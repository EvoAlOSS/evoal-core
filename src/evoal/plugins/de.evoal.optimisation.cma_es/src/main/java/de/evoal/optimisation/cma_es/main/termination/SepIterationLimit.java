package de.evoal.optimisation.cma_es.main.termination;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

/**
 * The limit a + b n sqrt(n / lambda) (DL type {@code 'sep-iteration-limit'}), the form of the
 *   archived BBOB entry IPOP-SEP-CMA-ES 2009 (a = 100, b = 300).
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.sep-iteration-limit")
public class SepIterationLimit implements IterationLimit {
    @Inject
    private AttributeHelper helper;

    /**
     * The constant a.
     */
    private double a;

    /**
     * The factor b.
     */
    private double b;

    /**
     * Creates a limit that is configured by {@link #init(EObject)}.
     */
    public SepIterationLimit() {
    }

    /**
     * Creates a configured limit, e.g., for tests.
     */
    SepIterationLimit(final double a, final double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public IterationLimit init(final EObject configuration) throws InitializationException {
        a = helper.<Double>lookup(configuration, "a");
        b = helper.<Double>lookup(configuration, "b");

        return this;
    }

    @Override
    public double of(final int dimension, final int populationSize) {
        return a + b * dimension * Math.sqrt((double) dimension / populationSize);
    }
}
