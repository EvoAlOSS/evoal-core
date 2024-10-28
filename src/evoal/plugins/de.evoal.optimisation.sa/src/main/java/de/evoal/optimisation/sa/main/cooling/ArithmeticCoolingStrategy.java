package de.evoal.optimisation.sa.main.cooling;

import de.evoal.optimisation.sa.api.cooling.CoolingStrategy;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.Instance;
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
@Named("de.evoal.optimisation.sa.optimisation.arithmetic-cooling")
public class ArithmeticCoolingStrategy implements CoolingStrategy {

    @Inject
    private AttributeEvaluator evaluator;

    private double rate;

    @Override
    public double cool(double currentTemp, int iteration) {
        double newTemp = currentTemp - (iteration * this.rate);
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public ArithmeticCoolingStrategy init(final Instance config) {
        this.rate = evaluator.attributeToDouble(config, "rate");
        log.info("Setting arithmetic rate to {}", this.rate);
        return this;
    }
}