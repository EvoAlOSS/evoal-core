package de.evoal.surrogate.simple.linear;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import de.evoal.core.api.properties.Properties;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.regression.SimpleRegression;

@Slf4j
public class LinearFunction extends AbstractPartialSurrogateFunction {
	/**
	 * Name of the intercept parameter.
	 */
	private static final String INTERCEPT_PARAMETER_NAME = "intercept";

	/**
	 * Name of the r square parameter.
	 */
	private static final String R_SQUARE_PARAMETER_NAME = "r²";

	/**
	 * Name of the slope parameter.
	 */
	private static final String SLOPE_PARAMETER_NAME = "slope";

	/**
	 * Turns an Apache simple regression into a parameter set.
	 */
	public static List<Parameter> toParameters(final SimpleRegression regression) {
		final List<Parameter> result = new LinkedList<>();
		
		addParameter(INTERCEPT_PARAMETER_NAME, regression.getIntercept(), result);
		addParameter(SLOPE_PARAMETER_NAME, regression.getSlope(), result);
		addParameter(R_SQUARE_PARAMETER_NAME, regression.getRSquare(), result);

		return result;
	}

	/**
	 * Actual function for prediction.
	 */
	private final Function<Properties, Double> regression;

	public LinearFunction(final PartialFunctionConfiguration configuration, final List<Parameter> functionParameters, final PropertiesSpecification input, final PropertiesSpecification actualInput, final PropertiesSpecification output) {
		super(configuration, functionParameters, input, output);
		
		final double slope = getSlope();
		final double intercept = getIntercept();

		log.info("Using linear regression f(x) = {} * x + {}.", slope, intercept);


		final PropertySpecification inputProperty = input.getProperties().get(0);
		final int propertyIndex = actualInput.indexOf(inputProperty);
		
		this.regression = vector -> intercept + slope * vector.get(propertyIndex);
	}

	public double [] apply(final Properties input) {
		return new double [] {regression.apply(input)};
	}

	private double getIntercept() {
		return (double)getParameters().stream()
				 .filter(p -> INTERCEPT_PARAMETER_NAME.equals(p.getName()))
				 .findFirst()
				 .get()
				 .getValue();
	}

	private double getSlope() {
		return (double)getParameters().stream()
				 .filter(p -> SLOPE_PARAMETER_NAME.equals(p.getName()))
				 .findFirst()
				 .get()
				 .getValue();
	}
}
