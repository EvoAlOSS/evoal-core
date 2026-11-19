package de.evoal.optimisation.api.steps;

/**
 * Tests candidates and reacts to the ones that fail, e.g., by replacing them
 *   ({@link de.evoal.optimisation.api.checks.CandidateCheck}).
 */
public interface Check extends Step {
    @Override
    default String kind() {
        return "Check";
    }
}
