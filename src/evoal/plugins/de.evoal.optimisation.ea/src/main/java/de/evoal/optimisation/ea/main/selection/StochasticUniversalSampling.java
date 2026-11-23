package de.evoal.optimisation.ea.main.selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.Rankings;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Stochastic universal sampling (DL type {@code 'stochastic-universal-sampling'}): the
 *   probabilities of the {@link RouletteWheelSelection}, but all candidates are selected with
 *   one spin and {@code count} equally spaced pointers. A candidate with the expected number
 *   e of selections is selected floor(e) or ceil(e) times. The selected candidates are
 *   returned in random order. Non-finite fitness as in the {@link RouletteWheelSelection}.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.stochastic-universal-sampling")
public class StochasticUniversalSampling implements SelectionMethod {
    @Override
    public String name() {
        return "stochastic-universal-sampling";
    }

    @Override
    public boolean needsSingleFitness() {
        return true;
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        final List<Candidate> selected = new ArrayList<>(count);
        if(count == 0) {
            return selected;
        }

        double[] weights = RouletteWheelSelection.windowedWeights(candidates, name());
        double total = Rankings.sum(weights);
        if(total <= 0.0) {
            weights = new double[candidates.size()];
            Arrays.fill(weights, 1.0);
            total = candidates.size();
        }

        final double distance = total / count;
        final double start = random.nextDouble() * distance;

        int index = 0;
        double cumulated = weights[0];
        for(int i = 0; i < count; ++i) {
            final double pointer = start + i * distance;
            while(pointer >= cumulated && index < weights.length - 1) {
                index += 1;
                cumulated += weights[index];
            }
            selected.add(candidates.get(index));
        }

        // the pointers follow the order of the candidates, so the copies of a candidate are
        // adjacent; consecutive parents form a pair, so the result is shuffled
        Collections.shuffle(selected, random);

        return selected;
    }
}
