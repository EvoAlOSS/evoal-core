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
 *   f_max - f, where f_max is the largest finite fitness. If all candidates have the same
 *   fitness, every candidate is equally likely. A fitness of +Infinity is never selected
 *   while a candidate has another fitness; if a fitness is -Infinity, only the candidates
 *   with -Infinity are selected; NaN is an error.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.roulette-wheel-selection")
public class RouletteWheelSelection implements SelectionMethod {
    /**
     * @param selection The name of the selection, for the error message.
     * @return The windowed weights f_max - f of the candidates, with f_max the largest finite
     *   fitness; non-finite fitness as in {@link Rankings#proportionalWeights}.
     */
    static double[] windowedWeights(final List<Candidate> candidates, final String selection) {
        return Rankings.proportionalWeights(candidates, selection, (fitness, best, worst) -> worst - fitness);
    }

    @Override
    public String name() {
        return "roulette-wheel-selection";
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        return Rankings.drawAll(candidates, windowedWeights(candidates, name()), count, random);
    }
}
