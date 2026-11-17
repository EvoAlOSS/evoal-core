package de.evoal.optimisation.api.steps;

import java.util.List;

/**
 * Accepts all current candidates: they replace the population.
 */
public final class ReplacePopulation implements Acceptance {
    @Override
    public String description() {
        return "replace the population by the candidates";
    }

    @Override
    public void execute(final SearchState state) {
        state.setPopulation(state.getCandidates());
        state.setCandidates(List.of());
    }
}
