package de.evoal.optimisation.cma_es.main.restart;

import java.util.Optional;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

/**
 * No restart (DL type {@code 'no-restart'}): the search ends when a termination criterion of
 *   CMA-ES ends the first run.
 */
@Dependent
@Named("de.evoal.optimisation.cma_es.optimisation.no-restart")
public class NoRestart implements RestartStrategy {
    @Override
    public boolean restarts() {
        return false;
    }

    @Override
    public RestartSchedule schedule(final int defaultPopulationSize) {
        return new RestartSchedule() {
            @Override
            public RunSetting first() {
                return RunSetting.of(defaultPopulationSize);
            }

            @Override
            public Optional<RunSetting> next(final long evaluations, final RandomGenerator random) {
                return Optional.empty();
            }
        };
    }
}
