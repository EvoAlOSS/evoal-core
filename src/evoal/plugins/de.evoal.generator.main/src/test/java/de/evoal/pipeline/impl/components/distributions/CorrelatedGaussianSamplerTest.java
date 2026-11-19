package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;

public class CorrelatedGaussianSamplerTest {
    private static final int NUMBER_OF_SAMPLES = 100_000;

    private static RandomGenerator generator(final long seed) {
        return RandomService.withSeed(seed).random("correlated-gaussian-sampler-test");
    }

    private static double[][] draw(final CorrelatedGaussianSampler sampler, final RandomGenerator randomness) {
        return IntStream.range(0, NUMBER_OF_SAMPLES)
                        .mapToObj(index -> sampler.sample(randomness))
                        .toArray(double[][]::new);
    }

    private static double mean(final double[][] samples, final int dimension) {
        double sum = 0.0;
        for(final double[] sample : samples) {
            sum += sample[dimension];
        }

        return sum / samples.length;
    }

    private static double covariance(final double[][] samples, final int first, final int second) {
        final double firstMean = mean(samples, first);
        final double secondMean = mean(samples, second);

        double sum = 0.0;
        for(final double[] sample : samples) {
            sum += (sample[first] - firstMean) * (sample[second] - secondMean);
        }

        return sum / (samples.length - 1);
    }

    @Nested
    @DisplayName("given a correlated two-dimensional distribution")
    class Correlated {
        private final double[] means = {1.0, -2.0};
        private final double[][] covariance = {{4.0, 1.5}, {1.5, 1.0}};

        @Test
        public void theSameSeedGivesTheSameSamples() {
            // given
            final CorrelatedGaussianSampler sampler = new CorrelatedGaussianSampler(means, covariance);

            // when
            final double[] first = sampler.sample(generator(42));
            final double[] second = sampler.sample(generator(42));

            // then
            Assertions.assertArrayEquals(first, second);
        }

        @Test
        public void differentSeedsGiveDifferentSamples() {
            // given
            final CorrelatedGaussianSampler sampler = new CorrelatedGaussianSampler(means, covariance);

            // when
            final double[] first = sampler.sample(generator(42));
            final double[] second = sampler.sample(generator(43));

            // then
            Assertions.assertFalse(Arrays.equals(first, second));
        }

        @Test
        public void theSamplesHaveTheConfiguredMeansAndCovariance() {
            // given
            final CorrelatedGaussianSampler sampler = new CorrelatedGaussianSampler(means, covariance);

            // when
            final double[][] samples = draw(sampler, generator(42));

            // then
            Assertions.assertEquals(means[0], mean(samples, 0), 0.03);
            Assertions.assertEquals(means[1], mean(samples, 1), 0.03);
            Assertions.assertEquals(covariance[0][0], covariance(samples, 0, 0), 0.06);
            Assertions.assertEquals(covariance[0][1], covariance(samples, 0, 1), 0.06);
            Assertions.assertEquals(covariance[1][1], covariance(samples, 1, 1), 0.06);
        }
    }

    @Nested
    @DisplayName("given a singular covariance matrix")
    class Singular {
        @Test
        public void theSamplesArePerfectlyCorrelated() {
            // given
            final double[] means = {0.0, 0.0};
            final double[][] covariance = {{1.0, 2.0}, {2.0, 4.0}};
            final CorrelatedGaussianSampler sampler = new CorrelatedGaussianSampler(means, covariance);

            // when
            final double[] sample = sampler.sample(generator(42));

            // then
            Assertions.assertEquals(2.0 * sample[0], sample[1], 1e-9);
        }
    }

    @Nested
    @DisplayName("given an invalid covariance matrix")
    class Invalid {
        @Test
        public void aMatrixWithTheWrongSizeIsRejected() {
            // given
            final double[][] covariance = {{1.0, 0.0}, {0.0, 1.0}};

            // when / then
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CorrelatedGaussianSampler(new double[] {0.0, 0.0, 0.0}, covariance));
        }

        @Test
        public void aNonSquareMatrixIsRejected() {
            // given
            final double[][] covariance = {{1.0, 0.0}, {0.0}};

            // when / then
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CorrelatedGaussianSampler(new double[] {0.0, 0.0}, covariance));
        }

        @Test
        public void anAsymmetricMatrixIsRejected() {
            // given
            final double[][] covariance = {{1.0, 0.5}, {0.0, 1.0}};

            // when / then
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CorrelatedGaussianSampler(new double[] {0.0, 0.0}, covariance));
        }

        @Test
        public void aMatrixWithANegativeEigenvalueIsRejected() {
            // given
            final double[][] covariance = {{1.0, 2.0}, {2.0, 1.0}};

            // when / then
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CorrelatedGaussianSampler(new double[] {0.0, 0.0}, covariance));
        }
    }
}
