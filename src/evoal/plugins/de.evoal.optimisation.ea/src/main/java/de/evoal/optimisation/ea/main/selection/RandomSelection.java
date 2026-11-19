package de.evoal.optimisation.ea.main.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Random selection (DL type {@code 'random-selection'}): every selected candidate is drawn
 *   uniformly.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.random-selection")
public class RandomSelection implements SelectionMethod {
    @Override
    public String name() {
        return "random-selection";
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        final List<Candidate> selected = new ArrayList<>(count);
        for(int i = 0; i < count; ++i) {
            selected.add(candidates.get(random.nextInt(candidates.size())));
        }

        return selected;
    }
}
