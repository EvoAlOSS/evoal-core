package de.evoal.optimisation.local_search.main.cooling;

import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Arithmetic cooling schedule decreases temperature according to decreasing arithmetic series.
 * T(k) = T(k-1) - (rate*k)
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.arithmetic-decrease")
public class ArithmeticDecreaseFunction implements DecreasingFunction {

    @Inject
    private AttributeEvaluator evaluator;

    private double rate;

    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = currentTemp - (iteration * this.rate);
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public ArithmeticDecreaseFunction init(final Instance config) {
        this.rate = evaluator.attributeToDouble(config, "rate");
        log.info("Setting arithmetic rate to {}", this.rate);
        return this;
    }
}