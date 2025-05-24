package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Instance;

import javax.inject.Inject;

/**
 * An optimisation function decorator. The decorator calls the decorated function
 *   and can then adapt or extend the result.
 */
public abstract class OptimisationFunctionDecorator implements OptimisationFunction {
    /**
     * The decorated function
     */
    protected OptimisationFunction decoratedFunction;

    @Inject
    protected AttributeHelper helper;

    @Override
    public OptimisationFunction init(final Instance config) {
        final Instance decoratedConfig = helper.lookup(config, "function");

        decoratedFunction = BeanFactory.createComponent(OptimisationFunction.class, decoratedConfig);

        return this;
    }
}
