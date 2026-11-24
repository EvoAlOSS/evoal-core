package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.math.EvoalMath;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.Rankings;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Boltzmann selection (DL type {@code 'boltzmann-selection'}): a candidate with fitness f is
 *   selected with a probability proportional to exp(-(f - f_min) / temperature), where f_min
 *   is the smallest finite fitness of the candidates. A fitness of +Infinity is never
 *   selected while a candidate has another fitness; if a fitness is -Infinity, only the
 *   candidates with -Infinity are selected; NaN is an error.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.boltzmann-selection")
public class BoltzmannSelection implements SelectionMethod {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The temperature.
     */
    private double temperature;

    public BoltzmannSelection() {
    }

    /**
     * @param temperature The temperature.
     */
    public BoltzmannSelection(final double temperature) {
        this.temperature = temperature;
    }

    @Override
    public SelectionMethod init(final EObject configuration) {
        temperature = evaluator.attributeToDouble(configuration, "temperature");
        return this;
    }

    @Override
    public String name() {
        return "boltzmann-selection";
    }

    /**
     * @return The weights exp(-(f - f_min) / temperature) of the candidates, with f_min the
     *   smallest finite fitness; non-finite fitness as in {@link Rankings#proportionalWeights}.
     */
    double[] weights(final List<Candidate> candidates) {
        return Rankings.proportionalWeights(candidates, name(),
                                            (fitness, best, worst) -> EvoalMath.exp(-(fitness - best) / temperature));
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        return Rankings.drawAll(candidates, weights(candidates), count, random);
    }
}
