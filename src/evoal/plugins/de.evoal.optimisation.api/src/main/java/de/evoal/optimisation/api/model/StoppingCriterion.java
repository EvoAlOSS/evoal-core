package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.EvoalComponent;

/**
 * A stopping criterion determines if an optimisation algorithm should stop optimising.
 *   There are different constraints that can be used, such as, number of iterations,
 *   population diversity, or convergence.
 */
@FunctionalInterface
public interface StoppingCriterion extends EvoalComponent<StoppingCriterion> {
    /**
     * @return {@code true} iff the algorithm should stop.
     */
    public boolean shouldTerminate(final Iteration iteration);

    /**
     * @return {@code true} iff the algorithm should continue.
     */
    default public boolean shouldContinue(final Iteration iteration) {
        return !shouldTerminate(iteration);
    }
}
