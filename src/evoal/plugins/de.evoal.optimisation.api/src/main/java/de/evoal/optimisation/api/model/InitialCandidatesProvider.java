package de.evoal.optimisation.api.model;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.properties.Properties;

import java.util.stream.Stream;

/**
 * Base for all initial candidates providers. Each provider can implement a
 *   custom strategy, such as, random or based on known candidates.
 */
public interface InitialCandidatesProvider extends EvoalComponent<InitialCandidatesProvider> {
    /**
     * @return An unlimited stream of search-space candidates.
     */
    Stream<Properties> create();
}
