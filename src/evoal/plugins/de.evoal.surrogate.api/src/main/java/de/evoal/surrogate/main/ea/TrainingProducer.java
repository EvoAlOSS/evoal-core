package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.constraints.strategies.RepairStrategy;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * TODO For some reasons I am not able to create the training instance directly ...
 */
@ApplicationScoped
public class TrainingProducer {

    @Produces
    @Dependent
    @Named("training")
    public InitialCandidatesProvider create(@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initialisation") Instance initialization) {
        final InitialCandidatesProvider population = new TrainingInitialCandidates();
        BeanFactory.injectFields(population);
        population.init(initialization);

        return population;
    }

    @Produces
    @Dependent
    @Named("repair-with-training")
    public RepairStrategy create() {

        final RepairStrategy strategy = new TrainingRepairStrategy();
        BeanFactory.injectFields(strategy);

        return strategy;
    }
}
