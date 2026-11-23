package de.evoal.core.api.validation.constraints;

import lombok.NonNull;

/**
 * The configured checker of a constraint annotation together with the annotation's
 *   {@code severity}, which is common to all annotations and therefore not read by the
 *   checker itself.
 *
 * @param checker The configured checker.
 * @param severity How serious a violation is.
 */
public record ConfiguredChecker(@NonNull ConstraintCheckerComponent checker, @NonNull Severity severity) {
    /**
     * Checks a value with the checker, see {@link ConstraintCheckerComponent#check(Object)}.
     */
    public ConstraintCheck check(final Object value) {
        return checker.check(value);
    }
}
