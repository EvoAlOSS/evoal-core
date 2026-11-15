package de.evoal.surrogate.adaption.interval.ea.fitness;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.surrogate.adaption.SurrogateLookup;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Adapts the fitness of the decorated SVR-based surrogate by the width of the prediction
 *   interval: {@code 2 * value² / (upper - lower)}. The prediction error data has to be
 *   calculated during training (see the goodness-of-fit calculator {@code predictive-error}).
 */
@Slf4j
public abstract class AbstractFitnessAdjustedPredicted extends OptimisationFunctionDecorator {
	/**
	 * Confidence of the prediction interval.
	 */
	private static final double CONFIDENCE = 0.95;

	/**
	 * The surrogate function the error data belongs to.
	 */
	private KernelBasedSVRFunction surrogate;

	/**
	 * The prediction error data of the surrogate's (first) output feature.
	 */
	private PredictiveErrorData errorData;

	/**
	 * The output feature the error data belongs to.
	 */
	private EStructuralFeature errorFeature;

	@Inject
	private EAnnotationHelper annotations;

	@Inject @Named("optimisation-space")
	private Space optimisationSpace;

	@Override
	public OptimisationFunction init(final EObject config) {
		log.info("Setting up interval-based fitness adjustment.");
		super.init(config);

		final ModelFunction function = SurrogateLookup.find(decoratedFunction).function();
		if(!(function instanceof KernelBasedSVRFunction svrFunction)) {
			throw new IllegalStateException("The interval-based fitness adjustment requires an SVR surrogate, but the surrogate is '" + function.getClass().getName() + "'.");
		}

		surrogate = svrFunction;
		// the predictive error calculator only stores data for the first output feature
		errorFeature = surrogate.getOutput().getFirst();
		errorData = new PredictiveErrorData(SurrogateLookup.findReader(decoratedFunction));

		return this;
	}

	@Override
	public TypedEObject evaluate(final TypedEObject candidate) {
		final TypedEObject current = decoratedFunction.evaluate(candidate);
		final TypedEObject fitness = optimisationSpace.newEObject();

		for(final EStructuralFeature feature : optimisationSpace) {
			if(!feature.equals(errorFeature)) {
				// no error data, so there is nothing to adapt
				fitness.eSet(feature, current.eGet(feature));
				continue;
			}

			final double value = current.eGetAsDouble(feature);
			final Pair<Double, Double> boundaries = errorData.calculateBoundaries(candidate, 0, surrogate, CONFIDENCE, annotations);

			fitness.eSet(feature, (2 * Math.pow(value, 2.0)) / (boundaries.getSecond() - boundaries.getFirst()));
		}

		return fitness;
	}
}
