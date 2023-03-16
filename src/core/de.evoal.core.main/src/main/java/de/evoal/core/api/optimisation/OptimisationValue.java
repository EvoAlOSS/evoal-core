package de.evoal.core.api.optimisation;

/**
 * The optimisation value is an abstract type that allows comparing them.
 */
public interface OptimisationValue extends Comparable<OptimisationValue> {
    /**
     * @return A list of serializable information for optimisation value statistics.
     */
    public Object [] toStatistics();
}
