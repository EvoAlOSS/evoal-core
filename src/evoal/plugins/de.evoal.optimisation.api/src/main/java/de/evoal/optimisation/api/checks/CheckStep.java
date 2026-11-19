package de.evoal.optimisation.api.checks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
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
     * The name of the property with the number of variations of a resampled candidate.
     */
    static final String ATTEMPTS = CandidateCheckProducer.ATTEMPTS;

    /**
     * The checks with the sources of the current run.
     */
    private final List<RunCheck> checks;

    /**
     * The number of failed candidates per check in the last execution, empty before.
     */
    private List<Integer> failures = List.of();

    /**
     * Redoes the variation for {@code resample}, {@code null} if the step cannot resample.
     */
    private final Resampler resampler;

    /**
     * The number of tested candidates in the last execution.
     */
    private int tested;

    /**
     * @param checks The checks of the check point, in the configured order.
     * @param resampler Redoes the variation for {@code resample}, {@code null} if the step
     *   cannot resample.
     */
    CheckStep(final List<ConfiguredCheck> checks, final Resampler resampler) {
        this.checks = checks.stream()
                            .map(RunCheck::new)
                            .toList();
        this.resampler = resampler;
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
                    case RESAMPLE -> result.set(i, resample(state, i, check, reason));
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
     * Redoes the variation of the candidate at the index until it passes the check, at most
     *   {@link CandidateCheck#maximumAttempts()} times; the last candidate is kept.
     *
     * @return The candidate with the number of its variations as property {@code attempts}.
     */
    private Candidate resample(final SearchState state, final int index, final CandidateCheck check, final String reason) {
        if(resampler == null) {
            throw new IllegalStateException("The check '" + check.name() + "' resamples, but the step cannot redo the variation.");
        }

        for(int attempt = 1; attempt <= check.maximumAttempts(); ++attempt) {
            final Candidate resampled = resampler.resample(state, index);
            final boolean passes = check.test(resampled).isEmpty();

            if(passes || attempt == check.maximumAttempts()) {
                if(!passes) {
                    log.warn("Iteration {}: the candidate {} still fails the check {} after {} variations; keeping it.",
                             state.getIteration(), resampled.input(), reason, attempt + 1);
                }
                return withAttempts(resampled, attempt + 1);
            }
        }

        throw new IllegalStateException("The check '" + check.name() + "' allows no attempts.");
    }

    /**
     * @return The candidate with the number of variations as property {@code attempts}: on
     *   its relationship, or on itself if it has no predecessor.
     */
    private static Candidate withAttempts(final Candidate candidate, final int attempts) {
        final Lineage lineage = candidate.lineage();
        if(lineage.kind() == Lineage.Kind.NONE) {
            candidate.setProperty(ATTEMPTS, (long) attempts);
            return candidate;
        }

        final Lineage counted = lineage.withProperty(ATTEMPTS, (long) attempts);
        return candidate.isEvaluated()
                ? Candidate.evaluated(candidate.input(), candidate.evaluation(), counted)
                : new Candidate(candidate.input(), counted);
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
