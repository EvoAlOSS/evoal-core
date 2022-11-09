package de.evoal.core.main.cdi.producer;

import de.evoal.languages.model.ddl.DataDescriptionModel;
import de.evoal.languages.model.eal.DataReference;
import de.evoal.languages.model.eal.EAModel;
import de.evoal.languages.model.el.Expression;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class DataConstraintProducer {
    @Produces @Dependent @Named("data-constraints")
    public Collection<Expression> produceDataInformation(final EAModel model) {
        final TreeIterator<EObject> iterator = model.eAllContents();
        Iterable<EObject> iterable = () -> iterator;

        // collect all expressions associated to the data definitions directly
        Set<Expression> result = StreamSupport.stream(iterable.spliterator(), false)
                                              .filter(DataReference.class::isInstance)
                                              .map(DataReference.class::cast)
                                              .map(DataReference::getDefinition)
                                              .flatMap(d -> d.getConstraints().stream())
                                              .collect(Collectors.toSet());

        // collect all expressions associated to the files
        final TreeIterator<EObject> iterator2 = model.eAllContents();
        iterable = () -> iterator2;
        StreamSupport.stream(iterable.spliterator(), false)
                     .filter(DataReference.class::isInstance)
                     .map(DataConstraintProducer::findModel)
                     .filter(Objects::nonNull)
                     .distinct()
                     .flatMap(m -> m.getConstraints().stream())
                     .forEach(result::add);

        return result;
    }

    private static DataDescriptionModel findModel(final EObject reference) {
        EObject current = reference;

        while(current != null && !(current instanceof DataDescriptionModel)) {
            current = current.eContainer();
        }

        return (DataDescriptionModel)current;
    }
}
