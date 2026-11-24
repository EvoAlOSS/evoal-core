package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

/**
 * The continuous distributions that sample by inversion. The expected quantiles come from
 *   closed forms, or for the truncated normal distribution from Python's
 *   {@code statistics.NormalDist.inv_cdf} and Φ(x) = erfc(−x/√2)/2 of Python's {@code math}.
 */
public class ContinuousDistributionsTest {
    private static RandomGenerator seeded(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed)).forNewInstance("test");
    }

    @Nested
    @DisplayName("given a truncated normal distribution")
    class TruncatedNormal {
        @Test
        public void theQuantileStaysInTheInterval() {
            final TruncatedNormalDistribution distribution = new TruncatedNormalDistribution(1.0, 2.0, -1.0, 5.0, seeded(1));

            Assertions.assertEquals(-1.0, distribution.quantile(0.0), 1e-12);
            Assertions.assertEquals(0.5151923642215466, distribution.quantile(0.3), 1e-12);
            Assertions.assertEquals(5.0, distribution.quantile(1.0), 1e-12);
        }

        @Test
        public void boundsFarInTheUpperTailKeepTheirPrecision() {
            final TruncatedNormalDistribution distribution = new TruncatedNormalDistribution(0.0, 1.0, 8.0, 9.0, seeded(1));

            Assertions.assertEquals(8.084888899018164, distribution.quantile(0.5), 1e-12);
        }

        @Test
        public void mirroredBoundsGiveMirroredQuantiles() {
            final TruncatedNormalDistribution upper = new TruncatedNormalDistribution(0.0, 1.0, 2.0, 4.0, seeded(1));
            final TruncatedNormalDistribution lower = new TruncatedNormalDistribution(0.0, 1.0, -4.0, -2.0, seeded(1));

            for(final double p : new double[] {0.01, 0.3, 0.5, 0.9}) {
                Assertions.assertEquals(-lower.quantile(1.0 - p), upper.quantile(p), 1e-12);
            }
        }

        @Test
        public void anIntervalWithoutProbabilityIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new TruncatedNormalDistribution(0.0, 1.0, 50.0, 60.0, seeded(1)));
        }

        @Test
        public void theSamplesLieInTheInterval() {
            assertSamplesWithin(new TruncatedNormalDistribution(1.0, 2.0, -1.0, 5.0, seeded(3)), -1.0, 5.0);
        }
    }

    @Nested
    @DisplayName("given a triangular distribution")
    class Triangular {
        @Test
        public void theQuantileHasTwoBranchesThatMeetAtTheMode() {
            final TriangularDistribution distribution = new TriangularDistribution(1.0, 2.0, 5.0, seeded(1));

            Assertions.assertEquals(1.0, distribution.quantile(0.0), 1e-12);
            Assertions.assertEquals(1.6324555320336759, distribution.quantile(0.1), 1e-12);
            Assertions.assertEquals(2.0, distribution.quantile(0.25), 1e-12);
            Assertions.assertEquals(3.450806661517033, distribution.quantile(0.8), 1e-12);
            Assertions.assertEquals(5.0, distribution.quantile(1.0), 1e-12);
        }

        @Test
        public void aModeAtTheMinimumHasOnlyTheFallingBranch() {
            final TriangularDistribution distribution = new TriangularDistribution(0.0, 0.0, 1.0, seeded(1));

            Assertions.assertEquals(0.0, distribution.quantile(0.0), 1e-12);
            Assertions.assertEquals(1.0 - Math.sqrt(0.5), distribution.quantile(0.5), 1e-12);
        }
    }

    @Nested
    @DisplayName("given a beta distribution")
    class Beta {
        @Test
        public void theArcsineDistributionHasAClosedFormQuantile() {
            final BetaDistribution distribution = new BetaDistribution(0.5, 0.5, 0.0, 1.0, seeded(1));

            Assertions.assertEquals(0.20610737385376346, distribution.quantile(0.3), 1e-8);
        }

        @Test
        public void theQuantileIsScaledToTheBounds() {
            final BetaDistribution distribution = new BetaDistribution(1.0, 3.0, 2.0, 4.0, seeded(1));

            Assertions.assertEquals(2.0 + 2.0 * 0.3305670499178305, distribution.quantile(0.7), 1e-8);
            Assertions.assertEquals(2.0, distribution.quantile(0.0), 1e-12);
            Assertions.assertEquals(4.0, distribution.quantile(1.0), 1e-12);
        }
    }

    @Nested
    @DisplayName("given an exponential distribution")
    class Exponential {
        @Test
        public void theQuantileIsTheInverseOfTheDistributionFunction() {
            final ExponentialDistribution distribution = new ExponentialDistribution(0.5, seeded(1));

            Assertions.assertEquals(0.0, distribution.quantile(0.0));
            Assertions.assertEquals(1.83258146374831, distribution.quantile(0.6), 1e-12);
            Assertions.assertEquals(Double.POSITIVE_INFINITY, distribution.quantile(1.0));
        }

        @Test
        public void theSampleMeanIsTheInverseRate() {
            final ExponentialDistribution distribution = new ExponentialDistribution(0.5, seeded(7));
            double sum = 0.0;
            for(int i = 0; i < 20000; ++i) {
                sum += distribution.sample()[0];
            }

            Assertions.assertEquals(2.0, sum / 20000, 0.05);
        }
    }

    @Nested
    @DisplayName("given a gamma distribution")
    class Gamma {
        @Test
        public void shapeOneHalfAndScaleTwoIsTheChiSquaredDistribution() {
            final GammaDistribution distribution = new GammaDistribution(0.5, 2.0, seeded(1));

            Assertions.assertEquals(2.7055434540954106, distribution.quantile(0.9), 1e-8);
        }

        @Test
        public void theScaleStretchesTheQuantile() {
            final GammaDistribution distribution = new GammaDistribution(2.0, 1.5, seeded(1));

            Assertions.assertEquals(2.5175204850249906, distribution.quantile(0.5), 1e-8);
            Assertions.assertEquals(0.0, distribution.quantile(0.0));
        }

        @Test
        public void nonPositiveParametersAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new GammaDistribution(-1.0, 1.0, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new GammaDistribution(1.0, 0.0, seeded(1)));
        }
    }

    @Nested
    @DisplayName("given a Weibull distribution")
    class Weibull {
        @Test
        public void theQuantileIsTheInverseOfTheDistributionFunction() {
            final WeibullDistribution distribution = new WeibullDistribution(1.5, 2.0, seeded(1));

            Assertions.assertEquals(0.0, distribution.quantile(0.0));
            Assertions.assertEquals(1.8867695478059596, distribution.quantile(0.6), 1e-12);
        }

        @Test
        public void shapeOneIsTheExponentialDistribution() {
            final WeibullDistribution weibull = new WeibullDistribution(1.0, 2.0, seeded(1));
            final ExponentialDistribution exponential = new ExponentialDistribution(0.5, seeded(1));

            Assertions.assertEquals(exponential.quantile(0.37), weibull.quantile(0.37), 1e-12);
        }
    }

    @Nested
    @DisplayName("given a seed")
    class Reproducibility {
        @Test
        public void theSameSeedGivesTheSameSamples() {
            Assertions.assertArrayEquals(samples(new GammaDistribution(2.0, 1.0, seeded(11))),
                                         samples(new GammaDistribution(2.0, 1.0, seeded(11))));
        }

        @Test
        public void aSampleIsTheQuantileOfTheNextUniformNumber() {
            final RandomGenerator uniform = seeded(5);
            final TriangularDistribution distribution = new TriangularDistribution(1.0, 2.0, 5.0, seeded(5));

            for(int i = 0; i < 10; ++i) {
                Assertions.assertEquals(distribution.quantile(uniform.nextDouble()), distribution.sample()[0]);
            }
        }
    }

    private static double [] samples(final UnivariateDistribution distribution) {
        final double [] result = new double[100];
        for(int i = 0; i < result.length; ++i) {
            result[i] = distribution.sample()[0];
        }

        return result;
    }

    private static void assertSamplesWithin(final UnivariateDistribution distribution, final double lower, final double upper) {
        Assertions.assertTrue(Arrays.stream(samples(distribution)).allMatch(x -> lower <= x && x <= upper));
    }
}
