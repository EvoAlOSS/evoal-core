package de.evoal.optimisation.cma_es.main.restart;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * What CMA-ES does when one of its termination criteria ends a run (DL type
 *   {@code 'restart-strategy'}).
 */
public interface RestartStrategy extends EvoalComponent<RestartStrategy> {
    /**
     * @return Whether the strategy restarts at all.
     */
    boolean restarts();

    /**
     * @param defaultPopulationSize The population size of the configuration (lambda_default).
     * @return A new schedule for one optimisation run.
     */
    RestartSchedule schedule(int defaultPopulationSize);
}
