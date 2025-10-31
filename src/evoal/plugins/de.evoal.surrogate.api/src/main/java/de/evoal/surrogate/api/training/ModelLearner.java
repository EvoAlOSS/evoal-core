package de.evoal.surrogate.api.training;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.ModelWriter;
import lombok.NonNull;

import java.net.URI;

/**
 * Interface for model learner. The interface allows to add data
 */
public interface ModelLearner extends EvoalComponent<ModelLearner> {
    /**
     * Adds a data point.
     *
     * @param features The feature object.
     */
    void add(final TypedEObject features);

    /**
     * Returns the model writer used by the model learner.
     *
     * This is passed to the GoF components for adding additional information.
     *
     * @return A valid non-null model writer.
     */
    @NonNull
    ModelWriter<?, ?> getWriter();

    /**
     * Finish learning (if necessary).
     */
    void learn();

    /**
     * Method called (before the init of the component) that sets the input and
     *   output feature spaces.
     *
     * @param inputFeatures The input feature space.
     * @param outputFeatures The output feature space.
     */
    void setFeatureSpaces(Space inputFeatures, Space outputFeatures);

    /**
     * Turns a trained model into a surrogate function.
     *
     * @return A non-null valid surrogate function.
     */
    @NonNull
    ModelFunction toFunction();
}
