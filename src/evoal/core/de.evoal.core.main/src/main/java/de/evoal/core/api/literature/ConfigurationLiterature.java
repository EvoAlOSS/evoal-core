package de.evoal.core.api.literature;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import lombok.NonNull;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicDefinitions;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Instance;

/**
 * Collects the literature of a configuration by walking its runtime model: every configuration
 *   of a DL type adds its definition ({@code @Literature} with that of its super types, and the
 *   citations of its module) and then the values of all its attributes, as the components read
 *   them (defaults applied, {@link AttributeEvaluator#readAttribute}); objects of the given
 *   runtime model packages are entered through their references. An instance literal that is
 *   not converted into a configuration (e.g. an argument of a builtin function) adds the
 *   definition of its DL type, and its attribute values are entered. Other objects (e.g. data
 *   descriptions) are not entered. Every {@link LiteratureContributor} may add further
 *   definitions for a configuration, e.g. those recorded in a model file it loads.
 */
@Slf4j
public final class ConfigurationLiterature {
    /**
     * The contributors of further definitions.
     */
    private final List<LiteratureContributor> contributors;

    /**
     * Reads the attributes of the configurations.
     */
    private final AttributeEvaluator evaluator;

    /**
     * The packages of the runtime model whose objects are entered.
     */
    private final Set<EPackage> runtimePackages;

    /**
     * Configurations of these DL types are left out, with everything they hold.
     */
    private final Predicate<ClassDefinition> skipped;

    /**
     * @param evaluator Reads the attributes of the configurations.
     * @param runtimePackages The packages of the runtime model whose objects are entered.
     * @param skipped Configurations of these DL types are left out, with everything they hold.
     * @param contributors The contributors of further definitions.
     */
    public ConfigurationLiterature(final @NonNull AttributeEvaluator evaluator,
                                   final @NonNull Set<EPackage> runtimePackages,
                                   final @NonNull Predicate<ClassDefinition> skipped,
                                   final @NonNull List<LiteratureContributor> contributors) {
        this.evaluator = evaluator;
        this.runtimePackages = Set.copyOf(runtimePackages);
        this.skipped = skipped;
        this.contributors = List.copyOf(contributors);
    }

    /**
     * Creates the walker of an application's runtime model, e.g. of a training or a pipeline
     *   run: nothing is left out, and the contributors of the installed modules take part.
     *
     * @param evaluator Reads the attributes of the configurations.
     * @param runtimePackages The packages of the runtime model whose objects are entered.
     */
    public static ConfigurationLiterature of(final @NonNull AttributeEvaluator evaluator, final @NonNull Set<EPackage> runtimePackages) {
        return new ConfigurationLiterature(evaluator, runtimePackages, definition -> false, installedContributors());
    }

    /**
     * @param definitions The DL types and declarations of a run.
     * @return Their citations with the entries of the installed modules, starting with core's.
     */
    public static CitationList citationsOf(final @NonNull List<Definition> definitions) {
        final CitationList list = new CitationList(LiteratureIndex.load(ConfigurationLiterature.class.getClassLoader()));
        definitions.forEach(list::add);

        return list;
    }

    /**
     * @return The contributors of the installed modules (CDI beans).
     */
    public static List<LiteratureContributor> installedContributors() {
        return BeanProvider.getContextualReferences(LiteratureContributor.class, true, false);
    }

    /**
     * Adds the literature of the object and of everything it holds.
     *
     * @param list The list to add to.
     * @param root The root of the runtime model, e.g. a module.
     */
    public void addTo(final @NonNull CitationList list, final @NonNull EObject root) {
        definitions(root).forEach(list::add);
    }

    /**
     * @param root The root of the runtime model, e.g. a module.
     * @return The DL types and declarations whose literature the object and everything it holds
     *   use, each once, in the order they are found.
     */
    public List<Definition> definitions(final @NonNull EObject root) {
        final Set<Definition> definitions = new LinkedHashSet<>();
        walk(root, definitions, Collections.newSetFromMap(new IdentityHashMap<>()));

        return List.copyOf(definitions);
    }

    private void walk(final EObject object, final Set<Definition> list, final Set<EObject> visited) {
        if(!visited.add(object)) {
            return;
        }

        final Optional<ClassDefinition> definition = DynamicDefinitions.definitionOf(object.eClass());
        if(definition.isPresent()) {
            if(skipped.test(definition.get())) {
                return;
            }

            list.add(definition.get());
            contributors.forEach(contributor -> contributor.definitionsOf(object).forEach(list::add));

            for(final EStructuralFeature attribute : object.eClass().getEAllStructuralFeatures()) {
                walkValue(read(object, attribute), list, visited);
            }
        } else if(object instanceof Instance instance && instance.getDefinition() != null) {
            if(skipped.test(instance.getDefinition())) {
                return;
            }

            list.add(instance.getDefinition());
            instance.getAttributes()
                    .forEach(attribute -> walkValue(attribute.getValue(), list, visited));
        } else if(runtimePackages.contains(object.eClass().getEPackage())) {
            for(final EReference reference : object.eClass().getEAllReferences()) {
                walkValue(object.eGet(reference), list, visited);
            }
        }
    }

    private void walkValue(final Object value, final Set<Definition> list, final Set<EObject> visited) {
        switch(value) {
            case EObject child -> walk(child, list, visited);
            case Collection<?> children -> children.forEach(child -> walkValue(child, list, visited));
            case Object[] children -> Arrays.stream(children).forEach(child -> walkValue(child, list, visited));
            case null, default -> { }
        }
    }

    /**
     * @return The value of the attribute as the components read it; the stored value if it
     *   cannot be read so.
     */
    private Object read(final EObject configuration, final EStructuralFeature attribute) {
        try {
            return evaluator.readAttribute(configuration, attribute);
        } catch(final RuntimeException e) {
            log.debug("Reading '{}' of {} for its literature failed, using the stored value.", attribute.getName(),
                      configuration.eClass().getName(), e);
            return configuration.eGet(attribute);
        }
    }
}
