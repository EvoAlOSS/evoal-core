package de.evoal.optimisation.main.constraints;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.api.constraints.LinearForm;

/**
 * The {@link SaturationRepair} and the {@link ProjectionRepair}.
 */
public class ConstraintRepairsTest {
    private final Space space = space();

    private final EStructuralFeature x = space.getEClass().getEStructuralFeature("x");

    private final EStructuralFeature y = space.getEClass().getEStructuralFeature("y");

    private final EStructuralFeature n = space.getEClass().getEStructuralFeature("n");

    private static Space space() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        final Map<String, EDataType> features = new LinkedHashMap<>();
        features.put("x", EcorePackage.Literals.EDOUBLE);
        features.put("y", EcorePackage.Literals.EDOUBLE);
        features.put("n", EcorePackage.Literals.EINT);

        features.forEach((name, type) -> {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(type);
            eClass.getEStructuralFeatures().add(feature);
        });

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private TypedEObject candidate(final double valueOfX, final double valueOfY, final int valueOfN) {
        final TypedEObject candidate = space.newEObject();
        candidate.eSet(x, valueOfX);
        candidate.eSet(y, valueOfY);
        candidate.eSet(n, valueOfN);

        return candidate;
    }

    /**
     * @return The constraint {@code sum of coefficient * feature + constant (kind) 0} with the
     *   given comparison.
     */
    private static Constraint linear(final int number, final ConstraintKind kind, final boolean strict,
                                     final Map<EStructuralFeature, Double> coefficients, final double constant) {
        final LinearForm form = new LinearForm(coefficients, constant);

        return new Constraint(number, "g", "c" + number, kind, strict, List.copyOf(coefficients.keySet()), List.of(),
                              Map.of(), values -> {
                                  double sum = constant;
                                  for(final Map.Entry<EStructuralFeature, Double> term : coefficients.entrySet()) {
                                      sum += term.getValue() * values.valueOf(term.getKey());
                                  }
                                  return sum;
                              }, form);
    }

    private static Map<EStructuralFeature, Double> terms(final Object... featuresAndCoefficients) {
        final Map<EStructuralFeature, Double> terms = new LinkedHashMap<>();
        for(int i = 0; i < featuresAndCoefficients.length; i += 2) {
            terms.put((EStructuralFeature) featuresAndCoefficients[i], (Double) featuresAndCoefficients[i + 1]);
        }

        return terms;
    }

    @Nested
    @DisplayName("given the saturation repair")
    class Saturation {
        private final SaturationRepair repair = new SaturationRepair();

        @Test
        public void aViolatedLowerBoundSetsTheFeatureToTheBound() {
            // given: 2x - 3 >= 0, i.e. x >= 1.5
            final Constraint bound = linear(1, ConstraintKind.INEQUALITY, false, terms(x, 2.0), -3.0);
            final TypedEObject input = candidate(0.5, 7.0, 0);

            // when
            final TypedEObject repaired = repair.repair(input, List.of(bound));

            // then
            Assertions.assertEquals(1.5, repaired.eGet(x));
            Assertions.assertEquals(7.0, repaired.eGet(y));
            Assertions.assertEquals(0.5, input.eGet(x), "the input is not changed");
        }

        @Test
        public void aViolatedUpperBoundSetsTheFeatureToTheBound() {
            // given: -x + 1 >= 0, i.e. x <= 1
            final Constraint bound = linear(1, ConstraintKind.INEQUALITY, false, terms(x, -1.0), 1.0);

            // when
            final TypedEObject repaired = repair.repair(candidate(4.0, 0.0, 0), List.of(bound));

            // then
            Assertions.assertEquals(1.0, repaired.eGet(x));
        }

        @Test
        public void aSatisfiedBoundKeepsTheValue() {
            final Constraint bound = linear(1, ConstraintKind.INEQUALITY, false, terms(x, 1.0), -1.0);

            final TypedEObject repaired = repair.repair(candidate(2.0, 0.0, 0), List.of(bound));

            Assertions.assertEquals(2.0, repaired.eGet(x));
        }

        @Test
        public void anIntegerFeatureTakesTheNearestIntegerOnTheFeasibleSide() {
            // given: 2n - 3 >= 0, i.e. n >= 1.5
            final Constraint bound = linear(1, ConstraintKind.INEQUALITY, false, terms(n, 2.0), -3.0);

            final TypedEObject repaired = repair.repair(candidate(0.0, 0.0, -4), List.of(bound));

            Assertions.assertEquals(2, repaired.eGet(n));
        }

        @Test
        public void aStrictBoundOfAnIntegerFeatureIsLeftByOneStep() {
            // given: n - 3 > 0 and -n + 1 > 0
            final Constraint lower = linear(1, ConstraintKind.INEQUALITY, true, terms(n, 1.0), -3.0);
            final Constraint upper = linear(2, ConstraintKind.INEQUALITY, true, terms(n, -1.0), 1.0);

            Assertions.assertEquals(4, repair.repair(candidate(0.0, 0.0, 0), List.of(lower)).eGet(n));
            Assertions.assertEquals(0, repair.repair(candidate(0.0, 0.0, 5), List.of(upper)).eGet(n));
        }

        @Test
        public void aStrictBoundOfARealFeatureIsMeasuredLikeANonStrictOne() {
            final Constraint lower = linear(1, ConstraintKind.INEQUALITY, true, terms(x, 1.0), -3.0);

            Assertions.assertEquals(3.0, repair.repair(candidate(0.0, 0.0, 0), List.of(lower)).eGet(x));
        }

        @Test
        public void anEqualitySetsTheFeatureToItsValue() {
            // given: 4x - 1 = 0
            final Constraint equality = linear(1, ConstraintKind.EQUALITY, false, terms(x, 4.0), -1.0);

            Assertions.assertEquals(0.25, repair.repair(candidate(3.0, 0.0, 0), List.of(equality)).eGet(x));
        }

        @Test
        public void onlyLinearConstraintsOnOneFeatureCanBeRepaired() {
            final Constraint twoFeatures = linear(1, ConstraintKind.INEQUALITY, false, terms(x, 1.0, y, 1.0), 0.0);
            final Constraint nonLinear = new Constraint(2, "g", "x * x >= 1", ConstraintKind.INEQUALITY, false, List.of(x),
                                                        List.of(), Map.of(), values -> values.valueOf(x) * values.valueOf(x) - 1.0,
                                                        null);
            final Constraint oneFeature = linear(3, ConstraintKind.INEQUALITY, false, terms(x, 1.0), 0.0);

            Assertions.assertTrue(repair.cannotRepair(twoFeatures).isPresent());
            Assertions.assertTrue(repair.cannotRepair(nonLinear).isPresent());
            Assertions.assertTrue(repair.cannotRepair(oneFeature).isEmpty());
        }
    }

    @Nested
    @DisplayName("given the projection repair")
    class Projection {
        private final ProjectionRepair repair = new ProjectionRepair();

        @Test
        public void aViolatedInequalityMovesTheCandidateOntoItsHyperplane() {
            // given: x + y - 2 >= 0 at (0, 0): t = 2 / 2 = 1
            final Constraint sum = linear(1, ConstraintKind.INEQUALITY, false, terms(x, 1.0, y, 1.0), -2.0);

            // when
            final TypedEObject repaired = repair.repair(candidate(0.0, 0.0, 0), List.of(sum));

            // then
            Assertions.assertEquals(1.0, repaired.eGet(x));
            Assertions.assertEquals(1.0, repaired.eGet(y));
        }

        @Test
        public void anEqualityIsProjectedFromBothSides() {
            // given: x - y = 0
            final Constraint equal = linear(1, ConstraintKind.EQUALITY, false, terms(x, 1.0, y, -1.0), 0.0);

            final TypedEObject repaired = repair.repair(candidate(3.0, 1.0, 0), List.of(equal));

            Assertions.assertEquals(2.0, repaired.eGet(x));
            Assertions.assertEquals(2.0, repaired.eGet(y));
        }

        @Test
        public void theConstraintsAreProjectedOnceInTheOrderOfTheDdl() {
            // given: x >= 1, x + y <= 1, y <= -1 at (0, 0): the first gives (1, 0), the
            //   second holds there, the third gives (1, -1)
            final Constraint lower = linear(1, ConstraintKind.INEQUALITY, false, terms(x, 1.0), -1.0);
            final Constraint sum = linear(2, ConstraintKind.INEQUALITY, false, terms(x, -1.0, y, -1.0), 1.0);
            final Constraint upper = linear(3, ConstraintKind.INEQUALITY, false, terms(y, -1.0), -1.0);

            // when
            final TypedEObject repaired = repair.repair(candidate(0.0, 0.0, 0), List.of(lower, sum, upper));

            // then
            Assertions.assertEquals(1.0, repaired.eGet(x));
            Assertions.assertEquals(-1.0, repaired.eGet(y));
        }

        @Test
        public void aProjectedValueIsNeverLeftOnTheInfeasibleSideByRoundingErrors() {
            // given: 0.1x + 0.2y - 0.3 >= 0
            final Constraint inexact = linear(1, ConstraintKind.INEQUALITY, false, terms(x, 0.1, y, 0.2), -0.3);

            // when
            final TypedEObject repaired = repair.repair(candidate(-1.7, 0.3, 0), List.of(inexact));

            // then
            final double g = 0.1 * (double) repaired.eGet(x) + 0.2 * (double) repaired.eGet(y) - 0.3;
            Assertions.assertTrue(g >= 0.0, "g = " + g);
            Assertions.assertTrue(g < 1.0e-12, "g = " + g);
        }

        @Test
        public void integerFeaturesAreRounded() {
            // given: n - 2.4 >= 0 -> projected to 2.4, rounded to 2 (a further attempt is needed)
            final Constraint lower = linear(1, ConstraintKind.INEQUALITY, false, terms(n, 1.0), -2.4);

            Assertions.assertEquals(2, repair.repair(candidate(0.0, 0.0, 0), List.of(lower)).eGet(n));
        }

        @Test
        public void onlyLinearConstraintsCanBeRepaired() {
            final Constraint nonLinear = new Constraint(1, "g", "x * y >= 1", ConstraintKind.INEQUALITY, false, List.of(x, y),
                                                        List.of(), Map.of(), values -> values.valueOf(x) * values.valueOf(y) - 1.0,
                                                        null);
            final Constraint constant = linear(2, ConstraintKind.INEQUALITY, false, Map.of(), 1.0);
            final Constraint twoFeatures = linear(3, ConstraintKind.INEQUALITY, false, terms(x, 1.0, y, 1.0), 0.0);

            Assertions.assertTrue(repair.cannotRepair(nonLinear).isPresent());
            Assertions.assertTrue(repair.cannotRepair(constant).isPresent());
            Assertions.assertTrue(repair.cannotRepair(twoFeatures).isEmpty());
        }
    }
}
