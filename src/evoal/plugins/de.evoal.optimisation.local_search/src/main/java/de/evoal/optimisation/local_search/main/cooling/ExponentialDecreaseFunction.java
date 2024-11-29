package de.evoal.optimisation.local_search.main.cooling;

import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
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
@Named("de.evoal.optimisation.local_search.optimisation.exponential-decrease")
public class ExponentialDecreaseFunction implements DecreasingFunction {


    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    @Named("search-space-specification")
    private PropertiesSpecification searchSpaceSpecification;


    private int searchSpecSize;


    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = initialTemp * Math.exp(-1 * (Math.pow(iteration, (1/this.searchSpecSize))));
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public ExponentialDecreaseFunction init(final Instance config) {
        this.searchSpecSize = searchSpaceSpecification.size();
        return this;
    }
}