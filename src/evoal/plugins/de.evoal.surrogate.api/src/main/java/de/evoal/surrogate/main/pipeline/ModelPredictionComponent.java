package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.model-prediction")
public class ModelPredictionComponent extends PipelineComponentImpl {
    @Inject
    private AttributeHelper helper;

    private ModelFunctionData memento;

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        log.info("Applying model prediction to {}.", object);
        memento.function()
               .apply(object, object);

        return object;
    }


    @Override
    public PipelineComponent setContext(final @NonNull InterpreterState context) {
        super.setContext(context);

        log.info("Fetching model function from pipeline context.");

        memento = (ModelFunctionData) context.getByName("model-function");

        return this;
    }
}