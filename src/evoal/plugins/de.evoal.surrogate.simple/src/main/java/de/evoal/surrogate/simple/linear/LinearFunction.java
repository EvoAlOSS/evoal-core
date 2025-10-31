package de.evoal.surrogate.simple.linear;

import java.util.function.BiConsumer;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.function.ModelFunction;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

@Slf4j
public class LinearFunction extends ModelFunction {

	/**
	 * Actual function for prediction.
	 */
	private final BiConsumer<TypedEObject, TypedEObject> regression;

	@Getter
	private final double intercept;

	@Getter
	private final double slope;

	public LinearFunction(final Space inputFeatures, final Space outputFeatures, final double slope, final double intercept) {
		super("de.evoal.surrogate.simple.ml.linear-regression", inputFeatures, outputFeatures);
		
		Requirements.requireSize(input, 1);
		Requirements.requireSize(output, 1);

		final EStructuralFeature iFeature = input.iterator().next();
		final EStructuralFeature oFeature = output.iterator().next();

		this.slope = slope;
		this.intercept = intercept;

		log.info("Using linear regression f(x) = {} * x + {}.", slope, intercept);

		this.regression = (in, out) -> out.eSet(oFeature, intercept + slope * in.eGetAsDouble(iFeature));
	}

	@Override
	public void apply(final TypedEObject input, final TypedEObject output) {
		regression.accept(input, output);
	}
}
