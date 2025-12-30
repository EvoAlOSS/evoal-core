package de.evoal.core.arff.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileOutputStream;

@Slf4j
@Dependent
@Named("arff-writer")
public class ArffPropertiesWriter implements PropertiesWriter {
    private FileOutputStream outputStream;

    @Override
    public PropertiesWriter init(final File outputFile, final PropertiesSpecification specification) throws EvoalIOException {

        return this;
    }

    @Override
    public void add(final Properties properties) throws EvoalIOException {

    }

    @Override
    public void close() throws Exception {
    }
}
