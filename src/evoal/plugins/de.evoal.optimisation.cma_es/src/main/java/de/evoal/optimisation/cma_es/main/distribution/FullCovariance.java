package de.evoal.optimisation.cma_es.main.distribution;

import java.util.Arrays;

/**
 * A full covariance matrix. C is decomposed lazily, after every {@code decompositionGap}
 *   updates, as the tutorial suggests in appendix B.2 (max(1, floor(1 / (10 n (c_1 + c_mu))))
 *   updates), which reduces the effort of the eigendecomposition from O(n^3) to O(n^2) per
 *   candidate.
 * <p>
 * Eigenvalues below the largest one divided by {@link #MAXIMUM_CONDITION} are raised to this
 *   value, so rounding cannot make the decomposition singular; the termination criterion
 *   'condition-cov' ends a run long before.
 */
public final class FullCovariance implements CovarianceModel {
    /**
     * The largest condition number of the decomposition.
     */
    private static final double MAXIMUM_CONDITION = 1.0e20;

    /**
     * The eigenvectors of the last decomposition as columns.
     */
    private double[][] axes;

    /**
     * The matrix C.
     */
    private final double[][] covariance;

    /**
     * The number of updates after which C is decomposed again.
     */
    private final int decompositionGap;

    /**
     * The square roots of the eigenvalues of the last decomposition, in ascending order.
     */
    private double[] lengths;

    /**
     * The number of updates since the last decomposition.
     */
    private int updatesSinceDecomposition;

    /**
     * Creates the identity.
     *
     * @param dimension The number n of search variables.
     * @param decompositionGap The number of updates after which C is decomposed again, at
     *   least 1.
     */
    FullCovariance(final int dimension, final int decompositionGap) {
        if(decompositionGap < 1) {
            throw new IllegalArgumentException("The decomposition gap must be at least 1, but is " + decompositionGap + ".");
        }

        this.decompositionGap = decompositionGap;
        this.covariance = identity(dimension);
        this.axes = identity(dimension);
        this.lengths = new double[dimension];
        Arrays.fill(lengths, 1.0);
    }

    /**
     * Creates the given matrix, decomposed, e.g., the initial matrix of a reference
     *   implementation in tests.
     *
     * @param initial A symmetric positive definite matrix.
     * @param decompositionGap The number of updates after which C is decomposed again, at
     *   least 1.
     */
    FullCovariance(final double[][] initial, final int decompositionGap) {
        this(initial.length, decompositionGap);
        for(int i = 0; i < initial.length; ++i) {
            System.arraycopy(initial[i], 0, covariance[i], 0, initial.length);
        }

        decompose();
    }

    @Override
    public double conditionNumber() {
        final double longest = lengths[lengths.length - 1];
        final double shortest = lengths[0];

        return longest * longest / (shortest * shortest);
    }

    @Override
    public double correlation(final int i, final int j) {
        if(i == j) {
            return 1.0;
        }

        final double scale = Math.sqrt(covariance[i][i] * covariance[j][j]);

        return covariance[i][j] / scale;
    }

    /**
     * Decomposes C now.
     */
    public void decompose() {
        final SymmetricEigensystem eigensystem = SymmetricEigensystem.of(covariance);
        final double[] eigenvalues = eigensystem.eigenvalues();
        final double smallest = eigenvalues[eigenvalues.length - 1] / MAXIMUM_CONDITION;

        lengths = Arrays.stream(eigenvalues)
                        .map(eigenvalue -> Math.sqrt(Math.max(eigenvalue, smallest)))
                        .toArray();
        axes = eigensystem.eigenvectors();
        updatesSinceDecomposition = 0;
    }

    @Override
    public void decomposeIfDue() {
        if(updatesSinceDecomposition >= decompositionGap) {
            decompose();
        }
    }

    @Override
    public int dimension() {
        return covariance.length;
    }

    private static double[][] identity(final int dimension) {
        final double[][] identity = new double[dimension][dimension];
        for(int i = 0; i < dimension; ++i) {
            identity[i][i] = 1.0;
        }

        return identity;
    }

    @Override
    public double[] inverseTransform(final double[] vector) {
        final int dimension = dimension();
        final double[] scaled = new double[dimension];
        for(int k = 0; k < dimension; ++k) {
            double projection = 0.0;
            for(int i = 0; i < dimension; ++i) {
                projection += axes[i][k] * vector[i];
            }
            scaled[k] = projection / lengths[k];
        }

        return combineAxes(scaled);
    }

    @Override
    public boolean isDiagonal() {
        return false;
    }

    @Override
    public double largestAxis() {
        return lengths[lengths.length - 1];
    }

    /**
     * @return A copy of the matrix C.
     */
    public double[][] matrix() {
        return Arrays.stream(covariance)
                     .map(double[]::clone)
                     .toArray(double[][]::new);
    }

    @Override
    public double[] principalAxis(final int axis) {
        final int dimension = dimension();
        final double[] principal = new double[dimension];
        for(int i = 0; i < dimension; ++i) {
            principal[i] = lengths[axis] * axes[i][axis];
        }

        return principal;
    }

    @Override
    public double[] transform(final double[] standardNormal) {
        final int dimension = dimension();
        final double[] scaled = new double[dimension];
        for(int k = 0; k < dimension; ++k) {
            scaled[k] = lengths[k] * standardNormal[k];
        }

        return combineAxes(scaled);
    }

    /**
     * @return B s, the axes combined with the given coefficients.
     */
    private double[] combineAxes(final double[] coefficients) {
        final int dimension = dimension();
        final double[] combined = new double[dimension];
        for(int i = 0; i < dimension; ++i) {
            double sum = 0.0;
            for(int k = 0; k < dimension; ++k) {
                sum += axes[i][k] * coefficients[k];
            }
            combined[i] = sum;
        }

        return combined;
    }

    @Override
    public void update(final double decay, final double[] path, final double rankOneRate, final double[][] steps,
                       final double[] rankMuRates) {
        final int dimension = dimension();

        // only the lower triangle is computed, so C stays exactly symmetric
        for(int i = 0; i < dimension; ++i) {
            for(int j = 0; j <= i; ++j) {
                double rankMu = 0.0;
                for(int s = 0; s < steps.length; ++s) {
                    rankMu += rankMuRates[s] * steps[s][i] * steps[s][j];
                }

                final double element = decay * covariance[i][j] + rankOneRate * path[i] * path[j] + rankMu;
                covariance[i][j] = element;
                covariance[j][i] = element;
            }
        }

        ++updatesSinceDecomposition;
    }

    @Override
    public double variance(final int i) {
        return covariance[i][i];
    }
}
