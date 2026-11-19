package de.evoal.optimisation.ea.main.replacement;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.replacement.AbstractReplacement;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Survivor replacement (DL type {@code 'survivor-replacement'}): N - lambda survivors are
 *   selected from the parents, and all lambda children survive. The survivors come first.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.survivor-replacement")
public class SurvivorReplacement extends AbstractReplacement {
    public SurvivorReplacement() {
    }

    /**
     * @param selection Selects the survivors.
     */
    public SurvivorReplacement(final SelectionMethod selection) {
        super(selection);
    }

    @Override
    public void check(final int size, final int offspring) throws InitializationException {
        if(offspring > size) {
            throw new InitializationException("The 'survivor-replacement' keeps all " + offspring + " children, but the population has only "
                                              + size + " candidates; use 'plus-replacement' or 'comma-replacement'.");
        }
    }

    @Override
    public String name() {
        return "survivor-replacement";
    }

    @Override
    public List<Candidate> replace(final List<Candidate> parents, final List<Candidate> children, final int size,
                                   final CandidateOrder order, final RandomGenerator random) {
        final List<Candidate> next = new ArrayList<>(selection().select(parents, size - children.size(), order, random));
        next.addAll(children);

        return next;
    }
}
