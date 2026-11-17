package de.evoal.optimisation.local_search.main;

import de.evoal.optimisation.api.steps.ParameterAdjustment;
import de.evoal.optimisation.api.steps.SearchState;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;

/**
 * Passes the number of the finished iteration to the accepting strategy, e.g., to lower the
 *   temperature of simulated annealing or the threshold of threshold accepting. Nothing
 *   happens if the search ends.
 */
final class AdjustAcceptingStrategy implements ParameterAdjustment {
    /**
     * The adjusted strategy.
     */
    private final AcceptingStrategy acceptingStrategy;

    AdjustAcceptingStrategy(final AcceptingStrategy acceptingStrategy) {
        this.acceptingStrategy = acceptingStrategy;
    }

    @Override
    public String description() {
        return "adjust the accepting strategy";
    }

    @Override
    public void execute(final SearchState state) {
        if(!state.isStopped()) {
            acceptingStrategy.setIteration(state.getIteration());
        }
    }
}
