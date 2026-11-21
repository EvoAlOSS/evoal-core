package de.evoal.optimisation.ea.api.selection;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.ea.Statistics;

/**
 * The procedure of stochastic ranking (Runarsson and Yao 2000, Fig. 1).
 */
class StochasticRankingTest {
    private static final int TRIALS = 10_000;

    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(17);

    @Test
    void withoutFitnessProbabilityFeasibleCandidatesComeFirstByFitnessThenInfeasibleOnesByPenalty() {
        // candidates 0..4: fitness and penalty; 1 and 3 are feasible
        final double[] fitness = {1.0, 5.0, 0.5, 3.0, 2.0};
        final double[] penalty = {2.0, 0.0, 1.0, 0.0, 3.0};

        final StochasticRanking.Result result = StochasticRanking.rank(fitness, penalty, 0.0, 5, random);

        Assertions.assertArrayEquals(new int[] {3, 1, 2, 0, 4}, result.order());
        Assertions.assertEquals(0, result.fitnessComparisons());
    }

    @Test
    void withFitnessProbabilityOneTheConstraintsAreIgnored() {
        final double[] fitness = {1.0, 5.0, 0.5, 3.0, 2.0};
        final double[] penalty = {2.0, 0.0, 1.0, 0.0, 3.0};

        final StochasticRanking.Result result = StochasticRanking.rank(fitness, penalty, 1.0, 5, random);

        Assertions.assertArrayEquals(new int[] {2, 0, 4, 3, 1}, result.order());
        Assertions.assertEquals(0, result.penaltyComparisons());
    }

    @Test
    void feasibleNeighboursAreAlwaysComparedByFitness() {
        final double[] fitness = {4.0, 2.0, 3.0, 1.0};
        final double[] penalty = {0.0, 0.0, 0.0, 0.0};

        final StochasticRanking.Result result = StochasticRanking.rank(fitness, penalty, 0.0, 4, random);

        Assertions.assertArrayEquals(new int[] {3, 1, 2, 0}, result.order());
        Assertions.assertEquals(0, result.fitnessComparisons());
        Assertions.assertEquals(0, result.penaltyComparisons());
    }

    @Test
    void theRankingStopsAfterASweepWithoutSwap() {
        final double[] equal = {1.0, 1.0, 1.0, 1.0};

        final StochasticRanking.Result result = StochasticRanking.rank(equal, new double[4], 0.45, 4, random);

        Assertions.assertEquals(1, result.sweeps());
    }

    @Test
    void theRankingStopsAfterTheMaximumNumberOfSweeps() {
        // ten distinct values in a random order need more than two sweeps; two are allowed
        final double[] fitness = {9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0, 0.0};

        final StochasticRanking.Result result = StochasticRanking.rank(fitness, new double[10], 0.45, 2, random);

        Assertions.assertEquals(2, result.sweeps());
    }

    @Test
    void anInfeasiblePairIsDecidedByFitnessWithTheFitnessProbability() {
        // candidate 0 has the better fitness, candidate 1 the smaller penalty: whatever the
        // initial order, 0 is first exactly if the single comparison is decided by fitness
        final double[] fitness = {1.0, 2.0};
        final double[] penalty = {2.0, 1.0};

        long first = 0;
        long byFitness = 0;
        for(int trial = 0; trial < TRIALS; ++trial) {
            final StochasticRanking.Result result = StochasticRanking.rank(fitness, penalty, 0.45, 1, random);
            first += result.order()[0] == 0 ? 1 : 0;
            byFitness += result.fitnessComparisons();
            Assertions.assertEquals(1, result.fitnessComparisons() + result.penaltyComparisons());
        }

        Statistics.assertBinomial(first, TRIALS, 0.45, "candidate 0 first");
        Assertions.assertEquals(first, byFitness);
    }

    @Test
    void invalidArgumentsAreRejected() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> StochasticRanking.rank(new double[2], new double[3], 0.45, 1, random));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> StochasticRanking.rank(new double[2], new double[2], 1.5, 1, random));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> StochasticRanking.rank(new double[2], new double[2], 0.45, 0, random));
    }
}
