package de.evoal.surrogate.smile.svr;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import smile.math.kernel.MercerKernel;
import smile.regression.KernelMachine;
import smile.regression.SVR;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public abstract class KernelBasedSVRFunctionFactory extends AbstractPartialSurrogateFunctionFactory {
	/**
	 * Function to create the SVR kernel.
	 */
	private final Function<Map<String, Object>, MercerKernel<double[]>> toKernel;

	private final String nameOfKernel;

	public KernelBasedSVRFunctionFactory(final Function<Map<String, Object>, MercerKernel<double []>> toKernel, final String nameOfKernel) {
		this.toKernel = toKernel;
		this.nameOfKernel = nameOfKernel;
	}

	@Override
	protected PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, final List<Parameter> parameters, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput, final PropertiesPairStreamSupplier provider) {
		log.info("Calculate SVR surrogate from {} to {}.", requiredInput, producedOutput);

		Requirements.requireSizeGreaterThan(requiredInput.getProperties(), 0);
		Requirements.requireSize(producedOutput.getProperties(), 1);

		// do sanity checks and log information for the user
		final Function<Properties, double []> sourceConverter = createConverter(requiredInput);
		final Function<Properties, double []> targetConverter = createConverter(producedOutput);

		final List<double []> sources = new ArrayList<>();
		final List<Double> targets = new ArrayList<>();

		provider.get()
				.forEach(p -> {
					sources.add(sourceConverter.apply(p.getFirst()));
					targets.add(targetConverter.apply(p.getSecond())[0]);
				});

		log.info("Using {} points for regression.", sources.size());

		double [][] sourceArray = sources.toArray(new double [][] {});
		double [] targetArray = targets.stream().mapToDouble(Double.class::cast).toArray();

		double [] sourceMeans = new double [requiredInput.size()];
		double [] sourceSD = new double [requiredInput.size()];

		double [] targetMean = new double [1];
		double [] targetSD = new double [1];

		for(int propertyIndex = 0; propertyIndex < requiredInput.size(); ++propertyIndex) {
			double [] values = new double [sourceArray.length];
			for(int individualIndex = 0; individualIndex < sourceArray.length; ++individualIndex) {
				values[individualIndex] = sourceArray[individualIndex][propertyIndex];
			}

			calculateStatisticalInformation(values, propertyIndex, sourceMeans, sourceSD);
		}
		calculateStatisticalInformation(targetArray, 0, targetMean, targetSD);


		// start scaling of trainings data
		for(int individualIndex = 0; individualIndex < sourceArray.length; ++individualIndex) {
			for (int propertyIndex = 0; propertyIndex < requiredInput.size(); ++propertyIndex) {
				sourceArray[individualIndex][propertyIndex] = (sourceArray[individualIndex][propertyIndex] - sourceMeans[propertyIndex]) / sourceSD[propertyIndex];

			}
			targetArray[individualIndex] = (targetArray[individualIndex] - targetMean[0]) / targetSD[0];
		}


		final Map<String, Object> params = parameters.stream()
													 .collect(Collectors.toMap(Parameter::getName, Parameter::getValue));

		final double epsilon = ((Number)params.get(KernelHelper.EPSILON_PARAMETER)).doubleValue();
		final double margin = ((Number)params.get(KernelHelper.SOFT_MARGIN_PARAMETER)).doubleValue();
		final double tolerance = ((Number)params.get(KernelHelper.TOLERANCE_PARAMETER)).doubleValue();

		final KernelMachine<double []> regression = SVR.fit(sourceArray, targetArray, toKernel.apply(params), epsilon, margin, tolerance);

		return new KernelBasedSVRFunction(configuration, regression, nameOfKernel, requiredInput, actualInput, producedOutput, margin, sourceMeans, sourceSD, targetMean, targetSD);
	}

	private void calculateStatisticalInformation(final double[] values, final int index, final double[] means, final double[] sds) {
		means[index] = new Mean().evaluate(values, 0, values.length);
		sds[index] = new StandardDeviation().evaluate(values);
	}

	/**
	 * Creates a data converter function based on the given properties specification.
	 */
	private Function<Properties, double[]> createConverter(final PropertiesSpecification specification) {
		final Function<Properties, Double>[] converters = new Function[specification.size()];

		for(int i = 0; i < converters.length; ++i) {
			final PropertySpecification spec = specification.getProperties().get(i);
			Requirements.requireInstanceOf(spec.type(), DataDescription.class);
			final RepresentationType type = ((DataDescription)spec.type()).getRepresentation();

			final int index = i;
			if(RepresentationType.REAL.equals(type)) {
				converters[i] = p -> p.getAsDouble(spec);
			} else {
				log.warn("Property {} is of type {}. SVR only supports real values. Trying to add an automatic conversion.", spec, type);
				converters[i] = p -> ((Number)p.get(spec)).doubleValue();
			}
		}

		return p -> {
			double [] values = new double [converters.length];
			for(int i = 0; i < values.length; ++i) {
				values[i] = converters[i].apply(p);
			}

			return values;
		};
	}
}
