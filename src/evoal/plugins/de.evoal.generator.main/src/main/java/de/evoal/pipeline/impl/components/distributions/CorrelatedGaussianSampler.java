package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.random.RandomGenerator;

import lombok.NonNull;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import de.evoal.core.api.utils.Requirements;

/**
 * Draws samples of a multivariate normal distribution from a given random generator.
 * <p>
 * A sample is {@code means + A·z}, where {@code z} consists of independent standard normal
 *   numbers and {@code A} is the symmetric square root of the covariance matrix
 *   ({@code A·A = Σ}), computed once from its eigendecomposition {@code Σ = V·D·Vᵀ} as
 *   {@code A = V·√D·Vᵀ}. commons-math's {@code MultivariateNormalDistribution} uses the same
 *   matrix, but cannot draw its random numbers from EvoAl's {@code RandomService}.
 */
final class CorrelatedGaussianSampler {
    /**
     * Eigenvalues whose absolute value is below this fraction of the largest eigenvalue are
     *   treated as zero. A singular covariance matrix (e.g., of perfectly correlated values)
     *   has eigenvalues of zero, which rounding turns into tiny negative numbers.
     */
    private static final double RELATIVE_EIGENVALUE_TOLERANCE = 1e-12;

    /**
     * Relative tolerance for comparing the entries {@code Σ[i][j]} and {@code Σ[j][i]}.
     */
    private static final double RELATIVE_SYMMETRY_TOLERANCE = 1e-12;

    /**
     * The means of the distribution.
     */
    private final double [] means;

    /**
     * The symmetric square root of the covariance matrix.
     */
    private final RealMatrix samplingMatrix;

    /**
     * @param means The means of the distribution.
     * @param covariance The covariance matrix: square, of the size of {@code means},
     *   symmetric, and positive semi-definite.
     * @throws IllegalArgumentException if the covariance matrix does not fulfil these requirements.
     */
    CorrelatedGaussianSampler(final double @NonNull [] means, final double @NonNull [][] covariance) {
        this(means, covariance, "covariance matrix");
    }

    /**
     * @param means The means of the distribution.
     * @param covariance The covariance matrix: square, of the size of {@code means},
     *   symmetric, and positive semi-definite.
     * @param matrixName The name of the matrix in error messages, e.g., "correlation matrix".
     * @throws IllegalArgumentException if the covariance matrix does not fulfil these requirements.
     */
    CorrelatedGaussianSampler(final double @NonNull [] means, final double @NonNull [][] covariance, final @NonNull String matrixName) {
        requireMatchingSizes(means, covariance, matrixName);

        this.means = means.clone();
        this.samplingMatrix = toSamplingMatrix(covariance, matrixName);
    }

    /**
     * @return The largest absolute value of the given numbers, 0 for an empty array.
     */
    private static double largestMagnitude(final double [] values) {
        return Arrays.stream(values)
                     .map(Math::abs)
                     .max()
                     .orElse(0.0);
    }

    /**
     * Ensures that the covariance matrix has one row and one column per mean.
     */
    private static void requireMatchingSizes(final double [] means, final double [][] covariance, final String matrixName) {
        final int size = means.length;
        Requirements.requireTrue(covariance.length == size,
                "The " + matrixName + " has " + covariance.length + " rows, but there are " + size + " means.");

        for(final double [] row : covariance) {
            Requirements.requireTrue(row.length == size,
                    "The " + matrixName + " has a row with " + row.length + " columns, but there are "
                    + size + " means.");
        }
    }

    /**
     * Draws a sample.
     *
     * @param randomness The source of the standard normal numbers.
     */
    double [] sample(final @NonNull RandomGenerator randomness) {
        final double [] standardNormals = new double[means.length];
        for(int i = 0; i < standardNormals.length; ++i) {
            standardNormals[i] = randomness.nextGaussian();
        }

        return transform(standardNormals);
    }

    /**
     * Turns independent standard normal numbers into a sample: {@code means + A·z}.
     *
     * @param standardNormals The numbers z, one per mean.
     */
    double [] transform(final double @NonNull [] standardNormals) {
        final double [] sample = samplingMatrix.operate(standardNormals);
        for(int i = 0; i < sample.length; ++i) {
            sample[i] += means[i];
        }

        return sample;
    }

    /**
     * Computes the symmetric square root of the covariance matrix.
     *
     * @throws IllegalArgumentException if the matrix is not symmetric or not positive semi-definite.
     */
    private static RealMatrix toSamplingMatrix(final double [][] covariance, final String matrixName) {
        final RealMatrix covarianceMatrix = MatrixUtils.createRealMatrix(covariance);
        final boolean isSymmetric = MatrixUtils.isSymmetric(covarianceMatrix, RELATIVE_SYMMETRY_TOLERANCE);
        Requirements.requireTrue(isSymmetric, "The " + matrixName + " is not symmetric.");

        final EigenDecomposition decomposition = new EigenDecomposition(covarianceMatrix);
        final double [] eigenvalues = decomposition.getRealEigenvalues();
        final double tolerance = RELATIVE_EIGENVALUE_TOLERANCE * largestMagnitude(eigenvalues);

        final double [] roots = new double[eigenvalues.length];
        for(int i = 0; i < eigenvalues.length; ++i) {
            Requirements.requireTrue(eigenvalues[i] >= -tolerance,
                    "The " + matrixName + " is not positive semi-definite (eigenvalue " + eigenvalues[i] + ").");

            // a rounding error of 1e-16 would otherwise contribute its root, 1e-8
            roots[i] = eigenvalues[i] <= tolerance ? 0.0 : Math.sqrt(eigenvalues[i]);
        }

        final RealMatrix eigenvectors = decomposition.getV();
        final RealMatrix rootsOfEigenvalues = MatrixUtils.createRealDiagonalMatrix(roots);
        final RealMatrix transposedEigenvectors = decomposition.getVT();

        return eigenvectors.multiply(rootsOfEigenvalues)
                           .multiply(transposedEigenvectors);
    }
}
