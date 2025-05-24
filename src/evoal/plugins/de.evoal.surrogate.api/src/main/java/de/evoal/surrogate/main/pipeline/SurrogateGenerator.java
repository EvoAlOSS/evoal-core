package de.evoal.surrogate.main.pipeline;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.surrogate.api.cdi.SurrogateProducer;
import de.evoal.surrogate.api.function.SurrogateFunction;

@Dependent
@Named("de.evoal.surrogate.pipeline.surrogate")
@Slf4j
public class SurrogateGenerator extends ComponentImpl {

    @Inject
    private AttributeHelper attribute;

    private SurrogateFunction function;

    @Inject
    private SurrogateProducer producer;

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        function.apply(object, object);

        return object;
    }

    @Override
    public SurrogateGenerator init(final Instance configuration) throws InitializationException {
        final String surrogateConfiguration = attribute.lookup(configuration, "pson-file");
        log.info("Loading configuration from {}", surrogateConfiguration);

        function = producer.load(new File(surrogateConfiguration), getReads().merge(getWrites()));

        return this;
    }
}
