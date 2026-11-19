package de.evoal.optimisation.ea.api.selection;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.Candidates;

/**
 * The crowded-comparison operator and the assignment of fronts and crowding distances.
 */
class CrowdedOrderTest {
    private final CrowdedOrder order = new CrowdedOrder();

    private static Candidate ranked(final int front, final double distance) {
        final Candidate candidate = Candidates.withTwoComponents(0, 0);
        candidate.setProperty(CrowdedOrder.FRONT, (long) front);
        candidate.setProperty(CrowdedOrder.CROWDING_DISTANCE, distance);
        return candidate;
    }

    @Test
    @DisplayName("a lower front is better, whatever the crowding distance")
    void lowerFront() {
        Assertions.assertTrue(order.isBetter(ranked(0, 0.1), ranked(1, Double.POSITIVE_INFINITY)));
        Assertions.assertFalse(order.isBetter(ranked(1, Double.POSITIVE_INFINITY), ranked(0, 0.1)));
    }

    @Test
    @DisplayName("in the same front, a larger crowding distance is better; equal distances are equal")
    void sameFront() {
        Assertions.assertTrue(order.isBetter(ranked(2, 0.5), ranked(2, 0.4)));
        Assertions.assertTrue(order.isBetter(ranked(2, Double.POSITIVE_INFINITY), ranked(2, 0.4)));
        Assertions.assertEquals(0, order.compare(ranked(2, Double.POSITIVE_INFINITY), ranked(2, Double.POSITIVE_INFINITY)));
    }

    @Test
    @DisplayName("a member of the next population uses the front of the candidate it is a copy of")
    void survivorUsesPredecessor() {
        final Candidate selected = ranked(0, 1.0);
        final Candidate survivor = selected.survivor();

        Assertions.assertTrue(CrowdedOrder.isRanked(survivor));
        Assertions.assertTrue(order.isBetter(survivor, ranked(0, 0.5)));
    }

    @Test
    @DisplayName("a candidate without front cannot be compared")
    void unranked() {
        final Candidate unranked = Candidates.withTwoComponents(0, 0);

        Assertions.assertFalse(CrowdedOrder.isRanked(unranked));
        Assertions.assertThrows(IllegalStateException.class, () -> order.compare(unranked, ranked(0, 1.0)));
    }

    @Test
    @DisplayName("assign sets front and crowding distance of every candidate")
    void assign() {
        final List<Candidate> candidates = ParetoFrontsTest.POINTS.stream()
                                                                  .map(point -> Candidates.withTwoComponents(point[0], point[1]))
                                                                  .toList();

        Assertions.assertEquals(List.of(List.of(0, 1, 2, 5), List.of(3), List.of(4)), CrowdedOrder.assign(candidates));
        Assertions.assertEquals(List.of(0L, 0L, 0L, 1L, 2L, 0L),
                                candidates.stream().map(candidate -> candidate.properties().get(CrowdedOrder.FRONT)).toList());
        Assertions.assertEquals(Double.POSITIVE_INFINITY, candidates.get(4).properties().get(CrowdedOrder.CROWDING_DISTANCE));
        Assertions.assertEquals(1.0 / 3.0 + 0.5, (double) candidates.get(1).properties().get(CrowdedOrder.CROWDING_DISTANCE), 1e-12);
    }

    @Test
    @DisplayName("bestFirst sorts by front, then by descending crowding distance; ties keep their order")
    void bestFirst() {
        final Candidate a = ranked(1, 0.2);
        final Candidate b = ranked(0, 0.3);
        final Candidate c = ranked(0, Double.POSITIVE_INFINITY);
        final Candidate d = ranked(0, 0.3);

        Assertions.assertEquals(List.of(c, b, d, a), order.bestFirst(List.of(a, b, c, d)));
    }
}
