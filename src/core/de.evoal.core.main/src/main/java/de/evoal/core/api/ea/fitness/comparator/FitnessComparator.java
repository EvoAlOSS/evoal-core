package de.evoal.core.api.ea.fitness.comparator;

import de.evoal.languages.model.instance.Instance;

import java.util.function.Function;

/**
 * Converts a given set of fitness values (result of {@link de.evoal.core.api.ea.fitness.FitnessFunction}
 * into a {@link FitnessValue} for Jenetics.
 */
public interface FitnessComparator extends Function<double [], FitnessValue> {
    /**
     * Creates a fitness type instance for the given fitness values.
     *
     * @param fitnessValues The calculated fitness values to convert.
     * @return The calculated FitnessType.
     */
    public FitnessValue compare(final double [] fitnessValues);

    public default FitnessValue apply(final double [] fitnessValues) {
        return compare(fitnessValues);
    }

    FitnessComparator init(final Instance config);
}
