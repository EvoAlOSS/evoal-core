package de.evoal.surrogate.main.gof;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunctionData;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The actual and the predicted values of one output feature, for comparing a surrogate with
 *   its data.
 *
 * @param actual The values of the data.
 * @param predicted The values the surrogate predicts for the same inputs, in the same order.
 */
public record PredictedValues(double[] actual, double[] predicted) {

    /**
     * Applies the surrogate to every input of the data and collects the values per output
     *   feature.
     *
     * @param function The trained surrogate.
     * @param data Pairs of input and expected output.
     * @return The values per output feature, in the order of the output space.
     */
    public static Map<EStructuralFeature, PredictedValues> collect(final ModelFunctionData function, final EObjectPairStreamSupplier data) {
        final Space outputSpace = function.function().getOutput();

        final Map<EStructuralFeature, List<Double>> actual = new LinkedHashMap<>();
        final Map<EStructuralFeature, List<Double>> predicted = new LinkedHashMap<>();
        for (final EStructuralFeature feature : outputSpace) {
            actual.put(feature, new ArrayList<>());
            predicted.put(feature, new ArrayList<>());
        }

        data.get().forEach(pair -> {
            final TypedEObject expected = pair.getSecond();
            final TypedEObject calculated = new TypedEObject(expected.eSpace());

            function.function().apply(pair.getFirst(), calculated);

            for (final EStructuralFeature feature : outputSpace) {
                actual.get(feature).add(expected.eGetAsDouble(feature));
                predicted.get(feature).add(calculated.eGetAsDouble(feature));
            }
        });

        final Map<EStructuralFeature, PredictedValues> result = new LinkedHashMap<>();
        for (final EStructuralFeature feature : outputSpace) {
            result.put(feature, new PredictedValues(toArray(actual.get(feature)), toArray(predicted.get(feature))));
        }

        return result;
    }

    private static double[] toArray(final List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
