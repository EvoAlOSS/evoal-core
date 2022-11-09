package de.evoal.surrogate.svr;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
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

	public KernelBasedSVRFunctionFactory(final Function<Map<String, Object>, MercerKernel<double []>> toKernel) {
		this.toKernel = toKernel;
	}

	@Override
	protected PartialSurrogateFunction calculateRegression(final PartialFunctionConfiguration configuration, List<Parameter> parameters, PropertiesSpecification actualInput, PropertiesSpecification requiredInput, PropertiesSpecification producedOutput, PropertiesPairStreamSupplier provider) {
		log.info("Calculate SVR surrogate from {} to {}.", requiredInput, producedOutput);

		Requirements.requireSizeGreaterThean(requiredInput.getProperties(), 0);
		Requirements.requireSize(producedOutput.getProperties(), 1);

		final List<double []> sources = new ArrayList<>();
		final List<Double> targets = new ArrayList<>();

		provider.get()
				.forEach(p -> {
					sources.add(p.getFirst().getValues());
					targets.add(p.getSecond().get(0));
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

		return new KernelBasedSVRFunction(configuration, regression, requiredInput, actualInput, producedOutput, margin);
	}
}
