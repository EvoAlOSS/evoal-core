package de.evoal.surrogate.main.gof.rsquare;

import de.evoal.surrogate.main.gof.GoodnessOfFitMeasure;
import de.evoal.surrogate.api.training.PredictedValues;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.OptionalDouble;

/**
 * Calculates the coefficient of determination R² ({@link CoefficientOfDetermination}) of
 *   every output feature on the assessed data set.
 */
@Dependent
@Named(RSquareCalculator.NAME)
public class RSquareCalculator extends GoodnessOfFitMeasure {
	static final String NAME = "de.evoal.surrogate.ml.R²";

	@Override
	protected String qualifiedName() {
		return NAME;
	}

	@Override
	protected OptionalDouble measure(final PredictedValues values) {
		return CoefficientOfDetermination.of(values.actual(), values.predicted());
	}

	@Override
	protected String whyUndefined() {
		return "all its values are equal";
	}

	@Override
	public String toString() {
		return "R²";
	}
}
