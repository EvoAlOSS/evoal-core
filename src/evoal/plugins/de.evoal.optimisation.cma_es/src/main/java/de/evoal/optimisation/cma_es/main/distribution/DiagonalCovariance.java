package de.evoal.optimisation.cma_es.main.distribution;

import java.util.Arrays;

/**
 * A diagonal covariance matrix (sep-CMA-ES: R. Ros, N. Hansen: A simple modification in
 *   CMA-ES achieving linear time and space complexity. PPSN X, LNCS 5199, 2008,
 *   pp. 296-305, doi 10.1007/978-3-540-87700-4_30). Only the variances are adapted, so
 *   sampling and updating take linear time and space; the principal axes are the coordinate
 *   axes and every correlation is 0.
 */
public final class DiagonalCovariance implements CovarianceModel {
    /**
     * The variances C_ii.
     */
    private final double[] variances;

    /**
     * Creates the identity.
     *
     * @param dimension The number n of search variables.
     */
    DiagonalCovariance(final int dimension) {
        variances = new double[dimension];
        Arrays.fill(variances, 1.0);
    }

    @Override
    public double conditionNumber() {
        final double largest = Arrays.stream(variances).max().orElseThrow();
        final double smallest = Arrays.stream(variances).min().orElseThrow();

        return largest / smallest;
    }

    @Override
    public double correlation(final int i, final int j) {
        return i == j ? 1.0 : 0.0;
    }

    /**
     * Does nothing: the diagonal is its own decomposition.
     */
    @Override
    public void decomposeIfDue() {
    }

    @Override
    public int dimension() {
        return variances.length;
    }

    @Override
    public double[] inverseTransform(final double[] vector) {
        final double[] scaled = new double[variances.length];
        for(int i = 0; i < variances.length; ++i) {
            scaled[i] = vector[i] / Math.sqrt(variances[i]);
        }

        return scaled;
    }

    @Override
    public boolean isDiagonal() {
        return true;
    }

    @Override
    public double largestAxis() {
        final double largest = Arrays.stream(variances).max().orElseThrow();

        return Math.sqrt(largest);
    }

    @Override
    public double[] principalAxis(final int axis) {
        final double[] principal = new double[variances.length];
        principal[axis] = Math.sqrt(variances[axis]);

        return principal;
    }

    @Override
    public double[] transform(final double[] standardNormal) {
        final double[] scaled = new double[variances.length];
        for(int i = 0; i < variances.length; ++i) {
            scaled[i] = Math.sqrt(variances[i]) * standardNormal[i];
        }

        return scaled;
    }

    @Override
    public void update(final double decay, final double[] path, final double rankOneRate, final double[][] steps,
                       final double[] rankMuRates) {
        for(int i = 0; i < variances.length; ++i) {
            double rankMu = 0.0;
            for(int s = 0; s < steps.length; ++s) {
                rankMu += rankMuRates[s] * steps[s][i] * steps[s][i];
            }

            variances[i] = decay * variances[i] + rankOneRate * path[i] * path[i] + rankMu;
        }
    }

    @Override
    public double variance(final int i) {
        return variances[i];
    }
}
