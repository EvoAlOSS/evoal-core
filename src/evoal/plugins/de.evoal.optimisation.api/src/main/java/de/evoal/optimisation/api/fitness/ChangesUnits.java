package de.evoal.optimisation.api.fitness;

/**
 * A {@link FitnessStep} after which fitness components are no longer in the units of their
 *   objectives, e.g. a scaling. Steps that {@link RequiresObjectiveUnits require these units}
 *   must run before it.
 */
public interface ChangesUnits extends FitnessStep {
}
