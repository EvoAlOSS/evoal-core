package de.evoal.pipeline.api.model.dynamic;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.dynamic.Definition;
import de.evoal.languages.model.dynamic.DynamicPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class EAnnotationHelper {
    public Optional<DataDescription> dataDescriptionOf(final EStructuralFeature attribute) {
        return attribute.getEAnnotations()
                .stream()
                .peek(ann -> System.out.println("Annotation from " + ann.getSource()))
                .filter(ann -> DynamicPackage.eNS_URI.equals(ann.getSource()))
                .flatMap(ann -> ann.getContents().stream())
                .filter(Definition.class::isInstance)
                .map(Definition.class::cast)
                .map(Definition::getSource)
                .map(DataDescription.class::cast)
                .findFirst();

    }
}
