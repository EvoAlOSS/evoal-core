package de.evoal.optimisation.api.constraints.strategies;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;

/**
 * Repair strategy used by kill-at-birth.
 */
public interface RepairStrategy<T extends EvoalComponent<T>> extends EvoalComponent<T> {
     Properties apply(final Properties candidate, long generation);
}
