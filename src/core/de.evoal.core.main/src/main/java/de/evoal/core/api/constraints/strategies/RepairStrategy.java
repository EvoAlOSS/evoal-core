package de.evoal.core.api.constraints.strategies;

import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.Instance;

/**
 * Repair strategy used by kill-at-birth.
 */
public interface RepairStrategy {
     Properties apply(final Properties candidate, long generation);

    RepairStrategy init(final Instance configuration);
}
