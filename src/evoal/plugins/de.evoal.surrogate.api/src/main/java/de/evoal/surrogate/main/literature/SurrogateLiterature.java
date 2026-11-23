package de.evoal.surrogate.main.literature;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.literature.LiteratureContributor;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.utils.FQNProvider;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;

/**
 * The literature of surrogate models.
 * <p>
 * A training run records the DL types of its configuration ({@link #trained(List)}), and the
 *   model file stores them as {@code definitions} ({@link #trainingDefinitions()}). A search or a
 *   pipeline that loads the model file (DL types {@value #SURROGATE_FUNCTION} and
 *   {@value #TRAINED_MODEL}) cites them, together with the model's own type ({@code name}) and the
 *   types of its prediction pipeline ({@code class-definition}). A model file without
 *   {@code definitions}, written before they were recorded, gives only these two.
 */
@ApplicationScoped
@Slf4j
public class SurrogateLiterature implements LiteratureContributor {
    /**
     * The attribute of the configurations with the model file.
     */
    private static final String MODEL_FILE = "model-file";

    /**
     * The DL type of a fitness function that predicts with a model file.
     */
    static final String SURROGATE_FUNCTION = "de.evoal.surrogate.optimisation.surrogate";

    /**
     * The DL type of a pipeline step that predicts with a model file.
     */
    static final String TRAINED_MODEL = "de.evoal.surrogate.pipeline.trained-model";

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private DefinitionModuleLoader loader;

    /**
     * The fully qualified names of the DL types of the training configuration.
     */
    private final List<String> trainingDefinitions = new ArrayList<>();

    /**
     * Records the definitions of the training configuration.
     *
     * @param definitions The DL types and declarations whose literature the training uses.
     */
    public void trained(final @NonNull List<Definition> definitions) {
        final FQNProvider names = new FQNProvider();

        trainingDefinitions.clear();
        definitions.stream()
                   .filter(ClassDefinition.class::isInstance)
                   .map(ClassDefinition.class::cast)
                   .map(names::get)
                   .distinct()
                   .forEach(trainingDefinitions::add);
    }

    /**
     * @return The fully qualified names of the DL types of the training configuration, empty
     *   outside of a training run.
     */
    public List<String> trainingDefinitions() {
        return List.copyOf(trainingDefinitions);
    }

    @Override
    public List<Definition> definitionsOf(final EObject configuration) {
        final String type = DynamicEClassProvider.dlTypeOf(configuration);
        if(!SURROGATE_FUNCTION.equals(type) && !TRAINED_MODEL.equals(type)) {
            return List.of();
        }

        final File modelFile = new File(evaluator.attributeToString(configuration, MODEL_FILE));
        if(!modelFile.isFile()) {
            log.warn("The model file '{}' does not exist; its literature is not cited.", modelFile);
            return List.of();
        }

        try {
            final JsonNode model = JsonMapper.builder().build().readTree(modelFile);

            return namesIn(model).stream()
                                 .map(this::findClassDefinition)
                                 .flatMap(Optional::stream)
                                 .map(Definition.class::cast)
                                 .toList();
        } catch(final JacksonException e) {
            log.warn("Cannot read the literature of the model file '{}'.", modelFile, e);
            return List.of();
        }
    }

    /**
     * @return The fully qualified DL type names of a model file: {@code name}, the
     *   {@code definitions} and every {@code class-definition} of the prediction pipeline.
     */
    static Set<String> namesIn(final JsonNode model) {
        final Set<String> names = new LinkedHashSet<>();

        final JsonNode name = model.get("name");
        if(name != null && name.isString()) {
            names.add(name.asString());
        }

        final JsonNode definitions = model.get("definitions");
        if(definitions != null && definitions.isArray()) {
            definitions.forEach(definition -> names.add(definition.asString()));
        }

        final JsonNode pipeline = model.get("predictionPipeline");
        if(pipeline != null) {
            pipeline.findValues("class-definition")
                    .forEach(definition -> names.add(definition.asString()));
        }

        return names;
    }

    /**
     * @return The DL type with the fully qualified name, from the DL module of the installed
     *   plugins; empty (with a warning) if no module defines it.
     */
    private Optional<ClassDefinition> findClassDefinition(final String name) {
        final int index = name.lastIndexOf('.');
        if(index <= 0) {
            return Optional.empty();
        }

        final String moduleName = name.substring(0, index);
        final String typeName = name.substring(index + 1);

        try {
            final DefinitionModule module = loader.load(URI.createURI("classpath:/" + moduleName.replace('.', '/') + ".dl"));

            return module.getTypes()
                         .stream()
                         .filter(type -> typeName.equals(type.getName()))
                         .findFirst();
        } catch(final RuntimeException e) {
            log.warn("Cannot find the DL type '{}' of a model file; its literature is not cited.", name, e);
            return Optional.empty();
        }
    }
}
