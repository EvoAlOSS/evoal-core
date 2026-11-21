package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Chooses a single member or a subset of the population as the current candidates, e.g.,
 *   the parents of the next adaption.
 */
public interface Selection extends Step {
    @Override
    default String kind() {
        return "Selection";
    }

    /**
     * @return The selected members, the current candidates after the step.
     */
    @Override
    default List<Candidate> outputs(final SearchState state) {
        return state.getCandidates();
    }
}
