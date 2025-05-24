package de.evoal.surrogate.main.gof.rsquare;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.interpreter.api.InterpreterState;
import de.evoal.surrogate.api.SurrogateInformationCalculator;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.SurrogateConfiguration;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Optional;

/**
 * Calculates cross validation values.
 */
@Dependent
@Named("de.evoal.surrogate.ml.R²")
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
	 * Supplier for the training data.
	 */
	private EObjectPairStreamSupplier training;

	@Override
	public Optional<Object> call(final InterpreterState context, final Object[] arguments) {
		final Space inSpace = function.getInputSpecification();
		final Space outSpace = function.getOutputSpecification();

		log.info("calculating r² of surrogate function.");
		final double [][] yValues = training.get()
											.map(Pair::getSecond)
				   							.map(t -> outSpace.stream().mapToDouble(f -> t.eGetAsDouble(f)).toArray())
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
				training.get()
						.map(pair -> {
							final TypedEObject input = pair.getFirst();
							final TypedEObject expected = pair.getSecond();
							final TypedEObject calculated = new TypedEObject(expected.eClass());

							function.apply(input, calculated);

							return expected.eClass()
											.getEAllStructuralFeatures()
											.stream()
											.mapToDouble(f -> Math.pow(expected.eGetAsDouble(f) - calculated.eGetAsDouble(f), 2))
											.toArray();
						}).toArray(size -> new double [size][]);

		int index = 0;
		for(final EStructuralFeature feature : outSpace) {
			double error = 0.0;

			for(int x = 0; x < errors.length; ++x) {
				error += errors[x][index];
			}

			final double unexplainedVariation = error;
			final double totalVariation = Math.pow(sds[index], 2) * yValues.length;
			final double rSquare = 1 - unexplainedVariation / totalVariation;

			log.info("unexplained variation: '{}', total variation: {}, rSquare: {}", unexplainedVariation, totalVariation, rSquare);

			final Parameter goodnessOfFit = Parameter.builder()
					.name("r²")
					.value(rSquare)
					.build();

			config.addOutputParameter(feature.getName(), goodnessOfFit);

			index += 1;
		}

		return Optional.empty();
	}

	@Override
	public String toString() {
		return "r²";
	}

	@Override
	public void configure(final @NonNull SurrogateFunction function, final @NonNull SurrogateConfiguration config, final @NonNull EObjectPairStreamSupplier training) {
		Requirements.requireNotNull(function);
		Requirements.requireNotNull(config);

		this.function = function;
		this.config = config;
		this.training = training;
	}
}
