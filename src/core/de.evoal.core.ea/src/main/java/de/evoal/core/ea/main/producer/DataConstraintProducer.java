package de.evoal.core.ea.main.producer;

import de.evoal.core.ea.api.constraints.model.DataConstraints;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataDescriptionModel;
import de.evoal.languages.model.ddl.TypedDataDescription;
import de.evoal.languages.model.ol.OptimisationModel;
import de.evoal.languages.model.instance.DataReference;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class DataConstraintProducer {
    @Produces @Dependent
    public DataConstraints produceDataInformation(final OptimisationModel model) {
        final TreeIterator<EObject> iterator = model.eAllContents();
        Iterable<EObject> iterable = () -> iterator;

        final Set<DataDescriptionModel> models = new HashSet<>();

        // collect all referenced data descriptions
        final Set<DataDescription> descriptions = StreamSupport.stream(iterable.spliterator(), false)
                                                               .filter(DataReference.class::isInstance)
                                                               .map(DataReference.class::cast)
                                                               .map(DataReference::getDefinition)
                                                               .collect(Collectors.toSet());

        // collect models of descriptions
        descriptions.stream()
                    .map(DataConstraintProducer::findModel)
                    .filter(Objects::nonNull)
                    .forEach(models::add);

        // collect models of types of descriptions
        descriptions.stream()
                .filter(TypedDataDescription.class::isInstance)
                .map(TypedDataDescription.class::cast)
                .map(TypedDataDescription::getType)
                .map(DataConstraintProducer::findModel)
                .filter(Objects::nonNull)
                .forEach(models::add);

        return new DataConstraints(models);
    }

    private static DataDescriptionModel findModel(final EObject reference) {
        EObject current = reference;

        while(current != null && !(current instanceof DataDescriptionModel)) {
            current = current.eContainer();
        }

        return (DataDescriptionModel)current;
    }
}
