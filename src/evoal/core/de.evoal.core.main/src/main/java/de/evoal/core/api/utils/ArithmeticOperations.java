package de.evoal.core.api.utils;

import java.util.function.BiFunction;

/**
 * Helper class for mathematical operations on numbers.
 */
public final class ArithmeticOperations {
    private ArithmeticOperations() {}

    public static Number add(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        ArithmeticOperations::addAsDouble,
                        ArithmeticOperations::addAsLong,
                        ArithmeticOperations::addAsInteger);
    }

    private static Number addAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() + op2.doubleValue();
    }
    private static Number addAsLong(final Number op1, final Number op2) {
        return op1.longValue() + op2.longValue();
    }
    private static Number addAsInteger(final Number op1, final Number op2) {
        return op1.intValue() + op2.intValue();
    }

    private static Number dispatch(final Object op1, final Object op2, final BiFunction<Number, Number, Number> doubleHandler, final BiFunction<Number, Number, Number> longHandler, final BiFunction<Number, Number, Number> integerHandler) {
        Requirements.requireInstanceOf(op1, Number.class);
        Requirements.requireInstanceOf(op2, Number.class);

        if (op1 instanceof Double || op2 instanceof Double ||
                op1 instanceof Float || op2 instanceof Float) {
            return doubleHandler.apply((Number) op1, (Number) op2);
        } else if (op1 instanceof Long || op2 instanceof Long) {
            return longHandler.apply((Number) op1, (Number) op2);
        } else if (op1 instanceof Integer || op2 instanceof Integer ||
                op1 instanceof Short || op2 instanceof Short ||
                op1 instanceof Byte || op2 instanceof Byte
        ) {
            return integerHandler.apply((Number) op1, (Number) op2);
        }

        throw new IllegalArgumentException("Parameters of types " + op1 + " and " + op2 + " are not supported.");
    }

    public static Number divide(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        ArithmeticOperations::divideAsDouble,
                        ArithmeticOperations::divideAsLong,
                        ArithmeticOperations::divideAsInteger);
    }

    private static Number divideAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() / op2.doubleValue();
    }

    private static Number divideAsLong(final Number op1, final Number op2) {
        return op1.longValue() / op2.longValue();
    }

    private static Number divideAsInteger(final Number op1, final Number op2) {
        return op1.intValue() / op2.intValue();
    }

    public static Number minus(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        ArithmeticOperations::minusAsDouble,
                        ArithmeticOperations::minusAsLong,
                        ArithmeticOperations::minusAsInteger);
    }

    private static Number minusAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() - op2.doubleValue();
    }
    private static Number minusAsLong(final Number op1, final Number op2) {
        return op1.longValue() - op2.longValue();
    }

    private static Number minusAsInteger(final Number op1, final Number op2) {
        return op1.intValue() - op2.intValue();
    }

    public static Number modulo(final Object op1, final Object op2) {
        return dispatch(op1,
                op2,
                ArithmeticOperations::moduloAsLong,
                ArithmeticOperations::moduloAsLong,
                ArithmeticOperations::moduloAsInteger);
    }

    private static Number moduloAsLong(final Number op1, final Number op2) {
        return op1.longValue() % op2.longValue();
    }

    private static Number moduloAsInteger(final Number op1, final Number op2) {
        return op1.intValue() % op2.intValue();
    }

    public static Number multiply(final Object op1, final Object op2) {
        return dispatch(op1,
                op2,
                ArithmeticOperations::multiplyAsDouble,
                ArithmeticOperations::multiplyAsLong,
                ArithmeticOperations::multiplyAsInteger);
    }

    private static Number multiplyAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() * op2.doubleValue();
    }

    private static Number multiplyAsLong(final Number op1, final Number op2) {
        return op1.longValue() * op2.longValue();
    }

    private static Number multiplyAsInteger(final Number op1, final Number op2) {
        return op1.intValue() * op2.intValue();
    }

    public static Number pow(final Object op1, final Object op2) {
        return dispatch(op1,
                op2,
                ArithmeticOperations::powAsDouble,
                ArithmeticOperations::powAsLong,
                ArithmeticOperations::powAsInteger);
    }

    private static Number powAsDouble(final Number op1, final Number op2) {
        return Math.pow(op1.doubleValue(), op2.doubleValue());
    }

    private static Number powAsLong(final Number op1, final Number op2) {
        long result = op1.longValue();

        for(int i = 1; i < op2.intValue(); ++i) {
            result *= op1.longValue();
        }

        return result;
    }

    private static Number powAsInteger(final Number op1, final Number op2) {
        int result = op1.intValue();

        for(int i = 1; i < op2.intValue(); ++i) {
            result *= op1.longValue();
        }

        return result;
    }
}
