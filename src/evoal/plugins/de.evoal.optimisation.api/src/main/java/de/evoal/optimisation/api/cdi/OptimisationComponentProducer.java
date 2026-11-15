package de.evoal.optimisation.api.cdi;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.main.producer.ConfigurationValueProducer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.Typed;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

@ApplicationScoped
public class OptimisationComponentProducer {
    @Inject
    private Blackboard board;

    @Inject
    private ComponentProducer producer;

    @Inject
    private ConfigurationValueProducer valueProducer;

    public <T extends EvoalComponent<T>> T create(final Class<T> clazz, final String entry, final String access) {
        final EObject configuration = valueProducer.lookup(board.get(entry), access);

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
    @Named("optimisation-function")
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function")
    @Typed(OptimisationFunction.class) // OptimisationFunction is an EObject, which would clash with ConfigurationValueProducer
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
