package de.evoal.core.api.ecore.io;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.utils.EvoalIOException;

import java.io.File;

/**
 * Factory class for creating instances of {@code EObjectReader} and {@code EObjectWriter}.
 */
public final class EObjectIOFactory {
    private EObjectIOFactory() {}

    public static EObjectReader reader(final File filename, final Space specification) throws EvoalIOException {
        final String [] parts = filename.toString().split("\\.");
        final String extension = parts[parts.length - 1];
        final String name = extension + "-eObject-reader";

        return BeanFactory.create(name, EObjectReader.class).init(filename, specification);
    }

    public static EObjectWriter writer(final File filename, final Space specification) throws EvoalIOException {
        final String [] parts = filename.toString().split("\\.");
        final String extension = parts[parts.length - 1];
        final String name = extension + "-eObject-writer";

        return BeanFactory.create(name, EObjectWriter.class).init(filename, specification);
    }
}
