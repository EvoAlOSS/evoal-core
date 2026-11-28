package de.evoal.optimisation.api.models;

import java.util.List;

import lombok.NonNull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.models.EcoreModels;

import de.evoal.optimisation.api.builder.ModelTypeSource;

/**
 * The Ecore front-end of the random builder: the classes of Ecore metamodels loaded by
 *   {@link EcoreModels} ({@code @EcoreType}).
 * <ul>
 *   <li>The concrete subtypes of a class come from all loaded files, ordered by their type
 *     names ({@link EcoreModels#concreteSubclassesOf}).</li>
 *   <li>A single-valued containment with lower bound 0 is optional. A single-valued attribute is
 *     optional only with lower bound 0 and {@code unsettable}, EMF's marker for an attribute
 *     that may have no value: Ecore's default lower bound is 0, so the lower bound alone would
 *     make almost every attribute optional.</li>
 * </ul>
 *
 * @param models The loaded metamodels.
 */
public record EcoreModelTypes(@NonNull EcoreModels models) implements ModelTypeSource {
    @Override
    public List<EClass> concreteSubtypesOf(final EClass type) {
        return models.concreteSubclassesOf(type);
    }

    @Override
    public boolean isOptional(final EStructuralFeature feature) {
        return isOptionalFeature(feature);
    }

    /**
     * @return {@code true} if the single-valued feature of a metamodel class may stay without
     *   value (see the class comment).
     */
    public static boolean isOptionalFeature(final @NonNull EStructuralFeature feature) {
        if(feature.isMany() || feature.getLowerBound() > 0) {
            return false;
        }

        if(feature instanceof EReference reference) {
            return reference.isContainment();
        }

        return feature.isUnsettable();
    }
}
