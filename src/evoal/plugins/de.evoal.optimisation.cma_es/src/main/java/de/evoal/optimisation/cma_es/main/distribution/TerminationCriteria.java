package de.evoal.optimisation.cma_es.main.distribution;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The termination criteria of a CMA-ES run, as recommended in appendix B.3 of N. Hansen: The
 *   CMA evolution strategy: a tutorial, arXiv:1604.00772v2, 2023. A run that meets one of
 *   them ends; a restart strategy then starts the next run. With L = 10 + ceil(30 n / lambda):
 * <ul>
 *   <li>{@code no-effect-axis}: adding 0.1 standard deviations along a principal axis of C
 *     does not change m,</li>
 *   <li>{@code no-effect-coord}: adding 0.2 standard deviations in a single coordinate does
 *     not change m,</li>
 *   <li>{@code condition-cov}: the condition number of C exceeds the limit,</li>
 *   <li>{@code equal-fun-values}: the best values of the last L iterations are equal,</li>
 *   <li>{@code stagnation}: in the histories of the best and of the median values over the
 *     last 20 % of the iterations, but at least 120 + 30 n / lambda and at most 20 000, the
 *     median of the most recent 30 % is not better than the median of the first 30 %,</li>
 *   <li>{@code tol-x-up}: sigma max(diag(D)) increased by more than the factor,</li>
 *   <li>{@code tol-fun}: the range of the best values of the last L iterations and of all
 *     values of the last iteration is below the tolerance,</li>
 *   <li>{@code tol-x}: sigma sqrt(C_ii) and sigma |p_c,i| are below the tolerance times the
 *     initial step size in every coordinate.</li>
 * </ul>
 *
 * @param tolFun The tolerance of 'tol-fun'; 0 turns the criterion off.
 * @param tolX The tolerance of 'tol-x' relative to the initial step size; 0 turns it off.
 * @param tolXUp The factor of 'tol-x-up'; infinity turns it off.
 * @param conditionCov The limit of 'condition-cov'; infinity turns it off.
 * @param noEffectAxis Whether 'no-effect-axis' is checked.
 * @param noEffectCoord Whether 'no-effect-coord' is checked.
 * @param equalFunValues Whether 'equal-fun-values' is checked.
 * @param stagnation Whether 'stagnation' is checked.
 */
public record TerminationCriteria(double tolFun,
                                  double tolX,
                                  double tolXUp,
                                  double conditionCov,
                                  boolean noEffectAxis,
                                  boolean noEffectCoord,
                                  boolean equalFunValues,
                                  boolean stagnation) {
    /**
     * The criteria with the values of the tutorial: 'tol-fun' 1e-12, 'tol-x' 1e-12,
     *   'tol-x-up' 1e4, 'condition-cov' 1e14 and all other criteria.
     */
    public static final TerminationCriteria DEFAULTS = new TerminationCriteria(1.0e-12, 1.0e-12, 1.0e4, 1.0e14,
                                                                               true, true, true, true);

    /**
     * @param distribution The distribution of the run after its update.
     * @param history The values of the iterations of the run.
     * @param initialStepSize The step size at the start of the run.
     * @return The name of the first criterion that the run meets, in the order of the list
     *   above, or empty.
     */
    public Optional<String> check(final Distribution distribution, final RunHistory history, final double initialStepSize) {
        final int dimension = distribution.parameters().dimension();
        final int populationSize = distribution.parameters().populationSize();
        final int historyLength = 10 + (int) Math.ceil(30.0 * dimension / populationSize);

        if(noEffectAxis && hasNoEffectAxis(distribution)) {
            return Optional.of("no-effect-axis");
        }
        if(noEffectCoord && hasNoEffectCoordinate(distribution)) {
            return Optional.of("no-effect-coord");
        }
        if(distribution.covariance().conditionNumber() > conditionCov) {
            return Optional.of("condition-cov");
        }
        if(equalFunValues && hasEqualBestValues(history, historyLength)) {
            return Optional.of("equal-fun-values");
        }
        if(stagnation && isStagnating(history, dimension, populationSize)) {
            return Optional.of("stagnation");
        }

        final double spread = distribution.stepSize() * distribution.covariance().largestAxis();
        if(spread > tolXUp * initialStepSize) {
            return Optional.of("tol-x-up");
        }
        if(hasSmallFunctionRange(history, historyLength)) {
            return Optional.of("tol-fun");
        }
        if(isWithinTolX(distribution, initialStepSize)) {
            return Optional.of("tol-x");
        }

        return Optional.empty();
    }

    private static boolean hasEqualBestValues(final RunHistory history, final int historyLength) {
        if(history.size() < historyLength) {
            return false;
        }

        final List<Double> recent = recent(history.bestValues(), historyLength);

        return range(recent) == 0.0;
    }

    /**
     * @return Whether m does not change by 0.1 sigma times a principal axis, for some axis.
     */
    private static boolean hasNoEffectAxis(final Distribution distribution) {
        final double[] mean = distribution.mean();
        final double factor = 0.1 * distribution.stepSize();

        for(int axis = 0; axis < mean.length; ++axis) {
            final double[] principal = distribution.covariance().principalAxis(axis);
            boolean unchanged = true;
            for(int i = 0; i < mean.length && unchanged; ++i) {
                unchanged = mean[i] + factor * principal[i] == mean[i];
            }

            if(unchanged) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return Whether m_i does not change by 0.2 sigma sqrt(C_ii), for some coordinate i.
     */
    private static boolean hasNoEffectCoordinate(final Distribution distribution) {
        final double[] mean = distribution.mean();
        final double factor = 0.2 * distribution.stepSize();

        for(int i = 0; i < mean.length; ++i) {
            final double deviation = Math.sqrt(distribution.covariance().variance(i));
            if(mean[i] + factor * deviation == mean[i]) {
                return true;
            }
        }

        return false;
    }

    private boolean hasSmallFunctionRange(final RunHistory history, final int historyLength) {
        if(history.size() < historyLength) {
            return false;
        }

        final List<Double> recent = recent(history.bestValues(), historyLength);
        final double[] last = history.lastValues();
        final double smallest = Math.min(Arrays.stream(last).min().orElseThrow(), min(recent));
        final double largest = Math.max(Arrays.stream(last).max().orElseThrow(), max(recent));

        return largest - smallest < tolFun;
    }

    private static boolean isNotBetter(final List<Double> window, final int part) {
        final double first = median(window.subList(0, part));
        final double latest = median(window.subList(window.size() - part, window.size()));

        return latest >= first;
    }

    private static boolean isStagnating(final RunHistory history, final int dimension, final int populationSize) {
        final int iterations = history.size();
        final int minimum = (int) Math.ceil(120.0 + 30.0 * dimension / populationSize);
        if(iterations < minimum) {
            return false;
        }

        final int fifth = (int) Math.ceil(0.2 * iterations);
        final int windowLength = Math.min(RunHistory.MAXIMUM_LENGTH, Math.max(minimum, fifth));
        final int part = (int) Math.ceil(0.3 * windowLength);
        final List<Double> best = recent(history.bestValues(), windowLength);
        final List<Double> median = recent(history.medianValues(), windowLength);

        return isNotBetter(best, part) && isNotBetter(median, part);
    }

    private boolean isWithinTolX(final Distribution distribution, final double initialStepSize) {
        final double tolerance = tolX * initialStepSize;
        final double stepSize = distribution.stepSize();
        final double[] path = distribution.rankOnePath();

        for(int i = 0; i < path.length; ++i) {
            final double deviation = stepSize * Math.sqrt(distribution.covariance().variance(i));
            final double pathLength = stepSize * Math.abs(path[i]);
            if(deviation >= tolerance || pathLength >= tolerance) {
                return false;
            }
        }

        return true;
    }

    private static double max(final List<Double> values) {
        return values.stream()
                     .mapToDouble(Double::doubleValue)
                     .max()
                     .orElseThrow();
    }

    private static double median(final List<Double> values) {
        final double[] sorted = values.stream()
                                      .mapToDouble(Double::doubleValue)
                                      .sorted()
                                      .toArray();
        final int middle = sorted.length / 2;
        if(sorted.length % 2 == 1) {
            return sorted[middle];
        }

        return (sorted[middle - 1] + sorted[middle]) / 2.0;
    }

    private static double min(final List<Double> values) {
        return values.stream()
                     .mapToDouble(Double::doubleValue)
                     .min()
                     .orElseThrow();
    }

    private static double range(final List<Double> values) {
        return max(values) - min(values);
    }

    private static List<Double> recent(final List<Double> values, final int length) {
        return values.subList(values.size() - length, values.size());
    }
}
