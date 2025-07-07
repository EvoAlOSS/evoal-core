package de.evoal.optimisation.api.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.main.producer.ConfigurationValueProducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

@ApplicationScoped
public class OptimisationComponentProducer {
    @Inject
    private Blackboard board;

    @Inject
    private ComponentProducer producer;

    @Inject
    private ConfigurationValueProducer valueProducer;

    public <T extends EvoalComponent<T>> T create(final Class<T> clazz, final String entry, final String access) {
        final Instance configuration = valueProducer.lookup(board.get(entry), access);

        return producer.create(clazz, configuration);
    }

    public <T extends EvoalComponent<T>> T create(final InjectionPoint ip) {
        final ConfigurationValue annotation = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return create((Class<T>)ip.getAnnotated().getBaseType(), annotation.entry(), annotation.access());
    }

    @Produces
    @Dependent
    @Component
    public OptimisationValueComparator createComparator(final InjectionPoint ip) {
        return create(OptimisationValueComparator.class, OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, "algorithm.comparator");
    }

    @Produces
    @Dependent
    @Component
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public OptimisationFunction createOptimisationFunction(final InjectionPoint ip) {
        return create(OptimisationFunction.class, OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, "algorithm.optimisation-function");
    }

    @Produces
    @Dependent
    @Component
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public InitialCandidatesProvider createInitialCandidatesProvider(final InjectionPoint ip) {
        return create(InitialCandidatesProvider.class, OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, "algorithm.initialisation");
    }
}
