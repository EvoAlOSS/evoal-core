package de.evoal.generator.main.generators;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.AbstractGeneratorFunction;
import lombok.AccessLevel;
import lombok.Setter;
import org.apache.commons.math3.distribution.MultivariateRealDistribution;

import java.util.List;

public abstract class MultivariateRealDistributionBase extends AbstractGeneratorFunction {
    @Setter(AccessLevel.PROTECTED)
    private MultivariateRealDistribution distribution;

    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);
        final List<PropertySpecification> specifications = writeSpecification.getProperties();
        final int dimension = specifications.size();

        final double [] values = distribution.sample();

        for(int i = 0; i < dimension; ++i) {
            result.put(specifications.get(i), values[i]);
        }

        return result;
    }
}
