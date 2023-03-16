package de.evoal.core.ea.main.producer;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class OptimisingFunctionProducer {
    @Produces
    @Dependent
    @Named("optimisation-function-input")
    public PropertiesSpecification createInputSpec(final @Named("genotype-specification") PropertiesSpecification genotypeSpec) {
        return genotypeSpec;
    }

    @Produces
    @ApplicationScoped
    @Named("optimisation-function-configuration")
    public Instance find(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.fitness") Instance fitnessConfiguration) {
        return findInner(fitnessConfiguration);
    }

    @Produces
    @Dependent
    @Named("optimisation-function-output")
    public PropertiesSpecification createOutputSpec(final @Named("optimisation-function-configuration") Instance configuration) {
        return toSpecification(configuration);
    }

    @Produces
    @ApplicationScoped
    @Named("optimisation-function")
    private OptimisationFunction create(final @Named("optimisation-function-configuration") Instance configuration) {
        final String fitnessName = configuration.getDefinition().getName();

        return BeanFactory.create(fitnessName, OptimisationFunction.class)
                .init(configuration);
    }

    private PropertiesSpecification toSpecification(final Instance fitnessConfiguration) {
        return PropertiesSpecification.builder()
                .add(((Array)findInner(fitnessConfiguration).findAttribute("maps-to").getValue())
                        .getValues()
                        .stream()
                        .map(DataReference.class::cast)
                        .map(DataReference::getDefinition)
                )
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
