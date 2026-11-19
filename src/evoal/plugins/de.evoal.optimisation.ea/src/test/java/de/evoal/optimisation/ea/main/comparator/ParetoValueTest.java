package de.evoal.optimisation.ea.main.comparator;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.ea.Candidates;

/**
 * The value of {@code 'crowded-comparator'}: Pareto dominance on the canonical fitness.
 */
class ParetoValueTest {
    private static OptimisationValue value(final double f1, final double f2) {
        return Candidates.withTwoComponents(f1, f2).value();
    }

    @Test
    @DisplayName("a dominating value is better, a dominated one worse")
    void dominance() {
        Assertions.assertTrue(value(1, 2).isBetter(value(2, 2)));
        Assertions.assertTrue(value(2, 2).isWorse(value(1, 2)));
    }

    @Test
    @DisplayName("incomparable and equal values compare as equal")
    void incomparable() {
        Assertions.assertTrue(value(1, 3).isEqual(value(3, 1)));
        Assertions.assertTrue(value(1, 3).isEqual(value(1, 3)));
    }

    @Test
    @DisplayName("the distance is the sum of the absolute differences")
    void distance() {
        Assertions.assertEquals(3.0, ((ParetoValue) value(1, 3)).distanceFrom(value(2, 1)), 1e-12);
    }

    @Test
    @DisplayName("with violations, a feasible value is better than a dominating infeasible one")
    void constrainedDominance() {
        final Fitness dominated = Candidates.withTwoComponents(5, 5).fitness();
        final Fitness dominating = Candidates.withTwoComponents(1, 1).fitness();
        final OptimisationValue feasible = new ParetoValue(null, dominated, List.of(), 0.0);
        final OptimisationValue infeasible = new ParetoValue(null, dominating, List.of(), 0.5);

        Assertions.assertTrue(feasible.isBetter(infeasible));
        Assertions.assertTrue(infeasible.isWorse(feasible));
    }
}
