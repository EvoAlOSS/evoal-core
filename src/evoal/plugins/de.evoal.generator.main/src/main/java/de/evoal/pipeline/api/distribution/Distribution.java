package de.evoal.pipeline.api.distribution;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * A distribution to sample data.
 */
public interface Distribution extends EvoalComponent<Distribution> {
    /**
     * @return A sample from the distribution.
     */
    double [] sample();

    /**
     * @return The number of values of every sample.
     */
    int dimension();

    /**
     * Tells if a value of the samples is a whole number. Such a value is written to integer data,
     *   any other value to real data.
     *
     * @param index The index of the value in a sample, less than {@link #dimension()}.
     * @return If the value is a whole number; false by default.
     */
    default boolean isDiscrete(final int index) {
        return false;
    }

    /**
     * Tells if a value of the samples is a category: a whole number that names a category, not
     *   a count. Such a value is written to nominal or ordinal integer data.
     *
     * @param index The index of the value in a sample, less than {@link #dimension()}.
     * @return If the value is a category; false by default.
     */
    default boolean isCategorical(final int index) {
        return false;
    }
}
