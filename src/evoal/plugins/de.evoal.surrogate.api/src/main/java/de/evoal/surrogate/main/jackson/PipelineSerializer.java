package de.evoal.surrogate.main.jackson;

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
     * Writes the configuration of a pipeline step. Only the DL type is stored; attribute
     *   values are not stored (as before), so the {@code attributes} array stays empty. The
     *   type tag {@code instance} is kept for compatibility with existing PSON files.
     */
    private void serializeConfiguration(final EObject configuration, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "instance");
        generator.writeStringProperty("class-definition", DynamicEClassProvider.dlTypeOf(configuration));

        generator.writeName("attributes");
        generator.writeStartArray();
        generator.writeEndArray();

        generator.writeEndObject();
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
