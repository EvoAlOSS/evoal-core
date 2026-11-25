package de.evoal.surrogate.api.function;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A model function that also gives a prediction interval for its prediction, e.g. a gradient
 *   boosting model that fits the lower and the upper quantile of the output. The interval holds
 *   a new observation at a point with the {@linkplain #coverage coverage} of the model. The
 *   surrogate adaption uses its width to rate how reliable a prediction is.
 */
public interface PredictionInterval {
    /**
     * An interval of an output.
     *
     * @param lower The lower bound.
     * @param upper The upper bound, at least {@code lower}.
     */
    record Interval(double lower, double upper) {
        /**
         * @return {@code upper − lower}.
         */
        public double width() {
            return upper - lower;
        }
    }

    /**
     * @param input A point of the model's input space.
     * @param output An output feature of the model.
     * @return The prediction interval of {@code output} at {@code input}, in the unit of the
     *   model.
     */
    Interval interval(@NonNull TypedEObject input, @NonNull EStructuralFeature output);

    /**
     * @param output An output feature of the model.
     * @return The share of new observations that the interval of {@code output} holds, in
     *   (0, 1), e.g. 0.9.
     */
    double coverage(@NonNull EStructuralFeature output);
}
