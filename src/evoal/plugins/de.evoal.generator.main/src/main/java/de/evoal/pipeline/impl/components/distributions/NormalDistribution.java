package de.evoal.pipeline.impl.components.distributions;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.pipeline.api.distribution.Distribution;
import org.apache.commons.math3.distribution.RealDistribution;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

@Named("de.evoal.pipeline.distributions.normal-distribution")
@Dependent
public class NormalDistribution implements Distribution {
    private RealDistribution distribution;

    @Inject
    private AttributeHelper helper;

    @Override
    public NormalDistribution init(final EObject configuration) {
        double μ = helper.lookup(configuration, "μ");
        double σ = helper.lookup(configuration, "σ");

        distribution = new org.apache.commons.math3.distribution.NormalDistribution(μ, σ);

        return this;
    }

    @Override
    public double [] sample() {
        return new double[] {distribution.sample()};
    }
}
