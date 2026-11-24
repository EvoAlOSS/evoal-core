package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.Requirements;

/**
 * Normal distribution N(μ, σ²) truncated to [{@code lower}, {@code upper}]: μ and σ are the
 *   parameters of the normal distribution before the truncation, not the mean and standard
 *   deviation of the truncated one.
 * <p>
 * With the standardised bounds α = (lower − μ)/σ and β = (upper − μ)/σ, the quantile is
 *   μ + σ·Φ⁻¹(Φ(α) + p·(Φ(β) − Φ(α))). If both bounds lie above μ, the quantile is computed
 *   on the mirrored side, μ − σ·Φ⁻¹(Φ(−β) + (1 − p)·(Φ(−α) − Φ(−β))): Φ is close to 1 there,
 *   and the differences of values close to 1 would lose their precision.
 */
@Named(TruncatedNormalDistribution.NAME)
@Dependent
public class TruncatedNormalDistribution extends InversionDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.truncated-normal-distribution";

    /**
     * Φ(α), or Φ(−β) if the quantile is computed on the mirrored side.
     */
    private double fromProbability;

    /**
     * The lower bound.
     */
    private double lower;

    /**
     * Φ(β) − Φ(α), the probability of the interval.
     */
    private double mass;

    /**
     * If the quantile is computed on the mirrored side.
     */
    private boolean mirrored;

    /**
     * The mean of the normal distribution before the truncation.
     */
    private double μ;

    /**
     * The standard deviation of the normal distribution before the truncation.
     */
    private double σ;

    /**
     * The upper bound.
     */
    private double upper;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public TruncatedNormalDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if the interval has the probability 0 in double
     *   precision.
     */
    TruncatedNormalDistribution(final double μ, final double σ, final double lower, final double upper, final RandomGenerator randomness) {
        super(randomness);
        configure(μ, σ, lower, upper);
    }

    @Override
    protected void configure(final EObject configuration) {
        configure(lookup(configuration, "μ"), lookup(configuration, "σ"),
                  lookup(configuration, "lower"), lookup(configuration, "upper"));
    }

    private void configure(final double μ, final double σ, final double lower, final double upper) {
        this.μ = μ;
        this.σ = σ;
        this.lower = lower;
        this.upper = upper;

        final double α = (lower - μ) / σ;
        final double β = (upper - μ) / σ;
        mirrored = α > 0.0;

        fromProbability = StandardNormal.cdf(mirrored ? -β : α);
        mass = StandardNormal.cdf(mirrored ? -α : β) - fromProbability;

        Requirements.requireTrue(mass > 0.0,
                "The interval [" + lower + ", " + upper + "] of the truncated normal distribution lies so far in the tail of N("
                + μ + ", " + σ + "²) that its probability is 0 in double precision.");
    }

    @Override
    protected String name() {
        return NAME;
    }

    @Override
    public double quantile(final double p) {
        final double q = mirrored ? 1.0 - p : p;
        final double z = StandardNormal.quantile(fromProbability + q * mass);
        final double x = mirrored ? μ - σ * z : μ + σ * z;

        return Math.min(upper, Math.max(lower, x));
    }
}
