package de.evoal.optimisation.ea.main.producer;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.util.FQNProvider;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@ApplicationScoped
@Slf4j
public class SpecificationProducer {

    @Inject
    private AttributeEvaluator evaluator;

    @Produces
    @Dependent
    @Named("genotype-description")
    public List<Definition> createSourceSpecification(final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.genotype") Instance genotype) {
        final String name = new FQNProvider().get(genotype) + "-describer";
        final CustomCodecDescriber describer = BeanFactory.createComponent(CustomCodecDescriber.class, name, genotype);
        return describer.describe();
    }

    @Produces
    @Dependent
    @Named("genotype-specification")
    public PropertiesSpecification createSourceSpecification(final @Named("genotype-description") List<Definition> descriptions) {
        return PropertiesSpecification.builder()
                .add(descriptions.stream())
                .build();
    }
}
