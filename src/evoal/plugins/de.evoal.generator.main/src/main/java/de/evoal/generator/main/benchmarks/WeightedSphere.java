package de.evoal.generator.main.benchmarks;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.AbstractGeneratorFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("de.evoal.generator.generator.weighted-sphere")
public class WeightedSphere extends AbstractGeneratorFunction {
    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);

        final double n = readSpecification.size();
        double value = 0.0;
        int counter = 1;

        for(final PropertySpecification ps : readSpecification.getProperties()) {
            double read_i = in.getAsDouble(ps);

            value += Math.pow(read_i, 2.0)  * counter++;
        }

        result.put(writeSpecification.getProperties().get(0), value);

        return result;
    }
}