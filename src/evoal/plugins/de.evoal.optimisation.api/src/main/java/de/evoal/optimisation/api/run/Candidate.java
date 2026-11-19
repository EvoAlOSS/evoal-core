package de.evoal.optimisation.api.run;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

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
 * <p>
 * The <em>age</em> of a candidate is the number of iterations it was carried over into
 *   unchanged ({@link #survivor()}). A new candidate, e.g., a mutated, recombined or
 *   replacing one, has age 0.
 */
public final class Candidate {
    /**
     * The number of iterations the candidate was carried over into unchanged.
     */
    private final int age;

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
     * Further details of the candidate, by property name, in insertion order.
     */
    private final Map<String, Object> properties = new LinkedHashMap<>();

    /**
     * Creates a candidate that is not evaluated yet.
     *
     * @param input The candidate (a point of the search space).
     * @param lineage How the candidate came from other candidates.
     */
    public Candidate(final TypedEObject input, final Lineage lineage) {
        this(input, lineage, 0);
    }

    private Candidate(final TypedEObject input, final Lineage lineage, final int age) {
        this.input = input;
        this.lineage = lineage;
        this.age = age;
    }

    /**
     * @return The number of iterations the candidate was carried over into unchanged.
     */
    public int age() {
        return age;
    }

    /**
     * @return A new candidate with the same values, evaluation and age that is an identity of
     *   this candidate. Its properties are not copied.
     */
    public Candidate copy() {
        final Candidate copy = new Candidate(input, Lineage.identity(this), age);
        copy.evaluation = evaluation;

        return copy;
    }

    /**
     * @return Further details of the candidate, by property name, in insertion order. The
     *   kernel records them on the individual of the memory model; every name has to be
     *   defined with the scope {@code INDIVIDUAL}
     *   ({@link de.evoal.optimisation.api.execution.ExecutionRecorder#defineProperty}).
     */
    public Map<String, Object> properties() {
        return Collections.unmodifiableMap(properties);
    }

    /**
     * Sets a property of the candidate.
     *
     * @param name The name of the property.
     * @param value The value of the property.
     */
    public void setProperty(final @NonNull String name, final @NonNull Object value) {
        properties.put(name, value);
    }

    /**
     * @return A {@link #copy()} for the next iteration: the candidate was carried over
     *   unchanged, so its age grows by one.
     */
    public Candidate survivor() {
        final Candidate survivor = new Candidate(input, Lineage.identity(this), age + 1);
        survivor.evaluation = evaluation;

        return survivor;
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
