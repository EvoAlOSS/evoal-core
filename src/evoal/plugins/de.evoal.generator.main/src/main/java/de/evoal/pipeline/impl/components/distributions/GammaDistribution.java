package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

/**
 * Gamma distribution with shape {@code k} and scale {@code θ}: density
 *   x^(k−1)·exp(−x/θ) / (Γ(k)·θ^k) for x &gt; 0, mean kθ. The quantile has no closed form;
 *   Commons Math computes it numerically from the regularised incomplete gamma function.
 */
@Named(GammaDistribution.NAME)
@Dependent
public class GammaDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.gamma-distribution";

    /**
     * Commons Math's gamma distribution, used only for its quantile; it has no random
     *   generator, so it must not sample.
     */
    private org.apache.commons.math3.distribution.GammaDistribution distribution;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public GammaDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if k or θ is not positive.
     */
    GammaDistribution(final double k, final double θ, final RandomGenerator randomness) {
        super(randomness);
        configure(k, θ);
    }

    @Override
    protected void configure(final EObject configuration) {
        configure(lookup(configuration, "k"), lookup(configuration, "θ"));
    }

    private void configure(final double k, final double θ) {
        distribution = new org.apache.commons.math3.distribution.GammaDistribution(
                (org.apache.commons.math3.random.RandomGenerator) null, k, θ);
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
