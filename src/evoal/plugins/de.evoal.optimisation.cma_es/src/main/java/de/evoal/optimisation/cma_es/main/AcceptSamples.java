package de.evoal.optimisation.cma_es.main;

import java.util.List;

import de.evoal.optimisation.api.steps.Acceptance;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Comma selection: the sampled candidates replace the population. If the search stopped in
 *   this iteration, nothing was sampled and the population stays.
 */
final class AcceptSamples implements Acceptance {
    @Override
    public String description() {
        return "replace the population by the sampled candidates";
    }

    @Override
    public void execute(final SearchState state) {
        if(!state.isStopped()) {
            state.setPopulation(state.getCandidates());
        }

        state.setCandidates(List.of());
    }
}
