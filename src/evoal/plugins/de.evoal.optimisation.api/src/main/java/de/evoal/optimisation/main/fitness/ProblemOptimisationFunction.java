package de.evoal.optimisation.main.fitness;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.models.v202704.optimisation.model.Problem;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.languages.model.ol.ProblemInstance;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import org.eclipse.emf.ecore.EObject;


@Dependent
@Named("de.evoal.optimisation.core.problem-function")
@Slf4j
public class ProblemOptimisationFunction extends OptimisationFunctionImpl {
    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem")
    private EObject problemConfiguration;

    /**
     * The actual problem function to use
     */
    private OptimisationFunction delegate;

    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        return delegate.evaluate(candidate);
    }

    /**
     * {@inheritDoc}
     * <p>
     * The problem function only delegates, so it is thread-safe iff its delegate is.
     */
    @Override
    public boolean isThreadSafe() {
        return delegate.isThreadSafe();
    }

    @Override
    public OptimisationFunction init(final EObject config) {
        problemConfiguration = ((Problem)problemConfiguration).getOptimisationFunction();
        delegate = BeanFactory.createComponent(OptimisationFunction.class, problemConfiguration);

        return this;
    }
}
