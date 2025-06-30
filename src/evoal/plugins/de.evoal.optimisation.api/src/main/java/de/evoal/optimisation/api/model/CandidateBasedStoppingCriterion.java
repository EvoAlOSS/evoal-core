package de.evoal.optimisation.api.model;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A stopping criterion determines if an optimisation algorithm should stop optimising.
 *   This abstract candidate-based version decides the stopping criterion based on
 *   single candidate and not on the entire iteration.
 */
public abstract class CandidateBasedStoppingCriterion implements StoppingCriterion {
    /**
     * @return {@code true} iff the algorithm should stop.
     */
    public boolean shouldTerminate(final Iteration iteration) {
        final int iterationNumber = iteration.iteration();
        final Candidate bestCandidate = iteration.bestCandidate();
        final Optional<Integer> numberOfCandidates = iteration.candidateCount();

        final AtomicInteger counter = new AtomicInteger(0);

        return iteration.candidates()
                        .anyMatch(c -> isSatisfied(iterationNumber, counter.getAndIncrement(), numberOfCandidates.get(), bestCandidate, c));
    }

    /**
     * Checks a stopping criterion for a specific {@code candidate}.
     *
     * @param iteration The current iteration number.
     * @param candidateNumber The candidate number.
     * @param candidateCount Number of individuals in the iteration.
     * @param iterationBest The best candidate in the iteration.
     * @param candidate The candidate to check.
     * @return {@code true} iff the algorithm should stop.
     */
    public abstract boolean isSatisfied(final int iteration, final int candidateNumber, final int candidateCount, final Candidate iterationBest, final Candidate candidate);
}
