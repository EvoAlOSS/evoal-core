package de.evoal.optimisation.sa.main.cooling;

import de.evoal.optimisation.sa.api.cooling.CoolingStrategy;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.languages.model.base.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Exponential cooling strategy determines new temperature according to formula:
 * T(k) = T_0 * exp(-k^(1/N))
 * where T_0 = initial temperature, k = iteration and N = dimension of search space
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.sa.optimisation.exponential-cooling")
public class ExponentialCoolingStrategy implements CoolingStrategy {


    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.initial-temperature")
    private double initialTemperature;

    private int searchSpecSize;


    @Override
    public double cool(double currentTemp, int iteration) {
        double newTemp = this.initialTemperature * Math.exp(-1 * (Math.pow(iteration, (1/this.searchSpecSize))));
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public ExponentialCoolingStrategy init(final Instance config) {
        this.searchSpecSize = searchSpaceSpecification.size();
        return this;
    }
}