package de.evoal.surrogate.api.function;

import de.evoal.surrogate.api.function.PredictionInterval.Interval;

/**
 * Rearranges the values that separately fitted quantile models predict at one point, so they
 *   do not cross (Chernozhukov, Fernández-Val and Galichon 2010): the lower quantile is never
 *   above the upper one. With a single point and three values, rearranging is sorting.
 */
public final class Rearrangement {
    /**
     * The prediction and the interval at a point after the rearrangement.
     *
     * @param prediction The prediction.
     * @param interval The prediction interval.
     */
    public record Rearranged(double prediction, Interval interval) {
    }

    private Rearrangement() {
    }

    /**
     * Rearranges the prediction of a quantile (e.g. the median) and the two bounds: the three
     *   values are sorted, the middle one is the prediction and the outer ones are the bounds.
     *
     * @param prediction The predicted quantile between the bounds.
     * @param lower The predicted lower quantile.
     * @param upper The predicted upper quantile.
     * @return The sorted values.
     */
    public static Rearranged ofQuantile(final double prediction, final double lower, final double upper) {
        final double low = Math.min(prediction, Math.min(lower, upper));
        final double high = Math.max(prediction, Math.max(lower, upper));
        // the sum of the three values minus the outer ones loses digits; select the middle one
        final double middle = Math.max(Math.min(prediction, lower), Math.min(Math.max(prediction, lower), upper));

        return new Rearranged(middle, new Interval(low, high));
    }

    /**
     * Rearranges the bounds only, for a prediction that is no quantile (e.g. the mean): the
     *   prediction stays as it is and may lie outside the interval.
     *
     * @param prediction The prediction.
     * @param lower The predicted lower quantile.
     * @param upper The predicted upper quantile.
     * @return The prediction and the sorted bounds.
     */
    public static Rearranged ofMean(final double prediction, final double lower, final double upper) {
        return new Rearranged(prediction, new Interval(Math.min(lower, upper), Math.max(lower, upper)));
    }
}
