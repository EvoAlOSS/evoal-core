package de.evoal.surrogate.main.ea;

import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.instance.Instance;
import de.evoal.surrogate.api.function.SurrogateFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("surrogate")
public class SurrogateFitnessFunction implements OptimisationFunction {

    @Inject
    private SurrogateFunction function;

    @Override
    public double[] evaluate(final Properties properties) {
        return function.apply(properties).getValuesAsDouble();
    }

    @Override
    public OptimisationFunction init(final Instance config) {
        return this;
    }
}
