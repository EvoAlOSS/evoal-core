package de.evoal.optimisation.gp.api;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * The operation of a function node of an expression. The operands are the values of the
 *   containments of the node, in the order of its attributes.
 */
public interface ExpressionFunction {
    /**
     * @return A function of two operands.
     */
    static ExpressionFunction binary(final DoubleBinaryOperator operation) {
        return new ExpressionFunction() {
            @Override
            public double apply(final double[] operands) {
                return operation.applyAsDouble(operands[0], operands[1]);
            }

            @Override
            public int arity() {
                return 2;
            }
        };
    }

    /**
     * @return A function of one operand.
     */
    static ExpressionFunction unary(final DoubleUnaryOperator operation) {
        return new ExpressionFunction() {
            @Override
            public double apply(final double[] operands) {
                return operation.applyAsDouble(operands[0]);
            }

            @Override
            public int arity() {
                return 1;
            }
        };
    }

    /**
     * @param operands The values of the operands, {@link #arity()} many.
     * @return The value of the function.
     */
    double apply(double[] operands);

    /**
     * @return The number of operands.
     */
    int arity();
}
