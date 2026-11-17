package de.evoal.optimisation.api.run;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.events.RunEventDispatcher;

/**
 * The algorithm-specific part of a run, executed by the {@link OptimisationRun}.
 * <p>
 * {@link #initialise(RunEventDispatcher)} and {@link #iterate(int)} may throw an
 *   {@link EvaluationBudgetExhaustedException}. The kernel then still records the
 *   iteration with the {@link #population()} at that point and ends the run.
 */
public interface SearchProcedure {
    /**
     * Creates and evaluates the initial candidates (iteration 0).
     *
     * @param events Publishes the events of the procedure, e.g., its executed steps. The kernel
     *   passes the dispatcher of the run, so the procedure can keep it for the whole run.
     */
    void initialise(RunEventDispatcher events);

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
