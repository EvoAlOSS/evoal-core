package de.evoal.optimisation.api.events;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;

/**
 * The {@link EvaluationService} evaluated a candidate. The candidate is not yet an
 *   individual of the memory model; the run kernel creates the individual when the
 *   iteration is finished.
 *
 * @param candidate The evaluated candidate (a point of the search space).
 * @param output The result of the optimisation function (a point of the optimisation space).
 * @param source The source that produced the result.
 */
public record IndividualEvaluated(TypedEObject candidate,
                                  TypedEObject output,
                                  EvaluationSource source) implements RunEvent {
}
