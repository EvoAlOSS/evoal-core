package de.evoal.surrogate.smile.gaussian;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.training.AbstractModelLearner;
import de.evoal.surrogate.api.training.ModelLearner;
import de.evoal.surrogate.smile.KernelFactory;
import de.evoal.surrogate.smile.utils.Converter;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import smile.math.kernel.MercerKernel;
import smile.regression.GaussianProcessRegression;

import java.util.*;
import java.util.function.Function;


/**
 * class for the gaussian process algorithm
 */
@Dependent
@Named("de.evoal.surrogate.smile.ml.gaussian-process-learner")
@Slf4j
public class GaussianProcessLearner extends AbstractModelLearner {
    public static final String MLL_ITERATIONS_PARAMETER = "iterations";
    public static final String MLL_KERNEL_PARAMETER = "kernel";
    public static final String MLL_NOISE_PARAMETER = "noise";
    public static final String MLL_NORMALIZE_PARAMETER = "normalize";
    public static final String MLL_TOLERANCE_PARAMETER = "tolerance";

    protected final Map<String, Object> configuration = new HashMap<>();

    @Inject
    private AttributeHelper helper;

    /**
     * Number of iterations.
     */
    private int iterations = 10;

    /**
     * Noise level.
     */
    private double noise = 0.15;

    /**
     * Whether to normalize the data.
     */
    private boolean normalize = true;

    /**
     * The learned regression model.
     */
    private GaussianProcessRegression<double[]> regression;

    /**
     * Specifies the tolerance value used in the Gaussian Process optimization process.
     * This value controls the precision of the optimization algorithm by determining
     * the acceptable level of error or convergence criteria.
     */
    private double tolerance = 0.15;

    /**
     * The training data to use.
     */
    private final List<TypedEObject> trainingData = new ArrayList<>();


    @Override
    public void add(final TypedEObject features) {
        final TypedEObject copy = features.copy();

        trainingData.add(copy);
    }

    @Override
    public ModelLearner init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        noise = helper.lookup(configuration, MLL_NOISE_PARAMETER);
        tolerance = helper.lookup(configuration, MLL_TOLERANCE_PARAMETER);
        normalize = helper.lookup(configuration, MLL_NORMALIZE_PARAMETER);
        iterations = helper.lookup(configuration, MLL_ITERATIONS_PARAMETER);

        final Instance kernel = helper.lookup(configuration, KernelFactory.MLL_KERNEL_PARAMETER);

        this.configuration.put(MLL_ITERATIONS_PARAMETER, iterations);
        this.configuration.put(KernelFactory.KERNEL_PARAMETER, KernelFactory.mllToConfiguration(kernel));
        this.configuration.put(MLL_NOISE_PARAMETER, noise);
        this.configuration.put(MLL_NORMALIZE_PARAMETER, normalize);
        this.configuration.put(MLL_TOLERANCE_PARAMETER, tolerance);

        return this;
    }


    @Override
    public void learn() {
        log.info("Calculate SVR surrogate from {} to {}.", inputFeatures, outputFeatures);

        Requirements.requireSizeGreaterThan(inputFeatures, 0);
        Requirements.requireSize(outputFeatures, 1);

        // do sanity checks and log information for the user
        final Function<TypedEObject, double []> sourceConverter = Converter.create(inputFeatures);
        final Function<TypedEObject, double []> targetConverter = Converter.create(outputFeatures);

        final List<double []> sources = new ArrayList<>();
        final List<Double> targets = new ArrayList<>();

        trainingData
                .forEach(p -> {
                    sources.add(sourceConverter.apply(p));
                    targets.add(targetConverter.apply(p)[0]);
                });

        log.info("Using {} points for regression.", sources.size());

        double [][] sourceArray = sources.toArray(new double [][] {});
        double [] targetArray = targets.stream().mapToDouble(Double.class::cast).toArray();


        final Map<String, Object> kernelMap = (Map<String, Object>)configuration.get("kernel");
        final MercerKernel<double[]> mercerKernel = KernelFactory.toKernel(kernelMap);

        GaussianProcessRegression.Options options = new GaussianProcessRegression.Options(noise, normalize, tolerance, iterations);

        try {
            regression= GaussianProcessRegression.<double []>fit(sourceArray, targetArray, mercerKernel, options);
        }
        catch (Exception e){
            options = new GaussianProcessRegression.Options(noise, normalize, tolerance, 0);
            regression = GaussianProcessRegression.fit(sourceArray, targetArray, mercerKernel, options);
        }

        /*
        if (StringToKernel(KernelToString(gaussianProcessRegression.kernel)) == null){
            properties.remove("smile.gaussian_process.iterations");
            properties.setProperty("smile.gaussian_process.iterations", "0");
            regression = GaussianProcessRegression.fit(x, y, mercerKernel, properties);
        }
         */

    }

    @Override
    public @NonNull ModelFunction toFunction() {
        return new GaussianProcessFunction(
                getInputFeatures(),
                getOutputFeatures(),
                regression,
                configuration
        );
    }
}
