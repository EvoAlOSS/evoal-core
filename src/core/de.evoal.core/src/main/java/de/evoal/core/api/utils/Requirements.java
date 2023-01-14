package de.evoal.core.api.utils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Class for checking requirements of values, e.g., of parameters.
 */
public final class Requirements {
    private Requirements() {
    }

    /**
     * Requires the value to be {@code false}.
     *
     * @param value Value to check.
     * @throws IllegalArgumentException iff the passed {@code value} is {@code true}.
     */
    public static void requireFalse(final boolean value) {
        if(value) {
            throw new IllegalArgumentException("Value expected to be false.");
        }
    }

    /**
     * Requires the arrays to be present and of same size.
     *
     * @param a The first array.
     * @param b The second array.
     *
     * @throws NullPointerException iff either {@code a} or {@code b} is {@code null}.
     * @throws IllegalArgumentException iff the size of {@code a} and {@code b} differ.
     */
    public static void requireSameSize(final double [] a, final double [] b) {
        Objects.requireNonNull(a, "Array is not allowed to be null");
        Objects.requireNonNull(b, "Array is not allowed to be null");

        if(a.length != b.length) {
            throw new IllegalArgumentException("Arrays are expected to have the same size: " + a.length + " -- " + b.length);
        }
    }

    /**
     * Requires the arrays to be present and of same size.
     *
     * @param a The first array.
     * @param b The second array.
     *
     * @throws NullPointerException iff either {@code a} or {@code b} is {@code null}.
     * @throws IllegalArgumentException iff the size of {@code a} and {@code b} differ.
     */
    public static <T>void requireSameSize(final double [] a, final T [] b) {
        Objects.requireNonNull(a, "Array is not allowed to be null");
        Objects.requireNonNull(b, "Array is not allowed to be null");

        if(a.length != b.length) {
            throw new IllegalArgumentException("Arrays are expected to have the same size: " + a.length + " -- " + b.length);
        }
    }

    /**
     * Requires the collections to be present and of same size.
     *
     * @param a The first collection.
     * @param b The second collection.
     *
     * @throws NullPointerException iff either {@code a} or {@code b} is {@code null}.
     * @throws IllegalArgumentException iff the size of {@code a} and {@code b} differ.
     */
    public static void requireSameSize(final Collection<?> a, final Collection<?> b) {
        Objects.requireNonNull(a, "Collection is not allowed to be null");
        Objects.requireNonNull(b, "Collection is not allowed to be null");

        if(a.size() != b.size()) {
            throw new IllegalArgumentException("Collections are expected to have the same size: " + a.size() + " -- " + b.size());
        }
    }

    /**
     * Requires the collection {@code collection} to be present and of size {@code size}.
     *
     * @param collection The collection to check.
     * @param size The required size.
     *
     * @throws NullPointerException iff either {@code a} or {@code b} is {@code null}.
     * @throws IllegalArgumentException iff the size of {@code a} and {@code b} differ.
     */
    public static void requireSize(final Collection<?> collection, final int size) {
        Objects.requireNonNull(collection, "Collection is not allowed to be null");

        if(collection.size() != size) {
            throw new IllegalArgumentException("Collections is expected to have size (" + size + "): " + collection.size());
        }
    }

    /**
     * Requires the collection {@code collection} to be present and of size {@code size}.
     *
     * @param collection The collection to check.
     * @param size The required size.
     *
     * @throws NullPointerException iff either {@code a} or {@code b} is {@code null}.
     * @throws IllegalArgumentException iff the size of {@code a} and {@code b} differ.
     */
    public static void requireSizeGreaterThan(final Collection<?> collection, final int size) {
        Objects.requireNonNull(collection, "Collection is not allowed to be null");

        if(collection.size() <= size) {
            throw new IllegalArgumentException("Collections expected size size (" + size + ") is not met: " + collection.size());
        }
    }

    /**
     * Requires the collection {@code collection} to be present but empty.
     *
     * @param collection The collection to check.
     *
     * @throws NullPointerException iff {@code collection}  is {@code null}.
     * @throws IllegalArgumentException iff the size of {@code collection} is greater than 0.
     */
    public static void requireEmpty(final Collection<?> collection) {
        Objects.requireNonNull(collection, "Collection is not allowed to be null");

        if(!collection.isEmpty()) {
            throw new IllegalArgumentException("Collections is expected to have size (0): " + collection.size());
        }
    }

    /**
     * Requires the parameters to be equal.
     *
     * @param a The first value to check.
     * @param b The second value to check.
     *
     * @throws IllegalArgumentException iff the values are not equal.
     */
    public static void requireEqual(final Object a, final Object b) {
        if(!Objects.equals(a, b)) {
            throw new IllegalArgumentException("Values are not equal: " + a + " != " + b);
        }
    }
    /**
     * Requires the parameters to have the same value.
     *
     * @param a The first value to check.
     * @param b The second value to check.
     *
     * @throws IllegalArgumentException iff the values are not equal.
     */
    public static void requireEqual(final long a, final long b) {
        if(a != b) {
            throw new IllegalArgumentException("Values are not equal: " + a + " != " + b);
        }
    }

    /**
     * Requires the object to exist.
     *
     * @param object The object to check.
     *
     * @throws NullPointerException iff {@code object} is {@code null}.
     */
    public static void requireNotNull(final Object object) {
        Objects.requireNonNull(object, "Object is not allowed to be null");
    }

    /**
     * Requires the object to be null.
     *
     * @param object The object to check.
     *
     * @throws IllegalArgumentException iff {@code object} is not {@code null}.
     */
    public static void requireNull(final Object object) {
        if(object != null) {
            throw new IllegalArgumentException("Object is required to be null");
        }
    }

    /**
     * Requires {@code object} to be of type {@code type}
     *
     * @param object The object to check
     * @param type The required type.
     *
     * @throws NullPointerException iff either {@code list} or {@code type} is {@code null}.
     * @throws IllegalArgumentException iff the object is not of the required type.
     */
    private static void requireType(final Object object, final Class<?> type) {
        Objects.requireNonNull(type, "Type is not allowed to be null");

        if(!type.isAssignableFrom(object.getClass())) {
            throw new IllegalArgumentException("Object of type " + object.getClass() + " is not assignable to type " + type.getClass());
        }
    }

    /**
     * Requires the object in {@code list} at {@code index} to be of type {@code type}.
     *
     * @param list The hosting list.
     * @param index The index of the element to check.
     * @param type The required type.
     *
     * @throws NullPointerException iff either {@code list} or {@code type} is {@code null}.
     * @throws IllegalArgumentException iff the object is not of the required type.
     */
    public static void requireType(final List<Object> list, final int index, final Class<?> type) {
        Objects.requireNonNull(list, "List is not allowed to be null");

        requireType(list.get(index), type);
    }

    /**
     * Requires the passed value to be a probability.
     *
     * @param value The value to check.
     * @return The probability itself for further usage.
     *
     * @throws IllegalArgumentException Iff the passed value is not a probability.
     */
    public static double requireProbability(final double value) {
        if(value < 0.0 || value > 0.0) {
            throw new IllegalArgumentException("Passed value is not a probability: " + value);
        }

        return value;
    }

    /**
     * Requires the value to be positive.
     *
     * @param value The value to check.
     * @return {@code p} itself for further usage.
     */
    public static double nonNegative(final double value) {
        if(value < 0.0) {
            throw new IllegalArgumentException("Passed value is negative: " + value);
        }

        return value;
    }

    /**
     * Requires the value to be a valid instance of the given class.
     *
     * @param value The value to check.
     * @param clazz The class for checking
     * @return {@code true} iff {@code value instanceof clazz}.
     */
    public static void requireInstanceOf(final Object value, final Class<?> clazz) {
        requireNotNull(value);
        requireNotNull(clazz);

        if(!clazz.isInstance(value)) {
            throw new IllegalArgumentException("Passed object " + Objects.toString(value) + " is not an instance of: " + clazz);
        }
    }
}
