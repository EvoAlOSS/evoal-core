package de.evoal.surrogate.main.jackson;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.surrogate.api.io.pson.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.tensor.Matrix;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class ParameterSerializer extends StdSerializer<Parameter> {
    public ParameterSerializer() {
        super(Parameter.class);
    }

    @Override
    public void serialize(final Parameter parameter, final JsonGenerator jsonGenerator, final SerializationContext serializerProvider) {
        log.info("Serializing parameter: " + parameter.getName());
        jsonGenerator.writeStartObject();

        jsonGenerator.writeName("name");
        jsonGenerator.writeString(parameter.getName());
        jsonGenerator.writeName("value");

        serializeValue(parameter.getValue(), jsonGenerator, serializerProvider);
        jsonGenerator.writeEndObject();
        log.info("Serialized parameter: " + parameter.getName());
    }

    private void serializeValue(final Object o, final JsonGenerator jsonGenerator, final SerializationContext serializerProvider) {
        if(o instanceof Boolean b) {
            serializeBoolean(b, jsonGenerator);
        } else if(o instanceof Double d) {
            serializeDouble(d, jsonGenerator);
        } else if(o instanceof Integer i) {
            serializeInteger(i, jsonGenerator);
        } else if(o instanceof String s) {
            serializeString(s, jsonGenerator);
        } else if(o instanceof double [][] array) {
            serializeArray(array, jsonGenerator);
        } else if(o instanceof double [] array) {
            serializeArray(array, jsonGenerator);
        } else if(o instanceof Matrix matrix) {
            serializeArray(matrix, jsonGenerator);
        } else if(o instanceof List<?> list) {
            serializeList(list, jsonGenerator, serializerProvider);
        }  else if(o instanceof Map<?, ?> map) {
            serializeDict((Map<String, ?>)map, jsonGenerator, serializerProvider);
        } else if(o instanceof EObjectPair pair) {
            serializePair(pair, jsonGenerator, serializerProvider);
        } else if(o instanceof TypedEObject object) {
            serializeObject(object, jsonGenerator, serializerProvider);
        }
    }

    private void serializeBoolean(final boolean o, final JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "boolean");
        jsonGenerator.writeBooleanProperty("value", o);
        jsonGenerator.writeEndObject();
    }


    private void serializeDouble(final Double o, final JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "double");
        jsonGenerator.writeNumberProperty("value", o);
        jsonGenerator.writeEndObject();
    }

    private void serializeInteger(final Integer o, final JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "integer");
        jsonGenerator.writeNumberProperty("value", o);
        jsonGenerator.writeEndObject();
    }

    private void serializePair(final EObjectPair pair, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "object-pair");
        generator.writeName("source");
        serializeValue(pair.getFirst(), generator, provider);
        generator.writeName("target");
        serializeValue(pair.getSecond(), generator, provider);
        generator.writeEndObject();
    }

    private void serializeObject(final TypedEObject object, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        for(final EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
            generator.writeName(feature.getName());
            serializeValue(object.eGet(feature), generator, provider);
        }
        generator.writeEndObject();
    }

    private void serializeString(final String o, final JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "string");
        jsonGenerator.writeStringProperty("value", o);
        jsonGenerator.writeEndObject();
    }

    private void serializeArray(final double [] o, final JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "array(double)");
        jsonGenerator.writeNumberProperty("size", o.length);
        jsonGenerator.writeName("value");
        jsonGenerator.writeArray(o, 0, o.length);
        jsonGenerator.writeEndObject();
    }

    private void serializeArray(final double [][] o, final JsonGenerator jsonGenerator) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "array(array(double))");
        jsonGenerator.writeNumberProperty("size-1", o.length);
        jsonGenerator.writeNumberProperty("size-2", o.length == 0 ? 0 : o[0].length);
        jsonGenerator.writeName("value");
        jsonGenerator.writeStartArray(o.length);
        for(int i = 0; i < o.length; ++i) {
            for(int j = 0; j < o[i].length; ++j) {
                jsonGenerator.writeNumber(o[i][j]);
            }
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void serializeArray(final Matrix o, final JsonGenerator jsonGenerator) {
        final int nrows = o.nrow();
        final int ncols = o.ncol();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringProperty("type", "matrix");

        jsonGenerator.writeNumberProperty("nrows", nrows);
        jsonGenerator.writeNumberProperty("ncols", ncols);
        jsonGenerator.writeName("value");
        jsonGenerator.writeStartArray(nrows * ncols);
        for(int i = 0; i < nrows; ++i) {
            for(int j = 0; j < ncols; ++j) {
                jsonGenerator.writeNumber(o.get(i, j));
            }
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void serializeList(final List<?> list, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartArray();

        for(final Object child : list) {
            serializeValue(child, generator, provider);
        }

        generator.writeEndArray();
    }

    private void serializeDict(final Map<String, ?> map, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "dict");

        for(final Map.Entry<String, ?> child : map.entrySet()) {
            generator.writeName(child.getKey());
            serializeValue(child.getValue(), generator, provider);
        }

        generator.writeEndObject();
    }
}
