package de.evoal.optimisation.ea.main.replacement;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.replacement.AbstractReplacement;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * Plus replacement (DL type {@code 'plus-replacement'}), the (mu + lambda) strategy: N
 *   candidates are selected from the parents followed by the children.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.plus-replacement")
public class PlusReplacement extends AbstractReplacement {
    public PlusReplacement() {
    }

    /**
     * @param selection Selects the survivors.
     */
    public PlusReplacement(final SelectionMethod selection) {
        super(selection);
    }

    @Override
    public String name() {
        return "plus-replacement";
    }

    @Override
    public List<Candidate> replace(final List<Candidate> parents, final List<Candidate> children, final int size,
                                   final RandomGenerator random) {
        final List<Candidate> pool = new ArrayList<>(parents);
        pool.addAll(children);

        return selection().select(pool, size, random);
    }
}
