package de.evoal.surrogate.smile.gaussian;

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

import java.util.List;
import java.util.Map;

/**
 * The predictive standard deviation of a Gaussian process surrogate.
 */
public class GaussianProcessFunctionTest {
    private final EAttribute x = attribute("x:0");

    private final EAttribute y = attribute("y:0");

    private final Space data = space(x, y);

    @Nested
    @DisplayName("given the Gaussian process of the Forrester function with a gap in (0.6, 0.9)")
    class Forrester {
        private final GaussianProcessFunction function = new GaussianProcessFunction(data.subSpace(List.of(x)),
                                                                                      data.subSpace(List.of(y)),
                                                                                      ForresterGaussianProcess.fit(100),
                                                                                      Map.of());

        @Test
        public void theDeviationAtTheTrainingPointsIsSmallerThanInTheGap() {
            // given
            final double inTheGap = function.standardDeviation(at(0.75), y);

            // then
            for(final double training : ForresterGaussianProcess.TRAINING) {
                final double deviation = function.standardDeviation(at(training), y);

                Assertions.assertTrue(deviation >= 0.0, "deviation at " + training);
                Assertions.assertTrue(deviation < inTheGap / 10, "deviation " + deviation + " at " + training + ", " + inTheGap + " in the gap");
            }
        }

        @Test
        public void theDeviationGrowsTowardsTheMiddleOfTheGap() {
            Assertions.assertTrue(function.standardDeviation(at(0.65), y) < function.standardDeviation(at(0.75), y));
        }

        @Test
        public void anotherFeatureIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> function.standardDeviation(at(0.5), x));
        }
    }

    private TypedEObject at(final double value) {
        final TypedEObject input = data.newEObject();
        input.eSet(x, value);

        return input;
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    private static Space space(final EAttribute... attributes) {
        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().addAll(List.of(attributes));

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/gaussian-process");
        pkg.getEClassifiers().add(type);

        return new Space(type);
    }
}
