package de.evoal.surrogate.api.function;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A model function that also gives the predictive standard deviation of its prediction, e.g.
 *   a Gaussian process. The standard deviation is the uncertainty of the model about the
 *   predicted value at a point: small near the training data, large far from it. The
 *   surrogate adaption uses it to rate how reliable a prediction is.
 */
public interface PredictiveStandardDeviation {
    /**
     * @param input A point of the model's input space.
     * @param output An output feature of the model.
     * @return The predictive standard deviation of {@code output} at {@code input}, in the
     *   unit of the output; at least 0.
     */
    double standardDeviation(@NonNull TypedEObject input, @NonNull EStructuralFeature output);
}
