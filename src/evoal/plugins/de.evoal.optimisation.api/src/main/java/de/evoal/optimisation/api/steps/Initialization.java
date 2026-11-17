package de.evoal.optimisation.api.steps;

/**
 * Creates new candidates without predecessors, e.g., by sampling the search space, and
 *   makes them the current candidates ({@link SearchState#setCandidates}).
 */
public interface Initialization extends Step {
    @Override
    default String kind() {
        return "Initialization";
    }
}
