package de.evoal.surrogate.main.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.pipeline.*;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PipelineDeserializer extends StdDeserializer<PipelineDefinition> {
    /**
     * For loading definition modules.
     */
    private final DefinitionModuleLoader loader;

    /**
     * The space to use.
     */
    private final @NonNull Space space;

    public PipelineDeserializer(final @NonNull DefinitionModuleLoader loader, final @NonNull Space space) {
        super(Object.class);

        this.loader = loader;
        this.space = space;
    }

    @Override
    public PipelineDefinition deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
        return (PipelineDefinition)readObject(parser, false);
    }

    private Object readObject(final JsonParser parser, final boolean advance) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "type");

        final String type = parser.getValueAsString();
        log.info("Reading object with type entry: '{}'.", type);

        final Object value = switch (type) {
            case "pipeline-definition" -> getPipelineDefinition(parser);
            case "pipeline-step" -> getPipelineStep(parser);
            case "concrete-step" -> getConcreteStep(parser);
            case "instance" -> getInstance(parser);

            default -> {
                System.err.println("Unsupported type: " + type);
                throw new IllegalArgumentException();
            }
        };

        if(advance) {
            assertTokenTypeAndAdvance(parser, JsonToken.END_OBJECT);
        } else {
            assertTokenType(parser, JsonToken.END_OBJECT);
        }

        //log.info(
        //        "Finished object with type entry: '{}' -- {}.",
        //        type,
        //        parser.getCurrentToken().name());

        return value;
    }

    private PipelineDefinition getPipelineDefinition(final JsonParser parser) throws IOException {
//        log.info("[PD{}] Reading pipeline definition '?'.  ");
        final PipelineDefinition result = PipelineFactory.eINSTANCE.createPipelineDefinition();

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "name");
        result.setName(parser.getValueAsString());
        //log.info("[PD{}]   name is '{}'.", pdLevel, result.getName());

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "steps");

        assertArrayStart(parser);

        AtomicInteger counter = new AtomicInteger();
        while(!parser.hasToken(JsonToken.END_ARRAY)) {
            //log.info("[PD{}]   reading child number {}.", pdLevel, counter.getAndIncrement());
            result.getSteps()
                  .add((Step)readObject(parser, true));
            //log.info("[PD{}]   read child number {}.", pdLevel, counter.get() - 1);
            //log.info("[PD{}]     current token: {}", pdLevel, parser.getCurrentToken().name());
        }

        assertArrayEndAndAdvance(parser);
        assertObjectEnd(parser);

        //log.info("[PD{}]   read pipeline definition '{}'", pdLevel, result.getName());
        //log.info("[PD{}]     current token: {}", pdLevel, parser.getCurrentToken().name());

        //pdLevel -= 1;

        return result;
    }

    //int psLevel = 0;
    private PipelineStep getPipelineStep(final JsonParser parser) throws IOException {
        //psLevel += 1;
        //log.info("[PS{}] Reading 'compound step'.", psLevel);
        parser.nextValue();

        final PipelineStep result = PipelineFactory.eINSTANCE.createPipelineStep();

        assertFieldName(parser.getCurrentName(), "definition");

        result.setDefinition((PipelineDefinition)readObject(parser, true));

        assertObjectEnd(parser);

        //log.info("[PS{}]   current token: {}", psLevel, parser.getCurrentToken().name());
        //log.info("[PS{}] Finished 'compound step'.", psLevel);
        //psLevel -= 1;
        return result;
    }

    //int csLevel = 0;
    private ConcreteStep getConcreteStep(final JsonParser parser) throws IOException {
        //csLevel += 1;
        //log.info("[CS{}] Reading 'concrete step'.", csLevel);
        parser.nextValue();

        final ConcreteStep result = PipelineFactory.eINSTANCE.createConcreteStep();
        assertFieldName(parser.getCurrentName(), "reads");
        readFeatures(parser, result.getReads());

        assertFieldName(parser.getCurrentName(), "writes");
        readFeatures(parser, result.getWrites());

        assertFieldName(parser.getCurrentName(), "configuration");
        result.setInstance((Instance) readObject(parser, true));


        //log.info("[CS{}] Finished 'concrete step'.", csLevel);
        //csLevel -= 1;
        return result;
    }

    private void readFeatures(final JsonParser parser, final EList<EStructuralFeature> features) throws IOException {
        while(!parser.hasToken(JsonToken.START_ARRAY)) {
            parser.nextValue();
        }
        parser.nextValue();
        while(!parser.hasToken(JsonToken.END_ARRAY)) {
            final String featureName = parser.getValueAsString();
            //log.info("Using feature '{}'.", featureName);
            final EStructuralFeature feature = space.getEClass().getEStructuralFeature(featureName);

            features.add(feature);
            parser.nextValue();
        }
        parser.nextValue();
    }

    private Instance getInstance(final JsonParser parser) throws IOException {
        //log.info("[IN] Reading 'instance'.");

        final Instance result = ExpressionsFactory.eINSTANCE.createInstance();
        parser.nextValue();

        assertFieldName(parser.getCurrentName(), "class-definition");
        final String className = parser.getValueAsString();
        result.setDefinition(findClassDefinition(className));

        parser.nextValue();
        assertFieldName(parser.getCurrentName(), "attributes");

        while(!parser.hasToken(JsonToken.END_ARRAY)) {
            parser.nextValue();
        }

        parser.nextValue();
        assertObjectEnd(parser);

        return result;
    }

    private ClassDefinition findClassDefinition(final String name) {
        final int index = name.lastIndexOf(".");
        String packageName = name.substring(0, index);
        final String className = name.substring(index + 1);

        log.info("Searching definition of class {} in package {}.", className, packageName);

        packageName = "classpath:/" + packageName.replace(".", "/") + ".dl";
        final DefinitionModule module = loader.load(packageName);

        return module.getTypes()
                .stream()
                .filter(d -> className.equals(d.getName()))
                .findFirst()
                .get();
    }

    private void assertArrayStart(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);
    }

    private void assertArrayEndAndAdvance(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.END_ARRAY);
    }

    private void assertObjectEnd(final JsonParser parser) throws IOException {
        assertTokenType(parser, JsonToken.END_OBJECT);
    }
/*
    private void assertObjectEndAndAdvance(final JsonParser parser) throws IOException {
        assertTokenTypeAndAdvance(parser, JsonToken.END_OBJECT);
    }
*/
    private void assertFieldName(final String actual, final String expected) {
        if(!expected.equals(actual)) {
            throw new IllegalStateException("Expected field name " + expected + " but got " + actual);
        }
    }

    private void assertTokenTypeAndAdvance(final JsonParser parser, final JsonToken token) throws IOException {
        if(!token.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.getCurrentToken());
        }
        parser.nextToken();
    }

    private void assertTokenType(final JsonParser parser, final JsonToken token) throws IOException {
        if(!token.equals(parser.getCurrentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.getCurrentToken());
        }
    }
}
