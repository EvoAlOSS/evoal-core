package de.evoal.surrogate.api.io.pson;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPSONWriter implements ModelWriter {
    private PSONModelStorage storage;

    private final Map<String, List<Parameter>> inputInformation = new HashMap<>();

    private final Map<String, List<Parameter>> outputInformation = new HashMap<>();

    private PipelineDefinition pipeline;

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

    @Override
    public void store(final ModelFunction function) {
        final SurrogateConfiguration configuration = new SurrogateConfiguration();
        final Space inputSpace = function.getInput();
        final Space outputSpace = function.getOutput();

        configuration.setName(function.getModelName());
        configuration.setPredictionPipeline(pipeline);
        configuration.setInputData(inputSpace);
        configuration.setOutputData(outputSpace);
        configuration.getInputParameters()
                .putAll(inputInformation);
        configuration.getOutputParameters()
                .putAll(outputInformation);

        toConfiguration(function, configuration);

        storage.store(configuration);
    }

    protected abstract void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration);

    @Override
    public void setStorage(final @NonNull ModelStorage storage) {
        this.storage = (PSONModelStorage) storage;
    }
}
