package de.evoal.surrogate.main.gof.rsquare;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.SurrogateInformationCalculator;
import de.evoal.surrogate.main.gof.PredictedValues;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Calculates the coefficient of determination R² ({@link CoefficientOfDetermination}) of
 *   every output feature on the training data.
 */
@Dependent
@Named("de.evoal.surrogate.ml.R²")
@Slf4j
public class RSquareCalculator extends SurrogateInformationCalculator {

	@Override
	public Optional<Object> calculate(final InterpreterState context, final Object[] arguments) {
		log.info("calculating r² of surrogate function.");

		final Map<EStructuralFeature, PredictedValues> values = PredictedValues.collect(functionData, helper.loadTrainingDataPaired(context));

		for(final Map.Entry<EStructuralFeature, PredictedValues> entry : values.entrySet()) {
			final String name = entry.getKey().getName();
			final OptionalDouble rSquare = CoefficientOfDetermination.of(entry.getValue().actual(), entry.getValue().predicted());

			if(rSquare.isEmpty()) {
				log.warn("R² of {} is undefined: all values of the training data are equal.", name);
				continue;
			}

			log.info("R² of {}: '{}'", name, rSquare.getAsDouble());

			final Parameter goodnessOfFit = Parameter.builder()
					.name("r²")
					.value(rSquare.getAsDouble())
					.build();

			functionData.writer()
					.get()
					.addOutputFeatureInformation(entry.getKey(), goodnessOfFit);
		}

		return Optional.empty();
	}

	@Override
	public String toString() {
		return "r²";
	}
}
