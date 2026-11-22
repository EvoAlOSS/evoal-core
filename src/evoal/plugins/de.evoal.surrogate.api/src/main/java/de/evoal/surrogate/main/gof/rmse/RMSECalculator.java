package de.evoal.surrogate.main.gof.rmse;

import de.evoal.surrogate.main.gof.GoodnessOfFitMeasure;
import de.evoal.surrogate.main.gof.PredictedValues;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.OptionalDouble;

/**
 * Calculates the root mean squared error ({@link RootMeanSquaredError}) of every output
 *   feature on the assessed data set.
 */
@Dependent
@Named(RMSECalculator.NAME)
public class RMSECalculator extends GoodnessOfFitMeasure {
	static final String NAME = "de.evoal.surrogate.ml.rmse";

	@Override
	protected String qualifiedName() {
		return NAME;
	}

	@Override
	protected OptionalDouble measure(final PredictedValues values) {
		return RootMeanSquaredError.of(values.actual(), values.predicted());
	}

	@Override
	protected String whyUndefined() {
		return "the data set is empty";
	}

	@Override
	public String toString() {
		return "rmse";
	}
}
