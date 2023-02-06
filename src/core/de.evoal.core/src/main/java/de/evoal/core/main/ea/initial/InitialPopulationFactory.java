package de.evoal.core.main.ea.initial;

import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class InitialPopulationFactory {

	@Inject
	@ConfigurationValue(entry = BlackboardEntry.OPTIMISATION_CONFIGURATION, access = "algorithm.initialization")
	private Instance initialization;

	/**
	 * Creates an initial generation based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link BlackboardEntry#OPTIMISATION_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent @Named("initial")
	public InitialPopulation create() {
		return BeanFactory.create(initialization.getName().getName(), InitialPopulation.class)
						  .init(initialization);
	}
}
