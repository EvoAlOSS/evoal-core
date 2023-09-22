package de.evoal.core.api.cdi;

import de.evoal.languages.model.base.Instance;

/**
 * Base class for components that allow initialisation using an init method.
 */
public interface EvoalComponent<T extends EvoalComponent<T>> {
    /**
     * Initialises the component based on the given configuration.
     *
     * @param configuration The configuration to use.
     *
     * @return The component itself.
     */
    public T init(final Instance configuration);
}
