package de.evoal.optimisation.main.stopping;

import de.evoal.optimisation.api.model.Iteration;
import de.evoal.optimisation.api.model.StoppingCriterion;

import javax.enterprise.inject.Vetoed;
import java.util.LinkedList;
import java.util.List;

/**
 * Evaluates all stopping critera one after another and stops (and returns {@code true})
 *   as soon as a stopping criterion returns {@code true}.
 */
@Vetoed
public class CriterionCombiner implements StoppingCriterion {
    private List<StoppingCriterion> criteria = new LinkedList<>();

    public void add(final StoppingCriterion criterion) {
        criteria.add(criterion);
    }

    @Override
    public boolean shouldTerminate(final Iteration iteration) {
        for(final StoppingCriterion criterion : criteria) {
            if(criterion.shouldTerminate(iteration)) {
                return true;
            }
        }

        return false;
    }
}
