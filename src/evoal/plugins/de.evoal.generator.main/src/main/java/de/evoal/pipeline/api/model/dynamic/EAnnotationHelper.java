package de.evoal.pipeline.api.model.dynamic;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.dynamic.Definition;
import de.evoal.languages.model.dynamic.DynamicPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
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
}