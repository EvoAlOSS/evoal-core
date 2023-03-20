package de.evoal.core.main.producer;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class ComparatorProducer {
    @Produces
    @Dependent
    @Named("comparator")
    public OptimisationValueComparator create(final @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.comparator") Instance configuration) {
        return BeanFactory.create(configuration.getDefinition().getName(), OptimisationValueComparator.class)
                          .init(configuration);
    }
}
