package de.evoal.optimisation.api.model;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.models.v202704.core.Configuration;
import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;

/**
 * An optimisation function decorator. The decorator calls the decorated function
 *   and can then adapt or extend the result.
 */
public abstract class OptimisationFunctionDecorator extends OptimisationFunctionImpl {
    /**
     * The decorated function
     */
    protected OptimisationFunction decoratedFunction;

    /**
     * @return The decorated function.
     */
    public OptimisationFunction getDecoratedFunction() {
        return decoratedFunction;
    }

    @Inject
    protected AttributeHelper helper;

    @Override
    public OptimisationFunction init(final EObject config) {
        final Configuration decoratedConfig = helper.lookup(config, "function");

        decoratedFunction = BeanFactory.createComponent(OptimisationFunction.class, decoratedConfig);

        return this;
    }
}
