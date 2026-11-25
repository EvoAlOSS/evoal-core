package de.evoal.surrogate.main.resampling;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.ExpressionInterpreter;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.random.RandomService;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.execution.ModelFunction;
import de.evoal.languages.model.execution.Program;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.pipeline.Step;
import de.evoal.pipeline.api.executor.StreamExecutor;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.pipeline.api.values.PipelineValues;
import de.evoal.pipeline.impl.internal.PipelineInstantiator;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import de.evoal.surrogate.api.training.PredictedValues;
import de.evoal.surrogate.api.training.ResampledValues;
import de.evoal.surrogate.api.training.TrainingTaskHelper;
import de.evoal.surrogate.main.gof.GofCalculatorFunction;
import de.evoal.surrogate.main.internal.MLLProgramExecutionSwitch;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * {@code 'resample'(scheme, learning, assessment)}: assesses the learning with a resampling
 *   scheme. It loads the training data as {@code 'training-data-loader'} loaded it, splits it
 *   into the parts of the scheme and, for each part, in an interpreter state of its own that
 *   holds only the program variables:
 *
 * <ol>
 *   <li>runs the {@code learning} steps on copies of the training rows (validation, the
 *     preparation fitted on these rows, {@code 'model-learner'}),</li>
 *   <li>runs the {@code assessment} steps on copies of the held-out rows (validation),</li>
 *   <li>predicts the rows that leave them through the prediction pipeline of the part's
 *     model and assesses these predictions with the measures of {@code specify gof}.</li>
 * </ol>
 *
 * After the last part, the measures of {@code specify gof} assess the predictions of all
 *   parts together (pooled). The values of the parts and the pooled value are recorded as
 *   {@link ResampledValues} in the data set of the scheme. The final model, its fitted
 *   parameters and its other values live in the outermost state of the run, which the parts
 *   do not share, so they are not changed.
 */
@Slf4j
@Dependent
@Named("de.evoal.surrogate.pipeline.resample")
public class ResampleFunction implements EvoalBuiltinFunction {
    /**
     * The prefix of the random streams of the schemes.
     */
    static final String STREAM = "de.evoal.surrogate.pipeline.resample/";

    @Inject
    private TrainingTaskHelper helper;

    @Inject
    private RandomService random;

    @Inject
    private EAnnotationHelper annotations;

    @Override
    public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        if(arguments.length != 3 || !(arguments[0] instanceof Instance scheme)
                || !(arguments[1] instanceof List<?> learning) || !(arguments[2] instanceof List<?> assessment)) {
            throw new IllegalArgumentException("'resample' needs a resampling scheme and two arrays of steps, e.g. "
                                               + "'resample'('k-fold-cross-validation' { 'k' := 10; }, [pipeline 'validation', "
                                               + "pipeline 'preparation', step { component 'model-learner' {} }], [pipeline 'validation']), but got "
                                               + Arrays.toString(arguments) + ".");
        }

        final ModelFunction goodnessOfFit = GofCalculatorFunction.of(context)
                                                                 .orElseThrow(() -> new IllegalStateException("'resample' needs the measures of 'specify gof'."));

        final ResamplingScheme resampling = schemeOf(context, scheme);
        final List<EStructuralFeature> additional = resampling instanceof BlockCrossValidation block && block.blocks() instanceof GivenBlocks given
                                                    ? List.of(given.feature())
                                                    : List.of();
        final List<TypedEObject> rows = helper.loadInputStreams(context, additional).toList();
        final List<Part> parts = resampling.parts(rows);
        log.info("Resampling with '{}': {} parts of {} rows.", resampling.name(), parts.size(), rows.size());

        // output feature → measure → value per part (undefined values are missing)
        final Map<EStructuralFeature, Map<String, List<Double>>> values = new LinkedHashMap<>();
        final List<Assessed> assessed = new ArrayList<>();
        for(int p = 0; p < parts.size(); ++p) {
            final Part part = parts.get(p);
            log.info("'{}' part {} of {}: learning on {} rows, assessing {} rows.", resampling.name(), p + 1, parts.size(),
                     part.training().length, part.heldOut().length);

            final Optional<Assessed> rowsOfPart = predict(context, goodnessOfFit, resampling.name(), part, rows, steps(learning), steps(assessment));
            if(rowsOfPart.isEmpty()) {
                continue;
            }

            assessed.add(rowsOfPart.get());
            assess(context, goodnessOfFit, resampling.name(), rowsOfPart.get())
                    .forEach((feature, measures) -> measures.forEach((measure, value) ->
                            values.computeIfAbsent(feature, f -> new LinkedHashMap<>())
                                  .computeIfAbsent(measure, m -> new ArrayList<>())
                                  .add(value)));
        }

        final Map<EStructuralFeature, Map<String, Double>> pooled = assessed.isEmpty()
                                                                    ? Map.of()
                                                                    : assess(context, goodnessOfFit, resampling.name(), Assessed.pool(assessed));

        record(GoodnessOfFit.of(context), resampling.name(), parts.size(), values, pooled);

        return Optional.empty();
    }

    /**
     * The held-out rows of one part, or of all parts, that leave the assessment steps, and the
     *   predictions of the part's model for them.
     *
     * @param rows The rows.
     * @param predictions The actual and predicted values of the rows per output feature.
     */
    record Assessed(List<TypedEObject> rows, Map<EStructuralFeature, PredictedValues> predictions) {
        /**
         * @return The rows and predictions of all parts, one part after the other.
         */
        static Assessed pool(final List<Assessed> parts) {
            return new Assessed(parts.stream().flatMap(part -> part.rows().stream()).toList(),
                                PredictedValues.pool(parts.stream().map(Assessed::predictions).toList()));
        }
    }

    /**
     * Learns one part in a state of its own and predicts its held-out rows.
     *
     * @return The held-out rows that leave the assessment steps and their predictions, or empty
     *   if no row leaves them.
     */
    private Optional<Assessed> predict(final InterpreterState context, final ModelFunction goodnessOfFit, final String scheme,
                                       final Part part, final List<TypedEObject> rows,
                                       final List<Step> learning, final List<Step> assessment) {
        final InterpreterState state = stateOf(context, goodnessOfFit);

        run(state, learning, copies(rows, part.training()));
        if(!(state.getByName("model-function") instanceof ModelFunctionData model)) {
            throw new IllegalStateException("The learning steps of 'resample' learn no model; they need a 'model-learner' step.");
        }

        final List<TypedEObject> assessed = run(state, assessment, copies(rows, part.heldOut()));
        if(assessed.isEmpty()) {
            log.warn("Skipping a part of '{}': no held-out row passes the assessment steps.", scheme);
            return Optional.empty();
        }

        return Optional.of(new Assessed(assessed, PredictedValues.collect(model, pairs(assessed))));
    }

    /**
     * Assesses predicted rows with the measures of {@code specify gof}, in a state of its own
     *   that holds only the program variables.
     *
     * @return Output feature → measure → value on the rows (undefined values are missing).
     */
    private static Map<EStructuralFeature, Map<String, Double>> assess(final InterpreterState context, final ModelFunction goodnessOfFit,
                                                                      final String scheme, final Assessed assessed) {
        final InterpreterState state = stateOf(context, goodnessOfFit);
        final GoodnessOfFit values = GoodnessOfFit.of(state);
        values.assess(scheme, pairs(assessed.rows()), assessed.predictions());

        BeanFactory.create(MLLProgramExecutionSwitch.class)
                   .setState(state)
                   .doSwitch(goodnessOfFit);

        final Map<EStructuralFeature, Map<String, Double>> result = new LinkedHashMap<>();
        values.values().forEach((feature, measures) -> measures.forEach((measure, dataSets) -> {
            if(dataSets.get(scheme) instanceof Double value) {
                result.computeIfAbsent(feature, f -> new LinkedHashMap<>())
                      .put(measure, value);
            }
        }));

        return result;
    }

    /**
     * @return A state that holds only the program variables of the program of
     *   {@code specify gof}.
     */
    private static InterpreterState stateOf(final InterpreterState context, final ModelFunction goodnessOfFit) {
        final InterpreterState state = new InterpreterState();
        state.setSpace(context.getSpace());
        ((Program) goodnessOfFit.eContainer()).getVariables()
                                              .forEach(variable -> state.put(variable, variable));

        return state;
    }

    /**
     * @return The rows as pairs of input and expected output.
     */
    private static EObjectPairStreamSupplier pairs(final List<TypedEObject> rows) {
        return () -> rows.stream()
                         .map(row -> new EObjectPair(row, row));
    }

    /**
     * Runs steps on rows in the given state, as {@code 'execute'} does, but on the given rows
     *   instead of a source.
     *
     * @return The rows that leave the steps.
     */
    private static List<TypedEObject> run(final InterpreterState state, final List<Step> steps, final List<TypedEObject> rows) {
        if(steps.isEmpty()) {
            return rows;
        }

        final PipelineComposite composite = new PipelineInstantiator(state.getSpace()).stepsToComposite(steps);
        composite.setContext(state);
        PipelineValues.of(state).beginExecution();

        final List<TypedEObject> result = new StreamExecutor().execute(composite, rows);
        composite.close();

        return result;
    }

    /**
     * Records the mean, the standard deviation, the values of the parts and the pooled value in
     *   the data set of the scheme. A measure that is undefined on every part and pooled is not
     *   recorded.
     *
     * @param parts The number of parts of the scheme.
     * @param values Output feature → measure → values of the parts on which it is defined.
     * @param pooled Output feature → measure → value on the held-out rows of all parts, if
     *   defined.
     */
    static void record(final GoodnessOfFit goodnessOfFit, final String scheme, final int parts,
                       final Map<EStructuralFeature, Map<String, List<Double>>> values,
                       final Map<EStructuralFeature, Map<String, Double>> pooled) {
        // output feature → measure, in the order of the parts, then the pooled values
        final Map<EStructuralFeature, List<String>> recorded = new LinkedHashMap<>();
        values.forEach((feature, measures) -> recorded.computeIfAbsent(feature, f -> new ArrayList<>()).addAll(measures.keySet()));
        pooled.forEach((feature, measures) -> measures.keySet().forEach(measure -> {
            final List<String> known = recorded.computeIfAbsent(feature, f -> new ArrayList<>());
            if(!known.contains(measure)) {
                known.add(measure);
            }
        }));

        recorded.forEach((feature, measures) -> measures.forEach(measure -> {
            final List<Double> list = values.getOrDefault(feature, Map.of()).getOrDefault(measure, List.of());
            final Double pooledValue = pooled.getOrDefault(feature, Map.of()).get(measure);
            final ResampledValues resampled = ResampledValues.of(list, pooledValue == null ? OptionalDouble.empty() : OptionalDouble.of(pooledValue));

            if(list.isEmpty()) {
                log.warn("{} of {} is undefined on every part of '{}'; there is only the pooled value, which uses the held-out rows of all parts.",
                         measure, feature.getName(), scheme);
            } else if(list.size() < parts) {
                log.warn("{} of {} is undefined on {} of {} parts of '{}'; the mean and the standard deviation use the other parts, "
                         + "the pooled value uses the held-out rows of all parts.", measure, feature.getName(), parts - list.size(), parts, scheme);
            }
            if(resampled.pooled().isEmpty()) {
                log.warn("{} of {} is undefined on the held-out rows of all parts of '{}'; there is no pooled value.", measure, feature.getName(), scheme);
            }

            log.info("{} of {} by '{}': mean {}, standard deviation {} over {} parts, pooled {}.", measure, feature.getName(), scheme,
                     text(resampled.mean()), text(resampled.standardDeviation()), list.size(), text(resampled.pooled()));
            goodnessOfFit.record(feature, measure, scheme, resampled);
        }));
    }

    private static String text(final OptionalDouble value) {
        return value.isPresent() ? Double.toString(value.getAsDouble()) : "undefined";
    }

    /**
     * @return Copies of the rows with the given indices, in their order, so that the steps of
     *   one part do not change the rows of another.
     */
    private static List<TypedEObject> copies(final List<TypedEObject> rows, final int[] indices) {
        return Arrays.stream(indices)
                     .mapToObj(i -> rows.get(i).copy())
                     .toList();
    }

    private static List<Step> steps(final List<?> values) {
        return values.stream()
                     .map(value -> {
                         if(!(value instanceof Step step)) {
                             throw new IllegalArgumentException("'resample' expects steps, e.g. pipeline 'validation', but got " + value + ".");
                         }
                         return step;
                     })
                     .toList();
    }

    /**
     * Creates the scheme of an instance of {@code 'resampling-scheme'}.
     */
    private ResamplingScheme schemeOf(final InterpreterState context, final Instance scheme) {
        final String name = scheme.getDefinition().getName();

        return switch(name) {
            case KFoldCrossValidation.NAME -> new KFoldCrossValidation(integer(context, scheme, "k"), random.random(STREAM + name));
            case LeaveOneOutCrossValidation.NAME -> new LeaveOneOutCrossValidation();
            case Bootstrap.NAME -> new Bootstrap(integer(context, scheme, "repetitions"), random.random(STREAM + name));
            case BlockCrossValidation.NAME -> new BlockCrossValidation(blocksOf(context, (Instance) value(context, scheme, "blocks")));
            default -> throw new IllegalArgumentException("Unknown resampling scheme '" + name + "'.");
        };
    }

    /**
     * Creates the block definition of an instance of {@code 'block-definition'}.
     */
    private BlockDefinition blocksOf(final InterpreterState context, final Instance blocks) {
        final String name = blocks.getDefinition().getName();
        final TaskDescription task = (TaskDescription) context.getByName("learning-task");
        final Map<DataDescription, EStructuralFeature> features = annotations.featuresOf(context.getSpace());
        final List<EStructuralFeature> inputs = task.getInputs()
                                                    .stream()
                                                    .map(features::get)
                                                    .toList();

        return switch(name) {
            case KMeansBlocks.NAME -> new KMeansBlocks(integer(context, blocks, "k"), inputs,
                                                       random.random(STREAM + BlockCrossValidation.NAME + "/" + name));
            case GridBlocks.NAME -> new GridBlocks(integer(context, blocks, "intervals"), inputs);
            case GivenBlocks.NAME -> {
                final DataDescription description = (DataDescription) value(context, blocks, "feature");
                final EStructuralFeature feature = features.get(description);
                if(feature == null) {
                    throw new IllegalStateException("The feature '" + description.getName() + "' of '" + name + "' is not part of the training data.");
                }
                yield new GivenBlocks(feature);
            }
            default -> throw new IllegalArgumentException("Unknown block definition '" + name + "'.");
        };
    }

    private static int integer(final InterpreterState context, final Instance instance, final String attribute) {
        try {
            return NumericConversions.toInteger(value(context, instance, attribute));
        } catch(final IllegalArgumentException e) {
            throw new IllegalArgumentException("'" + attribute + "' of '" + instance.getDefinition().getName() + "' must be an integer: " + e.getMessage(), e);
        }
    }

    /**
     * @return The evaluated value of an attribute of an instance.
     */
    private static Object value(final InterpreterState context, final Instance instance, final String attribute) {
        final Attribute value = instance.findAttribute(attribute);
        if(value == null) {
            throw new IllegalArgumentException("'" + instance.getDefinition().getName() + "' needs '" + attribute + "'.");
        }

        return new ExpressionInterpreter(context).execute(value.getValue());
    }
}
