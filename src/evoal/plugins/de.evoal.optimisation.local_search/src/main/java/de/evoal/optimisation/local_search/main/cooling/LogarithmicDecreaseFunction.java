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
 * Logarithmic decrease strategy determines new temperature according to formula:
 * T(k) = T_0/log(k+1)
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.logarithmic-decrease")
public class LogarithmicDecreaseFunction implements DecreasingFunction {

    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = initialTemp/(Math.log(iteration+1));
        log.info("reducing to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public LogarithmicDecreaseFunction init(final Instance config) {
        return this;
    }
}