package de.evoal.core.api.dynamic;

import de.evoal.languages.model.dynamic.DefinitionMapping;
import de.evoal.models.core.ecore.Space;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.dynamic.DynamicPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class EAnnotationHelper {
    public Optional<DataDescription> dataDescriptionOf(final EStructuralFeature attribute) {
        return attribute.getEAnnotations()
                .stream()
                .filter(ann -> DynamicPackage.eNS_URI.equals(ann.getSource()))
                .flatMap(ann -> ann.getContents().stream())
                .filter(DefinitionMapping.class::isInstance)
                .map(DefinitionMapping.class::cast)
                .map(DefinitionMapping::getSource)
                .map(DataDescription.class::cast)
                .findFirst();
    }


    public Map<DataDescription, EStructuralFeature> featuresOf(final EObject obj) {
        return featuresOf(obj.eClass());
    }

    public Map<DataDescription, EStructuralFeature> featuresOf(final EClass eClass) {
        final Map<DataDescription, EStructuralFeature> features = new HashMap<>();

        for (final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            features.put(dataDescriptionOf(feature).get(), feature);
        }

        return features;
    }

    public Map<DataDescription, EStructuralFeature> featuresOf(final Space space) {
        final Map<DataDescription, EStructuralFeature> features = new HashMap<>();

        for (final EStructuralFeature feature : space.getEClass().getEAllStructuralFeatures()) {
            features.put(dataDescriptionOf(feature).get(), feature);
        }

        return features;
    }

    public List<DataDescription> dataDescriptionsOf(final Space space) {
        return space.stream()
                .map(this::dataDescriptionOf)
                .map(Optional::get)
                .toList();
    }

    public Space subSpaceOf(final Space space, final List<DataDescription> descriptions) {
        final Map<DataDescription, EStructuralFeature> featureMap = featuresOf(space);

        return space.subSpace(
            descriptions.stream()
                        .map(featureMap::get)
        );
    }

    public EStructuralFeature featureOf(final Space space, final DataDescription description) {
        for(final EStructuralFeature feature : space) {
            final Optional<DataDescription> d = dataDescriptionOf(feature);

            if(d.isEmpty() || !d.get().equals(description)) {
                continue;
            }

            return feature;
        }

        throw new RuntimeException("No feature found for " + description);
    }

    public EStructuralFeature featureOf(final EClass clazz, final DataDescription description) {
        final Optional<EStructuralFeature> feature = findFeatureOf(description);

        if(feature.isPresent()) {
            return feature.get();
        }

        throw new RuntimeException("No feature found for " + description);
    }

    /**
     * @return The feature of the data description in a space class, empty if no space class
     *   has one.
     */
    public static Optional<EStructuralFeature> findFeatureOf(final DataDescription description) {
        return description.getEAnnotations()
                          .stream()
                          .filter(a -> DynamicPackage.eNS_URI.equals(a.getSource()))
                          .map(a -> a.getContents().stream().filter(DefinitionMapping.class::isInstance).findFirst())
                          .filter(Optional::isPresent)
                          .map(Optional::get)
                          .map(DefinitionMapping.class::cast)
                          .map(DefinitionMapping::getTarget)
                          .findFirst();
    }
}