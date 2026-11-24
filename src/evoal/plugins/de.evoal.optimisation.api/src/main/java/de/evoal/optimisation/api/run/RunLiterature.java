package de.evoal.optimisation.api.run;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;


import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.literature.CitationList;
import de.evoal.core.api.literature.ConfigurationLiterature;
import de.evoal.core.api.literature.LiteratureContributor;
import de.evoal.core.api.literature.LiteratureIndex;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Call;
import de.evoal.models.v202704.optimisation.model.ModelPackage;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.optimisation.main.constraints.ConstraintCompiler;

/**
 * The literature of the optimisation runs: the methods that a configuration uses, as
 *   {@code citations.bib} in the output folder and as keys for the memory model.
 * <p>
 * The configuration is walked like the memory model writes it ({@link ConfigurationLiterature}):
 *   the algorithm, the optimisation function, the target distances and the statistics writers
 *   with every nested configuration, in the order of their attributes. Every DL type found adds its
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
    public static final String FILE_NAME = CitationList.FILE_NAME;

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
     * The contributors of further literature (e.g. of a surrogate's model file), found at the
     *   first use.
     */
    private List<LiteratureContributor> contributors;

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
     * @param root A configuration, e.g. the algorithm of a run.
     * @return The DL types (and the declarations of builtin calls) that the configuration uses,
     *   walked as for its literature, but without the definitions that contributors add (e.g.
     *   from a surrogate's model file).
     */
    public List<Definition> definitionsOf(final @NonNull EObject root) {
        return new ConfigurationLiterature(evaluator, Set.of(ModelPackage.eINSTANCE), definition -> false, List.of())
                .definitions(root);
    }

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
        new ConfigurationLiterature(evaluator,
                                    Set.of(ModelPackage.eINSTANCE),
                                    definition -> !constrained && isConstraintMeasure(definition),
                                    contributors())
                .addTo(list, configuration);

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
            citations.write(target);
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

    private List<LiteratureContributor> contributors() {
        if(contributors == null) {
            contributors = ConfigurationLiterature.installedContributors();
        }

        return contributors;
    }

    private LiteratureIndex index() {
        if(index == null) {
            index = LiteratureIndex.load(RunLiterature.class.getClassLoader());
        }

        return index;
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
