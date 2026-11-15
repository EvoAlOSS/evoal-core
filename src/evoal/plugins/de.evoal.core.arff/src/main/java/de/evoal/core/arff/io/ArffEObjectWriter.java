package de.evoal.core.arff.io;

import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileOutputStream;

@Slf4j
@Dependent
@Named("arff-writer")
public class ArffEObjectWriter implements EObjectWriter {
    private FileOutputStream outputStream;

    @Override
    public EObjectWriter init(final File outputFile, final Space specification) throws EvoalIOException {
        return this;
    }

    @Override
    public void add(final TypedEObject object) throws EvoalIOException {

    }

    @Override
    public void close() throws Exception {
    }
}
