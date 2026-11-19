package de.evoal.optimisation.api.checks;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Redoes the variation of a new candidate for the reaction {@link CheckReaction#RESAMPLE}.
 *   Algorithms with a variation provide it to {@link CheckNewCandidates}.
 */
@FunctionalInterface
public interface Resampler {
    /**
     * @param state The search state.
     * @param index The index of the candidate among the current candidates.
     * @return A new candidate from the same parents, created by the variation again.
     */
    Candidate resample(SearchState state, int index);
}
