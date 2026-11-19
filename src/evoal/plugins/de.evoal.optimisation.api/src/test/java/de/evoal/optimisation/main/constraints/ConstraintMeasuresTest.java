package de.evoal.optimisation.main.constraints;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;

/**
 * The degrees of violation of the {@link ExactMeasure} and the {@link ToleranceMeasure}.
 */
public class ConstraintMeasuresTest {
    private final Space space = space();

    private final EStructuralFeature x = space.getEClass().getEStructuralFeature("x");

    private final EStructuralFeature y = space.getEClass().getEStructuralFeature("y");

    private static Space space() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

        for(final String name : List.of("x", "y")) {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(EcorePackage.Literals.EDOUBLE);
            eClass.getEStructuralFeatures().add(feature);
        }

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private TypedEObject candidate(final double valueOfX, final double valueOfY) {
        final TypedEObject candidate = space.newEObject();
        candidate.eSet(x, valueOfX);
        candidate.eSet(y, valueOfY);

        return candidate;
    }

    /**
     * @return The constraint {@code x >= 1}, in normal form {@code x - 1 >= 0}.
     */
    private Constraint xAtLeastOne(final Map<EStructuralFeature, Double> deviations) {
        return new Constraint(1, "g", "x >= 1", ConstraintKind.INEQUALITY, false, List.of(x), List.of(), deviations,
                              values -> values.valueOf(x) - 1.0, null);
    }

    /**
     * @return The constraint {@code x = y}, in normal form {@code x - y = 0}.
     */
    private Constraint xEqualsY(final Map<EStructuralFeature, Double> deviations) {
        return new Constraint(1, "g", "x = y", ConstraintKind.EQUALITY, false, List.of(x, y), List.of(), deviations,
                              values -> values.valueOf(x) - values.valueOf(y), null);
    }

    @Nested
    @DisplayName("given the exact measure")
    class Exact {
        private final ExactMeasure measure = new ExactMeasure(1.0e-4);

        @Test
        public void aSatisfiedInequalityHasDegreeZero() {
            // when
            final double degree = measure.degreeOf(xAtLeastOne(Map.of()), candidate(1.5, 0.0), null);

            // then
            Assertions.assertEquals(0.0, degree);
        }

        @Test
        public void aViolatedInequalityHasTheNegatedValueAsDegree() {
            // when
            final double degree = measure.degreeOf(xAtLeastOne(Map.of()), candidate(0.25, 0.0), null);

            // then
            Assertions.assertEquals(0.75, degree);
        }

        @Test
        public void anInequalityOnItsBoundIsSatisfied() {
            // when
            final double degree = measure.degreeOf(xAtLeastOne(Map.of()), candidate(1.0, 0.0), null);

            // then
            Assertions.assertEquals(0.0, degree);
        }

        @Test
        public void anEqualityWithinTheToleranceIsSatisfied() {
            // when
            final double degree = measure.degreeOf(xEqualsY(Map.of()), candidate(2.0, 2.00005), null);

            // then
            Assertions.assertEquals(0.0, degree);
        }

        @Test
        public void anEqualityBeyondTheToleranceHasTheExcessAsDegree() {
            // when
            final double degree = measure.degreeOf(xEqualsY(Map.of()), candidate(2.0, 1.5), null);

            // then
            Assertions.assertEquals(0.5 - 1.0e-4, degree, 1.0e-12);
        }

        @Test
        public void aNegativeToleranceIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new ExactMeasure(-1.0));
        }
    }

    @Nested
    @DisplayName("given the tolerance measure with factor 2 and a standard deviation of 0.25 for x")
    class Tolerance {
        private final ToleranceMeasure measure = new ToleranceMeasure(1.0e-4, 2.0);

        private final Map<EStructuralFeature, Double> deviations = Map.of(x, 0.25);

        @Test
        public void aViolationWithinTheToleranceHasDegreeZero() {
            // when: x = 0.6 moved by +0.5 satisfies x >= 1
            final double degree = measure.degreeOf(xAtLeastOne(deviations), candidate(0.6, 0.0), null);

            // then
            Assertions.assertEquals(0.0, degree);
        }

        @Test
        public void aViolationBeyondTheToleranceHasTheSmallestDegree() {
            // when: x = 0.2 moved by +0.5 is 0.7
            final double degree = measure.degreeOf(xAtLeastOne(deviations), candidate(0.2, 0.0), null);

            // then
            Assertions.assertEquals(0.3, degree, 1.0e-12);
        }

        @Test
        public void aFeatureWithoutDeviationIsNotMoved() {
            // when
            final double degree = measure.degreeOf(xAtLeastOne(Map.of()), candidate(0.6, 0.0), null);

            // then
            Assertions.assertEquals(0.4, degree, 1.0e-12);
        }

        @Test
        public void bothDirectionsAreTried() {
            // given: x = y, x is 0.5 above y, x is moved by -0.5 and meets y
            final Map<EStructuralFeature, Double> xDeviation = Map.of(x, 0.25);

            // when
            final double degree = measure.degreeOf(xEqualsY(xDeviation), candidate(2.5, 2.0), null);

            // then
            Assertions.assertEquals(0.0, degree, 1.0e-12);
        }

        @Test
        public void aFactorOfZeroIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new ToleranceMeasure(1.0e-4, 0.0));
        }
    }
}
