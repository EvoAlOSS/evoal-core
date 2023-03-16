package de.evoal.core.api.optimisation;

import de.evoal.languages.model.instance.Instance;

/**
 * Interface for all optimisation algorithms.
 */
public interface OptimisationAlgorithm {
    /**
     * Initialises the algorithm based on the given configuration.
     *
     * @param instance The configuration to use.
     *
     * @return The algorithm itself.
     */
    public OptimisationAlgorithm init(final Instance instance);

    /**
     * Does the actual optimisation.
     */
    public void run();
}
