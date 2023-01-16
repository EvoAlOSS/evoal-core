package de.evoal.surrogate.svr;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import smile.regression.KernelMachine;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("pearson-svr")
@Slf4j
public class PearsonKernelSVRFunctionFactory extends KernelBasedSVRFunctionFactory {
	public PearsonKernelSVRFunctionFactory() {
		super(KernelHelper::toPearsonKernel, "pearson");
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final PropertiesSpecification actualInput, final PropertiesSpecification requiredInput, final PropertiesSpecification producedOutput) {
		final KernelMachine<double []> regression = KernelHelper.fromParameters(configuration.getParameters(), configuration.getState());

		final double margin = configuration.getParameters()
										   .stream()
										   .filter(p -> KernelHelper.SOFT_MARGIN_PARAMETER.equals(p.getName()))
										   .map(Parameter::getValue)
										   .map(Double.class::cast)
										   .findFirst()
										   .orElse(0.1);

		return new KernelBasedSVRFunction(configuration, regression, "pearson", requiredInput, actualInput, producedOutput, margin);
	}
}
