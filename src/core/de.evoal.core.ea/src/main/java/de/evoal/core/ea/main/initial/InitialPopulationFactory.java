package de.evoal.core.ea.main.initial;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.ea.api.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class InitialPopulationFactory {

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initialisation")
	private Instance initialization;

	/**
	 * Creates an initial generation based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link CoreBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent @Named("initial")
	public InitialPopulation create() {
		return BeanFactory.create(initialization.getDefinition().getName(), InitialPopulation.class)
						  .init(initialization);
	}
}
