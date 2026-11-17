package de.evoal.optimisation.api.run;

import lombok.NonNull;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Fitness;

/**
 * A candidate of the search, evaluated or not. The members of a {@link Population} are
 *   evaluated candidates; the kernel turns them into the individuals of the memory model.
 * <p>
 * A candidate is identified by its object, not by its values: the {@link Lineage} of other
 *   candidates refers to it, and the kernel maps it to its individual. A candidate that
 *   stays unchanged in the next step or iteration is therefore a {@link #copy()} that refers
 *   to it as identity.
 */
public final class Candidate {
    /**
     * The evaluation of the candidate, {@code null} before the evaluation.
     */
    private Evaluation evaluation;

    /**
     * The candidate (a point of the search space).
     */
    private final TypedEObject input;

    /**
     * How the candidate came from other candidates.
     */
    private final Lineage lineage;

    /**
     * Creates a candidate that is not evaluated yet.
     *
     * @param input The candidate (a point of the search space).
     * @param lineage How the candidate came from other candidates.
     */
    public Candidate(final TypedEObject input, final Lineage lineage) {
        this.input = input;
        this.lineage = lineage;
    }

    /**
     * @return A new candidate with the same values and evaluation that is an identity of
     *   this candidate.
     */
    public Candidate copy() {
        final Candidate copy = new Candidate(input, Lineage.identity(this));
        copy.evaluation = evaluation;

        return copy;
    }

    /**
     * Sets the result of the evaluation.
     *
     * @param evaluation The evaluation of the candidate.
     * @throws IllegalStateException if the candidate is already evaluated.
     */
    public void evaluate(final @NonNull Evaluation evaluation) {
        if(isEvaluated()) {
            throw new IllegalStateException("The candidate " + input + " is already evaluated.");
        }

        this.evaluation = evaluation;
    }

    /**
     * @param input The candidate (a point of the search space).
     * @param evaluation The evaluation of the candidate.
     * @param lineage How the candidate came from other candidates.
     * @return An evaluated candidate.
     */
    public static Candidate evaluated(final TypedEObject input, final Evaluation evaluation, final Lineage lineage) {
        final Candidate candidate = new Candidate(input, lineage);
        candidate.evaluate(evaluation);

        return candidate;
    }

    /**
     * @return The evaluation, {@code null} before the evaluation.
     */
    public Evaluation evaluation() {
        return evaluation;
    }

    /**
     * @return The fitness, {@code null} before the evaluation.
     */
    public Fitness fitness() {
        return isEvaluated() ? evaluation.fitness() : null;
    }

    /**
     * @return The candidate (a point of the search space).
     */
    public TypedEObject input() {
        return input;
    }

    /**
     * @return Whether the candidate is evaluated.
     */
    public boolean isEvaluated() {
        return evaluation != null;
    }

    /**
     * @return How the candidate came from other candidates.
     */
    public Lineage lineage() {
        return lineage;
    }

    /**
     * @return The result of the optimisation function, {@code null} before the evaluation.
     */
    public TypedEObject output() {
        return isEvaluated() ? evaluation.output() : null;
    }

    @Override
    public String toString() {
        return "Candidate[" + input + " -> " + value() + "]";
    }

    /**
     * @return The optimisation value, {@code null} before the evaluation. It decides the
     *   ranking and the best individual so far.
     */
    public OptimisationValue value() {
        return isEvaluated() ? evaluation.value() : null;
    }
}
