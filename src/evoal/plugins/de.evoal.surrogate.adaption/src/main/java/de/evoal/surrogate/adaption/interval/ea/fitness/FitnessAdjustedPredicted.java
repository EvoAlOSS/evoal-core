package de.evoal.surrogate.adaption.interval.ea.fitness;

import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import org.apache.commons.math3.util.Pair;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("de.evoal.surrogate.adaption.interval.optimisation.adjusted-predicted-fitness")
@Dependent
public class FitnessAdjustedPredicted extends OptimisationFunctionDecorator {
	private PredictiveErrorData[] errorData;

	@Inject
	private SurrogateFunction surrogate;

	@Override
	public OptimisationFunction init(final Instance config) {
        super.init(config);
		
		final List<FunctionCombiner> mappings = surrogate.getMappings();
		final FunctionCombiner mapping = mappings.get(mappings.size() - 1);

		final PartialSurrogateFunction[] regressions = mapping.getFunctions();
		errorData = new PredictiveErrorData[regressions.length];

		for(int i = 0; i < regressions.length; ++i) {
			errorData[i] = new PredictiveErrorData(regressions[i].getConfiguration());
		}

		return this;
	}

	@Override
	public double [] evaluate(final Properties candidate) {
		final double [] current = decoratedFunction.evaluate(candidate);
		final int currentSize = current.length;

		final double[] fitness = new double[currentSize];

		for (int i = 0; i < currentSize; i++) {
			final PredictiveErrorData data = errorData[i];
			final Pair<Double, Double> boundaries = data.calculateBoundaries(candidate, i, surrogate, 0.95);

			fitness[i] = (2 * Math.pow(current[i], 2.0)) / (boundaries.getSecond() - boundaries.getFirst());
		}

		return fitness;
    }
}
