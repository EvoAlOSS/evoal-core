package de.evoal.generator.main.functions.distributions;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Instance;
import lombok.Data;
import org.apache.commons.math3.distribution.RealDistribution;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Data
@Named("de.evoal.generator.generator.uniform-distribution-noise")
@Dependent
public class UniformDistribution implements Distribution {
    private double l;
    private double u;

    private RealDistribution distribution;

    @Inject
    private LanguageHelper helper;

    @Override
    public UniformDistribution init(final Instance configuration) {
        double lower = helper.lookup(configuration, "lower");
        double upper = helper.lookup(configuration, "upper");

        distribution = new org.apache.commons.math3.distribution.UniformRealDistribution(lower, upper);

        return this;
    }

    @Override
    public double sample() {
        return distribution.sample();
    }
}
