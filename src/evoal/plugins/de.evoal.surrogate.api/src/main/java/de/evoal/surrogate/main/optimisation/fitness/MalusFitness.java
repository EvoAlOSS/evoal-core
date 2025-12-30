package de.evoal.surrogate.main.optimisation.fitness;

import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.ea.constraints.strategies.malus.MalusForFitnessStrategy;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent
@Named("malus")
@Slf4j
public class MalusFitness extends OptimisationFunctionDecorator {

    @Inject
    @Named("optimisation-space-specification")
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
