package de.evoal.optimisation.local_search.api.accepting;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.model.OptimisationValue;

/**
 * An accepting strategy for local searches.
 */
public interface AcceptingStrategy extends EvoalComponent<AcceptingStrategy> {

    /**
     * Iff a potential candidate should be accepted.
     */
    public boolean acceptCandidate(final Properties candidate, final OptimisationValue bestFitnessValue);

    /**
     * Sets the current iteration.
     *
     * @param iteration Iteration number.
     * @param maximum Maximum number of iterations.
     */
    public default void setIteration(final int iteration, final int maximum) {}
}
