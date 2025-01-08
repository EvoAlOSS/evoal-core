package de.evoal.pipeline.api.model;

import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.LinkedHashSet;

/**
 * A component of the data pipeline.
 */
public interface Component {
    /**
     * @return A non-null set of structural features the component will read.
     */
    public @NonNull LinkedHashSet<EStructuralFeature> getReads();

    /**
     * @return A non-null set of structural features the component will write.
     */
    public @NonNull LinkedHashSet<EStructuralFeature> getWrites();

    /**
     * Applies the component to an object. Therefore, the component reads and writes features.
     *
     * @param object The object to work on.
     * @return The passed object.
     */
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object);
}
