package de.evoal.core.api.cdi;

import de.evoal.core.api.utils.InitializationException;
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
     * @throws InitializationException on errors during initialisation.
     */
    public default T init(final Instance configuration) throws InitializationException {
        return (T)this;
    };
}
