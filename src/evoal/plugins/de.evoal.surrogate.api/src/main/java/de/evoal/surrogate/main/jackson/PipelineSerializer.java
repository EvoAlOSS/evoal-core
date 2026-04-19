package de.evoal.surrogate.main.jackson;

import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.pipeline.*;
import lombok.extern.slf4j.Slf4j;
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

    private void serializeInstance(final Instance instance, final JsonGenerator generator, final SerializationContext provider) {
        generator.writeStartObject();
        generator.writeStringProperty("type", "instance");
        generator.writeStringProperty("class-definition", ((DefinitionModule)instance.getDefinition().eContainer()).getName() + "." + instance.getDefinition().getName());

        generator.writeName("attributes");
        generator.writeStartArray();

        for(final Attribute attr : instance.getAttributes()) {
            generator.writeStartObject();
            generator.writeName(attr.getDefinition().getName());
            generator.writeNull(); // TODO serialize(attr.getValue(), generator, provider);
            generator.writeEndObject();
        }

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
        serializeInstance(step.getInstance(), generator, provider);

        generator.writeEndObject();
    }

}
