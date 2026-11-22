package de.evoal.pipeline.impl.components.distributions;

/**
 * The distribution function Φ and the quantile function Φ⁻¹ of the standard normal
 *   distribution, computed by Commons Math (by the error function and its inverse).
 */
final class StandardNormal {
    /**
     * Commons Math's standard normal distribution, used only for Φ and Φ⁻¹; it has no random
     *   generator, so it must not sample.
     */
    private static final org.apache.commons.math3.distribution.NormalDistribution DISTRIBUTION
            = new org.apache.commons.math3.distribution.NormalDistribution(null, 0.0, 1.0);

    private StandardNormal() {
    }

    /**
     * @return Φ(z), in [0, 1].
     */
    static double cdf(final double z) {
        return DISTRIBUTION.cumulativeProbability(z);
    }

    /**
     * @param p A probability in [0, 1].
     * @return Φ⁻¹(p); −∞ for 0 and +∞ for 1.
     */
    static double quantile(final double p) {
        return DISTRIBUTION.inverseCumulativeProbability(p);
    }
}
