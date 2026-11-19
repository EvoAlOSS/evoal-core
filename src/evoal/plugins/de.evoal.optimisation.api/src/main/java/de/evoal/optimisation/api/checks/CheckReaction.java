package de.evoal.optimisation.api.checks;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * The reaction to a candidate that fails a {@link CandidateCheck} (DL enumeration
 *   {@code 'check-reaction'}).
 */
public enum CheckReaction {
    /**
     * The failure is reported; the candidate stays unchanged.
     */
    WARN("warn"),

    /**
     * A new candidate from the replacement source takes the place of the failed one.
     */
    REPLACE("replace"),

    /**
     * The variation is redone, with a bounded number of attempts.
     */
    RESAMPLE("resample"),

    /**
     * The candidate is repaired by the repair strategy of the check.
     */
    REPAIR("repair");

    /**
     * The name of the literal in the DL.
     */
    private final String literal;

    CheckReaction(final String literal) {
        this.literal = literal;
    }

    /**
     * @param literal A literal of the DL enumeration {@code 'check-reaction'}.
     * @return The corresponding reaction.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static CheckReaction of(final EEnumLiteral literal) {
        return of(literal.getName());
    }

    /**
     * @param literal The name of a literal of the DL enumeration {@code 'check-reaction'}.
     * @return The corresponding reaction.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static CheckReaction of(final String literal) {
        for(final CheckReaction reaction : values()) {
            if(reaction.literal.equals(literal)) {
                return reaction;
            }
        }

        throw new IllegalArgumentException("Unknown check reaction '" + literal + "'.");
    }

    /**
     * @return The name of the literal in the DL.
     */
    @Override
    public String toString() {
        return literal;
    }
}
