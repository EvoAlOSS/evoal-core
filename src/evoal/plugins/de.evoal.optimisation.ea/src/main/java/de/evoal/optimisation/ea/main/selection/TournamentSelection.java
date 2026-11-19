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
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Tournament selection (DL type {@code 'tournament-selection'}): every selected candidate is
 *   the best of {@code size} candidates drawn uniformly with replacement; on equal values the
 *   first drawn one wins.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.tournament-selection")
public class TournamentSelection implements SelectionMethod {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The number of candidates in a tournament.
     */
    private int size = 2;

    public TournamentSelection() {
    }

    /**
     * @param size The number of candidates in a tournament.
     */
    public TournamentSelection(final int size) {
        this.size = size;
    }

    @Override
    public SelectionMethod init(final EObject configuration) {
        size = evaluator.attributeToInteger(configuration, "size");
        return this;
    }

    @Override
    public String name() {
        return "tournament-selection";
    }

    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final RandomGenerator random) {
        final List<Candidate> selected = new ArrayList<>(count);

        for(int i = 0; i < count; ++i) {
            Candidate best = candidates.get(random.nextInt(candidates.size()));
            for(int j = 1; j < size; ++j) {
                final Candidate competitor = candidates.get(random.nextInt(candidates.size()));
                if(competitor.value().isBetter(best.value())) {
                    best = competitor;
                }
            }
            selected.add(best);
        }

        return selected;
    }
}
