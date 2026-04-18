package de.evoal.core.main.properties;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.io.PropertiesReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.Requirements;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Slf4j
@Dependent
@Named("json-reader")
public class JsonPropertiesReader implements PropertiesReader {

    private JsonParser jsonParser;

    private Set<String> properties;

    private PropertiesSpecification specification;

    @Override
    public PropertiesReader init(final File inputFile, final PropertiesSpecification specification) throws EvoalIOException {
        log.info("Creating JSON properties reader for {}.", specification);
        this.specification = specification;

        properties = specification.getProperties()
                                  .stream()
                                  .map(PropertySpecification::name)
                                  .collect(Collectors.toSet());

        try {
            final ObjectMapper mapper = new ObjectMapper();
            jsonParser = mapper.createParser(inputFile);
            jsonParser.nextToken();
            assertStartArray();
        } catch (final IOException e) {
            log.error("Failed to read JSON file {}.", inputFile, e);
            throw new EvoalIOException("Failure while reading " + inputFile, e);
        }

        return this;
    }

    private Properties readProperties() throws IOException {
        assertStartArray();

        final Map<String, Object> entries = new TreeMap<>();
        while(!JsonToken.END_ARRAY.equals(jsonParser.currentToken())) {
            Requirements.requireEqual(jsonParser.currentToken(), JsonToken.START_OBJECT);

            String name = null;
            Object value = null;

            while(!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                final String fieldName = jsonParser.nextName();

                if("name".equals(fieldName)) {
                    name = jsonParser.nextStringValue();
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
