package de.evoal.optimisation.api.run;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.NonNull;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.constraints.PartialViolationRecord;
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
 * The {@link #lineage()} relates a candidate to the population of the previous iteration; the
 *   final version of the memory model records it. If a candidate came from another candidate
 *   of the same iteration in a different way, e.g., a mutated child from the recombined child
 *   of an earlier step, it also has a {@link #stepLineage()}, the relationship to its direct
 *   predecessor; the steps version of the memory model records that one.
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
     * How the candidate came from other candidates, related to the previous iteration;
     *   {@link Lineage#RECORDED} once its iteration is recorded.
     */
    private Lineage lineage;

    /**
     * The degrees of the constraints measured before the evaluation.
     */
    private PartialViolationRecord measuredViolations = PartialViolationRecord.EMPTY;

    /**
     * Further details of the candidate, by property name, in insertion order.
     */
    private final Map<String, Object> properties = new LinkedHashMap<>();

    /**
     * How the candidate came from its direct predecessor in the iteration; {@code null} if it is
     *   the {@link #lineage}.
     */
    private Lineage stepLineage;

    /**
     * Creates a candidate that is not evaluated yet.
     *
     * @param input The candidate (a point of the search space).
     * @param lineage How the candidate came from other candidates.
     */
    public Candidate(final TypedEObject input, final Lineage lineage) {
        this(input, lineage, null, 0);
    }

    /**
     * Creates a candidate that is not evaluated yet and that came from a candidate of the same
     *   iteration in another way than from the previous iteration, e.g., a mutated child of a
     *   recombined child.
     *
     * @param input The candidate (a point of the search space).
     * @param lineage How the candidate came from the population of the previous iteration.
     * @param stepLineage How the candidate came from its direct predecessor in the iteration.
     */
    public Candidate(final TypedEObject input, final Lineage lineage, final @NonNull Lineage stepLineage) {
        this(input, lineage, stepLineage, 0);
    }

    private Candidate(final TypedEObject input, final Lineage lineage, final Lineage stepLineage, final int age) {
        this.input = input;
        this.lineage = lineage;
        this.stepLineage = stepLineage;
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
        final Candidate copy = new Candidate(input, Lineage.identity(this), null, age);
        copy.evaluation = evaluation;

        return copy;
    }

    /**
     * Adds degrees of constraints measured before the evaluation, e.g., by a
     *   {@code 'constraint-check'}. The evaluation takes them over instead of measuring the
     *   constraints again.
     *
     * @param measured The measured degrees; they replace earlier degrees of the same
     *   constraints.
     * @throws IllegalStateException if the candidate is already evaluated.
     */
    public void addMeasuredViolations(final @NonNull PartialViolationRecord measured) {
        if(isEvaluated()) {
            throw new IllegalStateException("The candidate " + input + " is already evaluated.");
        }

        measuredViolations = measuredViolations.merge(measured);
    }

    /**
     * @return The degrees of the constraints measured before the evaluation; empty if none
     *   were measured.
     */
    public PartialViolationRecord measuredViolations() {
        return measuredViolations;
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
     * @return How the candidate came from its direct predecessor in the iteration: the
     *   {@link #lineage()}, unless the candidate was created with a step lineage of its own.
     */
    public Lineage stepLineage() {
        return stepLineage == null ? lineage : stepLineage;
    }

    /**
     * @return A {@link #copy()} for the next iteration: the candidate was carried over
     *   unchanged, so its age grows by one.
     */
    public Candidate survivor() {
        final Candidate survivor = new Candidate(input, Lineage.identity(this), null, age + 1);
        survivor.evaluation = evaluation;

        return survivor;
    }

    /**
     * @param evaluation The evaluation that also holds the further samples of the candidate.
     * @param relationship The property of the relationship that marks the re-evaluation.
     * @return The candidate evaluated once more, e.g., a member of the population with the
     *   strategy {@code 're-evaluation'}: the same input, lineage (with the property set to
     *   {@code true}), age, measured violations and properties, with the new evaluation.
     */
    public Candidate reEvaluated(final @NonNull Evaluation evaluation, final @NonNull String relationship) {
        final Lineage stepLineageOfCopy = stepLineage == null ? null : stepLineage.withProperty(relationship, true);
        final Candidate candidate = new Candidate(input, lineage.withProperty(relationship, true), stepLineageOfCopy, age);
        candidate.evaluation = evaluation;
        candidate.measuredViolations = measuredViolations;
        candidate.properties.putAll(properties);

        return candidate;
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
     * @return How the candidate came from other candidates, related to the population of the
     *   previous iteration.
     */
    public Lineage lineage() {
        return lineage;
    }

    /**
     * Forgets the predecessors once the iteration of the candidate is recorded: its lineage
     *   becomes {@link Lineage#RECORDED}. Otherwise a candidate keeps all its ancestors in
     *   memory, e.g., a candidate carried over for k iterations is a chain of k candidates.
     *   Its successors in the next iteration still refer to it, so they can be recorded.
     */
    public void forgetPredecessors() {
        lineage = Lineage.RECORDED;
        stepLineage = null;
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
