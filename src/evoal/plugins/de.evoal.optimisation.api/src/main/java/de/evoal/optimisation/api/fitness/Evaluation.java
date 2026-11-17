package de.evoal.optimisation.api.fitness;

import java.util.Objects;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

/**
 * The result of evaluating a candidate ({@link Evaluator}).
 *
 * @param output The result of the optimisation function (the objectives).
 * @param fitness The fitness computed by the {@link FitnessPipeline}.
 * @param value The optimisation value computed by the comparator; it decides the ranking.
 */
public record Evaluation(TypedEObject output, Fitness fitness, OptimisationValue value) {
    /**
     * Requires all parts.
     */
    public Evaluation {
        Objects.requireNonNull(output, "output");
        Objects.requireNonNull(fitness, "fitness");
        Objects.requireNonNull(value, "value");
    }
}
