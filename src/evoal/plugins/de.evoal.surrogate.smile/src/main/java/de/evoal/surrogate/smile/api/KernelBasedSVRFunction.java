package de.evoal.surrogate.smile.api;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.BaseDataDescription;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunction;

import de.evoal.core.api.utils.ConverterFunctions;
import de.evoal.surrogate.smile.svr.KernelHelper;
import smile.regression.KernelMachine;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class KernelBasedSVRFunction extends AbstractPartialSurrogateFunction {

	/**
	 *
	 */
	private final double gamma;

	/**
	 * Indices of input data
	 */
	private final int[] indices;

	private final Function<Properties, Double> [] inputConverters;

	private final Function<Double, Object> outputConverter;

	/**
	 * Actual SVR
	 */
	private final KernelMachine<double []> regression;
	private final double[] sourceMeans;
	private final double[] sourceSDs;
	private final double[] targetMeans;
	private final double[] targetSDs;

	public KernelBasedSVRFunction(final PartialFunctionConfiguration configuration, final KernelMachine<double []> regression, final String kernelName, final PropertiesSpecification input, final PropertiesSpecification actualInput, final PropertiesSpecification output, final double gamma, final double[] sourceMeans, final double[] sourceSDs, final double[] targetMeans, final double[] targetSDs) {
		super(configuration, KernelHelper.toParameters(regression, kernelName), input, output);
		this.sourceMeans = sourceMeans;
		this.sourceSDs = sourceSDs;
		this.targetMeans = targetMeans;
		this.targetSDs = targetSDs;

		final List<Function<Properties, Double>> inputConverts = new LinkedList<>();

		this.indices = input.getProperties()
							.stream()
						    .mapToInt(s -> {
								final int index = actualInput.indexOf(s);
								Requirements.requireInstanceOf(s.type(), BaseDataDescription.class);

								inputConverts.add(ConverterFunctions.convertToDouble(((BaseDataDescription)s.type()).getRepresentation(), index));

								return  index;
							})
							.toArray();

		this.inputConverters = inputConverts.toArray(new Function[0]);

		// Calculate output converter
		final RepresentationType outputType = ((BaseDataDescription)output.getProperties().get(0).type()).getRepresentation();
		outputConverter = ConverterFunctions.convertDoubleTo(outputType);

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
	public Object [] apply(final Properties input) {
		final double [] inputData = new double[indices.length];

		for(int i = 0; i < inputData.length; ++i) {
			inputData[i] = (inputConverters[i].apply(input) - sourceMeans[i]) / sourceSDs[i];
		}

		final double predictedValue = (regression.predict(inputData) * targetSDs[0]) + targetMeans[0];

		final Object [] outputData = new Object[1];
		outputData[0] = outputConverter.apply(predictedValue);

		return outputData;
	}

	public KernelMachine<double []> getRegression() {
		return regression;
	}

	public double getGamma() {
		return gamma;
	}
}
