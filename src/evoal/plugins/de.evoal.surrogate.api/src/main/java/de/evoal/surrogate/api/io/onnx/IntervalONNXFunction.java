package de.evoal.surrogate.api.io.onnx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.PredictionInterval;
import de.evoal.surrogate.api.function.Rearrangement;
import de.evoal.surrogate.api.function.Rearrangement.Rearranged;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;

/**
 * An ONNX model that predicts a prediction interval with every output: for each output feature
 *   {@code y}, the graph has the outputs {@code y} (the prediction), {@code y.lower} and
 *   {@code y.upper} (the bounds). The function runs the model once per call and
 *   {@linkplain Rearrangement rearranges} the three values, so the bounds do not cross.
 * <p>
 * The model information of the file states the coverage of the interval
 *   ({@value #COVERAGE}) and whether the prediction is the median or the mean
 *   ({@value #POINT_PREDICTION}) in its state.
 */
public class IntervalONNXFunction extends ONNXFunction implements PredictionInterval {
    /**
     * The suffix of the output of the lower bound.
     */
    public static final String LOWER = ".lower";

    /**
     * The suffix of the output of the upper bound.
     */
    public static final String UPPER = ".upper";

    /**
     * The state entry with the coverage of the interval, a number in (0, 1).
     */
    public static final String COVERAGE = "coverage";

    /**
     * The state entry with the point prediction: {@value #MEDIAN} or {@value #MEAN}.
     */
    public static final String POINT_PREDICTION = "point-prediction";

    /**
     * The prediction is the median, a quantile like the bounds.
     */
    public static final String MEDIAN = "median";

    /**
     * The prediction is the mean.
     */
    public static final String MEAN = "mean";

    /**
     * The coverage of the interval.
     */
    private final double coverage;

    /**
     * Whether the prediction is the median.
     */
    private final boolean median;

    /**
     * @param modelName The name of the model.
     * @param input The input features.
     * @param output The output features.
     * @param session The session that runs the model.
     * @param coverage The coverage of the interval.
     * @param pointPrediction {@value #MEDIAN} or {@value #MEAN}.
     */
    public IntervalONNXFunction(final String modelName, final Space input, final Space output, final OrtSession session,
                                final double coverage, final String pointPrediction) {
        super(modelName, input, output, session);

        if(!MEDIAN.equals(pointPrediction) && !MEAN.equals(pointPrediction)) {
            throw new IllegalArgumentException("The point prediction is '" + pointPrediction + "', not '" + MEDIAN + "' or '" + MEAN + "'.");
        }

        this.coverage = coverage;
        this.median = MEDIAN.equals(pointPrediction);
    }

    /**
     * Creates the function of a loaded model file.
     *
     * @param storage The loaded model file.
     * @param input The input features.
     * @param output The output features.
     * @return The function.
     * @throws IllegalStateException if the file states no coverage or point prediction, or the
     *   graph has no bounds of an output feature.
     */
    public static IntervalONNXFunction of(final @NonNull ONNXModelStorage storage, final @NonNull Space input, final @NonNull Space output) {
        final OrtSession session = storage.getSession().orElseThrow(() -> new IllegalStateException("The ONNX model file is not loaded."));
        final List<Parameter> state = storage.getConfiguration()
                                             .map(SurrogateConfiguration::getState)
                                             .orElse(List.of());

        final Object coverage = valueOf(state, COVERAGE);
        final Object pointPrediction = valueOf(state, POINT_PREDICTION);
        requireBounds(session, output);

        return new IntervalONNXFunction(storage.getModelName(), input, output, session,
                                        ((Number) coverage).doubleValue(), pointPrediction.toString());
    }

    private static Object valueOf(final List<Parameter> state, final String name) {
        return state.stream()
                    .filter(p -> name.equals(p.getName()))
                    .map(Parameter::getValue)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("The model information of the ONNX model file has no '" + name + "' in its state."));
    }

    private static void requireBounds(final OrtSession session, final Space output) {
        final Set<String> outputs;
        try {
            outputs = session.getOutputInfo().keySet();
        } catch(final OrtException e) {
            throw new IllegalStateException("Failed to read the outputs of the ONNX model.", e);
        }

        final List<String> missing = new ArrayList<>();
        for(final EStructuralFeature feature : output) {
            for(final String suffix : List.of(LOWER, UPPER)) {
                if(!outputs.contains(feature.getName() + suffix)) {
                    missing.add(feature.getName() + suffix);
                }
            }
        }

        if(!missing.isEmpty()) {
            throw new IllegalStateException("The graph of the ONNX model has no outputs " + missing + " for the prediction interval.");
        }
    }

    @Override
    public void apply(final @NonNull TypedEObject in, final @NonNull TypedEObject out) {
        predict(in, output).forEach((feature, rearranged) -> out.eSet(feature, rearranged.prediction()));
    }

    @Override
    public Interval interval(final @NonNull TypedEObject input, final @NonNull EStructuralFeature output) {
        if(!this.output.contains(output)) {
            throw new IllegalArgumentException("'" + output.getName() + "' is not an output of the model.");
        }

        return predict(input, List.of(output)).get(output).interval();
    }

    @Override
    public double coverage(final @NonNull EStructuralFeature output) {
        return coverage;
    }

    /**
     * Runs the model once for all features.
     *
     * @return The rearranged prediction and interval of each feature.
     */
    private Map<EStructuralFeature, Rearranged> predict(final TypedEObject in, final Collection<EStructuralFeature> features) {
        final List<String> names = new ArrayList<>();
        for(final EStructuralFeature feature : features) {
            names.add(feature.getName());
            names.add(feature.getName() + LOWER);
            names.add(feature.getName() + UPPER);
        }

        final Map<String, Object> values = run(in, names);
        final Map<EStructuralFeature, Rearranged> result = new LinkedHashMap<>();
        for(final EStructuralFeature feature : features) {
            final String name = feature.getName();
            final double prediction = ((Number) values.get(name)).doubleValue();
            final double lower = ((Number) values.get(name + LOWER)).doubleValue();
            final double upper = ((Number) values.get(name + UPPER)).doubleValue();

            result.put(feature, median ? Rearrangement.ofQuantile(prediction, lower, upper)
                                       : Rearrangement.ofMean(prediction, lower, upper));
        }

        return result;
    }
}
