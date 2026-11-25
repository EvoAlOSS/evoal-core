package de.evoal.surrogate.main.gof.interval;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

import lombok.NonNull;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.PredictionInterval;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import de.evoal.surrogate.main.gof.PredictedValues;

/**
 * The goodness of fit of prediction intervals, picp and mpiw (#349).
 */
public class PredictionIntervalMeasuresTest {
    private EAttribute x;
    private EAttribute y;
    private Space space;

    @BeforeEach
    void setUp() {
        x = attribute("x");
        y = attribute("y");

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().addAll(List.of(x, y));

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/interval-measures");
        pkg.getEClassifiers().add(type);

        space = new Space(type);
    }

    private static EAttribute attribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);

        return attribute;
    }

    @Test
    public void picpIsTheShareOfValuesInTheirIntervalWithTheBoundsIncluded() {
        // the values 0 (lower bound), 1 (inside), 2 (upper bound), 4 (above)
        final OptionalDouble picp = PredictionIntervalMeasures.picp(new double[] {0.0, 1.0, 2.0, 4.0},
                                                                    new double[] {0.0, 0.0, 0.0, 0.0},
                                                                    new double[] {2.0, 2.0, 2.0, 2.0});

        Assertions.assertEquals(0.75, picp.getAsDouble());
    }

    @Test
    public void mpiwIsTheMeanWidth() {
        Assertions.assertEquals(2.0, PredictionIntervalMeasures.mpiw(new double[] {0.0, 1.0}, new double[] {1.0, 4.0}).getAsDouble());
    }

    @Test
    public void bothAreUndefinedWithoutValues() {
        Assertions.assertTrue(PredictionIntervalMeasures.picp(new double[0], new double[0], new double[0]).isEmpty());
        Assertions.assertTrue(PredictionIntervalMeasures.mpiw(new double[0], new double[0]).isEmpty());
    }

    @Test
    public void boundsOfAnotherLengthAreRejected() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> PredictionIntervalMeasures.picp(new double[] {1.0}, new double[0], new double[] {1.0}));
    }

    /**
     * A surrogate that predicts y = 2x with the interval [2x − x, 2x + x], or without interval.
     */
    private InterpreterState context(final boolean withInterval) {
        final ModelFunction function;
        if(withInterval) {
            function = new Bounded();
        } else {
            function = new ModelFunction("double", space.subSpace(List.of(x)), space.subSpace(List.of(y))) {
                @Override
                public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
                    output.eSet(y, 2.0 * input.eGetAsDouble(x));
                }
            };
        }

        final InterpreterState context = new InterpreterState();
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName("model-function");
        context.put(variable, new ModelFunctionData(function, Optional.empty(), Optional.empty()));

        // (1, 2) and (2, 3.5) lie in [1, 3] and [2, 6], (3, 10) not in [3, 9]
        final List<TypedEObject> data = List.of(point(1.0, 2.0), point(2.0, 3.5), point(3.0, 10.0));
        GoodnessOfFit.of(context).assess(GoodnessOfFit.TEST, () -> data.stream().map(p -> new EObjectPair(p, p)));

        return context;
    }

    private final class Bounded extends ModelFunction implements PredictionInterval {
        private Bounded() {
            super("bounded", space.subSpace(List.of(x)), space.subSpace(List.of(y)));
        }

        @Override
        public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
            output.eSet(y, 2.0 * input.eGetAsDouble(x));
        }

        @Override
        public Interval interval(final @NonNull TypedEObject input, final @NonNull EStructuralFeature output) {
            final double value = input.eGetAsDouble(x);

            return new Interval(value, 3.0 * value);
        }

        @Override
        public double coverage(final @NonNull EStructuralFeature output) {
            return 0.9;
        }
    }

    private TypedEObject point(final double xValue, final double yValue) {
        final TypedEObject point = new TypedEObject(space);
        point.eSet(x, xValue);
        point.eSet(y, yValue);

        return point;
    }

    @Test
    public void theValuesOfASurrogateWithIntervalHaveItsBounds() {
        // given
        final InterpreterState context = context(true);

        // when
        final PredictedValues values = PredictedValues.collect((ModelFunctionData) context.getByName("model-function"),
                                                               GoodnessOfFit.of(context).data().orElseThrow()).get(y);

        // then
        final PredictedValues.Bounds bounds = values.bounds().orElseThrow();
        Assertions.assertArrayEquals(new double[] {1.0, 2.0, 3.0}, bounds.lower());
        Assertions.assertArrayEquals(new double[] {3.0, 6.0, 9.0}, bounds.upper());
    }

    @Test
    public void theMeasuresRecordTheirValues() {
        // given
        final InterpreterState context = context(true);

        // when
        new PICPCalculator().call(new InterpreterState(context), new Object[0]);
        new MPIWCalculator().call(new InterpreterState(context), new Object[0]);

        // then: widths 2, 4 and 6
        final Map<String, Map<String, Object>> values = GoodnessOfFit.of(context).values().get(y);
        Assertions.assertEquals(Map.of(GoodnessOfFit.TEST, 2.0 / 3.0), values.get(PICPCalculator.NAME));
        Assertions.assertEquals(Map.of(GoodnessOfFit.TEST, 4.0), values.get(MPIWCalculator.NAME));
    }

    @Test
    public void withoutIntervalNothingIsRecorded() {
        // given
        final InterpreterState context = context(false);

        // when
        new PICPCalculator().call(new InterpreterState(context), new Object[0]);
        new MPIWCalculator().call(new InterpreterState(context), new Object[0]);

        // then
        final Map<String, Map<String, Object>> values = GoodnessOfFit.of(context).values().getOrDefault(y, Map.of());
        Assertions.assertFalse(values.containsKey(PICPCalculator.NAME));
        Assertions.assertFalse(values.containsKey(MPIWCalculator.NAME));
    }
}
