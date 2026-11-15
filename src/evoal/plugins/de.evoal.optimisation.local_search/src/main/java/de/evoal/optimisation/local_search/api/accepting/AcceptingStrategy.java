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
     * Sets the current iteration.
     *
     * @param iteration Iteration number.
     * @param maximum Maximum number of iterations.
     */
    public default void setIteration(final int iteration, final int maximum) {}
}
