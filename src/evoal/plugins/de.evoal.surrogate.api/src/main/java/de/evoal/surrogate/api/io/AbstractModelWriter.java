package de.evoal.surrogate.api.io;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base of the model writers: collects the model information that every model file stores
 *   (feature information, prediction pipeline and the DL types of the training) and turns it
 *   into a {@link SurrogateConfiguration}. The subclasses write it in their format.
 */
public abstract class AbstractModelWriter implements ModelWriter {
    private final Map<String, List<Parameter>> inputInformation = new HashMap<>();

    private final Map<String, List<Parameter>> outputInformation = new HashMap<>();

    private PipelineDefinition pipeline;

    /**
     * The DL types of the training configuration.
     */
    private final List<String> definitions = new ArrayList<>();

    @Override
    public void addInputFeatureInformation(final EStructuralFeature feature, final Parameter value) {
        // a name identifies the information: a second value replaces the first
        final List<Parameter> information = this.inputInformation.computeIfAbsent(feature.getName(), k -> new ArrayList<>());
        information.removeIf(p -> p.getName().equals(value.getName()));
        information.add(value);
    }

    @Override
    public void addOutputFeatureInformation(final EStructuralFeature feature, final Parameter value) {
        // a name identifies the information: a second value replaces the first
        final List<Parameter> information = this.outputInformation.computeIfAbsent(feature.getName(), k -> new ArrayList<>());
        information.removeIf(p -> p.getName().equals(value.getName()));
        information.add(value);
    }

    @Override
    public ModelWriter addPredictionPipeline(@NonNull PipelineDefinition pipeline) {
        this.pipeline = pipeline;

        return this;
    }

    /**
     * The writer implements the raw {@link ModelWriter}, so the list is raw as well; its elements
     *   are the fully qualified names of the DL types.
     */
    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ModelWriter addTrainingDefinitions(final @NonNull List definitions) {
        this.definitions.clear();
        this.definitions.addAll(definitions);

        return this;
    }

    /**
     * @return The configuration of the function with the collected information, without the
     *   state of the model.
     */
    protected SurrogateConfiguration configurationOf(final @NonNull ModelFunction function) {
        final SurrogateConfiguration configuration = new SurrogateConfiguration();
        final Space inputSpace = function.getInput();
        final Space outputSpace = function.getOutput();

        configuration.setName(function.getModelName());
        configuration.setDefinitions(new ArrayList<>(definitions));
        configuration.setPredictionPipeline(pipeline);
        configuration.setInputData(inputSpace);
        configuration.setOutputData(outputSpace);
        configuration.getInputParameters()
                .putAll(inputInformation);
        configuration.getOutputParameters()
                .putAll(outputInformation);

        return configuration;
    }
}
