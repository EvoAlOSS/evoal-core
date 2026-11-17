package de.evoal.optimisation.api.steps;

/**
 * Decides which candidates form the new population, e.g., the accepting condition of a
 *   local search or the survivor selection of an evolutionary algorithm.
 */
public interface Acceptance extends Step {
    @Override
    default String kind() {
        return "Acceptance";
    }
}
