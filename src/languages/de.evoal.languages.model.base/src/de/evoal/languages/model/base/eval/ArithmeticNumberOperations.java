package de.evoal.languages.model.base.eval;

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
    
    private static void requireInstanceOf(final Object obj, final Class<?> clazz) {
    	if(!clazz.isInstance(obj)) {
    		throw new IllegalArgumentException("Parameter '"  + obj + "'is not of required type: " + clazz);
    	}
    }

}
