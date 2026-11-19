package de.evoal.optimisation.main.fitness;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.TestConstraints;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.fitness.ChangesUnits;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessContext;
import de.evoal.optimisation.api.fitness.FitnessLayout;

/**
 * The static penalty {@link ConstraintPenaltyStep}.
 */
public class ConstraintPenaltyStepTest {
    private static final FitnessLayout LAYOUT = new FitnessLayout(List.of(FitnessComponent.named("f1"),
                                                                          FitnessComponent.named("f2")));

    private final Constraints constraints = TestConstraints.constraints("strict", "vague", "strict");

    private static FitnessContext context(final ViolationRecord violations) {
        return new FitnessContext(null, null, null, violations);
    }

    @Nested
    @DisplayName("given a penalty with weight 10 on the group 'strict'")
    class Penalty {
        private final ConstraintPenaltyStep step = new ConstraintPenaltyStep("strict", 10.0);

        private final Fitness fitness = new Fitness(LAYOUT, new double[] {1.0, 2.0});

        @Test
        public void theWeightedViolationIsAddedToEveryComponent() {
            // given
            final ViolationRecord violations = TestConstraints.record(constraints, 0.5, 100.0, 0.25);

            // when
            final Fitness penalised = step.apply(context(violations), fitness);

            // then
            Assertions.assertArrayEquals(new double[] {8.5, 9.5}, penalised.values());
            Assertions.assertEquals(LAYOUT, penalised.layout());
        }

        @Test
        public void aFeasibleCandidateKeepsItsFitness() {
            // given: only the other group is violated
            final ViolationRecord violations = TestConstraints.record(constraints, 0.0, 100.0, 0.0);

            // when
            final Fitness penalised = step.apply(context(violations), fitness);

            // then
            Assertions.assertSame(fitness, penalised);
        }

        @Test
        public void thePenaltyChangesTheUnits() {
            Assertions.assertInstanceOf(ChangesUnits.class, step);
        }
    }

    @Nested
    @DisplayName("given an invalid configuration")
    class Invalid {
        @Test
        public void aWeightOfZeroIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new ConstraintPenaltyStep("strict", 0.0));
        }

        @Test
        public void anUnknownGroupIsRejectedWhenApplied() {
            // given
            final ConstraintPenaltyStep step = new ConstraintPenaltyStep("unknown", 1.0);
            final Fitness fitness = new Fitness(LAYOUT, new double[] {1.0, 2.0});
            final ViolationRecord violations = TestConstraints.record(constraints, 0.0, 0.0, 0.0);

            // then
            Assertions.assertThrows(IllegalArgumentException.class, () -> step.apply(context(violations), fitness));
        }
    }
}
