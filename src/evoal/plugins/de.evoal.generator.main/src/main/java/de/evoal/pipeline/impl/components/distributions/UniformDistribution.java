package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.distribution.Distribution;

/**
 * Continuous uniform distribution on {@code [lower, upper)}. The random numbers come from
 *   the {@link RandomService} (see {@link RandomStreams}).
 */
@Named(UniformDistribution.NAME)
@Dependent
public class UniformDistribution implements Distribution {
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

    @Override
    public UniformDistribution init(final EObject configuration) {
        lower = helper.lookup(configuration, "lower");
        upper = helper.lookup(configuration, "upper");
        Requirements.requireTrue(lower < upper,
                "The lower bound of the uniform distribution (" + lower + ") has to be less than its upper bound ("
                + upper + ").");

        randomness = randomStreams.forNewInstance(NAME);

        return this;
    }

    @Override
    public double [] sample() {
        return new double[] {randomness.nextDouble(lower, upper)};
    }
}
