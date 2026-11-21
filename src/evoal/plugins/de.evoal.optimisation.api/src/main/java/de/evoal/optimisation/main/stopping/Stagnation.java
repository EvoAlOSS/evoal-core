package de.evoal.optimisation.main.stopping;

/**
 * Counts the iterations in which a measure (smaller is better) has not improved. An
 *   iteration improves if its value is below the reference by more than the tolerance,
 *   {@code max(absolute, relative * |reference|)}. An improvement becomes the new reference,
 *   so smaller improvements add up until they exceed the tolerance. A non-finite value never
 *   improves; the first finite value sets the reference.
 */
final class Stagnation {
    /**
     * The tolerance independent of the reference, at least 0.
     */
    private final double absoluteTolerance;

    /**
     * The tolerance as a fraction of the reference's magnitude, at least 0.
     */
    private final double relativeTolerance;

    /**
     * The value of the last improvement, {@code NaN} before the first finite value.
     */
    private double reference = Double.NaN;

    /**
     * The number of iterations since the last improvement.
     */
    private int iterationsWithoutImprovement;

    /**
     * @param absoluteTolerance The tolerance independent of the reference.
     * @param relativeTolerance The tolerance as a fraction of the reference's magnitude.
     * @throws IllegalArgumentException if a tolerance is negative or not finite.
     */
    Stagnation(final double absoluteTolerance, final double relativeTolerance) {
        this.absoluteTolerance = requireTolerance(absoluteTolerance, "absolute-tolerance");
        this.relativeTolerance = requireTolerance(relativeTolerance, "relative-tolerance");
    }

    private static double requireTolerance(final double tolerance, final String name) {
        if(!Double.isFinite(tolerance) || tolerance < 0.0) {
            throw new IllegalArgumentException("The '" + name + "' must be a finite value of at least 0, but is "
                                               + tolerance + ".");
        }

        return tolerance;
    }

    /**
     * @return The number of iterations since the last improvement.
     */
    int iterationsWithoutImprovement() {
        return iterationsWithoutImprovement;
    }

    /**
     * @return The value of the last improvement, {@code NaN} before the first finite value.
     */
    double reference() {
        return reference;
    }

    /**
     * Forgets the reference and the count, e.g. at the start of a run.
     */
    void reset() {
        reference = Double.NaN;
        iterationsWithoutImprovement = 0;
    }

    /**
     * @return The tolerance of the current reference.
     */
    double tolerance() {
        return Math.max(absoluteTolerance, relativeTolerance * Math.abs(reference));
    }

    /**
     * Records the value of an iteration.
     *
     * @param value The value of the measure.
     * @return Whether the value is an improvement.
     */
    boolean update(final double value) {
        final boolean improvement = Double.isFinite(value)
                                    && (Double.isNaN(reference) || value < reference - tolerance());

        if(improvement) {
            reference = value;
            iterationsWithoutImprovement = 0;
        } else {
            iterationsWithoutImprovement += 1;
        }

        return improvement;
    }
}
