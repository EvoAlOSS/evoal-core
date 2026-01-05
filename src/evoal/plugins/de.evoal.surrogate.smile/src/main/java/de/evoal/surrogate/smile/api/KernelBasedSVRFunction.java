package de.evoal.surrogate.smile.api;

import lombok.Getter;

import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;

import java.util.Map;

public class KernelBasedSVRFunction extends ModelFunction {

	/**
	 * The SVR's gamma parameter
	 */
	@Getter
	private final double gamma;

	/**
	 * Actual SVR
	 */
	protected final KernelMachine<double []> regression;

	@Getter
	protected final double[] sourceMeans;

	@Getter
	protected final double[] sourceSDs;

	@Getter
	protected final double[] targetMeans;

	@Getter
	protected final double[] targetSDs;

	@Getter
	private final Map<String, Object> parameters;

	public KernelBasedSVRFunction(final Space input, final Space output, final Map<String, Object> parameters, final KernelMachine<double []> regression, final double gamma, final double[] sourceMeans, final double[] sourceSDs, final double[] targetMeans, final double[] targetSDs) {
		super("de.evoal.surrogate.smile.ml.epsilon-svr", input, output);

		this.sourceMeans = sourceMeans;
		this.sourceSDs = sourceSDs;
		this.targetMeans = targetMeans;
		this.targetSDs = targetSDs;
		this.parameters = parameters;

		this.regression = regression;
		this.gamma = gamma;
	}

	@Override
	public void apply(final @NonNull TypedEObject input, final @NonNull TypedEObject output) {
		final double [] inputData = new double[this.input.size()];

		int index = 0;
		for(final EStructuralFeature feature : this.input) {
			inputData[index] = (input.eGetAsDouble(feature) - sourceMeans[index]) / sourceSDs[index];
			index += 1;
		}

		final double predictedValue = (regression.predict(inputData) * targetSDs[0]) + targetMeans[0];
		final EStructuralFeature oFeature = this.output.iterator().next();

		output.eSet(oFeature, predictedValue);
	}

	public KernelMachine<double []> getRegression() {
		return regression;
	}
}
