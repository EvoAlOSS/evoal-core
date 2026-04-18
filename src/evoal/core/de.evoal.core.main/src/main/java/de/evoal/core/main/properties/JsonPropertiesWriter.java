package de.evoal.core.main.properties;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Dependent
@Named("json-writer")
public class JsonPropertiesWriter implements PropertiesWriter {
    private FileOutputStream outputStream;
    private JsonGenerator jsonGenerator;

    @Override
    public PropertiesWriter init(final File outputFile, final PropertiesSpecification specification) throws EvoalIOException {
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
    public void add(final Properties properties) throws EvoalIOException {
        jsonGenerator.writeStartArray();
        for (final PropertySpecification spec : properties.getSpecification().getProperties()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringProperty("name", spec.name());

            final Object value = properties.get(spec);
            if (value instanceof Double || value instanceof Float) {
                jsonGenerator.writeNumberProperty("value", ((Number) properties.get(spec)).doubleValue());
            } else if (value instanceof Integer) {
                jsonGenerator.writeNumberProperty("value", ((Number) properties.get(spec)).longValue());
            } else if (value instanceof Boolean) {
                jsonGenerator.writeBooleanProperty("value", (Boolean) properties.get(spec));
            } else if (value instanceof String) {
                jsonGenerator.writeStringProperty("value", (String) properties.get(spec));
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
