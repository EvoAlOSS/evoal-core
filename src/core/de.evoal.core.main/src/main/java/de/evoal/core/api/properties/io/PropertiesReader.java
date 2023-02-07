package de.evoal.core.api.properties.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.EvoalIOException;

import java.io.File;
import java.util.Iterator;

/**
 * Base interface for reading properties from disk.
 */
public interface PropertiesReader extends AutoCloseable, Iterator<Properties> {
    /**
     * The reader's initialisation method. Receives the file to read and the
     *   specification to use.
     *
     * @param input The input file.
     * @param specification The input specification.
     *
     * @return The instance itself.
     */
    public PropertiesReader init(final File input, final PropertiesSpecification specification) throws EvoalIOException;
}
