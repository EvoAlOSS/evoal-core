package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Creates new candidates without predecessors, e.g., by sampling the search space, and
 *   makes them the current candidates ({@link SearchState#setCandidates}).
 */
public interface Initialization extends Step {
    @Override
    default String kind() {
        return "Initialization";
    }

    /**
     * @return The created candidates, the current candidates after the step.
     */
    @Override
    default List<Candidate> outputs(final SearchState state) {
        return state.getCandidates();
    }
}
