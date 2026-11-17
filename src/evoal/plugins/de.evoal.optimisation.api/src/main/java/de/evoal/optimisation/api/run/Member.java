package de.evoal.optimisation.api.run;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

/**
 * An evaluated candidate of a population. The kernel turns it into an individual of the
 *   memory model.
 *
 * @param input The candidate (a point of the search space).
 * @param output The result of the optimisation function (a point of the optimisation space).
 * @param value The optimisation value of the output; it decides the best individual so far.
 * @param lineage How the member came from the previous population.
 */
public record Member(TypedEObject input, TypedEObject output, OptimisationValue value, Lineage lineage) {
}
