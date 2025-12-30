package de.evoal.surrogate.adaption.interval.ea.fitness;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import org.apache.commons.math3.util.Pair;

import jakarta.inject.Inject;
import java.util.List;

public abstract class AbstractFitnessAdjustedPredicted extends OptimisationFunctionDecorator {
	private PredictiveErrorData[] errorData;

	@Inject
	private EAnnotationHelper helper;

	@Override
	public OptimisationFunction init(final Instance config) {
        super.init(config);
/*
		final List<PartialSurrogateFunction> regressions = surrogate.getFunctions();
		errorData = new PredictiveErrorData[regressions.size()];

		for(int i = 0; i < regressions.size(); ++i) {
			errorData[i] = new PredictiveErrorData(regressions.get(i).getConfiguration());
		}
*/
		return this;
	}

	@Override
	public double [] evaluate(final Properties candidate) {
        throw new RuntimeException();
        /*
		final double [] current = decoratedFunction.evaluate(candidate);
		final int currentSize = current.length;

		final double[] fitness = new double[currentSize];

		for (int i = 0; i < currentSize; i++) {
			final PredictiveErrorData data = errorData[i];
			final Pair<Double, Double> boundaries = data.calculateBoundaries(candidate, i, surrogate, 0.95, helper);

			fitness[i] = (2 * Math.pow(current[i], 2.0)) / (boundaries.getSecond() - boundaries.getFirst());
		}

		return fitness;

         */
    }
}
