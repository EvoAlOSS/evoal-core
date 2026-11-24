package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

/**
 * Binomial distribution: the number of successes in {@code n} independent trials with the
 *   success probability {@code p}. The quantile comes from Commons Math, which searches the
 *   smallest k with F(k) ≥ p.
 */
@Named(BinomialDistribution.NAME)
@Dependent
public class BinomialDistribution extends DiscreteDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.binomial-distribution";

    /**
     * Commons Math's binomial distribution, used only for its quantile; it has no random
     *   generator, so it must not sample.
     */
    private org.apache.commons.math3.distribution.BinomialDistribution distribution;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public BinomialDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if n is negative or p is not in [0, 1].
     */
    BinomialDistribution(final int n, final double p, final RandomGenerator randomness) {
        super(randomness);
        configure(n, p);
    }

    @Override
    protected void configure(final EObject configuration) {
        configure(lookup(configuration, "n"), lookup(configuration, "p"));
    }

    private void configure(final int n, final double p) {
        distribution = new org.apache.commons.math3.distribution.BinomialDistribution(
                (org.apache.commons.math3.random.RandomGenerator) null, n, p);
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        return distribution.inverseCumulativeProbability(p);
    }
}
