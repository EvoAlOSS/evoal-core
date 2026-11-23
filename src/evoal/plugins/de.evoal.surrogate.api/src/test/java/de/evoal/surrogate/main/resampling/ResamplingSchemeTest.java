package de.evoal.surrogate.main.resampling;

import de.evoal.core.api.random.RandomService;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * The splits of the resampling schemes and the blocks of block cross-validation (#334).
 */
public class ResamplingSchemeTest {
    /**
     * The package of the test classes; dynamic objects need one.
     */
    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();

    private static final EClass DATA = EcoreFactory.eINSTANCE.createEClass();
    private static final EAttribute X0 = attribute("x:0");
    private static final EAttribute X1 = attribute("x:1");
    private static final EAttribute BLOCK = attribute("z:0");
    private static final Space SPACE;

    static {
        DATA.setName("data");
        DATA.getEStructuralFeatures().addAll(List.of(X0, X1, BLOCK));
        PACKAGE.getEClassifiers().add(DATA);
        SPACE = new Space(DATA);
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    private static TypedEObject row(final double x0, final double x1, final double block) {
        final TypedEObject row = SPACE.newEObject();
        row.eSet(X0, x0);
        row.eSet(X1, x1);
        row.eSet(BLOCK, block);

        return row;
    }

    /**
     * @return n rows on a line.
     */
    private static List<TypedEObject> rows(final int n) {
        return IntStream.range(0, n)
                        .mapToObj(i -> row(i, 0.0, i % 3))
                        .toList();
    }

    private static RandomGenerator random(final String name) {
        return RandomService.withSeed(42).random(name);
    }

    private static Set<Integer> setOf(final int[] indices) {
        final Set<Integer> result = new HashSet<>();
        Arrays.stream(indices).forEach(result::add);

        return result;
    }

    /**
     * Every row is held out exactly once, and the training rows of a part are the other rows.
     */
    private static void assertPartition(final List<Part> parts, final int n) {
        final List<Integer> heldOut = new ArrayList<>();
        for(final Part part : parts) {
            Arrays.stream(part.heldOut()).forEach(heldOut::add);

            final Set<Integer> training = setOf(part.training());
            Assertions.assertEquals(n - part.heldOut().length, part.training().length);
            Assertions.assertTrue(setOf(part.heldOut()).stream().noneMatch(training::contains));
        }

        Assertions.assertEquals(IntStream.range(0, n).boxed().toList(), heldOut.stream().sorted().toList());
    }

    private static List<List<Integer>> asLists(final List<Part> parts) {
        return parts.stream()
                    .map(p -> Arrays.stream(p.heldOut()).boxed().toList())
                    .toList();
    }

    @Nested
    @DisplayName("k-fold cross-validation")
    class KFold {
        @Test
        public void theFoldsPartitionTheRowsAndDifferInSizeByAtMostOne() {
            // when
            final List<Part> parts = new KFoldCrossValidation(3, random("k-fold")).parts(rows(10));

            // then
            Assertions.assertEquals(3, parts.size());
            Assertions.assertEquals(List.of(4, 3, 3), parts.stream().map(p -> p.heldOut().length).toList());
            assertPartition(parts, 10);
        }

        @Test
        public void theSameSeedGivesTheSameFolds() {
            // when
            final List<Part> first = new KFoldCrossValidation(4, random("k-fold")).parts(rows(20));
            final List<Part> second = new KFoldCrossValidation(4, random("k-fold")).parts(rows(20));

            // then
            Assertions.assertEquals(asLists(first), asLists(second));
        }

        @Test
        public void theRowsAreShuffled() {
            // when
            final List<Part> parts = new KFoldCrossValidation(2, random("k-fold")).parts(rows(20));

            // then: not the first and the second half
            Assertions.assertNotEquals(IntStream.range(0, 10).boxed().toList(), Arrays.stream(parts.get(0).heldOut()).boxed().sorted().toList());
        }

        @Test
        public void moreFoldsThanRowsAreRejected() {
            // when
            final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                                                                        () -> new KFoldCrossValidation(5, random("k-fold")).parts(rows(4)));

            // then
            Assertions.assertTrue(e.getMessage().contains("needs at least 5 rows, but the training data has 4"), e.getMessage());
        }
    }

    @Nested
    @DisplayName("leave-one-out cross-validation")
    class LeaveOneOut {
        @Test
        public void eachRowIsHeldOutOnceInOrder() {
            // when
            final List<Part> parts = new LeaveOneOutCrossValidation().parts(rows(5));

            // then
            Assertions.assertEquals(List.of(List.of(0), List.of(1), List.of(2), List.of(3), List.of(4)), asLists(parts));
            assertPartition(parts, 5);
        }
    }

    @Nested
    @DisplayName("bootstrap")
    class BootstrapScheme {
        @Test
        public void eachRepetitionDrawsNRowsAndHoldsOutTheRowsNotDrawn() {
            // when
            final List<Part> parts = new Bootstrap(10, random("bootstrap")).parts(rows(30));

            // then
            Assertions.assertEquals(10, parts.size());
            for(final Part part : parts) {
                Assertions.assertEquals(30, part.training().length);

                final Set<Integer> drawn = setOf(part.training());
                final Set<Integer> outOfBag = setOf(part.heldOut());
                Assertions.assertTrue(outOfBag.stream().noneMatch(drawn::contains));
                Assertions.assertEquals(30, drawn.size() + outOfBag.size());
            }
        }

        @Test
        public void theSameSeedGivesTheSameDraws() {
            // when
            final List<Part> first = new Bootstrap(5, random("bootstrap")).parts(rows(30));
            final List<Part> second = new Bootstrap(5, random("bootstrap")).parts(rows(30));

            // then
            Assertions.assertEquals(first.stream().map(p -> Arrays.stream(p.training()).boxed().toList()).toList(),
                                    second.stream().map(p -> Arrays.stream(p.training()).boxed().toList()).toList());
        }

        @Test
        public void aRepetitionWithoutOutOfBagRowsIsSkipped() {
            // given: a stream that draws 0, 1, 0, 1, ...: with two rows, every repetition draws both
            final RandomGenerator alternating = new RandomGenerator() {
                private long next = 0;

                @Override
                public long nextLong() {
                    return next++;
                }

                @Override
                public int nextInt(final int bound) {
                    return (int) (next++ % bound);
                }
            };

            // when
            final List<Part> parts = new Bootstrap(3, alternating).parts(rows(2));

            // then
            Assertions.assertTrue(parts.isEmpty());
        }
    }

    @Nested
    @DisplayName("block cross-validation")
    class Blocks {
        @Test
        public void eachBlockIsHeldOutOnce() {
            // when: blocks 0, 1, 2, 0, 1, 2, ...
            final List<Part> parts = new BlockCrossValidation(new GivenBlocks(BLOCK)).parts(rows(9));

            // then
            Assertions.assertEquals(List.of(List.of(0, 3, 6), List.of(1, 4, 7), List.of(2, 5, 8)), asLists(parts));
            assertPartition(parts, 9);
        }

        @Test
        public void oneBlockIsRejected() {
            // given
            final List<TypedEObject> rows = List.of(row(0, 0, 1), row(1, 0, 1), row(2, 0, 1));

            // when
            final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                                                                        () -> new BlockCrossValidation(new GivenBlocks(BLOCK)).parts(rows));

            // then
            Assertions.assertTrue(e.getMessage().contains("needs at least 2 blocks, but 'given-blocks' gives 1"), e.getMessage());
        }

        @Test
        public void kMeansFindsSeparatedClusters() {
            // given: three groups around (0, 0), (10, 0) and (0, 100) in different units
            final List<TypedEObject> rows = new ArrayList<>();
            final double[][] centres = {{0, 0}, {10, 0}, {0, 100}};
            for(int i = 0; i < 30; ++i) {
                final double[] centre = centres[i % 3];
                rows.add(row(centre[0] + 0.1 * (i % 5), centre[1] + (i % 7), 0));
            }

            // when
            final int[] blocks = new KMeansBlocks(3, List.of(X0, X1), random("k-means")).blocksOf(rows);

            // then: the rows of a group share a block, the groups do not
            for(int i = 0; i < 30; ++i) {
                Assertions.assertEquals(blocks[i % 3], blocks[i], "row " + i);
            }
            Assertions.assertEquals(3, setOf(new int[]{blocks[0], blocks[1], blocks[2]}).size());
        }

        @Test
        public void kMeansIsReproducible() {
            // given
            final List<TypedEObject> rows = IntStream.range(0, 40)
                                                     .mapToObj(i -> row(Math.sin(i), Math.cos(3 * i), 0))
                                                     .toList();

            // when
            final int[] first = new KMeansBlocks(4, List.of(X0, X1), random("k-means")).blocksOf(rows);
            final int[] second = new KMeansBlocks(4, List.of(X0, X1), random("k-means")).blocksOf(rows);

            // then
            Assertions.assertArrayEquals(first, second);
        }

        @Test
        public void theGridHasOneBlockPerNonEmptyCell() {
            // given: two intervals per input, rows in three of the four cells; the maximum
            // belongs to the last interval
            final List<TypedEObject> rows = List.of(row(0.0, 0.0, 0), row(0.4, 0.2, 0),
                                                    row(1.0, 0.0, 0), row(0.9, 0.4, 0),
                                                    row(0.0, 1.0, 0));

            // when
            final int[] blocks = new GridBlocks(2, List.of(X0, X1)).blocksOf(rows);

            // then
            Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2}, blocks);
        }

        @Test
        public void aConstantInputIsOneInterval() {
            // given
            final List<TypedEObject> rows = List.of(row(0.0, 5.0, 0), row(1.0, 5.0, 0));

            // when
            final int[] blocks = new GridBlocks(4, List.of(X0, X1)).blocksOf(rows);

            // then
            Assertions.assertArrayEquals(new int[]{0, 1}, blocks);
        }
    }
}
