package de.evoal.optimisation.hc.api.neighbour;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class NeighbourStrategyFactory {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.neighbour-choosing-strategy")
    private Instance config;

    /**
     * Creates an acception function based on the configuration.
     *
     * Blackboard slots used:
     * <ul>
     *   <li>{@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
     * </ul>
     */
    @Produces @Dependent @Named("neighbour-strategy")
    public NeighbourChoosingStrategy create() {
        return BeanFactory.createComponent(NeighbourChoosingStrategy.class, config);
    }
}