package de.evoal.core.main.ecore;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
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

    /**
     * The features to write, in the order of the file.
     */
    private Space specification;

    /**
     * Opens the file for the features of {@code specification}: each object gets an entry per
     *   feature of the space, in the order of the space, like the CSV and ARFF writers (#357).
     */
    @Override
    public EObjectWriter init(final File outputFile, final Space specification) throws EvoalIOException {
        this.specification = specification;

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

    /**
     * Writes the features of the space as an array of {@code { "name": ..., "value": ... }}
     *   entries. A feature without a value (unset or {@code null}, e.g. a missing value of an
     *   ARFF file) has no entry, so reading the file leaves it unset again (#356).
     *
     * @throws EvoalIOException if a value is neither a number nor a boolean nor a string.
     */
    @Override
    public void add(final TypedEObject object) throws EvoalIOException {
        jsonGenerator.writeStartArray();
        for (final EStructuralFeature spec : specification) {
            final Object value = object.eIsSet(spec) ? object.eGet(spec) : null;
            if(value == null) {
                continue;
            }

            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringProperty("name", spec.getName());

            if (value instanceof Double || value instanceof Float) {
                jsonGenerator.writeNumberProperty("value", object.eGetAsDouble(spec));
            } else if (value instanceof Integer i) {
                jsonGenerator.writeNumberProperty("value", i);
            } else if (value instanceof Long l) {
                jsonGenerator.writeNumberProperty("value", l);
            } else if (value instanceof Boolean b) {
                jsonGenerator.writeBooleanProperty("value", b);
            } else if (value instanceof String s) {
                jsonGenerator.writeStringProperty("value", s);
            } else {
                throw new EvoalIOException("Cannot write the value of '" + spec.getName() + "' ("
                        + value.getClass().getSimpleName()
                        + ") to a JSON file: only numbers, booleans and strings can be written.");
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
