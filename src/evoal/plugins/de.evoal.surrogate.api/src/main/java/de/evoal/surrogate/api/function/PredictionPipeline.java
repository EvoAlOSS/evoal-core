package de.evoal.surrogate.api.function;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.misc.ConcurrentEClassAccess;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.pipeline.ConcreteStep;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.models.v202704.pipeline.PipelineFactory;
import de.evoal.models.v202704.pipeline.PipelineStep;
import de.evoal.models.v202704.pipeline.Step;
import de.evoal.pipeline.api.executor.StreamExecutor;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.pipeline.impl.internal.PipelineInstantiator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The executable prediction pipeline of a model: the preparation steps of the inputs with
 *   their fitted parameters, {@code 'model-prediction'}, and the inverses of the invertible
 *   preparation steps on the outputs, in reverse order. Every prediction of the model runs it,
 *   so predictions are in the original unit of the outputs. The model file stores it.
 *
 * <p>A model without stored pipeline (a foreign ONNX model) has the implicit pipeline that only
 *   predicts with the model function.</p>
 */
@Slf4j
public final class PredictionPipeline {
    private static final String PREPARATION_STEP = "de.evoal.surrogate.pipeline.preparation-step";
    private static final String INVERTIBLE_PREPARATION_STEP = "de.evoal.surrogate.pipeline.invertible-preparation-step";
    private static final String MODEL_PREDICTION = "de.evoal.surrogate.pipeline.model-prediction";

    /**
     * The name of the stored pipeline.
     */
    public static final String NAME = "predicting";

    /**
     * The model function.
     */
    private final ModelFunction function;

    /**
     * The executable pipeline, or {@code null} for the implicit pipeline.
     */
    private final PipelineDefinition definition;

    /**
     * The space of the rows that run through the pipeline.
     */
    private final Space space;

    /**
     * The steps before {@code 'model-prediction'}, all steps, and the steps after it.
     */
    private final PipelineComposite preparation;
    private final PipelineComposite all;
    private final PipelineComposite postparation;

    private PredictionPipeline(final ModelFunction function, final PipelineDefinition definition, final Space space,
                               final PipelineComposite preparation, final PipelineComposite all, final PipelineComposite postparation) {
        this.function = function;
        this.definition = definition;
        this.space = space;
        this.preparation = preparation;
        this.all = all;
        this.postparation = postparation;
    }

    /**
     * @param function The model function.
     * @return The implicit pipeline of a model without stored pipeline: it only predicts.
     */
    public static PredictionPipeline implicit(final @NonNull ModelFunction function) {
        return new PredictionPipeline(function, null, null, null, null, null);
    }

    /**
     * Instantiates an executable pipeline.
     *
     * @param definition The executable pipeline (see {@link #executable}), e.g. read from the
     *   model file.
     * @param space The space of the rows: all input and output features of the model.
     * @param function The model function that {@code 'model-prediction'} applies.
     * @return The pipeline.
     */
    public static PredictionPipeline of(final @NonNull PipelineDefinition definition, final @NonNull Space space, final @NonNull ModelFunction function) {
        final List<Step> steps = flatten(definition);
        final int prediction = indexOfPrediction(steps);

        final InterpreterState context = new InterpreterState();
        context.setSpace(space);
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName("model-function");
        context.put(variable, new ModelFunctionData(function, Optional.empty(), Optional.empty(), implicit(function)));

        final PipelineInstantiator instantiator = new PipelineInstantiator(space);
        final PipelineComposite preparation = instantiator.stepsToComposite(steps.subList(0, prediction));
        final PipelineComposite all = instantiator.stepsToComposite(steps);
        final PipelineComposite postparation = instantiator.stepsToComposite(steps.subList(prediction + 1, steps.size()));
        preparation.setContext(context);
        all.setContext(context);
        postparation.setContext(context);

        // predictions in parallel create rows and inputs of the model; build the classes' caches now
        ConcurrentEClassAccess.prepare(space.getEClass());
        ConcurrentEClassAccess.prepare(function.getInput().getEClass());

        return new PredictionPipeline(function, definition, space, preparation, all, postparation);
    }

    /**
     * Builds the executable pipeline from the predicting use case: a copy of it, including the
     *   pipelines it refers to, in which the preparation steps have the parameters they fitted
     *   while learning; the inverses of the invertible preparation steps with an output feature
     *   are added at the end, in reverse order. The inverse of a step undoes it on all its
     *   features; only the outputs leave the pipeline.
     *
     * @param predicting The predicting use case.
     * @param fitted The fitted parameters of the preparation steps.
     * @param outputs The output features of the model.
     * @return A new, self-contained pipeline.
     */
    public static PipelineDefinition executable(final @NonNull PipelineDefinition predicting, final @NonNull FittedParameters fitted,
                                                final @NonNull Collection<EStructuralFeature> outputs) {
        final List<ConcreteStep> inverses = new ArrayList<>();
        final PipelineDefinition result = copy(predicting, fitted, outputs, inverses);
        result.setName(NAME);

        Collections.reverse(inverses);
        result.getSteps().addAll(inverses);

        log.info("Executable prediction pipeline: {}.", describe(result));
        return result;
    }

    /**
     * @return The steps of the pipeline in order, e.g. {@code 'min-max-normalisation' [x:0],
     *   'model-prediction', 'z-score-normalisation' [y:0] (inverse)}.
     */
    private static String describe(final PipelineDefinition definition) {
        final List<String> steps = new ArrayList<>();
        for(final Step step : flatten(definition)) {
            final EObject configuration = ((ConcreteStep) step).getConfiguration();
            final StringBuilder text = new StringBuilder("'").append(configuration.eClass().getName()).append("'");
            if(DynamicEClassProvider.isInstanceOf(configuration, PREPARATION_STEP)) {
                text.append(' ').append(featuresOf(configuration).stream()
                                                                 .map(f -> ((EStructuralFeature) f).getName())
                                                                 .toList());
                final EStructuralFeature inverse = configuration.eClass().getEStructuralFeature("inverse");
                if(inverse != null && Boolean.TRUE.equals(configuration.eGet(inverse))) {
                    text.append(" (inverse)");
                }
            }
            steps.add(text.toString());
        }

        return String.join(", ", steps);
    }

    /**
     * Copies a pipeline with the pipelines it refers to, fills in the fitted parameters and
     *   collects the inverses of the invertible preparation steps with an output feature, in
     *   pipeline order.
     */
    private static PipelineDefinition copy(final PipelineDefinition definition, final FittedParameters fitted,
                                           final Collection<EStructuralFeature> outputs, final List<ConcreteStep> inverses) {
        final PipelineDefinition result = PipelineFactory.eINSTANCE.createPipelineDefinition();
        result.setName(definition.getName());

        for(final Step step : definition.getSteps()) {
            if(step instanceof PipelineStep pipeline) {
                final PipelineStep copy = PipelineFactory.eINSTANCE.createPipelineStep();
                copy.setDefinition(copy(pipeline.getDefinition(), fitted, outputs, inverses));
                result.getSteps().add(copy);
                continue;
            }

            final ConcreteStep original = (ConcreteStep) step;
            final ConcreteStep copy = EcoreUtil.copy(original);
            final EObject configuration = copy.getConfiguration();

            if(DynamicEClassProvider.isInstanceOf(configuration, PREPARATION_STEP)) {
                fitted.of(original.getConfiguration())
                      .ifPresent(parameters -> setParameters(configuration, parameters));

                if(DynamicEClassProvider.isInstanceOf(configuration, INVERTIBLE_PREPARATION_STEP)
                        && featuresOf(configuration).stream().anyMatch(outputs::contains)) {
                    final ConcreteStep inverse = EcoreUtil.copy(copy);
                    final EObject inverseConfiguration = inverse.getConfiguration();
                    inverseConfiguration.eSet(inverseConfiguration.eClass().getEStructuralFeature("inverse"), true);
                    inverses.add(inverse);
                }
            }

            result.getSteps().add(copy);
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private static void setParameters(final EObject configuration, final Map<String, List<Double>> parameters) {
        for(final Map.Entry<String, List<Double>> parameter : parameters.entrySet()) {
            final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(parameter.getKey());
            final List<Object> values = (List<Object>) configuration.eGet(feature);
            values.clear();
            values.addAll(parameter.getValue());
        }
    }

    private static List<?> featuresOf(final EObject configuration) {
        return (List<?>) configuration.eGet(configuration.eClass().getEStructuralFeature("features"));
    }

    /**
     * @return The concrete steps of the pipeline, with the pipelines it refers to written out.
     */
    private static List<Step> flatten(final PipelineDefinition definition) {
        final List<Step> result = new ArrayList<>();
        for(final Step step : definition.getSteps()) {
            if(step instanceof PipelineStep pipeline) {
                result.addAll(flatten(pipeline.getDefinition()));
            } else {
                result.add(step);
            }
        }

        return result;
    }

    private static int indexOfPrediction(final List<Step> steps) {
        for(int i = 0; i < steps.size(); ++i) {
            if(steps.get(i) instanceof ConcreteStep concrete
                    && DynamicEClassProvider.isInstanceOf(concrete.getConfiguration(), MODEL_PREDICTION)) {
                return i;
            }
        }

        throw new IllegalStateException("The prediction pipeline has no 'model-prediction' step.");
    }

    /**
     * @return The executable pipeline, or empty for the implicit pipeline.
     */
    public Optional<PipelineDefinition> definition() {
        return Optional.ofNullable(definition);
    }

    /**
     * Whether several threads may {@linkplain #predict predict} at the same time: the model
     *   function and every step of the pipeline are thread-safe. Each prediction runs on rows of
     *   its own.
     *
     * @return {@code true} iff {@link #predict} is thread-safe.
     */
    public boolean isThreadSafe() {
        return definition == null ? function.isThreadSafe() : all.isThreadSafe();
    }

    /**
     * Predicts the outputs of the model for an input: runs the pipeline on a copy of the input
     *   features, so the input is not changed.
     *
     * @param input An object with the input features of the model.
     * @param output The object that receives the output features of the model.
     */
    public void predict(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
        if(definition == null) {
            function.apply(input, output);
            return;
        }

        final TypedEObject row = run(all, rowOf(input));
        function.getOutput().forEach(feature -> output.eSet(feature, row.eGet(feature)));
    }

    /**
     * @param input An object with the input features of the model.
     * @return A new object with the input features after the preparation steps, in the space of
     *   the model function: the input that the model itself sees.
     */
    public TypedEObject prepare(final @NonNull TypedEObject input) {
        final TypedEObject result = function.getInput().newEObject();
        final TypedEObject row = definition == null ? input : run(preparation, rowOf(input));
        function.getInput().forEach(feature -> result.eSet(feature, row.eGet(feature)));

        return result;
    }

    /**
     * @return Whether steps after the prediction change the outputs, i.e. whether the model
     *   predicts in another unit than the pipeline.
     */
    public boolean hasPostparation() {
        return definition != null && !postparation.getChildren().isEmpty();
    }

    /**
     * The slope dy/dy' of the steps after the prediction for an output feature, at a value y'
     *   of the model itself (e.g. to convert a standard deviation of the model into the original
     *   unit). It is the secant over [y' - 1/2, y' + 1/2], which is exact for affine steps.
     *
     * @param feature An output feature.
     * @param value A value of the feature as the model predicts it.
     * @return The slope; 1 without steps after the prediction.
     */
    public double slope(final @NonNull EStructuralFeature feature, final double value) {
        if(!hasPostparation()) {
            return 1.0;
        }

        // the other features keep their default 0; the steps only change the features they name
        final TypedEObject lower = space.newEObject();
        final TypedEObject upper = space.newEObject();
        lower.eSet(feature, value - 0.5);
        upper.eSet(feature, value + 0.5);

        return run(postparation, upper).eGetAsDouble(feature) - run(postparation, lower).eGetAsDouble(feature);
    }

    private TypedEObject rowOf(final TypedEObject input) {
        final TypedEObject row = space.newEObject();
        function.getInput().forEach(feature -> row.eSet(feature, input.eGet(feature)));

        return row;
    }

    private static TypedEObject run(final PipelineComposite pipeline, final TypedEObject row) {
        return new StreamExecutor().execute(pipeline, List.of(row)).getFirst();
    }
}
