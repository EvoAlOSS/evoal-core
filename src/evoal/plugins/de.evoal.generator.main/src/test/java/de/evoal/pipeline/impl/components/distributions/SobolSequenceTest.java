package de.evoal.pipeline.impl.components.distributions;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.random.RandomGenerator;
import java.util.stream.DoubleStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.random.RandomService;
import de.evoal.pipeline.api.distribution.Randomisation;

public class SobolSequenceTest {
    private static final double [] UNIT_LOWER = {0.0, 0.0};

    private static final double [] UNIT_UPPER = {1.0, 1.0};

    /**
     * A random stream that returns the given numbers from {@code nextDouble()}.
     */
    private static RandomGenerator fixed(final double ... numbers) {
        final PrimitiveIterator.OfDouble iterator = DoubleStream.of(numbers).iterator();

        return new RandomGenerator() {
            @Override
            public double nextDouble() {
                return iterator.nextDouble();
            }

            @Override
            public long nextLong() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static RandomGenerator seeded(final long seed) {
        return RandomStreams.of(RandomService.withSeed(seed)).forNewInstance(SobolSequence.NAME);
    }

    private static double [][] samples(final SobolSequence sequence, final int count) {
        final double [][] result = new double[count][];

        for(int i = 0; i < count; ++i) {
            result[i] = sequence.sample();
        }

        return result;
    }

    @Nested
    @DisplayName("given no randomisation")
    class WithoutRandomisation {
        @Test
        public void theFirstPointsAreThoseOfTheSobolSequence() {
            // given
            final SobolSequence sequence = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new NoRandomisation(), seeded(42));

            // when
            final double [][] points = samples(sequence, 4);

            // then
            Assertions.assertArrayEquals(new double[] {0.0, 0.0}, points[0]);
            Assertions.assertArrayEquals(new double[] {0.5, 0.5}, points[1]);
            Assertions.assertArrayEquals(new double[] {0.75, 0.25}, points[2]);
            Assertions.assertArrayEquals(new double[] {0.25, 0.75}, points[3]);
        }

        @Test
        public void thePointsAreScaledToTheBox() {
            // given
            final SobolSequence sequence = new SobolSequence(new double[] {-1.0, 10.0}, new double[] {3.0, 12.0}, new NoRandomisation(), seeded(42));

            // when
            final double [][] points = samples(sequence, 3);

            // then
            Assertions.assertArrayEquals(new double[] {-1.0, 10.0}, points[0]);
            Assertions.assertArrayEquals(new double[] {1.0, 11.0}, points[1]);
            Assertions.assertArrayEquals(new double[] {2.0, 10.5}, points[2]);
        }

        @Test
        public void theSeedIsIgnored() {
            // given
            final SobolSequence first = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new NoRandomisation(), seeded(42));
            final SobolSequence second = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new NoRandomisation(), seeded(43));

            // then
            Assertions.assertArrayEquals(samples(first, 16), samples(second, 16));
        }

        @Test
        public void everyIntervalOfLengthOneSixteenthHoldsOneOfSixteenPoints() {
            // given
            final SobolSequence sequence = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new NoRandomisation(), seeded(42));
            final int [][] counts = new int[2][16];

            // when
            for(final double [] point : samples(sequence, 16)) {
                counts[0][(int)(point[0] * 16)]++;
                counts[1][(int)(point[1] * 16)]++;
            }

            // then
            for(final int [] dimension : counts) {
                for(final int count : dimension) {
                    Assertions.assertEquals(1, count);
                }
            }
        }
    }

    @Nested
    @DisplayName("given a random shift")
    class WithRandomShift {
        @Test
        public void everyPointIsShiftedAndWrapped() {
            // given
            final SobolSequence sequence = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new RandomShift(), fixed(0.25, 0.625));

            // when
            final double [][] points = samples(sequence, 3);

            // then
            Assertions.assertArrayEquals(new double[] {0.25, 0.625}, points[0]);
            Assertions.assertArrayEquals(new double[] {0.75, 0.125}, points[1]);
            Assertions.assertArrayEquals(new double[] {0.0, 0.875}, points[2]);
        }

        @Test
        public void aSumThatRoundsToTwoStaysBelowOne() {
            Assertions.assertTrue(RandomShift.wrap(2.0) < 1.0);
            Assertions.assertEquals(0.5, RandomShift.wrap(1.5));
            Assertions.assertEquals(0.5, RandomShift.wrap(0.5));
        }

        @Test
        public void theSameSeedGivesTheSamePoints() {
            // given
            final SobolSequence first = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new RandomShift(), seeded(42));
            final SobolSequence second = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new RandomShift(), seeded(42));

            // then
            Assertions.assertArrayEquals(samples(first, 16), samples(second, 16));
        }

        @Test
        public void twoInstancesGetDifferentShifts() {
            // given
            final RandomStreams streams = RandomStreams.of(RandomService.withSeed(42));
            final SobolSequence first = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new RandomShift(), streams.forNewInstance(SobolSequence.NAME));
            final SobolSequence second = new SobolSequence(UNIT_LOWER, UNIT_UPPER, new RandomShift(), streams.forNewInstance(SobolSequence.NAME));

            // then
            Assertions.assertFalse(Arrays.equals(first.sample(), second.sample()));
        }
    }

    @Nested
    @DisplayName("given an invalid configuration")
    class InvalidConfiguration {
        @Test
        public void boundsOfDifferentLengthsAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SobolSequence(new double[] {0.0}, UNIT_UPPER, new NoRandomisation(), seeded(42)));
        }

        @Test
        public void aLowerBoundThatIsNotLessThanTheUpperBoundIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SobolSequence(new double[] {0.0, 1.0}, UNIT_UPPER, new NoRandomisation(), seeded(42)));
        }

        @Test
        public void noDimensionIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SobolSequence(new double[0], new double[0], new NoRandomisation(), seeded(42)));
        }

        @Test
        public void moreThanThousandDimensionsAreRejected() {
            final double [] lower = new double[SobolSequence.MAXIMUM_DIMENSION + 1];
            final double [] upper = DoubleStream.generate(() -> 1.0).limit(lower.length).toArray();

            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SobolSequence(lower, upper, new NoRandomisation(), seeded(42)));
        }

        @Test
        public void thousandDimensionsAreAccepted() {
            final double [] lower = new double[SobolSequence.MAXIMUM_DIMENSION];
            final double [] upper = DoubleStream.generate(() -> 1.0).limit(lower.length).toArray();

            Assertions.assertEquals(SobolSequence.MAXIMUM_DIMENSION,
                    new SobolSequence(lower, upper, new NoRandomisation(), seeded(42)).sample().length);
        }

        @Test
        public void anUnsupportedRandomisationIsRejected() {
            final Randomisation unsupported = new Randomisation() {
                @Override
                public void prepare(final int dimension, final RandomGenerator randomness) {
                }

                @Override
                public double [] apply(final double [] point) {
                    return point;
                }
            };

            Assertions.assertThrows(IllegalArgumentException.class,
                    () -> new SobolSequence(UNIT_LOWER, UNIT_UPPER, unsupported, seeded(42)));
        }
    }
}
