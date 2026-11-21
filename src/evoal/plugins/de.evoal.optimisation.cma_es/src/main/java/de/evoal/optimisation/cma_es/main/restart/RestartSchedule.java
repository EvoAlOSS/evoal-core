package de.evoal.optimisation.cma_es.main.restart;

import java.util.Optional;
import java.util.random.RandomGenerator;

/**
 * The sequence of runs of a restart strategy within one optimisation run. A new schedule is
 *   created for every optimisation run.
 */
public interface RestartSchedule {
    /**
     * @return The setting of the first run.
     */
    RunSetting first();

    /**
     * @param evaluations The number of evaluations of the run that just ended.
     * @param random The random numbers of the strategy.
     * @return The setting of the next run, or empty if the strategy does not restart.
     */
    Optional<RunSetting> next(long evaluations, RandomGenerator random);
}
