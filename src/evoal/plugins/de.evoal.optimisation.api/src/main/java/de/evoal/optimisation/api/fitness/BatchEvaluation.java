package de.evoal.optimisation.api.fitness;

import java.util.List;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;

/**
 * The result of {@link Evaluator#evaluateAll(List)}: the evaluations of the first inputs
 *   and, if the budget did not cover all inputs, the exhaustion of the budget.
 *
 * @param evaluations The evaluations of the first inputs, in input order. Without an
 *   exhaustion, there is one evaluation per input.
 * @param exhaustion The exhaustion of the budget that stopped the batch, {@code null} if all
 *   inputs are evaluated.
 */
public record BatchEvaluation(List<Evaluation> evaluations, EvaluationBudgetExhaustedException exhaustion) {
    public BatchEvaluation {
        evaluations = List.copyOf(evaluations);
    }

    /**
     * @return {@code true} iff the budget did not cover all inputs.
     */
    public boolean isExhausted() {
        return exhaustion != null;
    }

    /**
     * Throws the exhaustion of the budget, if any. Callers first keep the evaluations made,
     *   so that the result equals the one of a sequential evaluation.
     *
     * @throws EvaluationBudgetExhaustedException if the budget did not cover all inputs.
     */
    public void rethrowExhaustion() {
        if(exhaustion != null) {
            throw exhaustion;
        }
    }
}
