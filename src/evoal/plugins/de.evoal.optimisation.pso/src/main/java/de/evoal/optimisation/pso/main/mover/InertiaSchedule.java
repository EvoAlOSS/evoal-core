package de.evoal.optimisation.pso.main.mover;

/**
 * The inertia weight of a mover over the iterations. The weight changes linearly from
 *   {@code start} to {@code end} within the first {@code iterations} iterations and then
 *   stays at {@code end}:
 *   {@code w(k) = start + min(k, iterations) / iterations * (end - start)}
 *   for the iteration {@code k >= 1}.
 *
 * @param start The weight before the first iteration.
 * @param end The weight from iteration {@code iterations} on.
 * @param iterations The number of iterations until the weight reaches {@code end}.
 */
record InertiaSchedule(double start, double end, int iterations) {
    InertiaSchedule {
        if(iterations < 1) {
            throw new IllegalArgumentException("The inertia schedule needs at least one iteration, got " + iterations + ".");
        }
    }

    /**
     * @param iteration The iteration, starting at 1.
     * @return The inertia weight of the iteration.
     */
    double weight(final int iteration) {
        final double progress = Math.min(iteration, iterations) / (double) iterations;

        return start + progress * (end - start);
    }
}
