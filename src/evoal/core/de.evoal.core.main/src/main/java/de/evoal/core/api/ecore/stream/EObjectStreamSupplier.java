package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * A supplier of a stream of typed EObjects. The supplier can be reused and can
 *   be asked for the EObjects conforming to a {@link Space}.
 */
public interface EObjectStreamSupplier extends Supplier<Stream<TypedEObject>>, Function<Space, Stream<TypedEObject>> {
    @Override
    default  Stream<TypedEObject> apply(final Space specification) {
        return get().filter(p -> specification.stream().allMatch(s -> p.eIsSet(s)));
    }
}
