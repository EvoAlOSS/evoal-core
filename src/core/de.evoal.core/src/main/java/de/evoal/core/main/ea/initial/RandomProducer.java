package de.evoal.core.main.ea.initial;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;

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
    @Named("random")
    public InitialPopulation create(@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.initialization") Instance initialization) {
        final InitialPopulation population = new RandomInitialPopulation();
        BeanFactory.injectFields(population);
        population.init(initialization);

        return population;
    }
}
