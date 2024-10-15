package de.evoal.surrogate.main.gof.rmse;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.stream.PropertiesBasedPropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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
	private PropertiesStreamSupplier trainingData;

	@Override
	public void execute() {
		log.info("calculating rmse of surrogate function.");

		final PropertiesPairStreamSupplier pairStream = new PropertiesBasedPropertiesPairStreamSupplier(trainingData, function.getInputSpecification(), function.getOutputSpecification());

		final List<List<Double>> data = new ArrayList<>();
		for(int i = 0; i  < function.getOutputSpecification().size(); ++i) {
			data.add(new ArrayList<>());
		}

		pairStream.get()
				.forEach(p -> {
					final Properties source = p.getFirst();
					final Properties expected = p.getSecond();

					final Properties actual = function.apply(source);

					for(int i = 0; i < expected.size(); ++i) {
						data.get(i).add(Math.pow(expected.getAsDouble(i) - actual.getAsDouble(i), 2.0));
					}
				});

		for(int i = 0; i < data.size(); ++i) {
			final double average = data.get(i)
					.stream()
					.mapToDouble(Double.class::cast)
					.summaryStatistics()
					.getAverage();

			final double rmse = Math.pow(average, 0.5);

			log.info("RMSE of {}: '{}'", function.getOutputSpecification().get(i), rmse);

			final Parameter goodnessOfFit = Parameter.builder()
					.name("rmse")
					.value(rmse)
					.build();

			config.addOutputParameter(function.getOutputSpecification().get(i).name(), goodnessOfFit);
		}
	}

	@Override
	public String toString() {
		return "rmse";
	}

	@Override
	public void configure(final SurrogateFunction function, final SurrogateConfiguration config, final List<Object> parameters, final PropertiesStreamSupplier trainingData) {
		Requirements.requireEmpty(parameters);
		Requirements.requireNotNull(function);
		Requirements.requireNotNull(config);

		this.function = function;
		this.config = config;
		this.trainingData = trainingData;
	}
}
