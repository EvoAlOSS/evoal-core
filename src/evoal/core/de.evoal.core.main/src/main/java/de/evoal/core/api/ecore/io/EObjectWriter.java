package de.evoal.core.api.ecore.io;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.NonNull;

import java.io.File;

/**
 * Base interface for EObject writers. An EObject writer's task is to serialize a sequence
 *   of EObjects.
 */
public interface EObjectWriter extends AutoCloseable {
    /**
     * Writes a new EObject instance to the repository.
     *
     * @param object The EObject to write.
     * @throws EvoalIOException An exception to signal some problem while serialising the data.
     */
    void add(final @NonNull TypedEObject object) throws EvoalIOException;

    /**
     * Inits the writer with the specification information.
     *
     * @param specification The specification of the EObject to write.
     *
     * @return The instance itself.
     */
    EObjectWriter init(final File outputFile, final Space specification) throws EvoalIOException;
}
