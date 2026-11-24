package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

/**
 * Poisson distribution with mean {@code λ}: the number of events in an interval in which they
 *   occur independently at the rate λ. The quantile comes from Commons Math, which searches the
 *   smallest k with F(k) ≥ p; it is +∞ at p = 1, as the distribution has no upper bound.
 */
@Named(PoissonDistribution.NAME)
@Dependent
public class PoissonDistribution extends DiscreteDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.poisson-distribution";

    /**
     * Commons Math's Poisson distribution, used only for its quantile; it has no random
     *   generator, so it must not sample.
     */
    private org.apache.commons.math3.distribution.PoissonDistribution distribution;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public PoissonDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if λ is not positive.
     */
    PoissonDistribution(final double λ, final RandomGenerator randomness) {
        super(randomness);
        configure(λ);
    }

    @Override
    protected void configure(final EObject configuration) {
        configure(this.<Double>lookup(configuration, "λ"));
    }

    private void configure(final double λ) {
        distribution = new org.apache.commons.math3.distribution.PoissonDistribution(
                (org.apache.commons.math3.random.RandomGenerator) null, λ,
                org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_EPSILON,
                org.apache.commons.math3.distribution.PoissonDistribution.DEFAULT_MAX_ITERATIONS);
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        if(p >= 1.0) {
            return Double.POSITIVE_INFINITY;
        }

        return distribution.inverseCumulativeProbability(p);
    }
}
