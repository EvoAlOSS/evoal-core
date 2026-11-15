package de.evoal.optimisation.api.model;

import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.Rank;

/**
 * A stopping criterion determines if an optimisation algorithm should stop optimising.
 *   This abstract candidate-based version decides the stopping criterion based on
 *   a single candidate and not on the entire iteration.
 */
public abstract class CandidateBasedStoppingCriterion implements TerminationCriterion {
    /**
     * Checks a stopping criterion for a specific {@code candidate}.
     *
     * @param iteration The current iteration number.
     * @param candidateCount Number of individuals in the iteration.
     * @param iterationBest The best candidates of the iteration (rank 0).
     * @param candidate The candidate to check. Its id identifies it in the memory model.
     * @return {@code true} iff the algorithm should stop.
     */
    public abstract boolean isSatisfied(final int iteration,
                                        final int candidateCount,
                                        final Rank iterationBest,
                                        final Individual candidate);

    /**
     * @return {@code true} iff the criterion is satisfied for at least one surviving individual.
     */
    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        final int iterationNumber = iteration.getNumber();
        final int numberOfCandidates = iteration.numberOfSurvivedIndividuals();
        final Rank bestCandidates = iteration.getRanks().getFirst();

        return iteration.survivedIndividuals()
                        .anyMatch(candidate -> isSatisfied(iterationNumber,
                                                           numberOfCandidates,
                                                           bestCandidates,
                                                           candidate));
    }
}
