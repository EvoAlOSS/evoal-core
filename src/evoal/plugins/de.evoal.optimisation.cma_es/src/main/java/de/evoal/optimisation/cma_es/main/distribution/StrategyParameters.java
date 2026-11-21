package de.evoal.optimisation.cma_es.main.distribution;

import java.util.Arrays;

import de.evoal.core.api.math.EvoalMath;

import static de.evoal.core.api.utils.Requirements.requireTrue;

/**
 * The strategy parameters of a (mu/mu_w, lambda)-CMA-ES. The defaults are those of table 1
 *   of N. Hansen: The CMA evolution strategy: a tutorial, arXiv:1604.00772v2, 2023,
 *   equations (48)-(58), with positive recombination weights only (no active update).
 *
 * @param dimension The number n of search variables.
 * @param populationSize The number lambda of candidates per iteration.
 * @param weights The positive recombination weights w_1 >= ... >= w_mu of the mu best
 *   candidates; they sum to 1.
 * @param effectiveSelectionMass The variance effective selection mass mu_eff = 1 / sum w_i^2.
 * @param cSigma The learning rate c_sigma of the evolution path of the step size.
 * @param dSigma The damping d_sigma of the step size update.
 * @param cC The learning rate c_c of the evolution path of the rank-one update.
 * @param c1 The learning rate c_1 of the rank-one update.
 * @param cMu The learning rate c_mu of the rank-mu update.
 * @param cM The learning rate c_m of the mean.
 */
public record StrategyParameters(int dimension,
                                 int populationSize,
                                 double[] weights,
                                 double effectiveSelectionMass,
                                 double cSigma,
                                 double dSigma,
                                 double cC,
                                 double c1,
                                 double cMu,
                                 double cM) {
    /**
     * The factor alpha_cov of the learning rates of the covariance matrix.
     */
    private static final double ALPHA_COV = 2.0;

    /**
     * @throws IllegalArgumentException if a parameter lies outside its range.
     */
    public StrategyParameters {
        weights = weights.clone();

        requireTrue(dimension >= 1, "The dimension must be at least 1, but is " + dimension + ".");
        requireTrue(weights.length >= 1 && weights.length <= populationSize,
                    "The number of parents must lie in [1, " + populationSize + "], but is " + weights.length + ".");
        requireTrue(Arrays.stream(weights).allMatch(weight -> weight > 0.0),
                    "The recombination weights must be positive: " + Arrays.toString(weights) + ".");
        requireTrue(isInOpenUnitInterval(cSigma), "c_sigma must lie in (0, 1), but is " + cSigma + ".");
        requireTrue(dSigma > 0.0, "d_sigma must be positive, but is " + dSigma + ".");
        requireTrue(isInHalfOpenUnitInterval(cC), "c_c must lie in (0, 1], but is " + cC + ".");
        requireTrue(c1 >= 0.0 && cMu >= 0.0 && c1 + cMu <= 1.0,
                    "c_1 and c_mu must not be negative and sum to at most 1, but are " + c1 + " and " + cMu + ".");
        requireTrue(isInHalfOpenUnitInterval(cM), "c_m must lie in (0, 1], but is " + cM + ".");
    }

    /**
     * @param dimension The number n of search variables.
     * @return The default population size 4 + floor(3 ln n), equation (48).
     */
    public static int defaultPopulationSize(final int dimension) {
        final double logarithm = EvoalMath.log(dimension);

        return 4 + (int) Math.floor(3.0 * logarithm);
    }

    /**
     * @param dimension The number n of search variables.
     * @param populationSize The number lambda of candidates per iteration, at least 2.
     * @param parentNumber The number mu of parents, in [1, lambda]; floor(lambda / 2) by
     *   default.
     * @return The default parameters of table 1 with mu positive weights
     *   w'_i = ln((lambda + 1) / 2) - ln i, normalised to sum 1; the weights of equation (49)
     *   are positive for i <= floor(lambda / 2). If mu exceeds lambda / 2, the weights of the
     *   last parents are not positive and the parameters are rejected.
     * @throws IllegalArgumentException if the numbers do not fit.
     */
    public static StrategyParameters defaults(final int dimension, final int populationSize, final int parentNumber) {
        requireTrue(populationSize >= 2, "The population size must be at least 2, but is " + populationSize + ".");
        requireTrue(parentNumber >= 1 && parentNumber <= populationSize,
                    "The number of parents must lie in [1, " + populationSize + "], but is " + parentNumber + ".");

        final double[] weights = weights(populationSize, parentNumber);
        final double massOfSelection = effectiveSelectionMass(weights);
        final double n = dimension;

        final double cSigma = (massOfSelection + 2.0) / (n + massOfSelection + 5.0);
        final double pathLengthRatio = Math.sqrt((massOfSelection - 1.0) / (n + 1.0)) - 1.0;
        final double dSigma = 1.0 + 2.0 * Math.max(0.0, pathLengthRatio) + cSigma;
        final double cC = (4.0 + massOfSelection / n) / (n + 4.0 + 2.0 * massOfSelection / n);
        final double c1 = ALPHA_COV / ((n + 1.3) * (n + 1.3) + massOfSelection);
        final double rankMuNumerator = 0.25 + massOfSelection + 1.0 / massOfSelection - 2.0;
        final double rankMuDenominator = (n + 2.0) * (n + 2.0) + ALPHA_COV * massOfSelection / 2.0;
        final double cMu = Math.min(1.0 - c1, ALPHA_COV * rankMuNumerator / rankMuDenominator);

        return new StrategyParameters(dimension, populationSize, weights, massOfSelection, cSigma, dSigma, cC, c1, cMu,
                                      1.0);
    }

    /**
     * @return The variance effective selection mass 1 / sum w_i^2 of weights that sum to 1.
     */
    public static double effectiveSelectionMass(final double[] weights) {
        final double sumOfSquares = Arrays.stream(weights)
                                          .map(weight -> weight * weight)
                                          .sum();

        return 1.0 / sumOfSquares;
    }

    @Override
    public boolean equals(final Object other) {
        if(!(other instanceof StrategyParameters parameters)) {
            return false;
        }

        return dimension == parameters.dimension
            && populationSize == parameters.populationSize
            && Arrays.equals(weights, parameters.weights)
            && Double.compare(effectiveSelectionMass, parameters.effectiveSelectionMass) == 0
            && Double.compare(cSigma, parameters.cSigma) == 0
            && Double.compare(dSigma, parameters.dSigma) == 0
            && Double.compare(cC, parameters.cC) == 0
            && Double.compare(c1, parameters.c1) == 0
            && Double.compare(cMu, parameters.cMu) == 0
            && Double.compare(cM, parameters.cM) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Arrays.hashCode(weights) + Double.hashCode(cSigma) + populationSize;
    }

    private static boolean isInHalfOpenUnitInterval(final double value) {
        return value > 0.0 && value <= 1.0;
    }

    private static boolean isInOpenUnitInterval(final double value) {
        return value > 0.0 && value < 1.0;
    }

    /**
     * @return The number mu of parents.
     */
    public int parentNumber() {
        return weights.length;
    }

    /**
     * @return The parameters of the diagonal model (sep-CMA-ES): c_1 and c_mu multiplied by
     *   (n + 2) / 3, c_mu at most 1 - c_1 (R. Ros, N. Hansen: A simple modification in CMA-ES
     *   achieving linear time and space complexity. PPSN X, LNCS 5199, 2008, pp. 296-305,
     *   doi 10.1007/978-3-540-87700-4_30).
     */
    public StrategyParameters separable() {
        final double factor = (dimension + 2.0) / 3.0;
        final double separableC1 = Math.min(1.0, c1 * factor);
        final double separableCMu = Math.min(1.0 - separableC1, cMu * factor);

        return new StrategyParameters(dimension, populationSize, weights, effectiveSelectionMass, cSigma, dSigma, cC,
                                      separableC1, separableCMu, cM);
    }

    @Override
    public String toString() {
        return "lambda = " + populationSize + ", mu = " + weights.length + ", mu_eff = " + effectiveSelectionMass
               + ", c_sigma = " + cSigma + ", d_sigma = " + dSigma + ", c_c = " + cC + ", c_1 = " + c1
               + ", c_mu = " + cMu + ", c_m = " + cM;
    }

    @Override
    public double[] weights() {
        return weights.clone();
    }

    /**
     * @return The parameters with the given learning rates; {@code null} keeps a value.
     */
    public StrategyParameters with(final Double newCSigma,
                                   final Double newDSigma,
                                   final Double newCC,
                                   final Double newC1,
                                   final Double newCMu,
                                   final Double newCM) {
        return new StrategyParameters(dimension,
                                      populationSize,
                                      weights,
                                      effectiveSelectionMass,
                                      newCSigma == null ? cSigma : newCSigma,
                                      newDSigma == null ? dSigma : newDSigma,
                                      newCC == null ? cC : newCC,
                                      newC1 == null ? c1 : newC1,
                                      newCMu == null ? cMu : newCMu,
                                      newCM == null ? cM : newCM);
    }

    /**
     * @return The mu positive weights ln((lambda + 1) / 2) - ln i, normalised to sum 1.
     * @throws IllegalArgumentException if a weight is not positive.
     */
    private static double[] weights(final int populationSize, final int parentNumber) {
        final double logarithmOfCentre = EvoalMath.log((populationSize + 1.0) / 2.0);
        final double[] raw = new double[parentNumber];
        for(int i = 0; i < parentNumber; ++i) {
            raw[i] = logarithmOfCentre - EvoalMath.log(i + 1.0);
        }

        requireTrue(raw[parentNumber - 1] > 0.0,
                    "With a population size of " + populationSize + ", at most " + populationSize / 2
                    + " parents have positive weights, but " + parentNumber + " are configured.");

        final double sum = Arrays.stream(raw).sum();

        return Arrays.stream(raw)
                     .map(weight -> weight / sum)
                     .toArray();
    }
}
