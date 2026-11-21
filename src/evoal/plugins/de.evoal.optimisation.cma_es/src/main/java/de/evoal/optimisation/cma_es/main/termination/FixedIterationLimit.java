package de.evoal.optimisation.cma_es.main.termination;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

/**
 * The same number of iterations for every run (DL type {@code 'fixed-iteration-limit'}).
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.fixed-iteration-limit")
public class FixedIterationLimit implements IterationLimit {
    @Inject
    private AttributeHelper helper;

    /**
     * The number of iterations.
     */
    private int iterations;

    /**
     * Creates a limit that is configured by {@link #init(EObject)}.
     */
    public FixedIterationLimit() {
    }

    /**
     * Creates a configured limit, e.g., for tests.
     */
    FixedIterationLimit(final int iterations) {
        this.iterations = iterations;
    }

    @Override
    public IterationLimit init(final EObject configuration) throws InitializationException {
        iterations = helper.<Integer>lookup(configuration, "iterations");

        return this;
    }

    @Override
    public double of(final int dimension, final int populationSize) {
        return iterations;
    }
}
