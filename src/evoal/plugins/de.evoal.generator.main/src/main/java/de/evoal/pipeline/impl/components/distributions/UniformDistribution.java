package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

/**
 * Continuous uniform distribution on {@code [lower, upper)}. The random numbers come from
 *   the {@link RandomService} (see {@link RandomStreams}).
 */
@Named(UniformDistribution.NAME)
@Dependent
public class UniformDistribution implements UnivariateDistribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.uniform-distribution";

    @Inject
    private AttributeHelper helper;

    /**
     * The lower bound (inclusive).
     */
    private double lower;

    /**
     * The random stream of this distribution.
     */
    private RandomGenerator randomness;

    @Inject
    private RandomStreams randomStreams;

    /**
     * The upper bound (exclusive).
     */
    private double upper;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    public UniformDistribution() {
    }

    /**
     * Creates a configured distribution, e.g., for tests.
     *
     * @throws IllegalArgumentException if the lower bound is not less than the upper bound.
     */
    UniformDistribution(final double lower, final double upper, final RandomGenerator randomness) {
        configure(lower, upper);
        this.randomness = randomness;
    }

    @Override
    public UniformDistribution init(final EObject configuration) {
        configure(helper.lookup(configuration, "lower"), helper.lookup(configuration, "upper"));
        randomness = randomStreams.forNewInstance(NAME);

        return this;
    }

    private void configure(final double lower, final double upper) {
        Requirements.requireTrue(lower < upper,
                "The lower bound of the uniform distribution (" + lower + ") has to be less than its upper bound ("
                + upper + ").");

        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public double [] sample() {
        return new double[] {randomness.nextDouble(lower, upper)};
    }

    @Override
    public double quantile(final double p) {
        return lower + p * (upper - lower);
    }
}
