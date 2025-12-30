package de.evoal.optimisation.main.producer;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import java.util.List;
import java.util.stream.Stream;

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
    public PropertiesSpecification createSearchSpaceSpecification(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem") Instance problem) {
        final Stream<TypeDefinition> types =
                ((ProblemInstance)problem)
                        .getSearchSpace()
                        .stream()
                        .map(TypeDefinitionReference::getDefinition);

        return PropertiesSpecification.builder()
                .add(types)
                .build();
    }

    @Produces
    @Dependent
    @Named("optimisation-space-specification")
    public PropertiesSpecification createOptimisationSpaceSpecification(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem") Instance problem) {
        final Stream<TypeDefinition> types =
                ((ProblemInstance)problem)
                    .getOptimisationSpace()
                    .stream()
                    .map(OptimisationGoal::getData)
                    .map(TypeDefinitionReference::getDefinition);

        return PropertiesSpecification.builder()
                .add(types)
                .build();
    }
}
