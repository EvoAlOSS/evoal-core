package de.evoal.surrogate.api.io;

import java.util.List;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
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
     * Adds an information for the given input feature. The name of the value identifies the
     *   information: a value with the name of an earlier one replaces it.
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
     * Adds an information for the given output feature. The name of the value identifies the
     *   information: a value with the name of an earlier one replaces it.
     *
     * @param feature The feature.
     * @param value The value to store.
     */
    void addOutputFeatureInformation(final EStructuralFeature feature, final Parameter value);

    /**
     * Sets the DL types of the training configuration, which a run that uses the model cites.
     *   A storage that cannot record them ignores them.
     *
     * @param definitions The fully qualified names of the DL types.
     * @return The writer itself.
     */
    default ModelWriter<F, S> addTrainingDefinitions(final @NonNull List<String> definitions) {
        return this;
    }
}
