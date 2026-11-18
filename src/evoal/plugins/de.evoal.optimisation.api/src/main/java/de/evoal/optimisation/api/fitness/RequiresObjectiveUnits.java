package de.evoal.optimisation.api.fitness;

/**
 * A {@link FitnessStep} that works on fitness components in the units of their objectives,
 *   e.g. a surrogate adaption whose penalty is measured in these units. It must not run after
 *   a step that {@link ChangesUnits changes the units}.
 */
public interface RequiresObjectiveUnits extends FitnessStep {
}
