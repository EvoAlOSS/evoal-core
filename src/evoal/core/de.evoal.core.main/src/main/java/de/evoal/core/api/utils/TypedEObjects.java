package de.evoal.core.api.utils;

import java.util.Objects;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * Operations on the values of {@link TypedEObject}s, e.g., positions in the
 *   search space.
 */
public final class TypedEObjects {
    private TypedEObjects() {
    }

    private static boolean hasSameValue(final TypedEObject first,
                                        final TypedEObject second,
                                        final EStructuralFeature feature) {
        final Object firstValue = first.eGet(feature);
        final Object secondValue = second.eGet(feature);

        return Objects.equals(firstValue, secondValue);
    }

    /**
     * Compares two objects value by value. The comparison is exact
     *   ({@link Objects#equals(Object, Object)}), e.g., {@code 1.0} and
     *   {@code 1.0000000001} are different values.
     *
     * @param first The first object, its space defines the compared features.
     * @param second The second object, of the same space.
     * @return Whether both objects have equal values for every feature of the first object's space.
     */
    public static boolean haveSameValues(final TypedEObject first, final TypedEObject second) {
        final Space space = first.eSpace();

        return space.stream()
                    .allMatch(feature -> hasSameValue(first, second, feature));
    }
}
