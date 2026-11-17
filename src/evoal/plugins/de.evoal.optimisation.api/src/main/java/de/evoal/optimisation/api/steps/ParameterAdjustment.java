package de.evoal.optimisation.api.steps;

/**
 * Adjusts the parameters of the algorithm in the strategy state
 *   ({@link SearchState#strategy}), e.g., the temperature of simulated annealing or the
 *   inertia of particle swarm optimisation.
 */
public interface ParameterAdjustment extends Step {
    @Override
    default String kind() {
        return "ParameterAdjustment";
    }
}
