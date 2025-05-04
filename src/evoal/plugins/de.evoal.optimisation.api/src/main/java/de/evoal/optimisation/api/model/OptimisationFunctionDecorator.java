package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;

import javax.inject.Inject;

public abstract class OptimisationFunctionDecorator implements OptimisationFunction {
    protected OptimisationFunction decoratedFunction;

    @Inject
    protected AttributeHelper helper;

    @Override
    public OptimisationFunction init(final Instance config) {
        final Instance decoratedConfig = helper.lookup(config, "function");

        decoratedFunction = BeanFactory.createComponent(OptimisationFunction.class, decoratedConfig);

        return this;
    }

    protected final boolean hasDecoratedFunction(final Instance config) {
        return config.findAttribute("function") != null;
    }
}
