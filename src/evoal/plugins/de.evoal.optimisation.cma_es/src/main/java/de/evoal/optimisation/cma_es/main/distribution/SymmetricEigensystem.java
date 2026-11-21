package de.evoal.optimisation.cma_es.main.distribution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * The eigendecomposition A = Q diag(lambda) Q^T of a symmetric matrix A. The matrix is
 *   brought into tridiagonal form by Householder reflections, which is then diagonalised by
 *   implicit symmetric QR steps with Wilkinson shifts (G. H. Golub, C. F. Van Loan: Matrix
 *   Computations, 4th edition, Johns Hopkins University Press, 2013, algorithms 5.1.1,
 *   5.1.3, 8.3.1, 8.3.2 and 8.3.3).
 * <p>
 * The computation uses only addition, subtraction, multiplication, division and
 *   {@link Math#sqrt}, which IEEE 754 defines exactly, so the result is the same on every
 *   platform.
 */
public final class SymmetricEigensystem {
    /**
     * The relative precision of {@code double}, 2^-52.
     */
    private static final double EPSILON = 0x1.0p-52;

    /**
     * The number of QR steps per dimension after which the iteration is considered not to
     *   converge.
     */
    private static final int MAXIMUM_STEPS_PER_DIMENSION = 60;

    /**
     * The eigenvalues in ascending order.
     */
    private final double[] eigenvalues;

    /**
     * The eigenvectors as columns, in the order of the eigenvalues.
     */
    private final double[][] eigenvectors;

    private SymmetricEigensystem(final double[] eigenvalues, final double[][] eigenvectors) {
        this.eigenvalues = eigenvalues;
        this.eigenvectors = eigenvectors;
    }

    /**
     * Applies the rotation G = [c s; -s c] in the plane (k, k + 1) from both sides to the
     *   band of the tridiagonal matrix (T = G^T T G) and from the right to the accumulated
     *   transformation (Q = Q G).
     */
    private static void applyRotation(final double[][] tridiagonal, final double[][] transformation, final int k,
                                      final int lower, final int upper, final double c, final double s) {
        final int first = Math.max(lower, k - 1);
        final int last = Math.min(upper, k + 2);

        for(int column = first; column <= last; ++column) {
            final double top = tridiagonal[k][column];
            final double bottom = tridiagonal[k + 1][column];
            tridiagonal[k][column] = c * top - s * bottom;
            tridiagonal[k + 1][column] = s * top + c * bottom;
        }

        for(int row = first; row <= last; ++row) {
            final double left = tridiagonal[row][k];
            final double right = tridiagonal[row][k + 1];
            tridiagonal[row][k] = c * left - s * right;
            tridiagonal[row][k + 1] = s * left + c * right;
        }

        for(final double[] row : transformation) {
            final double left = row[k];
            final double right = row[k + 1];
            row[k] = c * left - s * right;
            row[k + 1] = s * left + c * right;
        }
    }

    /**
     * Diagonalises the tridiagonal matrix by implicit symmetric QR steps; afterwards, its
     *   diagonal holds the eigenvalues and the columns of the transformation the eigenvectors.
     *
     * @throws IllegalStateException if the iteration does not converge.
     */
    private static void diagonalise(final double[][] tridiagonal, final double[][] transformation) {
        final int dimension = tridiagonal.length;
        final int maximumSteps = MAXIMUM_STEPS_PER_DIMENSION * dimension;

        for(int step = 0; step < maximumSteps; ++step) {
            dropNegligibleOffDiagonals(tridiagonal);

            int upper = dimension - 1;
            while(upper > 0 && tridiagonal[upper][upper - 1] == 0.0) {
                --upper;
            }
            if(upper == 0) {
                return;
            }

            int lower = upper - 1;
            while(lower > 0 && tridiagonal[lower][lower - 1] != 0.0) {
                --lower;
            }

            qrStep(tridiagonal, transformation, lower, upper);
        }

        throw new IllegalStateException("The eigendecomposition did not converge after " + maximumSteps + " steps.");
    }

    /**
     * Sets the off-diagonal elements to 0 that are negligible compared to their diagonal
     *   neighbours.
     */
    private static void dropNegligibleOffDiagonals(final double[][] tridiagonal) {
        for(int i = 0; i + 1 < tridiagonal.length; ++i) {
            final double neighbours = Math.abs(tridiagonal[i][i]) + Math.abs(tridiagonal[i + 1][i + 1]);
            final boolean negligible = Math.abs(tridiagonal[i + 1][i]) <= EPSILON * neighbours;

            if(negligible) {
                tridiagonal[i + 1][i] = 0.0;
                tridiagonal[i][i + 1] = 0.0;
            }
        }
    }

    /**
     * @return The eigenvalues in ascending order.
     */
    public double[] eigenvalues() {
        return eigenvalues.clone();
    }

    /**
     * @return The eigenvectors as columns ({@code [row][column]}), in the order of the
     *   eigenvalues; they are orthonormal.
     */
    public double[][] eigenvectors() {
        return Arrays.stream(eigenvectors)
                     .map(double[]::clone)
                     .toArray(double[][]::new);
    }

    /**
     * @return {@code sqrt(a^2 + b^2)} without overflow or underflow of the squares.
     */
    private static double hypotenuse(final double a, final double b) {
        final double absoluteA = Math.abs(a);
        final double absoluteB = Math.abs(b);
        final double larger = Math.max(absoluteA, absoluteB);
        if(larger == 0.0) {
            return 0.0;
        }

        final double ratio = Math.min(absoluteA, absoluteB) / larger;

        return larger * Math.sqrt(1.0 + ratio * ratio);
    }

    /**
     * @param matrix A symmetric matrix; only its lower triangle is read. It is not changed.
     * @return The eigendecomposition of the matrix.
     * @throws IllegalArgumentException if the matrix is not square or has a non-finite element.
     * @throws IllegalStateException if the iteration does not converge.
     */
    public static SymmetricEigensystem of(final double[][] matrix) {
        final int dimension = matrix.length;
        final double[][] symmetric = new double[dimension][dimension];
        for(int row = 0; row < dimension; ++row) {
            if(matrix[row].length != dimension) {
                throw new IllegalArgumentException("The matrix must be square, but row " + row + " has "
                                                   + matrix[row].length + " instead of " + dimension + " elements.");
            }

            for(int column = 0; column <= row; ++column) {
                final double element = matrix[row][column];
                if(!Double.isFinite(element)) {
                    throw new IllegalArgumentException("The matrix has the non-finite element " + element + " at ("
                                                       + row + ", " + column + ").");
                }

                symmetric[row][column] = element;
                symmetric[column][row] = element;
            }
        }

        final double[][] transformation = identity(dimension);
        tridiagonalise(symmetric, transformation);
        diagonalise(symmetric, transformation);

        return sorted(symmetric, transformation);
    }

    private static double[][] identity(final int dimension) {
        final double[][] identity = new double[dimension][dimension];
        for(int i = 0; i < dimension; ++i) {
            identity[i][i] = 1.0;
        }

        return identity;
    }

    /**
     * One implicit symmetric QR step with Wilkinson shift on the unreduced block
     *   {@code [lower, upper]} of the tridiagonal matrix (Golub, Van Loan, algorithm 8.3.2).
     */
    private static void qrStep(final double[][] tridiagonal, final double[][] transformation,
                               final int lower, final int upper) {
        final double lastDiagonal = tridiagonal[upper][upper];
        final double lastOffDiagonal = tridiagonal[upper][upper - 1];
        final double delta = (tridiagonal[upper - 1][upper - 1] - lastDiagonal) / 2.0;
        final double sign = delta < 0.0 ? -1.0 : 1.0;
        final double root = hypotenuse(delta, lastOffDiagonal);
        final double shift = lastDiagonal - lastOffDiagonal * lastOffDiagonal / (delta + sign * root);

        double x = tridiagonal[lower][lower] - shift;
        double z = tridiagonal[lower + 1][lower];
        for(int k = lower; k < upper; ++k) {
            final double[] rotation = rotation(x, z);
            applyRotation(tridiagonal, transformation, k, lower, upper, rotation[0], rotation[1]);
            if(k > lower) {
                // the rotation annihilates the bulge of the previous one; without rounding it is 0
                tridiagonal[k + 1][k - 1] = 0.0;
                tridiagonal[k - 1][k + 1] = 0.0;
            }

            if(k + 1 < upper) {
                x = tridiagonal[k + 1][k];
                z = tridiagonal[k + 2][k];
            }
        }
    }

    /**
     * @return {@code {c, s}} such that [c s; -s c]^T (a, b)^T = (r, 0)^T (Golub, Van Loan,
     *   algorithm 5.1.3).
     */
    private static double[] rotation(final double a, final double b) {
        if(b == 0.0) {
            return new double[] {1.0, 0.0};
        }

        if(Math.abs(b) > Math.abs(a)) {
            final double tau = -a / b;
            final double s = 1.0 / Math.sqrt(1.0 + tau * tau);

            return new double[] {s * tau, s};
        }

        final double tau = -b / a;
        final double c = 1.0 / Math.sqrt(1.0 + tau * tau);

        return new double[] {c, c * tau};
    }

    /**
     * @return The eigensystem with the eigenvalues in ascending order; equal eigenvalues keep
     *   their order.
     */
    private static SymmetricEigensystem sorted(final double[][] diagonal, final double[][] transformation) {
        final int dimension = diagonal.length;
        final Integer[] order = IntStream.range(0, dimension)
                                         .boxed()
                                         .sorted(Comparator.comparingDouble(i -> diagonal[i][i]))
                                         .toArray(Integer[]::new);

        final double[] values = new double[dimension];
        final double[][] vectors = new double[dimension][dimension];
        for(int column = 0; column < dimension; ++column) {
            final int source = order[column];
            values[column] = diagonal[source][source];

            for(int row = 0; row < dimension; ++row) {
                vectors[row][column] = transformation[row][source];
            }
        }

        return new SymmetricEigensystem(values, vectors);
    }

    /**
     * Brings the symmetric matrix into tridiagonal form by Householder reflections
     *   (Golub, Van Loan, algorithm 8.3.1) and accumulates the reflections in the
     *   transformation.
     */
    private static void tridiagonalise(final double[][] matrix, final double[][] transformation) {
        final int dimension = matrix.length;

        for(int k = 0; k + 2 < dimension; ++k) {
            final int size = dimension - k - 1;
            final double[] column = new double[size];
            for(int i = 0; i < size; ++i) {
                column[i] = matrix[k + 1 + i][k];
            }

            final Householder reflection = Householder.of(column);
            if(reflection.beta() == 0.0) {
                continue;
            }

            reflection.applySymmetric(matrix, k + 1);
            matrix[k + 1][k] = reflection.norm();
            matrix[k][k + 1] = reflection.norm();
            for(int i = k + 2; i < dimension; ++i) {
                matrix[i][k] = 0.0;
                matrix[k][i] = 0.0;
            }

            reflection.applyFromRight(transformation, k + 1);
        }
    }

    /**
     * A Householder reflection P = I - beta v v^T with v_1 = 1 that maps a vector x to
     *   ||x|| e_1 (Golub, Van Loan, algorithm 5.1.1).
     *
     * @param vector The vector v.
     * @param beta The factor beta; 0 if x already is a multiple of e_1.
     * @param norm The norm of x, the first element of P x.
     */
    private record Householder(double[] vector, double beta, double norm) {
        /**
         * Replaces the trailing block {@code [offset.., offset..]} of a symmetric matrix A by
         *   P A P.
         */
        private void applySymmetric(final double[][] matrix, final int offset) {
            final int size = vector.length;
            final double[] p = new double[size];
            for(int i = 0; i < size; ++i) {
                double sum = 0.0;
                for(int j = 0; j < size; ++j) {
                    sum += matrix[offset + i][offset + j] * vector[j];
                }
                p[i] = beta * sum;
            }

            double pTimesV = 0.0;
            for(int i = 0; i < size; ++i) {
                pTimesV += p[i] * vector[i];
            }

            final double[] w = new double[size];
            for(int i = 0; i < size; ++i) {
                w[i] = p[i] - beta / 2.0 * pTimesV * vector[i];
            }

            for(int i = 0; i < size; ++i) {
                for(int j = 0; j < size; ++j) {
                    matrix[offset + i][offset + j] -= vector[i] * w[j] + w[i] * vector[j];
                }
            }
        }

        /**
         * Replaces the columns {@code [offset..]} of the matrix Q by those of Q P.
         */
        private void applyFromRight(final double[][] matrix, final int offset) {
            final int size = vector.length;

            for(final double[] row : matrix) {
                double sum = 0.0;
                for(int j = 0; j < size; ++j) {
                    sum += row[offset + j] * vector[j];
                }

                final double scaled = beta * sum;
                for(int j = 0; j < size; ++j) {
                    row[offset + j] -= scaled * vector[j];
                }
            }
        }

        private static Householder of(final double[] x) {
            final int size = x.length;
            double sigma = 0.0;
            for(int i = 1; i < size; ++i) {
                sigma += x[i] * x[i];
            }

            final double[] v = x.clone();
            v[0] = 1.0;
            if(sigma == 0.0) {
                // x is a multiple of e_1 already, no reflection is needed
                return new Householder(v, 0.0, x[0]);
            }

            final double first = x[0];
            final double norm = Math.sqrt(first * first + sigma);
            final double head = first <= 0.0 ? first - norm : -sigma / (first + norm);
            final double beta = 2.0 * head * head / (sigma + head * head);
            for(int i = 1; i < size; ++i) {
                v[i] = x[i] / head;
            }

            return new Householder(v, beta, norm);
        }
    }
}
