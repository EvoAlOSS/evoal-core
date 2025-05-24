package de.evoal.surrogate.main.gof.rmse;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamFactory;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.*;

/**
 * Calculates the root mean squared error.
 */
@Dependent
@Named("de.evoal.surrogate.ml.rmse")
@Slf4j
public class RMSECalculator implements SurrogateInformationCalculator {

	/**
	 * Surrogate configuration for attaching the calculated r² value.
	 */
	private SurrogateConfiguration config;

	/**
	 * The actual surrogate function.
	 */
	private SurrogateFunction function;

	/**
	 * Supplier for the training data.
	 */
	private EObjectPairStreamSupplier trainingData;

	@Override
	public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
		log.info("calculating rmse of surrogate function.");

		final EObjectPairStreamSupplier pairStream = EObjectPairStreamFactory.createFromList(function.getInputSpecification(), function.getOutputSpecification(), trainingData);

		final Map<EStructuralFeature, List<Double>> data = new HashMap<>();
		for(final EStructuralFeature feature : function.getOutputSpecification()) {
			data.put(feature, new ArrayList<>());
		}

		pairStream.get()
				.forEach(p -> {
					final TypedEObject source = p.getFirst();
					final TypedEObject expected = p.getSecond();
					final TypedEObject actual = new TypedEObject(expected.eClass());

					function.apply(source, actual);

					for(final EStructuralFeature feature : actual.eClass().getEAllStructuralFeatures()) {
						data.get(feature)
							.add(Math.pow(expected.eGetAsDouble(feature) - actual.eGetAsDouble(feature), 2.0));
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

			log.info("RMSE of {}: '{}'", entry.getKey().getName(), rmse);

			final Parameter goodnessOfFit = Parameter.builder()
					.name("rmse")
					.value(rmse)
					.build();

			config.addOutputParameter(entry.getKey().getName(), goodnessOfFit);
		}

		return Optional.empty();
	}

	@Override
	public String toString() {
		return "rmse";
	}

	@Override
	public void configure(final @NonNull SurrogateFunction function, final @NonNull SurrogateConfiguration config, final @NonNull EObjectPairStreamSupplier trainingData) {
		this.function = function;
		this.config = config;
		this.trainingData = trainingData;
	}
}
