package de.evoal.surrogate.simple.quadratic;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Slf4j
@Named("de.evoal.surrogate.simple.ml.simple-quadratic-regression-reader-pson")
@Dependent
public class SimpleQuadraticFunctionPSONReader extends AbstractPSONReader {
	@Override
	public ModelFunction load() {
		storage.load();
		final SurrogateConfiguration configuration = storage.getConfiguration()
														    .get();

		return new SimpleQuadraticFunction(getInput(), getOutput(), getSlope(configuration), getIntercept(configuration));
	}

	private static double getIntercept(final SurrogateConfiguration configuration) {
		return (double) configuration.getState()
				.stream()
				.filter(p -> SimpleQuadraticFunctionPSONWriter.INTERCEPT_PARAMETER_NAME.equals(p.getName()))
				.findFirst()
				.get()
				.getValue();
	}

	private static  double getSlope(final SurrogateConfiguration configuration) {
		return (double) configuration.getState()
				.stream()
				.filter(p -> SimpleQuadraticFunctionPSONWriter.SLOPE_PARAMETER_NAME.equals(p.getName()))
				.findFirst()
				.get()
				.getValue();
	}

}
