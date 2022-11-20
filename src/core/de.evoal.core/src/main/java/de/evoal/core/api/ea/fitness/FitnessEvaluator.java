package de.evoal.core.api.ea.fitness;

import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.core.api.properties.Properties;

import java.util.function.Function;

/**
 * A fitness evaluator calculates the fitness for a given individual.
 */
public interface FitnessEvaluator extends Function<Properties, FitnessType> {
    /**
     * Calculates the fitness value of the given individual.
     */
    public FitnessType evaluate(final Properties individual);

    /**
     * See {@link #evaluate(Properties)}.
     */
    default FitnessType apply(final Properties individual) {
        return evaluate(individual);
    }
}
