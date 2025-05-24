package de.evoal.core.main.ecore;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.Requirements;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
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

        specification.stream()
                     .forEach(f -> columnToFeature.put(f.getName(), f));

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

    private TypedEObject readEObject() throws IOException {
        assertStartArray();

        final TypedEObject result = specification.newEObject();
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

            if(columnToFeature.containsKey(name)) {
                result.eSet(columnToFeature.get(name), value);
            } else {
                log.debug("Skipping field {}.", name);
            }

        }

        assertEndArray();
        return result;
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
