package de.evoal.surrogate.smile;

import java.util.*;
import java.util.stream.Collectors;

import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.surrogate.api.io.pson.Parameter;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import smile.math.kernel.*;
import smile.regression.GaussianProcessRegression;
import smile.regression.KernelMachine;
import smile.regression.Regression;

public final class KernelFactory {
	public static final String MLL_EPSILON_PARAMETER = "ε";

	public static final String MLL_KERNEL_PARAMETER = "kernel";

	public static final String MLL_SOFT_MARGIN_PARAMETER = "soft-margin";

	public static final String MLL_TOLERANCE_PARAMETER = "tolerance";


	public static final String KERNEL_PARAMETER = "kernel";

	public static final String KERNEL_1_PARAMETER = "kernel-1";
	public static final String KERNEL_2_PARAMETER = "kernel-1";

	public static final String TYPE_PARAMETER = "_type";

	private static final String DEGREE_PARAMETER = "degree";


	private static final String SCALE_PARAMETER = "scale";

	private static final String OFFSET_PARAMETER = "offset";

	public static final String SIGMA_PARAMETER = "σ";


	/**
	 * Logger instance
	 */
	private final static Logger log = LoggerFactory.getLogger(KernelFactory.class);

	private KernelFactory() {
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
		final Parameter modelParameter = parameters
				.stream()
				.filter(p -> "model".equals(p.getName()))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("The model parameter is missing."));

		final Map<String, Object> modelMap = (Map<String, Object>)modelParameter.getValue();
		final Map<String, Object> parametersMap = (Map<String, Object>)modelMap.get("parameters");
		final Map<String, Object> kernelMap = (Map<String, Object>)parametersMap.get("kernel");

		final MercerKernel<double []> kernel = toKernel(kernelMap);

		final Map<String, Object> regressionMap = (Map<String, Object>)modelMap.get("regression");
		final double[][] instances =(double[][]) regressionMap.get("instances");
		final double[] weight = (double[]) regressionMap.get("weights");
		final double b = (double)regressionMap.get("intercept");
		
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

	public static MercerKernel<double []> toSumKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'sum'");
		final Map<String, Object> k1Parameters = (Map<String, Object>) parameters.get(KERNEL_1_PARAMETER);
		final Map<String, Object> k2Parameters = (Map<String, Object>) parameters.get(KERNEL_2_PARAMETER);

		return new SumKernel<>(toKernel(k1Parameters), toKernel(k2Parameters));
	}


	public static MercerKernel<double []> toProductKernel(final Map<String, Object> parameters) {
		log.info("  Using kernel 'product'");
		final Map<String, Object> k1Parameters = (Map<String, Object>) parameters.get(KERNEL_1_PARAMETER);
		final Map<String, Object> k2Parameters = (Map<String, Object>) parameters.get(KERNEL_2_PARAMETER);

		return new ProductKernel<>(toKernel(k1Parameters), toKernel(k2Parameters));
	}

	public static MercerKernel<double []> toKernel(final Map<String, Object> configuration) {
		final String kernelType = (String) configuration.get(TYPE_PARAMETER);
		log.info("  Using kernel '{}'", kernelType);
		log.info("    parameters {}", configuration);

		return switch(kernelType) {
			case "de.evoal.surrogate.smile.ml.gaussian" 			-> toGaussianKernel(configuration);
			case "de.evoal.surrogate.smile.ml.hellinger" 			-> toHellingerKernel(configuration);
			case "de.evoal.surrogate.smile.ml.hyperbolic-tangent" 	-> toHyperbolicTangentKernel(configuration);
			case "de.evoal.surrogate.smile.ml.laplacian" 			-> toLaplacianKernel(configuration);
			case "de.evoal.surrogate.smile.ml.linear" 				-> toLinearKernel(configuration);
			case "de.evoal.surrogate.smile.ml.pearson" 				-> toPearsonKernel(configuration);
			case "de.evoal.surrogate.smile.ml.polynomial" 			-> toPolynomialKernel(configuration);
			case "de.evoal.surrogate.smile.ml.thin-plate-spline" 	-> toThinPlateSplineKernel(configuration);
			case "de.evoal.surrogate.smile.ml.sum" 					-> toSumKernel(configuration);
			case "de.evoal.surrogate.smile.ml.product"			 	-> toProductKernel(configuration);
			default 	-> throw new IllegalArgumentException("The kernel " + kernelType + " is not supported.");
		};
	}

	public static Map<String, Object> toConfiguration(final Regression<double[]> regression) {
		final Map<String, Object> result = new HashMap<>();

		if(regression instanceof KernelMachine<double[]> machine) {
			result.put("weights", machine.weights());
			result.put("intercept", machine.intercept());
			result.put("instances", machine.vectors());
		} else if(regression instanceof GaussianProcessRegression<double[]> gp) {
			result.put("regressors", gp.regressors);
			result.put("weights", gp.w);
			result.put("noise", gp.noise);
			result.put("mean", gp.mean);
			result.put("sd", gp.sd);
		}

		return result;
	}
	/*x

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
            } catch (final IllegalArgumentException | IllegalAccessException e) {
                log.error("Cannot determine the model parameters: ", e);
            }
        }
    */
	private final static ConstantEvaluator evaluator = new ConstantEvaluator();
	public static Map<String, Object> mllToConfiguration(final Instance object) {
		final ClassDefinition definition = object.getDefinition();

		final Map<String, Object> result = new HashMap<>();
		result.put("_type", ((DefinitionModule)definition.eContainer()).getName() + "." + definition.getName());

		for(final Attribute attr : object.getAttributes()) {
			Object value = attr.getValue();
			value = evaluator.doSwitch((EObject) value);

			if(value instanceof Instance instance) {
				value = mllToConfiguration(instance);
			}

			result.put(attr.getDefinition().getName(), value);
		}

		return result;
	}
}
