package de.evoal.optimisation.api.fitness;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import de.evoal.core.api.cdi.Component;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

/**
 * Evaluates a candidate: the {@link EvaluationService} computes the objectives, the
 *   {@link FitnessPipeline} the fitness and the comparator the optimisation value. Every
 *   algorithm evaluates its candidates with an evaluator, so the three always belong
 *   together.
 * <p>
 * {@link #evaluateAll(List)} computes the objectives of a batch in parallel
 *   ({@link EvaluationService#evaluateAll(List)}); the fitness and the optimisation values are
 *   computed afterwards on the calling thread, in input order.
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

    /**
     * Evaluates a batch of candidates. If a budget with the policy {@code cut-off} does not
     *   cover all candidates, the first candidates that it covers are evaluated and the result
     *   contains the exhaustion, so the evaluations equal the ones of a sequential run.
     *
     * @param inputs The candidates (points of the search space).
     * @return The evaluations of the first candidates and the exhaustion of the budget, if any.
     * @throws RuntimeException the failure of the evaluation with the lowest index, after all
     *   evaluations of the batch have ended.
     */
    public BatchEvaluation evaluateAll(final List<TypedEObject> inputs) {
        final OptionalLong remaining = evaluationService.remainingEvaluations();
        final int covered = (int) Math.min(inputs.size(), remaining.orElse(Long.MAX_VALUE));

        final List<TypedEObject> evaluated = inputs.subList(0, covered);
        final List<TypedEObject> outputs = evaluationService.evaluateAll(evaluated);

        final List<Evaluation> evaluations = new ArrayList<>(covered);
        for(int i = 0; i < covered; ++i) {
            final TypedEObject input = evaluated.get(i);
            final TypedEObject output = outputs.get(i);
            final Fitness fitness = pipeline.apply(input, output);

            evaluations.add(new Evaluation(output, fitness, comparator.toValue(output, fitness)));
        }

        return new BatchEvaluation(evaluations, covered < inputs.size() ? exhaustionFor(inputs.subList(covered, inputs.size())) : null);
    }

    /**
     * @return The exhaustion that the service reports for the candidates beyond the budget. The
     *   service rejects them before evaluating any of them.
     */
    private EvaluationBudgetExhaustedException exhaustionFor(final List<TypedEObject> beyondBudget) {
        try {
            evaluationService.evaluateAll(beyondBudget);
        } catch(final EvaluationBudgetExhaustedException e) {
            return e;
        }

        throw new IllegalStateException("The budget allowed more evaluations than reported.");
    }
}
