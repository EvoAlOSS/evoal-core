package de.evoal.optimisation.api.evaluation;

/**
 * What happens if an evaluation budget runs out in the middle of an iteration.
 */
public enum ExhaustionPolicy {
    /**
     * The iteration is finished, so a run can use more evaluations than the budget.
     *   The run stops after the iteration.
     */
    FINISH_ITERATION,

    /**
     * A run never uses more evaluations than the budget. The run stops immediately
     *   and records the partial iteration.
     */
    CUT_OFF
}
