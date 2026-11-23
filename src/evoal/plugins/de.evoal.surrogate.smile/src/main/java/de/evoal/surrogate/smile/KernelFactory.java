package de.evoal.surrogate.smile;

import java.util.*;
import java.util.stream.Collectors;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.surrogate.api.io.pson.Parameter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
	public static final String KERNEL_2_PARAMETER = "kernel-2";

	public static final String TYPE_PARAMETER = "_type";

	private static final String DEGREE_PARAMETER = "degree";


	private static final String SCALE_PARAMETER = "scale";

	private static final String OFFSET_PARAMETER = "offset";

	public static final String SIGMA_PARAMETER = "σ";

	private static final String NU_PARAMETER = "ν";

	private static final String OMEGA_PARAMETER = "ω";

	/**
	 * Keys of the stored Gaussian process regression (the {@code regression} map of the model
	 *   file).
	 */
	public static final String GP_REGRESSORS = "regressors";
	public static final String GP_WEIGHTS = "weights";
	public static final String GP_NOISE = "noise";
	public static final String GP_MEAN = "mean";
	public static final String GP_SD = "sd";

	/**
	 * The hyperparameters of the kernel after fitting ({@code MercerKernel.hyperparameters()}).
	 *   Older model files lack them; their kernel is the configured one.
	 */
	public static final String GP_HYPERPARAMETERS = "hyperparameters";

	/**
	 * The log marginal likelihood of the training data under the fitted model, the measure
	 *   that fitting the hyperparameters maximises. Older model files lack it.
	 */
	public static final String GP_LOG_MARGINAL_LIKELIHOOD = "log-marginal-likelihood";


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
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new GaussianKernel(sigma);
	}

	/**
	 * @param parameters The configuration of a {@code 'matérn'} kernel: length scale σ and
	 *   smoothness ν.
	 * @return The Matérn kernel; Smile rejects a ν other than 0.5, 1.5, 2.5 or infinity.
	 */
	public static MercerKernel<double []> toMaternKernel(final Map<String, Object> parameters) {
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		final double nu = (double) parameters.get(NU_PARAMETER);
		log.info("    parameter σ={} and ν={}.", sigma, nu);

		return new MaternKernel(sigma, nu);
	}

	/**
	 * @param parameters The configuration of a {@code 'hellinger'} kernel, which has no
	 *   parameters.
	 * @return The Hellinger kernel.
	 */
	public static MercerKernel<double []> toHellingerKernel(final Map<String, Object> parameters) {
		return new HellingerKernel();
	}

	/**
	 * @param parameters The configuration of a {@code 'hyperbolic-tangent'} kernel: scale γ and
	 *   offset λ of tanh(γ uᵀv + λ).
	 * @return The hyperbolic tangent kernel.
	 */
	public static MercerKernel<double []> toHyperbolicTangentKernel(final Map<String, Object> parameters) {
		final double scale = (double)parameters.get(SCALE_PARAMETER);
		final double offset = (double)parameters.get(OFFSET_PARAMETER);

		log.info("    parameter scale is {} and offset is {}.", scale, offset);

		return new HyperbolicTangentKernel(scale, offset);
	}

	public static MercerKernel<double []> toLaplacianKernel(final Map<String, Object> parameters) {
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);

		log.info("    parameter σ is {}.", sigma);

		return new LaplacianKernel(sigma);
	}

	public static MercerKernel<double []> toLinearKernel(final Map<String, Object> parameters) {
		return new LinearKernel();
	}

	/**
	 * @param parameters The configuration of a {@code 'pearson'} kernel: width σ and tailing
	 *   factor ω.
	 * @return The Pearson VII universal kernel.
	 */
	public static MercerKernel<double []> toPearsonKernel(final Map<String, Object> parameters) {
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		final double omega = (double) parameters.get(OMEGA_PARAMETER);
		log.info("    parameter σ={} and ω={}.", sigma, omega);

		return new PearsonKernel(sigma, omega);
	}

	/**
	 * @param parameters The configuration of a {@code 'polynomial'} kernel: degree d, scale γ
	 *   and offset λ of (γ uᵀv + λ)^d.
	 * @return The polynomial kernel; Smile rejects a degree below 1 and a negative offset.
	 */
	public static MercerKernel<double []> toPolynomialKernel(final Map<String, Object> parameters) {
		final int degree = (int) parameters.get(DEGREE_PARAMETER);
		final double scale = (double) parameters.get(SCALE_PARAMETER);
		final double offset = (double) parameters.get(OFFSET_PARAMETER);

		log.info("    parameter degree is {}, scale is {}, and offset is {}.", degree, scale, offset);

		return new PolynomialKernel(degree, scale, offset);
	}

	public static MercerKernel<double []> toThinPlateSplineKernel(final Map<String, Object> parameters) {
		final double sigma = (double) parameters.get(SIGMA_PARAMETER);
		log.info("    parameter σ={}.", sigma);

		return new ThinPlateSplineKernel(sigma);
	}

	public static MercerKernel<double []> toSumKernel(final Map<String, Object> parameters) {
		final Map<String, Object> k1Parameters = (Map<String, Object>) parameters.get(KERNEL_1_PARAMETER);
		final Map<String, Object> k2Parameters = (Map<String, Object>) parameters.get(KERNEL_2_PARAMETER);

		return new SumKernel<>(toKernel(k1Parameters), toKernel(k2Parameters));
	}


	public static MercerKernel<double []> toProductKernel(final Map<String, Object> parameters) {
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
			case "de.evoal.surrogate.smile.ml.matérn" 				-> toMaternKernel(configuration);
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
			result.put(GP_REGRESSORS, gp.regressors);
			result.put(GP_WEIGHTS, gp.w.toArray(new double[0]));
			result.put(GP_NOISE, gp.noise);
			result.put(GP_MEAN, gp.mean);
			result.put(GP_SD, gp.sd);
			// the kernel of the MLL file with fitted hyperparameters ('iterations' > 0)
			result.put(GP_HYPERPARAMETERS, gp.kernel.hyperparameters());
			result.put(GP_LOG_MARGINAL_LIKELIHOOD, gp.L);
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

	/**
	 * Converts a runtime kernel configuration into the parameter map that is used for
	 *   creating the SMILE kernel and that is stored in the PSON file.
	 */
	public static Map<String, Object> toKernelConfiguration(final EObject kernel) {
		final Map<String, Object> result = new HashMap<>();
		result.put(TYPE_PARAMETER, DynamicEClassProvider.dlTypeOf(kernel));

		for(final EStructuralFeature feature : kernel.eClass().getEAllStructuralFeatures()) {
			if(!kernel.eIsSet(feature)) {
				continue;
			}

			Object value = kernel.eGet(feature);
			if(value instanceof EObject nested) {
				value = toKernelConfiguration(nested);
			}

			result.put(feature.getName(), value);
		}

		return result;
	}
}
