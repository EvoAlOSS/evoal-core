package de.evoal.optimisation.local_search.api.neighbour;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.cdi.EvoalComponent;
import org.eclipse.emf.ecore.EObject;

import java.util.stream.Stream;

public interface NeighbourChoosingStrategy extends EvoalComponent<NeighbourChoosingStrategy> {

    NeighbourChoosingStrategy init(final EObject ncs);

    Stream<TypedEObject> neighbours(final TypedEObject candidate);
}
