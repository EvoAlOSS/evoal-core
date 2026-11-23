package de.evoal.optimisation.ea.api.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Helpers of the selections: drawing by weights.
 */
public final class Rankings {
    private Rankings() {
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
     * Computes the weight of a candidate with a finite fitness.
     */
    @FunctionalInterface
    public interface FiniteWeight {
        /**
         * @param fitness The finite fitness of the candidate.
         * @param best The smallest finite fitness of the candidates.
         * @param worst The largest finite fitness of the candidates.
         * @return The non-negative weight.
         */
        double weight(double fitness, double best, double worst);
    }

    /**
     * Computes the weights of a fitness-proportional selection from the single fitness of
     *   the candidates, which is canonical (smaller is better):
     *   <ul>
     *     <li>NaN is rejected;</li>
     *     <li>if a fitness is -Infinity, the candidates with -Infinity get weight 1 and all
     *       others 0;</li>
     *     <li>otherwise +Infinity gets weight 0, and a finite fitness gets the weight of
     *       {@code finiteWeight}, with the best and worst fitness taken over the finite
     *       values only.</li>
     *   </ul>
     *
     * @param candidates The evaluated candidates.
     * @param selection The name of the selection, for the error message.
     * @param finiteWeight The weight of a finite fitness.
     * @return The weights, in the order of the candidates.
     * @throws IllegalStateException if a fitness is NaN or has not exactly one component.
     */
    public static double[] proportionalWeights(final List<Candidate> candidates, final String selection,
                                               final FiniteWeight finiteWeight) {
        final double[] fitness = singleFitness(candidates);
        final double[] weights = new double[fitness.length];

        boolean negativeInfinity = false;
        boolean positiveInfinity = false;
        boolean finite = false;
        double best = Double.POSITIVE_INFINITY;
        double worst = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < fitness.length; ++i) {
            final double value = fitness[i];
            if(Double.isNaN(value)) {
                throw new IllegalStateException("'" + selection + "' needs a fitness that is a number, but the fitness of "
                                                + candidates.get(i) + " is NaN.");
            }
            if(value == Double.NEGATIVE_INFINITY) {
                negativeInfinity = true;
            } else if(value == Double.POSITIVE_INFINITY) {
                positiveInfinity = true;
            } else {
                finite = true;
                best = Math.min(best, value);
                worst = Math.max(worst, value);
            }
        }

        for(int i = 0; i < fitness.length; ++i) {
            final double value = fitness[i];
            if(negativeInfinity) {
                weights[i] = value == Double.NEGATIVE_INFINITY ? 1.0 : 0.0;
            } else if(Double.isFinite(value)) {
                weights[i] = finiteWeight.weight(value, best, worst);
            }
        }

        // all finite weights 0 (e.g. equal fitness with windowing): the uniform fallback of the
        // callers must not include the candidates with +Infinity
        if(positiveInfinity && finite && sum(weights) <= 0.0) {
            for(int i = 0; i < fitness.length; ++i) {
                weights[i] = Double.isFinite(fitness[i]) ? 1.0 : 0.0;
            }
        }

        return weights;
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
