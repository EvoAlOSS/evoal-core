package de.evoal.surrogate.main.gof.rmse;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.*;
import de.evoal.core.api.math.EvoalMath;

/**
 * Calculates the root mean squared error.
 */
@Dependent
@Named("de.evoal.surrogate.ml.rmse")
@Slf4j
public class RMSECalculator extends SurrogateInformationCalculator {
	@Override
	public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
		log.info("calculating rmse of surrogate function.");

		final Space inputSpace = functionData.function().getInput();
		final Space outputSpace = functionData.function().getOutput();

		final EObjectPairStreamSupplier pairStream = helper.loadTrainingDataPaired(context);

		final Map<EStructuralFeature, List<Double>> data = new HashMap<>();
		for(final EStructuralFeature feature : outputSpace) {
			data.put(feature, new ArrayList<>());
		}

		pairStream.get()
				.forEach(p -> {
					final TypedEObject source = p.getFirst();
					final TypedEObject expected = p.getSecond();
					final TypedEObject actual = new TypedEObject(expected.eSpace());

					functionData.function()
							.apply(source, actual);

					for(final EStructuralFeature feature : outputSpace) {
						final double difference = expected.eGetAsDouble(feature) - actual.eGetAsDouble(feature);
						data.get(feature)
							.add(EvoalMath.square(difference));
					}
				});

		for(final Map.Entry<EStructuralFeature, List<Double>> entry : data.entrySet()) {
			final double average = entry
					.getValue()
					.stream()
					.mapToDouble(Double.class::cast)
					.summaryStatistics()
					.getAverage();

			final double rmse = Math.sqrt(average);

			log.info("RMSE of {}: '{}'", entry.getKey().getName(), rmse);

			final Parameter goodnessOfFit = Parameter.builder()
					.name("de.evoal.surrogate.ml.rmse")
					.value(rmse)
					.build();

			functionData.writer()
					.get()
					.addOutputFeatureInformation(entry.getKey(), goodnessOfFit);
		}

		return Optional.empty();
	}

	@Override
	public String toString() {
		return "rmse";
	}
}
