package de.evoal.optimisation.api.fitness;

import de.evoal.models.core.cdi.EvoalComponent;

/**
 * The distance of a target goal: how far an objective value is from the goal's target.
 *   Distances are instances of the DL type {@code 'target-distance'}.
 * <p>
 * A distance is non-negative and 0 exactly at the target.
 */
public interface TargetDistance extends EvoalComponent<TargetDistance> {
    /**
     * @param value The value of the objective.
     * @param target The target of the goal.
     * @return The distance of the value from the target.
     */
    double distance(double value, double target);
}
