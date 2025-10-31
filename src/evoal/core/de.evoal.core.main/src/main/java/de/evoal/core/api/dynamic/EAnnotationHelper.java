package de.evoal.core.api.dynamic;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.dynamic.Definition;
import de.evoal.languages.model.dynamic.DynamicPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.ApplicationScoped;
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
                .filter(Definition.class::isInstance)
                .map(Definition.class::cast)
                .map(Definition::getSource)
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

    public PropertiesSpecification specificationOf(final Space space) {
        return PropertiesSpecification
                .builder()
                .add(dataDescriptionsOf(space).stream() )
                .build();
    }

    public Space subSpaceOf(final Space space, final List<DataDescription> descriptions) {
        final Map<DataDescription, EStructuralFeature> featureMap = featuresOf(space);

        return space.subSpace(
            descriptions.stream()
                        .map(featureMap::get)
        );
    }
}