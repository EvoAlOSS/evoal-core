package de.evoal.surrogate.adaption.interval.fitness;

import java.util.Set;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.adaption.AdaptionStep;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;

/**
 * Adapts the prediction of an SVR surrogate by the width of its prediction interval
 *   (DL type {@code 'prediction-interval'}): {@code 2 · ŷ² / (upper − lower)}. The
 *   prediction error data has to be calculated during training (see the goodness-of-fit
 *   calculator {@code predictive-error}); it only exists for the surrogate's first output.
 */
@Dependent
@Named("de.evoal.surrogate.adaption.interval.optimisation.prediction-interval")
public class PredictionIntervalStep extends AdaptionStep {
    @Inject
    private ReproducibilityProtocol reproducibility;

    /**
     * Confidence of the prediction interval.
     */
    private static final double CONFIDENCE = 0.95;

    @Inject
    private EAnnotationHelper annotations;

    /**
     * The prediction error data of the surrogate's first output feature.
     */
    private PredictiveErrorData errorData;

    /**
     * The surrogate function the error data belongs to.
     */
    private KernelBasedSVRFunction svr;

    @Override
    protected double adapt(final TypedEObject candidate, final String objective, final double value) {
        final Pair<Double, Double> boundaries = errorData.calculateBoundaries(candidate, 0, svr, CONFIDENCE, annotations);
        final double lower = boundaries.getFirst();
        final double upper = boundaries.getSecond();

        return adapt(value, lower, upper);
    }

    /**
     * @param value The (possibly already adapted) prediction.
     * @param lower The lower end of the prediction interval.
     * @param upper The upper end of the prediction interval.
     * @return {@code 2 · value² / (upper − lower)}.
     */
    static double adapt(final double value, final double lower, final double upper) {
        final double width = upper - lower;

        return (2 * value * value) / width;
    }

    @Override
    public PredictionIntervalStep init(final EObject configuration) {
        return this;
    }

    /**
     * @throws IllegalStateException if the surrogate is no SVR or the model contains no
     *   prediction error data.
     */
    @Override
    protected Set<String> prepare() {
        final ModelFunctionData surrogate = surrogate();
        final ModelFunction function = surrogate.function();

        if(!(function instanceof KernelBasedSVRFunction svrFunction)) {
            throw new IllegalStateException("The prediction-interval adaption requires an SVR surrogate, but the surrogate is '"
                                            + function.getClass().getName() + "'.");
        }

        final ModelReader reader = surrogate.reader()
                                            .orElseThrow(() -> new IllegalStateException("The surrogate model has no reader for its stored information."));

        reproducibility.reportNativeLibraries("prediction-interval");
        svr = svrFunction;
        errorData = new PredictiveErrorData(reader);

        // the predictive error calculator only stores data for the first output feature
        final EStructuralFeature errorFeature = svr.getOutput().getFirst();

        return Set.of(errorFeature.getName());
    }

    @Override
    public String toString() {
        return "prediction-interval";
    }
}
