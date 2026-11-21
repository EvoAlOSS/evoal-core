package de.evoal.optimisation.api.steps;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;

/**
 * Evaluates candidates and sets their objectives, fitness and optimisation values, e.g.,
 *   {@link EvaluateCandidates}.
 */
public interface FitnessCalculation extends Step {
    @Override
    default String kind() {
        return "FitnessCalculation";
    }

    /**
     * @return The evaluated candidates among the current candidates after the step.
     */
    @Override
    default List<Candidate> outputs(final SearchState state) {
        return state.getCandidates()
                    .stream()
                    .filter(Candidate::isEvaluated)
                    .toList();
    }
}
