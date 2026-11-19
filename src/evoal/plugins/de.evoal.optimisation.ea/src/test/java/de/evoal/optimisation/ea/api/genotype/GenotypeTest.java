package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.ea.Candidates;

public class GenotypeTest {
    private final EAttribute x = Candidates.real("x");
    private final EAttribute n = Candidates.integer("n");
    private final EAttribute b = Candidates.bool("b");
    private final Space space = Candidates.space(x, n, b);

    private TypedEObject candidate(final double xValue, final int nValue, final boolean bValue) {
        final TypedEObject candidate = space.newEObject();
        candidate.eSet(x, xValue);
        candidate.eSet(n, nValue);
        candidate.eSet(b, bValue);

        return candidate;
    }

    private BinaryChromosome binary(final int precision, final boolean gray) {
        return new BinaryChromosome(List.of(x, n, b),
                                    new BinaryChromosome.Kind[] {BinaryChromosome.Kind.REAL, BinaryChromosome.Kind.INTEGER, BinaryChromosome.Kind.BOOLEAN},
                                    new double[] {-1.0, -3.0, 0.0}, new double[] {1.0, 4.0, 0.0}, precision, gray);
    }

    @Nested
    @DisplayName("given a genotype with a double, an integer and a bit chromosome")
    class Separate {
        private final Genotype genotype = new Genotype(List.of(new DoubleChromosome(List.of(x), new double[] {-1.0}, new double[] {1.0}),
                                                               new IntegerChromosome(List.of(n), new long[] {-3}, new long[] {4}),
                                                               binaryOf(b)),
                                                       space);

        private BinaryChromosome binaryOf(final EAttribute feature) {
            return new BinaryChromosome(List.of(feature), new BinaryChromosome.Kind[] {BinaryChromosome.Kind.BOOLEAN},
                                        new double[] {0.0}, new double[] {0.0}, 1, false);
        }

        @Test
        public void decodingTheEncodedGenomeGivesTheCandidate() {
            // given
            final TypedEObject original = candidate(0.25, -2, true);

            // when
            final TypedEObject decoded = genotype.decode(genotype.encode(original));

            // then
            Assertions.assertEquals(0.25, decoded.eGet(x));
            Assertions.assertEquals(-2, decoded.eGet(n));
            Assertions.assertEquals(true, decoded.eGet(b));
        }

        @Test
        public void theChangedFeaturesAreNamed() {
            // given
            final Genome before = genotype.encode(candidate(0.25, -2, true));
            final Genome after = before.copy();
            ((IntegerGenes) after.chromosomes().get(1)).set(0, 3);

            // then
            Assertions.assertEquals(List.of("n"), genotype.changedFeatures(before, after));
            Assertions.assertFalse(genotype.isUnchanged(before, after));
            Assertions.assertTrue(genotype.isUnchanged(before, before.copy()));
        }
    }

    @Test
    public void aFeatureMustBelongToExactlyOneChromosome() {
        final DoubleChromosome xOnly = new DoubleChromosome(List.of(x), new double[] {-1.0}, new double[] {1.0});

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Genotype(List.of(xOnly), space));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Genotype(List.of(xOnly, xOnly, binary(4, false)), space));
    }

    @Nested
    @DisplayName("given a bit chromosome with a real, an integer and a boolean feature")
    class Binary {
        @Test
        public void eachFeatureHasItsBits() {
            final BinaryChromosome chromosome = binary(4, false);
            final BitGenes bits = chromosome.encode(candidate(1.0, 4, true));

            Assertions.assertEquals("111111111", bits.toString());
            Assertions.assertEquals(List.of(0, 0, 0, 0, 1, 1, 1, 1, 2),
                                    java.util.stream.IntStream.range(0, 9).map(chromosome::featureOfGene).boxed().toList());
        }

        @Test
        public void theBoundariesAndIntegersAreReproducedExactly() {
            for(final boolean gray : new boolean[] {false, true}) {
                final BinaryChromosome chromosome = binary(4, gray);
                for(int value = -3; value <= 4; ++value) {
                    final TypedEObject decoded = space.newEObject();
                    chromosome.decode(chromosome.encode(candidate(-1.0, value, false)), decoded);

                    Assertions.assertEquals(value, decoded.eGet(n));
                    Assertions.assertEquals(-1.0, decoded.eGet(x));
                }
            }
        }

        @Test
        public void grayCodedNeighboursDifferInOneBit() {
            final BinaryChromosome chromosome = binary(8, true);
            final double step = 2.0 / 255.0;

            for(int k = 0; k < 255; ++k) {
                final BitGenes lower = chromosome.encode(candidate(-1.0 + k * step, 0, false));
                final BitGenes upper = chromosome.encode(candidate(-1.0 + (k + 1) * step, 0, false));

                int differences = 0;
                for(int bit = 0; bit < 8; ++bit) {
                    differences += lower.get(bit) == upper.get(bit) ? 0 : 1;
                }
                Assertions.assertEquals(1, differences, "values " + k + " and " + (k + 1));
            }
        }

        @Test
        public void tooFewBitsForTheIntegersAreRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> binary(2, false));
        }
    }

    @Nested
    @DisplayName("given a value outside the boundaries [0, 10]")
    class Boundaries {
        @Test
        public void stickSetsTheNearestBoundary() {
            Assertions.assertEquals(10.0, BoundaryHandling.STICK.apply(23.0, 0.0, 10.0));
            Assertions.assertEquals(0.0, BoundaryHandling.STICK.apply(-0.5, 0.0, 10.0));
            Assertions.assertEquals(0L, BoundaryHandling.STICK.apply(-7L, 0L, 10L));
        }

        @Test
        public void bounceReflectsAsOftenAsNeeded() {
            Assertions.assertEquals(8.0, BoundaryHandling.BOUNCE.apply(12.0, 0.0, 10.0), 1e-12);
            Assertions.assertEquals(3.0, BoundaryHandling.BOUNCE.apply(23.0, 0.0, 10.0), 1e-12);
            Assertions.assertEquals(2.0, BoundaryHandling.BOUNCE.apply(-2.0, 0.0, 10.0), 1e-12);
            Assertions.assertEquals(8L, BoundaryHandling.BOUNCE.apply(12L, 0L, 10L));
            Assertions.assertEquals(3L, BoundaryHandling.BOUNCE.apply(23L, 0L, 10L));
        }

        @Test
        public void wrapEntersFromTheOtherSide() {
            Assertions.assertEquals(2.0, BoundaryHandling.WRAP.apply(12.0, 0.0, 10.0), 1e-12);
            Assertions.assertEquals(8.0, BoundaryHandling.WRAP.apply(-2.0, 0.0, 10.0), 1e-12);
            // integers: the range has 11 values
            Assertions.assertEquals(1L, BoundaryHandling.WRAP.apply(12L, 0L, 10L));
            Assertions.assertEquals(9L, BoundaryHandling.WRAP.apply(-2L, 0L, 10L));
        }

        @Test
        public void valuesWithinStayUnchanged() {
            for(final BoundaryHandling handling : BoundaryHandling.values()) {
                Assertions.assertEquals(4.5, handling.apply(4.5, 0.0, 10.0));
                Assertions.assertEquals(10L, handling.apply(10L, 0L, 10L));
            }
        }
    }
}
