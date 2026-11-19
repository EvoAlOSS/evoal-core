package de.evoal.optimisation.api.fitness;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.ViolationRecord;

/**
 * What a {@link FitnessStep} knows about the candidate whose fitness it computes.
 *
 * @param input The candidate (a point of the search space).
 * @param objectives The result of the optimisation function for the candidate.
 * @param goals The goals of the problem.
 * @param violations How far the candidate violates the constraints of the problem.
 */
public record FitnessContext(TypedEObject input, TypedEObject objectives, Goals goals, ViolationRecord violations) {
    /**
     * Creates the context of a candidate of a problem without constraints.
     *
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate.
     * @param goals The goals of the problem.
     */
    public FitnessContext(final TypedEObject input, final TypedEObject objectives, final Goals goals) {
        this(input, objectives, goals, ViolationRecord.NONE);
    }
}
