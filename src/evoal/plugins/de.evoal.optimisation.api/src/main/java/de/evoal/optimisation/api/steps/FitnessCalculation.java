package de.evoal.optimisation.api.steps;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Evaluates the current candidates that are not evaluated yet. The candidates are passed to
 *   the {@link EvaluationService} as a batch, in their order, and the results come back in
 *   the same order. Evaluated candidates are not evaluated again.
 */
public final class FitnessCalculation implements Step {
    /**
     * Computes the optimisation values.
     */
    private final OptimisationValueComparator comparator;

    /**
     * Evaluates and counts the candidates.
     */
    private final EvaluationService evaluationService;

    /**
     * @param evaluationService Evaluates and counts the candidates.
     * @param comparator Computes the optimisation values.
     */
    public FitnessCalculation(final EvaluationService evaluationService, final OptimisationValueComparator comparator) {
        this.evaluationService = evaluationService;
        this.comparator = comparator;
    }

    @Override
    public String description() {
        return "evaluate the candidates";
    }

    /**
     * Evaluates the candidates in place; they stay the current candidates.
     *
     * @throws de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException if the
     *   budget runs out; the candidates evaluated before keep their evaluation.
     */
    @Override
    public void execute(final SearchState state) {
        for(final Candidate candidate : state.getCandidates()) {
            if(candidate.isEvaluated()) {
                continue;
            }

            final TypedEObject output = evaluationService.evaluate(candidate.input());
            final OptimisationValue value = comparator.apply(output);
            candidate.evaluate(output, value);
        }
    }

    @Override
    public String kind() {
        return "FitnessCalculation";
    }
}
