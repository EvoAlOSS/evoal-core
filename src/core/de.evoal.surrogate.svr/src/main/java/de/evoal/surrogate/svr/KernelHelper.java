package de.evoal.surrogate.svr;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.evoal.surrogate.api.configuration.Parameter;
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

	private static final String SIGMA_PARAMETER = "σ";

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

	public static KernelMachine<double []> fromParameters(final List<Parameter> parameters, final List<Parameter> kernelParameters) {
		final Map<String, Object> kernelParameterMap = toMap(kernelParameters);

		final MercerKernel<double []> kernel = toKernel(toMap(parameters), kernelParameterMap);
		final double[][] instances =(double[][]) kernelParameterMap.get("instances");
		final double[] weight = (double[]) kernelParameterMap.get("weights");
		final double b = (double)kernelParameterMap.get("intercept");
		
		return new KernelMachine<>(kernel, instances, weight, b);
	}

	public static MercerKernel<double []> toGaussianKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'gaussian'");
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new GaussianKernel(sigma);
	}

	public static MercerKernel<double []> toKernel(final Map<String, Object> parameters, final Map<String, Object> state) {
		log.info("  Using kernel '{}'", state.get(KERNEL_PARAMETER));

		switch((String)state.get(KERNEL_PARAMETER)) {
		case "gaussian": {
			final double sigma = (double)parameters.get(SIGMA_PARAMETER);

			log.info("    parameter σ={}.", sigma);

			return new GaussianKernel(sigma);
		}

		case "hellinger": {
			return new HellingerKernel();
		}
		
		case "hyperbolic-tangent": {
			final double scale = (double)parameters.get(SCALE_PARAMETER);
			final double offset = (double)parameters.get(OFFSET_PARAMETER);
			
			log.info("    parameter scale is {} and offset is {}.", scale, offset);
			
			return new HyperbolicTangentKernel(scale, offset);
		}

		case "laplacian": {
			final double sigma = (double)parameters.get(SIGMA_PARAMETER);

			log.info("    parameter sigma is {}.", sigma);

			return new LaplacianKernel(sigma);
		}

		case "linear": {
			return new LinearKernel();
		}

		case "pearson": {
			final double omega = (double)parameters.get("omega");
			final double sigma = (double)parameters.get(SIGMA_PARAMETER);
			
			log.info("    parameter ω={} and σ={}.", omega, sigma);

			return new PearsonKernel(omega, sigma);
		}

		case "polynomial": {
			final int degree = (int)parameters.get(DEGREE_PARAMETER);
			final double scale = (double)parameters.get(SCALE_PARAMETER);
			final double offset = (double)parameters.get(OFFSET_PARAMETER);
			
			log.info("    parameter degeree is {}, scale is {}, and offset is {}.", degree, scale, offset);

			return new PolynomialKernel(degree, scale, offset);
		}

		case "thin-plate-spline": {
			final double sigma = (double)parameters.get(SIGMA_PARAMETER);

			log.info("    parameter σ={}.", sigma);

			return new ThinPlateSplineKernel(sigma);
		}
		}
		 

		throw new IllegalArgumentException("The kernel " + parameters.get(KERNEL_PARAMETER) + " is not supported.");
	}

	public static List<Parameter> toParameters(final Regression<double[]> regression, final String kernelName) {
		final KernelMachine<double []> machine = (KernelMachine<double[]>)regression;
		
		final List<Parameter> result = new LinkedList<>();
		addParameter("weights", machine.weights(), result);
		addParameter("intercept", machine.intercept(), result);
		addParameter("instances", machine.instances(), result);
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
