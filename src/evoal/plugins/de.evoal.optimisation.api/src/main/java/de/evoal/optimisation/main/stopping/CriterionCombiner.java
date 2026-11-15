package de.evoal.optimisation.main.stopping;

import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import jakarta.enterprise.inject.Vetoed;

import java.util.LinkedList;
import java.util.List;

/**
 * Evaluates all stopping criteria one after another and stops (and returns {@code true})
 *   as soon as a stopping criterion returns {@code true}. The evaluation is a lazy one
 *   so the first criterion that returns {@code true} will stop any further evaluation.
 */
@Vetoed
public class CriterionCombiner extends TerminationCriterionImpl {
    /**
     * List of all criteria to check.
     */
    private final List<TerminationCriterion> criteria = new LinkedList<>();

    /**
     * Adds a new criterion to the list of criteria to check.
     *
     * @param criterion The criterion to add.
     */
    public void add(final TerminationCriterion criterion) {
        criteria.add(criterion);
    }

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        return criteria
                .stream()
                .anyMatch(c -> c.shouldTerminate(iteration));
    }
}
