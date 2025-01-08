package de.evoal.pipeline.impl.components.distributions;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.Instance;
import de.evoal.pipeline.api.distribution.Distribution;
import org.apache.commons.math3.distribution.RealDistribution;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named("de.evoal.pipeline.distributions.uniform-distribution")
@Dependent
public class UniformDistribution implements Distribution {
    private RealDistribution distribution;

    @Inject
    private AttributeHelper helper;

    @Override
    public UniformDistribution init(final Instance configuration) {
        double lower = helper.lookup(configuration, "lower");
        double upper = helper.lookup(configuration, "upper");

        distribution = new org.apache.commons.math3.distribution.UniformRealDistribution(lower, upper);

        return this;
    }

    @Override
    public double [] sample() {
        return new double[] {distribution.sample()};
    }
}
