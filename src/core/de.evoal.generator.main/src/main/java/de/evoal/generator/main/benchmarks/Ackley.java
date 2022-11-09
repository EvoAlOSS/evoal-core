package de.evoal.generator.main.benchmarks;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.generator.main.utils.ELHelper;
import de.evoal.languages.model.generator.Step;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("ackley")
@Slf4j
public class Ackley extends AbstractGeneratorFunction {
    private double a = 20;

    private double b = 0.2;

    private double c = 6.283185307179586;

    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);

        final double n = readSpecification.size();

        double sum1 = 0.0;
        double sum2 = 0.0;

        for(final PropertySpecification ps : readSpecification.getProperties()) {
            double read_i = in.get(ps);

        	sum1 += Math.pow(read_i, 2.0);
        	sum2 += Math.cos(c * read_i);
        }

        double value = -a * Math.exp(-b * Math.sqrt((1 / n) * sum1)) - Math.exp((1 / n) * sum2) + a + Math.E;

        result.put(writeSpecification.getProperties().get(0), value);

        return result;
    }

    @Override
    public GeneratorFunction init(final Step configuration) {
        super.init(configuration);

        a = ELHelper.readDouble(configuration.getInstance(), "a");
        b = ELHelper.readDouble(configuration.getInstance(), "b");
        c = ELHelper.readDouble(configuration.getInstance(), "c");

        return this;
    }
}
