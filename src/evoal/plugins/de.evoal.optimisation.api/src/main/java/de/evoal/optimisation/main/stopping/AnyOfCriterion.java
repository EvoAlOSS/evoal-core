package de.evoal.optimisation.main.stopping;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

/**
 * Stops when at least one of its criteria is satisfied. The list {@code 'stopping-criteria'}
 *   of an algorithm is combined this way.
 */
@Dependent
@Named("de.evoal.optimisation.core.any-of")
public class AnyOfCriterion extends CriteriaCombination {
    /**
     * Creates the combination without criteria. CDI uses it before {@code init}.
     */
    public AnyOfCriterion() {
    }

    /**
     * @param criteria The combined criteria.
     * @throws IllegalArgumentException if there is no criterion.
     */
    public AnyOfCriterion(final List<TerminationCriterion> criteria) {
        super(criteria);
    }

    @Override
    protected boolean combine(final boolean[] results) {
        for(final boolean result : results) {
            if(result) {
                return true;
            }
        }

        return false;
    }
}
