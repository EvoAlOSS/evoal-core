package de.evoal.core.api.optimisation;

import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.instance.Instance;

import java.util.stream.Stream;

/**
 * Base for all initial candidates providers. Each provider can implement a
 *   custom strategy, such as, random or based on known candidates.
 */
public interface InitialCandidatesProvider {
    /**
     * Initalises the provider with its configuration.
     *
     * @param configuration The configuration for the provider.
     * @return The provider itself.
     */
    InitialCandidatesProvider init(final Instance configuration);

    /**
     * @return An unlimited stream of search-space candidates.
     */
    Stream<Properties> create();
}
