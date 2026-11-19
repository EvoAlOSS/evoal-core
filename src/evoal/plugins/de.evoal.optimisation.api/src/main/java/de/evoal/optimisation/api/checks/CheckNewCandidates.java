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
 *   For {@code resample}, the {@link Resampler} of the algorithm redoes the variation.
 */
public final class CheckNewCandidates extends CheckStep {
    /**
     * @param checks The checks of new candidates, in the configured order.
     */
    public CheckNewCandidates(final List<ConfiguredCheck> checks) {
        super(checks, null);
    }

    /**
     * @param checks The checks of new candidates, in the configured order.
     * @param resampler Redoes the variation for {@code resample}.
     */
    public CheckNewCandidates(final List<ConfiguredCheck> checks, final Resampler resampler) {
        super(checks, resampler);
    }

    private CheckNewCandidates(final List<RunCheck> checks, final Resampler resampler, final boolean shared) {
        super(checks, resampler, shared);
    }

    /**
     * @param resampler Creates a new candidate for {@code resample} at the other place.
     * @return A step with the same checks and replacement sources and another resampler, e.g.,
     *   for the initial candidates and the children of an algorithm. A replacing check takes
     *   its candidates from one stream at both places.
     */
    public CheckNewCandidates withResampler(final Resampler resampler) {
        return new CheckNewCandidates(runChecks(), resampler, true);
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
