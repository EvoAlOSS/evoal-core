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
     * The standard deviation of the latent function, without the noise. A negative variance
     *   from rounding (at a training point with a tiny noise) gives 0.
     */
    @Override
    public double standardDeviation(final @NonNull TypedEObject input, final @NonNull EStructuralFeature output) {
        if(!this.output.contains(output)) {
            throw new IllegalArgumentException("'" + output.getName() + "' is not the output of the Gaussian process.");
        }

        final double[] estimation = new double[2];
        regression.predict(toArray(input), estimation);

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
