package de.evoal.optimisation.cma_es.main;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import de.evoal.optimisation.api.steps.ParameterAdjustment;
import de.evoal.optimisation.api.steps.SearchState;

import de.evoal.optimisation.cma_es.main.distribution.TerminationCriteria;

/**
 * Checks the termination criteria of CMA-ES and the iteration limit of the current CMA-ES
 *   run (BIPOP). If one holds, the restart strategy starts the next CMA-ES run, or the search
 *   ends; it then samples no further candidates.
 */
@Slf4j
final class CheckTermination implements ParameterAdjustment {
    /**
     * The termination criteria.
     */
    private final TerminationCriteria criteria;

    /**
     * Whether the strategy restarts.
     */
    private final boolean restarts;

    CheckTermination(final TerminationCriteria criteria, final boolean restarts) {
        this.criteria = criteria;
        this.restarts = restarts;
    }

    @Override
    public String description() {
        return restarts ? "restart the distribution when a termination criterion of CMA-ES holds"
                        : "end the search when a termination criterion of CMA-ES holds";
    }

    @Override
    public void execute(final SearchState state) {
        final CmaEsRun run = SetUpDistribution.runOf(state);
        final Optional<String> criterion = fulfilledCriterion(run);
        if(criterion.isEmpty()) {
            return;
        }

        log.info("CMA-ES run {} ends in iteration {} by '{}' after {} updates.", run.restartNumber(), state.getIteration(),
                 criterion.get(), run.distribution().updates());

        if(!run.restart()) {
            state.stop();

            return;
        }

        log.info("CMA-ES run {} starts with lambda = {} and sigma = {} ({}).", run.restartNumber(),
                 run.distribution().parameters().populationSize(), run.distribution().stepSize(), run.setting().regime());
    }

    private Optional<String> fulfilledCriterion(final CmaEsRun run) {
        if(run.distribution().updates() >= run.setting().maximumIterations()) {
            return Optional.of("maximum-iterations");
        }

        return criteria.check(run.distribution(), run.history(), run.initialStepSize());
    }
}
