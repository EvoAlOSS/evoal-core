package de.evoal.optimisation.api.constraints;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * Measures how far a candidate violates a constraint (DL type {@code 'constraint-measure'},
 *   configured once per algorithm in {@code 'constraint-measure'}). The degree of violation is
 *   never negative and 0 exactly if the constraint is satisfied.
 */
public interface ConstraintMeasure extends EvoalComponent<ConstraintMeasure> {
    /**
     * @param constraint The constraint.
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate; may be
     *   {@code null} if the constraint reads no objectives.
     * @return The degree of violation.
     */
    double degreeOf(Constraint constraint, TypedEObject input, TypedEObject objectives);
}
