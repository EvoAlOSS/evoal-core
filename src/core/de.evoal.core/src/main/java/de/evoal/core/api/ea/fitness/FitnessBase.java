package de.evoal.core.api.ea.fitness;

import de.evoal.core.api.ea.constraints.strategies.fitness.MalusForFitnessStrategy;
import de.evoal.core.api.ea.fitness.type.FitnessConverter;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.ea.fitness.type.FitnessType;
import de.evoal.core.api.properties.Properties;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Base class for fitness functions that allows manipulating the calculated fitness
 *   values (in case of multi-optimization problems) based on, e.g., constraint
 *   violations.
 */
public abstract class FitnessBase implements FitnessEvaluator {
    @Inject @Named("depending")
    private FitnessConverter converter;

    @Inject
    private MalusForFitnessStrategy malus;

    /**
     * The surrogate function used.
     */
    //@Inject
    // TODO protected SurrogateFunction surrogate;

    /**
     * The property values we are looking for.
     */
    @Inject
    @BlackboardValue(BlackboardEntry.TARGET_PROPERTIES)
    protected Properties targetVector;

    /**
     * The actual fitness function we are wrapping.
     */
    protected abstract double [] _fitness(final Properties candidate);

    /**
     * Calculates the fitness of the given candidate.
     *
     * @param candidate The possible candidate individual.
     * @return The calculated fitness value.
     */
    @Override
    public final FitnessType evaluate(final Properties candidate) {
        final double [] fitnessValues = _fitness(candidate);

        malus.apply(candidate, fitnessValues);

        return converter.convert(fitnessValues);
    }
}
