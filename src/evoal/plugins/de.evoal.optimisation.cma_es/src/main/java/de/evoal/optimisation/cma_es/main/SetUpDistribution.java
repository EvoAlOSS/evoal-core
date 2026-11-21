package de.evoal.optimisation.cma_es.main;

import java.util.function.Supplier;

import de.evoal.optimisation.api.steps.ParameterAdjustment;
import de.evoal.optimisation.api.steps.SearchState;
import de.evoal.optimisation.api.steps.StateKey;

/**
 * Sets up CMA-ES for an optimisation run: the first distribution with the first candidate of
 *   the 'initialisation' as its mean, the initial step size and C = I.
 */
final class SetUpDistribution implements ParameterAdjustment {
    /**
     * The state of CMA-ES in the strategy state of the search.
     */
    static final StateKey<CmaEsRun> RUN = new StateKey<>("cma-es", CmaEsRun.class);

    /**
     * Creates the state of an optimisation run.
     */
    private final Supplier<CmaEsRun> runs;

    SetUpDistribution(final Supplier<CmaEsRun> runs) {
        this.runs = runs;
    }

    @Override
    public String description() {
        return "set up the distribution with the mean from the initialisation";
    }

    @Override
    public void execute(final SearchState state) {
        state.setStrategy(RUN, runs.get());
    }

    /**
     * @return The state of CMA-ES of the search.
     * @throws IllegalStateException if the distribution is not set up.
     */
    static CmaEsRun runOf(final SearchState state) {
        return state.strategy(RUN)
                    .orElseThrow(() -> new IllegalStateException("The distribution of CMA-ES is not set up."));
    }
}
