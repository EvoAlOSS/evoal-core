package de.evoal.optimisation.ea.main.correlation;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.BoundaryExtractor;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.ea.Candidates;

/**
 * The transfer of changes along correlations and the linkage of the {@link CorrelationTransfer}.
 *   Features: x real in [-1, 1], y real in [0, 10], n integer in [0, 4], u real without bounds,
 *   k integer without bounds.
 */
public class CorrelationTransferTest {
    private final EAttribute x = bounded(Candidates.real("x"), -1.0, 1.0);
    private final EAttribute y = bounded(Candidates.real("y"), 0.0, 10.0);
    private final EAttribute n = bounded(Candidates.integer("n"), 0.0, 4.0);
    private final EAttribute u = Candidates.real("u");
    private final EAttribute k = Candidates.integer("k");
    private final Space space = Candidates.space(x, y, n, u, k);

    private static EAttribute bounded(final EAttribute feature, final double lower, final double upper) {
        FeatureBoundaries.annotate(feature, new BoundaryExtractor.Extracted(Optional.of(new BoundaryExtractor.Bound(lower, true)),
                                                                            Optional.of(new BoundaryExtractor.Bound(upper, true))));
        return feature;
    }

    private TypedEObject point(final double xValue, final double yValue, final int nValue) {
        final TypedEObject point = space.newEObject();
        point.eSet(x, xValue);
        point.eSet(y, yValue);
        point.eSet(n, nValue);
        point.eSet(u, 0.0);
        point.eSet(k, 0);

        return point;
    }

    private static Correlation linear(final int number, final EAttribute first, final EAttribute second, final double rho) {
        return new Correlation(number, first, second, rho, null, null, CorrelationKind.LINEAR);
    }

    private CorrelationTransfer transfer(final double minimum, final Correlation... correlations) {
        return new CorrelationTransfer(List.of(correlations), minimum, new FeatureBoundaries(), "test");
    }

    @Nested
    @DisplayName("given a mutation of x from 0 to 0.5 (a quarter of its range)")
    class Propagation {
        private final TypedEObject before = point(0.0, 5.0, 1);
        private final TypedEObject after = point(0.5, 5.0, 1);

        @Test
        public void withRhoOneTheChangeIsTheScaledPrimaryChange() {
            final List<String> propagated = transfer(0.0, linear(1, x, y, 1.0)).propagate(before, after, 1);

            Assertions.assertEquals(7.5, after.eGet(y));
            Assertions.assertEquals(List.of("y from x (1.0)"), propagated);
        }

        @Test
        public void aNegativeCoefficientShiftsInTheOtherDirection() {
            transfer(0.0, linear(1, x, y, -0.5)).propagate(before, after, 1);

            Assertions.assertEquals(5.0 - 0.5 * 2.5, after.eGet(y));
        }

        @Test
        public void aCoefficientBelowTheMinimumPropagatesNothing() {
            final List<String> propagated = transfer(0.5, linear(1, x, y, 0.4)).propagate(before, after, 1);

            Assertions.assertEquals(5.0, after.eGet(y));
            Assertions.assertEquals(List.of(), propagated);
        }

        @Test
        public void anIntegerFeatureIsRoundedAndClampedToItsBounds() {
            // a quarter of the range of n is 1
            transfer(0.0, linear(1, x, n, 1.0)).propagate(before, after, 1);
            Assertions.assertEquals(2, after.eGet(n));

            final TypedEObject atTheBound = point(0.5, 5.0, 4);
            final List<String> propagated = transfer(0.0, linear(1, x, n, 1.0)).propagate(point(0.0, 5.0, 4), atTheBound, 1);
            Assertions.assertEquals(4, atTheBound.eGet(n));
            Assertions.assertEquals(List.of(), propagated);
        }

        @Test
        public void aRankCorrelationShiftsTheNormalisedRank() {
            transfer(0.0, new Correlation(1, x, n, 1.0, null, null, CorrelationKind.RANK)).propagate(before, after, 1);

            Assertions.assertEquals(2, after.eGet(n));
        }

        @Test
        public void nominalPairsAndPairsWithAnUnboundedRealFeatureAreSkipped() {
            final CorrelationTransfer transfer = transfer(0.0, new Correlation(1, x, y, 1.0, null, null, CorrelationKind.NOMINAL),
                                                          linear(2, x, u, 1.0), linear(3, x, k, 1.0));

            // the unbounded integer k uses the range of its type
            Assertions.assertEquals(List.of(3), transfer.correlations().stream().map(Correlation::number).toList());
        }

        @Test
        public void aRangedCorrelationNeedsTheSourceBeforeItsChangeInItsRange() {
            final Correlation inRange = new Correlation(1, x, y, 1.0, new CorrelationRange(-0.1, 0.1),
                                                        new CorrelationRange(0.0, 10.0), CorrelationKind.LINEAR);
            final Correlation outOfRange = new Correlation(1, x, y, 1.0, new CorrelationRange(0.4, 1.0),
                                                           new CorrelationRange(0.0, 10.0), CorrelationKind.LINEAR);

            final TypedEObject first = point(0.5, 5.0, 1);
            transfer(0.0, inRange).propagate(before, first, 1);
            final TypedEObject second = point(0.5, 5.0, 1);
            transfer(0.0, outOfRange).propagate(before, second, 1);

            Assertions.assertEquals(7.5, first.eGet(y));
            Assertions.assertEquals(5.0, second.eGet(y));
        }

        @Test
        public void theDepthLimitsTheChains() {
            // x -> y -> n: y changes by 2.5 (a quarter), n by a quarter of 4
            final TypedEObject direct = point(0.5, 5.0, 1);
            transfer(0.0, linear(1, x, y, 1.0), linear(2, y, n, 1.0)).propagate(before, direct, 1);
            final TypedEObject chained = point(0.5, 5.0, 1);
            final List<String> propagated = transfer(0.0, linear(1, x, y, 1.0), linear(2, y, n, 1.0))
                    .propagate(before, chained, 2);

            Assertions.assertEquals(1, direct.eGet(n));
            Assertions.assertEquals(2, chained.eGet(n));
            Assertions.assertEquals(List.of("y from x (1.0)", "n from y (1.0)"), propagated);
        }

        @Test
        public void everyFeatureChangesAtMostOnceAndTheFirstCorrelationWins() {
            // given: y changed by the mutation as well, n is correlated with x (first) and y
            final TypedEObject both = point(0.5, 7.5, 1);
            final List<String> propagated = transfer(0.0, linear(1, x, y, 1.0), linear(2, x, n, -1.0), linear(3, y, n, 1.0))
                    .propagate(before, both, 2);

            // then: y is primary and stays, n takes -1 of x
            Assertions.assertEquals(7.5, both.eGet(y));
            Assertions.assertEquals(0, both.eGet(n));
            Assertions.assertEquals(List.of("n from x (-1.0)"), propagated);
        }
    }

    @Nested
    @DisplayName("given two children of a crossover")
    class Linkage {
        private final TypedEObject parentA = point(0.5, 1.0, 0);
        private final TypedEObject parentB = point(-0.5, 9.0, 4);

        @Test
        public void aChildGetsTheCorrelatedFeatureFromTheParentOfItsAnchor() {
            // given: the crossover exchanged y
            final TypedEObject childA = point(0.5, 9.0, 0);
            final TypedEObject childB = point(-0.5, 1.0, 4);

            // when
            final List<String> linked = transfer(0.0, linear(1, x, y, 0.9)).link(parentA, parentB, childA, childB);

            // then
            Assertions.assertEquals(1.0, childA.eGet(y));
            Assertions.assertEquals(9.0, childB.eGet(y));
            Assertions.assertEquals(List.of("y with x"), linked);
        }

        @Test
        public void childrenThatKeepTheLinkageAreUnchanged() {
            final TypedEObject childA = point(0.5, 1.0, 4);
            final TypedEObject childB = point(-0.5, 9.0, 0);

            final List<String> linked = transfer(0.0, linear(1, x, y, 0.9)).link(parentA, parentB, childA, childB);

            Assertions.assertEquals(List.of(), linked);
            Assertions.assertEquals(4, childA.eGet(n));
        }

        @Test
        public void aFeatureFromNeitherParentIsNoAnchor() {
            // given: x of child A comes from neither parent, so y anchors x
            final TypedEObject childA = point(0.1, 9.0, 0);
            final TypedEObject childB = point(-0.1, 1.0, 4);

            transfer(0.0, linear(1, x, y, 0.9)).link(parentA, parentB, childA, childB);

            // then: y of child A comes from B, so x of child A becomes the one of B
            Assertions.assertEquals(-0.5, childA.eGet(x));
            Assertions.assertEquals(0.5, childB.eGet(x));
        }
    }
}
