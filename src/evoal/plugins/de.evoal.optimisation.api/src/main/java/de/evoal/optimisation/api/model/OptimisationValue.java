package de.evoal.optimisation.api.model;

/**
 * The optimisation value is an abstract type that allows comparing them.
 */
public interface OptimisationValue extends Comparable<OptimisationValue> {
    /**
     * @return A list of serializable information for optimisation value statistics.
     */
    Object [] toStatistics();

    default boolean isEqual(final OptimisationValue other, final boolean maximise) {
        return this.compareTo(other) == 0;
    }

    default boolean isBetter(final OptimisationValue other, final boolean maximise) {
        return maximise ? this.compareTo(other) > 0 : this.compareTo(other) < 0;
    }

    default boolean isWorse(final OptimisationValue other, final boolean maximise){
        return maximise ? this.compareTo(other) < 0 : this.compareTo(other) > 0;
    }

    double distanceFrom(final OptimisationValue other);
}
