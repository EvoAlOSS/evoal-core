package de.evoal.surrogate.svr;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.stream.PropertiesPairStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.AbstractPartialSurrogateFunctionFactory;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smile.math.kernel.MercerKernel;
import smile.regression.KernelMachine;
import smile.regression.SVR;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Dependent
@Named("gaussian-svr")
@Slf4j
public class GaussianKernelSVRFunctionFactory extends KernelBasedSVRFunctionFactory {
	public GaussianKernelSVRFunctionFactory() {
		super(KernelHelper::toGaussianKernel, "gaussian");
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

		return new KernelBasedSVRFunction(configuration, regression, "gaussian", requiredInput, actualInput, producedOutput, margin);
	}
}
