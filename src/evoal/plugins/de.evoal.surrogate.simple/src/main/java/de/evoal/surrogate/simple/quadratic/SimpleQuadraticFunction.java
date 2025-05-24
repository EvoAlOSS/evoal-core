package de.evoal.surrogate.simple.quadratic;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;

@Slf4j
public class SimpleQuadraticFunction extends AbstractPartialSurrogateFunction {
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
	private final BiConsumer<TypedEObject, TypedEObject> regression;

	public SimpleQuadraticFunction(final PartialFunctionConfiguration configuration, final List<Parameter> functionParameters, final Space input, final Space output) {
		super(configuration, functionParameters, input, output);
		
		final double slope = getSlope();
		final double intercept = getIntercept();

		log.info("Using quadratic regression f(x) = {} * x^2 + {}.", slope, intercept);

		Requirements.requireSize(input, 1);
		Requirements.requireSize(output, 1);
		final EStructuralFeature iFeature = input.iterator().next();
		final EStructuralFeature oFeature = output.iterator().next();

		this.regression = (in, out) -> out.eSet(oFeature, intercept + slope * Math.pow(in.eGetAsDouble(iFeature), 2.0));
	}

	@Override
	public void apply(final TypedEObject input, final TypedEObject output) {
		regression.accept(input, output);
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
