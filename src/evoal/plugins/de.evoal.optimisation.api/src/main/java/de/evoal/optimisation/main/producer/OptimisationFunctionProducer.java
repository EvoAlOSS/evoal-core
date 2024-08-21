package de.evoal.optimisation.main.producer;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.List;

@ApplicationScoped
@Slf4j
public class OptimisationFunctionProducer {
    @Produces
    @Dependent
    @Named("optimisation-function")
    public OptimisationFunction createOptimisationFunction(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function") Instance configuration) {
        return BeanFactory.createComponent(OptimisationFunction.class, configuration);
    }

    @Produces
    @Dependent
    @Named("search-space-specification")
    public PropertiesSpecification createSearchSpaceSpecification(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.search-space") List<Definition> references) {
        return PropertiesSpecification.builder()
                .add(references.stream())
                .build();
    }


    @Produces
    @Dependent
    @Named("optimisation-space-specification")
    public PropertiesSpecification createOptimisationSpaceSpecification(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.optimisation-space") List<Definition> references) {
        return PropertiesSpecification.builder()
                .add(references.stream())
                .build();
    }

    private static Instance findInner(final Instance fitnessConfig) {
        final Attribute subFunction = fitnessConfig.findAttribute("function");

        if(subFunction != null) {
            return findInner((Instance)subFunction.getValue());
        }

        return fitnessConfig;
    }
}
