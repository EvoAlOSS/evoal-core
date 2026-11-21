package de.evoal.optimisation.api.run;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicDefinitions;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.literature.CitationList;
import de.evoal.core.api.literature.LiteratureIndex;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.models.v202704.optimisation.model.ModelPackage;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.main.constraints.ConstraintCompiler;
import de.evoal.optimisation.main.statistics.memory.ConfigurationJson;

/**
 * The literature of the optimisation runs: the methods that a configuration uses, as
 *   {@code citations.bib} in the output folder and as keys for the memory model.
 * <p>
 * The configuration is walked like the memory model writes it: the algorithm, the
 *   optimisation function, the target distances and the statistics writers with every nested
 *   configuration, in the order of their attributes. Every DL type found adds its
 *   {@code @Literature} (with that of its super types) and the citations of its module; then
 *   every DDL declaration of the problem (e.g. {@code 'building-block'}) adds its
 *   {@code @Literature}. The list starts with the EvoAl paper. The constraint measure of the
 *   algorithm counts only if the problem has {@code constraint} declarations.
 */
@ApplicationScoped
@Slf4j
public class RunLiterature {
    /**
     * The name of the file in the output folder.
     */
    public static final String FILE_NAME = "citations.bib";

    /**
     * The DL type of the constraint measures. Every algorithm has one (by default
     *   'exact-measure'), but it only acts on the constraints of a problem, so it counts only for
     *   a problem with {@code constraint} declarations.
     */
    private static final String CONSTRAINT_MEASURE = "constraint-measure";

    @Inject
    private ConstraintCompiler constraintCompiler;

    /**
     * Reads the attributes of the configurations with their default values.
     */
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The entries of the installed modules, read at the first use.
     */
    private LiteratureIndex index;

    /**
     * The configuration whose literature was written last, {@code null} before.
     */
    private OptimisationModule configuration;

    /**
     * The citations of {@link #configuration}.
     */
    private CitationList citations;

    /**
     * The folder that {@link #citations} were written to.
     */
    private Path folder;

    /**
     * Collects the literature of a configuration.
     *
     * @param configuration The runtime model of the configuration.
     * @return Its citations.
     */
    public CitationList collect(final @NonNull OptimisationModule configuration) {
        final List<Call> declarations = configuration.getProblem() == null
                ? List.of()
                : constraintCompiler.declarations(configuration.getProblem());
        final boolean constrained = declarations.stream()
                                                .map(Call::getFunction)
                                                .anyMatch(function -> function != null
                                                                      && ConstraintCompiler.CONSTRAINT.equals(function.getName()));

        final CitationList list = new CitationList(index());
        final Set<EObject> visited = Collections.newSetFromMap(new IdentityHashMap<>());
        walk(configuration, list, visited, constrained);

        declarations.stream()
                    .map(Call::getFunction)
                    .filter(Objects::nonNull)
                    .forEach(list::add);

        return list;
    }

    /**
     * @return {@code true} if the type is a {@value #CONSTRAINT_MEASURE} or one of its subtypes.
     */
    private static boolean isConstraintMeasure(final ClassDefinition definition) {
        for(ClassDefinition type = definition; type != null; type = type.getSuperType()) {
            if(CONSTRAINT_MEASURE.equals(type.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Writes the literature of the configuration into the output folder, once per
     *   configuration and folder: the runs of an evaluation share one file.
     *
     * @param configuration The runtime model of the configuration.
     * @param outputFolder The output folder of the run ({@code File} or path), {@code null}
     *   if the application has none; then only the keys are collected.
     */
    public void start(final @NonNull OptimisationModule configuration, final Object outputFolder) {
        final Path target = toPath(outputFolder);
        if(configuration == this.configuration && Objects.equals(target, folder)) {
            return;
        }

        this.configuration = configuration;
        this.citations = collect(configuration);
        this.folder = target;

        if(target == null) {
            return;
        }

        try {
            Files.createDirectories(target);
            Files.writeString(target.resolve(FILE_NAME), citations.toBibTeX(), StandardCharsets.UTF_8);
            log.info("Wrote the literature of the run ({} entries) to '{}'.", citations.keys().size(),
                     target.resolve(FILE_NAME));
        } catch(final IOException e) {
            log.error("Failed to write the literature of the run to '{}'.", target.resolve(FILE_NAME), e);
        }
    }

    /**
     * @return The keys of the configuration of the current run, none before the first run.
     */
    public List<String> keys() {
        return citations == null ? List.of() : citations.keys();
    }

    private LiteratureIndex index() {
        if(index == null) {
            index = LiteratureIndex.load(RunLiterature.class.getClassLoader());
        }

        return index;
    }

    /**
     * Visits the object and then the objects that its features hold, in the order of the
     *   features: objects of the runtime model (their references) and configurations of DL
     *   types (all attributes as the memory model writes them, with default values applied,
     *   since nested instances are attributes of the dynamic classes); other objects (e.g. data
     *   descriptions, classes of the spaces) are not entered.
     */
    private void walk(final EObject object, final CitationList list, final Set<EObject> visited, final boolean constrained) {
        if(!visited.add(object)) {
            return;
        }

        final Optional<ClassDefinition> definition = DynamicDefinitions.definitionOf(object.eClass());
        if(definition.isPresent()) {
            if(!constrained && isConstraintMeasure(definition.get())) {
                return;
            }

            list.add(definition.get());
            for(final EStructuralFeature attribute : object.eClass().getEAllStructuralFeatures()) {
                walkValue(read(object, attribute), list, visited, constrained);
            }
        } else if(object.eClass().getEPackage() == ModelPackage.eINSTANCE) {
            for(final EReference reference : object.eClass().getEAllReferences()) {
                walkValue(object.eGet(reference), list, visited, constrained);
            }
        }
    }

    private void walkValue(final Object value, final CitationList list, final Set<EObject> visited, final boolean constrained) {
        switch(value) {
            case EObject child -> walk(child, list, visited, constrained);
            case Collection<?> children -> children.forEach(child -> walkValue(child, list, visited, constrained));
            case Object[] children -> Arrays.stream(children).forEach(child -> walkValue(child, list, visited, constrained));
            case null, default -> { }
        }
    }

    /**
     * @return The value of the attribute as the components read it; the stored value if it
     *   cannot be read so.
     */
    private Object read(final EObject configuration, final EStructuralFeature attribute) {
        try {
            return ConfigurationJson.readAttribute(evaluator, configuration, attribute);
        } catch(final RuntimeException e) {
            log.debug("Reading '{}' of {} for its literature failed, using the stored value.", attribute.getName(),
                      configuration.eClass().getName(), e);
            return configuration.eGet(attribute);
        }
    }

    private static Path toPath(final Object folder) {
        return switch(folder) {
            case null -> null;
            case File file -> file.toPath();
            case Path path -> path;
            default -> Path.of(folder.toString());
        };
    }
}
