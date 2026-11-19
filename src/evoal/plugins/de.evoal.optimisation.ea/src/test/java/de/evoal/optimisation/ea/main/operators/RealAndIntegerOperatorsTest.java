package de.evoal.optimisation.ea.main.operators;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.ea.Statistics;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.IntegerGenes;
import de.evoal.optimisation.ea.api.genotype.RealGenes;
import de.evoal.optimisation.ea.api.operators.MutationOperator;

/**
 * Statistical tests of the line, arithmetic and BLX-alpha crossovers and of the creep and
 *   single-choice mutations.
 */
public class RealAndIntegerOperatorsTest {
    private static final int TRIALS = 10_000;

    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(11);

    private static RealGenes reals(final double... values) {
        final double[] lower = new double[values.length];
        Arrays.fill(lower, -100.0);
        final double[] upper = new double[values.length];
        Arrays.fill(upper, 100.0);

        return new RealGenes(values.clone(), lower, upper);
    }

    @Test
    public void arithmeticCrossoverGivesTheWeightedMeans() {
        final RealGenes x = reals(0.0, 10.0);
        final RealGenes y = reals(4.0, 20.0);

        new ArithmeticCrossover(1.0, 0.25).recombine(x, y, random);

        Assertions.assertEquals(3.0, x.get(0), 1e-12);
        Assertions.assertEquals(17.5, x.get(1), 1e-12);
        Assertions.assertEquals(1.0, y.get(0), 1e-12);
        Assertions.assertEquals(12.5, y.get(1), 1e-12);
    }

    @Test
    public void lineCrossoverKeepsTheChildOnTheLineWithAUniformFactor() {
        // parents 0 and 1 per gene: the child's value is its factor a in [-0.25, 1.25]
        final LineCrossover crossover = new LineCrossover(1.0, 0.25);
        final long[] bins = new long[3];

        for(int trial = 0; trial < TRIALS; ++trial) {
            final RealGenes x = reals(0.0, 0.0);
            final RealGenes y = reals(1.0, 2.0);
            crossover.recombine(x, y, random);

            final double a = x.get(0);
            Assertions.assertTrue(a >= -0.25 && a <= 1.25);
            // one factor for the whole chromosome: the child lies on the line
            Assertions.assertEquals(2.0 * a, x.get(1), 1e-12);
            bins[(int) Math.min(2, Math.floor((a + 0.25) / 0.5))] += 1;
        }

        for(final long bin : bins) {
            Statistics.assertBinomial(bin, TRIALS, 1.0 / 3.0, "factor third");
        }
    }

    @Test
    public void blxAlphaDrawsUniformlyFromTheExtendedInterval() {
        // parents 0 and 1, alpha 0.5: [-0.5, 1.5]
        final BlxAlphaCrossover crossover = new BlxAlphaCrossover(1.0, 0.5);
        final long[] quarters = new long[4];

        for(int trial = 0; trial < TRIALS; ++trial) {
            final RealGenes x = reals(0.0);
            final RealGenes y = reals(1.0);
            crossover.recombine(x, y, random);

            for(final double value : new double[] {x.get(0), y.get(0)}) {
                Assertions.assertTrue(value >= -0.5 && value <= 1.5);
                quarters[(int) Math.min(3, Math.floor((value + 0.5) / 0.5))] += 1;
            }
        }

        for(final long quarter : quarters) {
            Statistics.assertBinomial(quarter, 2L * TRIALS, 0.25, "quarter of the interval");
        }
    }

    @Test
    public void creepChangesByEveryStepButZeroEquallyOften() {
        final CreepMutation mutation = new CreepMutation(1.0, Double.NaN, 2);
        final long[] counts = new long[5];

        for(int trial = 0; trial < TRIALS; ++trial) {
            final IntegerGenes genes = new IntegerGenes(new long[] {0}, new long[] {-10}, new long[] {10});
            mutation.mutate(genes, 1.0, random);
            counts[(int) genes.get(0) + 2] += 1;
        }

        Assertions.assertEquals(0, counts[2]);
        for(final int change : new int[] {-2, -1, 1, 2}) {
            Statistics.assertBinomial(counts[change + 2], TRIALS, 0.25, "change " + change);
        }
    }

    @Test
    public void singleChoiceChoosesOneChildByItsWeights() {
        final MutationOperator first = new GaussianMutation(0.0, Double.NaN, 0.1);
        final MutationOperator second = new RandomResetMutation(0.0, 0.5);
        final SingleChoiceMutation mutation = new SingleChoiceMutation(1.0, List.of(first, second), new double[] {3.0, 1.0});

        long firstChosen = 0;
        for(int trial = 0; trial < TRIALS; ++trial) {
            final MutationOperator chosen = mutation.choose(random);
            firstChosen += chosen == first ? 1 : 0;
            Assertions.assertTrue(chosen == first || chosen == second);
        }

        Statistics.assertBinomial(firstChosen, TRIALS, 0.75, "first child");
        Assertions.assertEquals(OptionalDouble.of(0.5), second.geneProbability());
    }

    @Test
    public void singleChoiceWithEqualWeightsChoosesUniformly() {
        final List<MutationOperator> children = List.of(new GaussianMutation(1.0, Double.NaN, 0.1),
                                                        new PolynomialMutation(1.0, Double.NaN, 20.0),
                                                        new RandomResetMutation(1.0, Double.NaN));
        final SingleChoiceMutation mutation = new SingleChoiceMutation(1.0, children, new double[0]);

        final long[] counts = new long[3];
        for(int trial = 0; trial < TRIALS; ++trial) {
            counts[children.indexOf(mutation.choose(random))] += 1;
        }

        for(final long count : counts) {
            Statistics.assertBinomial(count, TRIALS, 1.0 / 3.0, "child");
        }
    }

    @Test
    public void singleChoiceDoesNotMutateItself() {
        final SingleChoiceMutation mutation = new SingleChoiceMutation(1.0, List.of(new RandomResetMutation(1.0, Double.NaN)), new double[0]);
        final Genes genes = reals(1.0);

        Assertions.assertThrows(UnsupportedOperationException.class, () -> mutation.mutate(genes, 1.0, random));
    }
}
