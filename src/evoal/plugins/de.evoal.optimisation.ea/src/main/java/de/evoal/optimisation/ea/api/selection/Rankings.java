package de.evoal.optimisation.ea.api.selection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Helpers of the selections: ranking by the optimisation values and drawing by weights.
 */
public final class Rankings {
    private Rankings() {
    }

    /**
     * @return The candidates from the best to the worst by their optimisation values; equal
     *   candidates keep their order.
     */
    public static List<Candidate> bestFirst(final List<Candidate> candidates) {
        final List<Candidate> sorted = new ArrayList<>(candidates);
        sorted.sort(Comparator.comparing(Candidate::value).reversed());

        return sorted;
    }

    /**
     * Draws one index with probabilities proportional to the weights.
     *
     * @param weights The non-negative weights; if their sum is 0, every index is equally
     *   likely.
     * @return The drawn index.
     */
    public static int draw(final double[] weights, final double total, final RandomGenerator random) {
        if(total <= 0.0) {
            return random.nextInt(weights.length);
        }

        final double target = random.nextDouble() * total;
        double cumulated = 0.0;
        for(int i = 0; i < weights.length; ++i) {
            cumulated += weights[i];
            if(target < cumulated) {
                return i;
            }
        }

        // rounding: the last index with a positive weight
        for(int i = weights.length - 1; i >= 0; --i) {
            if(weights[i] > 0.0) {
                return i;
            }
        }

        return weights.length - 1;
    }

    /**
     * @return The first fitness component of every candidate.
     * @throws IllegalStateException if a candidate has not exactly one fitness component.
     */
    public static double[] singleFitness(final List<Candidate> candidates) {
        final double[] fitness = new double[candidates.size()];

        for(int i = 0; i < fitness.length; ++i) {
            final double[] values = candidates.get(i).fitness().values();
            if(values.length != 1) {
                throw new IllegalStateException("The selection needs a fitness with one component, but the fitness has "
                                                + values.length + ".");
            }
            fitness[i] = values[0];
        }

        return fitness;
    }

    /**
     * @return The sum of the weights.
     */
    public static double sum(final double[] weights) {
        double total = 0.0;
        for(final double weight : weights) {
            total += weight;
        }

        return total;
    }

    /**
     * Draws {@code count} candidates independently with probabilities proportional to the
     *   weights.
     */
    public static List<Candidate> drawAll(final List<Candidate> candidates, final double[] weights, final int count,
                                          final RandomGenerator random) {
        final double total = sum(weights);
        final List<Candidate> selected = new ArrayList<>(count);
        for(int i = 0; i < count; ++i) {
            selected.add(candidates.get(draw(weights, total, random)));
        }

        return selected;
    }
}
