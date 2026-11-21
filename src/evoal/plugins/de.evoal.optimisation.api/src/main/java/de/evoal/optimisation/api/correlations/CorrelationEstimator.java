package de.evoal.optimisation.api.correlations;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.math3.special.Erf;

import de.evoal.core.api.math.EvoalMath;

/**
 * Estimates the correlation of two features from a sample, shared by the statistics writer
 *   {@code 'correlation-statistics'} and the pipeline component
 *   {@code 'correlation-estimation'}, so both give the same values for the same data:
 * <ul>
 *   <li>the Pearson correlation for a {@link CorrelationKind#LINEAR} correlation, K. Pearson:
 *     Mathematical contributions to the theory of evolution. III. Regression, heredity, and
 *     panmixia. Philosophical Transactions A 187, 1896, pp. 253-318;</li>
 *   <li>the Spearman rank correlation with average ranks for ties for a
 *     {@link CorrelationKind#RANK} correlation, C. Spearman: The proof and measurement of
 *     association between two things. American Journal of Psychology 15(1), 1904,
 *     pp. 72-101.</li>
 * </ul>
 * The confidence interval uses Fisher's z-transformation z = atanh(r), R. A. Fisher: On the
 *   "probable error" of a coefficient of correlation deduced from a small sample. Metron 1,
 *   1921, pp. 3-32: z ± q·√variance, transformed back with tanh, where q is the quantile of
 *   the standard normal distribution for the confidence level. The variance is 1/(n−3) for
 *   the Pearson correlation and given by a {@link RankStandardError} for the Spearman
 *   correlation.
 */
public final class CorrelationEstimator {
    private CorrelationEstimator() {
    }

    /**
     * @param kind How the correlation is measured, not {@link CorrelationKind#NOMINAL}.
     * @param first The values of the first feature.
     * @param second The values of the second feature, as many as of the first one.
     * @return The coefficient, {@code null} for fewer than two values or a constant feature.
     * @throws IllegalArgumentException if the kind is nominal or the numbers of values differ.
     */
    public static Double coefficient(final CorrelationKind kind, final double[] first, final double[] second) {
        requireMeasurable(kind, first, second);

        return kind == CorrelationKind.RANK
                ? pearson(ranks(first), ranks(second))
                : pearson(first, second);
    }

    /**
     * @return The covariance (divided by n), {@code null} for fewer than two values.
     */
    public static Double covariance(final double[] first, final double[] second) {
        final int n = first.length;
        if(n < 2) {
            return null;
        }

        final double firstMean = Arrays.stream(first).average().orElseThrow();
        final double secondMean = Arrays.stream(second).average().orElseThrow();
        double sum = 0.0;
        for(int i = 0; i < n; ++i) {
            sum += (first[i] - firstMean) * (second[i] - secondMean);
        }

        return sum / n;
    }

    /**
     * @param kind How the correlation is measured, not {@link CorrelationKind#NOMINAL}.
     * @param first The values of the first feature.
     * @param second The values of the second feature, as many as of the first one.
     * @param confidenceLevel The confidence level of the interval, in (0, 1).
     * @param rankError The variance for a Spearman correlation.
     * @return The estimate.
     * @throws IllegalArgumentException if the kind is nominal, the numbers of values differ or
     *   the confidence level lies outside (0, 1).
     */
    public static CorrelationEstimate estimate(final CorrelationKind kind,
                                               final double[] first,
                                               final double[] second,
                                               final double confidenceLevel,
                                               final RankStandardError rankError) {
        Objects.requireNonNull(rankError, "rankError");
        // also rejects NaN
        if(!(0.0 < confidenceLevel && confidenceLevel < 1.0)) {
            throw new IllegalArgumentException("The confidence level must lie in (0, 1), but is " + confidenceLevel + ".");
        }

        final Double coefficient = coefficient(kind, first, second);
        final int n = first.length;
        if(coefficient == null || n <= 3) {
            return new CorrelationEstimate(kind, n, coefficient, null, null);
        }

        final double variance = kind == CorrelationKind.RANK
                ? rankError.variance(coefficient, n)
                : 1.0 / (n - 3);
        final double quantile = Math.sqrt(2.0) * Erf.erfInv(confidenceLevel);
        final double z = atanh(coefficient);
        final double halfWidth = quantile * Math.sqrt(variance);

        return new CorrelationEstimate(kind, n, coefficient, EvoalMath.tanh(z - halfWidth), EvoalMath.tanh(z + halfWidth));
    }

    /**
     * @return The Pearson correlation, {@code null} for fewer than two values or a constant
     *   feature.
     */
    public static Double pearson(final double[] first, final double[] second) {
        final Double covariance = covariance(first, second);
        if(covariance == null) {
            return null;
        }

        final double firstDeviation = Math.sqrt(covariance(first, first));
        final double secondDeviation = Math.sqrt(covariance(second, second));
        if(firstDeviation == 0.0 || secondDeviation == 0.0) {
            return null;
        }

        return covariance / (firstDeviation * secondDeviation);
    }

    /**
     * @return The ranks of the values from 1, equal values get the average of their ranks.
     */
    public static double[] ranks(final double[] values) {
        final Integer[] order = new Integer[values.length];
        for(int i = 0; i < order.length; ++i) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Double.compare(values[a], values[b]));

        final double[] ranks = new double[values.length];
        int start = 0;
        while(start < order.length) {
            int end = start;
            while(end + 1 < order.length && values[order[end + 1]] == values[order[start]]) {
                ++end;
            }

            final double average = (start + end) / 2.0 + 1.0;
            for(int i = start; i <= end; ++i) {
                ranks[order[i]] = average;
            }
            start = end + 1;
        }

        return ranks;
    }

    /**
     * @return atanh(r); infinite for |r| = 1, so that the interval is [r, r]. Rounding errors
     *   beyond [-1, 1] are clamped.
     */
    private static double atanh(final double coefficient) {
        return EvoalMath.atanh(Math.max(-1.0, Math.min(1.0, coefficient)));
    }

    private static void requireMeasurable(final CorrelationKind kind, final double[] first, final double[] second) {
        if(kind == CorrelationKind.NOMINAL) {
            throw new IllegalArgumentException("A correlation with a nominal feature cannot be measured.");
        }
        if(first.length != second.length) {
            throw new IllegalArgumentException("Both features need the same number of values, but have " + first.length
                                               + " and " + second.length + ".");
        }
    }
}
