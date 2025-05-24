package de.evoal.pipeline.api.model;

import lombok.NonNull;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.Space;

/**
 * A component of the data pipeline.
 */
public interface Component {
    /**
     * @return A non-null set of structural features the component will read.
     */
    public @NonNull Space getReads();

    /**
     * @return A non-null set of structural features the component will write.
     */
    public @NonNull Space getWrites();

    /**
     * Applies the component to an object. Therefore, the component reads and writes features.
     *
     * @param object The object to work on.
     * @return The passed object.
     */
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object);

    /**
     * Gets called to signal component that the pipeline was closed.
     */
    public void close();
}
