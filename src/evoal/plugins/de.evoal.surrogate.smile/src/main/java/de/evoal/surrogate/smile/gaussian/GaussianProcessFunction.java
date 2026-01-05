package de.evoal.surrogate.smile.gaussian;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.math.kernel.*;
import smile.regression.GaussianProcessRegression;

import java.util.*;


/**
 * class for the gaussian process algorithm
 */
public class GaussianProcessFunction extends ModelFunction {

    @Getter
    private final Map<String, Object> parameters;

    @Getter
    private GaussianProcessRegression<double[]> regression = null;

    /**
     * constructor of the GaussianProcess class
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
        final double [] inputData = new double[this.input.size()];

        int index = 0;
        for(final EStructuralFeature feature : this.input) {
            inputData[index] = input.eGetAsDouble(feature);
            index += 1;
        }

        final double predictedValue = regression.predict(inputData);
        final EStructuralFeature oFeature = this.output.iterator().next();

        output.eSet(oFeature, predictedValue);
    }
}
