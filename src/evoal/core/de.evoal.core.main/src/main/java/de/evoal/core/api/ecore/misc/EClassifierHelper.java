package de.evoal.core.api.ecore.misc;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;

/**
 * Tells the kind of value a data type holds. A data type is recognised by its instance class, so
 *   the Ecore types ({@code EInt}, {@code EIntegerObject}, ...) and data types of a metamodel
 *   that restrict them (e.g. a {@code Direction} with instance class {@code int} and the facets
 *   {@code minInclusive 0} and {@code maxInclusive 3}) are treated alike. Enums and classes are
 *   none of these kinds.
 */
public final class EClassifierHelper {
    private EClassifierHelper() {}

    public static boolean isBoolean(final EClassifier type) {
        return hasInstanceClass(type, boolean.class, Boolean.class);
    }

    public static boolean isByte(final EClassifier type) {
        return hasInstanceClass(type, byte.class, Byte.class);
    }

    public static boolean isDouble(final EClassifier type) {
        return hasInstanceClass(type, double.class, Double.class);
    }

    public static boolean isFloat(final EClassifier type) {
        return hasInstanceClass(type, float.class, Float.class);
    }

    public static boolean isInteger(final EClassifier type) {
        return hasInstanceClass(type, int.class, Integer.class);
    }

    public static boolean isIntegerOrShorter(final EClassifier type) {
        return isInteger(type)
                || isShortOrShorter(type);
    }

    public static boolean isLong(final EClassifier type) {
        return hasInstanceClass(type, long.class, Long.class);
    }

    public static boolean isLongOrShorter(final EClassifier type) {
        return isLong(type) || isIntegerOrShorter(type);
    }

    public static boolean isNumeric(final EClassifier type) {
        return isLongOrShorter(type) || isReal(type);
    }

    public static boolean isReal(final EClassifier type) {
        return isDouble(type) || isFloat(type);
    }

    public static boolean isShort(final EClassifier type) {
        return hasInstanceClass(type, short.class, Short.class);
    }

    public static boolean isShortOrShorter(final EClassifier type) {
        return isShort(type) || isByte(type);
    }

    public static boolean isString(final EClassifier type) {
        return hasInstanceClass(type, String.class, String.class);
    }

    /**
     * @return {@code true} if the type is a data type (no enum) whose instance class is the
     *   primitive class or its wrapper.
     */
    private static boolean hasInstanceClass(final EClassifier type, final Class<?> primitive, final Class<?> wrapper) {
        if(!(type instanceof EDataType) || type instanceof EEnum) {
            return false;
        }

        final Class<?> instanceClass = type.getInstanceClass();

        return instanceClass == primitive || instanceClass == wrapper;
    }
}
