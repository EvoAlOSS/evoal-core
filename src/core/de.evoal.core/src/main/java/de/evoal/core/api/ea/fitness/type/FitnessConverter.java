package de.evoal.core.api.ea.fitness.type;

/**
 * Converter base for creating FitnessType's from distance arrays.
 */
public interface FitnessConverter {
    /**
     * Creates a fitness type instance for the given fitness values.
     *
     * @param fitnessValues The calculated fitness values to convert.
     * @return The calculated FitnessType.
     */
    public FitnessType convert(final double [] fitnessValues);
}
