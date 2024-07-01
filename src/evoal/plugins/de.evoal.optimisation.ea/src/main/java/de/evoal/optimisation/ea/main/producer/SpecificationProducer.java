package de.evoal.optimisation.ea.main.producer;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.ea.api.codec.CustomCodecDescriber;
import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.dl.util.FQNProvider;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ApplicationScoped
@Slf4j
public class SpecificationProducer {

    @Inject
    private ExpressionEvaluator evaluator;

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
