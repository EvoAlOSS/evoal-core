package de.evoal.core.api.properties.stream;

import de.evoal.core.api.properties.PropertiesPair;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A supplier of a stream of pairs of properties. Supplier can be reused.
 */
public interface PropertiesPairStreamSupplier extends Supplier<Stream<PropertiesPair>> {
}
