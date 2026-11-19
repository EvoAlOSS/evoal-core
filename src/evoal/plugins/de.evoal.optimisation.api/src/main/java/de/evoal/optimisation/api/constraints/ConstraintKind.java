package de.evoal.optimisation.api.constraints;

/**
 * The kind of a {@link Constraint} in its normal form g >= 0 or g = 0.
 */
public enum ConstraintKind {
    /**
     * g = 0: the constraint is satisfied if |g| is at most the equality tolerance.
     */
    EQUALITY,

    /**
     * g >= 0: the constraint is satisfied if g is not negative.
     */
    INEQUALITY
}
