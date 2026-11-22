package de.evoal.surrogate.main.gof;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * A goodness-of-fit measure: compares the predictions of the surrogate with the actual values
 *   of the assessed data set (the training data while learning, the test data while testing)
 *   and records one value per output feature in the
 *   {@link de.evoal.surrogate.api.training.GoodnessOfFit}.
 */
@Slf4j
public abstract class GoodnessOfFitMeasure extends SurrogateInformationCalculator {
    @Override
    protected final boolean describesTrainingData() {
        return false;
    }

    @Override
    public final Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
        final String dataSet = goodnessOfFit.dataSet();
        final EObjectPairStreamSupplier data = goodnessOfFit.data()
                                                            .orElseGet(() -> helper.loadTrainingDataPaired(context));

        final Map<EStructuralFeature, PredictedValues> values = PredictedValues.collect(functionData, data);

        for(final Map.Entry<EStructuralFeature, PredictedValues> entry : values.entrySet()) {
            final String feature = entry.getKey().getName();
            final OptionalDouble value = measure(entry.getValue());

            if(value.isEmpty()) {
                log.warn("{} of {} is undefined on the {} data: {}.", this, feature, dataSet, whyUndefined());
                continue;
            }

            log.info("{} of {} on the {} data: {}", this, feature, dataSet, value.getAsDouble());
            goodnessOfFit.record(entry.getKey(), qualifiedName(), dataSet, value.getAsDouble());
        }

        return Optional.empty();
    }

    /**
     * @return The qualified name of the DL function of the measure, the key of its values.
     */
    protected abstract String qualifiedName();

    /**
     * Calculates the measure of one output feature.
     *
     * @param values The actual and the predicted values of the feature.
     * @return The value, or empty if the measure is undefined for these values.
     */
    protected abstract OptionalDouble measure(final PredictedValues values);

    /**
     * @return Why the measure can be undefined, for the warning.
     */
    protected abstract String whyUndefined();
}
