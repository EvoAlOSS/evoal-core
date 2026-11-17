package de.evoal.optimisation.api.steps;

/**
 * Evaluates candidates and sets their objectives, fitness and optimisation values, e.g.,
 *   {@link EvaluateCandidates}.
 */
public interface FitnessCalculation extends Step {
    @Override
    default String kind() {
        return "FitnessCalculation";
    }
}
