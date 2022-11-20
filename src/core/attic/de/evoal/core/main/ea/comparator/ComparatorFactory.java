package de.evoal.core.main.ea.comparator;

import de.evoal.core.api.ea.fitness.type.FitnessConverter;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.ConfigurationValue;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import javax.inject.Named;

@ApplicationScoped
public class ComparatorFactory {
    @Produces
    @Named("depending")
    public FitnessConverter create(@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.comparator.name") String comparator) {
        return (FitnessConverter) BeanProvider.getContextualReference(comparator, false, FitnessConverter.class);
    }
}
