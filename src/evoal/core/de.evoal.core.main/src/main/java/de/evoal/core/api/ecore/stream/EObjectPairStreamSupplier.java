package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.properties.PropertiesPair;
import org.eclipse.emf.ecore.EObject;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A supplier of a stream of pairs of properties. Supplier can be reused.
 */
public interface EObjectPairStreamSupplier extends Supplier<Stream<EObjectPair>> {
}
