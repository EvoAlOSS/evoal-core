package de.evoal.core.api.languages;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import lombok.NonNull;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.StringLiteral;

/**
 * Reads the DL annotation {@code @Literature} of a DL type or declaration ({@code def}): the
 *   BibTeX keys of its sources. It needs no CDI container, so the build check of the credits
 *   uses it as well.
 */
public final class LiteratureReader {
    /**
     * The name of the annotation type.
     */
    public static final String ANNOTATION = "Literature";

    /**
     * The name of the attribute with the keys.
     */
    private static final String KEYS = "keys";

    private LiteratureReader() {
    }

    /**
     * @param definition A DL type or declaration.
     * @return The keys of its own annotations, in their order, each once.
     */
    public static List<String> ownKeysOf(final @NonNull Definition definition) {
        final Set<String> keys = new LinkedHashSet<>();
        addOwnKeys(definition, keys);

        return List.copyOf(keys);
    }

    /**
     * @param definition A DL type or declaration.
     * @return The keys of its annotations and, for a type, those of all its super types, the
     *   type's own first; each key once.
     */
    public static List<String> keysOf(final @NonNull Definition definition) {
        final Set<String> keys = new LinkedHashSet<>();

        if(definition instanceof ClassDefinition type) {
            for(ClassDefinition current = type; current != null; current = current.getSuperType()) {
                addOwnKeys(current, keys);
            }
        } else {
            addOwnKeys(definition, keys);
        }

        return List.copyOf(keys);
    }

    private static void addOwnKeys(final Definition definition, final Set<String> keys) {
        definition.getConstraints()
                  .stream()
                  .filter(Instance.class::isInstance)
                  .map(Instance.class::cast)
                  .filter(LiteratureReader::isLiterature)
                  .flatMap(instance -> instance.getAttributes().stream())
                  .filter(attribute -> attribute.getDefinition() != null
                                       && KEYS.equals(attribute.getDefinition().getName()))
                  .forEach(attribute -> addKeys(attribute, keys));
    }

    /**
     * Adds the string literals of the value of the attribute, in their order.
     */
    private static void addKeys(final Attribute attribute, final Set<String> keys) {
        if(attribute.getValue() == null) {
            return;
        }

        addKey(attribute.getValue(), keys);
        final TreeIterator<EObject> contents = attribute.getValue().eAllContents();
        while(contents.hasNext()) {
            addKey(contents.next(), keys);
        }
    }

    private static void addKey(final EObject element, final Set<String> keys) {
        if(element instanceof StringLiteral literal && literal.getLiteral() != null) {
            keys.add(literal.getLiteral());
        }
    }

    /**
     * @return {@code true} if the annotation is an instance of {@value #ANNOTATION}.
     */
    public static boolean isLiterature(final @NonNull Instance annotation) {
        return annotation.getDefinition() != null && ANNOTATION.equals(annotation.getDefinition().getName());
    }
}
