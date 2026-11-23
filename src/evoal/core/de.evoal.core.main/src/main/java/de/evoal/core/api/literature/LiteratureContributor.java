package de.evoal.core.api.literature;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.evoal.languages.model.base.definitions.Definition;

/**
 * Adds literature that a configuration uses beyond its DL type, e.g. the methods recorded in a
 *   model file that the configuration loads. {@link ConfigurationLiterature} asks every
 *   contributor (CDI beans of this type) for every configuration it visits.
 */
public interface LiteratureContributor {
    /**
     * @param configuration A configuration of a DL type.
     * @return The further DL types and declarations whose literature the configuration uses;
     *   empty if the contributor does not know the configuration.
     */
    List<Definition> definitionsOf(EObject configuration);
}
