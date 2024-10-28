package de.evoal.optimisation.sa.api.cooling;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class CoolingStrategyFactory {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.cooling-schedule")
    private Instance config;

    /**
     * Creates a Cooling Strategy based on the configuration.
     *
     * Blackboard slots used:
     * <ul>
     *   <li>{@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
     * </ul>
     */
    @Produces @Dependent @Named("cooling-strategy")
    public CoolingStrategy create() {
        return BeanFactory.createComponent(CoolingStrategy.class, config);
    }
}