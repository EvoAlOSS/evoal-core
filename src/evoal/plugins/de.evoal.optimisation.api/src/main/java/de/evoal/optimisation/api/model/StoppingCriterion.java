package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.EvoalComponent;

/**
 * A stopping criterion determines if an optimisation algorithm should stop optimising.
 *   There are different strategies that can be used, such as, number of iterations,
 *   population diversity, or convergence.
 */
@FunctionalInterface
public interface StoppingCriterion extends EvoalComponent<StoppingCriterion> {
    /**
     * @return {@code true} iff the algorithm should stop.
     */
    public boolean isSatisfied(final Iteration iteration);
}
