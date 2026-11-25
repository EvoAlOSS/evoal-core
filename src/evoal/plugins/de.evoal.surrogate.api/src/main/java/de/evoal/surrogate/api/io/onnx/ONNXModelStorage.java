package de.evoal.surrogate.api.io.onnx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;
import tools.jackson.core.JacksonException;

import de.evoal.core.api.provenance.RunRecord;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.SurrogateConfigurations;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.protobuf.ModelProto;
import de.evoal.surrogate.protobuf.StringStringEntryProto;

/**
 * A model file in the ONNX format. A file that EvoAl writes stores the model information (the
 *   content of a PSON file; the graph is the state of the model, the state of the model
 *   information holds only small values outside the graph) as JSON in the metadata of the model,
 *   under the key {@value #CONFIGURATION_KEY}; other ONNX tools ignore it. A file without the key
 *   is a foreign model: model {@value #FOREIGN_MODEL}, without a prediction pipeline and without
 *   feature information.
 * <p>
 * Every session runs on one thread, so a model predicts the same values on every machine: with
 *   several threads, ONNX Runtime sums in parallel and the last digits depend on the machine.
 */
@Dependent
@Named("onnx")
@Slf4j
public class ONNXModelStorage implements ModelStorage {
    /**
     * The metadata key of the model information.
     */
    public static final String CONFIGURATION_KEY = "de.evoal.surrogate.configuration";

    /**
     * The model name of an ONNX file without model information.
     */
    public static final String FOREIGN_MODEL = "de.evoal.surrogate.api.ml.general-onnx";

    /**
     * The model information, empty for a foreign model or before the file is loaded.
     */
    @Getter
    private Optional<SurrogateConfiguration> configuration = Optional.empty();

    /**
     * The session that runs the model, set when the file is loaded.
     */
    private OrtSession session;

    private File file;

    @Inject
    private DefinitionModuleLoader loader;

    @Inject
    private SurrogateModelTransformer transformer;

    @Getter
    private Space inputSpace;

    @Getter
    private Space outputSpace;

    /**
     * The space of the rows of the stored prediction pipeline, set when the model information is
     *   read.
     */
    private Space functionSpace;

    /**
     * Creates the storage; the loader and the transformer are injected.
     */
    public ONNXModelStorage() {
    }

    /**
     * Creates the storage with the given loader and transformer, e.g., for tests.
     */
    public ONNXModelStorage(final DefinitionModuleLoader loader, final SurrogateModelTransformer transformer) {
        this.loader = loader;
        this.transformer = transformer;
    }

    /**
     * Writes the model with its model information.
     *
     * @param configuration The model information.
     * @param onnx The ONNX model.
     */
    public void store(final SurrogateConfiguration configuration, final OnnxConfiguration onnx) {
        log.info("Storing the ONNX model to {}.", file);
        RunRecord.current().output(file.toPath());

        final ModelProto.Builder model = onnx.getModel()
                                             .setGraph(onnx.getGraph())
                                             .setProducerName("EvoAl")
                                             .addMetadataProps(StringStringEntryProto.newBuilder()
                                                                                     .setKey(CONFIGURATION_KEY)
                                                                                     .setValue(SurrogateConfigurations.writer().writeValueAsString(configuration)));
        producerVersion().ifPresent(model::setProducerVersion);

        try(final OutputStream os = new FileOutputStream(file)) {
            model.build().writeTo(os);
        } catch(final IOException e) {
            throw new IllegalStateException("Failed to write the ONNX model file '" + file + "'.", e);
        }
    }

    /**
     * @return EvoAl's version, if the module has one (not in unit tests).
     */
    private static Optional<String> producerVersion() {
        final Module module = ONNXModelStorage.class.getModule();

        return module.getDescriptor() == null ? Optional.empty() : module.getDescriptor().rawVersion();
    }

    /**
     * Opens the session and reads the model information, once.
     *
     * @throws IllegalStateException if the file cannot be loaded, its model information cannot be
     *   read, or its graph does not fit the features.
     */
    public void load() {
        if(session != null) {
            return;
        }

        log.info("Loading the ONNX model from {}.", file);
        RunRecord.current().input(file.toPath());

        OrtSession created = null;
        try(final OrtSession.SessionOptions options = sessionOptions()) {
            created = OrtEnvironment.getEnvironment().createSession(file.getPath(), options);

            final String json = created.getMetadata().getCustomMetadata().get(CONFIGURATION_KEY);
            if(json != null) {
                functionSpace = inputSpace.merge(outputSpace);
                configuration = Optional.of(SurrogateConfigurations.reader(loader, transformer, inputSpace, outputSpace, functionSpace)
                                                                   .readValue(json, SurrogateConfiguration.class));
            }

            checkGraph(created.getInputInfo().keySet(), created.getOutputInfo().keySet());

            // only a completely loaded file counts as loaded
            session = created;
        } catch(final OrtException e) {
            close(created);
            throw new IllegalStateException("Failed to load the ONNX model file '" + file + "'.", e);
        } catch(final JacksonException e) {
            close(created);
            throw new IllegalStateException("Failed to read the model information of the ONNX model file '" + file + "'.", e);
        } catch(final IllegalStateException e) {
            close(created);
            throw e;
        }
    }

    /**
     * Closes a session that was not loaded completely.
     */
    private static void close(final OrtSession session) {
        if(session == null) {
            return;
        }

        try {
            session.close();
        } catch(final OrtException e) {
            log.warn("Failed to close an ONNX session.", e);
        }
    }

    /**
     * @return The options of every session: one thread, operators one after the other.
     */
    static OrtSession.SessionOptions sessionOptions() throws OrtException {
        final OrtSession.SessionOptions options = new OrtSession.SessionOptions();
        options.setIntraOpNumThreads(1);
        options.setInterOpNumThreads(1);
        options.setExecutionMode(OrtSession.SessionOptions.ExecutionMode.SEQUENTIAL);

        return options;
    }

    /**
     * Checks that the graph has exactly one input per input feature and an output per output
     *   feature, each named after the feature.
     */
    private void checkGraph(final Set<String> inputs, final Set<String> outputs) {
        final List<String> missingInputs = missing(inputSpace, inputs);
        final List<String> unknownInputs = inputs.stream()
                                                 .filter(input -> inputSpace.stream().noneMatch(f -> f.getName().equals(input)))
                                                 .sorted()
                                                 .toList();
        final List<String> missingOutputs = missing(outputSpace, outputs);

        if(!missingInputs.isEmpty() || !unknownInputs.isEmpty() || !missingOutputs.isEmpty()) {
            throw new IllegalStateException("The graph of the ONNX model file '" + file + "' does not fit the features: "
                    + "missing inputs " + missingInputs + ", inputs that are no input feature " + unknownInputs
                    + ", missing outputs " + missingOutputs + ". The graph needs an input per input feature and an output per output feature, named after the feature.");
        }
    }

    private static List<String> missing(final Space space, final Set<String> names) {
        return space.stream()
                    .map(EStructuralFeature::getName)
                    .filter(name -> !names.contains(name))
                    .toList();
    }

    /**
     * @return The session that runs the model, empty before the file is loaded.
     */
    public Optional<OrtSession> getSession() {
        return Optional.ofNullable(session);
    }

    @Override
    public String getModelName() {
        load();

        return configuration.map(SurrogateConfiguration::getName)
                            .orElse(FOREIGN_MODEL);
    }

    /**
     * @return The prediction pipeline of the model information, empty for a foreign model.
     * @throws IllegalStateException if the model information has no prediction pipeline.
     */
    @Override
    public Optional<PipelineDefinition> getPredictionPipeline() {
        load();

        if(configuration.isEmpty()) {
            return Optional.empty();
        }

        final PipelineDefinition pipeline = configuration.get().getPredictionPipeline();
        if(pipeline == null) {
            throw new IllegalStateException("The model file '" + file + "' has no prediction pipeline; train the model again.");
        }

        return Optional.of(pipeline);
    }

    @Override
    public Space getPipelineSpace() {
        load();

        return functionSpace != null ? functionSpace : ModelStorage.super.getPipelineSpace();
    }

    /**
     * @return The information of the output features, by feature name; empty for a foreign
     *   model.
     */
    public Map<String, List<Parameter>> getOutputParameters() {
        load();

        return configuration.map(SurrogateConfiguration::getOutputParameters).orElse(Map.of());
    }

    /**
     * @return The information of the input features, by feature name; empty for a foreign
     *   model.
     */
    public Map<String, List<Parameter>> getInputParameters() {
        load();

        return configuration.map(SurrogateConfiguration::getInputParameters).orElse(Map.of());
    }

    @Override
    public String getStorageExtension() {
        return "onnx";
    }

    @Override
    public ModelStorage setLocation(final URI location) {
        this.file = new File(location.getPath());

        return this;
    }

    @Override
    public ModelStorage setSpaces(final Space inputSpace, final Space outputSpace) {
        this.inputSpace = inputSpace;
        this.outputSpace = outputSpace;

        return this;
    }
}
