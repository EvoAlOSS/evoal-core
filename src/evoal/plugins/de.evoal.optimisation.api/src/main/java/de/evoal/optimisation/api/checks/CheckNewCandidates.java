package de.evoal.optimisation.api.checks;

import java.util.List;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Applies the checks of the check point {@link CheckPoint#NEW_CANDIDATES} to the current
 *   candidates. Algorithms place it after the variation and before the evaluation, so a
 *   failed candidate costs no evaluation.
 * <p>
 * A failed candidate is not evaluated, so the memory model has no individual for it. Its
 *   replacement therefore has no predecessor; it gets the property {@code reason} instead.
 */
public final class CheckNewCandidates extends CheckStep {
    /**
     * @param checks The checks of new candidates, in the configured order.
     */
    public CheckNewCandidates(final List<ConfiguredCheck> checks) {
        super(checks);
    }

    @Override
    public void execute(final SearchState state) {
        final List<Candidate> checked = apply(state, state.getCandidates(), CheckNewCandidates::replacementOf);

        state.setCandidates(checked);
    }

    private static Candidate replacementOf(final Candidate failed, final String reason, final ReplacementSource source) {
        final Candidate replacement = new Candidate(source.next(), Lineage.NONE);
        replacement.setProperty(REASON, reason);

        return replacement;
    }
}
