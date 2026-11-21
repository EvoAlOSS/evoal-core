package de.evoal.optimisation.cma_es.main.distribution;

import java.util.List;

import de.evoal.core.api.math.EvoalMath;

/**
 * The search distribution N(m, sigma^2 C) of a (mu/mu_w, lambda)-CMA-ES with its evolution
 *   paths, as in figure 6 of N. Hansen: The CMA evolution strategy: a tutorial,
 *   arXiv:1604.00772v2, 2023 (equations (38)-(47), cumulative step-size adaptation, rank-one
 *   and rank-mu update with positive weights). The algorithm goes back to N. Hansen,
 *   A. Ostermeier: Completely derandomized self-adaptation in evolution strategies.
 *   Evolutionary Computation 9(2), 2001, pp. 159-195, doi 10.1162/106365601750190398, and
 *   N. Hansen, S. D. Müller, P. Koumoutsakos: Reducing the time complexity of the
 *   derandomized evolution strategy with covariance matrix adaptation (CMA-ES).
 *   Evolutionary Computation 11(1), 2003, pp. 1-18, doi 10.1162/106365603321828970
 *   (rank-mu update).
 * <p>
 * The distribution lives in the unbounded space of the genotypes; candidates are points of
 *   this space.
 */
public final class Distribution {
    /**
     * The covariance matrix C.
     */
    private final CovarianceModel covariance;

    /**
     * The expected length E||N(0, I)|| of a standard normally distributed vector.
     */
    private final double expectedLength;

    /**
     * Whether the evolution path p_c was updated in the last update (h_sigma = 1).
     */
    private boolean lastPathUpdate = true;

    /**
     * The mean m.
     */
    private double[] mean;

    /**
     * The strategy parameters.
     */
    private final StrategyParameters parameters;

    /**
     * The evolution path p_c of the rank-one update.
     */
    private double[] rankOnePath;

    /**
     * The step size sigma.
     */
    private double stepSize;

    /**
     * The evolution path p_sigma of the step size.
     */
    private double[] stepSizePath;

    /**
     * The number of updates since the distribution was created, the generation g.
     */
    private int updates;

    /**
     * @param parameters The strategy parameters.
     * @param covariance The initial covariance matrix, usually the identity.
     * @param mean The initial mean.
     * @param stepSize The initial step size.
     * @throws IllegalArgumentException if the dimensions do not fit or the step size is not
     *   positive.
     */
    public Distribution(final StrategyParameters parameters, final CovarianceModel covariance, final double[] mean,
                        final double stepSize) {
        final int dimension = parameters.dimension();
        if(covariance.dimension() != dimension || mean.length != dimension) {
            throw new IllegalArgumentException("The parameters, the covariance matrix and the mean must have the dimension "
                                               + dimension + ".");
        }
        if(!(stepSize > 0.0) || !Double.isFinite(stepSize)) {
            throw new IllegalArgumentException("The step size must be positive and finite, but is " + stepSize + ".");
        }

        this.parameters = parameters;
        this.covariance = covariance;
        this.mean = mean.clone();
        this.stepSize = stepSize;
        this.stepSizePath = new double[dimension];
        this.rankOnePath = new double[dimension];

        this.expectedLength = expectedLength(dimension);
    }

    /**
     * @return The covariance matrix C; the update changes it.
     */
    public CovarianceModel covariance() {
        return covariance;
    }

    /**
     * @param dimension The dimension n.
     * @return E||N(0, I)|| = sqrt(2) Gamma((n + 1) / 2) / Gamma(n / 2), exactly as pycma for
     *   n <= 100, by the recurrence E_1 = sqrt(2 / pi), E_(k+1) = k / E_k (the product of two
     *   neighbours is 2 Gamma(k / 2 + 1) / Gamma(k / 2) = k). The tutorial approximates it by
     *   sqrt(n) (1 - 1 / (4 n) + 1 / (21 n^2)).
     */
    static double expectedLength(final int dimension) {
        double length = Math.sqrt(2.0 / Math.PI);
        for(int k = 1; k < dimension; ++k) {
            length = k / length;
        }

        return length;
    }

    /**
     * @return Whether the last update updated the evolution path p_c (h_sigma = 1); before
     *   the first update {@code true}.
     */
    public boolean isPathUpdated() {
        return lastPathUpdate;
    }

    /**
     * @return The mean m.
     */
    public double[] mean() {
        return mean.clone();
    }

    private static double norm(final double[] vector) {
        double sum = 0.0;
        for(final double element : vector) {
            sum += element * element;
        }

        return Math.sqrt(sum);
    }

    /**
     * @return The strategy parameters.
     */
    public StrategyParameters parameters() {
        return parameters;
    }

    /**
     * @return The evolution path p_c of the rank-one update.
     */
    public double[] rankOnePath() {
        return rankOnePath.clone();
    }

    /**
     * @param standardNormal A vector z of n standard normally distributed numbers.
     * @return The candidate m + sigma B D z, equations (38)-(40).
     */
    public double[] sample(final double[] standardNormal) {
        final double[] step = covariance.transform(standardNormal);
        final double[] candidate = new double[mean.length];
        for(int i = 0; i < mean.length; ++i) {
            candidate[i] = mean[i] + stepSize * step[i];
        }

        return candidate;
    }

    /**
     * @return The step size sigma.
     */
    public double stepSize() {
        return stepSize;
    }

    /**
     * @return The evolution path p_sigma of the step size.
     */
    public double[] stepSizePath() {
        return stepSizePath.clone();
    }

    /**
     * Updates the distribution from the best candidates of an iteration, equations (41)-(47):
     *   the mean, the evolution paths, the covariance matrix (rank-one update with the
     *   correction delta(h_sigma), rank-mu update), and the step size (cumulative step-size
     *   adaptation). h_sigma is 1 if ||p_sigma|| / sqrt(1 - (1 - c_sigma)^(2 (g + 1))) is less
     *   than (1.4 + 2 / (n + 1)) E||N(0, I)||, otherwise 0 (tutorial, p. 28).
     *
     * @param ranked The candidates of the iteration, the best first; at least mu.
     * @throws IllegalArgumentException if fewer than mu candidates are given.
     */
    public void update(final List<double[]> ranked) {
        final int parents = parameters.parentNumber();
        if(ranked.size() < parents) {
            throw new IllegalArgumentException("The update needs the " + parents + " best candidates, but got "
                                               + ranked.size() + ".");
        }

        final int dimension = mean.length;
        final double[] weights = parameters.weights();
        final double massOfSelection = parameters.effectiveSelectionMass();

        // y_i = (x_i:lambda - m) / sigma and <y>_w, equation (41)
        final double[][] steps = new double[parents][dimension];
        final double[] weightedStep = new double[dimension];
        for(int s = 0; s < parents; ++s) {
            final double[] candidate = ranked.get(s);
            for(int i = 0; i < dimension; ++i) {
                steps[s][i] = (candidate[i] - mean[i]) / stepSize;
                weightedStep[i] += weights[s] * steps[s][i];
            }
        }

        // equation (42)
        final double[] newMean = new double[dimension];
        for(int i = 0; i < dimension; ++i) {
            newMean[i] = mean[i] + parameters.cM() * stepSize * weightedStep[i];
        }

        // equation (43), with C^(-1/2) of the distribution that sampled the candidates
        final double cSigma = parameters.cSigma();
        final double stepSizeFactor = Math.sqrt(cSigma * (2.0 - cSigma) * massOfSelection);
        final double[] whitenedStep = covariance.inverseTransform(weightedStep);
        for(int i = 0; i < dimension; ++i) {
            stepSizePath[i] = (1.0 - cSigma) * stepSizePath[i] + stepSizeFactor * whitenedStep[i];
        }

        ++updates;

        final double stepSizePathLength = norm(stepSizePath);
        final double bias = 1.0 - EvoalMath.pow(1.0 - cSigma, 2.0 * updates);
        final double threshold = (1.4 + 2.0 / (dimension + 1.0)) * expectedLength;
        final boolean pathUpdate = stepSizePathLength / Math.sqrt(bias) < threshold;
        final double h = pathUpdate ? 1.0 : 0.0;

        // equation (45)
        final double cC = parameters.cC();
        final double rankOneFactor = h * Math.sqrt(cC * (2.0 - cC) * massOfSelection);
        for(int i = 0; i < dimension; ++i) {
            rankOnePath[i] = (1.0 - cC) * rankOnePath[i] + rankOneFactor * weightedStep[i];
        }

        // equation (47) with positive weights that sum to 1
        final double c1 = parameters.c1();
        final double cMu = parameters.cMu();
        final double varianceLoss = (1.0 - h) * cC * (2.0 - cC);
        final double decay = 1.0 + c1 * varianceLoss - c1 - cMu;
        final double[] rankMuRates = new double[parents];
        for(int s = 0; s < parents; ++s) {
            rankMuRates[s] = cMu * weights[s];
        }
        covariance.update(decay, rankOnePath, c1, steps, rankMuRates);

        // equation (44)
        final double exponent = cSigma / parameters.dSigma() * (stepSizePathLength / expectedLength - 1.0);
        stepSize *= EvoalMath.exp(exponent);

        mean = newMean;
        lastPathUpdate = pathUpdate;
    }

    /**
     * @return The number of updates since the distribution was created, the generation g.
     */
    public int updates() {
        return updates;
    }
}
