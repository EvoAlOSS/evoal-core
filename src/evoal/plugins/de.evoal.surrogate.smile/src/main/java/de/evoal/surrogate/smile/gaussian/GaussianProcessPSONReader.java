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
import smile.tensor.Cholesky;
import smile.tensor.DenseMatrix;
import smile.tensor.Vector;

import java.util.Map;

/**
 * Reads a Gaussian process surrogate from a PSON model file.
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

        final Map<String, Object> kernelMap = (Map<String, Object>)parameterMap.get(KernelFactory.KERNEL_PARAMETER);

        return new GaussianProcessFunction(
                getInput(),
                getOutput(),
                toRegression(KernelFactory.toKernel(kernelMap), regressionMap),
                parameterMap);
    }

    /**
     * Restores the regression of a model file. The Cholesky factor of K + noise · I, which
     *   the predictive standard deviation needs, is recomputed from the regressors instead of
     *   being stored (n² values); the fit computed the same factor.
     *
     * @param configured The kernel of the MLL file.
     * @param regression The stored regression (see {@link KernelFactory#toConfiguration}).
     * @return The regression with the fitted kernel, if the hyperparameters are stored.
     * @throws IllegalStateException if K + noise · I is not positive definite.
     */
    static GaussianProcessRegression<double[]> toRegression(final MercerKernel<double[]> configured,
                                                            final Map<String, Object> regression) {
        MercerKernel<double[]> kernel = configured;
        if(regression.get(KernelFactory.GP_HYPERPARAMETERS) instanceof double[] hyperparameters) {
            kernel = configured.of(hyperparameters);
        }
        log.info("Gaussian process with kernel {}.", kernel);

        final double[][] regressors = (double[][]) regression.get(KernelFactory.GP_REGRESSORS);
        final Vector weights = Vector.column(toArray(regression.get(KernelFactory.GP_WEIGHTS)));
        final double noise = (double) regression.get(KernelFactory.GP_NOISE);
        final double mean = (double) regression.get(KernelFactory.GP_MEAN);
        final double sd = (double) regression.get(KernelFactory.GP_SD);
        final double logMarginalLikelihood = regression.get(KernelFactory.GP_LOG_MARGINAL_LIKELIHOOD) instanceof Double value ? value : Double.NaN;

        return new GaussianProcessRegression<>(kernel, regressors, weights, noise, mean, sd, cholesky(kernel, regressors, noise), logMarginalLikelihood);
    }

    private static Cholesky cholesky(final MercerKernel<double[]> kernel, final double[][] regressors, final double noise) {
        final DenseMatrix matrix = kernel.K(regressors);
        for(int i = 0; i < regressors.length; ++i) {
            matrix.add(i, i, noise);
        }

        try {
            return matrix.cholesky();
        } catch(final RuntimeException e) {
            throw new IllegalStateException("The kernel matrix of the stored Gaussian process plus its noise is not positive definite: " + e.getMessage(), e);
        }
    }

    /**
     * @param weights The stored weights: an array, or a one-column matrix (files written with
     *   Smile 5 before the weights were stored as an array).
     * @return The weights as an array.
     */
    private static double[] toArray(final Object weights) {
        if(weights instanceof double[] array) {
            return array;
        }

        if(weights instanceof DenseMatrix matrix && matrix.ncol() == 1) {
            final double[] array = new double[matrix.nrow()];
            for(int i = 0; i < array.length; ++i) {
                array[i] = matrix.get(i, 0);
            }
            return array;
        }

        throw new IllegalStateException("The weights of the Gaussian process are neither an array nor a column vector.");
    }
}
