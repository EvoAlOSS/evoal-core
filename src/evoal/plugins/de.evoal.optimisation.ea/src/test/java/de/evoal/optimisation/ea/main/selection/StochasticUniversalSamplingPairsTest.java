package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;

/**
 * Stochastic universal sampling returns its selection in random order, so consecutive
 *   parents are random pairs and the copies of a candidate are not adjacent.
 */
class StochasticUniversalSamplingPairsTest {
    @Test
    void theCopiesOfACandidateAreNotAlwaysPaired() {
        final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(3);
        // 8 selections with the roulette probabilities 0.4, 0.3, 0.2, 0.1, 0: the best
        // candidate is selected 3 or 4 times
        final List<Candidate> candidates = Candidates.withFitness(0.0, 1.0, 2.0, 3.0, 4.0);
        final Candidate best = candidates.get(0);
        final int spins = 1_000;

        int firstPairIsTheBest = 0;
        for(int spin = 0; spin < spins; ++spin) {
            final List<Candidate> selected = new StochasticUniversalSampling().select(candidates, 8, CandidateOrder.BY_VALUE, random);
            if(selected.get(0) == best && selected.get(1) == best) {
                firstPairIsTheBest += 1;
            }
        }

        // in population order the first pair is always the best with itself; in random order
        // with 3 or 4 copies of 8 at most 4/8 * 3/7 of the spins
        Assertions.assertTrue(firstPairIsTheBest < spins / 3, "first pair is the best twice in " + firstPairIsTheBest
                                                              + " of " + spins + " spins");
    }
}
