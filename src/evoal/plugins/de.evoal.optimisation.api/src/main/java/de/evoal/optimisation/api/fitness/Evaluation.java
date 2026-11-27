package de.evoal.optimisation.api.fitness;

import java.util.Objects;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.constraints.ViolationRecord;

/**
 * The result of evaluating a candidate ({@link Evaluator}).
 *
 * @param output The objectives: the result of the optimisation function, or the aggregate of
 *   its results if the candidate was evaluated several times ({@link ObjectiveSamples}).
 * @param fitness The fitness computed by the {@link FitnessPipeline}.
 * @param value The optimisation value computed by the comparator; it decides the ranking.
 * @param violations How far the candidate violates the constraints of the problem.
 * @param samples The results of the evaluations of the candidate; their aggregate is the
 *   output.
 */
public record Evaluation(TypedEObject output, Fitness fitness, OptimisationValue value, ViolationRecord violations,
                         ObjectiveSamples samples) {
    /**
     * Requires all parts and the output to be the aggregate of the samples.
     */
    public Evaluation {
        Objects.requireNonNull(output, "output");
        Objects.requireNonNull(fitness, "fitness");
        Objects.requireNonNull(value, "value");
        Objects.requireNonNull(violations, "violations");
        Objects.requireNonNull(samples, "samples");

        if(samples.aggregate() != output) {
            throw new IllegalArgumentException("The output is not the aggregate of the samples.");
        }
    }

    /**
     * Creates the evaluation of a candidate that was evaluated once.
     *
     * @param output The result of the optimisation function (the objectives).
     * @param fitness The fitness computed by the {@link FitnessPipeline}.
     * @param value The optimisation value computed by the comparator.
     * @param violations How far the candidate violates the constraints of the problem.
     */
    public Evaluation(final TypedEObject output, final Fitness fitness, final OptimisationValue value,
                      final ViolationRecord violations) {
        this(output, fitness, value, violations, ObjectiveSamples.single(output));
    }

    /**
     * Creates the evaluation of a candidate of a problem without constraints that was
     *   evaluated once.
     *
     * @param output The result of the optimisation function (the objectives).
     * @param fitness The fitness computed by the {@link FitnessPipeline}.
     * @param value The optimisation value computed by the comparator.
     */
    public Evaluation(final TypedEObject output, final Fitness fitness, final OptimisationValue value) {
        this(output, fitness, value, ViolationRecord.NONE);
    }
}
