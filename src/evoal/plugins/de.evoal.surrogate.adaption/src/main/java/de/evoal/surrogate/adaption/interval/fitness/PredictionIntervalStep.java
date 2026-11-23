package de.evoal.surrogate.adaption.interval.fitness;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.adaption.AdaptionStep;
import de.evoal.surrogate.adaption.interval.model.PredictiveErrorData;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.PredictionPipeline;
import de.evoal.surrogate.api.function.PredictiveStandardDeviation;
import de.evoal.surrogate.api.io.ModelReader;
import de.evoal.surrogate.smile.api.KernelBasedSVRFunction;
import de.evoal.core.api.math.EvoalMath;

/**
 * Adapts the prediction of a surrogate by the width of its prediction interval (DL type
 *   {@code 'prediction-interval'}): {@code 2 · ŷ² / width}. The interval comes from
 * <ul>
 *   <li>the predictive standard deviation σ of a model that provides it (e.g. a Gaussian
 *     process): ŷ ± z · σ for every output, with z the {@link #CONFIDENCE} quantile of the
 *     standard normal distribution;</li>
 *   <li>otherwise the prediction error data of an SVR surrogate, calculated during training
 *     (see the goodness-of-fit calculator {@code predictive-error}); it only exists for the
 *     surrogate's first output.</li>
 * </ul>
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
     * The width of the prediction interval of an objective at a candidate.
     */
    private IntervalWidth width;

    @Override
    protected double adapt(final TypedEObject candidate, final String objective, final double value) {
        return adapt(value, width.of(candidate, objective));
    }

    /**
     * @param value The (possibly already adapted) prediction.
     * @param width The width of the prediction interval.
     * @return {@code 2 · value² / width}.
     */
    static double adapt(final double value, final double width) {
        return (2 * EvoalMath.square(value)) / width;
    }

    @Override
    public PredictionIntervalStep init(final EObject configuration) {
        return this;
    }

    /**
     * @throws IllegalStateException if the surrogate provides no predictive standard deviation
     *   and is no SVR with prediction error data.
     */
    @Override
    protected Set<String> prepare() {
        final ModelFunctionData surrogate = surrogate();
        final ModelFunction function = surrogate.function();

        if(function instanceof PredictiveStandardDeviation deviation) {
            width = standardDeviationWidth(function, deviation, surrogate.pipeline());

            return function.getOutput()
                           .stream()
                           .map(EStructuralFeature::getName)
                           .collect(Collectors.toSet());
        }

        if(!(function instanceof KernelBasedSVRFunction svrFunction)) {
            throw new IllegalStateException("The prediction-interval adaption requires a surrogate with a predictive standard deviation"
                                            + " (e.g. a Gaussian process) or an SVR surrogate, but the surrogate is '"
                                            + function.getClass().getName() + "'.");
        }

        final ModelReader reader = surrogate.reader()
                                            .orElseThrow(() -> new IllegalStateException("The surrogate model has no reader for its stored information."));

        reproducibility.reportNativeLibraries("prediction-interval");
        final PredictiveErrorData errorData = new PredictiveErrorData(reader);
        width = (candidate, objective) -> {
            final Pair<Double, Double> boundaries = errorData.calculateBoundaries(candidate, 0, svrFunction, surrogate.pipeline(), CONFIDENCE, annotations);

            return boundaries.getSecond() - boundaries.getFirst();
        };

        // the predictive error calculator only stores data for the first output feature
        final EStructuralFeature errorFeature = svrFunction.getOutput().getFirst();

        return Set.of(errorFeature.getName());
    }

    /**
     * @return The width {@code 2 · z · σ} of the interval ŷ ± z · σ, in the original unit: the
     *   model computes σ' at the prepared candidate in its own unit, and σ = |dy/dy'| · σ' with
     *   the slope of the steps after the prediction at the model's prediction y' (exact for
     *   affine steps).
     */
    static IntervalWidth standardDeviationWidth(final ModelFunction function, final PredictiveStandardDeviation deviation, final PredictionPipeline pipeline) {
        final double quantile = new NormalDistribution(0.0, 1.0).inverseCumulativeProbability(CONFIDENCE);
        final Space output = function.getOutput();

        return (candidate, objective) -> {
            final EStructuralFeature feature = output.find(objective).orElseThrow();
            final TypedEObject point = pipeline.prepare(candidate);
            double slope = 1.0;
            if(pipeline.hasPostparation()) {
                final TypedEObject predicted = output.newEObject();
                function.apply(point, predicted);
                slope = pipeline.slope(feature, predicted.eGetAsDouble(feature));
            }

            return 2 * quantile * Math.abs(slope) * deviation.standardDeviation(point, feature);
        };
    }

    /**
     * The width of the prediction interval of an objective at a candidate.
     */
    @FunctionalInterface
    interface IntervalWidth {
        /**
         * @param candidate The candidate (a point of the search space).
         * @param objective The name of the objective, an output of the surrogate.
         * @return The width of the prediction interval.
         */
        double of(TypedEObject candidate, String objective);
    }

    @Override
    public String toString() {
        return "prediction-interval";
    }
}
