package de.evoal.optimisation.ea.main.operators;

import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.ea.Statistics;
import de.evoal.optimisation.ea.api.genotype.BitGenes;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.IntegerGenes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.MutationOperator;

/**
 * Statistical tests of the operators: with a fixed seed and many trials, the observed
 *   frequencies lie within +-4 standard deviations of the binomial expectation.
 */
public class OperatorStatisticsTest {
    private static final int TRIALS = 10_000;

    private static final int GENES = 10;

    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(42);

    private static RealGenes reals(final double value) {
        final double[] values = new double[GENES];
        Arrays.fill(values, value);
        final double[] lower = new double[GENES];
        Arrays.fill(lower, -10.0);
        final double[] upper = new double[GENES];
        Arrays.fill(upper, 10.0);

        return new RealGenes(values, lower, upper);
    }

    private static IntegerGenes integers(final long value) {
        final long[] values = new long[GENES];
        Arrays.fill(values, value);
        final long[] lower = new long[GENES];
        Arrays.fill(lower, -100);
        final long[] upper = new long[GENES];
        Arrays.fill(upper, 100);

        return new IntegerGenes(values, lower, upper);
    }

    private static BitGenes bits(final boolean value) {
        final boolean[] bits = new boolean[GENES];
        Arrays.fill(bits, value);

        return new BitGenes(bits);
    }

    /**
     * @return The number of genes that differ.
     */
    private static int differences(final Genes a, final Genes b) {
        int differences = 0;
        for(int gene = 0; gene < a.size(); ++gene) {
            differences += a.equalAt(b, gene) ? 0 : 1;
        }

        return differences;
    }

    @Nested
    @DisplayName("given a mutation with a gene probability")
    class Mutations {
        /**
         * Counts the changed genes of many mutations.
         */
        private long changedGenes(final MutationOperator mutation, final Genes original, final double geneProbability) {
            long changed = 0;
            for(int trial = 0; trial < TRIALS; ++trial) {
                final Genes genes = original.copy();
                mutation.mutate(genes, geneProbability, random);
                changed += differences(original, genes);
            }

            return changed;
        }

        @Test
        public void bitFlipFlipsEveryBitWithTheGeneProbability() {
            final BitFlipMutation mutation = new BitFlipMutation(1.0, Double.NaN);

            Statistics.assertBinomial(changedGenes(mutation, bits(false), 0.1), (long) TRIALS * GENES, 0.1, "flipped bits");
            Assertions.assertEquals(0, changedGenes(mutation, bits(false), 0.0));
            Assertions.assertEquals((long) TRIALS * GENES, changedGenes(mutation, bits(true), 1.0));
        }

        @Test
        public void gaussianChangesEveryGeneWithTheGeneProbability() {
            final GaussianMutation mutation = new GaussianMutation(1.0, Double.NaN, 0.1);

            Statistics.assertBinomial(changedGenes(mutation, reals(0.0), 0.3), (long) TRIALS * GENES, 0.3, "changed genes");
            Assertions.assertEquals(0, changedGenes(mutation, reals(0.0), 0.0));
            Assertions.assertEquals((long) TRIALS * GENES, changedGenes(mutation, reals(0.0), 1.0));
        }

        @Test
        public void gaussianStepsHaveTheConfiguredStandardDeviation() {
            // sigma 0.1 of the range 20: standard deviation 2
            final GaussianMutation mutation = new GaussianMutation(1.0, Double.NaN, 0.1);

            double sum = 0.0;
            double squares = 0.0;
            for(int trial = 0; trial < TRIALS; ++trial) {
                final RealGenes genes = reals(0.0);
                mutation.mutate(genes, 1.0, random);
                for(int gene = 0; gene < GENES; ++gene) {
                    sum += genes.get(gene);
                    squares += genes.get(gene) * genes.get(gene);
                }
            }

            final int n = TRIALS * GENES;
            final double mean = sum / n;
            final double deviation = Math.sqrt(squares / n - mean * mean);
            Assertions.assertEquals(0.0, mean, 4.0 * 2.0 / Math.sqrt(n));
            Assertions.assertEquals(2.0, deviation, 0.05);
        }

        @Test
        public void randomResetChangesEveryGeneWithTheGeneProbability() {
            final RandomResetMutation mutation = new RandomResetMutation(1.0, Double.NaN);

            // a reset of a real gene keeps its value with probability 0
            Statistics.assertBinomial(changedGenes(mutation, reals(0.5), 0.2), (long) TRIALS * GENES, 0.2, "changed genes");
            Assertions.assertEquals(0, changedGenes(mutation, reals(0.5), 0.0));
        }

        @Test
        public void randomResetDrawsIntegersUniformly() {
            final RandomResetMutation mutation = new RandomResetMutation(1.0, Double.NaN);
            final long[] counts = new long[201];

            for(int trial = 0; trial < TRIALS; ++trial) {
                final IntegerGenes genes = integers(0);
                mutation.mutate(genes, 1.0, random);
                for(int gene = 0; gene < GENES; ++gene) {
                    counts[(int) genes.get(gene) + 100] += 1;
                }
            }

            for(int value = 0; value < counts.length; ++value) {
                Statistics.assertBinomial(counts[value], (long) TRIALS * GENES, 1.0 / 201, "value " + (value - 100));
            }
        }

        @Test
        public void polynomialChangesEveryGeneWithTheGeneProbabilityWithinTheBoundaries() {
            final PolynomialMutation mutation = new PolynomialMutation(1.0, Double.NaN, 20.0);

            Statistics.assertBinomial(changedGenes(mutation, reals(9.9), 0.25), (long) TRIALS * GENES, 0.25, "changed genes");

            for(int trial = 0; trial < TRIALS; ++trial) {
                final RealGenes genes = reals(9.9);
                mutation.mutate(genes, 1.0, random);
                for(int gene = 0; gene < GENES; ++gene) {
                    Assertions.assertTrue(genes.get(gene) >= -10.0 && genes.get(gene) <= 10.0, "value " + genes.get(gene));
                }
            }
        }

        @Test
        public void polynomialMovesUpAndDownEquallyOften() {
            // the polynomial distribution is symmetric for a gene in the middle of its range
            final PolynomialMutation mutation = new PolynomialMutation(1.0, Double.NaN, 20.0);
            long up = 0;
            for(int trial = 0; trial < TRIALS; ++trial) {
                final RealGenes genes = reals(0.0);
                mutation.mutate(genes, 1.0, random);
                for(int gene = 0; gene < GENES; ++gene) {
                    up += genes.get(gene) > 0.0 ? 1 : 0;
                }
            }

            Statistics.assertBinomial(up, (long) TRIALS * GENES, 0.5, "upward moves");
        }
    }

    @Nested
    @DisplayName("given a recombination of two different parents")
    class Recombinations {
        @Test
        public void singlePointCutsUniformlyBetweenTwoGenes() {
            final SinglePointCrossover crossover = new SinglePointCrossover(1.0);
            final long[] cuts = new long[GENES];

            for(int trial = 0; trial < TRIALS; ++trial) {
                final BitGenes first = bits(false);
                final BitGenes second = bits(true);
                crossover.recombine(first, second, random);

                // the first child keeps its genes up to the cut and gets the rest
                final int cut = GENES - differences(bits(false), first);
                cuts[cut] += 1;
                Assertions.assertEquals(GENES, differences(first, second));
            }

            Assertions.assertEquals(0, cuts[0]);
            for(int cut = 1; cut < GENES; ++cut) {
                Statistics.assertBinomial(cuts[cut], TRIALS, 1.0 / (GENES - 1), "cut " + cut);
            }
        }

        @Test
        public void multiPointExchangesEverySecondSegment() {
            final MultiPointCrossover crossover = new MultiPointCrossover(1.0, 2);

            for(int trial = 0; trial < TRIALS; ++trial) {
                final BitGenes first = bits(false);
                crossover.recombine(first, bits(true), random);

                // two cuts: 0...0 1...1 0...0 with a non-empty middle segment
                final String pattern = first.toString();
                Assertions.assertTrue(pattern.matches("0+1+0*"), pattern);
            }
        }

        @Test
        public void uniformExchangesEveryGeneWithTheSwapProbability() {
            final UniformCrossover crossover = new UniformCrossover(1.0, 0.3);
            long exchanged = 0;

            for(int trial = 0; trial < TRIALS; ++trial) {
                final BitGenes first = bits(false);
                crossover.recombine(first, bits(true), random);
                exchanged += differences(bits(false), first);
            }

            Statistics.assertBinomial(exchanged, (long) TRIALS * GENES, 0.3, "exchanged genes");
        }

        @Test
        public void sbxRecombinesEveryGeneWithProbabilityOneHalfAndKeepsTheMean() {
            final SbxCrossover crossover = new SbxCrossover(1.0, 15.0);
            long recombined = 0;

            for(int trial = 0; trial < TRIALS; ++trial) {
                final RealGenes first = reals(-1.0);
                final RealGenes second = reals(1.0);
                crossover.recombine(first, second, random);

                for(int gene = 0; gene < GENES; ++gene) {
                    final double a = first.get(gene);
                    final double b = second.get(gene);
                    final boolean unchanged = Math.min(a, b) == -1.0 && Math.max(a, b) == 1.0;
                    recombined += unchanged ? 0 : 1;

                    // far from the boundaries, the children are symmetric around the parents' mean
                    Assertions.assertEquals(0.0, a + b, 1e-9);
                }
            }

            Statistics.assertBinomial(recombined, (long) TRIALS * GENES, 0.5, "recombined genes");
        }

        @Test
        public void sbxKeepsTheChildrenWithinTheBoundaries() {
            final SbxCrossover crossover = new SbxCrossover(1.0, 2.0);

            for(int trial = 0; trial < TRIALS; ++trial) {
                final RealGenes first = reals(9.5);
                final RealGenes second = reals(-9.5);
                crossover.recombine(first, second, random);

                for(int gene = 0; gene < GENES; ++gene) {
                    Assertions.assertTrue(Math.abs(first.get(gene)) <= 10.0 && Math.abs(second.get(gene)) <= 10.0);
                }
            }
        }
    }
}
