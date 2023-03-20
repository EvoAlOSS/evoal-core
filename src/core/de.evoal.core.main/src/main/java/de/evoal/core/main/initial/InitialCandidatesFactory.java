package de.evoal.core.main.initial;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.languages.model.instance.Instance;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class InitialCandidatesFactory {

	@Inject
	@ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initialisation")
	private Instance initialisation;

	/**
	 * Creates an initial generation based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link CoreBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent @Named("initial")
	public InitialCandidatesProvider create() {
		return BeanFactory.create(initialisation.getDefinition().getName(), InitialCandidatesProvider.class)
						  .init(initialisation);
	}
}
