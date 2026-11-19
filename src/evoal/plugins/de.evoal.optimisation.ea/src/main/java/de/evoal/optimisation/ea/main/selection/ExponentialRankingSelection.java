package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.Rankings;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Exponential ranking selection (DL type {@code 'exponential-ranking-selection'}): the
 *   candidates are ranked from the worst (rank 1) to the best (rank n); a candidate of rank i
 *   is selected with a probability proportional to c^(n - i). Equal candidates get
 *   consecutive ranks in their order.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.exponential-ranking-selection")
public class ExponentialRankingSelection implements SelectionMethod {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The base of the probabilities.
     */
    private double c;

    public ExponentialRankingSelection() {
    }

    /**
     * @param c The base of the probabilities.
     */
    public ExponentialRankingSelection(final double c) {
        this.c = c;
    }

    @Override
    public SelectionMethod init(final EObject configuration) {
        c = evaluator.attributeToDouble(configuration, "c");
        return this;
    }

    @Override
    public String name() {
        return "exponential-ranking-selection";
    }

    /**
     * @return The weight of every position of the ranking, best first: c^position.
     */
    double[] weights(final int size) {
        final double[] weights = new double[size];
        double weight = 1.0;
        for(int position = 0; position < size; ++position) {
            weights[position] = weight;
            weight *= c;
        }

        return weights;
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final RandomGenerator random) {
        return Rankings.drawAll(Rankings.bestFirst(candidates), weights(candidates.size()), count, random);
    }
}
