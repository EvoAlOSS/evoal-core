package de.evoal.optimisation.ea.api.selection;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Non-dominated sorting and crowding distance with hand-calculated fronts.
 */
class ParetoFrontsTest {
    /**
     * Six points (f1, f2), both minimised:
     * <ul>
     *   <li>0 (1, 5), 1 (2, 3), 2 (4, 1) and 5 (2, 3) form the first front (1 and 5 are equal),</li>
     *   <li>3 (3, 4) is dominated by 1 and 5,</li>
     *   <li>4 (5, 5) is dominated by 3.</li>
     * </ul>
     */
    static final List<double[]> POINTS = List.of(new double[] {1, 5}, new double[] {2, 3}, new double[] {4, 1},
                                                 new double[] {3, 4}, new double[] {5, 5}, new double[] {2, 3});

    @Test
    @DisplayName("dominance needs one better and no worse component")
    void dominance() {
        Assertions.assertTrue(ParetoFronts.dominates(new double[] {1, 2}, new double[] {1, 3}));
        Assertions.assertFalse(ParetoFronts.dominates(new double[] {1, 3}, new double[] {1, 2}));
        Assertions.assertFalse(ParetoFronts.dominates(new double[] {1, 2}, new double[] {1, 2}), "equal vectors");
        Assertions.assertFalse(ParetoFronts.dominates(new double[] {1, 3}, new double[] {2, 2}), "incomparable");
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> ParetoFronts.dominates(new double[] {1}, new double[] {1, 2}));
    }

    @Test
    @DisplayName("the fronts of the hand-calculated example, equal points in the same front")
    void fronts() {
        Assertions.assertEquals(List.of(List.of(0, 1, 2, 5), List.of(3), List.of(4)), ParetoFronts.fronts(POINTS));
    }

    @Test
    @DisplayName("mutually non-dominated points form one front")
    void oneFront() {
        final List<double[]> line = List.of(new double[] {0, 3}, new double[] {1, 2}, new double[] {2, 1}, new double[] {3, 0});
        Assertions.assertEquals(List.of(List.of(0, 1, 2, 3)), ParetoFronts.fronts(line));
    }

    @Test
    @DisplayName("a chain of dominated points gives one front per point")
    void chain() {
        final List<double[]> chain = List.of(new double[] {3, 3}, new double[] {1, 1}, new double[] {2, 2});
        Assertions.assertEquals(List.of(List.of(1), List.of(2), List.of(0)), ParetoFronts.fronts(chain));
    }

    @Test
    @DisplayName("crowding distance: infinite at the boundaries, normalised neighbour gaps inside")
    void crowdingDistance() {
        final double[] distances = ParetoFronts.crowdingDistances(POINTS, List.of(0, 1, 2, 5));

        // f1 sorted: 0 (1), 1 (2), 5 (2), 2 (4), range 3; f2 sorted: 2 (1), 1 (3), 5 (3), 0 (5), range 4
        Assertions.assertEquals(Double.POSITIVE_INFINITY, distances[0]);
        Assertions.assertEquals((2.0 - 1.0) / 3.0 + (3.0 - 1.0) / 4.0, distances[1], 1e-12);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, distances[2]);
        Assertions.assertEquals((4.0 - 2.0) / 3.0 + (5.0 - 3.0) / 4.0, distances[3], 1e-12);
    }

    @Test
    @DisplayName("fronts of one or two members have infinite crowding distances")
    void smallFronts() {
        Assertions.assertArrayEquals(new double[] {Double.POSITIVE_INFINITY},
                                     ParetoFronts.crowdingDistances(POINTS, List.of(3)));
        Assertions.assertArrayEquals(new double[] {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                                     ParetoFronts.crowdingDistances(POINTS, List.of(0, 2)));
    }

    @Test
    @DisplayName("a component without range adds nothing to the inner members")
    void noRange() {
        final List<double[]> points = List.of(new double[] {0, 1}, new double[] {1, 1}, new double[] {2, 1});
        final double[] distances = ParetoFronts.crowdingDistances(points, List.of(0, 1, 2));

        Assertions.assertEquals(Double.POSITIVE_INFINITY, distances[0]);
        Assertions.assertEquals((2.0 - 0.0) / 2.0, distances[1], 1e-12);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, distances[2]);
    }

    @Test
    @DisplayName("constrained domination: feasible beats infeasible, the smaller violation beats the larger")
    void constrainedDomination() {
        final double[] good = {1.0, 1.0};
        final double[] bad = {2.0, 2.0};

        Assertions.assertTrue(ParetoFronts.constrainedDominates(bad, 0.0, good, 0.5));
        Assertions.assertFalse(ParetoFronts.constrainedDominates(good, 0.5, bad, 0.0));
        Assertions.assertTrue(ParetoFronts.constrainedDominates(bad, 0.25, good, 0.5));
        Assertions.assertFalse(ParetoFronts.constrainedDominates(good, 0.5, bad, 0.5));
        Assertions.assertTrue(ParetoFronts.constrainedDominates(good, 0.0, bad, 0.0));
    }

    @Test
    @DisplayName("with violations, the feasible points form the first fronts, the infeasible ones follow by violation")
    void frontsWithViolations() {
        final List<double[]> fitness = List.of(new double[] {1, 1}, new double[] {2, 2}, new double[] {3, 0},
                                               new double[] {0, 0}, new double[] {0, 3});
        final double[] violations = {0.0, 0.0, 0.0, 0.5, 0.25};

        Assertions.assertEquals(List.of(List.of(0, 2), List.of(1), List.of(4), List.of(3)),
                                ParetoFronts.fronts(fitness, violations));
    }

    @Test
    @DisplayName("without violations, the fronts are the plain Pareto fronts")
    void frontsWithoutViolations() {
        final List<double[]> fitness = List.of(new double[] {1, 1}, new double[] {2, 2}, new double[] {0, 3});

        Assertions.assertEquals(ParetoFronts.fronts(fitness), ParetoFronts.fronts(fitness, new double[3]));
    }
}
