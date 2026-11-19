package de.evoal.optimisation.api.fitness;

import java.util.Objects;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.constraints.ViolationRecord;

/**
 * The result of evaluating a candidate ({@link Evaluator}).
 *
 * @param output The result of the optimisation function (the objectives).
 * @param fitness The fitness computed by the {@link FitnessPipeline}.
 * @param value The optimisation value computed by the comparator; it decides the ranking.
 * @param violations How far the candidate violates the constraints of the problem.
 */
public record Evaluation(TypedEObject output, Fitness fitness, OptimisationValue value, ViolationRecord violations) {
    /**
     * Requires all parts.
     */
    public Evaluation {
        Objects.requireNonNull(output, "output");
        Objects.requireNonNull(fitness, "fitness");
        Objects.requireNonNull(value, "value");
        Objects.requireNonNull(violations, "violations");
    }

    /**
     * Creates the evaluation of a candidate of a problem without constraints.
     *
     * @param output The result of the optimisation function (the objectives).
     * @param fitness The fitness computed by the {@link FitnessPipeline}.
     * @param value The optimisation value computed by the comparator.
     */
    public Evaluation(final TypedEObject output, final Fitness fitness, final OptimisationValue value) {
        this(output, fitness, value, ViolationRecord.NONE);
    }
}
