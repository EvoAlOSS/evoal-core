package de.evoal.core.api.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.optimisation.OptimisationFunction;
import de.evoal.core.api.optimisation.OptimisationValueComparator;
import de.evoal.core.main.producer.ConfigurationValueProducer;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class ComponentProducer {
    @Inject
    private Blackboard board;

    @Inject
    private ConfigurationValueProducer producer;

    public <T extends EvoalComponent<T>> T create(final Class<T> clazz, final Instance configuration) {
        return BeanFactory.createComponent(clazz, configuration);
    }


    public <T extends EvoalComponent<T>> T create(final Class<T> clazz, final String entry, final String access) {
        final Instance configuration = producer.lookup(board.get(entry), access);

        return create(clazz, configuration);
    }

    public <T extends EvoalComponent<T>> T create(final InjectionPoint ip) {
        final ConfigurationValue annotation = ip.getAnnotated().getAnnotation(ConfigurationValue.class);

        return create((Class<T>)ip.getAnnotated().getBaseType(), annotation.entry(), annotation.access());
    }

    @Produces
    @Dependent
    @Component
    public OptimisationValueComparator createComparator(final InjectionPoint ip) {
        return create(OptimisationValueComparator.class, CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, "algorithm.comparator");
    }


    @Produces
    @Dependent
    @Component
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public OptimisationFunction createOptimisationFunction(final InjectionPoint ip) {
        return create(OptimisationFunction.class, CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, "algorithm.optimisation-function");
    }

    @Produces
    @Dependent
    @Component
    @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "")
    public InitialCandidatesProvider createInitialCandidatesProvider(final InjectionPoint ip) {
        return create(InitialCandidatesProvider.class, CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, "algorithm.initialisation");
    }
}
