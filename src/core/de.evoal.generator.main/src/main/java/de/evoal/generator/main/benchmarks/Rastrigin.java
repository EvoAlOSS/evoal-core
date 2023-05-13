package de.evoal.generator.main.benchmarks;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.AbstractGeneratorFunction;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.generator.Step;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("rastrigin")
public class Rastrigin extends AbstractGeneratorFunction {
    @Inject
    private ExpressionEvaluator evaluator;

    private double a;

    @Override
    public Properties apply(final Properties in) {
        final Properties result = mergeAndCopy(in);

        final double n = readSpecification.size();
        double value = a * n;

        for(final PropertySpecification ps : readSpecification.getProperties()) {
            double read_i = in.getAsDouble(ps);

            value += (Math.pow(read_i, 2.0) - a * Math.cos(2 * Math.PI * read_i));
        }

        result.put(writeSpecification.getProperties().get(0), value);

        return result;
    }

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        super.init(configuration);

        a = evaluator.attributeToDouble(configuration.getInstance(), "a");

        return this;
    }
}
