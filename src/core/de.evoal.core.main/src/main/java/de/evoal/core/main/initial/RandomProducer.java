package de.evoal.core.main.initial;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * TODO For some reasons I am not able to create the training instance directly ...
 */
@ApplicationScoped
public class RandomProducer {

    @Produces
    @Dependent
    @Named("random-population")
    public InitialCandidatesProvider create(@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initialisation") Instance initialization) {
        final InitialCandidatesProvider population = new RandomInitialCandidates();
        BeanFactory.injectFields(population);

        return population.init(initialization);
    }
}
