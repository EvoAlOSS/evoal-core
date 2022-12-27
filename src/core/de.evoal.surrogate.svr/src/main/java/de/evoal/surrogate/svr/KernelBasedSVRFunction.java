package de.evoal.surrogate.svr;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;

import smile.regression.KernelMachine;

public class KernelBasedSVRFunction extends AbstractPartialSurrogateFunction {

	/**
	 * Indices of input data
	 */
	private final int[] indices;

	/**
	 * Actual SVR
	 */
	private final KernelMachine<double []> regression;

	private final double gamma;

	public KernelBasedSVRFunction(final PartialFunctionConfiguration configuration, final KernelMachine<double []> regression, final String kernelName, final PropertiesSpecification input, final PropertiesSpecification actualInput, final PropertiesSpecification output, final double gamma) {
		super(configuration, KernelHelper.toParameters(regression, kernelName), input, output);
		
		this.indices = input.getProperties().stream().mapToInt(p -> actualInput.indexOf(p)).toArray();

		this.regression = regression;
		this.gamma = gamma;
	}

	@Override
	public double [] apply(final Properties input) {
		final double [] data = new double[indices.length];

		for(int i = 0; i < data.length; ++i) {
			data[i] = input.getAsDouble(indices[i]);
		}

		return new double [] {regression.predict(data)};
	}

	public KernelMachine<double []> getRegression() {
		return regression;
	}

	public double getGamma() {
		return gamma;
	}
}
