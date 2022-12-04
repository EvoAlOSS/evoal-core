package de.evoal.surrogate.main.ea;

import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.instance.Instance;
import de.evoal.surrogate.api.function.SurrogateFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("surrogate")
public class SurrogateFitnessFunction implements FitnessFunction {

    private SurrogateFunction function;

    @Override
    public double[] evaluate(final Properties properties) {
        return function.apply(properties).getValues();
    }

    @Override
    public FitnessFunction init(final Instance config) {
        return this;
    }
}
