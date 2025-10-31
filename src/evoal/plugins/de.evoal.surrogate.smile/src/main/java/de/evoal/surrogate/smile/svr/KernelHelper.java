package de.evoal.surrogate.smile.svr;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.evoal.surrogate.api.io.pson.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import smile.math.kernel.*;
import smile.regression.KernelMachine;
import smile.regression.Regression;

public final class KernelHelper {
	private static final String DEGREE_PARAMETER = "degree";

	public static final String EPSILON_PARAMETER = "ε";

	private static final String SCALE_PARAMETER = "scale";

	private static final String OFFSET_PARAMETER = "offset";

	public static final String SIGMA_PARAMETER = "σ";

	public static final String SOFT_MARGIN_PARAMETER = "soft-margin";

	public static final String TOLERANCE_PARAMETER = "tolerance";

	public static final String KERNEL_PARAMETER = "kernel";

	/**
	 * Logger instance
	 */
	private final static Logger log = LoggerFactory.getLogger(KernelHelper.class);

	private KernelHelper() {
	}

	private static void addParameter(final String name, final Object value, final List<Parameter> parameters) {
		final Parameter parameter = Parameter.builder()
				.name(name)
				.value(value)
				.build();

		parameters.add(parameter);
	}
	
	public static Map<String, Object> toMap(final List<Parameter> parameters) {
		return parameters.stream()
						 .collect(Collectors.toMap(Parameter::getName, Parameter::getValue));
	}

	public static KernelMachine<double []> fromParameters(final List<Parameter> parameters) {
		final Map<String, Object> parameterMap = toMap(parameters);

		final MercerKernel<double []> kernel = toKernel(toMap(parameters), parameterMap);
		final double[][] instances =(double[][]) parameterMap.get("instances");
		final double[] weight = (double[]) parameterMap.get("weights");
		final double b = (double)parameterMap.get("intercept");
		
		return new KernelMachine<>(kernel, instances, weight, b);
	}

	public static MercerKernel<double []> toGaussianKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'gaussian'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new GaussianKernel(sigma);
	}

	public static MercerKernel<double []> toHellingerKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'hellinger'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new HellingerKernel();
	}

	public static MercerKernel<double []> toHyperbolicTangentKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'hyperbolic-tangent'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);
		final double scale = (double)parameters.get(SCALE_PARAMETER);
		final double offset = (double)parameters.get(OFFSET_PARAMETER);

		log.info("    parameter scale is {} and offset is {}.", scale, offset);

		return new HyperbolicTangentKernel(scale, offset);
	}

	public static MercerKernel<double []> toLaplacianKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'laplacian'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);

		log.info("    parameter σ is {}.", sigma);

		return new LaplacianKernel(sigma);
	}

	public static MercerKernel<double []> toLinearKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'linear'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new LinearKernel();
	}

	public static MercerKernel<double []> toPearsonKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'pearson'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		final double omega = (double) parameters.get("ω");
		log.info("    parameter ω={} and σ={}.", omega, sigma);

		return new PearsonKernel(omega, sigma);
	}

	public static MercerKernel<double []> toPolynomialKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'polynomial'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		final int degree = (int) parameters.get(DEGREE_PARAMETER);
		final double scale = (double) parameters.get(SCALE_PARAMETER);
		final double offset = (double) parameters.get(OFFSET_PARAMETER);

		log.info("    parameter σ={}.", sigma);
		log.info("    parameter degeree is {}, scale is {}, and offset is {}.", degree, scale, offset);

		return new PolynomialKernel(degree, scale, offset);
	}

	public static MercerKernel<double []> toThinPlateSplineKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'thin-plate-spline'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new ThinPlateSplineKernel(sigma);
	}

	public static MercerKernel<double []> toKernel(final Map<String, Object> parameters, final Map<String, Object> state) {
		log.info("  Using kernel '{}'", state.get(KERNEL_PARAMETER));

		return switch((String)state.get(KERNEL_PARAMETER)) {
			case "de.evoal.surrogate.smile.ml.gaussian-svr" 			-> toGaussianKernel(parameters);
			case "de.evoal.surrogate.smile.ml.hellinger-svr" 			-> toHellingerKernel(parameters);
			case "de.evoal.surrogate.smile.ml.hyperbolic-tangent-svr" 	-> toHyperbolicTangentKernel(parameters);
			case "de.evoal.surrogate.smile.ml.laplacian-svr" 			-> toLaplacianKernel(parameters);
			case "de.evoal.surrogate.smile.ml.linear-svr" 				-> toLinearKernel(parameters);
			case "de.evoal.surrogate.smile.ml.pearson-svr" 				-> toPearsonKernel(parameters);
			case "de.evoal.surrogate.smile.ml.polynomial-svr" 			-> toPolynomialKernel(parameters);
			case "de.evoal.surrogate.smile.ml.thin-plate-spline-svr" 	-> toThinPlateSplineKernel(parameters);
			default 	-> throw new IllegalArgumentException("The kernel " + parameters.get(KERNEL_PARAMETER) + " is not supported.");
		};
	}

	public static List<Parameter> toParameters(final Regression<double[]> regression, final String kernelName) {
		final KernelMachine<double []> machine = (KernelMachine<double[]>)regression;
		
		final List<Parameter> result = new LinkedList<>();
		addParameter("weights", machine.weights(), result);
		addParameter("intercept", machine.intercept(), result);
		addParameter("instances", machine.vectors(), result);
		addParameter(KERNEL_PARAMETER, kernelName, result);

		return result;
	}

	private void logRegressionParameters(final Regression<double[]> c) {
		try {
			final Field bField = smile.base.svm.KernelMachine.class.getDeclaredField("b");
			final Field wField = smile.base.svm.KernelMachine.class.getDeclaredField("w");

			bField.setAccessible(true);
			wField.setAccessible(true);

			final double b = bField.getDouble(c);
			final double [] w = (double [])wField.get(c);

			log.info("Parameters of kernel are b = {} and w = {}.", b, Arrays.toString(w));
		} catch(final NoSuchFieldException e) {
			log.error("Cannot determine the model parameters: Unable to read model of SVR.", e);
		} catch (final IllegalArgumentException e) {
			log.error("Cannot determine the model parameters: ", e);
		} catch (IllegalAccessException e) {
			log.error("Cannot determine the model parameters: ", e);
		}
	}}
