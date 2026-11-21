package de.evoal.optimisation.cma_es.main.distribution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The function values of the iterations of one CMA-ES run (from its start or its last
 *   restart) that the termination criteria read: the best and the median value of every
 *   iteration and all values of the last one. The values are in the canonical direction,
 *   smaller is better. At most {@link #MAXIMUM_LENGTH} iterations are kept.
 */
public final class RunHistory {
    /**
     * The largest number of iterations the criterion 'stagnation' looks at.
     */
    public static final int MAXIMUM_LENGTH = 20_000;

    /**
     * The best value of every iteration, the oldest first.
     */
    private final List<Double> bestValues = new ArrayList<>();

    /**
     * The values of the last iteration.
     */
    private double[] lastValues = new double[0];

    /**
     * The median value of every iteration, the oldest first.
     */
    private final List<Double> medianValues = new ArrayList<>();

    /**
     * @return The best values of the kept iterations, the oldest first.
     */
    public List<Double> bestValues() {
        return List.copyOf(bestValues);
    }

    /**
     * @return The values of the last iteration.
     */
    public double[] lastValues() {
        return lastValues.clone();
    }

    /**
     * @return The median of the sorted values; the mean of the middle two for an even number.
     */
    private static double median(final double[] sorted) {
        final int middle = sorted.length / 2;
        if(sorted.length % 2 == 1) {
            return sorted[middle];
        }

        return (sorted[middle - 1] + sorted[middle]) / 2.0;
    }

    /**
     * @return The median values of the kept iterations, the oldest first.
     */
    public List<Double> medianValues() {
        return List.copyOf(medianValues);
    }

    /**
     * Records the values of an iteration.
     *
     * @param values The values of the candidates of the iteration, in any order; at least one.
     * @throws IllegalArgumentException if no value is given.
     */
    public void record(final double[] values) {
        if(values.length == 0) {
            throw new IllegalArgumentException("An iteration needs at least one value.");
        }

        final double[] sorted = values.clone();
        Arrays.sort(sorted);

        bestValues.add(sorted[0]);
        medianValues.add(median(sorted));
        lastValues = sorted;

        if(bestValues.size() > MAXIMUM_LENGTH) {
            bestValues.removeFirst();
            medianValues.removeFirst();
        }
    }

    /**
     * @return The number of kept iterations.
     */
    public int size() {
        return bestValues.size();
    }
}
