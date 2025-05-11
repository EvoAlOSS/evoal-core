package de.evoal.pipeline.api.distribution;

import de.evoal.core.api.cdi.EvoalComponent;

/**
 * A distribution to sample data.
 */
public interface Distribution extends EvoalComponent<Distribution> {
    /**
     * @return A sample from the distribution.
     */
    double [] sample();
}
