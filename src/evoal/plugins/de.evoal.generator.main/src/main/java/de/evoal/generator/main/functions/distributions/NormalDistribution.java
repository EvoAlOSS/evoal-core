package de.evoal.generator.main.functions.distributions;

import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.base.Instance;
import lombok.Data;
import org.apache.commons.math3.distribution.RealDistribution;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Data
@Named("de.evoal.generator.generator.normal-distribution-noise")
@Dependent
public class NormalDistribution implements Distribution {
    private RealDistribution distribution;

    @Inject
    private LanguageHelper helper;

    @Override
    public NormalDistribution init(final Instance configuration) {
        double μ = helper.lookup(configuration, "μ");
        double σ = helper.lookup(configuration, "σ");

        distribution = new org.apache.commons.math3.distribution.NormalDistribution(μ, σ);

        return this;
    }

    @Override
    public double sample() {
        return distribution.sample();
    }
}
