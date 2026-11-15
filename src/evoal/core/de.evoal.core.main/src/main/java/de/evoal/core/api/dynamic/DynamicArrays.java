package de.evoal.core.api.dynamic;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import lombok.NonNull;

/**
 * Helper for multi-dimensional arrays in the dynamic runtime model.
 *
 * EMF only supports one-dimensional multi-valued features. Therefore, the
 *   {@link DynamicEClassProvider} maps a DL attribute of type {@code array array T}
 *   to a containment reference whose elements are <em>array objects</em>. An
 *   array object is an instance of a generated <em>array class</em> that has a single
 *   multi-valued feature {@link #VALUES} containing the next dimension. For example,
 *   {@code covariance : array array real} becomes {@code covariance : RealArray [0..*]}
 *   with {@code RealArray.values : EDouble [0..*]}.
 *
 * Consumers that do not want to deal with array objects can use {@link #toJava(Object)}
 *   to convert a value into nested {@link List}s.
 */
public final class DynamicArrays {
    /**
     * Source of the annotation that marks a generated array class.
     */
    public static final String ARRAY_SOURCE = "https://evoal.de/v202704/models/core/dynamic-array";

    /**
     * Detail key of the {@link #ARRAY_SOURCE} annotation that contains the element type.
     */
    public static final String ARRAY_ELEMENTS = "elements";

    /**
     * Name of the feature of an array class that contains the elements.
     */
    public static final String VALUES = "values";

    private DynamicArrays() {
    }

    /**
     * @return {@code true} if the class is a generated array class.
     */
    public static boolean isArrayClass(final EClass eClass) {
        return eClass != null && eClass.getEAnnotation(ARRAY_SOURCE) != null;
    }

    /**
     * @return {@code true} if the object is an instance of a generated array class.
     */
    public static boolean isArray(final Object object) {
        return object instanceof EObject eObject && isArrayClass(eObject.eClass());
    }

    /**
     * @return The feature containing the elements of the given array class.
     */
    public static EStructuralFeature valuesFeature(final @NonNull EClass arrayClass) {
        if(!isArrayClass(arrayClass)) {
            throw new IllegalArgumentException("Class " + arrayClass.getName() + " is not an array class.");
        }

        return arrayClass.getEStructuralFeature(VALUES);
    }

    /**
     * @return The (live) list of elements of the given array object.
     */
    @SuppressWarnings("unchecked")
    public static List<Object> valuesOf(final @NonNull EObject array) {
        return (List<Object>) array.eGet(valuesFeature(array.eClass()));
    }

    /**
     * Converts a value of the dynamic runtime model into plain Java values. Array objects
     *   and lists are converted into (nested) {@link List}s, all other values are returned
     *   as they are. The returned lists are copies and not connected to the model.
     *
     * @param value The value to convert, e.g., the result of {@code eGet}.
     * @return The converted value.
     */
    public static Object toJava(final Object value) {
        if(isArray(value)) {
            return toJava(valuesOf((EObject) value));
        }

        if(value instanceof Collection<?> collection) {
            return collection.stream()
                             .map(DynamicArrays::toJava)
                             .toList();
        }

        return value;
    }
}
