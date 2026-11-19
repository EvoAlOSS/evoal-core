package de.evoal.optimisation.api.constraints;

import java.util.List;
import java.util.Optional;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * Changes a candidate so that it satisfies constraints on search features (DL type
 *   {@code 'constraint-repair'}, used by {@code 'constraint-check'} with the reaction
 *   {@code repair}). A repair is deterministic; one call is one attempt, and a check may call
 *   it again on the result.
 */
public interface ConstraintRepair extends EvoalComponent<ConstraintRepair> {
    /**
     * @param constraint A constraint on search features.
     * @return Why the repair cannot handle the constraint, empty if it can.
     */
    Optional<String> cannotRepair(Constraint constraint);

    /**
     * @return The name of the strategy for reports and the memory model, e.g.
     *   {@code projection-repair}.
     */
    String name();

    /**
     * One attempt of the repair.
     *
     * @param input The candidate (a point of the search space); it is not changed.
     * @param constraints The constraints to satisfy, in the order of the DDL; the repair can
     *   handle every one of them.
     * @return A changed copy of the candidate.
     */
    TypedEObject repair(TypedEObject input, List<Constraint> constraints);
}
