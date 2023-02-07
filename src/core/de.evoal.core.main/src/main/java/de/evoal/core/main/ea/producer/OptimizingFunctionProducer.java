package de.evoal.core.main.ea.producer;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.fitness.FitnessFunction;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.instance.Instance;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class OptimizingFunctionProducer {
    @Produces
    @Dependent
    @Named("optimization-function-input")
    public PropertiesSpecification createInputSpec(final @Named("genotype-specification") PropertiesSpecification genotypeSpec) {
        return genotypeSpec;
    }

    @Produces
    @ApplicationScoped
    @Named("optimization-function-configuration")
    public Instance find(final @ConfigurationValue(entry = BlackboardEntry.OPTIMISATION_CONFIGURATION, access = "algorithm.fitness") Instance fitnessConfiguration) {
        return findInner(fitnessConfiguration);
    }

    @Produces
    @Dependent
    @Named("optimization-function-output")
    public PropertiesSpecification createOutputSpec(final @Named("optimization-function-configuration") Instance configuration) {
        return toSpecification(configuration);
    }

    @Produces
    @ApplicationScoped
    @Named("optimization-function")
    private FitnessFunction create(final @Named("optimization-function-configuration") Instance configuration) {
        final String fitnessName = configuration.getName().getName();

        return BeanProvider.getContextualReference(fitnessName, false, FitnessFunction.class)
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
