package de.evoal.optimisation.main.comparator;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.TestConstraints;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;

/**
 * The feasibility rules ({@link FeasibilityComparator}) and the epsilon-level comparison
 *   ({@link EpsilonComparator}) on a single fitness component and the group {@code g} of two
 *   constraints.
 */
public class FeasibilityComparatorsTest {
    private static final FitnessLayout LAYOUT = new FitnessLayout(List.of(FitnessComponent.named("f")));

    private final Constraints constraints = TestConstraints.constraints("g", "g");

    private final TypedEObject objectives = Mockito.mock(TypedEObject.class);

    private FeasibilityValue valueOf(final AbstractFeasibilityComparator comparator, final double fitness,
                                     final double violation) {
        final Fitness canonical = new Fitness(LAYOUT, new double[] {fitness});
        final ViolationRecord record = TestConstraints.record(constraints, violation, 0.0);

        return comparator.toValue(objectives, canonical, record);
    }

    @Nested
    @DisplayName("given the feasibility rules")
    class FeasibilityRules {
        private final FeasibilityComparator comparator = new FeasibilityComparator("g");

        @Test
        public void aFeasibleCandidateIsBetterThanAnInfeasibleOneWithBetterFitness() {
            // given
            final FeasibilityValue feasible = valueOf(comparator, 10.0, 0.0);
            final FeasibilityValue infeasible = valueOf(comparator, 1.0, 0.1);

            // then
            Assertions.assertTrue(feasible.isBetter(infeasible));
            Assertions.assertFalse(infeasible.isBetter(feasible));
        }

        @Test
        public void twoFeasibleCandidatesAreComparedByFitness() {
            // given
            final FeasibilityValue better = valueOf(comparator, 1.0, 0.0);
            final FeasibilityValue worse = valueOf(comparator, 2.0, 0.0);

            // then
            Assertions.assertTrue(better.isBetter(worse));
            Assertions.assertEquals(1.0, better.distanceFrom(worse));
        }

        @Test
        public void twoInfeasibleCandidatesAreComparedByViolation() {
            // given
            final FeasibilityValue smallerViolation = valueOf(comparator, 10.0, 0.5);
            final FeasibilityValue largerViolation = valueOf(comparator, 1.0, 2.0);

            // then
            Assertions.assertTrue(smallerViolation.isBetter(largerViolation));
            Assertions.assertEquals(1.5, smallerViolation.distanceFrom(largerViolation));
        }

        @Test
        public void twoInfeasibleCandidatesWithTheSameViolationAreEqual() {
            // given
            final FeasibilityValue first = valueOf(comparator, 1.0, 0.5);
            final FeasibilityValue second = valueOf(comparator, 2.0, 0.5);

            // then
            Assertions.assertEquals(0, first.compareTo(second));
        }

        @Test
        public void aValueWithoutViolationRecordIsRejected() {
            // given
            final Fitness canonical = new Fitness(LAYOUT, new double[] {1.0});

            // then
            Assertions.assertThrows(IllegalStateException.class, () -> comparator.toValue(objectives, canonical));
        }
    }

    @Nested
    @DisplayName("given the epsilon-level comparison with epsilon 0.5")
    class EpsilonLevel {
        private final EpsilonComparator comparator = new EpsilonComparator("g", 0.5);

        @Test
        public void aViolationUpToEpsilonCountsAsFeasible() {
            // given
            final FeasibilityValue withinEpsilon = valueOf(comparator, 1.0, 0.5);
            final FeasibilityValue feasible = valueOf(comparator, 2.0, 0.0);

            // then: both count as feasible, so the fitness decides
            Assertions.assertTrue(withinEpsilon.isBetter(feasible));
        }

        @Test
        public void aViolationBeyondEpsilonIsWorseThanOneWithinEpsilon() {
            // given
            final FeasibilityValue withinEpsilon = valueOf(comparator, 10.0, 0.25);
            final FeasibilityValue beyondEpsilon = valueOf(comparator, 1.0, 0.75);

            // then
            Assertions.assertTrue(withinEpsilon.isBetter(beyondEpsilon));
        }

        @Test
        public void twoCandidatesWithTheSameViolationAreComparedByFitness() {
            // given
            final FeasibilityValue better = valueOf(comparator, 1.0, 2.0);
            final FeasibilityValue worse = valueOf(comparator, 2.0, 2.0);

            // then
            Assertions.assertTrue(better.isBetter(worse));
        }

        @Test
        public void aNegativeEpsilonIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new EpsilonComparator("g", -0.1));
        }
    }
}
