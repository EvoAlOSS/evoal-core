package de.evoal.optimisation.ea.api.selection;

import java.util.random.RandomGenerator;

/**
 * Stochastic ranking (T. P. Runarsson, X. Yao: Stochastic ranking for constrained evolutionary
 *   optimization. IEEE Transactions on Evolutionary Computation 4(3), 2000, pp. 284-294,
 *   Fig. 1): ranks candidates by sweeps over neighbouring pairs, as in a bubble sort.
 * <ol>
 *   <li>The initial order is random (Fisher-Yates shuffle).</li>
 *   <li>A sweep visits the neighbours j and j + 1 from the front to the back and draws u from
 *     U(0, 1) for every pair. If both have the penalty 0 (feasible) or u &lt; P_f, they are
 *     swapped if the fitness of j is greater than the one of j + 1; otherwise they are swapped
 *     if the penalty of j is greater than the one of j + 1.</li>
 *   <li>The ranking stops after a sweep without swap, or after the given number of sweeps.</li>
 * </ol>
 * The fitness is canonical (smaller is better).
 */
public final class StochasticRanking {
    private StochasticRanking() {
    }

    /**
     * The outcome of a ranking.
     *
     * @param order The indices of the candidates, from the first (best) to the last rank.
     * @param sweeps The number of sweeps until the ranking stopped.
     * @param fitnessComparisons The comparisons of neighbours, at least one of them
     *   infeasible, that were decided by the fitness (u &lt; P_f).
     * @param penaltyComparisons The comparisons of neighbours, at least one of them
     *   infeasible, that were decided by the penalty.
     */
    public record Result(int[] order, int sweeps, long fitnessComparisons, long penaltyComparisons) {
        public Result {
            order = order.clone();
        }

        @Override
        public int[] order() {
            return order.clone();
        }
    }

    /**
     * @param fitness The canonical fitness of every candidate.
     * @param penalty The penalty of every candidate: not negative, 0 exactly if it is
     *   feasible.
     * @param fitnessProbability The probability P_f that neighbours, at least one of them
     *   infeasible, are compared by their fitness.
     * @param maximumSweeps The maximum number of sweeps N, at least 1.
     * @param random The random numbers of the shuffle and of the draws.
     * @return The ranking.
     * @throws IllegalArgumentException if the arrays differ in length, the probability is not
     *   in [0, 1], or the number of sweeps is smaller than 1.
     */
    public static Result rank(final double[] fitness, final double[] penalty, final double fitnessProbability,
                              final int maximumSweeps, final RandomGenerator random) {
        if(fitness.length != penalty.length) {
            throw new IllegalArgumentException("Every candidate needs a fitness and a penalty, but there are " + fitness.length
                                               + " fitness values and " + penalty.length + " penalties.");
        }
        if(!(fitnessProbability >= 0.0 && fitnessProbability <= 1.0)) {
            throw new IllegalArgumentException("The fitness probability must lie in [0, 1], but is " + fitnessProbability + ".");
        }
        if(maximumSweeps < 1) {
            throw new IllegalArgumentException("The number of sweeps must be at least 1, but is " + maximumSweeps + ".");
        }

        final int count = fitness.length;
        final int[] order = new int[count];
        for(int i = 0; i < count; ++i) {
            order[i] = i;
        }
        for(int i = count - 1; i > 0; --i) {
            swap(order, i, random.nextInt(i + 1));
        }

        long byFitness = 0;
        long byPenalty = 0;
        int sweeps = 0;
        while(sweeps < maximumSweeps) {
            ++sweeps;
            boolean swapped = false;

            for(int j = 0; j < count - 1; ++j) {
                final double u = random.nextDouble();
                final int first = order[j];
                final int second = order[j + 1];
                final boolean bothFeasible = penalty[first] == 0.0 && penalty[second] == 0.0;

                final boolean swap;
                if(bothFeasible || u < fitnessProbability) {
                    if(!bothFeasible) {
                        ++byFitness;
                    }
                    swap = fitness[first] > fitness[second];
                } else {
                    ++byPenalty;
                    swap = penalty[first] > penalty[second];
                }

                if(swap) {
                    swap(order, j, j + 1);
                    swapped = true;
                }
            }

            if(!swapped) {
                break;
            }
        }

        return new Result(order, sweeps, byFitness, byPenalty);
    }

    private static void swap(final int[] order, final int i, final int j) {
        final int value = order[i];
        order[i] = order[j];
        order[j] = value;
    }
}
