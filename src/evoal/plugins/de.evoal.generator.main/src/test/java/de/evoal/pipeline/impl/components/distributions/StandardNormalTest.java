package de.evoal.pipeline.impl.components.distributions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The quantile function Φ⁻¹ of {@link StandardNormal} (AS 241), checked against known
 *   values and against Φ, which Commons Math computes independently.
 */
public class StandardNormalTest {
    @Test
    public void theCentralQuantilesHaveTheirKnownValues() {
        Assertions.assertEquals(0.0, StandardNormal.quantile(0.5));
        Assertions.assertEquals(1.959963984540054, StandardNormal.quantile(0.975), 1e-15);
        Assertions.assertEquals(-1.959963984540054, StandardNormal.quantile(0.025), 1e-15);
    }

    @Test
    public void theBoundsMapToInfinity() {
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, StandardNormal.quantile(0.0));
        Assertions.assertEquals(Double.POSITIVE_INFINITY, StandardNormal.quantile(1.0));
    }

    @Test
    public void smallProbabilitiesKeepTheirRelativePrecision() {
        for(final double p : new double[] {1e-3, 1e-10, 1e-16, 1e-50, 1e-300}) {
            final double z = StandardNormal.quantile(p);

            Assertions.assertEquals(1.0, StandardNormal.cdf(z) / p, 1e-12, "p = " + p);
        }
    }

    @Test
    public void theQuantileIsSymmetric() {
        for(final double p : new double[] {1e-6, 0.01, 0.2, 0.4}) {
            Assertions.assertEquals(-StandardNormal.quantile(p), StandardNormal.quantile(1.0 - p), 1e-9);
        }
    }
}
