package de.evoal.surrogate.main.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import smile.math.matrix.Matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectiveDeserializer extends StdDeserializer<Object> {
    protected ReflectiveDeserializer() {
        super(Object.class);
    }

    @Override
    public Object deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        return readObject(parser);
    }

    private Object readObject(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);

        final JsonToken nextValue = parser.nextValue();
        assertFieldName(parser.getCurrentName(), "type");

        Object value = null;
        final String type = parser.getValueAsString();
        switch (type) {
            case "string":
                value = getStringValue(parser);
                break;

            case "double":
                value = getDoubleValue(parser);
                break;

            case "integer":
                value = getIntegerValue(parser);
                break;

            case "array(double)":
                value = getDoubleArrayValue(parser);
                break;

            case "array(array(double))":
                value = getDoubleArrayArrayValue(parser);
                break;

            case "matrix":
                value = getMatrixValue(parser);
                break;

            case "dict":
                value = getDictValue(parser);
                break;

            case "array":
                value = getArrayValue(parser);
                break;

            default:
                System.err.println("Unsupported type: " + type);
                throw new IllegalArgumentException();
        }

        while(!parser.hasToken(JsonToken.END_OBJECT)) {
            parser.nextToken();
        }

        return value;
    }

    private Object getDictValue(final JsonParser parser) throws IOException {
        final Map<String, Object> dict = new HashMap<>();

        parser.nextValue();
        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);

        while(!JsonToken.END_OBJECT.equals(parser.getCurrentToken())) {
            final String name = parser.getCurrentName();
            parser.nextToken();
            final Object value = readObject(parser);
            parser.nextToken();

            dict.put(name, value);
        }

        parser.nextToken();
        return dict;
    }

    private List<Object> getArrayValue(final JsonParser parser) throws IOException {
        final List<Object> result = new ArrayList<>();

        parser.nextValue();
        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);

        while(!JsonToken.END_ARRAY.equals(parser.getCurrentToken())) {
            final Object value = readObject(parser);
            parser.nextToken();

            result.add(value);
        }

        parser.nextToken();
        return result;
    }

    private Object getDoubleArrayValue(final JsonParser parser) throws IOException {
        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "size");
        final int size = parser.getValueAsInt();

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "value");

        //JsonToken tok = parser.nextToken();

        final double [] result = new double[size];
        for(int i = 0; i < size; ++i) {
            parser.nextValue();
            result[i] = parser.getValueAsDouble();
        }
        parser.nextToken();
        assertArrayEnd(parser);

        return result;
    }

    private Object getDoubleArrayArrayValue(final JsonParser parser) throws IOException {
        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "size-1");
        final int size1 = parser.getValueAsInt();

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "size-2");
        final int size2 = parser.getValueAsInt();

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "value");

        final double [][] result = new double[size1][size2];
        for(int i = 0; i < size1; ++i) {
            for(int j = 0; j < size2; ++j) {
                parser.nextValue();
                result[i][j] = parser.getValueAsDouble();
            }
        }
        parser.nextToken();
        assertArrayEnd(parser);

        return result;
    }

    private Object getMatrixValue(final JsonParser parser) throws IOException {
        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "nrows");
        final int nrows = parser.getValueAsInt();

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "ncols");
        final int ncols = parser.getValueAsInt();

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "value");

        parser.nextToken();

        final Matrix result = new Matrix(nrows, ncols);
        for(int i = 0; i < nrows; ++i) {
            for(int j = 0; j < ncols; ++j) {
                parser.nextValue();
                result.set(i, j, parser.getValueAsDouble());
            }
        }
        assertArrayEnd(parser);

        return result;
    }

    private void assertArrayStart(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);
    }

    private void assertArrayEnd(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.END_ARRAY);
    }

    private Object getStringValue(final JsonParser parser) throws IOException {
        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "value");

        return parser.getValueAsString();
    }

    private Object getDoubleValue(final JsonParser parser) throws IOException {
        final JsonToken nextValue = parser.nextValue();
        assertFieldName(parser.getCurrentName(), "value");

        return parser.getValueAsDouble();
    }

    private Object getIntegerValue(final JsonParser parser) throws IOException {
        final JsonToken nextValue = parser.nextValue();
        assertFieldName(parser.getCurrentName(), "value");

        return parser.getValueAsInt();
    }

    private void assertFieldName(final String actual, final String expected) {
        if(!expected.equals(actual)) {
            throw new IllegalStateException("Expected field name " + expected + " but got " + actual);
        }
    }

    private String getStringAndAdvance(final JsonParser parser) throws IOException {
        if(!JsonToken.VALUE_STRING.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + JsonToken.VALUE_STRING + " got " + parser.getCurrentToken());
        }

        final String value = parser.getText();

        parser.nextToken();

        return value;
    }

    private void assertFieldAndAdvance(final JsonParser parser, final String name) throws IOException {
        if(!JsonToken.FIELD_NAME.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + JsonToken.FIELD_NAME + " got " + parser.getCurrentToken());
        }

        if(!name.equals(parser.getText())) {
            throw new IllegalStateException("Expected field " + name + " got " + parser.getText());
        }

        parser.nextToken();
    }

    private void assertTokenTypeAndAdvance(final JsonParser parser, final JsonToken token) throws IOException {
        if(!token.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.getCurrentToken());
        }
        parser.nextToken();
    }
}
