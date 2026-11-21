package de.evoal.surrogate.main.gof.rmse;

import de.evoal.core.api.math.EvoalMath;

import java.util.OptionalDouble;

/**
 * The root relative squared error of predicted values (Witten, Frank and Hall, Data Mining,
 *   section "Evaluating numeric prediction"):
 *
 * <pre>
 *   rrse = sqrt( Σ (p_i - a_i)² / Σ (a_i - mean(a))² )
 * </pre>
 *
 * It compares the squared error of a model with the squared error of always predicting the
 *   mean of the actual values: 0 is a perfect model, 1 is as good as predicting the mean.
 */
public final class RootRelativeSquaredError {
    private RootRelativeSquaredError() {
    }

    /**
     * Calculates the root relative squared error.
     *
     * @param actual The actual values.
     * @param predicted The predicted values, in the order of {@code actual}.
     * @return The root relative squared error, or empty if all actual values are equal (the
     *   error of predicting the mean is 0, so the ratio is undefined).
     */
    public static OptionalDouble of(final double[] actual, final double[] predicted) {
        if (actual.length != predicted.length) {
            throw new IllegalArgumentException("Got " + actual.length + " actual but " + predicted.length + " predicted values.");
        }

        final double mean = mean(actual);

        double modelError = 0.0;
        double meanError = 0.0;
        for (int i = 0; i < actual.length; ++i) {
            modelError += EvoalMath.square(predicted[i] - actual[i]);
            meanError += EvoalMath.square(actual[i] - mean);
        }

        if (meanError == 0.0) {
            return OptionalDouble.empty();
        }

        return OptionalDouble.of(Math.sqrt(modelError / meanError));
    }

    private static double mean(final double[] values) {
        double sum = 0.0;
        for (final double value : values) {
            sum += value;
        }

        return sum / values.length;
    }
}
