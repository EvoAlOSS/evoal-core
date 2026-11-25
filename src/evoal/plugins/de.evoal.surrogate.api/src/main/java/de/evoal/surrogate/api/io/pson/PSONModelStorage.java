package de.evoal.surrogate.api.io.pson;

import de.evoal.core.api.provenance.RunRecord;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent
@Named("pson")
@Slf4j
public class PSONModelStorage implements ModelStorage {
    @Getter
    private Optional<SurrogateConfiguration> configuration = Optional.empty();

    private File file;

    @Getter
    private Space inputSpace;

    @Inject
    private DefinitionModuleLoader loader;

    @Inject
    private SurrogateModelTransformer transformer;

    @Getter
    private Space outputSpace;

    /**
     * The space of the rows of the stored prediction pipeline, set when the file is loaded.
     */
    private Space functionSpace;

    @SneakyThrows
    public void store(final SurrogateConfiguration configuration) {
        log.info("Storing predictive configuration from {}.", file);
        RunRecord.current().output(file.toPath());

        SurrogateConfigurations.writer()
                               .writeValue(file, configuration);
    }

    @Override
    public String getStorageExtension() {
        return "pson";
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

    @SneakyThrows
    public void load() {
        if(configuration.isPresent()) {
            return;
        }

        log.info("Loading predictive configuration from {}.", file);
        RunRecord.current().input(file.toPath());

        try(final InputStream is = new FileInputStream(file)) {
            functionSpace = inputSpace.merge(outputSpace);
            final SurrogateConfiguration configuration =
                    SurrogateConfigurations.reader(loader, transformer, inputSpace, outputSpace, functionSpace)
                                           .readValue(is, SurrogateConfiguration.class);

            this.configuration = Optional.of(configuration);
        } catch (final IOException e) {
            log.error("Failed to load predictive configuration from {}.", file, e);

            throw new IllegalStateException("Failed to load predictive configuration from " + file);
        }
    }

    @Override
    public String getModelName() {
        load();
        return configuration.get().getName();
    }

    /**
     * @throws IllegalStateException if the model file has no prediction pipeline.
     */
    @Override
    public Optional<PipelineDefinition> getPredictionPipeline() {
        load();
        final PipelineDefinition pipeline = configuration.get().getPredictionPipeline();
        if(pipeline == null) {
            throw new IllegalStateException("The model file '" + file + "' has no prediction pipeline; train the model again.");
        }

        return Optional.of(pipeline);
    }

    @Override
    public Space getPipelineSpace() {
        load();
        return functionSpace;
    }
}
