package de.evoal.optimisation.local_search.api.accepting;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.core.cdi.EvoalComponent;

/**
 * An accepting strategy for local searches.
 */
public interface AcceptingStrategy extends EvoalComponent<AcceptingStrategy> {

    /**
     * Iff a potential candidate should be accepted. The candidate is already evaluated,
     *   strategies must not evaluate the optimisation function themselves.
     *
     * @param candidateValue The optimisation value of the potential candidate.
     * @param currentValue The optimisation value of the current candidate.
     */
    public boolean acceptCandidate(final OptimisationValue candidateValue, final OptimisationValue currentValue);

    /**
     * Iff rejecting all neighbours of the current candidate is final, i.e., the strategy would
     *   reject them in every later iteration, too. The local search then ends. Otherwise,
     *   it keeps the candidate and tries again in the next iteration.
     *
     * @return {@code true} (default) for deterministic strategies whose acceptance does not
     *   become less strict over time, {@code false} for randomised strategies.
     */
    public default boolean rejectionIsFinal() {
        return true;
    }

    /**
     * Sets the current iteration.
     *
     * @param iteration Iteration number.
     */
    public default void setIteration(final int iteration) {}

    /**
     * Iff the local search offers only a single, randomly chosen neighbour per iteration
     *   (as in simulated annealing) instead of all neighbours until one is accepted.
     *
     * @return {@code false} (default): all neighbours are offered, in the configured order.
     */
    public default boolean testsSingleNeighbour() {
        return false;
    }
}
