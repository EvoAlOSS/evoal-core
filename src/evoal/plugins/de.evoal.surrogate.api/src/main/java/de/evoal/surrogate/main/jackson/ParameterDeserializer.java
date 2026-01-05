package de.evoal.surrogate.main.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.Requirements;
import de.evoal.surrogate.api.io.pson.Parameter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.tensor.DenseMatrix;
import smile.tensor.ScalarType;

import java.io.IOException;
import java.util.*;

@Slf4j
public class ParameterDeserializer extends StdDeserializer<Parameter> {
    @Setter
    private Space sourceSpace = null;

    @Setter
    private Space targetSpace = null;

    private int indentation = 1;

    public ParameterDeserializer() {
        super(Parameter.class);
    }

    @Override
    public Parameter deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        log.debug("Deserializing parameter");
        final Runnable checker = objectBalanceChecker(parser);

        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);

        // read name of parameter
        assertFieldNameAndAdvance(parser, "name");
        final String name = readStringValueAndAdvance(parser);
        log.debug(" deserializing parameter: '{}'", name);

        // read value of parameter
        assertFieldNameAndAdvance(parser, "value");
        final Object value = parseValue(parser);

        // check if we read everything correct
        assertTokenType(parser, JsonToken.END_OBJECT);
        nestingLevel -= 1; // we cannot advance (otherwise Jackson breaks).
        // // Thus, we have to undo one indentation manually

        log.debug("Deserialized parameter");
        checker.run();

        // create parameter
        return Parameter.builder().name(name).value(value).build();
    }

    private Object parseValue(final JsonParser parser) throws IOException {
        log.debug(" parsing value");

        Object result = null;
        if(JsonToken.START_ARRAY.equals(parser.getCurrentToken())) {
            log.debug("{} found start of array, switching to read a list.", " ".repeat(indentation));

            result = parseListValue(parser);
        } else if(JsonToken.START_OBJECT.equals(parser.getCurrentToken())) {
            log.debug("{} found start of object, switching to reading an object.", " ".repeat(indentation));
            result = parseObject(parser);
        }

        log.debug(" parsed value");
        return result;
    }

    private Object parseObject(final JsonParser parser) throws IOException {
        log.debug("{}parsing object", " ".repeat(indentation * 2));
        final Runnable checker = objectBalanceChecker(parser);

        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);
        assertFieldNameAndAdvance(parser, "type");

        final String type = readStringValueAndAdvance(parser);
        final JsonToken next = parser.currentToken();

        log.debug("{}  found type {} --> {}.", " ".repeat(indentation * 2), type, next);

        indentation += 1;
        final Object value = switch (type) {
            case "array" -> getArrayValue(parser);
            case "array(array(double))" -> getDoubleArrayArrayValue(parser);
            case "array(double)" -> getDoubleArrayValue(parser);
            case "boolean" -> parseBooleanValue(parser);
            case "dict" -> parseDictValue(parser);
            case "double" -> parseDoubleValue(parser);
            case "integer" -> parseIntegerValue(parser);
            case "matrix" -> getMatrixValue(parser);
            case "object-pair" -> getObjectPair(parser);
            case "string" -> parseStringValue(parser);
            default -> {
                log.error("{}... stored type '{}' is not supported.", " ".repeat(indentation * 2), type);
                throw new IllegalArgumentException();
            }
        };
        indentation -= 1;

        assertTokenTypeAndAdvance(parser, JsonToken.END_OBJECT);
        checker.run();
        log.debug("{}... read object", " ".repeat(indentation * 2));
        return value;
    }

    private Object parseDictValue(final JsonParser parser) throws IOException {
        final Map<String, Object> dict = new HashMap<>();

        while(!JsonToken.END_OBJECT.equals(parser.getCurrentToken())) {
            final String name = parser.getCurrentName();
            advance(parser); // go to value of entry

            final Object value = parseObject(parser);
            dict.put(name, value);
        }

        return dict;
    }

    private List<Object> parseListValue(final JsonParser parser) throws IOException {
        final List<Object> result = new ArrayList<>();

        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);

        while(!JsonToken.END_ARRAY.equals(parser.getCurrentToken())) {
            final Object value = parseObject(parser);
            result.add(value);
        }

        assertTokenTypeAndAdvance(parser, JsonToken.END_ARRAY);

        return result;
    }

    private List<Object> getArrayValue(final JsonParser parser) throws IOException {
        final List<Object> result = new ArrayList<>();

        advance(parser);
        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);

        while(!JsonToken.END_ARRAY.equals(parser.getCurrentToken())) {
            final Object value = parseObject(parser);
            advance(parser);

            result.add(value);
        }

        advance(parser);
        return result;
    }

    private Object getDoubleArrayValue(final JsonParser parser) throws IOException {
        assertFieldNameAndAdvance(parser, "size");
        final int size = parser.getValueAsInt();
        advance(parser);

        assertFieldNameAndAdvance(parser, "value");

        final double [] result = new double[size];
        for(int i = 0; i < size; ++i) {
            advance(parser);
            result[i] = parser.getValueAsDouble();
        }
        advance(parser);
        assertArrayEnd(parser);

        return result;
    }

    private Object getDoubleArrayArrayValue(final JsonParser parser) throws IOException {
        assertFieldNameAndAdvance(parser, "size-1");
        final int size1 = parser.getValueAsInt();
        advance(parser);

        assertFieldNameAndAdvance(parser, "size-2");
        final int size2 = parser.getValueAsInt();
        advance(parser);

        assertFieldNameAndAdvance(parser, "value");

        final double [][] result = new double[size1][size2];
        for(int i = 0; i < size1; ++i) {
            for(int j = 0; j < size2; ++j) {
                advance(parser);
                result[i][j] = parser.getValueAsDouble();
            }
        }

        advance(parser);
        assertArrayEnd(parser);

        return result;
    }

    private Object getMatrixValue(final JsonParser parser) throws IOException {
        advance(parser);
        assertFieldName(parser, "nrows");
        final int nrows = parser.getValueAsInt();

        advance(parser);
        assertFieldName(parser, "ncols");
        final int ncols = parser.getValueAsInt();

        advance(parser);
        assertFieldName(parser, "value");

        advance(parser);

        final DenseMatrix result = DenseMatrix.zeros(ScalarType.Float64, nrows, ncols);
        for(int i = 0; i < nrows; ++i) {
            for(int j = 0; j < ncols; ++j) {
                advance(parser);
                result.set(i, j, parser.getValueAsDouble());
            }
        }
        assertArrayEnd(parser);

        return result;
    }

    private EObjectPair getObjectPair(final JsonParser parser) throws IOException {
        Requirements.requireNotNull(sourceSpace);
        Requirements.requireNotNull(targetSpace);

        final TypedEObject result = sourceSpace.merge(targetSpace).newEObject();

        // assert source
        assertFieldNameAndAdvance(parser, "source");
        parseEObject(parser, sourceSpace, result);

        // assert target
        assertFieldNameAndAdvance(parser, "target");
        parseEObject(parser, targetSpace, result);

        return new EObjectPair(result, result);
    }

    private void parseEObject(final JsonParser parser, final Space space, final TypedEObject object) throws IOException {
        log.info("Reading typed EObject");

        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);

        while(!JsonToken.END_OBJECT.equals(parser.getCurrentToken())) {
            parseEObjectDimension(parser, space, object);
        }

        assertTokenTypeAndAdvance(parser, JsonToken.END_OBJECT);
    }

    private void parseEObjectDimension(final JsonParser parser, final Space space, final TypedEObject result) throws IOException {
        log.info("Reading dimension: {}", parser.getCurrentToken());

        final String attributeName = parser.getCurrentName();
        advance(parser); // go to value of dimension

        final Object value = parseObject(parser);
        final Optional<EStructuralFeature> feature = space
                .stream()
                .filter(f -> attributeName.equals(f.getName()))
                .findFirst();

        if(feature.isEmpty()) {
            log.warn("No suitable EStructuralFeature found for {}", attributeName);
            log.warn("  feature space is: {}", space);
        } else {
            log.info("Suitable EStructuralFeature found for {}", attributeName);
            feature.ifPresent(f -> result.eSet(f, value));
        }
    }


    private Object parseStringValue(final JsonParser parser) throws IOException {
        assertFieldNameAndAdvance(parser, "value");

        final String result = parser.getValueAsString();

        advance(parser);

        return result;
    }

    private Boolean parseBooleanValue(final JsonParser parser) throws IOException {
        assertFieldNameAndAdvance(parser, "value");

        final Boolean result = parser.getValueAsBoolean();

        advance(parser);

        return result;
    }


    private Object parseDoubleValue(final JsonParser parser) throws IOException {
        assertFieldNameAndAdvance(parser, "value");

        final Double result = parser.getValueAsDouble();

        advance(parser);

        return result;
    }

    private Integer parseIntegerValue(final JsonParser parser) throws IOException {
        assertFieldNameAndAdvance(parser, "value");

        final Integer result = parser.getValueAsInt();

        advance(parser);

        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /// Reading values

    private String readStringValueAndAdvance(final JsonParser parser) throws IOException {
        assertTokenType(parser, JsonToken.VALUE_STRING);

        final String value = parser.readValueAs(String.class);

        advance(parser);

        return value;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /// Checking object balance

    private int nestingLevel = 0;
    private Runnable objectBalanceChecker(final JsonParser parser) throws IOException {
        Requirements.requireTrue(JsonToken.START_OBJECT.equals(parser.getCurrentToken()), parser.getCurrentToken().toString());
        final int expectedLevel = nestingLevel;

        log.debug("{} creating checker @{}", " ".repeat(nestingLevel), expectedLevel);

        return () -> {
            log.debug("{} executing checker @{} (was {}).", " ".repeat(nestingLevel), nestingLevel, expectedLevel);
            if(nestingLevel != expectedLevel) {
                throw new IllegalStateException("Nesting level does not match: " +  (nestingLevel - expectedLevel));
            }
        };
    }


    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    /// Asserting and advancing tokens

    private void assertArrayStart(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);
    }

    private void assertArrayEnd(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.END_ARRAY);
    }

    private void assertFieldName(final JsonParser parser, final String expectedName) throws IOException {
        final JsonToken actual = parser.getCurrentToken();

        if(!JsonToken.FIELD_NAME.equals(actual)) {
            throw new IllegalStateException("Expected field name but token is: " + actual);
        }

        final String actualName = parser.getCurrentName();
        if(!expectedName.equals(actualName)) {
            throw new IllegalStateException("Expected field name '" + expectedName + "' but got '" + actualName + "'");
        }
    }

    private void assertFieldNameAndAdvance(final JsonParser parser, final String name) throws IOException {
        if(!JsonToken.FIELD_NAME.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + JsonToken.FIELD_NAME + " got " + parser.getCurrentToken());
        }

        if(!name.equals(parser.getText())) {
            throw new IllegalStateException("Expected field " + name + " got " + parser.getText());
        }

       advance(parser);
    }

    private void assertTokenType(final JsonParser parser, final JsonToken token) throws IOException {
        if(!token.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.getCurrentToken());
        }
    }

    private void assertTokenTypeAndAdvance(final JsonParser parser, final JsonToken token) throws IOException {
        if(!token.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.getCurrentToken());
        }

        advance(parser);
    }

    private JsonToken advance(final JsonParser parser) throws IOException {
        final JsonToken current = parser.getCurrentToken();
        final String currentTokenInfo = tokenInfo(parser);

        final JsonToken next = parser.nextToken();
        final String nextTokenInfo = tokenInfo(parser);

        log.debug("{}  Advancing to {} from {}.", " ".repeat(indentation * 2), nextTokenInfo, currentTokenInfo);

        if(JsonToken.START_OBJECT.equals(current)) {
            nestingLevel++;
            log.info("{}   changed nesting level to (+1): {}", " ".repeat(indentation * 2), nestingLevel);
        } else if(JsonToken.END_OBJECT.equals(current)) {
            nestingLevel--;
            log.info("{}   changed nesting level to (-1): {}", " ".repeat(indentation * 2), nestingLevel);
        }

        return next;
    }

    private String tokenInfo(final JsonParser parser) throws IOException {
        final JsonToken current = parser.currentToken();

        if(current == null) { return "<none>"; }
        String info = current.toString();

        if(JsonToken.FIELD_NAME.equals(current)) {
            info += " (" + parser.getCurrentName() + ")";
        } else if(JsonToken.VALUE_STRING.equals(current)) {
            info += " (" + parser.getValueAsString() + ")";
        } else if(JsonToken.VALUE_NUMBER_INT.equals(current)) {
            info += ": (" + parser.getValueAsInt() + ")";
        } else if(JsonToken.VALUE_NUMBER_FLOAT.equals(current)) {
            info += ": (" + parser.getValueAsDouble() + ")";
        }

        info += " @" + parser.getTokenLocation();

        return info;
    }
}
