package de.evoal.optimisation.api.model;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * Interface for all optimisation algorithms.
 */
public interface OptimisationAlgorithm extends EvoalComponent<OptimisationAlgorithm> {
    /**
     * Does the actual optimisation.
     */
    void run();
}
