package de.evoal.surrogate.api.io.pson;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.main.jackson.ParameterDeserializer;
import de.evoal.surrogate.main.jackson.ParameterSerializer;
import de.evoal.surrogate.main.jackson.PipelineDeserializer;
import de.evoal.surrogate.main.jackson.PipelineSerializer;
import lombok.NonNull;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

/**
 * The JSON form of a {@link SurrogateConfiguration}: a PSON file, and the model information
 *   in the metadata of an ONNX model file.
 */
public final class SurrogateConfigurations {
    private SurrogateConfigurations() {
    }

    /**
     * @return A mapper that writes a configuration with its prediction pipeline and parameters.
     */
    public static JsonMapper writer() {
        final SimpleModule module = new SimpleModule();
        module.addSerializer(PipelineDefinition.class, new PipelineSerializer());
        module.addSerializer(Parameter.class, new ParameterSerializer());

        return JsonMapper.builder()
                         .addModule(module)
                         .build();
    }

    /**
     * Creates a mapper that reads a configuration. The prediction pipeline is read on the rows
     *   of the model, the parameters of the features on the input and output space.
     *
     * @param loader Loads the DL modules of the pipeline steps.
     * @param transformer Creates the runtime configurations of the pipeline steps.
     * @param inputSpace The input space of the model.
     * @param outputSpace The output space of the model.
     * @param functionSpace The space of the rows of the prediction pipeline (the merged input
     *   and output space); the storage returns this instance as its pipeline space.
     * @return The mapper.
     */
    public static JsonMapper reader(final @NonNull DefinitionModuleLoader loader, final @NonNull SurrogateModelTransformer transformer, final @NonNull Space inputSpace, final @NonNull Space outputSpace, final @NonNull Space functionSpace) {
        final PipelineDeserializer pipelineDeserializer = new PipelineDeserializer(loader, functionSpace, transformer.setSpace(functionSpace));
        final ParameterDeserializer parameterDeserializer = new ParameterDeserializer();
        parameterDeserializer.setSourceSpace(inputSpace);
        parameterDeserializer.setTargetSpace(outputSpace);

        final SimpleModule module = new SimpleModule();
        module.addDeserializer(Parameter.class, parameterDeserializer);
        module.addDeserializer(PipelineDefinition.class, pipelineDeserializer);

        return JsonMapper.builder()
                         .addModule(module)
                         .build();
    }
}
