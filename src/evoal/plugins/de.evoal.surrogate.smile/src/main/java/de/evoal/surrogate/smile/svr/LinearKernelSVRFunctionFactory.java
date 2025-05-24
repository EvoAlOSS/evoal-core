package de.evoal.surrogate.smile.svr;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import smile.regression.KernelMachine;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

@Dependent
@Named("linear-svr")
@Slf4j
public class LinearKernelSVRFunctionFactory extends KernelBasedSVRFunctionFactory {
	public LinearKernelSVRFunctionFactory() {
		super(KernelHelper::toLinearKernel, "linear");
	}

	@Override
	protected PartialSurrogateFunction restoreRegression(final PartialFunctionConfiguration configuration, final Space input, final Space output) {
		final KernelMachine<double []> regression = KernelHelper.fromParameters(configuration.getParameters(), configuration.getState());

		final double margin = configuration.getParameters()
				.stream()
				.filter(p -> KernelHelper.SOFT_MARGIN_PARAMETER.equals(p.getName()))
				.map(Parameter::getValue)
				.map(Double.class::cast)
				.findFirst()
				.orElse(0.1);

		final double[] sourceMeans = (double [])configuration.getState()
				.stream()
				.filter(p -> "kernel-source-means".equals(p.getName()))
				.map(Parameter::getValue)
				.findFirst()
				.get();
		final double[] sourceSDs = (double [])configuration.getState()
				.stream()
				.filter(p -> "kernel-source-sds".equals(p.getName()))
				.map(Parameter::getValue)
				.findFirst()
				.get();
		final double[] targetMeans = (double [])configuration.getState()
				.stream()
				.filter(p -> "kernel-target-means".equals(p.getName()))
				.map(Parameter::getValue)
				.findFirst()
				.get();
		final double[] targetSDs = (double [])configuration.getState()
				.stream()
				.filter(p -> "kernel-target-sds".equals(p.getName()))
				.map(Parameter::getValue)
				.findFirst()
				.get();

		return new KernelBasedSVRFunction(configuration, regression, "linear", input, output, margin, sourceMeans, sourceSDs, targetMeans, targetSDs);
	}
}
