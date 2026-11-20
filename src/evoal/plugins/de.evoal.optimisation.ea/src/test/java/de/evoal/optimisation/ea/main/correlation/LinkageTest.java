package de.evoal.optimisation.ea.main.correlation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.correlations.BuildingBlock;
import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.api.correlations.LinkageGroup;
import de.evoal.optimisation.ea.Candidates;

/**
 * The {@link Linkage} of building blocks and correlated pairs after a crossover. Features: x
 *   real in [-1, 1], y real in [0, 10], z real in [0, 10], n integer in [0, 4], b boolean.
 *   Parent A is (0.5, 1, 2, 0, false), parent B is (-0.5, 9, 8, 4, true).
 */
public class LinkageTest {
    private final EAttribute x = bounded(Candidates.real("x"), -1.0, 1.0);
    private final EAttribute y = bounded(Candidates.real("y"), 0.0, 10.0);
    private final EAttribute z = bounded(Candidates.real("z"), 0.0, 10.0);
    private final EAttribute n = bounded(Candidates.integer("n"), 0.0, 4.0);
    private final EAttribute b = Candidates.bool("b");
    private final Space space = Candidates.space(x, y, z, n, b);

    private final TypedEObject parentA = point(0.5, 1.0, 2.0, 0, false);
    private final TypedEObject parentB = point(-0.5, 9.0, 8.0, 4, true);

    private static EAttribute bounded(final EAttribute feature, final double lower, final double upper) {
        FeatureBoundaries.annotate(feature, new BoundaryExtractor.Extracted(Optional.of(new BoundaryExtractor.Bound(lower, true)),
                                                                            Optional.of(new BoundaryExtractor.Bound(upper, true))));
        return feature;
    }

    private static BuildingBlock block(final int number, final EAttribute... features) {
        return new BuildingBlock(number, List.of(features));
    }

    private static Correlation linear(final int number, final EAttribute first, final EAttribute second, final double rho) {
        return new Correlation(number, first, second, rho, null, null, CorrelationKind.LINEAR);
    }

    private static List<String> link(final List<? extends LinkageGroup> groups, final TypedEObject parentA,
                                     final TypedEObject parentB, final TypedEObject childA, final TypedEObject childB) {
        return new Linkage(groups).link(parentA, parentB, childA, childB);
    }

    private TypedEObject point(final double xValue, final double yValue, final double zValue, final int nValue,
                               final boolean bValue) {
        final TypedEObject point = space.newEObject();
        point.eSet(x, xValue);
        point.eSet(y, yValue);
        point.eSet(z, zValue);
        point.eSet(n, nValue);
        point.eSet(b, bValue);

        return point;
    }

    @Test
    public void aChildGetsTheCorrelatedFeatureFromTheParentOfItsAnchor() {
        // given: the crossover exchanged y
        final TypedEObject childA = point(0.5, 9.0, 2.0, 0, false);
        final TypedEObject childB = point(-0.5, 1.0, 8.0, 4, true);

        // when
        final List<String> linked = link(List.of(linear(1, x, y, 0.9)), parentA, parentB, childA, childB);

        // then
        Assertions.assertEquals(1.0, childA.eGet(y));
        Assertions.assertEquals(9.0, childB.eGet(y));
        Assertions.assertEquals(List.of("y with x"), linked);
    }

    @Test
    public void childrenThatKeepTheLinkageAreUnchanged() {
        final TypedEObject childA = point(0.5, 1.0, 8.0, 4, true);
        final TypedEObject childB = point(-0.5, 9.0, 2.0, 0, false);

        final List<String> linked = link(List.of(linear(1, x, y, 0.9), block(1, x, y)), parentA, parentB, childA, childB);

        Assertions.assertEquals(List.of(), linked);
        Assertions.assertEquals(8.0, childA.eGet(z));
    }

    @Test
    public void aBuildingBlockComesFromTheParentOfItsAnchor() {
        // given: x of child A comes from A, y and z from B
        final TypedEObject childA = point(0.5, 9.0, 8.0, 0, false);
        final TypedEObject childB = point(-0.5, 1.0, 2.0, 4, true);

        // when
        final List<String> linked = link(List.of(block(1, x, y, z)), parentA, parentB, childA, childB);

        // then
        Assertions.assertEquals(List.of(1.0, 2.0), List.of(childA.eGet(y), childA.eGet(z)));
        Assertions.assertEquals(List.of(9.0, 8.0), List.of(childB.eGet(y), childB.eGet(z)));
        Assertions.assertEquals(List.of("y, z with x"), linked);
    }

    @Test
    public void aFeatureFromNeitherParentIsNoAnchor() {
        // given: x of child A comes from neither parent, y from B
        final TypedEObject childA = point(0.1, 9.0, 2.0, 0, false);
        final TypedEObject childB = point(-0.1, 1.0, 8.0, 4, true);

        // when
        final List<String> linked = link(List.of(block(1, x, y, z)), parentA, parentB, childA, childB);

        // then: y anchors the building block
        Assertions.assertEquals(List.of(-0.5, 8.0), List.of(childA.eGet(x), childA.eGet(z)));
        Assertions.assertEquals(List.of(0.5, 2.0), List.of(childB.eGet(x), childB.eGet(z)));
        Assertions.assertEquals(List.of("x, z with y"), linked);
    }

    @Test
    public void aBuildingBlockWithoutAnchorIsSkipped() {
        final TypedEObject childA = point(0.1, 5.0, 2.0, 0, false);
        final TypedEObject childB = point(-0.1, 5.0, 8.0, 4, true);

        final List<String> linked = link(List.of(block(1, x, y)), parentA, parentB, childA, childB);

        Assertions.assertEquals(List.of(), linked);
        Assertions.assertEquals(List.of(0.1, 5.0), List.of(childA.eGet(x), childA.eGet(y)));
    }

    @Test
    public void theSharedFeatureOfOverlappingBuildingBlocksAnchorsTheLaterOne() {
        // given: x of child A comes from B, y and z from A
        final TypedEObject childA = point(-0.5, 1.0, 2.0, 0, false);
        final TypedEObject childB = point(0.5, 9.0, 8.0, 4, true);

        // when
        final List<String> linked = link(List.of(block(1, x, y), block(2, y, z)), parentA, parentB, childA, childB);

        // then: x brings y from B, and y brings z from B
        Assertions.assertEquals(List.of(9.0, 8.0), List.of(childA.eGet(y), childA.eGet(z)));
        Assertions.assertEquals(List.of(1.0, 2.0), List.of(childB.eGet(y), childB.eGet(z)));
        Assertions.assertEquals(List.of("y with x", "z with y"), linked);
    }

    @Test
    public void theOrderOfTheDdlDecidesTheAnchor() {
        // given: the same children as above, but the building blocks in the other order
        final TypedEObject childA = point(-0.5, 1.0, 2.0, 0, false);
        final TypedEObject childB = point(0.5, 9.0, 8.0, 4, true);

        // when
        final List<String> linked = link(List.of(block(1, y, z), block(2, x, y)), parentA, parentB, childA, childB);

        // then: y and z stay with A, and y brings x from A
        Assertions.assertEquals(List.of(0.5, 1.0, 2.0), List.of(childA.eGet(x), childA.eGet(y), childA.eGet(z)));
        Assertions.assertEquals(List.of(-0.5, 9.0, 8.0), List.of(childB.eGet(x), childB.eGet(y), childB.eGet(z)));
        Assertions.assertEquals(List.of("x with y"), linked);
    }

    @Test
    public void featuresAlreadySetFromDifferentParentsKeepTheirValues() {
        // given: x and n of child A come from A, y and z from B
        final TypedEObject childA = point(0.5, 9.0, 8.0, 0, false);
        final TypedEObject childB = point(-0.5, 1.0, 2.0, 4, true);

        // when: x brings y from A, z brings n from B, and the last building block has both
        final List<String> linked = link(List.of(block(1, x, y), block(2, z, n), block(3, y, z)), parentA, parentB, childA,
                                         childB);

        // then: every feature is set at most once, so the last building block is not preserved
        Assertions.assertEquals(List.of(0.5, 1.0, 8.0, 4), List.of(childA.eGet(x), childA.eGet(y), childA.eGet(z), childA.eGet(n)));
        Assertions.assertEquals(List.of("y with x", "n with z"), linked);
    }

    @Test
    public void buildingBlocksAndCorrelationsAreTakenTogetherInTheOrderOfTheDdl() {
        // given: x of child A comes from B, the rest from A
        final TypedEObject childA = point(-0.5, 1.0, 2.0, 0, false);
        final TypedEObject childB = point(0.5, 9.0, 8.0, 4, true);

        // when
        final List<String> linked = link(List.of(linear(1, x, y, 0.9), block(1, y, z, n)), parentA, parentB, childA, childB);

        // then: x brings y from B, and y brings z and n
        Assertions.assertEquals(List.of(9.0, 8.0, 4), List.of(childA.eGet(y), childA.eGet(z), childA.eGet(n)));
        Assertions.assertEquals(List.of("y with x", "z, n with y"), linked);
    }

    @Test
    public void aBuildingBlockMayHaveFeaturesWithoutOrder() {
        // given: b of child A comes from B
        final TypedEObject childA = point(0.5, 1.0, 2.0, 0, true);
        final TypedEObject childB = point(-0.5, 9.0, 8.0, 4, false);

        // when
        final List<String> linked = link(List.of(block(1, b, x)), parentA, parentB, childA, childB);

        // then
        Assertions.assertEquals(-0.5, childA.eGet(x));
        Assertions.assertEquals(0.5, childB.eGet(x));
        Assertions.assertEquals(List.of("x with b"), linked);
    }

    @Test
    public void aRangedCorrelationAppliesOnlyIfBothParentsLieInItsRanges() {
        final Correlation ranged = new Correlation(1, x, y, 0.9, new CorrelationRange(0.0, 1.0), new CorrelationRange(0.0, 10.0),
                                                   CorrelationKind.LINEAR);
        final TypedEObject childA = point(0.5, 9.0, 2.0, 0, false);
        final TypedEObject childB = point(-0.5, 1.0, 8.0, 4, true);

        final List<String> linked = link(List.of(ranged), parentA, parentB, childA, childB);

        // parent B lies outside the range of x
        Assertions.assertEquals(List.of(), linked);
        Assertions.assertEquals(9.0, childA.eGet(y));
    }

    @Test
    public void theMinimumCorrelationDoesNotFilterBuildingBlocks() {
        // given
        final Correlations declared = new Correlations(List.of(linear(1, x, y, 0.3), block(1, x, z)));
        final CorrelationTransfer transfer = new CorrelationTransfer(declared.all(), 0.5, new FeatureBoundaries(), "test");

        // when
        final Linkage linkage = Linkage.of(declared, transfer);

        // then
        Assertions.assertEquals(List.of(block(1, x, z)), linkage.groups());
        Assertions.assertEquals(Set.of(x, z), linkage.features());
    }
}
