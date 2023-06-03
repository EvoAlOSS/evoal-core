package de.evoal.core.api.optimisation;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.languages.model.base.Instance;

/**
 * Interface for all optimisation algorithms.
 */
public interface OptimisationAlgorithm extends EvoalComponent<OptimisationAlgorithm> {
    /**
     * Does the actual optimisation.
     */
    void run();
}
