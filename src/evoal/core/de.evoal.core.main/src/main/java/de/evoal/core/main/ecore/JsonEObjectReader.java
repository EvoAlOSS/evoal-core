package de.evoal.core.main.ecore;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Dependent
@Named("json-eObject-reader")
public class JsonEObjectReader implements EObjectReader {

    /**
     * Maps the name of a feature to the feature itself.
     */
    private final Map<String, EStructuralFeature> columnToFeature = new HashMap<>();

    /**
     * For parsing a JSON file.
     */
    private JsonParser jsonParser;

    /**
     * The values that should be written to the JSON file.
     */
    private Space specification;

    @Override
    public EObjectReader init(final File inputFile, final Space specification) throws EvoalIOException {
        log.info("Creating JSON EObject reader for {}.", specification);
        this.specification = specification;

        specification.forEach(f -> columnToFeature.put(f.getName(), f));

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

    /**
     * Reads one object. A feature without an entry, or whose entry has no value or the value
     *   {@code null}, stays unset: it has no value (#356).
     */
    private TypedEObject readEObject() throws IOException {
        assertStartArray();

        final TypedEObject result = specification.newEObject();
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
                        value = jsonParser.getNumberValue();
                    } else if(token != JsonToken.VALUE_NULL) {
                        throw new RuntimeException("Unsupported token type " + token);
                    }
                }
            }
            assertEndObject();

            if(value == null) {
                log.debug("Field {} has no value.", name);
            } else if(columnToFeature.containsKey(name)) {
                final EStructuralFeature feature = columnToFeature.get(name);
                result.eSet(feature, integral(feature, value));
            } else {
                log.debug("Skipping field {}.", name);
            }

        }

        assertEndArray();
        return result;
    }

    /**
     * Converts a number for an {@code int} or {@code long} feature to the feature's type, so a
     *   {@code long} value is read back as a {@code long} (#357). Other values are returned
     *   unchanged.
     *
     * @throws IllegalArgumentException if the number does not fit into the feature's type.
     */
    private static Object integral(final EStructuralFeature feature, final Object value) {
        final Class<?> type = feature.getEType().getInstanceClass();

        try {
            if(type == long.class || type == Long.class) {
                return NumericConversions.toLong(value);
            } else if(type == int.class || type == Integer.class) {
                return NumericConversions.toInteger(value);
            }
        } catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid value of feature '" + feature.getName() + "': " + e.getMessage(), e);
        }

        return value;
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
    public TypedEObject next() {
        return readEObject();
    }
}
