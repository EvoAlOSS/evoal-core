package de.evoal.optimisation.sa.main.cooling;

import de.evoal.optimisation.sa.api.cooling.CoolingStrategy;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Logarithmic cooling strategy determines new temperature according to formula:
 * T(k) = T_0/log(k+1)
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.sa.optimisation.logarithmic-cooling")
public class LogarithmicCoolingStrategy implements CoolingStrategy {


    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initial-temperature")
    private double initialTemperature;


    @Override
    public double cool(double currentTemp, int iteration) {
        double newTemp = this.initialTemperature/(Math.log(iteration+1));
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public LogarithmicCoolingStrategy init(final Instance config) {
        return this;
    }
}