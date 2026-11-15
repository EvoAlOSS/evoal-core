package de.evoal.languages.model.interpreter.numeric;

import java.util.function.BiFunction;

/**
 * Helper class for mathematical operations on numbers.
 */
public final class ArithmeticNumberOperations {
    private ArithmeticNumberOperations() {}

    public static Number add(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        ArithmeticNumberOperations::addAsDouble,
                        ArithmeticNumberOperations::addAsLong,
                        ArithmeticNumberOperations::addAsInteger);
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
    
    public static Number abs(final Object op) {
        requireInstanceOf(op, Number.class);

        if (op instanceof Double || op instanceof Float) {
            return Math.abs(((Number) op).doubleValue());
        } else if (op instanceof Long) {
            return Math.abs(((Number) op).longValue());
        } else if (op instanceof Integer || op instanceof Short || op instanceof Byte) {
            return Math.abs(((Number) op).intValue());
        }

        throw new IllegalArgumentException("Parameter of type " + op + " is not supported.");
    }

    public static int compare(final Object op1, final Object op2) {
    	return dispatch(op1, op2,
    					(p1, p2) -> Double.compare(p1.doubleValue(), p2.doubleValue()),
    					(p1, p2) -> Long.compare(p1.longValue(), p2.longValue()),
    					(p1, p2) -> Integer.compare(p1.intValue(), p2.intValue())
    					).intValue();
    }

    public static Number dispatch(final Object lOp, final Object rOp,
    		final BiFunction<Number, Number, Number> doubleHandler,
    		final BiFunction<Number, Number, Number> longHandler,
    		final BiFunction<Number, Number, Number> integerHandler) {
        requireInstanceOf(lOp, Number.class);
        requireInstanceOf(rOp, Number.class);

        if (lOp instanceof Double || rOp instanceof Double ||
        		lOp instanceof Float || rOp instanceof Float) {
            return doubleHandler.apply((Number) lOp, (Number) rOp);
        } else if (lOp instanceof Long || rOp instanceof Long) {
            return longHandler.apply((Number) lOp, (Number) rOp);
        } else if (lOp instanceof Integer || rOp instanceof Integer ||
        		lOp instanceof Short || rOp instanceof Short ||
        		lOp instanceof Byte || rOp instanceof Byte
        ) {
            return integerHandler.apply((Number) lOp, (Number) rOp);
        }

        throw new IllegalArgumentException("Parameters of types " + lOp + " and " + rOp + " are not supported.");
    }
    
    public static Number divide(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        ArithmeticNumberOperations::divideAsDouble,
                        ArithmeticNumberOperations::divideAsLong,
                        ArithmeticNumberOperations::divideAsInteger);
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
                        ArithmeticNumberOperations::minusAsDouble,
                        ArithmeticNumberOperations::minusAsLong,
                        ArithmeticNumberOperations::minusAsInteger);
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
                ArithmeticNumberOperations::moduloAsLong,
                ArithmeticNumberOperations::moduloAsLong,
                ArithmeticNumberOperations::moduloAsInteger);
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
                ArithmeticNumberOperations::multiplyAsDouble,
                ArithmeticNumberOperations::multiplyAsLong,
                ArithmeticNumberOperations::multiplyAsInteger);
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
                ArithmeticNumberOperations::powAsDouble,
                ArithmeticNumberOperations::powAsLong,
                ArithmeticNumberOperations::powAsInteger);
    }

    private static Number powAsDouble(final Number op1, final Number op2) {
        return Math.pow(op1.doubleValue(), op2.doubleValue());
    }

    /**
     * Integral power. A negative exponent has no integral result, so it is computed
     *   using {@link Math#pow(double, double)} and returns a {@code double}. Overflows
     *   wrap around like Java's {@code *}.
     */
    private static Number powAsLong(final Number op1, final Number op2) {
        final long exponent = op2.longValue();
        if(exponent < 0) {
            return powAsDouble(op1, op2);
        }

        final long base = op1.longValue();
        long result = 1;

        for(long i = 0; i < exponent; ++i) {
            result *= base;
        }

        return result;
    }

    /**
     * Integral power, see {@link #powAsLong(Number, Number)}.
     */
    private static Number powAsInteger(final Number op1, final Number op2) {
        final int exponent = op2.intValue();
        if(exponent < 0) {
            return powAsDouble(op1, op2);
        }

        final int base = op1.intValue();
        int result = 1;

        for(int i = 0; i < exponent; ++i) {
            result *= base;
        }

        return result;
    }
    
    private static void requireInstanceOf(final Object obj, final Class<?> clazz) {
    	if(!clazz.isInstance(obj)) {
    		throw new IllegalArgumentException("Parameter '"  + obj + "'is not of required type: " + clazz);
    	}
    }

}
