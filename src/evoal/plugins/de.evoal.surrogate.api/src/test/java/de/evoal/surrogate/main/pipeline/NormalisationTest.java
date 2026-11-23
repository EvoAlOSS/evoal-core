package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.surrogate.api.function.FittedParameters;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * The preparation steps {@code 'min-max-normalisation'} and {@code 'z-score-normalisation'}:
 *   fitting on the stream, applying stated parameters, undoing, constant features (#333).
 */
public class NormalisationTest {
    private EAttribute x;
    private EAttribute y;
    private Space space;
    private InterpreterState context;

    private static EAttribute attribute(final EClass type, final String name, final boolean many) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        attribute.setUpperBound(many ? -1 : 1);
        type.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    /**
     * The package of the test classes; dynamic objects need one.
     */
    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();

    private static EClass eClass(final String name) {
        final EClass clazz = EcoreFactory.eINSTANCE.createEClass();
        clazz.setName(name);
        PACKAGE.getEClassifiers().add(clazz);

        return clazz;
    }

    @BeforeEach
    void setUp() {
        final EClass data = eClass("data");
        x = attribute(data, "x:0", false);
        y = attribute(data, "y:0", false);
        space = new Space(data);
        context = new InterpreterState();
    }

    private TypedEObject row(final double xValue, final double yValue) {
        final TypedEObject row = space.newEObject();
        row.eSet(x, xValue);
        row.eSet(y, yValue);

        return row;
    }

    /**
     * A configuration with the given parameters (empty = left out).
     */
    @SuppressWarnings("unchecked")
    private static EObject configuration(final String type, final Map<String, List<Double>> parameters) {
        final EClass clazz = eClass(type);
        for(final String name : List.of("minimum", "maximum", "μ", "σ")) {
            attribute(clazz, name, true);
        }

        final EObject configuration = EcoreUtil.create(clazz);
        parameters.forEach((name, values) -> ((EList<Object>) configuration.eGet(clazz.getEStructuralFeature(name))).addAll(values));

        return configuration;
    }

    private static void inject(final Object component, final String field, final Object value) throws ReflectiveOperationException {
        Class<?> type = component.getClass();
        while(type != null) {
            try {
                final Field declared = type.getDeclaredField(field);
                declared.setAccessible(true);
                declared.set(component, value);
                return;
            } catch(final NoSuchFieldException e) {
                type = type.getSuperclass();
            }
        }

        throw new NoSuchFieldException(field);
    }

    /**
     * Creates and initialises a step on the given features.
     */
    private <T extends FittedPreparationComponent> T step(final T step, final EObject configuration, final List<EStructuralFeature> features,
                                                          final boolean inverse) throws Exception {
        final AttributeHelper attributes = Mockito.mock(AttributeHelper.class);
        Mockito.when(attributes.lookup(configuration, "features")).thenReturn(features);

        final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);
        Mockito.when(evaluator.attributeToBoolean(configuration, "inverse")).thenReturn(inverse);
        Mockito.when(evaluator.attributeToDouble(configuration, "new-minimum")).thenReturn(0.0);
        Mockito.when(evaluator.attributeToDouble(configuration, "new-maximum")).thenReturn(1.0);

        inject(step, "attributes", attributes);
        inject(step, "evaluator", evaluator);
        step.init(configuration);
        step.setContext(context);

        return step;
    }

    private static List<TypedEObject> run(final FittedPreparationComponent step, final TypedEObject... rows) {
        return step.process(Stream.of(rows)).toList();
    }

    @Nested
    @DisplayName("given a min-max normalisation without parameters")
    class FittedMinMax {
        @Test
        public void itFitsOnTheWholeStreamAndMapsToTheUnitInterval() throws Exception {
            // given
            final EObject configuration = configuration("min-max-normalisation", Map.of());
            final MinMaxNormalisationComponent step = step(new MinMaxNormalisationComponent(), configuration, List.of(x, y), false);

            // when
            final List<TypedEObject> rows = run(step, row(250.0, 10.0), row(300.0, 30.0), row(350.0, 20.0));

            // then
            Assertions.assertEquals(List.of(0.0, 0.5, 1.0), rows.stream().map(r -> r.eGetAsDouble(x)).toList());
            Assertions.assertEquals(List.of(0.0, 1.0, 0.5), rows.stream().map(r -> r.eGetAsDouble(y)).toList());
            Assertions.assertEquals(Map.of("minimum", List.of(250.0, 10.0), "maximum", List.of(350.0, 30.0)),
                                    FittedParameters.of(context).of(configuration).orElseThrow());
        }

        @Test
        public void aConstantFeatureIsOnlyShifted() throws Exception {
            // given
            final EObject configuration = configuration("min-max-normalisation", Map.of());
            final MinMaxNormalisationComponent step = step(new MinMaxNormalisationComponent(), configuration, List.of(x), false);

            // when
            final List<TypedEObject> rows = run(step, row(4.0, 0.0), row(4.0, 0.0));

            // then
            Assertions.assertEquals(List.of(0.0, 0.0), rows.stream().map(r -> r.eGetAsDouble(x)).toList());
        }
    }

    @Nested
    @DisplayName("given a min-max normalisation with stated parameters")
    class StatedMinMax {
        @Test
        public void itAppliesThemWithoutFitting() throws Exception {
            // given
            final EObject configuration = configuration("min-max-normalisation", Map.of("minimum", List.of(0.0), "maximum", List.of(10.0)));
            final MinMaxNormalisationComponent step = step(new MinMaxNormalisationComponent(), configuration, List.of(x), false);

            // when
            final List<TypedEObject> rows = run(step, row(5.0, 0.0), row(20.0, 0.0));

            // then
            Assertions.assertEquals(List.of(0.5, 2.0), rows.stream().map(r -> r.eGetAsDouble(x)).toList());
            Assertions.assertTrue(FittedParameters.of(context).of(configuration).isEmpty());
        }

        @Test
        public void theInverseUndoesThem() throws Exception {
            // given
            final EObject configuration = configuration("min-max-normalisation", Map.of("minimum", List.of(250.0), "maximum", List.of(350.0)));
            final MinMaxNormalisationComponent step = step(new MinMaxNormalisationComponent(), configuration, List.of(x), true);

            // when
            final List<TypedEObject> rows = run(step, row(0.25, 0.0));

            // then
            Assertions.assertEquals(275.0, rows.getFirst().eGetAsDouble(x), 1e-12);
        }

        @Test
        public void aNumberOfValuesOtherThanTheFeaturesIsRejected() {
            // given
            final EObject configuration = configuration("min-max-normalisation", Map.of("minimum", List.of(0.0), "maximum", List.of(10.0)));

            // when / then
            Assertions.assertThrows(InitializationException.class,
                                    () -> step(new MinMaxNormalisationComponent(), configuration, List.of(x, y), false));
        }
    }

    @Nested
    @DisplayName("given a z-score normalisation")
    class ZScore {
        @Test
        public void itFitsMeanAndStandardDeviationOfTheTrainingValues() throws Exception {
            // given
            final EObject configuration = configuration("z-score-normalisation", Map.of());
            final ZScoreNormalisationComponent step = step(new ZScoreNormalisationComponent(), configuration, List.of(y), false);

            // when
            final List<TypedEObject> rows = run(step, row(0.0, 2.0), row(0.0, 4.0), row(0.0, 4.0), row(0.0, 4.0),
                                                row(0.0, 5.0), row(0.0, 5.0), row(0.0, 7.0), row(0.0, 9.0));

            // then: mean 5, standard deviation (divided by n) 2
            Assertions.assertEquals(Map.of("μ", List.of(5.0), "σ", List.of(2.0)), FittedParameters.of(context).of(configuration).orElseThrow());
            Assertions.assertEquals(-1.5, rows.getFirst().eGetAsDouble(y), 1e-12);
        }

        @Test
        public void theInverseUndoesIt() throws Exception {
            // given
            final EObject configuration = configuration("z-score-normalisation", Map.of("μ", List.of(20000.0), "σ", List.of(400.0)));
            final ZScoreNormalisationComponent step = step(new ZScoreNormalisationComponent(), configuration, List.of(y), true);

            // when
            final List<TypedEObject> rows = run(step, row(0.0, -0.5));

            // then
            Assertions.assertEquals(19800.0, rows.getFirst().eGetAsDouble(y), 1e-9);
        }

        @Test
        public void aConstantFeatureIsOnlyShifted() throws Exception {
            // given
            final EObject configuration = configuration("z-score-normalisation", Map.of());
            final ZScoreNormalisationComponent step = step(new ZScoreNormalisationComponent(), configuration, List.of(y), false);

            // when
            final List<TypedEObject> rows = run(step, row(0.0, 3.0), row(0.0, 3.0));

            // then
            Assertions.assertEquals(List.of(0.0, 0.0), rows.stream().map(r -> r.eGetAsDouble(y)).toList());
        }
    }
}
