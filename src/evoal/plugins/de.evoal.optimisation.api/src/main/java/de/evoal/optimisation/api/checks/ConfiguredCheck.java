package de.evoal.optimisation.api.checks;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * A check of an algorithm together with the source of its replacements.
 *
 * @param check The check.
 * @param sources Creates the replacement source for a run; {@code null} if the reaction is
 *   not {@link CheckReaction#REPLACE}.
 */
public record ConfiguredCheck(CandidateCheck check, Supplier<ReplacementSource> sources) {
    /**
     * @throws IllegalArgumentException if a replacing check has no source.
     */
    public ConfiguredCheck {
        Objects.requireNonNull(check);

        if(check.reaction() == CheckReaction.REPLACE && sources == null) {
            throw new IllegalArgumentException("The check '" + check.name() + "' replaces candidates, but has no source.");
        }
    }

    /**
     * @param check A check whose reaction is not {@link CheckReaction#REPLACE}.
     * @return The check without replacement source.
     */
    public static ConfiguredCheck withoutSource(final CandidateCheck check) {
        return new ConfiguredCheck(check, null);
    }
}
