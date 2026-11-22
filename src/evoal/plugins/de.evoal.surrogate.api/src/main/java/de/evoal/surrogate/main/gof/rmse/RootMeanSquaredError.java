package de.evoal.surrogate.main.gof.rmse;

import de.evoal.core.api.math.EvoalMath;

import java.util.OptionalDouble;

/**
 * The root mean squared error of predicted values:
 *
 * <pre>
 *   rmse = sqrt( Σ (a_i - p_i)² / n )
 * </pre>
 */
public final class RootMeanSquaredError {
    private RootMeanSquaredError() {
    }

    /**
     * Calculates the root mean squared error.
     *
     * @param actual The actual values.
     * @param predicted The predicted values, in the order of {@code actual}.
     * @return The root mean squared error, or empty if there are no values.
     */
    public static OptionalDouble of(final double[] actual, final double[] predicted) {
        if (actual.length != predicted.length) {
            throw new IllegalArgumentException("Got " + actual.length + " actual but " + predicted.length + " predicted values.");
        }

        if (actual.length == 0) {
            return OptionalDouble.empty();
        }

        double squaredError = 0.0;
        for (int i = 0; i < actual.length; ++i) {
            squaredError += EvoalMath.square(actual[i] - predicted[i]);
        }

        return OptionalDouble.of(Math.sqrt(squaredError / actual.length));
    }
}
