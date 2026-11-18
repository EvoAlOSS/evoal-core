package de.evoal.optimisation.api.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import de.evoal.core.api.cdi.Component;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

/**
 * Evaluates a candidate: the {@link EvaluationService} computes the objectives, the
 *   {@link FitnessPipeline} the fitness and the comparator the optimisation value. Every
 *   algorithm evaluates its candidates with an evaluator, so the three always belong
 *   together.
 */
@Dependent
public class Evaluator {
    /**
     * Computes the optimisation value from the objectives and the fitness.
     */
    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    /**
     * Evaluates and counts the candidates.
     */
    @Inject
    private EvaluationService evaluationService;

    /**
     * Computes the fitness from the objectives.
     */
    @Inject
    private FitnessPipeline pipeline;

    /**
     * Creates an evaluator whose parts are injected.
     */
    public Evaluator() {
    }

    /**
     * Creates an evaluator from its parts.
     *
     * @param evaluationService Evaluates and counts the candidates.
     * @param pipeline Computes the fitness from the objectives.
     * @param comparator Computes the optimisation value from the objectives and the fitness.
     */
    public Evaluator(final EvaluationService evaluationService,
                     final FitnessPipeline pipeline,
                     final OptimisationValueComparator comparator) {
        this.evaluationService = evaluationService;
        this.pipeline = pipeline;
        this.comparator = comparator;
    }

    /**
     * Evaluates a candidate.
     *
     * @param input The candidate (a point of the search space).
     * @return The objectives, the fitness and the optimisation value.
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   evaluation budget is exhausted.
     */
    public Evaluation evaluate(final TypedEObject input) {
        final TypedEObject output = evaluationService.evaluate(input);
        final Fitness fitness = pipeline.apply(input, output);
        final OptimisationValue value = comparator.toValue(output, fitness);

        return new Evaluation(output, fitness, value);
    }
}
