package de.evoal.generator.main.generators;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.AbstractGeneratorFunction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.distribution.RealDistribution;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class RealDistributionBase extends AbstractGeneratorFunction {
    @Getter(AccessLevel.PROTECTED)
    private final List<RealDistribution> distributions = new ArrayList<>();

    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);
        final List<PropertySpecification> specifications = writeSpecification.getProperties();
        final int dimension = specifications.size();

        for(int i = 0; i < dimension; ++i) {
            result.put(specifications.get(i), distributions.get(i).sample());
        }

        return result;
    }
}
