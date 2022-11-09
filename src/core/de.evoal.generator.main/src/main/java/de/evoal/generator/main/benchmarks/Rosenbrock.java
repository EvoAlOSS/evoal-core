package de.evoal.generator.main.benchmarks;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.AbstractGeneratorFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("rosenbrock")
public class Rosenbrock extends AbstractGeneratorFunction {
    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);

        final double n = readSpecification.size();
        double value = 0.0;

        for(int i = 0; i < readSpecification.getProperties().size() - 1; ++i) {
            final PropertySpecification ps_i = readSpecification.getProperties().get(i);
            final PropertySpecification ps_n = readSpecification.getProperties().get(i+1);

            double read_i = in.get(ps_i);
            double read_n = in.get(ps_n);

            value += 100 * Math.pow((Math.pow(read_i,  2.0) - read_n), 2.0) + Math.pow(1 - read_i, 2.0);
        }

        result.put(writeSpecification.getProperties().get(0), value);

        return result;
    }
}
