package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.ea.api.constraints.strategies.RepairStrategy;
import de.evoal.core.ea.api.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;

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
    public InitialPopulation create(@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initialisation") Instance initialization) {
        final TrainingInitialPopulation population = new TrainingInitialPopulation();
        BeanFactory.injectFields(population);
        population.init();
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
