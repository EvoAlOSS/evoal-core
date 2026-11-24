package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

/**
 * Bernoulli distribution: 1 with probability {@code p}, 0 otherwise. The quantile is 0 for
 *   probabilities up to 1 − p and 1 above.
 */
@Named(BernoulliDistribution.NAME)
@Dependent
public class BernoulliDistribution extends DiscreteDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.bernoulli-distribution";

    /**
     * The probability of a 1, in [0, 1].
     */
    private double success;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public BernoulliDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     */
    BernoulliDistribution(final double p, final RandomGenerator randomness) {
        super(randomness);
        success = p;
    }

    @Override
    protected void configure(final EObject configuration) {
        success = lookup(configuration, "p");
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        return p <= 1.0 - success ? 0.0 : 1.0;
    }
}
