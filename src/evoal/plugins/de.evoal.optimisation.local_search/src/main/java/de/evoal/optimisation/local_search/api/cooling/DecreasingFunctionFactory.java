package de.evoal.optimisation.local_search.api.cooling;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;

import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Dependent
public class DecreasingFunctionFactory {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.accepting-strategy.decreasing-function")
    private Instance config;

    /**
     * Creates a Cooling Strategy based on the configuration.
     *
     * Blackboard slots used:
     * <ul>
     *   <li>{@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.</li>
     * </ul>
     */
    @Produces @Dependent @Named("decreasing-function")
    public DecreasingFunction create() {
        return BeanFactory.createComponent(DecreasingFunction.class, config);
    }
}