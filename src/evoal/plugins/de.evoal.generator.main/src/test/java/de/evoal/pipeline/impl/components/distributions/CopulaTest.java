package de.evoal.pipeline.impl.components.distributions;

import java.util.List;
import java.util.random.RandomGenerator;

import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

public class CopulaTest {
    private static final double [] UNIT_LOWER = {0.0, 0.0};

    private static final double [] UNIT_UPPER = {1.0, 1.0};

    private static RandomGenerator seeded(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed)).forNewInstance("test");
    }

    private static SobolSequence shiftedSobol(final long seed) {
        return new SobolSequence(UNIT_LOWER, UNIT_UPPER, new RandomShift(), seeded(seed));
    }

    private static NormalDistribution standardNormal() {
        return new NormalDistribution(0.0, 1.0, seeded(1));
    }

    @Nested
    @DisplayName("given univariate distributions")
    class Marginals {
        @Test
        public void theNormalQuantileIsTheInverseOfTheDistributionFunction() {
            final NormalDistribution normal = new NormalDistribution(2.0, 3.0, seeded(1));

            Assertions.assertEquals(2.0, normal.quantile(0.5), 1e-12);
            Assertions.assertEquals(2.0 + 3.0 * 1.959963984540054, normal.quantile(0.975), 1e-9);
            Assertions.assertEquals(Double.NEGATIVE_INFINITY, normal.quantile(0.0));
            Assertions.assertEquals(Double.POSITIVE_INFINITY, normal.quantile(1.0));
        }

        @Test
        public void theUniformQuantileIsLinear() {
            final UniformDistribution uniform = new UniformDistribution(-1.0, 3.0, seeded(1));

            Assertions.assertEquals(-1.0, uniform.quantile(0.0));
            Assertions.assertEquals(0.0, uniform.quantile(0.25));
            Assertions.assertEquals(3.0, uniform.quantile(1.0));
        }

        @Test
        public void theLogNormalQuantileIsTheExponentialOfTheNormalQuantile() {
            final LogNormalDistribution logNormal = new LogNormalDistribution(1.0, 0.5, seeded(1));

            Assertions.assertEquals(Math.exp(1.0), logNormal.quantile(0.5), 1e-12);
            Assertions.assertEquals(Math.exp(1.0 + 0.5 * 1.959963984540054), logNormal.quantile(0.975), 1e-9);
            Assertions.assertEquals(0.0, logNormal.quantile(0.0));
        }

        @Test
        public void theLogNormalSamplesArePositiveWithMedianExpMu() {
            final LogNormalDistribution logNormal = new LogNormalDistribution(1.0, 0.5, seeded(42));
            final double [] samples = new double[10001];

            for(int i = 0; i < samples.length; ++i) {
                samples[i] = logNormal.sample()[0];
                Assertions.assertTrue(samples[i] > 0.0);
            }

            java.util.Arrays.sort(samples);
            Assertions.assertEquals(Math.exp(1.0), samples[5000], 0.05);
        }

        @Test
        public void aNonPositiveSigmaIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new LogNormalDistribution(0.0, 0.0, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new NormalDistribution(0.0, -1.0, seeded(1)));
        }
    }

    @Nested
    @DisplayName("given random points")
    class Points {
        @Test
        public void thePointsLieInTheBox() {
            final RandomPoints points = new RandomPoints(new double[] {-1.0, 10.0}, new double[] {1.0, 11.0}, seeded(42));

            for(int i = 0; i < 1000; ++i) {
                final double [] point = points.sample();
                Assertions.assertTrue(point[0] >= -1.0 && point[0] < 1.0);
                Assertions.assertTrue(point[1] >= 10.0 && point[1] < 11.0);
            }
        }

        @Test
        public void theSameSeedGivesTheSamePoints() {
            final RandomPoints first = new RandomPoints(UNIT_LOWER, UNIT_UPPER, seeded(42));
            final RandomPoints second = new RandomPoints(UNIT_LOWER, UNIT_UPPER, seeded(42));

            for(int i = 0; i < 10; ++i) {
                Assertions.assertArrayEquals(first.sample(), second.sample());
            }
        }

        @Test
        public void invalidBoundsAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new RandomPoints(new double[] {0.0}, UNIT_UPPER, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new RandomPoints(new double[] {1.0, 0.0}, UNIT_UPPER, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new RandomPoints(new double[0], new double[0], seeded(1)));
        }
    }

    @Nested
    @DisplayName("given a Gaussian copula")
    class Gaussian {
        private GaussianCopula prepared(final double [][] correlation) {
            final GaussianCopula copula = new GaussianCopula(correlation);
            copula.prepare(correlation.length);

            return copula;
        }

        @Test
        public void invalidCorrelationMatricesAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new GaussianCopula(new double[][] {{1.0, 0.5}, {0.5, 1.0}}).prepare(3));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> prepared(new double[][] {{1.0, 0.5}, {0.5}}));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> prepared(new double[][] {{1.0, 0.5}, {0.4, 1.0}}));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> prepared(new double[][] {{2.0, 0.5}, {0.5, 1.0}}));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> prepared(new double[][] {{1.0, 0.9, -0.9}, {0.9, 1.0, 0.9}, {-0.9, 0.9, 1.0}}));
        }

        @Test
        public void aSingularCorrelationMatrixIsAcceptedAndGivesEqualValues() {
            final GaussianCopula copula = prepared(new double[][] {{1.0, 1.0}, {1.0, 1.0}});

            final double [] values = copula.apply(new double[] {0.3, 0.7});

            Assertions.assertEquals(values[0], values[1], 1e-12);
        }

        @Test
        public void theIdentityKeepsThePoint() {
            final GaussianCopula copula = prepared(new double[][] {{1.0, 0.0}, {0.0, 1.0}});

            Assertions.assertArrayEquals(new double[] {0.3, 0.7}, copula.apply(new double[] {0.3, 0.7}), 1e-12);
        }

        @Test
        public void theSpearmanCorrelationFollowsFromR() {
            final double ρ = 0.8;
            final CopulaDistribution distribution = new CopulaDistribution(prepared(new double[][] {{1.0, ρ}, {ρ, 1.0}}),
                    List.of(standardNormal(), new LogNormalDistribution(0.0, 0.5, seeded(1))), shiftedSobol(42));
            final double [] x = new double[4096];
            final double [] y = new double[4096];

            for(int i = 0; i < x.length; ++i) {
                final double [] sample = distribution.sample();
                x[i] = sample[0];
                y[i] = sample[1];
            }

            final double spearman = new SpearmansCorrelation().correlation(x, y);
            Assertions.assertEquals(6.0 / Math.PI * Math.asin(ρ / 2.0), spearman, 0.01);
        }
    }

    @Nested
    @DisplayName("given a copula distribution")
    class Distribution {
        @Test
        public void independenceWithNormalMarginalsGivesTheNormalQuantilesOfThePoints() {
            final List<UnivariateDistribution> marginals = List.of(standardNormal(), new NormalDistribution(5.0, 2.0, seeded(1)));
            final CopulaDistribution distribution = new CopulaDistribution(new IndependenceCopula(), marginals, shiftedSobol(42));
            final SobolSequence reference = shiftedSobol(42);

            for(int i = 0; i < 16; ++i) {
                final double [] point = reference.sample();
                final double [] sample = distribution.sample();

                Assertions.assertEquals(StandardNormal.quantile(point[0]), sample[0], 1e-12);
                Assertions.assertEquals(5.0 + 2.0 * StandardNormal.quantile(point[1]), sample[1], 1e-12);
            }
        }

        @Test
        public void pointsOfAnotherDimensionAreRejected() {
            final RandomPoints points = new RandomPoints(new double[] {0.0, 0.0, 0.0}, new double[] {1.0, 1.0, 1.0}, seeded(1));

            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CopulaDistribution(new IndependenceCopula(), List.of(standardNormal(), standardNormal()), points));
        }

        @Test
        public void pointsOffTheUnitCubeAreRejected() {
            final RandomPoints points = new RandomPoints(new double[] {0.0, 0.0}, new double[] {1.0, 2.0}, seeded(1));

            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CopulaDistribution(new IndependenceCopula(), List.of(standardNormal(), standardNormal()), points));
        }

        @Test
        public void aCopulaForAnotherNumberOfMarginalsIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CopulaDistribution(new GaussianCopula(new double[][] {{1.0}}),
                            List.of(standardNormal(), standardNormal()), shiftedSobol(1)));
        }

        @Test
        public void noMarginalIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CopulaDistribution(new IndependenceCopula(), List.of(), shiftedSobol(1)));
        }

        @Test
        public void anInfiniteValueStopsTheRunWithAHint() {
            final SobolSequence unrandomised = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new NoRandomisation(), seeded(1));
            final CopulaDistribution distribution = new CopulaDistribution(new IndependenceCopula(),
                    List.of(standardNormal(), standardNormal()), unrandomised);

            final IllegalStateException error = Assertions.assertThrows(IllegalStateException.class, distribution::sample);
            Assertions.assertTrue(error.getMessage().contains("'random-shift'"));
        }
    }
}
