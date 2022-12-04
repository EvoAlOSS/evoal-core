package de.evoal.core.main.ea.initial;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class InitialPopulationFactory {
	/**
	 * Creates a initial generation based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link BlackboardEntry#EA_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent
	public InitialPopulation create(@ConfigurationValue(entry = BlackboardEntry.EA_CONFIGURATION, access = "algorithm.initialization") final Instance initialization) {
		return BeanFactory.create(initialization.getName().getName(), InitialPopulation.class)
						  .init(initialization);
	}
}
