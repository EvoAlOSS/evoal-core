package de.evoal.surrogate.main.gof.interval;

import java.util.OptionalDouble;

/**
 * Measures of prediction intervals (Khosravi, Nahavandi, Creighton and Atiya 2011): how many
 *   values the intervals hold and how wide they are.
 */
public final class PredictionIntervalMeasures {
    private PredictionIntervalMeasures() {
    }

    /**
     * The prediction interval coverage probability: the share of values that lie in their
     *   interval, bounds included.
     *
     * @param actual The actual values.
     * @param lower The lower bounds, in the order of {@code actual}.
     * @param upper The upper bounds, in the order of {@code actual}.
     * @return The share in [0, 1], or empty if there are no values.
     */
    public static OptionalDouble picp(final double[] actual, final double[] lower, final double[] upper) {
        requireSameLength(actual, lower, upper);
        if(actual.length == 0) {
            return OptionalDouble.empty();
        }

        int inside = 0;
        for(int i = 0; i < actual.length; ++i) {
            if(lower[i] <= actual[i] && actual[i] <= upper[i]) {
                inside += 1;
            }
        }

        return OptionalDouble.of(inside / (double) actual.length);
    }

    /**
     * The mean prediction interval width.
     *
     * @param lower The lower bounds.
     * @param upper The upper bounds, in the order of {@code lower}.
     * @return The mean of {@code upper − lower}, or empty if there are no intervals.
     */
    public static OptionalDouble mpiw(final double[] lower, final double[] upper) {
        requireSameLength(lower, lower, upper);
        if(lower.length == 0) {
            return OptionalDouble.empty();
        }

        double sum = 0.0;
        for(int i = 0; i < lower.length; ++i) {
            sum += upper[i] - lower[i];
        }

        return OptionalDouble.of(sum / lower.length);
    }

    private static void requireSameLength(final double[] actual, final double[] lower, final double[] upper) {
        if(actual.length != lower.length || actual.length != upper.length) {
            throw new IllegalArgumentException("Got " + actual.length + " values, " + lower.length + " lower and " + upper.length + " upper bounds.");
        }
    }
}
