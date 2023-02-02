package de.evoal.core.main.properties;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
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
        try {
            jsonGenerator.writeStartArray();
            for (final PropertySpecification spec : properties.getSpecification().getProperties()) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeStringField("name", spec.name());

                final Object value = properties.get(spec);
                if (value instanceof Double || value instanceof Float) {
                    jsonGenerator.writeNumberField("value", ((Number) properties.get(spec)).doubleValue());
                } else if (value instanceof Integer) {
                    jsonGenerator.writeNumberField("value", ((Number) properties.get(spec)).longValue());
                } else if (value instanceof Boolean) {
                    jsonGenerator.writeBooleanField("value", (Boolean) properties.get(spec));
                } else if (value instanceof String) {
                    jsonGenerator.writeStringField("value", (String) properties.get(spec));
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        } catch(final IOException e) {
            log.error("Failure while writing properties.", e);
            throw new EvoalIOException("Failure while writing properties.", e);
        }
    }

    @Override
    public void close() throws Exception {
        jsonGenerator.writeEndArray();
        jsonGenerator.close();
        outputStream.close();
    }
}
