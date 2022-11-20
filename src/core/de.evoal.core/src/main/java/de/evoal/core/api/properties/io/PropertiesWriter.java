package de.evoal.core.api.properties.io;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertySpecification;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PropertiesWriter implements AutoCloseable {
    private final FileOutputStream outputStream;
    private final JsonGenerator jsonGenerator;

    public PropertiesWriter(final File outputFile) throws IOException {
        outputStream = new FileOutputStream(outputFile);

        final ObjectMapper mapper = new ObjectMapper();
        jsonGenerator = mapper.createGenerator(outputStream);
        jsonGenerator.writeStartArray();
    }

    @SneakyThrows(IOException.class)
    public void addProperties(final Properties properties) {
        jsonGenerator.writeStartArray();
        for(final PropertySpecification spec : properties.getSpecification().getProperties()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", spec.name());
            jsonGenerator.writeNumberField("value", properties.get(spec));
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
