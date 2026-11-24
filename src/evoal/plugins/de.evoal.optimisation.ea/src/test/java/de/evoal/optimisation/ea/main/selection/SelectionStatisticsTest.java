package de.evoal.optimisation.ea.main.selection;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.math.EvoalMath;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.Statistics;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Statistical tests of the selections: with a fixed seed and many selections, every candidate
 *   is selected as often as its selection probability says, within +-4 standard deviations.
 *   The candidates have the fitness 0 (best) to 4 (worst).
 */
public class SelectionStatisticsTest {
    private static final int SELECTIONS = 50_000;

    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(7);

    /**
     * The candidates, worst first, so the selections cannot rely on the order.
     */
    private final List<Candidate> candidates = Candidates.withFitness(4.0, 3.0, 2.0, 1.0, 0.0);

    /**
     * @param probabilities The selection probability of the candidates with the fitness 0 to 4.
     */
    private void assertFrequencies(final SelectionMethod selection, final double... probabilities) {
        final Map<Candidate, Long> counts = new IdentityHashMap<>();
        selection.select(candidates, SELECTIONS, CandidateOrder.BY_VALUE, random)
                 .forEach(candidate -> counts.merge(candidate, 1L, Long::sum));

        for(int fitness = 0; fitness < probabilities.length; ++fitness) {
            final Candidate candidate = candidates.get(4 - fitness);
            Statistics.assertBinomial(counts.getOrDefault(candidate, 0L), SELECTIONS, probabilities[fitness],
                                      selection.name() + ", fitness " + fitness);
        }
    }

    @Test
    public void tournamentSelectsTheBestOfItsCompetitors() {
        // P(position j) = ((n - j)^s - (n - j - 1)^s) / n^s with n = 5, s = 2
        assertFrequencies(new TournamentSelection(2), 9 / 25.0, 7 / 25.0, 5 / 25.0, 3 / 25.0, 1 / 25.0);
    }

    @Test
    public void truncationSelectsUniformlyFromTheBest() {
        // ceil(0.5 * 5) = 3
        assertFrequencies(new TruncationSelection(0.5), 1 / 3.0, 1 / 3.0, 1 / 3.0, 0.0, 0.0);
    }

    @Test
    public void randomSelectionIsUniform() {
        assertFrequencies(new RandomSelection(), 0.2, 0.2, 0.2, 0.2, 0.2);
    }

    @Test
    public void linearRankingFollowsTheRanks() {
        // eta- = 0.5, eta+ = 1.5: (0.5 + (i - 1) / 4) / 5 for the ranks i = 5 (best) to 1
        assertFrequencies(new LinearRankingSelection(0.5), 0.3, 0.25, 0.2, 0.15, 0.1);
    }

    @Test
    public void exponentialRankingFollowsThePowersOfC() {
        final double c = 0.5;
        final double total = 1 + c + c * c + c * c * c + c * c * c * c;
        assertFrequencies(new ExponentialRankingSelection(c), 1 / total, c / total, c * c / total, c * c * c / total,
                          c * c * c * c / total);
    }

    @Test
    public void rouletteWheelUsesTheWindowedFitness() {
        // f_max - f = 4, 3, 2, 1, 0
        assertFrequencies(new RouletteWheelSelection(), 0.4, 0.3, 0.2, 0.1, 0.0);
    }

    @Test
    public void boltzmannUsesTheExponentialWeights() {
        final double temperature = 2.0;
        final double[] weights = new double[5];
        double total = 0.0;
        for(int f = 0; f < 5; ++f) {
            weights[f] = EvoalMath.exp(-f / temperature);
            total += weights[f];
        }

        assertFrequencies(new BoltzmannSelection(temperature), weights[0] / total, weights[1] / total, weights[2] / total,
                          weights[3] / total, weights[4] / total);
    }

    @Test
    public void stochasticUniversalSamplingSelectsTheFloorOrCeilingOfTheExpectation() {
        // 7 selections with the roulette probabilities 0.4, 0.3, 0.2, 0.1, 0: expected 2.8, 2.1, 1.4, 0.7, 0
        final double[] expected = {2.8, 2.1, 1.4, 0.7, 0.0};
        final SelectionMethod selection = new StochasticUniversalSampling();
        final long[] totals = new long[5];
        final int spins = 10_000;

        for(int spin = 0; spin < spins; ++spin) {
            final Map<Candidate, Integer> counts = new IdentityHashMap<>();
            selection.select(candidates, 7, CandidateOrder.BY_VALUE, random).forEach(candidate -> counts.merge(candidate, 1, Integer::sum));

            for(int fitness = 0; fitness < 5; ++fitness) {
                final int count = counts.getOrDefault(candidates.get(4 - fitness), 0);
                Assertions.assertTrue(count == Math.floor(expected[fitness]) || count == Math.ceil(expected[fitness]),
                                      "fitness " + fitness + " selected " + count + " times");
                totals[fitness] += count;
            }
        }

        // the fractional part decides between floor and ceiling: one binomial draw per spin
        for(int fitness = 0; fitness < 5; ++fitness) {
            final double fraction = expected[fitness] - Math.floor(expected[fitness]);
            final long ceilings = totals[fitness] - (long) Math.floor(expected[fitness]) * spins;
            Statistics.assertBinomial(ceilings, spins, fraction, "fitness " + fitness);
        }
    }

    @Test
    public void elitismSelectsTheBestFirst() {
        final List<Candidate> selected = new EliteSelection(2, new RandomSelection()).select(candidates, 4, CandidateOrder.BY_VALUE, random);

        Assertions.assertSame(candidates.get(4), selected.get(0));
        Assertions.assertSame(candidates.get(3), selected.get(1));
        Assertions.assertEquals(4, selected.size());
    }

    @Test
    public void fitnessProportionalSelectionsWithEqualFitnessAreUniform() {
        final List<Candidate> equal = Candidates.withFitness(1.0, 1.0, 1.0, 1.0);
        final Map<Candidate, Long> counts = new IdentityHashMap<>();
        new RouletteWheelSelection().select(equal, SELECTIONS, CandidateOrder.BY_VALUE, random).forEach(candidate -> counts.merge(candidate, 1L, Long::sum));

        for(final Candidate candidate : equal) {
            Statistics.assertBinomial(counts.getOrDefault(candidate, 0L), SELECTIONS, 0.25, "equal fitness");
        }
    }
}
