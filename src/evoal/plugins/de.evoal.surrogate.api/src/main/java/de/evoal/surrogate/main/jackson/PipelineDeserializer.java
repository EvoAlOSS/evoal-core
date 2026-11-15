package de.evoal.surrogate.main.jackson;

import de.evoal.models.core.ecore.Space;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.v202704.pipeline.*;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.deser.std.StdDeserializer;

import java.util.Map;

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

    /**
     * For creating the runtime configurations of the pipeline steps.
     */
    private final @NonNull ModelTransformer transformer;

    public PipelineDeserializer(final @NonNull DefinitionModuleLoader loader, final @NonNull Space space, final @NonNull ModelTransformer transformer) {
        super(Object.class);

        this.loader = loader;
        this.space = space;
        this.transformer = transformer;
    }

    @Override
    public PipelineDefinition deserialize(final JsonParser parser, final DeserializationContext context) {
        return (PipelineDefinition)readObject(parser, false);
    }

    private Object readObject(final JsonParser parser, final boolean advance) {
        assertTokenTypeAndAdvance(parser, JsonToken.START_OBJECT);

        parser.nextValue();
        assertFieldName(parser.currentName(), "type");

        final String type = parser.getValueAsString();
        log.info("Reading object with type entry: '{}'.", type);

        final Object value = switch (type) {
            case "pipeline-definition" -> getPipelineDefinition(parser);
            case "pipeline-step" -> getPipelineStep(parser);
            case "concrete-step" -> getConcreteStep(parser);
            case "instance" -> getConfiguration(parser);

            default -> {
                throw new IllegalArgumentException("Unsupported type: " + type + ".");
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

    private PipelineDefinition getPipelineDefinition(final JsonParser parser) {
//        log.info("[PD{}] Reading pipeline definition '?'.  ");
        final PipelineDefinition result = PipelineFactory.eINSTANCE.createPipelineDefinition();

        parser.nextValue();
        assertFieldName(parser.currentName(), "name");
        result.setName(parser.getValueAsString());
        //log.info("[PD{}]   name is '{}'.", pdLevel, result.getName());

        parser.nextValue();
        assertFieldName(parser.currentName(), "steps");

        assertArrayStart(parser);

        //AtomicInteger counter = new AtomicInteger();
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
    private PipelineStep getPipelineStep(final JsonParser parser) {
        //psLevel += 1;
        //log.info("[PS{}] Reading 'compound step'.", psLevel);
        parser.nextValue();

        final PipelineStep result = PipelineFactory.eINSTANCE.createPipelineStep();

        assertFieldName(parser.currentName(), "definition");

        result.setDefinition((PipelineDefinition)readObject(parser, true));

        assertObjectEnd(parser);

        //log.info("[PS{}]   current token: {}", psLevel, parser.getCurrentToken().name());
        //log.info("[PS{}] Finished 'compound step'.", psLevel);
        //psLevel -= 1;
        return result;
    }

    //int csLevel = 0;
    private ConcreteStep getConcreteStep(final JsonParser parser) {
        //csLevel += 1;
        //log.info("[CS{}] Reading 'concrete step'.", csLevel);
        parser.nextValue();

        final ConcreteStep result = PipelineFactory.eINSTANCE.createConcreteStep();
        assertFieldName(parser.currentName(), "reads");
        readFeatures(parser, result.getReads());

        assertFieldName(parser.currentName(), "writes");
        readFeatures(parser, result.getWrites());

        assertFieldName(parser.currentName(), "configuration");
        result.setConfiguration((Configuration) readObject(parser, true));


        //log.info("[CS{}] Finished 'concrete step'.", csLevel);
        //csLevel -= 1;
        return result;
    }

    private void readFeatures(final JsonParser parser, final EList<EStructuralFeature> features) {
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

    /**
     * Reads the configuration of a pipeline step. Only the DL type is stored in the file,
     *   so the runtime configuration gets the default values of the type. The
     *   {@code attributes} array is skipped.
     */
    private Configuration getConfiguration(final JsonParser parser) {
        parser.nextValue();

        assertFieldName(parser.currentName(), "class-definition");
        final String className = parser.getValueAsString();
        final Configuration result = transformer.createDynamic(findClassDefinition(className), Map.of());

        parser.nextValue();
        assertFieldName(parser.currentName(), "attributes");

        while(!parser.hasToken(JsonToken.END_ARRAY)) {
            parser.nextValue();
        }

        parser.nextValue();
        assertObjectEnd(parser);

        return result;
    }

    private ClassDefinition findClassDefinition(final String name) {
        final int index = name.lastIndexOf(".");
        final String packageName = name.substring(0, index);
        final String className = name.substring(index + 1);

        log.info("Searching definition of class {} in package {}.", className, packageName);

        final String uri = "classpath:/" + packageName.replace(".", "/") + ".dl";
        final URI modelURI = URI.createURI(uri);
        final DefinitionModule module = loader.load(modelURI);

        return module.getTypes()
                .stream()
                .filter(d -> className.equals(d.getName()))
                .findFirst()
                .get();
    }

    private void assertArrayStart(final JsonParser parser) {
        assertTokenTypeAndAdvance(parser, JsonToken.START_ARRAY);
    }

    private void assertArrayEndAndAdvance(final JsonParser parser) {
        assertTokenTypeAndAdvance(parser, JsonToken.END_ARRAY);
    }

    private void assertObjectEnd(final JsonParser parser) {
        assertTokenType(parser, JsonToken.END_OBJECT);
    }
/*
    private void assertObjectEndAndAdvance(final JsonParser parser) {
        assertTokenTypeAndAdvance(parser, JsonToken.END_OBJECT);
    }
*/
    private void assertFieldName(final String actual, final String expected) {
        if(!expected.equals(actual)) {
            throw new IllegalStateException("Expected field name " + expected + " but got " + actual);
        }
    }

    private void assertTokenTypeAndAdvance(final JsonParser parser, final JsonToken token) {
        if(!token.equals(parser.currentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.currentToken());
        }
        parser.nextToken();
    }

    private void assertTokenType(final JsonParser parser, final JsonToken token) {
        if(!token.equals(parser.currentToken())) {
            throw new IllegalStateException("Expected token " + token + " got " + parser.currentToken());
        }
    }
}
