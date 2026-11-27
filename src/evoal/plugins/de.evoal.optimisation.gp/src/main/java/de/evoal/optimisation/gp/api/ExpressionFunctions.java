package de.evoal.optimisation.gp.api;

import java.util.Map;

import de.evoal.core.api.math.EvoalMath;

/**
 * The function set of the module {@value ExpressionTypes#MODULE}, by the qualified names of
 *   their DL types. Another plugin adds functions by passing a larger map to the
 *   {@link ExpressionEvaluator}.
 */
public final class ExpressionFunctions {
    private ExpressionFunctions() {
    }

    /**
     * Protected division: the quotient, 1 if the denominator is 0 (Poli, Langdon and McPhee
     *   2008, sec. 3.2.1, after Koza 1992).
     */
    public static double protectedDivision(final double numerator, final double denominator) {
        if(denominator == 0.0) {
            return 1.0;
        }

        return numerator / denominator;
    }

    /**
     * Protected power: {@code |base|^exponent}, 1 if the result is not finite (EvoAl's own).
     */
    public static double protectedPower(final double base, final double exponent) {
        final double absoluteBase = Math.abs(base);
        final double power = EvoalMath.pow(absoluteBase, exponent);

        return Double.isFinite(power) ? power : 1.0;
    }

    /**
     * Protected square root: the square root of the absolute value (EvoAl's choice).
     */
    public static double protectedSquareRoot(final double radicand) {
        final double absoluteRadicand = Math.abs(radicand);

        return Math.sqrt(absoluteRadicand);
    }

    /**
     * @return The functions of the module by the qualified names of their DL types.
     */
    public static Map<String, ExpressionFunction> standard() {
        final ExpressionFunction plus = ExpressionFunction.binary(Double::sum);
        final ExpressionFunction minus = ExpressionFunction.binary((left, right) -> left - right);
        final ExpressionFunction multiply = ExpressionFunction.binary((left, right) -> left * right);
        final ExpressionFunction division = ExpressionFunction.binary(ExpressionFunctions::protectedDivision);
        final ExpressionFunction squareRoot = ExpressionFunction.unary(ExpressionFunctions::protectedSquareRoot);
        final ExpressionFunction power = ExpressionFunction.binary(ExpressionFunctions::protectedPower);

        return Map.of(ExpressionTypes.MODULE + ".plus", plus,
                      ExpressionTypes.MODULE + ".minus", minus,
                      ExpressionTypes.MODULE + ".multiply", multiply,
                      ExpressionTypes.MODULE + ".protected-division", division,
                      ExpressionTypes.MODULE + ".protected-square-root", squareRoot,
                      ExpressionTypes.MODULE + ".protected-power", power);
    }
}
