package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.random.RandomService;
import de.evoal.pipeline.api.distribution.Distribution;

/**
 * Multivariate normal distribution with the given {@code means} and {@code covariance}
 *   matrix. The random numbers come from the {@link RandomService} (see {@link RandomStreams}).
 */
@Named(MultivariateNormalDistribution.NAME)
@Dependent
public class MultivariateNormalDistribution implements Distribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.multivariate-normal-distribution";

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The random stream of this distribution.
     */
    private RandomGenerator randomness;

    @Inject
    private RandomStreams randomStreams;

    /**
     * Turns the random numbers into samples of this distribution.
     */
    private CorrelatedGaussianSampler sampler;

    /**
     * @throws IllegalArgumentException if the covariance matrix does not fit the means, or is not
     *   symmetric and positive semi-definite.
     */
    @Override
    public Distribution init(final EObject configuration) {
        final double [] means = evaluator.attributeToDoubleArray(configuration, "means");
        final double [][] covariance = evaluator.attributeToDoubleArrayArray(configuration, "covariance");

        sampler = new CorrelatedGaussianSampler(means, covariance);
        randomness = randomStreams.forNewInstance(NAME);

        return this;
    }

    @Override
    public double [] sample() {
        return sampler.sample(randomness);
    }
}
