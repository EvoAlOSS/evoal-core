package de.evoal.core.api.properties.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.NonNull;

import java.io.File;

/**
 * Base interface for properties writers. A properties writer's task is to serialize a sequence of properties.
 */
public interface PropertiesWriter extends AutoCloseable {
    /**
     * Writes a new properties instance to the repository.
     *
     * @param properties The properties to write.
     * @throws EvoalIOException An exception to signal some problem while serialising the data.
     */
    void add(final @NonNull Properties properties) throws EvoalIOException;

    /**
     * Inits the writer with the specification information.
     *
     * @param specification The properties specification of the properties to write.
     *
     * @return The instance itself.
     */
    PropertiesWriter init(final File outputFile, final PropertiesSpecification specification) throws EvoalIOException;
}
