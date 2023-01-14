package de.evoal.core.api.properties.io;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.Requirements;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
public class PropertiesReader implements AutoCloseable, Iterator<Properties> {

    private final JsonParser jsonParser;

    private final Set<String> properties;

    private final PropertiesSpecification specification;

    public PropertiesReader(final File inputFile, final PropertiesSpecification specification) throws IOException {
        log.info("Creating properties reader for {}.", specification);
        this.specification = specification;

        properties = specification.getProperties()
                                  .stream()
                                  .map(PropertySpecification::name)
                                  .collect(Collectors.toSet());

        final ObjectMapper mapper = new ObjectMapper();
        jsonParser = mapper.createParser(inputFile);
        jsonParser.nextToken();
        assertStartArray();
    }

    private Properties readProperties() throws IOException {
        assertStartArray();

        final Map<String, Object> entries = new TreeMap<>();
        while(!JsonToken.END_ARRAY.equals(jsonParser.currentToken())) {
            Requirements.requireEqual(jsonParser.currentToken(), JsonToken.START_OBJECT);

            String name = null;
            Object value = null;

            while(!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                final String fieldName = jsonParser.nextFieldName();

                if("name".equals(fieldName)) {
                    name = jsonParser.nextTextValue();
                } else if("value".equals(fieldName)) {
                    final JsonToken token = jsonParser.nextValue();

                    if(token == JsonToken.VALUE_NUMBER_FLOAT) {
                        value = jsonParser.getDoubleValue();
                    } else if(token == JsonToken.VALUE_STRING) {
                        value = jsonParser.getValueAsString();
                    } else if(token == JsonToken.VALUE_FALSE) {
                        value = false;
                    } else if(token == JsonToken.VALUE_TRUE) {
                        value = true;
                    } else if(token == JsonToken.VALUE_NUMBER_INT) {
                        value = jsonParser.getValueAsInt();
                    } else {
                        throw new RuntimeException("Unsupported token type " + token);
                    }
                }
            }
            assertEndObject();

            entries.put(name, value);
        }

        assertEndArray();

        try {
            final PropertiesSpecification spec =
                    PropertiesSpecification.builder()
                                           .add(entries.keySet()
                                                       .stream()
                                                       .filter(properties::contains)
                                                       .map(specification::find)
                                                       .map(PropertySpecification::type)
                                               )
                                           .build();

            return new Properties(spec).putAll(entries);
        } catch(final NullPointerException e) {
            log.error("Failed to read properties file entry {} for specification {}.", entries, specification);

            entries.keySet()
                    .stream()
                    .filter(k -> !properties.contains(k))
                    .forEach(n -> System.err.println("There is no properties specification for " + n));
            throw e;
        }
    }

    private void assertEndArray() throws IOException {
        Requirements.requireEqual(jsonParser.currentToken(), JsonToken.END_ARRAY);
        jsonParser.nextToken();
    }


    private void assertEndObject() throws IOException {
        Requirements.requireEqual(jsonParser.currentToken(), JsonToken.END_OBJECT);
        jsonParser.nextToken();
    }


    private void assertStartArray() throws IOException {
        Requirements.requireEqual(jsonParser.currentToken(), JsonToken.START_ARRAY);
        jsonParser.nextToken();
    }

    private void assertStartObject() throws IOException {
        Requirements.requireEqual(jsonParser.currentToken(), JsonToken.START_OBJECT);
        jsonParser.nextToken();
    }

    @Override
    public void close() throws Exception {
        jsonParser.close();
    }

    @Override
    public boolean hasNext() {
        return !JsonToken.END_ARRAY.equals(jsonParser.currentToken());
    }

    @Override
    @SneakyThrows(IOException.class)
    public Properties next() {
        return readProperties();
    }
}
