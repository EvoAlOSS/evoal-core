package de.evoal.optimisation.local_search.main.cooling;

import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.expressions.Instance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Geometric cooling schedule determines new temperature according to formula:
 * T(k) = T(k-1) * cooling_rate
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.geometric-decrease")
public class GeometricDecreaseFunction implements DecreasingFunction {


    @Inject
    private AttributeEvaluator evaluator;

    /*should be quite high, between 0.8-0.99*/
    private double rate;

    @Override
    public double decrease(double currentTemp, double initialTemp, int iteration) {
        double newTemp = currentTemp * rate;
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public GeometricDecreaseFunction init(final Instance config) {
        this.rate = evaluator.attributeToDouble(config, "decrease-rate");
        if(this.rate < 0.0 || this.rate > 1.0) {
            log.error("Decrease rate must be between 0 and 1.");
            throw new IllegalArgumentException("Error initialising geometric decrease strategy");
        }
        log.info("Setting decrease rate to {}", this.rate);
        return this;
    }
}