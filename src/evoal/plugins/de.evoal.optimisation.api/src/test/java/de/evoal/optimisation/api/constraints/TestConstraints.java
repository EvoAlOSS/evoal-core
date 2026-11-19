package de.evoal.optimisation.api.constraints;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Builds constraints and violation records for tests: every constraint has a constant normal
 *   form and reads no features.
 */
public final class TestConstraints {
    private TestConstraints() {
    }

    /**
     * @param groups The group of every constraint, in their order.
     * @return The constraints, numbered from 1.
     */
    public static Constraints constraints(final String... groups) {
        final List<Constraint> constraints = IntStream.range(0, groups.length)
                                                      .mapToObj(index -> constraint(index + 1, groups[index]))
                                                      .toList();

        return new Constraints(constraints);
    }

    /**
     * @param constraints The constraints.
     * @param degrees The degree of every constraint.
     * @return The violation record.
     */
    public static ViolationRecord record(final Constraints constraints, final double... degrees) {
        return new ViolationRecord(constraints, Arrays.copyOf(degrees, degrees.length));
    }

    private static Constraint constraint(final int number, final String group) {
        return new Constraint(number, group, "c" + number, ConstraintKind.INEQUALITY, false, List.of(), List.of(), Map.of(),
                              values -> 0.0, null);
    }
}
