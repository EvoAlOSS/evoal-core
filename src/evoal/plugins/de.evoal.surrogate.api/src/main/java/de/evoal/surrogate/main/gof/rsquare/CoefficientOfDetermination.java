package de.evoal.surrogate.main.gof.rsquare;

import de.evoal.core.api.math.EvoalMath;

import java.util.OptionalDouble;

/**
 * The coefficient of determination R² of predicted values:
 *
 * <pre>
 *   R² = 1 - Σ (a_i - p_i)² / Σ (a_i - mean(a))²
 * </pre>
 *
 * 1 is a perfect model, 0 is as good as predicting the mean of the actual values; worse
 *   models give negative values. On the same values, R² = 1 - rrse².
 */
public final class CoefficientOfDetermination {
    private CoefficientOfDetermination() {
    }

    /**
     * Calculates R².
     *
     * @param actual The actual values.
     * @param predicted The predicted values, in the order of {@code actual}.
     * @return R², or empty if all actual values are equal (there is no variation to explain).
     */
    public static OptionalDouble of(final double[] actual, final double[] predicted) {
        if (actual.length != predicted.length) {
            throw new IllegalArgumentException("Got " + actual.length + " actual but " + predicted.length + " predicted values.");
        }

        double sum = 0.0;
        for (final double value : actual) {
            sum += value;
        }
        final double mean = sum / actual.length;

        double unexplainedVariation = 0.0;
        double totalVariation = 0.0;
        for (int i = 0; i < actual.length; ++i) {
            unexplainedVariation += EvoalMath.square(actual[i] - predicted[i]);
            totalVariation += EvoalMath.square(actual[i] - mean);
        }

        if (totalVariation == 0.0) {
            return OptionalDouble.empty();
        }

        return OptionalDouble.of(1.0 - unexplainedVariation / totalVariation);
    }
}
