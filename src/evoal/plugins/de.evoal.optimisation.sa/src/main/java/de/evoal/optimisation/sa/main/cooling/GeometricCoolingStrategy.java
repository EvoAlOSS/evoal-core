package de.evoal.optimisation.sa.main.cooling;

import de.evoal.optimisation.sa.api.cooling.CoolingStrategy;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.Instance;
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
@Named("de.evoal.optimisation.sa.optimisation.geometric-cooling")
public class GeometricCoolingStrategy implements CoolingStrategy {


    @Inject
    private AttributeEvaluator evaluator;

    /*should be quite high, between 0.8-0.99*/
    private double rate;

    @Override
    public double cool(double currentTemp, int iteration) {
        double newTemp = currentTemp * rate;
        log.info("reducing temperature to {}", newTemp);
        return Math.max(newTemp, 0);
    }

    @Override
    public GeometricCoolingStrategy init(final Instance config) {
        this.rate = evaluator.attributeToDouble(config, "cooling-rate");
        if(this.rate < 0.0 || this.rate > 1.0) {
            log.error("Cooling rate must be between 0 and 1.");
            throw new IllegalArgumentException("Error initialising geometric cooling strategy");
        }
        log.info("Setting cooling rate to {}", this.rate);
        return this;
    }
}