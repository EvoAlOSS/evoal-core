package de.evoal.core.ea.main.fitness;

import de.evoal.core.ea.api.constraints.strategies.fitness.MalusForFitnessStrategy;
import de.evoal.core.api.optimisation.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("malus")
@Slf4j
public class MalusFitness extends OptimisationFunctionDecorator {

    @Inject
    @Named("optimisation-function-output")
    private PropertiesSpecification fitnessSpecification;

    @Inject
    private MalusForFitnessStrategy strategy;

    @Override
    public double[] evaluate(final Properties properties) {
        final double [] current = decoratedFunction.evaluate(properties);
        final Properties fitness = new Properties(fitnessSpecification, current);

        strategy.apply(properties, fitness);

        return fitness.getValuesAsDouble();
    }
}
