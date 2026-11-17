package de.evoal.optimisation.api.run;

/**
 * Whether the search can continue after an iteration.
 */
public enum Progress {
    /**
     * The search can continue; the termination criterion decides.
     */
    CONTINUE,

    /**
     * The search cannot continue, e.g., because a local search found no acceptable
     *   neighbour. The run ends after the current iteration.
     */
    STOP
}
