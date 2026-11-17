package de.evoal.optimisation.api.run;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;

/**
 * The algorithm-specific part of a run, executed by the {@link OptimisationRun}.
 * <p>
 * {@link #initialise()} and {@link #iterate(int)} may throw an
 *   {@link EvaluationBudgetExhaustedException}. The kernel then still records the
 *   iteration with the {@link #population()} at that point and ends the run.
 */
public interface SearchProcedure {
    /**
     * Creates and evaluates the initial candidates (iteration 0).
     */
    void initialise();

    /**
     * Executes an iteration.
     *
     * @param iteration The number of the iteration, starting at 1.
     * @return Whether the search can continue.
     */
    Progress iterate(int iteration);

    /**
     * Describes the current population. The kernel calls it exactly once after every
     *   iteration; the lineage of its members refers to the members of the previous call
     *   (or to unchanged copies of them).
     *
     * @return The current population.
     */
    Population population();
}
