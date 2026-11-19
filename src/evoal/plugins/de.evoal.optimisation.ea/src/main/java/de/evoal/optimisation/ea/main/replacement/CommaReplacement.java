package de.evoal.optimisation.ea.main.replacement;

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
 * Comma replacement (DL type {@code 'comma-replacement'}), the (mu, lambda) strategy: N
 *   candidates are selected from the children only.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.comma-replacement")
public class CommaReplacement extends AbstractReplacement {
    public CommaReplacement() {
    }

    /**
     * @param selection Selects the survivors.
     */
    public CommaReplacement(final SelectionMethod selection) {
        super(selection);
    }

    @Override
    public void check(final int size, final int offspring) throws InitializationException {
        if(offspring < size) {
            throw new InitializationException("The 'comma-replacement' selects " + size + " candidates from the children, but there are only "
                                              + offspring + "; set 'number-of-offspring' to at least 'size-of-population'.");
        }
    }

    @Override
    public String name() {
        return "comma-replacement";
    }

    @Override
    public List<Candidate> replace(final List<Candidate> parents, final List<Candidate> children, final int size,
                                   final CandidateOrder order, final RandomGenerator random) {
        return selection().select(children, size, order, random);
    }
}
