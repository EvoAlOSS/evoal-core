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
 * Normal distribution with mean {@code μ} and standard deviation {@code σ}. The random
 *   numbers come from the {@link RandomService} (see {@link RandomStreams}).
 */
@Named(NormalDistribution.NAME)
@Dependent
public class NormalDistribution implements Distribution {
    /**
     * The CDI name of the distribution.
     */
    static final String NAME = "de.evoal.pipeline.distributions.normal-distribution";

    @Inject
    private AttributeHelper helper;

    /**
     * The mean.
     */
    private double μ;

    /**
     * The random stream of this distribution.
     */
    private RandomGenerator randomness;

    @Inject
    private RandomStreams randomStreams;

    /**
     * The standard deviation.
     */
    private double σ;

    @Override
    public NormalDistribution init(final EObject configuration) {
        μ = helper.lookup(configuration, "μ");
        σ = helper.lookup(configuration, "σ");
        Requirements.requireTrue(σ > 0,
                "The standard deviation σ of the normal distribution has to be positive, but is " + σ + ".");

        randomness = randomStreams.forNewInstance(NAME);

        return this;
    }

    @Override
    public double [] sample() {
        final double standardNormal = randomness.nextGaussian();

        return new double[] {μ + σ * standardNormal};
    }
}
