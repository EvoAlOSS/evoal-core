package de.evoal.optimisation.api.constraints;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * The degrees, group violations and memory model properties of a {@link ViolationRecord}.
 */
public class ViolationRecordTest {
    private static Constraint constraint(final int number, final String group) {
        return new Constraint(number, group, "c" + number, ConstraintKind.INEQUALITY, false, List.of(), List.of(), Map.of(),
                              values -> 0.0, null);
    }

    @Nested
    @DisplayName("given three constraints in two groups")
    class TwoGroups {
        private final Constraints constraints = new Constraints(List.of(constraint(1, "strict"),
                                                                        constraint(2, "vague"),
                                                                        constraint(3, "strict")));

        @Test
        public void theViolationOfAGroupIsTheSumOfItsDegrees() {
            // given
            final ViolationRecord record = new ViolationRecord(constraints, new double[] {0.5, 2.0, 0.25});

            // when
            final double violation = record.violation("strict");

            // then
            Assertions.assertEquals(0.75, violation);
        }

        @Test
        public void theSquaredViolationOfAGroupIsTheSumOfItsSquaredDegrees() {
            // given
            final ViolationRecord record = new ViolationRecord(constraints, new double[] {0.5, 2.0, 3.0});

            // when
            final double violation = record.squaredViolation("strict");

            // then
            Assertions.assertEquals(0.25 + 9.0, violation);
            Assertions.assertThrows(IllegalArgumentException.class, () -> record.squaredViolation("unknown"));
        }

        @Test
        public void aGroupWithoutDegreesIsFeasibleWhileTheOtherIsNot() {
            // given
            final ViolationRecord record = new ViolationRecord(constraints, new double[] {0.0, 1.0, 0.0});

            // then
            Assertions.assertTrue(record.isFeasible("strict"));
            Assertions.assertFalse(record.isFeasible("vague"));
            Assertions.assertFalse(record.isFeasible());
        }

        @Test
        public void theDegreesAreThePropertiesInTheOrderOfTheConstraints() {
            // given
            final ViolationRecord record = new ViolationRecord(constraints, new double[] {0.0, 1.0, 3.0});

            // when
            final Map<String, Double> properties = record.toProperties();

            // then
            final List<String> names = List.copyOf(properties.keySet());
            Assertions.assertEquals(List.of("violation-1", "violation-2", "violation-3"), names);
            Assertions.assertEquals(List.of(0.0, 1.0, 3.0), List.copyOf(properties.values()));
        }

        @Test
        public void anUnknownGroupIsRejected() {
            // given
            final ViolationRecord record = new ViolationRecord(constraints, new double[] {0.0, 0.0, 0.0});

            // then
            Assertions.assertThrows(IllegalArgumentException.class, () -> record.violation("unknown"));
        }

        @Test
        public void aNegativeDegreeIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new ViolationRecord(constraints, new double[] {0.0, -1.0, 0.0}));
        }

        @Test
        public void aMissingDegreeIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new ViolationRecord(constraints, new double[] {0.0, 1.0}));
        }
    }

    @Nested
    @DisplayName("given constraints whose numbers are not their positions")
    class WrongNumbers {
        @Test
        public void theConstraintsAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new Constraints(List.of(constraint(2, "strict"))));
        }
    }

    @Nested
    @DisplayName("given a problem without constraints")
    class NoConstraints {
        @Test
        public void theEmptyRecordIsFeasibleAndHasNoProperties() {
            Assertions.assertTrue(ViolationRecord.NONE.isFeasible());
            Assertions.assertTrue(ViolationRecord.NONE.toProperties().isEmpty());
        }
    }
}
