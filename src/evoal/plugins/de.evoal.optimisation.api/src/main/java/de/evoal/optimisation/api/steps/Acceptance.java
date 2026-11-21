package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Decides which candidates form the new population, e.g., the accepting condition of a
 *   local search or the survivor selection of an evolutionary algorithm.
 */
public interface Acceptance extends Step {
    @Override
    default String kind() {
        return "Acceptance";
    }

    /**
     * @return The new population.
     */
    @Override
    default List<Candidate> outputs(final SearchState state) {
        return state.getPopulation();
    }
}
