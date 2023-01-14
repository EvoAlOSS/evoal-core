package de.evoal.surrogate.svr;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import smile.math.kernel.MercerKernel;
import smile.regression.KernelMachine;
import smile.regression.SVR;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

		final Map<String, Object> params = parameters.stream()
													 .collect(Collectors.toMap(Parameter::getName, Parameter::getValue));

		final double epsilon = (double)params.get(KernelHelper.EPSILON_PARAMETER);
		final double margin = (double)params.get(KernelHelper.SOFT_MARGIN_PARAMETER);
		final double tolerance = (double)params.get(KernelHelper.TOLERANCE_PARAMETER);

		final KernelMachine<double []> regression = SVR.fit(sourceArray, targetArray, toKernel.apply(params), epsilon, margin, tolerance);

		return new KernelBasedSVRFunction(configuration, regression, nameOfKernel, requiredInput, actualInput, producedOutput, margin);
	}

	/**
	 * Creates a data converter function based on the given properties specification.
	 */
	private Function<Properties, double[]> createConverter(final PropertiesSpecification specification) {
		final Function<Properties, Double>[] converters = new Function[specification.size()];

		for(int i = 0; i < converters.length; ++i) {
			final PropertySpecification spec = specification.getProperties().get(i);
			final RepresentationType type = spec.type().getRepresentation();

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
