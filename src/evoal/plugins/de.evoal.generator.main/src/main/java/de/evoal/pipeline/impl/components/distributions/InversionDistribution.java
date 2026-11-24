package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

/**
 * Base class of the univariate distributions that sample by inversion: a sample is the
 *   quantile F⁻¹(u) of a uniform number u in [0, 1). The uniform numbers come from the
 *   distribution's own stream of the {@link RandomService} (see {@link RandomStreams}), so the
 *   same seed gives the same samples, and a copula or a low-discrepancy sequence that maps
 *   its points by {@link #quantile(double)} gives the same distribution.
 */
abstract class InversionDistribution implements UnivariateDistribution {
    @Inject
    private AttributeHelper helper;

    /**
     * The random stream of this distribution.
     */
    private RandomGenerator randomness;

    @Inject
    private RandomStreams randomStreams;

    /**
     * Creates a distribution that is configured by {@link #init(EObject)}.
     */
    protected InversionDistribution() {
    }

    /**
     * Creates a distribution with the given random stream, e.g., for tests.
     */
    protected InversionDistribution(final RandomGenerator randomness) {
        this.randomness = randomness;
    }

    /**
     * Reads the parameters of the distribution and assigns its random stream.
     */
    @Override
    public InversionDistribution init(final EObject configuration) {
        configure(configuration);
        randomness = randomStreams.forNewInstance(name());

        return this;
    }

    /**
     * Reads the parameters of the distribution from its configuration.
     */
    protected abstract void configure(EObject configuration);

    /**
     * @return The value of a parameter of the configuration.
     */
    protected <T> T lookup(final EObject configuration, final String parameter) {
        return helper.lookup(configuration, parameter);
    }

    /**
     * @return The CDI name of the distribution, which names its random stream.
     */
    protected abstract String name();

    @Override
    public double [] sample() {
        return new double[] {quantile(randomness.nextDouble())};
    }
}
