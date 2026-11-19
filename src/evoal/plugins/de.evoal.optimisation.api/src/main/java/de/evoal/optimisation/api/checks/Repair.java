package de.evoal.optimisation.api.checks;

import java.util.Objects;
import java.util.function.UnaryOperator;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * The repair of a check with the reaction {@link CheckReaction#REPAIR}: a strategy that
 *   changes a failed candidate, and the reaction if the candidate still fails after
 *   {@link CandidateCheck#maximumAttempts()} attempts.
 *
 * @param name The name of the strategy, recorded in the memory model, e.g.
 *   {@code projection-repair}.
 * @param attempt One attempt of the strategy: returns a changed copy of the candidate and
 *   leaves the candidate itself unchanged.
 * @param fallback The reaction if the repair fails; not {@link CheckReaction#REPAIR}.
 */
public record Repair(String name, UnaryOperator<TypedEObject> attempt, CheckReaction fallback) {
    /**
     * @throws IllegalArgumentException if the fallback is {@link CheckReaction#REPAIR}.
     */
    public Repair {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(attempt, "attempt");
        Objects.requireNonNull(fallback, "fallback");

        if(fallback == CheckReaction.REPAIR) {
            throw new IllegalArgumentException("The fallback of the repair '" + name + "' cannot be 'repair'.");
        }
    }
}
