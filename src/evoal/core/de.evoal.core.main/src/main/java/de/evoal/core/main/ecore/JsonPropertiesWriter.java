package de.evoal.core.main.ecore;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Dependent
@Named("json-eObject-writer")
public class JsonPropertiesWriter implements EObjectWriter {
    private FileOutputStream outputStream;
    private JsonGenerator jsonGenerator;

    @Override
    public EObjectWriter init(final File outputFile, final Space specification) throws EvoalIOException {
        try {
            outputStream = new FileOutputStream(outputFile);

            final ObjectMapper mapper = new ObjectMapper();
            jsonGenerator = mapper.createGenerator(outputStream);
            jsonGenerator.writeStartArray();
        } catch (final IOException e) {
            log.error("Failed to write {}.", outputFile, e);
            throw new EvoalIOException("Failed to write " + outputFile, e);
        }

        return this;
    }

    @Override
    public void add(final TypedEObject object) throws EvoalIOException {
        jsonGenerator.writeStartArray();
        for (final EStructuralFeature spec : object.eClass().getEAllStructuralFeatures()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringProperty("name", spec.getName());

            final Object value = object.eGet(spec);
            if (value instanceof Double || value instanceof Float) {
                jsonGenerator.writeNumberProperty("value", object.eGetAsDouble(spec));
            } else if (value instanceof Integer) {
                jsonGenerator.writeNumberProperty("value", object.eGetAsInteger(spec));
            } else if (value instanceof Boolean) {
                jsonGenerator.writeBooleanProperty("value", object.eGetAsBoolean(spec));
            } else if (value instanceof String) {
                jsonGenerator.writeStringProperty("value", object.eGetAsString(spec));
            }
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
    }

    @Override
    public void close() throws Exception {
        jsonGenerator.writeEndArray();
        jsonGenerator.close();
        outputStream.close();
    }
}
