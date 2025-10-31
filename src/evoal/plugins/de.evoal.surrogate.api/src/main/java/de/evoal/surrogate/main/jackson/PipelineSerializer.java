package de.evoal.surrogate.main.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.pipeline.*;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;

@Slf4j
public class PipelineSerializer extends StdSerializer<PipelineDefinition> {
    public PipelineSerializer() {
        super(PipelineDefinition.class);
    }

    @Override
    public void serialize(final PipelineDefinition value, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        serializePipelineDefinition(value, jsonGenerator, serializerProvider);
    }

    private void serializeInstance(final Instance instance, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", "instance");
        generator.writeStringField("class-definition", ((DefinitionModule)instance.getDefinition().eContainer()).getName() + "." + instance.getDefinition().getName());

        generator.writeFieldName("attributes");
        generator.writeStartArray();

        for(final Attribute attr : instance.getAttributes()) {
            generator.writeStartObject();
            generator.writeFieldName(attr.getDefinition().getName());
            generator.writeNull(); // TODO serialize(attr.getValue(), generator, provider);
            generator.writeEndObject();
        }

        generator.writeEndArray();
        generator.writeEndObject();
    }

    private void serializePipelineDefinition(final PipelineDefinition definition, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", "pipeline-definition");
        generator.writeStringField("name", definition.getName());

        generator.writeFieldName("steps");
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

    private void serializePipelineStep(final PipelineStep step, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", "pipeline-step");
        generator.writeFieldName("definition");
        serialize(step.getDefinition(), generator, provider);

        generator.writeEndObject();
    }

    private void serializeConcreteStep(final ConcreteStep step, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("type", "concrete-step");

        generator.writeFieldName("reads");
        generator.writeStartArray();
        for(final EStructuralFeature feature : step.getReads()) {
            generator.writeString(feature.getName());
        }
        generator.writeEndArray();

        generator.writeFieldName("writes");
        generator.writeStartArray();
        for(final EStructuralFeature feature : step.getWrites()) {
            generator.writeString(feature.getName());
        }
        generator.writeEndArray();

        generator.writeFieldName("configuration");
        serializeInstance(step.getInstance(), generator, provider);

        generator.writeEndObject();
    }

}
