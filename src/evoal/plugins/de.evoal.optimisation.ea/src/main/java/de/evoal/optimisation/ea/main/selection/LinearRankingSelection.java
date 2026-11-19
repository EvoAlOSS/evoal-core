package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.Rankings;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Linear ranking selection (DL type {@code 'linear-ranking-selection'}): the candidates are
 *   ranked from the worst (rank 1) to the best (rank n); a candidate of rank i is selected
 *   with probability (eta- + (eta+ - eta-) (i - 1) / (n - 1)) / n with eta+ = 2 - eta-.
 *   Equal candidates get consecutive ranks in their order.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.linear-ranking-selection")
public class LinearRankingSelection implements SelectionMethod {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The expected number of selections of the worst candidate per n selections.
     */
    private double etaMinus;

    public LinearRankingSelection() {
    }

    /**
     * @param etaMinus The expected number of selections of the worst candidate per n
     *   selections.
     */
    public LinearRankingSelection(final double etaMinus) {
        this.etaMinus = etaMinus;
    }

    @Override
    public SelectionMethod init(final EObject configuration) {
        etaMinus = evaluator.attributeToDouble(configuration, "eta-minus");
        return this;
    }

    @Override
    public String name() {
        return "linear-ranking-selection";
    }

    /**
     * @return The selection probability of every position of the ranking, best first.
     */
    double[] probabilities(final int size) {
        final double[] probabilities = new double[size];
        if(size == 1) {
            probabilities[0] = 1.0;
            return probabilities;
        }

        final double etaPlus = 2.0 - etaMinus;
        for(int position = 0; position < size; ++position) {
            final int rank = size - position;
            probabilities[position] = (etaMinus + (etaPlus - etaMinus) * (rank - 1) / (size - 1)) / size;
        }

        return probabilities;
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        return Rankings.drawAll(order.bestFirst(candidates), probabilities(candidates.size()), count, random);
    }
}
