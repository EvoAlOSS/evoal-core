package de.evoal.pipeline.impl.components.distributions;

import de.evoal.pipeline.api.distribution.Distribution;
import lombok.AccessLevel;
import lombok.Setter;
import org.apache.commons.math3.distribution.MultivariateRealDistribution;

import java.util.List;

public abstract class MultivariateRealDistributionBase implements Distribution {
    @Setter(AccessLevel.PROTECTED)
    private MultivariateRealDistribution distribution;

    @Override
    public double [] sample() {
        return distribution.sample();
    }
}
