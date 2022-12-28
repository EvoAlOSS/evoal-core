package de.evoal.core.main.producer;

import de.evoal.core.api.ea.correlations.Range;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.ddl.DataDescription;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.Resource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class ConstraintsProducer {
    @Produces @Dependent
    public void findApplicableConstraints(final @Named("genotype-description") List<DataDescription> descriptions) {
        log.info("Searching for applicable constraints for {} data descriptions.", descriptions.size());
        final List<Resource> resources =
                descriptions.stream()
                            .map(DataDescription::eResource)
                            .distinct()
                            .collect(Collectors.toList());

        log.info("Identified {} different resources to scan.", resources.size());


    }

    @Produces @Dependent @Named("genotype-limits")
    public Map<PropertySpecification, Range> findLimits() {
        return null; // TODO Implement me
    }
}
