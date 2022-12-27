package de.evoal.surrogate.main.gof.rsquare;

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
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.util.Pair;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

/**
 * Calculates cross validation values.
 */
@Dependent
@Named("R²")
@Slf4j
public class RSquareCalculator implements SurrogateInformationCalculator {

	/**
	 * Surrogate configuration for attaching the calculated r² value.
	 */
	private SurrogateConfiguration config;

	/**
	 * The actual surrogate function.
	 */
	private SurrogateFunction function;

	/**
	 * Supplier for the trainings data.
	 */
	private PropertiesStreamSupplier trainingData;

	@Override
	public void execute() {
		log.info("calculating r² of surrogate function.");

		final PropertiesPairStreamSupplier pairStream = new PropertiesBasedPropertiesPairStreamSupplier(trainingData, function.getInputSpecification(), function.getOutputSpecification());

		final double [][] yValues = pairStream.get()
											  .map(Pair::getSecond)
				   							  .map(Properties::getValuesAsDouble)
											  .toArray(size -> new double[size][]);

		final double [] means = new double [yValues[0].length];
		for(int i = 0; i < means.length; ++i) {
			final int j = i;
			means[i] = new Mean().evaluate(Arrays.stream(yValues)
							 					 .mapToDouble(a -> a[j])
							 					 .toArray());
		}

		final double [] sds = new double [yValues[0].length];
		for(int i = 0; i < sds.length; ++i) {
			final int j = i;
			sds[i] = new StandardDeviation().evaluate(Arrays.stream(yValues)
															  .mapToDouble(a -> a[j])
															  .toArray());
		}

		final double [][] errors =
				pairStream.get()
						.map(pair -> {
							final Properties input = pair.getFirst();
							final Properties calculated = function.apply(input);

							double [] values = calculated.getValuesAsDouble();

							for(int i = 0; i < values.length; ++i) {
								values[i] = Math.pow(pair.getSecond().getAsDouble(i) - values[i], 2);
							}

							return values;
						}).toArray(size -> new double [size][]);

		for(int y = 0; y < errors[0].length; ++y) {
			double error = 0.0;

			for(int x = 0; x < errors.length; ++x) {
				error += errors[x][y];
			}

			final double unexplainedVariation = error;
			final double totalVariation = Math.pow(sds[y], 2) * yValues.length;
			final double rSquare = 1 - unexplainedVariation / totalVariation;

			log.info("unexplained variation: '{}', total variation: {}, rSquare: {}", unexplainedVariation, totalVariation, rSquare);

			final Parameter goodnessOfFit = Parameter.builder()
					.name("r²")
					.value(rSquare)
					.build();

			config.addOutputParameter(function.getOutputSpecification().getProperties().get(y).name(), goodnessOfFit);
		}
	}

	@Override
	public String toString() {
		return "r²";
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
