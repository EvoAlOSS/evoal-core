package de.evoal.surrogate.simple.linear;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;


@Slf4j
@Named("de.evoal.surrogate.simple.ml.linear-regression-reader-pson")
@Dependent
public class LinearFunctionPSONReader extends AbstractPSONReader {
	private static double getIntercept(final SurrogateConfiguration configuration) {
		return (double) configuration.getState()
				.stream()
				.filter(p -> LinearFunctionPSONWriter.INTERCEPT_PARAMETER_NAME.equals(p.getName()))
				.findFirst()
				.get()
				.getValue();
	}

	private static  double getSlope(final SurrogateConfiguration configuration) {
		return (double) configuration.getState()
				.stream()
				.filter(p -> LinearFunctionPSONWriter.SLOPE_PARAMETER_NAME.equals(p.getName()))
				.findFirst()
				.get()
				.getValue();
	}

    @Override
    public ModelFunction load() {
        storage.load();

        final SurrogateConfiguration configuration = storage.getConfiguration()
                .get();

        return new LinearFunction(getInput(), getOutput(), getSlope(configuration), getIntercept(configuration));
    }

}
