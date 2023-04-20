package de.evoal.core.main.producer;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SpecificationProducer {
    @Produces
    @Dependent
    @Named("genotype-description")
    public List<DataDescription> createSourceSpecification(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.genotype") Instance [] genotype) {
        final List<DataDescription> descriptors = Arrays.stream(genotype)
                .map(Instance.class::cast)
                .map(i -> i.findAttribute("genes"))
                .map(Attribute::getValue)
                .map(Array.class::cast)
                .map(Array::getValues)
                .flatMap(List::stream)
                .map(Instance.class::cast)
                .map(i -> i.findAttribute("content"))
                .map(Attribute::getValue)
                .map(DataReference.class::cast)
                .map(DataReference::getDefinition)
                .collect(Collectors.toList());

        return descriptors;
    }

    @Produces
    @Dependent
    @Named("genotype-specification")
    public PropertiesSpecification createSourceSpecification(final @Named("genotype-description") List<DataDescription> descriptions) {
        return PropertiesSpecification.builder()
                                      .add(descriptions.stream())
                                      .build();
    }
}
