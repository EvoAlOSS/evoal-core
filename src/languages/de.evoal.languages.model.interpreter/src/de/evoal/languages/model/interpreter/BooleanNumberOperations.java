package de.evoal.languages.model.interpreter;

import java.util.function.BiFunction;

/**
 * Helper class for boolean operations on numbers.
 */
public final class BooleanNumberOperations {
    private BooleanNumberOperations() {}

    public static Boolean isGreaterThan(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        BooleanNumberOperations::isGreaterThanAsDouble,
                        BooleanNumberOperations::isGreaterThanAsLong,
                        BooleanNumberOperations::isGreaterThanAsInteger);
    }

    private static Boolean isGreaterThanAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() > op2.doubleValue();
    }
    
    private static Boolean isGreaterThanAsLong(final Number op1, final Number op2) {
        return op1.longValue() > op2.longValue();
    }

    private static Boolean isGreaterThanAsInteger(final Number op1, final Number op2) {
        return op1.intValue() > op2.intValue();
    }

    public static Boolean isGreaterThanOrEqualTo(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        BooleanNumberOperations::isGreaterThanOrEqualToAsDouble,
                        BooleanNumberOperations::isGreaterThanOrEqualToAsLong,
                        BooleanNumberOperations::isGreaterThanOrEqualToAsInteger);
    }

    private static Boolean isGreaterThanOrEqualToAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() >= op2.doubleValue();
    }

    private static Boolean isGreaterThanOrEqualToAsLong(final Number op1, final Number op2) {
        return op1.longValue() >= op2.longValue();
    }

    private static Boolean isGreaterThanOrEqualToAsInteger(final Number op1, final Number op2) {
        return op1.intValue() >= op2.intValue();
    }
    
    public static Boolean isLesserThan(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        BooleanNumberOperations::isLesserThanAsDouble,
                        BooleanNumberOperations::isLesserThanAsLong,
                        BooleanNumberOperations::isLesserThanAsInteger);
    }

    private static Boolean isLesserThanAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() < op2.doubleValue();
    }
    
    private static Boolean isLesserThanAsLong(final Number op1, final Number op2) {
        return op1.longValue() < op2.longValue();
    }

    private static Boolean isLesserThanAsInteger(final Number op1, final Number op2) {
        return op1.intValue() < op2.intValue();
    }

    public static Boolean isLesserThanOrEqualTo(final Object op1, final Object op2) {
        return dispatch(op1,
                        op2,
                        BooleanNumberOperations::isLesserThanOrEqualToAsDouble,
                        BooleanNumberOperations::isLesserThanOrEqualToAsLong,
                        BooleanNumberOperations::isLesserThanOrEqualToAsInteger);
    }

    private static Boolean isLesserThanOrEqualToAsDouble(final Number op1, final Number op2) {
        return op1.doubleValue() <= op2.doubleValue();
    }

    private static Boolean isLesserThanOrEqualToAsLong(final Number op1, final Number op2) {
        return op1.longValue() <= op2.longValue();
    }

    private static Boolean isLesserThanOrEqualToAsInteger(final Number op1, final Number op2) {
        return op1.intValue() <= op2.intValue();
    }

    public static Boolean dispatch(final Object lOp, final Object rOp,
    		final BiFunction<Number, Number, Boolean> doubleHandler,
    		final BiFunction<Number, Number, Boolean> longHandler,
    		final BiFunction<Number, Number, Boolean> integerHandler) {
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
    
    
    private static void requireInstanceOf(final Object obj, final Class<?> clazz) {
    	if(!clazz.isInstance(obj)) {
    		throw new IllegalArgumentException("Parameter '"  + obj + "'is not of required type: " + clazz);
    	}
    }

}
