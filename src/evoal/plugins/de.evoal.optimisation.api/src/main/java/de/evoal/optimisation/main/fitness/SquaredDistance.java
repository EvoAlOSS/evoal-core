package de.evoal.optimisation.main.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.fitness.TargetDistance;

/**
 * The squared distance {@code (v - t)^2}.
 */
@Dependent
@Named("de.evoal.optimisation.core.squared-distance")
public class SquaredDistance implements TargetDistance {
    @Override
    public double distance(final double value, final double target) {
        final double difference = value - target;

        return difference * difference;
    }
}
