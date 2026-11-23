package de.evoal.optimisation.ea.main.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Elitism (DL type {@code 'elite-selection'}): the {@code count} best candidates are selected
 *   first (at most as many as requested), the remaining ones by {@code rest} from all
 *   candidates.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.elite-selection")
public class EliteSelection implements SelectionMethod {
    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private AttributeHelper helper;

    /**
     * The number of best candidates that are always selected.
     */
    private int count;

    /**
     * Selects the remaining candidates.
     */
    private SelectionMethod rest;

    public EliteSelection() {
    }

    /**
     * @param count The number of best candidates that are always selected.
     * @param rest Selects the remaining candidates.
     */
    public EliteSelection(final int count, final SelectionMethod rest) {
        this.count = count;
        this.rest = rest;
    }

    @Override
    public SelectionMethod init(final EObject configuration) {
        count = evaluator.attributeToInteger(configuration, "count");
        rest = BeanFactory.createComponent(SelectionMethod.class, helper.<EObject>lookup(configuration, "rest"));
        return this;
    }

    @Override
    public String name() {
        return "elite-selection";
    }

    @Override
    public boolean needsSingleFitness() {
        return rest.needsSingleFitness();
    }

    @Override
    public boolean sortsIntoFronts() {
        return rest.sortsIntoFronts();
    }

    @Override
    public boolean ranksStochastically() {
        return rest.ranksStochastically();
    }

    /**
     * @return The elite plus what {@code rest} can choose, since {@code rest} chooses from all
     *   candidates.
     */
    @Override
    public int maximumCount(final int candidates) {
        final int remaining = rest.maximumCount(candidates);
        if(remaining == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return Math.min(count, candidates) + remaining;
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        final int elite = Math.min(this.count, Math.min(count, candidates.size()));
        final List<Candidate> selected = new ArrayList<>(order.bestFirst(candidates).subList(0, elite));
        selected.addAll(rest.select(candidates, count - elite, order, random));

        return selected;
    }
}
