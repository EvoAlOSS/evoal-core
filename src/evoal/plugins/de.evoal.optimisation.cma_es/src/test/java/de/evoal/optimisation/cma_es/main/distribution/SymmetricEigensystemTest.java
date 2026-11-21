package de.evoal.optimisation.cma_es.main.distribution;

import java.util.SplittableRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SymmetricEigensystemTest {
    private static final double TOLERANCE = 1.0e-12;

    @Nested
    @DisplayName("given a random symmetric matrix")
    class RandomMatrix {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 7, 20, 60})
        public void eigensystemReconstructsTheMatrix(final int dimension) {
            // given
            final double[][] matrix = randomSymmetric(dimension, 42L + dimension);

            // when
            final SymmetricEigensystem eigensystem = SymmetricEigensystem.of(matrix);

            // then
            final double[] values = eigensystem.eigenvalues();
            final double[][] vectors = eigensystem.eigenvectors();
            final double scale = norm(matrix);
            for(int i = 0; i < dimension; ++i) {
                for(int j = 0; j < dimension; ++j) {
                    double reconstructed = 0.0;
                    double product = 0.0;
                    for(int k = 0; k < dimension; ++k) {
                        reconstructed += vectors[i][k] * values[k] * vectors[j][k];
                        product += vectors[k][i] * vectors[k][j];
                    }

                    Assertions.assertEquals(matrix[i][j], reconstructed, TOLERANCE * scale, "A at " + i + ", " + j);
                    Assertions.assertEquals(i == j ? 1.0 : 0.0, product, TOLERANCE * dimension, "Q^T Q at " + i + ", " + j);
                }
            }

            for(int k = 1; k < dimension; ++k) {
                Assertions.assertTrue(values[k - 1] <= values[k], "the eigenvalues are sorted");
            }
        }

        @Test
        public void decompositionIsRepeatable() {
            // given
            final double[][] matrix = randomSymmetric(30, 7L);

            // when
            final SymmetricEigensystem first = SymmetricEigensystem.of(matrix);
            final SymmetricEigensystem second = SymmetricEigensystem.of(matrix);

            // then
            Assertions.assertArrayEquals(first.eigenvalues(), second.eigenvalues());
            Assertions.assertArrayEquals(first.eigenvectors(), second.eigenvectors());
        }
    }

    @Nested
    @DisplayName("given matrices with known spectra")
    class KnownSpectra {
        @Test
        public void identityHasEigenvaluesOne() {
            // when
            final SymmetricEigensystem eigensystem = SymmetricEigensystem.of(new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});

            // then
            Assertions.assertArrayEquals(new double[] {1, 1, 1}, eigensystem.eigenvalues());
        }

        @Test
        public void twoByTwoMatrixHasItsEigenvalues() {
            // when
            final SymmetricEigensystem eigensystem = SymmetricEigensystem.of(new double[][] {{2, 1}, {1, 2}});

            // then
            Assertions.assertArrayEquals(new double[] {1, 3}, eigensystem.eigenvalues(), TOLERANCE);
        }

        @Test
        public void repeatedEigenvaluesAreFound() {
            // given: eigenvalues 1, 1 and 4 of J + I with J the matrix of ones
            final double[][] matrix = {{2, 1, 1}, {1, 2, 1}, {1, 1, 2}};

            // when
            final SymmetricEigensystem eigensystem = SymmetricEigensystem.of(matrix);

            // then
            Assertions.assertArrayEquals(new double[] {1, 1, 4}, eigensystem.eigenvalues(), TOLERANCE);
        }

        @Test
        public void nonFiniteElementsAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> SymmetricEigensystem.of(new double[][] {{1, Double.NaN}, {Double.NaN, 1}}));
        }
    }

    private static double norm(final double[][] matrix) {
        double sum = 0.0;
        for(final double[] row : matrix) {
            for(final double element : row) {
                sum += element * element;
            }
        }

        return Math.sqrt(sum);
    }

    private static double[][] randomSymmetric(final int dimension, final long seed) {
        final SplittableRandom random = new SplittableRandom(seed);
        final double[][] matrix = new double[dimension][dimension];
        for(int i = 0; i < dimension; ++i) {
            for(int j = 0; j <= i; ++j) {
                final double value = random.nextDouble(-1.0, 1.0);
                matrix[i][j] = value;
                matrix[j][i] = value;
            }
        }

        return matrix;
    }
}
