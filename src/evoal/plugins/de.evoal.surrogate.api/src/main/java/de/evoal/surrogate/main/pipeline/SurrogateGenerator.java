package de.evoal.surrogate.main.pipeline;

import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.File;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.surrogate.api.cdi.SurrogateProducer;

@Dependent
@Named("de.evoal.surrogate.pipeline.trained-model")
@Slf4j
public class SurrogateGenerator extends PipelineComponentImpl {

    @Inject
    private AttributeHelper attribute;

    private ModelFunctionData function;

    @Inject
    private SurrogateProducer producer;

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        function.function()
                .apply(object, object);

        return object;
    }

    @Override
    public SurrogateGenerator init(final Instance configuration) throws InitializationException {
        final String surrogateConfiguration = attribute.lookup(configuration, "model-file");
        log.info("Loading configuration from {}", surrogateConfiguration);

        function = producer.load(new File(surrogateConfiguration), getReads(), getWrites());

        return this;
    }
}
