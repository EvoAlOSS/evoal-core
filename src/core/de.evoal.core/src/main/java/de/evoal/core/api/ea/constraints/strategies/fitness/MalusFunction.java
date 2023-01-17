package de.evoal.core.api.ea.constraints.strategies.fitness;

import de.evoal.core.api.properties.Properties;

/**
 * Base interface for a malus function.
 */
@FunctionalInterface
public interface MalusFunction {
    /**
     * Applies the malus function and calculates the adjusted fitness value.
     *
     * @param properties The individual.
     * @param fitnessValue The current fitness value.
     * @return The adapted fitness value.
     */
    public double apply(final Properties genoProperties, final Properties fitnessPro, final double fitnessValue);
}
