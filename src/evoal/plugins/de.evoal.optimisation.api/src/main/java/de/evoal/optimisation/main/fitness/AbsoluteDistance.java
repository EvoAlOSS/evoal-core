package de.evoal.optimisation.main.fitness;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.fitness.TargetDistance;

/**
 * The absolute distance {@code abs(v - t)}.
 */
@Dependent
@Named("de.evoal.optimisation.core.distance")
public class AbsoluteDistance implements TargetDistance {
    @Override
    public double distance(final double value, final double target) {
        return Math.abs(value - target);
    }
}
