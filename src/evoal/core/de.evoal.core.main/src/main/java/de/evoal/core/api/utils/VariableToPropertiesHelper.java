package de.evoal.core.api.utils;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;
import lombok.extern.slf4j.Slf4j;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@ApplicationScoped
public class VariableToPropertiesHelper {
    @Inject
    protected AttributeHelper helper;

    public Properties variablesToProperties(List<Instance>  variablesList) {
        PropertiesSpecification specification = PropertiesSpecification.builder()
                .add(variablesList.stream()
                        .map(i -> helper.<DataDescription>lookup(i, "var"))
                        .map(DataDescription.class::cast)
                )
                .build();

        final Properties properties = new Properties(specification);
        variablesList.forEach(i -> {
                    final DataDescription dd = helper.<DataDescription>lookup(i, "var");
                    final Object val = helper.lookup(i, "val");
                    properties.put(specification.indexOf(dd.getName()), val);
                });

        return properties;
    }

    public Properties candidateToProperties(Instance candidate, PropertiesSpecification totalSpecification) {
        //receives candidate, turns to properties
        final List<Instance> sv = helper.lookup(candidate, "values");
        Properties properties = variablesToProperties(sv);
        //currently a problem if the received candidate doesn't correspond to total spec.
        for (PropertySpecification p : totalSpecification.getProperties()) {
            if (!properties.contains(p)) {
                log.error("Candidate Specification does not match Total Specification!");
            }
        }
        return properties;
    }
}