package de.evoal.optimisation.api.model;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.EvaluationSourceProvider;

/**
 * An optimisation function decorator. The decorator calls the decorated function
 *   and can then adapt or extend the result. Its values come from the same source as
 *   the values of the decorated function.
 */
public abstract class OptimisationFunctionDecorator extends OptimisationFunctionImpl
                                                    implements EvaluationSourceProvider {
    /**
     * The decorated function
     */
    protected OptimisationFunction decoratedFunction;

    @Inject
    protected AttributeHelper helper;

    /**
     * @return The decorated function.
     */
    public OptimisationFunction getDecoratedFunction() {
        return decoratedFunction;
    }

    @Override
    public EvaluationSource getEvaluationSource() {
        return EvaluationSource.of(decoratedFunction);
    }

    @Override
    public OptimisationFunction init(final EObject config) {
        final Configuration decoratedConfig = helper.lookup(config, "function");

        decoratedFunction = BeanFactory.createComponent(OptimisationFunction.class, decoratedConfig);

        return this;
    }
}
