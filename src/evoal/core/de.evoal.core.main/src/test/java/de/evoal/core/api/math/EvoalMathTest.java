package de.evoal.core.api.math;

import java.util.SplittableRandom;
import java.util.function.DoubleUnaryOperator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvoalMathTest {
    private static final double[] SPECIAL_VALUES = {
        Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.0, -0.0, 1.0, -1.0
    };

    /**
     * @return the largest difference between {@code actual} and
     *   {@code expected} for 100,000 values in [low, high), in ulp of the
     *   expected value.
     */
    private static double maximalUlpError(final DoubleUnaryOperator actual, final DoubleUnaryOperator expected, final double low, final double high) {
        final SplittableRandom random = new SplittableRandom(42);

        double maximum = 0;
        for(int i = 0; i < 100_000; i++) {
            final double x = random.nextDouble(low, high);
            final double expectedValue = expected.applyAsDouble(x);
            maximum = Math.max(maximum, Math.abs(actual.applyAsDouble(x) - expectedValue) / Math.ulp(expectedValue));
        }

        return maximum;
    }

    @Test
    public void expIsAccurate() {
        Assertions.assertTrue(maximalUlpError(EvoalMath::exp, StrictMath::exp, -700, 700) <= 4);
    }

    @Test
    public void logIsAccurate() {
        Assertions.assertTrue(maximalUlpError(EvoalMath::log, StrictMath::log, 1e-300, 1e300) <= 1);
    }

    @Test
    public void cosIsAccurate() {
        final SplittableRandom random = new SplittableRandom(42);

        for(int i = 0; i < 100_000; i++) {
            final double x = random.nextDouble(-1000, 1000);
            Assertions.assertEquals(StrictMath.cos(x), EvoalMath.cos(x), 1e-15);
        }
    }

    @Test
    public void integerPowersAreExact() {
        for(int base = -20; base <= 20; base++) {
            for(int exponent = 0; exponent <= 10; exponent++) {
                double expected = 1;
                for(int i = 0; i < exponent; i++) {
                    expected *= base;
                }

                Assertions.assertEquals(expected, EvoalMath.pow(base, exponent), "pow(" + base + ", " + exponent + ")");
            }
        }
    }

    @Test
    public void specialValuesBehaveLikeStrictMath() {
        for(final double x : SPECIAL_VALUES) {
            Assertions.assertEquals(StrictMath.cos(x), EvoalMath.cos(x), "cos(" + x + ")");
            Assertions.assertEquals(StrictMath.exp(x), EvoalMath.exp(x), "exp(" + x + ")");
            Assertions.assertEquals(StrictMath.log(x), EvoalMath.log(x), "log(" + x + ")");
            Assertions.assertEquals(StrictMath.pow(x, 0.5), EvoalMath.pow(x, 0.5), "pow(" + x + ", 0.5)");
        }
    }
}
