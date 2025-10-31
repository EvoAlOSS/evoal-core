package de.evoal.surrogate.api.io;

import de.evoal.core.api.ecore.Space;

import java.net.URI;

/**
 * <p>
 *   Base interface for storage locations for trained models. A model storage is some means
 *   to serialize a model and additional data, such as goodness of fit measures, training
 *   data, or so on.
 * </p>
 *
 * <p>
 *   The concrete implementations are created by {@link de.evoal.surrogate.api.training.ModelLearner}
 *   using {@link ModelStorageFactory}. The instance is then passed to a {@link ModelWriter}
 *   instance. The model writer is an adapter between a concrete model and a concrete storage
 *   type.
 * </p>
 *
 */
public interface ModelStorage {
    /**
     * @return The storage's input space.
     */
    public Space getInputSpace();

    /**
     * @return The CDI name of the model.
     */
    public String getModelName();

    /**
     * @return The storage's output space.
     */
    public Space getOutputSpace();

    /**
     * @return The file extension of the storage files.
     */
    public String getStorageExtension();

    /**
     * Sets the storage URI of the model.
     *
     * @param location The storage URI.
     *
     * @return The instance itself to allow fluent usage of the function.
     */
    ModelStorage setLocation(final URI location);

    /**
     * Sets the input and output space of the model storage.
     *
     * @param inputSpace The input space.
     * @param outputSpace The output space.
     * @return The model storage itself.
     */
    ModelStorage setSpaces(final Space inputSpace, final Space outputSpace);
}
