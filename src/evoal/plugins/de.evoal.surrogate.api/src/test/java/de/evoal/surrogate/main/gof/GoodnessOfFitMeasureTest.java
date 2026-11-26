package de.evoal.surrogate.main.gof;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import de.evoal.surrogate.main.gof.rmse.RMSECalculator;
import lombok.NonNull;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Which calculators of {@code specify gof} run on which data set, and where the measures put
 *   their values (#234).
 */
public class GoodnessOfFitMeasureTest {
    private static final String RMSE = "de.evoal.surrogate.ml.rmse";

    private EAttribute x;
    private EAttribute y;
    private Space space;
    private InterpreterState context;

    /**
     * A calculator that describes the training data, like a density estimation.
     */
    private static class TrainingDataCalculator extends SurrogateInformationCalculator {
        private int calls = 0;

        @Override
        public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
            ++calls;
            return Optional.empty();
        }
    }

    private EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    @BeforeEach
    void setUp() {
        x = attribute("x");
        y = attribute("y");

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().addAll(List.of(x, y));

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/goodness-of-fit");
        pkg.getEClassifiers().add(type);

        space = new Space(type);

        // the surrogate predicts y = 2x
        final ModelFunction function = new ModelFunction("double", space.subSpace(List.of(x)), space.subSpace(List.of(y))) {
            @Override
            public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
                output.eSet(y, 2.0 * input.eGetAsDouble(x));
            }
        };

        context = new InterpreterState();
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName("model-function");
        context.put(variable, new ModelFunctionData(function, Optional.empty(), Optional.empty()));
    }

    private TypedEObject point(final double xValue, final double yValue) {
        final TypedEObject point = new TypedEObject(space);
        point.eSet(x, xValue);
        point.eSet(y, yValue);

        return point;
    }

    private void assessTestData() {
        final List<TypedEObject> data = List.of(point(1.0, 2.0), point(2.0, 5.0));

        GoodnessOfFit.of(new InterpreterState(context))
                     .assess(GoodnessOfFit.TEST, () -> data.stream().map(p -> new EObjectPair(p, p)));
    }

    @Nested
    @DisplayName("given the test data is assessed")
    class TestData {
        @BeforeEach
        void assess() {
            assessTestData();
        }

        @Test
        public void aMeasureRecordsItsValueForTheTestData() {
            // when
            new RMSECalculator().call(new InterpreterState(context), new Object[0]);

            // then: errors 0 and 1
            final Map<String, Object> values = GoodnessOfFit.of(context).values().get(y).get(RMSE);
            Assertions.assertEquals(Map.of(GoodnessOfFit.TEST, Math.sqrt(0.5)), values);
        }

        @Test
        public void aCalculatorThatDescribesTheTrainingDataIsSkipped() {
            // given
            final TrainingDataCalculator calculator = new TrainingDataCalculator();

            // when
            calculator.call(context, new Object[0]);

            // then
            Assertions.assertEquals(0, calculator.calls);
        }
    }

    @Nested
    @DisplayName("given the training data is assessed")
    class TrainingDataAssessed {
        @Test
        public void aCalculatorThatDescribesTheTrainingDataRuns() {
            // given
            final TrainingDataCalculator calculator = new TrainingDataCalculator();

            // when
            calculator.call(context, new Object[0]);

            // then
            Assertions.assertEquals(1, calculator.calls);
        }

        @Test
        public void aMeasureAssessesTheRecordedTrainingRowsOnly() {
            // given: 'validation' dropped the row (3, 100); the recorded rows are those left
            final List<TypedEObject> rows = List.of(point(1.0, 2.0), point(2.0, 5.0));
            GoodnessOfFit.of(context).assess(GoodnessOfFit.TRAINING, () -> rows.stream().map(p -> new EObjectPair(p, p)));

            // when
            new RMSECalculator().call(new InterpreterState(context), new Object[0]);

            // then: errors 0 and 1
            Assertions.assertEquals(Map.of(GoodnessOfFit.TRAINING, Math.sqrt(0.5)), GoodnessOfFit.of(context).values().get(y).get(RMSE));
        }

        @Test
        public void withoutRecordedRowsAMeasureNamesTheMissingStep() {
            // when
            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                     () -> new RMSECalculator().call(new InterpreterState(context), new Object[0]));

            // then
            Assertions.assertTrue(e.getMessage().contains("No step has recorded the rows of the training data"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains("step { component 'assessment-data' { 'data-set' := \"training\"; } }"), e.getMessage());
        }
    }
}
