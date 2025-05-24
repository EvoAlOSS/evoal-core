package de.evoal.surrogate.api.ea.constraints.strategies.malus;

import de.evoal.core.api.properties.Properties;

/**
 * Base interface for a malus function.
 */
@FunctionalInterface
public interface MalusFunction {
    /**
     * Applies the malus function and calculates the adjusted malus value.
     *
     * @param properties The individual.
     * @param fitnessValue The current malus value.
     * @return The adapted malus value.
     */
    double apply(final Properties genoProperties, final Properties fitnessPro, final double fitnessValue);
}
