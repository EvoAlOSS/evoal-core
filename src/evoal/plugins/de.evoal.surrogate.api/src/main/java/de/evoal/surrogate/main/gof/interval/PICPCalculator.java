package de.evoal.surrogate.main.gof.interval;

import java.util.OptionalDouble;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.surrogate.main.gof.GoodnessOfFitMeasure;
import de.evoal.surrogate.api.training.PredictedValues;

/**
 * Calculates the prediction interval coverage probability
 *   ({@link PredictionIntervalMeasures#picp}) of every output feature on the assessed data set.
 */
@Dependent
@Named(PICPCalculator.NAME)
public class PICPCalculator extends GoodnessOfFitMeasure {
    static final String NAME = "de.evoal.surrogate.ml.picp";

    @Override
    protected String qualifiedName() {
        return NAME;
    }

    @Override
    protected OptionalDouble measure(final PredictedValues values) {
        return values.bounds()
                     .map(bounds -> PredictionIntervalMeasures.picp(values.actual(), bounds.lower(), bounds.upper()))
                     .orElse(OptionalDouble.empty());
    }

    @Override
    protected String whyUndefined() {
        return "the surrogate predicts no interval, or the data set is empty";
    }

    @Override
    public String toString() {
        return "picp";
    }
}
