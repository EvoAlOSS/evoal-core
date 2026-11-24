package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

/**
 * Beta distribution with shapes {@code α} and {@code β}, scaled from [0, 1] to
 *   [{@code lower}, {@code upper}]: X = lower + (upper − lower)·Y, where Y has the density
 *   y^(α−1)·(1 − y)^(β−1) / B(α, β). The quantile of Y has no closed form; Commons Math
 *   computes it numerically from the regularised incomplete beta function.
 */
@Named(BetaDistribution.NAME)
@Dependent
public class BetaDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.beta-distribution";

    /**
     * Commons Math's beta distribution on [0, 1], used only for its quantile; it has no
     *   random generator, so it must not sample.
     */
    private org.apache.commons.math3.distribution.BetaDistribution distribution;

    /**
     * The lower bound of the support.
     */
    private double lower;

    /**
     * The upper bound of the support.
     */
    private double upper;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public BetaDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if α or β is not positive.
     */
    BetaDistribution(final double α, final double β, final double lower, final double upper, final RandomGenerator randomness) {
        super(randomness);
        configure(α, β, lower, upper);
    }

    @Override
    protected void configure(final EObject configuration) {
        configure(lookup(configuration, "α"), lookup(configuration, "β"),
                  lookup(configuration, "lower"), lookup(configuration, "upper"));
    }

    private void configure(final double α, final double β, final double lower, final double upper) {
        distribution = new org.apache.commons.math3.distribution.BetaDistribution(
                (org.apache.commons.math3.random.RandomGenerator) null, α, β);
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        return lower + (upper - lower) * distribution.inverseCumulativeProbability(p);
    }
}
