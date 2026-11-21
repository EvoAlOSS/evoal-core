package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Tests candidates and reacts to the ones that fail, e.g., by replacing them
 *   ({@link de.evoal.optimisation.api.checks.CandidateCheck}).
 */
public interface Check extends Step {
    @Override
    default String kind() {
        return "Check";
    }

    /**
     * @return The checked candidates, the current candidates after the step, among them the
     *   replacements of the failed ones.
     */
    @Override
    default List<Candidate> outputs(final SearchState state) {
        return state.getCandidates();
    }
}
