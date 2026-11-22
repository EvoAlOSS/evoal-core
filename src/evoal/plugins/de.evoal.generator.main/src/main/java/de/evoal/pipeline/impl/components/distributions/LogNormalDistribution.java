package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

/**
 * Log-normal distribution: ln X is normally distributed with mean {@code μ} and standard
 *   deviation {@code σ}. A sample is exp(μ + σ·z) for a standard normal z, the quantile
 *   exp(μ + σ·Φ⁻¹(p)). The random numbers come from the {@link RandomService} (see
 *   {@link RandomStreams}).
 */
@Named(LogNormalDistribution.NAME)
@Dependent
public class LogNormalDistribution implements UnivariateDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.log-normal-distribution";

    @Inject
    private AttributeHelper helper;

    /**
     * The mean of ln X.
     */
    private double μ;

    /**
     * The random stream of this distribution.
     */
    private RandomGenerator randomness;

    @Inject
    private RandomStreams randomStreams;

    /**
     * The standard deviation of ln X.
     */
    private double σ;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public LogNormalDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if σ is not positive.
     */
    LogNormalDistribution(final double μ, final double σ, final RandomGenerator randomness) {
        configure(μ, σ);
        this.randomness = randomness;
    }

    @Override
    public LogNormalDistribution init(final EObject configuration) {
        configure(helper.lookup(configuration, "μ"), helper.lookup(configuration, "σ"));
        randomness = randomStreams.forNewInstance(NAME);

        return this;
    }

    private void configure(final double μ, final double σ) {
        Requirements.requireTrue(σ > 0,
                "The standard deviation σ of the log-normal distribution has to be positive, but is " + σ + ".");

        this.μ = μ;
        this.σ = σ;
    }

    @Override
    public double [] sample() {
        return new double[] {EvoalMath.exp(μ + σ * randomness.nextGaussian())};
    }

    @Override
    public double quantile(final double p) {
        return EvoalMath.exp(μ + σ * StandardNormal.quantile(p));
    }
}
