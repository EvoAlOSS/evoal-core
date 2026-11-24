package de.evoal.pipeline.api.distribution;

/**
 * A distribution of one value with a quantile function (DL type {@code 'univariate-distribution'}).
 *   A copula distribution uses it as a marginal.
 */
public interface UnivariateDistribution extends Distribution {
    /**
     * Returns the quantile F⁻¹(p), the inverse of the distribution function. For a discrete
     *   distribution, it is the smallest value k with F(k) ≥ p.
     *
     * @param p A probability in [0, 1].
     * @return The quantile; ±∞ at 0 or 1 for a distribution without a lower or upper bound.
     */
    double quantile(double p);

    /**
     * @return 1, a sample has one value.
     */
    @Override
    default int dimension() {
        return 1;
    }
}
