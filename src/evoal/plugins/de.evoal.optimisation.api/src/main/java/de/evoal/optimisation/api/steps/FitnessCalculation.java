package de.evoal.optimisation.api.steps;

/**
 * Evaluates candidates and sets their optimisation values, e.g., {@link EvaluateCandidates}.
 */
public interface FitnessCalculation extends Step {
    @Override
    default String kind() {
        return "FitnessCalculation";
    }
}
