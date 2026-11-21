package de.evoal.optimisation.main.stopping;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

/**
 * Stops when all of its criteria are satisfied, e.g. a stagnation criterion together with
 *   a minimum number of iterations.
 */
@Dependent
@Named("de.evoal.optimisation.core.all-of")
public class AllOfCriterion extends CriteriaCombination {
    /**
     * Creates the combination without criteria. CDI uses it before {@code init}.
     */
    public AllOfCriterion() {
    }

    /**
     * @param criteria The combined criteria.
     * @throws IllegalArgumentException if there is no criterion.
     */
    public AllOfCriterion(final List<TerminationCriterion> criteria) {
        super(criteria);
    }

    @Override
    protected boolean combine(final boolean[] results) {
        for(final boolean result : results) {
            if(!result) {
                return false;
            }
        }

        return true;
    }
}
