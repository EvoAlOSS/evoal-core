package de.evoal.optimisation.local_search.main.cooling;

import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Linear decrease schedule determines new temperature according to formula:
 * T(k) = T_0 - (k * T_0/#iterations)
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.linear-decrease")
public class LinearDecreaseFunction implements DecreasingFunction {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = initialTemp - (iteration * (initialTemp/this.maxIterations));
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public LinearDecreaseFunction init(final Instance config) {
        return this;
    }
}