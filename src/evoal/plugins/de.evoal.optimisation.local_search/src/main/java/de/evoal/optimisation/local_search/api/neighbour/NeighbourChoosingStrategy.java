package de.evoal.optimisation.local_search.api.neighbour;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.cdi.EvoalComponent;
import org.eclipse.emf.ecore.EObject;

import java.util.Optional;
import java.util.stream.Stream;

public interface NeighbourChoosingStrategy extends EvoalComponent<NeighbourChoosingStrategy> {

    NeighbourChoosingStrategy init(final EObject ncs);

    /**
     * @return The neighbours of the candidate, in the order the strategy is configured for.
     */
    Stream<TypedEObject> neighbours(final TypedEObject candidate);

    /**
     * @return A neighbour of the candidate, chosen uniformly at random from all its
     *   neighbours, independent of the configured order; nothing if it has no neighbours.
     */
    Optional<TypedEObject> randomNeighbour(final TypedEObject candidate);
}
