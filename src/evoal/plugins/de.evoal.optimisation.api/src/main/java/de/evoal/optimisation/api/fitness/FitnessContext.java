package de.evoal.optimisation.api.fitness;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * What a {@link FitnessStep} knows about the candidate whose fitness it computes.
 *
 * @param input The candidate (a point of the search space).
 * @param objectives The result of the optimisation function for the candidate.
 * @param goals The goals of the problem.
 */
public record FitnessContext(TypedEObject input, TypedEObject objectives, Goals goals) {
}
