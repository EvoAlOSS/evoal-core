package de.evoal.optimisation.api.run;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

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
     * The candidate (a point of the search space).
     */
    private final TypedEObject input;

    /**
     * How the candidate came from other candidates.
     */
    private final Lineage lineage;

    /**
     * The result of the optimisation function, {@code null} before the evaluation.
     */
    private TypedEObject output;

    /**
     * The optimisation value of the output, {@code null} before the evaluation. It decides
     *   the ranking and the best individual so far.
     */
    private OptimisationValue value;

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
     * @param input The candidate (a point of the search space).
     * @param output The result of the optimisation function.
     * @param value The optimisation value of the output.
     * @param lineage How the candidate came from other candidates.
     * @return An evaluated candidate.
     */
    public static Candidate evaluated(final TypedEObject input,
                                      final TypedEObject output,
                                      final OptimisationValue value,
                                      final Lineage lineage) {
        final Candidate candidate = new Candidate(input, lineage);
        candidate.evaluate(output, value);

        return candidate;
    }

    /**
     * @return A new candidate with the same values and evaluation that is an identity of
     *   this candidate.
     */
    public Candidate copy() {
        final Candidate copy = new Candidate(input, Lineage.identity(this));
        copy.output = output;
        copy.value = value;

        return copy;
    }

    /**
     * Sets the result of the evaluation.
     *
     * @param output The result of the optimisation function.
     * @param value The optimisation value of the output.
     * @throws IllegalStateException if the candidate is already evaluated.
     */
    public void evaluate(final TypedEObject output, final OptimisationValue value) {
        if(isEvaluated()) {
            throw new IllegalStateException("The candidate " + input + " is already evaluated.");
        }

        this.output = output;
        this.value = value;
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
        return value != null;
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
        return output;
    }

    @Override
    public String toString() {
        return "Candidate[" + input + " -> " + value + "]";
    }

    /**
     * @return The optimisation value, {@code null} before the evaluation.
     */
    public OptimisationValue value() {
        return value;
    }
}
