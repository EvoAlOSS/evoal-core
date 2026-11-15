package de.evoal.optimisation.local_search.main.cooling;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;

/**
 * Decreases the value (temperature or threshold) linearly, so that it reaches 0
 *   after the configured number of iterations ({@code iterations}) and stays 0:
 *   T(k) = T_0 - k * T_0 / iterations.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.linear-decrease")
public class LinearDecreaseFunction implements DecreasingFunction {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * Number of iterations until the value reaches 0.
     */
    private int iterations;

    @Override
    public double decrease(final double currentTemp, final double initialTemp, final int iteration) {
        final double decreasePerIteration = initialTemp / iterations;
        final double newTemp = initialTemp - iteration * decreasePerIteration;
        log.info("reducing temperature to {}", newTemp);

        return Math.max(newTemp, 0);
    }

    @Override
    public LinearDecreaseFunction init(final EObject config) {
        iterations = evaluator.attributeToInteger(config, "iterations");

        return this;
    }
}
