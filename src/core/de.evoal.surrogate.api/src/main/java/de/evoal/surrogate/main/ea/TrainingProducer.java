package de.evoal.surrogate.main.ea;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.ea.constraints.strategies.RepairStrategy;

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
    public InitialPopulation create(@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.initialization") Instance initialization) {
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
