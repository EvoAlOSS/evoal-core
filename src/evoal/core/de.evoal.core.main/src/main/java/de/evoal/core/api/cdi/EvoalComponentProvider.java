package de.evoal.core.api.cdi;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.Instance;

/**
 * Provider of EvoAl components if the components cannot be instantiated directly.
 */
@FunctionalInterface
public interface EvoalComponentProvider<T extends EvoalComponent<T>> {
    /**
     * Creates a component based on the given configuration.
     *
     * @param configuration The configuration to use.
     *
     * @return The component itself.
     * @throws InitializationException on errors during initialisation.
     */
    public T create(final Instance configuration) throws InitializationException;
}
