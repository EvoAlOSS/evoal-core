package de.evoal.optimisation.ea.main.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Truncation selection (DL type {@code 'truncation-selection'}): every selected candidate is
 *   drawn uniformly from the best ceil(threshold * n) of the n candidates.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.truncation-selection")
public class TruncationSelection implements SelectionMethod {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The fraction of the candidates that can be selected.
     */
    private double threshold;

    public TruncationSelection() {
    }

    /**
     * @param threshold The fraction of the candidates that can be selected.
     */
    public TruncationSelection(final double threshold) {
        this.threshold = threshold;
    }

    @Override
    public SelectionMethod init(final EObject configuration) {
        threshold = evaluator.attributeToDouble(configuration, "threshold");
        return this;
    }

    @Override
    public String name() {
        return "truncation-selection";
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        final int size = candidates.size();
        final int best = Math.max(1, Math.min(size, (int) Math.ceil(threshold * size)));
        final List<Candidate> sorted = order.bestFirst(candidates);

        final List<Candidate> selected = new ArrayList<>(count);
        for(int i = 0; i < count; ++i) {
            selected.add(sorted.get(random.nextInt(best)));
        }

        return selected;
    }
}
