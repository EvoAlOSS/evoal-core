package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.executor.StreamExecutor;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.PredictionPipeline;
import lombok.NonNull;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Whether a prediction pipeline may run on several threads at once, and whether it computes
 *   the same predictions there (#293).
 */
public class PredictionThreadSafetyTest {
    /**
     * The package of the test classes; dynamic objects need one.
     */
    private static final EPackage PACKAGE = EcoreFactory.eINSTANCE.createEPackage();

    private EAttribute x;
    private EAttribute y;
    private Space space;
    private InterpreterState context;

    /**
     * y = 3x + 1, declared thread-safe or not.
     */
    private static final class Line extends ModelFunction {
        private final boolean threadSafe;

        Line(final Space input, final Space output, final boolean threadSafe) {
            super("line", input, output);
            this.threadSafe = threadSafe;
        }

        @Override
        public void apply(final @NonNull TypedEObject in, final @NonNull TypedEObject out) {
            final EStructuralFeature feature = output.iterator().next();
            out.eSet(feature, 3.0 * in.eGetAsDouble(input.iterator().next()) + 1.0);
        }

        @Override
        public boolean isThreadSafe() {
            return threadSafe;
        }
    }

    @BeforeEach
    void setUp() {
        final EClass data = eClass("data");
        x = attribute(data, "x:0", false);
        y = attribute(data, "y:0", false);
        space = new Space(data);
        context = new InterpreterState();
    }

    @Test
    public void statedPreparationStepsAndAThreadSafeModelAreThreadSafe() throws Exception {
        Assertions.assertTrue(pipeline(true, true).isThreadSafe());
    }

    @Test
    public void aModelThatIsNotDeclaredMakesThePipelineNotThreadSafe() throws Exception {
        Assertions.assertFalse(pipeline(false, true).isThreadSafe());
    }

    @Test
    public void aStepThatStillFitsItsParametersIsNotThreadSafe() throws Exception {
        Assertions.assertFalse(pipeline(true, false).isThreadSafe());
    }

    @Test
    public void aStepThatDoesNotDeclareItMakesThePipelineNotThreadSafe() throws Exception {
        // given
        final PipelineComposite pipeline = PipelineComposite.of(List.of(pipeline(true, true), Mockito.mock(PipelineComponent.class)));

        // then
        Assertions.assertFalse(pipeline.isThreadSafe());
    }

    @Test
    public void theImplicitPipelineFollowsTheModel() {
        Assertions.assertTrue(PredictionPipeline.implicit(line(true)).isThreadSafe());
        Assertions.assertFalse(PredictionPipeline.implicit(line(false)).isThreadSafe());
    }

    @Test
    public void predictionsInParallelEqualTheSequentialOnes() throws Exception {
        // given
        final PipelineComposite pipeline = pipeline(true, true);
        final List<Double> inputs = IntStream.range(0, 1000).mapToObj(i -> i / 100.0).toList();
        final List<Double> sequential = inputs.stream().map(input -> predict(pipeline, input)).toList();

        // when
        ConcurrentEClassAccess.prepare(space.getEClass());
        final List<Callable<Double>> tasks = inputs.stream()
                                                   .<Callable<Double>>map(input -> () -> predict(pipeline, input))
                                                   .toList();
        final List<Double> parallel = new ArrayList<>();
        try(final ExecutorService threads = Executors.newFixedThreadPool(8)) {
            for(final Future<Double> future : threads.invokeAll(tasks)) {
                parallel.add(future.get());
            }
        }

        // then: x in [0, 10] is mapped to [0, 1], the line predicts 3x' + 1, the inverse of the
        // z-score (μ 100, σ 10) maps it back
        Assertions.assertEquals(sequential, parallel);
        Assertions.assertEquals(140.0, predict(pipeline, 10.0), 1e-9);
    }

    /**
     * Runs a row with the input through the pipeline, as {@link PredictionPipeline} does.
     */
    private double predict(final PipelineComposite pipeline, final double input) {
        final TypedEObject row = space.newEObject();
        row.eSet(x, input);

        return new StreamExecutor().execute(pipeline, List.of(row)).getFirst().eGetAsDouble(y);
    }

    /**
     * 'min-max-normalisation' on x, 'model-prediction' with the line, the inverse of
     *   'z-score-normalisation' on y.
     *
     * @param threadSafe Whether the line is declared thread-safe.
     * @param stated Whether the normalisation of x states its parameters.
     */
    private PipelineComposite pipeline(final boolean threadSafe, final boolean stated) throws Exception {
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName("model-function");
        context.put(variable, new ModelFunctionData(line(threadSafe), Optional.empty(), Optional.empty()));

        final Map<String, List<Double>> minMax = stated ? Map.of("minimum", List.of(0.0), "maximum", List.of(10.0)) : Map.of();
        final PipelineComposite pipeline = PipelineComposite.of(List.of(
                step(new MinMaxNormalisationComponent(), configuration("min-max-normalisation", minMax), x, false),
                new ModelPredictionComponent(),
                step(new ZScoreNormalisationComponent(), configuration("z-score-normalisation", Map.of("μ", List.of(100.0), "σ", List.of(10.0))), y, true)));
        pipeline.setContext(context);

        return pipeline;
    }

    private Line line(final boolean threadSafe) {
        return new Line(space.subSpace(List.of(x)), space.subSpace(List.of(y)), threadSafe);
    }

    private static EAttribute attribute(final EClass type, final String name, final boolean many) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        attribute.setUpperBound(many ? -1 : 1);
        type.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    private static EClass eClass(final String name) {
        final EClass clazz = EcoreFactory.eINSTANCE.createEClass();
        clazz.setName(name);
        PACKAGE.getEClassifiers().add(clazz);

        return clazz;
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

    /**
     * Creates and initialises a step on one feature.
     */
    private static <T extends FittedPreparationComponent> T step(final T step, final EObject configuration, final EStructuralFeature feature,
                                                                 final boolean inverse) throws Exception {
        final AttributeHelper attributes = Mockito.mock(AttributeHelper.class);
        Mockito.when(attributes.lookup(configuration, "features")).thenReturn(List.of(feature));

        final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);
        Mockito.when(evaluator.attributeToBoolean(configuration, "inverse")).thenReturn(inverse);
        Mockito.when(evaluator.attributeToDouble(configuration, "new-minimum")).thenReturn(0.0);
        Mockito.when(evaluator.attributeToDouble(configuration, "new-maximum")).thenReturn(1.0);

        inject(step, "attributes", attributes);
        inject(step, "evaluator", evaluator);
        step.init(configuration);

        return step;
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
}
