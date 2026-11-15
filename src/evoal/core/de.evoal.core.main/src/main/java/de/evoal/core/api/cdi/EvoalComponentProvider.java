package de.evoal.core.api.cdi;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;

import org.eclipse.emf.ecore.EObject;

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
    public T create(final EObject configuration) throws InitializationException;
}
