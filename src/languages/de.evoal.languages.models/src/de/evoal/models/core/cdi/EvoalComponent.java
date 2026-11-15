package de.evoal.models.core.cdi;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;

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
    public default T init(final EObject configuration) throws InitializationException {
        return (T) this;
    }
}