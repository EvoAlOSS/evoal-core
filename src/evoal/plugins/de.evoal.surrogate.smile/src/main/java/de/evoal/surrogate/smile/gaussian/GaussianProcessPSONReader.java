package de.evoal.surrogate.smile.gaussian;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.AbstractPSONReader;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.smile.KernelFactory;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import smile.math.kernel.MercerKernel;
import smile.regression.GaussianProcessRegression;
import smile.tensor.Vector;

import java.util.Map;

/**
 * Factory class for the gaussian process algorithm
 */
@Named("de.evoal.surrogate.smile.ml.gaussian-process-reader-pson")
@Dependent
@Slf4j
public class GaussianProcessPSONReader extends AbstractPSONReader {
    @Override
    public @NonNull ModelFunction load() {
        final SurrogateConfiguration configuration = storage
                .getConfiguration()
                .get();

        final Parameter modelParameter = configuration
                .getState()
                .stream()
                .filter(p -> "model".equals(p.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("The model parameter is missing."));

        final Map<String, Object> modelMap = (Map<String, Object>)modelParameter.getValue();
        final Map<String, Object> parameterMap = (Map<String, Object>)modelMap.get("parameters");
        final Map<String, Object> regressionMap = (Map<String, Object>)modelMap.get("regression");

        final Map<String, Object> kernelMap = (Map<String, Object>)parameterMap.get("kernel");
        final MercerKernel<double[]> kernel = KernelFactory.toKernel(kernelMap);

        double[][] regressors = (double[][]) regressionMap.get("regressors");
        double[] weights = (double[]) regressionMap.get("weights");
        final Vector weightsVector = Vector.column(weights);
        double noise = (double) regressionMap.get("noise");
        double mean = (double) regressionMap.get("mean");
        double sd = (double) regressionMap.get("sd");

        final GaussianProcessRegression<double []> regression = new GaussianProcessRegression<double []>(kernel, regressors, weightsVector, noise, mean, sd);

        return new GaussianProcessFunction(
                getInput(),
                getOutput(),
                regression,
                parameterMap);
    }
}
