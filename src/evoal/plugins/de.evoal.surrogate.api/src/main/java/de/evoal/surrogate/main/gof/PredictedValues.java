package de.evoal.surrogate.main.gof;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.PredictionInterval;
import de.evoal.surrogate.api.function.PredictionPipeline;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The actual and the predicted values of one output feature, for comparing a surrogate with
 *   its data.
 *
 * @param actual The values of the data.
 * @param predicted The values the surrogate predicts for the same inputs, in the same order.
 * @param bounds The bounds of the prediction intervals for the same inputs, if the surrogate
 *   predicts an interval.
 */
public record PredictedValues(double[] actual, double[] predicted, Optional<Bounds> bounds) {
    /**
     * The bounds of the prediction intervals, in the original unit of the feature.
     *
     * @param lower The lower bounds, in the order of the values.
     * @param upper The upper bounds, in the order of the values; each at least its lower bound.
     */
    public record Bounds(double[] lower, double[] upper) {
    }

    /**
     * The values of a surrogate without prediction interval.
     */
    public PredictedValues(final double[] actual, final double[] predicted) {
        this(actual, predicted, Optional.empty());
    }

    /**
     * Predicts the outputs of every input of the data through the prediction pipeline of the
     *   surrogate (in the original unit) and collects the values per output feature. For a
     *   surrogate that predicts an interval, the bounds are collected as well: the model gives
     *   them at the prepared input, and the steps after the prediction convert each bound into the
     *   original unit (a decreasing step swaps them).
     *
     * @param function The trained surrogate.
     * @param data Pairs of input and expected output.
     * @return The values per output feature, in the order of the output space.
     */
    public static Map<EStructuralFeature, PredictedValues> collect(final ModelFunctionData function, final EObjectPairStreamSupplier data) {
        final Space outputSpace = function.function().getOutput();

        final Map<EStructuralFeature, List<Double>> actual = new LinkedHashMap<>();
        final Map<EStructuralFeature, List<Double>> predicted = new LinkedHashMap<>();
        final Map<EStructuralFeature, List<Double>> lower = new LinkedHashMap<>();
        final Map<EStructuralFeature, List<Double>> upper = new LinkedHashMap<>();
        for (final EStructuralFeature feature : outputSpace) {
            actual.put(feature, new ArrayList<>());
            predicted.put(feature, new ArrayList<>());
            lower.put(feature, new ArrayList<>());
            upper.put(feature, new ArrayList<>());
        }

        final Optional<PredictionInterval> interval = function.function() instanceof PredictionInterval i ? Optional.of(i) : Optional.empty();
        final PredictionPipeline pipeline = function.pipeline();

        data.get().forEach(pair -> {
            final TypedEObject expected = pair.getSecond();
            final TypedEObject calculated = new TypedEObject(expected.eSpace());

            function.predict(pair.getFirst(), calculated);

            for (final EStructuralFeature feature : outputSpace) {
                actual.get(feature).add(expected.eGetAsDouble(feature));
                predicted.get(feature).add(calculated.eGetAsDouble(feature));
            }

            interval.ifPresent(model -> {
                final TypedEObject prepared = pipeline.prepare(pair.getFirst());
                for (final EStructuralFeature feature : outputSpace) {
                    final PredictionInterval.Interval bounds = model.interval(prepared, feature);
                    final double first = pipeline.restore(feature, bounds.lower());
                    final double second = pipeline.restore(feature, bounds.upper());
                    lower.get(feature).add(Math.min(first, second));
                    upper.get(feature).add(Math.max(first, second));
                }
            });
        });

        final Map<EStructuralFeature, PredictedValues> result = new LinkedHashMap<>();
        for (final EStructuralFeature feature : outputSpace) {
            final Optional<Bounds> bounds = interval.map(model -> new Bounds(toArray(lower.get(feature)), toArray(upper.get(feature))));
            result.put(feature, new PredictedValues(toArray(actual.get(feature)), toArray(predicted.get(feature)), bounds));
        }

        return result;
    }

    private static double[] toArray(final List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
