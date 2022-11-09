package de.evoal.generator.main.benchmarks;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.LiteralValue;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("rastrigin")
public class Rastrigin extends AbstractGeneratorFunction {
    private double a;

    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);

        final double n = readSpecification.size();
        double value = a * n;

        for(final PropertySpecification ps : readSpecification.getProperties()) {
            double read_i = in.get(ps);

            value += (Math.pow(read_i, 2.0) - a * Math.cos(2 * Math.PI * read_i));
        }

        result.put(writeSpecification.getProperties().get(0), value);

        return result;
    }

    @Override
    public GeneratorFunction init(final Step configuration) {
        super.init(configuration);

        a = ((DoubleLiteral)((LiteralValue)configuration.getInstance().findAttribute("a").getValue()).getLiteral()).getValue();

        return this;
    }
}
