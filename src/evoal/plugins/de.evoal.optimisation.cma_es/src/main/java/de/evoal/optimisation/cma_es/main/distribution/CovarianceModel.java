package de.evoal.optimisation.cma_es.main.distribution;

/**
 * The covariance matrix C of the search distribution N(m, sigma^2 C) of CMA-ES, with the
 *   decomposition that sampling and the step size control use: C^(1/2) = B D B^T and
 *   C^(-1/2) = B D^-1 B^T (N. Hansen: The CMA evolution strategy: a tutorial,
 *   arXiv:1604.00772v2, 2023, section 0.1 and appendix A). The decomposition may lag behind
 *   C ({@link FullCovariance}); the variances and correlations always describe C.
 */
public sealed interface CovarianceModel permits DiagonalCovariance, FullCovariance {
    /**
     * @param dimension The number n of search variables.
     * @return The identity of a diagonal model (sep-CMA-ES).
     */
    static CovarianceModel diagonal(final int dimension) {
        return new DiagonalCovariance(dimension);
    }

    /**
     * @param dimension The number n of search variables.
     * @param decompositionGap The number of updates after which C is decomposed again, at
     *   least 1.
     * @return The identity of a full model.
     */
    static CovarianceModel full(final int dimension, final int decompositionGap) {
        return new FullCovariance(dimension, decompositionGap);
    }

    /**
     * @return The square of the ratio of the longest to the shortest principal axis, i.e.,
     *   the condition number of C, from the current decomposition.
     */
    double conditionNumber();

    /**
     * @param i The index of a variable.
     * @param j The index of another variable.
     * @return The correlation C_ij / sqrt(C_ii C_jj) the matrix implies; 1 for i = j.
     */
    double correlation(int i, int j);

    /**
     * Decomposes C again if the decomposition is due, before new candidates are sampled.
     */
    void decomposeIfDue();

    /**
     * @return The number n of search variables.
     */
    int dimension();

    /**
     * @param vector A vector v.
     * @return C^(-1/2) v from the current decomposition.
     */
    double[] inverseTransform(double[] vector);

    /**
     * @return Whether C is restricted to its diagonal.
     */
    boolean isDiagonal();

    /**
     * @return The square root of the largest eigenvalue of C, max(diag(D)), from the current
     *   decomposition.
     */
    double largestAxis();

    /**
     * @param axis The index of a principal axis, in [0, n).
     * @return The principal axis D_kk b_k of the current decomposition: an eigenvector of C
     *   scaled by the square root of its eigenvalue.
     */
    double[] principalAxis(int axis);

    /**
     * @param standardNormal A vector z of standard normally distributed numbers.
     * @return y = B D z, distributed as N(0, C) by the current decomposition.
     */
    double[] transform(double[] standardNormal);

    /**
     * Replaces C by decay C + c_1 p p^T + sum_i r_i y_i y_i^T, equation (47) of the
     *   tutorial. The diagonal model updates only the diagonal.
     *
     * @param decay The factor of the old matrix.
     * @param path The evolution path p_c.
     * @param rankOneRate The learning rate c_1 of the rank-one update.
     * @param steps The steps y_i of the selected candidates.
     * @param rankMuRates The learning rates c_mu w_i of the steps.
     */
    void update(double decay, double[] path, double rankOneRate, double[][] steps, double[] rankMuRates);

    /**
     * @param i The index of a variable.
     * @return The variance C_ii.
     */
    double variance(int i);
}
