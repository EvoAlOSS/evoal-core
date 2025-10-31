package de.evoal.surrogate.simple.quadratic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.function.ModelFunction;

@Slf4j
public class SimpleQuadraticFunction extends ModelFunction {
	/**
	 * Actual function for prediction.
	 */
	private final BiConsumer<TypedEObject, TypedEObject> regression;

	@Getter
	private final double intercept;

	@Getter
	private final double slope;

	public SimpleQuadraticFunction(final Space inputFeatures, final Space outputFeatures, final double slope, final double intercept) {
		super("de.evoal.surrogate.simple.ml.simple-quadratic-regression", inputFeatures, outputFeatures);
		
		log.info("Using quadratic regression f(x) = {} * x^2 + {}.", slope, intercept);

		Requirements.requireSize(input, 1);
		Requirements.requireSize(output, 1);

		this.intercept = intercept;
		this.slope = slope;

		final EStructuralFeature iFeature = input.iterator().next();
		final EStructuralFeature oFeature = output.iterator().next();

		this.regression = (in, out) -> out.eSet(oFeature, intercept + slope * Math.pow(in.eGetAsDouble(iFeature), 2.0));
	}

	@Override
	public void apply(final TypedEObject input, final TypedEObject output) {
		regression.accept(input, output);
	}
}
