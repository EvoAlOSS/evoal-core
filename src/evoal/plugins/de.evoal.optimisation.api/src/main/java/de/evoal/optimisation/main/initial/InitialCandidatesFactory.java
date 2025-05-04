package de.evoal.optimisation.main.initial;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class InitialCandidatesFactory {

	@Inject
	@ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initialisation")
    private Instance initialisation;

	/**
	 * Creates an initial generation based on the heuristic configuration.
	 *
	 * Blackboard slots used:
	 * <ul>
	 *   <li>{@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
	 * </ul>
	 */
	@Produces @Dependent @Named("initial")
	public InitialCandidatesProvider create() {
		return BeanFactory.createComponent(InitialCandidatesProvider.class, initialisation);
	}
}
