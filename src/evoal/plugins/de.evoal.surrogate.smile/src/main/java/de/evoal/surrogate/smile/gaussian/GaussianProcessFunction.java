package de.evoal.surrogate.smile.gaussian;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.PredictiveStandardDeviation;
import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.regression.GaussianProcessRegression;

import java.util.Map;


/**
 * A Gaussian process surrogate with a single output: predicts the mean of the modelled
 *   function and gives its predictive standard deviation.
 */
public class GaussianProcessFunction extends ModelFunction implements PredictiveStandardDeviation {

    /**
     * Serialises the standard deviations of all Gaussian processes. Smile computes them with
     *   native BLAS and LAPACK, and the OpenBLAS of the CI gave wrong values when several
     *   threads called it at the same time.
     */
    private static final Object NATIVE_LOCK = new Object();

    @Getter
    private final Map<String, Object> parameters;

    @Getter
    private final GaussianProcessRegression<double[]> regression;

    /**
     * @param regression The regression; it needs the Cholesky factor of its kernel matrix for
     *   the standard deviation (Smile keeps it after fitting, the reader recomputes it).
     */
    public GaussianProcessFunction(final Space input,
                                   final Space output,
                                   final GaussianProcessRegression<double[]> regression,
                                   final Map<String, Object> parameters) {
        super("de.evoal.surrogate.smile.ml.gaussian-process", input, output);

        this.regression = regression;
        this.parameters = parameters;
    }

    @Override
    public void apply(@NonNull TypedEObject input, @NonNull TypedEObject output) {
        final double predictedValue = regression.predict(toArray(input));
        final EStructuralFeature oFeature = this.output.iterator().next();

        output.eSet(oFeature, predictedValue);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Smile's Gaussian process predicts the mean in Java from its final weights and
     *   regressors, and the kernels have final parameters only. The standard deviation uses
     *   native code and is computed by one thread at a time.
     */
    @Override
    public boolean isThreadSafe() {
        return true;
    }

    /**
     * The standard deviation of the latent function, without the noise. A negative variance
     *   from rounding (at a training point with a tiny noise) gives 0. One thread at a time
     *   computes it (see {@link #NATIVE_LOCK}).
     */
    @Override
    public double standardDeviation(final @NonNull TypedEObject input, final @NonNull EStructuralFeature output) {
        if(!this.output.contains(output)) {
            throw new IllegalArgumentException("'" + output.getName() + "' is not the output of the Gaussian process.");
        }

        final double[] point = toArray(input);
        final double[] estimation = new double[2];
        synchronized (NATIVE_LOCK) {
            regression.predict(point, estimation);
        }

        final double deviation = estimation[1];
        return Double.isNaN(deviation) ? 0.0 : deviation;
    }

    private double[] toArray(final TypedEObject input) {
        final double[] inputData = new double[this.input.size()];

        int index = 0;
        for(final EStructuralFeature feature : this.input) {
            inputData[index] = input.eGetAsDouble(feature);
            index += 1;
        }

        return inputData;
    }
}
