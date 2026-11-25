package de.evoal.surrogate.main.gof.interval;

import java.util.OptionalDouble;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.surrogate.main.gof.GoodnessOfFitMeasure;
import de.evoal.surrogate.api.training.PredictedValues;

/**
 * Calculates the mean prediction interval width ({@link PredictionIntervalMeasures#mpiw}) of
 *   every output feature on the assessed data set.
 */
@Dependent
@Named(MPIWCalculator.NAME)
public class MPIWCalculator extends GoodnessOfFitMeasure {
    static final String NAME = "de.evoal.surrogate.ml.mpiw";

    @Override
    protected String qualifiedName() {
        return NAME;
    }

    @Override
    protected OptionalDouble measure(final PredictedValues values) {
        return values.bounds()
                     .map(bounds -> PredictionIntervalMeasures.mpiw(bounds.lower(), bounds.upper()))
                     .orElse(OptionalDouble.empty());
    }

    @Override
    protected String whyUndefined() {
        return "the surrogate predicts no interval, or the data set is empty";
    }

    @Override
    public String toString() {
        return "mpiw";
    }
}
