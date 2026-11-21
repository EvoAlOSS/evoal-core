package de.evoal.optimisation.cma_es.main.termination;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

/**
 * The limit a + b (n + 3)^2 / sqrt(lambda) (DL type {@code 'quadratic-iteration-limit'}), the
 *   form of the archived BBOB entries BIPOP-CMA-ES 2009 and IPOP-CMA-ES 2010 (a = 100,
 *   b = 50) and of pycma's default (a = 100, b = 150).
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.quadratic-iteration-limit")
public class QuadraticIterationLimit implements IterationLimit {
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
    public QuadraticIterationLimit() {
    }

    /**
     * Creates a configured limit, e.g., for tests.
     */
    QuadraticIterationLimit(final double a, final double b) {
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
        return a + b * EvoalMath.square(dimension + 3.0) / Math.sqrt(populationSize);
    }
}
