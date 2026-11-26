package de.evoal.core.api.ecore.stream;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A supplier of a stream of typed EObjects. The supplier can be reused and can
 *   be asked for the EObjects conforming to a {@link Space}.
 */
public interface EObjectStreamSupplier extends Supplier<Stream<TypedEObject>>, Function<Space, Stream<TypedEObject>> {
    /**
     * Returns the objects that have a value for every feature of the space and reports the
     *   others with one warning. A value equal to the default (0, 0.0, false) is a value
     *   (#355). The objects are read once.
     *
     * @param specification The space.
     * @return The objects with a value for every feature of the space.
     */
    @Override
    default Stream<TypedEObject> apply(final Space specification) {
        final List<TypedEObject> objects = get().toList();
        MissingValues.report(objects::stream, object -> MissingValues.missing(object, specification));

        return objects.stream()
                      .filter(object -> MissingValues.complete(object, specification));
    }
}
