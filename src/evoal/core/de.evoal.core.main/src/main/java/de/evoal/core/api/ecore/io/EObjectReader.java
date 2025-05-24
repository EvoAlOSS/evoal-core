package de.evoal.core.api.ecore.io;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.EvoalIOException;

import java.io.File;
import java.util.Iterator;

/**
 * Base interface for reading EObjects from disk.
 */
public interface EObjectReader extends AutoCloseable, Iterator<TypedEObject> {
    /**
     * The reader's initialisation method. Receives the file to read and the
     *   specification to use.
     *
     * @param input The input file.
     * @param specification The input specification.
     *
     * @return The instance itself.
     */
    EObjectReader init(final File input, final Space specification) throws EvoalIOException;
}
