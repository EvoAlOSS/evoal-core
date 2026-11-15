package de.evoal.optimisation.api.model;

import de.evoal.core.api.utils.Requirements;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.Rank;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A stopping criterion determines if an optimisation algorithm should stop optimising.
 *   This abstract candidate-based version decides the stopping criterion based on
 *   a single candidate and not on the entire iteration.
 */
public abstract class CandidateBasedStoppingCriterion implements TerminationCriterion {
    /**
     * @return {@code true} iff the algorithm should stop.
     */
    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        final int iterationNumber = iteration.getNumber();
        final int numberOfCandidates = iteration.numberOfSurvivedIndividuals();
        final AtomicInteger counter = new AtomicInteger(0);

        return iteration
                .survivedIndividuals()
                .anyMatch(c -> isSatisfied(iterationNumber, counter.getAndIncrement(), numberOfCandidates, iteration.getRanks().get(0), c));
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
    public abstract boolean isSatisfied(final int iteration, final int candidateNumber, final int candidateCount, final Rank iterationBest, final Individual candidate);
}
