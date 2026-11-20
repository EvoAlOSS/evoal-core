package de.evoal.optimisation.api.correlations;

/**
 * The range of a feature in which a {@code 'ranged-correlation'} applies, declared in the
 *   DDL by {@code range(lower, upper)}. Both bounds belong to the range.
 *
 * @param lower The lower bound.
 * @param upper The upper bound, not smaller than the lower bound.
 */
public record CorrelationRange(double lower, double upper) {
    /**
     * @throws IllegalArgumentException if the upper bound is smaller than the lower bound or
     *   a bound is NaN.
     */
    public CorrelationRange {
        // also rejects NaN
        if(!(lower <= upper)) {
            throw new IllegalArgumentException("The range [" + lower + ", " + upper + "] is empty.");
        }
    }

    /**
     * @param value A value of the feature.
     * @return Whether the value lies in the range.
     */
    public boolean contains(final double value) {
        return lower <= value && value <= upper;
    }

    @Override
    public String toString() {
        return "[" + lower + ", " + upper + "]";
    }
}
