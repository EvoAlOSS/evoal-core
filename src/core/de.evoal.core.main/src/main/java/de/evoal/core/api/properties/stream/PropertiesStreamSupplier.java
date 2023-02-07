package de.evoal.core.api.properties.stream;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A supplier of a stream of properties. The supplier can be reused and can be asked for
 *   the properties conforming to a {@link PropertiesSpecification}.
 */
public interface PropertiesStreamSupplier extends Supplier<Stream<Properties>>, Function<PropertiesSpecification, Stream<Properties>> {
    default  Stream<Properties> apply(final PropertiesSpecification specification) {
        return get().filter(p -> p.contains(specification));
    }
}
