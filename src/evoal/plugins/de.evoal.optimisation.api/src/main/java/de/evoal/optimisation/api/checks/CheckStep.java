package de.evoal.optimisation.api.checks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.steps.Check;
import de.evoal.optimisation.api.steps.SearchState;

/**
 * Applies the checks of one check point to a list of candidates, in the configured order.
 *   A check tests the candidates as the checks before it left them. The description names
 *   every check with its reaction and, after an execution, how many candidates failed.
 */
@Slf4j
abstract class CheckStep implements Check {
    /**
     * The name of the property that states why a candidate was replaced.
     */
    static final String REASON = CandidateCheckProducer.REASON;

    /**
     * The checks with the sources of the current run.
     */
    private final List<RunCheck> checks;

    /**
     * The number of failed candidates per check in the last execution, empty before.
     */
    private List<Integer> failures = List.of();

    /**
     * The number of tested candidates in the last execution.
     */
    private int tested;

    /**
     * @param checks The checks of the check point, in the configured order.
     */
    CheckStep(final List<ConfiguredCheck> checks) {
        this.checks = checks.stream()
                            .map(RunCheck::new)
                            .toList();
    }

    @Override
    public String description() {
        final List<String> parts = new ArrayList<>();

        for(int i = 0; i < checks.size(); ++i) {
            final CandidateCheck check = checks.get(i).check();
            final String part = check.name() + " (" + check.reaction() + ")";

            parts.add(failures.isEmpty() ? part : part + ": " + failures.get(i) + " of " + tested + " candidates failed");
        }

        return String.join("; ", parts);
    }

    /**
     * Tests the candidates with all checks and applies the reactions.
     *
     * @param state The search state, for the log.
     * @param candidates The candidates to test.
     * @param replace Creates the replacement of a failed candidate with the reason.
     * @return The candidates after the reactions, in the same order.
     */
    final List<Candidate> apply(final SearchState state, final List<Candidate> candidates, final Replacer replace) {
        final List<Candidate> result = new ArrayList<>(candidates);
        final List<Integer> counts = new ArrayList<>();

        for(final RunCheck runCheck : checks) {
            final CandidateCheck check = runCheck.check();
            int failed = 0;

            for(int i = 0; i < result.size(); ++i) {
                final Candidate candidate = result.get(i);
                final Optional<String> failure = check.test(candidate);
                if(failure.isEmpty()) {
                    continue;
                }

                failed += 1;
                final String reason = check.name() + ": " + failure.get();
                switch(check.reaction()) {
                    case WARN -> log.warn("Iteration {}: candidate {} failed the check {}.", state.getIteration(), candidate.input(), reason);
                    case REPLACE -> {
                        log.info("Iteration {}: candidate {} failed the check {}, replacing it.", state.getIteration(), candidate.input(), reason);
                        result.set(i, replace.replace(candidate, reason, runCheck.source()));
                    }
                    default -> throw new IllegalStateException("The reaction '" + check.reaction() + "' of the check '"
                                                               + check.name() + "' is not supported.");
                }
            }

            counts.add(failed);
        }

        tested = candidates.size();
        failures = List.copyOf(counts);

        return result;
    }

    /**
     * Creates the replacement of a failed candidate.
     */
    @FunctionalInterface
    interface Replacer {
        /**
         * @param failed The candidate that failed.
         * @param reason Why it failed, with the name of the check.
         * @param source The source of the replacement.
         * @return The replacement.
         */
        Candidate replace(Candidate failed, String reason, ReplacementSource source);
    }

    /**
     * A check with the replacement source of the current run.
     *
     * @param check The check.
     * @param source The replacement source, {@code null} if the check does not replace.
     */
    private record RunCheck(CandidateCheck check, ReplacementSource source) {
        RunCheck(final ConfiguredCheck configured) {
            this(configured.check(), configured.sources() == null ? null : configured.sources().get());
        }
    }

}
