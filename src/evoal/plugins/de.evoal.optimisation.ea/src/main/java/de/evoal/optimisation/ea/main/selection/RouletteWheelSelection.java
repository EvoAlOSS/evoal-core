package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.Rankings;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Roulette wheel selection (DL type {@code 'roulette-wheel-selection'}) for minimisation with
 *   windowing: a candidate with fitness f is selected with a probability proportional to
 *   f_max - f. If all candidates have the same fitness, every candidate is equally likely.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.roulette-wheel-selection")
public class RouletteWheelSelection implements SelectionMethod {
    /**
     * @return The windowed weights f_max - f of the candidates.
     */
    static double[] windowedWeights(final List<Candidate> candidates) {
        final double[] fitness = Rankings.singleFitness(candidates);

        double maximum = Double.NEGATIVE_INFINITY;
        for(final double value : fitness) {
            maximum = Math.max(maximum, value);
        }

        final double[] weights = new double[fitness.length];
        for(int i = 0; i < fitness.length; ++i) {
            weights[i] = maximum - fitness[i];
        }

        return weights;
    }

    @Override
    public String name() {
        return "roulette-wheel-selection";
    }

    @Override
    public boolean needsSingleFitness() {
        return true;
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        return Rankings.drawAll(candidates, windowedWeights(candidates), count, random);
    }
}
