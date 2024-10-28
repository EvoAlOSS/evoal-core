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
 * Linear cooling schedule determines new temperature according to formula:
 * T(k) = T_0 - (k * T_0/#iterations)
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.sa.optimisation.linear-cooling")
public class LinearCoolingStrategy implements CoolingStrategy {

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initial-temperature")
    private double initialTemperature;

    private double initialRatio;

    @Override
    public double cool(double currentTemp, int iteration) {
        double newTemp = this.initialTemperature - (iteration * this.initialRatio);
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public LinearCoolingStrategy init(final Instance config) {
        this.initialRatio = this.initialTemperature/this.maxIterations;
        log.info("Initialising temperature to {}", this.initialTemperature);
        return this;
    }
}