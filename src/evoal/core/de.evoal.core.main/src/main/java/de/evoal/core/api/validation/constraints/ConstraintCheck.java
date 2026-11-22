package de.evoal.core.api.validation.constraints;

import lombok.NonNull;

/**
 * The result of checking a value against a DL constraint annotation
 *   ({@link ConstraintCheckerComponent#check(Object)}).
 */
public sealed interface ConstraintCheck {
    /**
     * The value satisfies the constraint.
     */
    record Satisfied() implements ConstraintCheck {}

    /**
     * The value violates the constraint.
     *
     * @param message Describes the violation, e.g. "is 1.3, but must be <= 1.0".
     */
    record Violated(@NonNull String message) implements ConstraintCheck {}

    /**
     * The value cannot be checked before the run, e.g., a data reference or an expression
     *   that is evaluated per sample.
     *
     * @param reason Why the value cannot be checked.
     */
    record NotCheckable(@NonNull String reason) implements ConstraintCheck {}

    static ConstraintCheck satisfied() {
        return new Satisfied();
    }

    static ConstraintCheck violated(final String message) {
        return new Violated(message);
    }

    static ConstraintCheck notCheckable(final String reason) {
        return new NotCheckable(reason);
    }
}
