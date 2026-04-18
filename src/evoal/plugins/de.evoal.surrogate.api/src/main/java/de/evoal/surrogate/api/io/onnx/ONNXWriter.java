package de.evoal.surrogate.api.io.onnx;

import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.api.io.ModelWriter;
import de.evoal.surrogate.api.io.pson.PSONModelStorage;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Care this class does nothing I hope it never gets called, but EVOAL searches for it
@Named("de.evoal.surrogate.api.ml.general-onnx-writer-onnx")
@Dependent
@Slf4j
public class ONNXWriter implements ModelWriter {
    private ONNXModelStorage storage;

    private final Map<String, List<Parameter>> inputInformation = new HashMap<>();

    private final Map<String, List<Parameter>> outputInformation = new HashMap<>();

    private PipelineDefinition pipeline;

    @Override
    public void setStorage(final @NonNull ModelStorage storage) {
        this.storage = (ONNXModelStorage) storage;
    }

    @Override
    public void store(final ModelFunction function) {
        log.info("!!!!!!!!!!ONNX Writer Store called !!!!!!!!!!");
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

        /*storage.store(configuration);*/
    }

    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration)
    {

    }

    @Override
    public void addInputFeatureInformation(final EStructuralFeature feature, final Parameter value) {
        this.inputInformation
                .computeIfAbsent(feature.getName(), k -> new ArrayList<>())
                .add(value);
    }

    @Override
    public void addOutputFeatureInformation(final EStructuralFeature feature, final Parameter value) {
        this.outputInformation
                .computeIfAbsent(feature.getName(), k -> new ArrayList<>())
                .add(value);
    }

    @Override
    public ModelWriter addPredictionPipeline(@NonNull PipelineDefinition pipeline) {
        this.pipeline = pipeline;

        return this;
    }
}
