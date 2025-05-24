package de.evoal.surrogate.smile.api;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;
import de.evoal.surrogate.smile.svr.KernelHelper;

public class KernelBasedSVRFunction extends AbstractPartialSurrogateFunction {

	/**
	 * The SVR's gamma parameter
	 */
	private final double gamma;

	/**
	 * Actual SVR
	 */
	private final KernelMachine<double []> regression;
	private final double[] sourceMeans;
	private final double[] sourceSDs;
	private final double[] targetMeans;
	private final double[] targetSDs;

	public KernelBasedSVRFunction(final PartialFunctionConfiguration configuration, final KernelMachine<double []> regression, final String kernelName, final Space input, final Space output, final double gamma, final double[] sourceMeans, final double[] sourceSDs, final double[] targetMeans, final double[] targetSDs) {
		super(configuration, KernelHelper.toParameters(regression, kernelName), input, output);

		this.sourceMeans = sourceMeans;
		this.sourceSDs = sourceSDs;
		this.targetMeans = targetMeans;
		this.targetSDs = targetSDs;

		this.regression = regression;
		this.gamma = gamma;

		final List<Parameter> parameters = new LinkedList<>();
		addParameter("kernel-source-means", sourceMeans, parameters);
		addParameter("kernel-source-sds", sourceSDs, parameters);
		addParameter("kernel-target-means", targetMeans, parameters);
		addParameter("kernel-target-sds", targetSDs, parameters);

		getParameters().addAll(parameters);
	}

	@Override
	public void apply(final TypedEObject input, final TypedEObject output) {
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

	public double getGamma() {
		return gamma;
	}
}
