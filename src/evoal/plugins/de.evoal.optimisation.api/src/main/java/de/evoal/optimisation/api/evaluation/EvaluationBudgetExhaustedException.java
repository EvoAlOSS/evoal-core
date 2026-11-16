package de.evoal.optimisation.api.evaluation;

import lombok.Getter;

/**
 * Thrown by the {@link EvaluationService} instead of an evaluation that would exceed a
 *   budget with the policy {@link ExhaustionPolicy#CUT_OFF}. The algorithm records the
 *   partial iteration and stops.
 */
public class EvaluationBudgetExhaustedException extends RuntimeException {
    /**
     * The maximum number of evaluations.
     */
    @Getter
    private final long budget;

    /**
     * The source whose budget is exhausted.
     */
    @Getter
    private final EvaluationSource source;

    /**
     * @param source The source whose budget is exhausted.
     * @param budget The maximum number of evaluations.
     */
    public EvaluationBudgetExhaustedException(final EvaluationSource source, final long budget) {
        super("The budget of " + budget + " for '" + source.getMetricName() + "' is exhausted.");

        this.source = source;
        this.budget = budget;
    }
}
