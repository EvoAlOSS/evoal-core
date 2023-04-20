package de.evoal.core.main.producer;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Arrays;

@ApplicationScoped
@Slf4j
public class OptimisationFunctionProducer {
    @Produces
    @Dependent
    @Named("optimisation-function")
    public OptimisationFunction createOptimisationFunction(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function.function") Instance configuration) {
        return BeanFactory.create(configuration.getDefinition().getName(), OptimisationFunction.class)
                .init(configuration);
    }

    @Produces
    @Dependent
    @Named("search-space-specification")
    public PropertiesSpecification createSearchSpaceSpecification(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function.search-space") DataReference [] references) {
        return PropertiesSpecification.builder()
                .add(
                        Arrays.stream(references)
                                .map(DataReference::getDefinition)
                )
                .build();
    }


    @Produces
    @Dependent
    @Named("optimisation-space-specification")
    public PropertiesSpecification createOptimisationSpaceSpecification(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function.optimisation-space") DataReference [] references) {
        return PropertiesSpecification.builder()
                .add(
                        Arrays.stream(references)
                                .map(DataReference::getDefinition)
                )
                .build();
    }

    @Produces
    @ApplicationScoped
    @Named("XXXoptimisation-function-configuration")
    public Instance find(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function.function") Instance configuration) {
        return findInner(configuration);
    }

    private static Instance findInner(final Instance fitnessConfig) {
        final Attribute subFunction = fitnessConfig.findAttribute("function");

        if(subFunction != null) {
            return findInner((Instance)subFunction.getValue());
        }

        return fitnessConfig;
    }
}
