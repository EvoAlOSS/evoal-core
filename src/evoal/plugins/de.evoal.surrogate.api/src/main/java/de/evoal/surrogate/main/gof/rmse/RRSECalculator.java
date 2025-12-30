package de.evoal.surrogate.main.gof.rmse;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.*;

/**
 * Calculates the root mean squared error.
 */
@Dependent
@Named("de.evoal.surrogate.ml.rrse")
@Slf4j
public class RRSECalculator extends SurrogateInformationCalculator {
	@Override
	public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
		log.info("calculating rrse of surrogate function.");

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
					final TypedEObject actual = new TypedEObject(expected.eClass());

					functionData.function()
							.apply(source, actual);

					for(final EStructuralFeature feature : actual.eClass().getEAllStructuralFeatures()) {
						data.get(feature)
								.add(Math.pow(expected.eGetAsDouble(feature) - actual.eGetAsDouble(feature) / expected.eGetAsDouble(feature), 2.0));
					}
				});


		for(final Map.Entry<EStructuralFeature, List<Double>> entry : data.entrySet()) {
			final double average = entry
					.getValue()
					.stream()
					.mapToDouble(Double.class::cast)
					.summaryStatistics()
					.getAverage();

			final double rmse = Math.pow(average, 0.5);

			log.info("RRSE of {}: '{}'", entry.getKey().getName(), rmse);

			final Parameter goodnessOfFit = Parameter.builder()
					.name("de.evoal.surrogate.ml.rrse")
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
		return "rrse";
	}
}
