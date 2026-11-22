package de.evoal.surrogate.adaption.interval.fitness;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.PredictiveStandardDeviation;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The interval formula is kept from the former decorator until #288 is decided.
 */
public class PredictionIntervalStepTest {
    @Test
    public void theFormulaDividesTwiceTheSquareByTheWidth() {
        // 2 * 3^2 / 4
        Assertions.assertEquals(4.5, PredictionIntervalStep.adapt(3.0, 4.0));
    }

    @Test
    public void theSignOfTheValueIsLost() {
        Assertions.assertEquals(PredictionIntervalStep.adapt(3.0, 4.0), PredictionIntervalStep.adapt(-3.0, 4.0));
    }

    @Nested
    @DisplayName("given a surrogate with a predictive standard deviation of 2 + x")
    class StandardDeviation {
        private final EAttribute x = attribute("x");

        private final EAttribute y = attribute("y");

        private final Space data = space(x, y);

        /**
         * A model with input x and output y whose standard deviation at x is 2 + x.
         */
        private final class Deviating extends ModelFunction implements PredictiveStandardDeviation {
            private Deviating() {
                super("deviating", data.subSpace(List.of(x)), data.subSpace(List.of(y)));
            }

            @Override
            public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
            }

            @Override
            public double standardDeviation(final @NonNull TypedEObject input, final @NonNull EStructuralFeature output) {
                return 2.0 + input.eGetAsDouble(x);
            }
        }

        @Test
        public void theWidthIsTwiceTheNormalQuantileTimesTheDeviation() {
            // given
            final Deviating model = new Deviating();
            final TypedEObject candidate = data.newEObject();
            candidate.eSet(x, 1.0);

            // when
            final double width = PredictionIntervalStep.standardDeviationWidth(model, model).of(candidate, "y");

            // then: z = Φ⁻¹(0.95) = 1.6448536...
            Assertions.assertEquals(2 * 1.6448536269514722 * 3.0, width, 1e-12);
        }
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
        pkg.setNsURI("http://www.evoal.de/test/prediction-interval");
        pkg.getEClassifiers().add(type);

        return new Space(type);
    }
}
