package de.evoal.surrogate.main.gof.rsquare;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.Arrays;
import java.util.Optional;

/**
 * Calculates cross validation values.
 */
@Dependent
@Named("de.evoal.surrogate.ml.R²")
@Slf4j
public class RSquareCalculator extends SurrogateInformationCalculator {

	@Override
	public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
		log.info("{}", context);

		final EObjectPairStreamSupplier trainingSupplier = helper.loadTrainingDataPaired(context);

		final Space inSpace = functionData.function().getInput();
		final Space outSpace = functionData.function().getOutput();

		log.info("calculating r² of surrogate function.");
		final double [][] yValues = trainingSupplier
											.get()
											.map(Pair::getSecond)
				   							.map(t -> outSpace.stream().mapToDouble(t::eGetAsDouble).toArray())
											.toArray(double[][]::new);

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
				trainingSupplier
						.get()
						.map(pair -> {
							final TypedEObject input = pair.getFirst();
							final TypedEObject expected = pair.getSecond();
							final TypedEObject calculated = new TypedEObject(expected.eClass());

							functionData.function()
										.apply(input, calculated);

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

			functionData.writer()
					.get()
					.addOutputFeatureInformation(feature, goodnessOfFit);

			index += 1;
		}

		return Optional.empty();
	}

	@Override
	public String toString() {
		return "r²";
	}
}
