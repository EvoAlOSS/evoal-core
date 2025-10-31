package de.evoal.surrogate.api.io;

import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.training.ModelLearner;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <p>
 *     A model writer is an adapter that serialised a trained model (passed as a {@link ModelLearner}
 *     to a storage location. Since the storage location used different strategies each model has to
 *     provide a custom writer for each supported {@link ModelStorage}.
 *  </p>
 *
 * @param <F> The concrete model supported.
 * @param <S> The concrete storage type supported.
 */
public interface ModelWriter<F extends ModelFunction, S extends ModelStorage> {
    /**
     * Sets the actual storage to use.
     *
     * @param storage The storage to be used.
     */
    void setStorage(final @NonNull S storage);

    /**
     * Stores the model to the set storage.
     */
    void store(final @NonNull F function);

    /**
     * Adds an information for the given input feature.
     *
     * @param feature The feature.
     * @param value The value to store.
     */
    void addInputFeatureInformation(final EStructuralFeature feature, final Parameter value);


    /**
     * Sets the prediction pipeline to use.
     *
     * @param pipeline The pipeline
     * @return The writer itself.
     */
    ModelWriter<F, S> addPredictionPipeline(final @NonNull PipelineDefinition pipeline);

    /**
     * Adds an information for the given output feature.
     *
     * @param feature The feature.
     * @param value The value to store.
     */
    void addOutputFeatureInformation(final EStructuralFeature feature, final Parameter value);

}
