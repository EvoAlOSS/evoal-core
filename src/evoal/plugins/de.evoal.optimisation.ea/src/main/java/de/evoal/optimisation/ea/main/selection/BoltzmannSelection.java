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
import de.evoal.optimisation.ea.api.selection.Rankings;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Boltzmann selection (DL type {@code 'boltzmann-selection'}): a candidate with fitness f is
 *   selected with a probability proportional to exp(-(f - f_min) / temperature), where f_min
 *   is the smallest fitness of the candidates.
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

    @Override
    public boolean needsSingleFitness() {
        return true;
    }

    /**
     * @return The weights exp(-(f - f_min) / temperature) of the candidates.
     */
    double[] weights(final List<Candidate> candidates) {
        final double[] fitness = Rankings.singleFitness(candidates);

        double minimum = Double.POSITIVE_INFINITY;
        for(final double value : fitness) {
            minimum = Math.min(minimum, value);
        }

        final double[] weights = new double[fitness.length];
        for(int i = 0; i < fitness.length; ++i) {
            weights[i] = EvoalMath.exp(-(fitness[i] - minimum) / temperature);
        }

        return weights;
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final RandomGenerator random) {
        return Rankings.drawAll(candidates, weights(candidates), count, random);
    }
}
