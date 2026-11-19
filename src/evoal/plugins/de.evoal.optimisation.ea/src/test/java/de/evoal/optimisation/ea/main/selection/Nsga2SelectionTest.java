package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.CrowdedOrder;

/**
 * The survivor selection of NSGA-II with the hand-calculated example of
 *   {@code ParetoFrontsTest}: first front 0, 1, 2, 5 (crowding distances infinite, 5/6,
 *   infinite, 7/6), then 3, then 4.
 */
class Nsga2SelectionTest {
    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(42);

    private static List<Candidate> candidates() {
        return List.of(Candidates.withTwoComponents(1, 5), Candidates.withTwoComponents(2, 3),
                       Candidates.withTwoComponents(4, 1), Candidates.withTwoComponents(3, 4),
                       Candidates.withTwoComponents(5, 5), Candidates.withTwoComponents(2, 3));
    }

    @Test
    @DisplayName("complete fronts are selected in their order")
    void completeFronts() {
        final List<Candidate> candidates = candidates();
        final List<Candidate> selected = new Nsga2Selection().select(candidates, 5, CandidateOrder.BY_VALUE, random);

        Assertions.assertEquals(List.of(candidates.get(0), candidates.get(1), candidates.get(2), candidates.get(5),
                                        candidates.get(3)), selected);
    }

    @Test
    @DisplayName("the front that does not fit is cut by descending crowding distance")
    void cutByCrowdingDistance() {
        final List<Candidate> candidates = candidates();
        final List<Candidate> selected = new Nsga2Selection().select(candidates, 3, CandidateOrder.BY_VALUE, random);

        // infinite (0), infinite (2), 7/6 (5); 5/6 (1) is left out
        Assertions.assertEquals(List.of(candidates.get(0), candidates.get(2), candidates.get(5)), selected);
    }

    @Test
    @DisplayName("every candidate gets its front and crowding distance, also the ones not selected")
    void properties() {
        final List<Candidate> candidates = candidates();
        new Nsga2Selection().select(candidates, 3, CandidateOrder.BY_VALUE, random);

        Assertions.assertEquals(2L, candidates.get(4).properties().get(CrowdedOrder.FRONT));
        Assertions.assertEquals(5.0 / 6.0, (double) candidates.get(1).properties().get(CrowdedOrder.CROWDING_DISTANCE), 1e-12);
    }

    @Test
    @DisplayName("it selects without replacement")
    void withoutReplacement() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Nsga2Selection().select(candidates(), 7, CandidateOrder.BY_VALUE, random));
        Assertions.assertTrue(new Nsga2Selection().sortsIntoFronts());
        Assertions.assertTrue(new EliteSelection(1, new Nsga2Selection()).sortsIntoFronts());
        Assertions.assertFalse(new TournamentSelection(2).sortsIntoFronts());
    }
}
