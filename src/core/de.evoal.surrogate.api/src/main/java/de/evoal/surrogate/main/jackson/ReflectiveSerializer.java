package de.evoal.surrogate.main.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import smile.math.matrix.Matrix;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReflectiveSerializer extends StdSerializer<Object> {
    protected ReflectiveSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(final Object o, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        if(o instanceof Double) {
            serializeDouble((Double) o, jsonGenerator);
        } else if(o instanceof Integer) {
            serializeInteger((Integer)o, jsonGenerator);
        } else if(o instanceof String) {
            serializeString((String)o, jsonGenerator);
        } else if(o instanceof double [][]) {
            serializeArray((double[][])o, jsonGenerator);
        } else if(o instanceof double []) {
            serializeArray((double[])o, jsonGenerator);
        } else if(o instanceof Matrix) {
            serializeArray((Matrix)o, jsonGenerator);
        } else if(o instanceof List) {
            serializeList((List<?>)o, jsonGenerator, serializerProvider);
        }  else if(o instanceof Map) {
            serializeMap((Map<String, ?>)o, jsonGenerator, serializerProvider);
        }
    }

    private void serializeDouble(final Double o, final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "double");
        jsonGenerator.writeNumberField("value", o);
        jsonGenerator.writeEndObject();
    }

    private void serializeInteger(final Integer o, final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "integer");
        jsonGenerator.writeNumberField("value", o);
        jsonGenerator.writeEndObject();
    }

    private void serializeString(final String o, final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "string");
        jsonGenerator.writeStringField("value", o);
        jsonGenerator.writeEndObject();
    }

    private void serializeArray(final double [] o, final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "array(double)");
        jsonGenerator.writeNumberField("size", o.length);
        jsonGenerator.writeFieldName("value");
        jsonGenerator.writeArray(o, 0, o.length);
        jsonGenerator.writeEndObject();
    }

    private void serializeArray(final double [][] o, final JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "array(array(double))");
        jsonGenerator.writeNumberField("size-1", o.length);
        jsonGenerator.writeNumberField("size-2", o.length == 0 ? 0 : o[0].length);
        jsonGenerator.writeFieldName("value");
        jsonGenerator.writeStartArray(o.length);
        for(int i = 0; i < o.length; ++i) {
            for(int j = 0; j < o[i].length; ++j) {
                jsonGenerator.writeNumber(o[i][j]);
            }
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void serializeArray(final Matrix o, final JsonGenerator jsonGenerator) throws IOException {
        final int nrows = o.nrows();
        final int ncols = o.ncols();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "matrix");

        jsonGenerator.writeNumberField("nrows", nrows);
        jsonGenerator.writeNumberField("ncols", ncols);
        jsonGenerator.writeFieldName("value");
        jsonGenerator.writeStartArray(nrows * ncols);
        for(int i = 0; i < nrows; ++i) {
            for(int j = 0; j < ncols; ++j) {
                jsonGenerator.writeNumber(o.get(i, j));
            }
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void serializeList(final List<?> list, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeStartArray();

        boolean first = true;
        for(final Object child : list) {
            serialize(child, generator, provider);
        }

        generator.writeEndArray();
    }

    private void serializeMap(final Map<String, ?> map, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeStartObject();

        boolean first = true;
        for(final Map.Entry<String, ?> child : map.entrySet()) {
            generator.writeFieldName(child.getKey());
            serialize(child.getValue(), generator, provider);
        }

        generator.writeEndObject();
    }
}
