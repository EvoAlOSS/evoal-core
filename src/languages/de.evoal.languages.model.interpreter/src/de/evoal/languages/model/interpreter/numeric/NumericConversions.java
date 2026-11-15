package de.evoal.languages.model.interpreter.numeric;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClassifier;

/**
 * Central conversions between numeric values.
 *
 * The rules are:
 * <ul>
 *   <li>Widening ({@code int} → {@code long} → {@code float} → {@code double}) is always allowed.</li>
 *   <li>Narrowing to an integral type is only allowed if no information is lost,
 *       e.g., {@code 2.0} → {@code 2}. Otherwise, e.g., {@code 1.7} → {@code int} or a
 *       {@code long} that exceeds the {@code int} range, an {@link IllegalArgumentException} is thrown.</li>
 *   <li>Narrowing {@code double} → {@code float} accepts the loss of precision but not an overflow.</li>
 *   <li>Non-numeric values cannot be converted to a numeric type.</li>
 * </ul>
 */
public final class NumericConversions {
    private NumericConversions() {
    }

    /**
     * Converts the value to {@code double}. Every number can be converted, but very large
     *   {@code long} values may lose precision.
     *
     * @throws IllegalArgumentException if the value is not a number.
     */
    public static double toDouble(final Object value) {
        return requireNumber(value, "double").doubleValue();
    }

    /**
     * Converts the value to {@code float}.
     *
     * @throws IllegalArgumentException if the value is not a number or exceeds the {@code float} range.
     */
    public static float toFloat(final Object value) {
        final Number number = requireNumber(value, "float");

        if(number instanceof Float f) {
            return f;
        }

        final double d = number.doubleValue();
        if(Double.isFinite(d) && Math.abs(d) > Float.MAX_VALUE) {
            throw cannotConvert(value, "float");
        }

        return (float) d;
    }

    /**
     * Converts the value to {@code long} without losing information.
     *
     * @throws IllegalArgumentException if the value is not a number, not integral, or exceeds the {@code long} range.
     */
    public static long toLong(final Object value) {
        final Number number = requireNumber(value, "long");

        if(isIntegral(number)) {
            return number.longValue();
        }

        final double d = number.doubleValue();
        // Long.MAX_VALUE is not representable as double, (double) Long.MAX_VALUE is 2^63
        if(!isIntegral(d) || d < Long.MIN_VALUE || d >= 0x1p63) {
            throw cannotConvert(value, "long");
        }

        return (long) d;
    }

    /**
     * Converts the value to {@code int} without losing information.
     *
     * @throws IllegalArgumentException if the value is not a number, not integral, or exceeds the {@code int} range.
     */
    public static int toInteger(final Object value) {
        final Number number = requireNumber(value, "int");

        if(isIntegral(number)) {
            final long l = number.longValue();
            if(l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
                throw cannotConvert(value, "int");
            }
            return (int) l;
        }

        final double d = number.doubleValue();
        if(!isIntegral(d) || d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) {
            throw cannotConvert(value, "int");
        }

        return (int) d;
    }

    /**
     * Converts the value to the numeric type of the given classifier, e.g., {@code EDouble}
     *   or {@code EInt}. Collections are converted element-wise, which is useful for
     *   multi-valued features.
     *
     * @param value The value to convert.
     * @param target The target type.
     * @return The converted value. {@code null} and values for non-numeric targets are
     *   returned unchanged. Collections are returned as new lists.
     *
     * @throws IllegalArgumentException if a value cannot be converted to the numeric target type.
     */
    public static Object toType(final Object value, final EClassifier target) {
        if(value == null || target == null) {
            return value;
        }

        final Class<?> targetClass = target.getInstanceClass();
        if(!isNumeric(targetClass)) {
            return value;
        }

        if(value instanceof Collection<?> collection) {
            return collection.stream()
                             .map(element -> toType(element, target))
                             .collect(Collectors.toList());
        }

        if(targetClass == double.class || targetClass == Double.class) {
            return toDouble(value);
        } else if(targetClass == float.class || targetClass == Float.class) {
            return toFloat(value);
        } else if(targetClass == long.class || targetClass == Long.class) {
            return toLong(value);
        } else {
            return toInteger(value);
        }
    }

    /**
     * @return {@code true} if the classifier is one of the numeric types supported by
     *   {@link #toType(Object, EClassifier)}.
     */
    public static boolean isNumeric(final EClassifier type) {
        return type != null && isNumeric(type.getInstanceClass());
    }

    /**
     * @return {@code true} if the class is one of the numeric types supported by
     *   {@link #toType(Object, EClassifier)} (primitive or wrapper of {@code int},
     *   {@code long}, {@code float}, or {@code double}).
     */
    public static boolean isNumeric(final Class<?> type) {
        return type == double.class || type == Double.class
            || type == float.class || type == Float.class
            || type == long.class || type == Long.class
            || type == int.class || type == Integer.class;
    }

    private static boolean isIntegral(final Number number) {
        return number instanceof Integer || number instanceof Long
            || number instanceof Short || number instanceof Byte;
    }

    private static boolean isIntegral(final double value) {
        return Double.isFinite(value) && value == Math.rint(value);
    }

    private static Number requireNumber(final Object value, final String target) {
        if(!(value instanceof Number number)) {
            throw cannotConvert(value, target);
        }

        return number;
    }

    private static IllegalArgumentException cannotConvert(final Object value, final String target) {
        final String type = value == null ? "null" : value.getClass().getSimpleName();
        return new IllegalArgumentException("Cannot convert value '" + value + "' (" + type + ") to " + target + ".");
    }
}
