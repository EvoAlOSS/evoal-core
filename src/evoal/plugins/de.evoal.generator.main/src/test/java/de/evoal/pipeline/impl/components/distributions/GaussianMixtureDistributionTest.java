package de.evoal.pipeline.impl.components.distributions;

import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;

/**
 * The Gaussian mixture. The expected quantiles come from a bisection in Python with
 *   Φ(x) = erfc(−x/√2)/2, independent of Commons Math.
 */
public class GaussianMixtureDistributionTest {
    private static RandomGenerator seeded(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed)).forNewInstance("test");
    }

    /**
     * 0.3·N(0, 1) + 0.7·N(5, 2²).
     */
    private final GaussianMixtureDistribution mixture =
            new GaussianMixtureDistribution(new double[] {0.3, 0.7}, new double[] {0.0, 5.0}, new double[] {1.0, 2.0}, seeded(1));

    @Test
    public void theQuantileInvertsTheDistributionFunction() {
        Assertions.assertEquals(0.810306400283141, mixture.quantile(0.25), 1e-10);
        Assertions.assertEquals(3.8682405726997566, mixture.quantile(0.5), 1e-10);
        Assertions.assertEquals(7.13514104775812, mixture.quantile(0.9), 1e-10);
    }

    @Test
    public void theTailsKeepTheirPrecision() {
        Assertions.assertEquals(-8.969155214299983, mixture.quantile(1e-12), 1e-9);
        Assertions.assertEquals(16.879204673457615, mixture.quantile(1.0 - 1e-9), 1e-6);
    }

    @Test
    public void theBoundsMapToInfinity() {
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, mixture.quantile(0.0));
        Assertions.assertEquals(Double.POSITIVE_INFINITY, mixture.quantile(1.0));
    }

    @Test
    public void oneComponentIsTheNormalDistribution() {
        final GaussianMixtureDistribution single =
                new GaussianMixtureDistribution(new double[] {1.0}, new double[] {2.0}, new double[] {3.0}, seeded(1));
        final NormalDistribution normal = new NormalDistribution(2.0, 3.0, seeded(1));

        for(final double p : new double[] {1e-6, 0.1, 0.5, 0.8, 0.999}) {
            Assertions.assertEquals(normal.quantile(p), single.quantile(p), 1e-9, "p = " + p);
        }
    }

    @Test
    public void theSamplesHaveTheMixtureMean() {
        final GaussianMixtureDistribution distribution =
                new GaussianMixtureDistribution(new double[] {0.3, 0.7}, new double[] {0.0, 5.0}, new double[] {1.0, 2.0}, seeded(9));
        double sum = 0.0;
        for(int i = 0; i < 20000; ++i) {
            sum += distribution.sample()[0];
        }

        Assertions.assertEquals(3.5, sum / 20000, 0.05);
    }

    @Test
    public void invalidComponentsAreRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GaussianMixtureDistribution(
                new double[] {0.5, 0.5}, new double[] {0.0}, new double[] {1.0, 1.0}, seeded(1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GaussianMixtureDistribution(
                new double[] {0.5, 0.4}, new double[] {0.0, 1.0}, new double[] {1.0, 1.0}, seeded(1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GaussianMixtureDistribution(
                new double[] {1.5, -0.5}, new double[] {0.0, 1.0}, new double[] {1.0, 1.0}, seeded(1)));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GaussianMixtureDistribution(
                new double[] {0.5, 0.5}, new double[] {0.0, 1.0}, new double[] {1.0, 0.0}, seeded(1)));
    }
}
