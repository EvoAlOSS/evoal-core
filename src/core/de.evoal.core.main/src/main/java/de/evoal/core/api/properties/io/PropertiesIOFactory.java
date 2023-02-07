package de.evoal.core.api.properties.io;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.EvoalIOException;

import java.io.File;

/**
 * Factory class for creating instances of {@code PropertiesReader} and {@code PropertiesWriter}.
 */
public final class PropertiesIOFactory {
    private PropertiesIOFactory() {}

    public static PropertiesReader reader(final File filename, final PropertiesSpecification specification) throws EvoalIOException {
        final String [] parts = filename.toString().split("\\.");
        final String extension = parts[parts.length - 1];
        final String name = extension + "-reader";

        return BeanFactory.create(name, PropertiesReader.class).init(filename, specification);
    }

    public static PropertiesWriter writer(final File filename, final PropertiesSpecification specification) throws EvoalIOException {
        final String [] parts = filename.toString().split("\\.");
        final String extension = parts[parts.length - 1];
        final String name = extension + "-writer";

        return BeanFactory.create(name, PropertiesWriter.class).init(filename, specification);
    }
}
