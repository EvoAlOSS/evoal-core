package de.evoal.surrogate.main.gof.rmse;

import de.evoal.surrogate.main.gof.GoodnessOfFitMeasure;
import de.evoal.surrogate.api.training.PredictedValues;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.OptionalDouble;

/**
 * Calculates the root relative squared error ({@link RootRelativeSquaredError}) of every
 *   output feature on the assessed data set.
 */
@Dependent
@Named(RRSECalculator.NAME)
public class RRSECalculator extends GoodnessOfFitMeasure {
	static final String NAME = "de.evoal.surrogate.ml.rrse";

	@Override
	protected String qualifiedName() {
		return NAME;
	}

	@Override
	protected OptionalDouble measure(final PredictedValues values) {
		return RootRelativeSquaredError.of(values.actual(), values.predicted());
	}

	@Override
	protected String whyUndefined() {
		return "all its values are equal";
	}

	@Override
	public String toString() {
		return "rrse";
	}
}
