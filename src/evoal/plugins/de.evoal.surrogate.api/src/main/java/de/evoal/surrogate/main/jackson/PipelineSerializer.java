package de.evoal.surrogate.main.jackson;

import java.util.List;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.models.v202704.pipeline.*;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

@Slf4j
public class PipelineSerializer extends StdSerializer<PipelineDefinition> {
    public PipelineSerializer() {
        super(PipelineDefinition.class);
    }

    @Override
    public void serialize(final PipelineDefinition value, final JsonGenerator jsonGenerator, final SerializationContext serializerProvider) {
        serializePipelineDefinition(value, jsonGenerator, serializerProvider);
    }

    /**
     * Writes the configuration of a pipeline step: its DL type and the values of its
     *   attributes, e.g. the fitted parameters of a preparation step. A value is written as
     *   {@code value} (number, boolean, string or an array of them) or as {@code data} (the
     *   names of features). The type tag {@code instance} is kept for compatibility with
     *   existing PSON files.
     *
     * @throws IllegalStateException if an attribute has a value that cannot be stored, e.g. an
     *   instance.
     */
    private void serializeConfiguration(final EObject configuration, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "instance");
        generator.writeStringProperty("class-definition", DynamicEClassProvider.dlTypeOf(configuration));
        generator.writeName("attributes");
        generator.writeStartArray();
        for(final EStructuralFeature attribute : configuration.eClass().getEAllStructuralFeatures()) {
            final Object value = configuration.eGet(attribute);
            // only the attributes of the DL type, not the features of generated super classes
            if(value == null || attribute.getEContainingClass().getInstanceClass() != null) {
                continue;
            }

            generator.writeStartObject();
            generator.writeStringProperty("name", attribute.getName());
            final List<?> values = value instanceof List<?> list ? list : List.of(value);
            final boolean data = !values.isEmpty() && values.stream().allMatch(EStructuralFeature.class::isInstance);
            generator.writeName(data ? "data" : "value");
            if(value instanceof List<?>) {
                generator.writeStartArray();
                values.forEach(v -> writeValue(configuration, attribute, v, generator));
                generator.writeEndArray();
            } else {
                writeValue(configuration, attribute, value, generator);
            }
            generator.writeEndObject();
        }
        generator.writeEndArray();
        generator.writeEndObject();
    }

    private static void writeValue(final EObject configuration, final EStructuralFeature attribute, final Object value, final JsonGenerator generator) {
        switch(value) {
            case EStructuralFeature feature -> generator.writeString(feature.getName());
            case Boolean bool -> generator.writeBoolean(bool);
            case Integer number -> generator.writeNumber(number);
            case Long number -> generator.writeNumber(number);
            case Number number -> generator.writeNumber(number.doubleValue());
            case String string -> generator.writeString(string);
            default -> throw new IllegalStateException("The attribute '" + attribute.getName() + "' of '"
                                                       + DynamicEClassProvider.dlTypeOf(configuration)
                                                       + "' cannot be stored in the model file: its value is a " + value.getClass().getSimpleName() + ".");
        }
    }

    private void serializePipelineDefinition(final PipelineDefinition definition, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "pipeline-definition");
        generator.writeStringProperty("name", definition.getName());

        generator.writeName("steps");
        generator.writeStartArray();

        for(final Step step : definition.getSteps()) {
            if(step instanceof ConcreteStep concrete) {
                serializeConcreteStep(concrete, generator, provider);
            } else if(step instanceof PipelineStep pipeline) {
                serializePipelineStep(pipeline, generator, provider);
            }
        }
        generator.writeEndArray();
        generator.writeEndObject();
    }

    private void serializePipelineStep(final PipelineStep step, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "pipeline-step");
        generator.writeName("definition");
        serialize(step.getDefinition(), generator, provider);

        generator.writeEndObject();
    }

    private void serializeConcreteStep(final ConcreteStep step, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "concrete-step");

        generator.writeName("reads");
        generator.writeStartArray();
        for(final EStructuralFeature feature : step.getReads()) {
            generator.writeString(feature.getName());
        }
        generator.writeEndArray();

        generator.writeName("writes");
        generator.writeStartArray();
        for(final EStructuralFeature feature : step.getWrites()) {
            generator.writeString(feature.getName());
        }
        generator.writeEndArray();

        generator.writeName("configuration");
        serializeConfiguration(step.getConfiguration(), generator, provider);

        generator.writeEndObject();
    }

}
