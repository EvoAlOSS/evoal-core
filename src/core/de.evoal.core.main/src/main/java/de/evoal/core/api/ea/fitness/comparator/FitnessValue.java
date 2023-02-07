package de.evoal.core.api.ea.fitness.comparator;

/**
 * The fitness value is an abstract type that allows comparing them.
 */
public interface FitnessValue extends Comparable<FitnessValue> {
    /**
     * @return A list of serializable information for fitness value statistics.
     */
    public Object [] toStatistics();
}
