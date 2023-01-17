package de.evoal.core.main.ea.fitness;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.ea.constraints.strategies.fitness.MalusForFitnessStrategy;
import de.evoal.core.api.ea.fitness.FitnessDecorator;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.instance.*;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("malus")
@Slf4j
public class MalusFitness extends FitnessDecorator {

    @Inject
    @Named("optimization-output-specification")
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
