package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;
import de.evoal.pipeline.api.distribution.UnivariateDistribution;

/**
 * The discrete distributions: their quantiles are the smallest k with F(k) ≥ p, checked at and
 *   next to the values of F, which are computed by hand.
 */
public class DiscreteDistributionsTest {
    private static RandomGenerator seeded(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed)).forNewInstance("test");
    }

    private static double [] frequencies(final UnivariateDistribution distribution, final int values, final int samples) {
        final double [] result = new double[values];
        for(int i = 0; i < samples; ++i) {
            result[(int) distribution.sample()[0]] += 1.0 / samples;
        }

        return result;
    }

    @Nested
    @DisplayName("given a Bernoulli distribution")
    class Bernoulli {
        @Test
        public void theQuantileIsOneAboveOneMinusP() {
            final BernoulliDistribution distribution = new BernoulliDistribution(0.3, seeded(1));

            Assertions.assertEquals(0.0, distribution.quantile(0.0));
            Assertions.assertEquals(0.0, distribution.quantile(0.7));
            Assertions.assertEquals(1.0, distribution.quantile(0.7000001));
            Assertions.assertEquals(1.0, distribution.quantile(1.0));
        }

        @Test
        public void onesHaveTheProbabilityP() {
            Assertions.assertEquals(0.3, frequencies(new BernoulliDistribution(0.3, seeded(2)), 2, 20000)[1], 0.01);
        }

        @Test
        public void theValuesAreWholeNumbers() {
            final BernoulliDistribution distribution = new BernoulliDistribution(0.3, seeded(1));

            Assertions.assertTrue(distribution.isDiscrete(0));
            Assertions.assertEquals(1, distribution.dimension());
        }
    }

    @Nested
    @DisplayName("given a binomial distribution with n = 10 and p = 0.5")
    class Binomial {
        /**
         * F(4) = 386/1024.
         */
        private static final double F4 = 386.0 / 1024.0;

        @Test
        public void theQuantileJumpsAtTheValuesOfTheDistributionFunction() {
            final BinomialDistribution distribution = new BinomialDistribution(10, 0.5, seeded(1));

            Assertions.assertEquals(0.0, distribution.quantile(0.0));
            Assertions.assertEquals(4.0, distribution.quantile(F4));
            Assertions.assertEquals(5.0, distribution.quantile(F4 + 1e-6));
            Assertions.assertEquals(5.0, distribution.quantile(0.5));
            Assertions.assertEquals(10.0, distribution.quantile(1.0));
        }

        @Test
        public void invalidParametersAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new BinomialDistribution(-1, 0.5, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class, () -> new BinomialDistribution(10, 1.5, seeded(1)));
        }
    }

    @Nested
    @DisplayName("given a Poisson distribution with λ = 2")
    class Poisson {
        @Test
        public void theQuantileJumpsAtTheValuesOfTheDistributionFunction() {
            final PoissonDistribution distribution = new PoissonDistribution(2.0, seeded(1));

            // F(0) = e⁻² = 0.1353, F(1) = 3e⁻² = 0.4060, F(2) = 5e⁻² = 0.6767
            Assertions.assertEquals(0.0, distribution.quantile(0.1));
            Assertions.assertEquals(1.0, distribution.quantile(0.2));
            Assertions.assertEquals(2.0, distribution.quantile(0.5));
            Assertions.assertEquals(3.0, distribution.quantile(0.7));
        }

        @Test
        public void theQuantileOfOneIsInfinite() {
            Assertions.assertEquals(Double.POSITIVE_INFINITY, new PoissonDistribution(2.0, seeded(1)).quantile(1.0));
        }

        @Test
        public void theSampleMeanIsLambda() {
            final PoissonDistribution distribution = new PoissonDistribution(2.0, seeded(3));
            double sum = 0.0;
            for(int i = 0; i < 20000; ++i) {
                sum += distribution.sample()[0];
            }

            Assertions.assertEquals(2.0, sum / 20000, 0.05);
        }
    }

    @Nested
    @DisplayName("given a categorical distribution of 3, 1 and 2 with probabilities 0.2, 0.5 and 0.3")
    class Categorical {
        private final CategoricalDistribution distribution =
                new CategoricalDistribution(new int[] {3, 1, 2}, new double[] {0.2, 0.5, 0.3}, seeded(4));

        @Test
        public void theQuantileFollowsTheOrderOfTheList() {
            Assertions.assertEquals(3.0, distribution.quantile(0.0));
            Assertions.assertEquals(3.0, distribution.quantile(0.2));
            Assertions.assertEquals(1.0, distribution.quantile(0.21));
            Assertions.assertEquals(1.0, distribution.quantile(0.7));
            Assertions.assertEquals(2.0, distribution.quantile(0.71));
            Assertions.assertEquals(2.0, distribution.quantile(1.0));
        }

        @Test
        public void everyValueHasItsProbability() {
            final double [] frequencies = frequencies(distribution, 4, 20000);

            Assertions.assertEquals(0.5, frequencies[1], 0.01);
            Assertions.assertEquals(0.3, frequencies[2], 0.01);
            Assertions.assertEquals(0.2, frequencies[3], 0.01);
        }

        @Test
        public void invalidProbabilitiesAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CategoricalDistribution(new int[] {1, 2}, new double[] {1.0}, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CategoricalDistribution(new int[] {1, 2}, new double[] {1.5, -0.5}, seeded(1)));
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new CategoricalDistribution(new int[] {1, 2}, new double[] {0.5, 0.4}, seeded(1)));
        }
    }

    @Nested
    @DisplayName("given a copula distribution with a discrete and a continuous marginal")
    class Copula {
        private final CopulaDistribution distribution = new CopulaDistribution(new IndependenceCopula(),
                List.of(new PoissonDistribution(2.0, seeded(1)), new NormalDistribution(0.0, 1.0, seeded(1))),
                new SobolSequence(new double[] {0.0, 0.0}, new double[] {1.0, 1.0}, new RandomShift(), seeded(5)));

        @Test
        public void theValuesOfTheDiscreteMarginalAreWholeNumbers() {
            Assertions.assertEquals(2, distribution.dimension());
            Assertions.assertTrue(distribution.isDiscrete(0));
            Assertions.assertFalse(distribution.isDiscrete(1));

            for(int i = 0; i < 64; ++i) {
                final double [] sample = distribution.sample();
                Assertions.assertEquals(Math.rint(sample[0]), sample[0], Arrays.toString(sample));
            }
        }
    }
}
