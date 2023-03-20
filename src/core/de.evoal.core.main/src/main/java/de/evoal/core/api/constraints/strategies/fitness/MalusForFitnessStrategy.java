package de.evoal.core.api.constraints.strategies.fitness;

import de.evoal.core.api.constraints.strategies.HandlingStrategy;
import de.evoal.core.api.constraints.strategies.fitness.internal.ChainFunction;
import de.evoal.core.api.constraints.strategies.fitness.internal.IdentityFunction;
import de.evoal.core.api.properties.Properties;

/**
 * Class for applying the configured malus functions to given properties candidate.
 */
public class MalusForFitnessStrategy implements HandlingStrategy {
    private final MalusFunction[] malusConversions;

    /**
     * Constructor of the class.
     * @param size Number of malus functions to apply by this strategy.
     */
    public MalusForFitnessStrategy(final int size) {
        malusConversions = new MalusFunction[size];

        for(int index = 0; index < size; ++index) {
            malusConversions[index] = new IdentityFunction();
        }
    }

    /**
     * Adds a {@code MalusFunction} for the given property index.
     *
     * @param propertyIndex Index of the property.
     * @param malusFunction The {@code MalusFunction} to apply
     */
    public void add(final int propertyIndex, final MalusFunction malusFunction) {
        malusConversions[propertyIndex] = new ChainFunction(malusConversions[propertyIndex], malusFunction);
    }

    /**
     * Applies the malus functions.
     *
     * @param candidate The individual.
     * @param fitnessValues The calculated fitness values.
     */
    public void apply(final Properties genotype, final Properties fitness) {
        for(int index = 0; index < fitness.size(); ++index) {
            fitness.set(index, malusConversions[index].apply(genotype, fitness, fitness.getAsDouble(index)));
        }
    }
}
