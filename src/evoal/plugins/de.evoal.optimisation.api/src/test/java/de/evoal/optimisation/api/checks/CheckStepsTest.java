package de.evoal.optimisation.api.checks;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.fitness.BatchEvaluation;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.steps.SearchState;

public class CheckStepsTest {
    /**
     * The candidates of the replacement source, in order.
     */
    private final List<TypedEObject> replacements = List.of(Mockito.mock(TypedEObject.class),
                                                            Mockito.mock(TypedEObject.class),
                                                            Mockito.mock(TypedEObject.class));

    /**
     * Provides {@link #replacements}; counts how often a stream is created.
     */
    private final InitialCandidatesProvider provider = Mockito.mock(InitialCandidatesProvider.class);

    /**
     * Evaluates every input, unless {@link #budget} is smaller than the batch.
     */
    private final Evaluator evaluator = Mockito.mock(Evaluator.class);

    private int budget = Integer.MAX_VALUE;

    private final SearchState state = new SearchState();

    @BeforeEach
    public void mockProviderAndEvaluator() {
        Mockito.when(provider.create()).thenAnswer(invocation -> replacements.stream());
        Mockito.when(evaluator.evaluateAll(Mockito.anyList())).thenAnswer(invocation -> {
            final List<TypedEObject> inputs = invocation.getArgument(0);
            final List<Evaluation> evaluations = inputs.stream()
                                                       .limit(budget)
                                                       .map(input -> evaluation())
                                                       .toList();
            final EvaluationBudgetExhaustedException exhaustion = evaluations.size() < inputs.size()
                    ? new EvaluationBudgetExhaustedException(EvaluationSource.REAL, budget)
                    : null;

            return new BatchEvaluation(evaluations, exhaustion);
        });
    }

    private static Evaluation evaluation() {
        return new Evaluation(Mockito.mock(TypedEObject.class),
                              new Fitness(FitnessLayout.EMPTY, new double[0]),
                              Mockito.mock(OptimisationValue.class));
    }

    private static Candidate member() {
        return Candidate.evaluated(Mockito.mock(TypedEObject.class), evaluation(), Lineage.NONE).survivor();
    }

    private ConfiguredCheck check(final String name, final CheckPoint point, final CheckReaction reaction,
                                  final Predicate<Candidate> fails) {
        final TestCheck check = new TestCheck(name, point, reaction, fails);

        return reaction == CheckReaction.REPLACE
                ? new ConfiguredCheck(check, () -> new ReplacementSource(provider))
                : ConfiguredCheck.withoutSource(check);
    }

    @Nested
    @DisplayName("given a population check")
    class PopulationChecks {
        private final Candidate passing = member();
        private final Candidate failing = member();

        @BeforeEach
        public void population() {
            state.setPopulation(List.of(passing, failing));
        }

        @Test
        public void aWarningKeepsThePopulation() {
            // given
            final CheckPopulation step = new CheckPopulation(List.of(check("test", CheckPoint.POPULATION, CheckReaction.WARN,
                                                                           candidate -> candidate == failing)),
                                                             evaluator);

            // when
            step.execute(state);

            // then
            Assertions.assertEquals(List.of(passing, failing), state.getPopulation());
            Assertions.assertEquals("test (warn): 1 of 2 candidates failed", step.description());
            Assertions.assertEquals("Check", step.kind());
            Mockito.verify(evaluator).evaluateAll(List.of());
        }

        @Test
        public void aFailedMemberIsReplacedByAnEvaluatedCandidateThatRefersToIt() {
            // given
            final CheckPopulation step = new CheckPopulation(List.of(check("test", CheckPoint.POPULATION, CheckReaction.REPLACE,
                                                                           candidate -> candidate == failing)),
                                                             evaluator);

            // when
            step.execute(state);

            // then
            final Candidate replacement = state.getPopulation().get(1);
            Assertions.assertSame(passing, state.getPopulation().getFirst());
            Assertions.assertSame(replacements.getFirst(), replacement.input());
            Assertions.assertTrue(replacement.isEvaluated());
            Assertions.assertEquals(0, replacement.age());
            Assertions.assertEquals(Lineage.replacement(failing).withProperty("reason", "test: failed"),
                                    replacement.lineage());
        }

        @Test
        public void aMemberThatIsNewInTheIterationIsReplacedWithoutPredecessor() {
            // given: the failing member is not carried over, so it is not recorded
            final Candidate parent = member();
            final Candidate offspring = Candidate.evaluated(Mockito.mock(TypedEObject.class), evaluation(),
                                                            Lineage.mutation(parent));
            state.setPopulation(List.of(passing, offspring));
            final CheckPopulation step = new CheckPopulation(List.of(check("test", CheckPoint.POPULATION, CheckReaction.REPLACE,
                                                                           candidate -> candidate == offspring)),
                                                             evaluator);

            // when
            step.execute(state);

            // then
            final Candidate replacement = state.getPopulation().get(1);
            Assertions.assertEquals(Lineage.NONE, replacement.lineage());
            Assertions.assertEquals("test: failed", replacement.properties().get("reason"));
            Assertions.assertTrue(replacement.isEvaluated());
        }

        @Test
        public void replacementsContinueTheStreamOfTheSource() {
            // given
            final CheckPopulation step = new CheckPopulation(List.of(check("test", CheckPoint.POPULATION, CheckReaction.REPLACE,
                                                                           candidate -> candidate == failing)),
                                                             evaluator);
            step.execute(state);
            state.setPopulation(List.of(passing, failing));

            // when
            step.execute(state);

            // then
            Assertions.assertSame(replacements.get(1), state.getPopulation().get(1).input());
            Mockito.verify(provider, Mockito.times(1)).create();
        }

        @Test
        public void aReplacementThatFailsALaterCheckIsReplacedAgainAndRefersToTheMember() {
            // given: the second check fails everything that is not passing
            final CheckPopulation step = new CheckPopulation(List.of(check("first", CheckPoint.POPULATION, CheckReaction.REPLACE,
                                                                           candidate -> candidate == failing),
                                                                     check("second", CheckPoint.POPULATION, CheckReaction.REPLACE,
                                                                           candidate -> candidate != passing)),
                                                             evaluator);

            // when
            step.execute(state);

            // then: every check has its own source
            final Candidate replacement = state.getPopulation().get(1);
            Assertions.assertSame(replacements.getFirst(), replacement.input());
            Assertions.assertEquals(Lineage.replacement(failing).withProperty("reason", "second: failed"),
                                    replacement.lineage());
            Assertions.assertEquals("first (replace): 1 of 2 candidates failed; second (replace): 1 of 2 candidates failed",
                                    step.description());
        }

        @Test
        public void aMemberStaysIfTheBudgetDoesNotCoverItsReplacement() {
            // given
            budget = 0;
            final CheckPopulation step = new CheckPopulation(List.of(check("test", CheckPoint.POPULATION, CheckReaction.REPLACE,
                                                                           candidate -> candidate == failing)),
                                                             evaluator);

            // when
            Assertions.assertThrows(EvaluationBudgetExhaustedException.class, () -> step.execute(state));

            // then
            Assertions.assertEquals(List.of(passing, failing), state.getPopulation());
        }
    }

    @Nested
    @DisplayName("given a check of new candidates")
    class NewCandidateChecks {
        private final Candidate passing = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);
        private final Candidate failing = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);

        @BeforeEach
        public void candidates() {
            state.setCandidates(List.of(passing, failing));
        }

        @Test
        public void aWarningKeepsTheCandidates() {
            // given
            final CheckNewCandidates step = new CheckNewCandidates(List.of(check("test", CheckPoint.NEW_CANDIDATES,
                                                                                 CheckReaction.WARN, candidate -> candidate == failing)));

            // when
            step.execute(state);

            // then
            Assertions.assertEquals(List.of(passing, failing), state.getCandidates());
            Assertions.assertEquals("test (warn): 1 of 2 candidates failed", step.description());
        }

        /**
         * Gives new mutations of the failing candidate; the first {@code failing} of them fail
         *   too.
         */
        private final class CountingResampler implements Resampler {
            private final java.util.List<Candidate> created = new java.util.ArrayList<>();

            @Override
            public Candidate resample(final SearchState state, final int index) {
                final Candidate candidate = new Candidate(Mockito.mock(TypedEObject.class), Lineage.mutation(member()));
                created.add(candidate);
                return candidate;
            }
        }

        @Test
        public void aResampledCandidateCountsItsVariations() {
            // given: the original and the first resampled candidate fail
            final CountingResampler resampler = new CountingResampler();
            final CheckNewCandidates step = new CheckNewCandidates(List.of(check("test", CheckPoint.NEW_CANDIDATES, CheckReaction.RESAMPLE,
                                                                                 candidate -> candidate == failing
                                                                                              || (!resampler.created.isEmpty() && candidate == resampler.created.getFirst()))),
                                                                   resampler);

            // when
            step.execute(state);

            // then: two resamples, so three variations
            final Candidate resampled = state.getCandidates().get(1);
            Assertions.assertEquals(2, resampler.created.size());
            Assertions.assertSame(resampler.created.get(1).input(), resampled.input());
            Assertions.assertEquals(3L, resampled.lineage().properties().get("attempts"));
            Assertions.assertSame(passing, state.getCandidates().getFirst());
        }

        @Test
        public void afterTheLastAttemptTheCandidateIsKept() {
            // given: every candidate fails
            final CountingResampler resampler = new CountingResampler();
            final CheckNewCandidates step = new CheckNewCandidates(List.of(check("test", CheckPoint.NEW_CANDIDATES, CheckReaction.RESAMPLE,
                                                                                 candidate -> true)),
                                                                   resampler);

            // when
            step.execute(state);

            // then: 3 attempts per candidate, the last one is kept
            Assertions.assertEquals(6, resampler.created.size());
            Assertions.assertSame(resampler.created.get(5).input(), state.getCandidates().get(1).input());
            Assertions.assertEquals(4L, state.getCandidates().get(1).lineage().properties().get("attempts"));
        }

        @Test
        public void aStepWithoutResamplerRejectsResampling() {
            final CheckNewCandidates step = new CheckNewCandidates(List.of(check("test", CheckPoint.NEW_CANDIDATES, CheckReaction.RESAMPLE,
                                                                                 candidate -> candidate == failing)));

            Assertions.assertThrows(IllegalStateException.class, () -> step.execute(state));
        }

        @Test
        public void aStepWithAnotherResamplerSharesTheReplacementSource() {
            // given: the initial candidates and the children are checked by two steps
            final CheckNewCandidates children = new CheckNewCandidates(List.of(check("test", CheckPoint.NEW_CANDIDATES,
                                                                                     CheckReaction.REPLACE, candidate -> candidate == failing)));
            final CheckNewCandidates initial = children.withResampler((searchState, index) -> failing);

            // when
            initial.execute(state);
            final TypedEObject first = state.getCandidates().get(1).input();
            state.setCandidates(List.of(passing, failing));
            children.execute(state);
            final TypedEObject second = state.getCandidates().get(1).input();

            // then: one stream for both steps
            Assertions.assertSame(replacements.get(0), first);
            Assertions.assertSame(replacements.get(1), second);
            Mockito.verify(provider, Mockito.times(1)).create();
        }

        @Test
        public void aFailedCandidateIsReplacedByAnUnevaluatedOneWithTheReason() {
            // given
            final CheckNewCandidates step = new CheckNewCandidates(List.of(check("test", CheckPoint.NEW_CANDIDATES,
                                                                                 CheckReaction.REPLACE, candidate -> candidate == failing)));

            // when
            step.execute(state);

            // then
            final Candidate replacement = state.getCandidates().get(1);
            Assertions.assertSame(passing, state.getCandidates().getFirst());
            Assertions.assertSame(replacements.getFirst(), replacement.input());
            Assertions.assertFalse(replacement.isEvaluated());
            Assertions.assertEquals(Lineage.NONE, replacement.lineage());
            Assertions.assertEquals("test: failed", replacement.properties().get("reason"));
            Mockito.verifyNoInteractions(evaluator);
        }
    }

    @Nested
    @DisplayName("given a repairing check of new candidates")
    class RepairingChecks {
        private final Candidate parent = member();

        private final Candidate passing = new Candidate(Mockito.mock(TypedEObject.class), Lineage.mutation(parent));

        private final Candidate failing = new Candidate(Mockito.mock(TypedEObject.class), Lineage.mutation(parent)
                                                                                                .withProperty("operators", "gaussian"));

        /**
         * The results of the repair attempts, in order.
         */
        private final List<TypedEObject> repaired = new java.util.ArrayList<>();

        @BeforeEach
        public void candidates() {
            state.setCandidates(List.of(passing, failing));
        }

        /**
         * @param failedAttempts The number of repair results that still fail.
         */
        private RepairingCheck check(final int failedAttempts, final CheckReaction fallback) {
            final Repair repair = new Repair("test-repair", input -> {
                final TypedEObject result = Mockito.mock(TypedEObject.class);
                repaired.add(result);
                return result;
            }, fallback);

            return new RepairingCheck(candidate -> candidate.input() == failing.input()
                                                   || repaired.indexOf(candidate.input()) >= 0
                                                      && repaired.indexOf(candidate.input()) < failedAttempts,
                                      repair);
        }

        @Test
        public void aRepairedCandidateKeepsTheLineageOfTheFailedOneWithRepairAndAttempts() {
            // given: the first repair result still fails
            final CheckNewCandidates step = new CheckNewCandidates(List.of(ConfiguredCheck.withoutSource(check(1, CheckReaction.WARN))));

            // when
            step.execute(state);

            // then
            final Candidate result = state.getCandidates().get(1);
            Assertions.assertSame(passing, state.getCandidates().getFirst());
            Assertions.assertSame(repaired.get(1), result.input());
            Assertions.assertEquals(Lineage.mutation(parent)
                                           .withProperty("operators", "gaussian")
                                           .withProperty("repair", "test-repair")
                                           .withProperty("attempts", 2L),
                                    result.lineage());
            Assertions.assertFalse(result.isEvaluated());
            Assertions.assertEquals("test (repair): 1 of 2 candidates failed", step.description());
        }

        @Test
        public void aRepairedCandidateWithoutPredecessorHasRepairAndAttemptsItself() {
            // given
            final Candidate initial = new Candidate(failing.input(), Lineage.NONE);
            state.setCandidates(List.of(initial));
            final CheckNewCandidates step = new CheckNewCandidates(List.of(ConfiguredCheck.withoutSource(check(0, CheckReaction.WARN))));

            // when
            step.execute(state);

            // then
            final Candidate result = state.getCandidates().getFirst();
            Assertions.assertEquals(Lineage.NONE, result.lineage());
            Assertions.assertEquals("test-repair", result.properties().get("repair"));
            Assertions.assertEquals(1L, result.properties().get("attempts"));
        }

        @Test
        public void theFallbackWarnKeepsTheUnrepairedCandidate() {
            // given: every repair result fails
            final CheckNewCandidates step = new CheckNewCandidates(List.of(ConfiguredCheck.withoutSource(check(3, CheckReaction.WARN))));

            // when
            step.execute(state);

            // then
            Assertions.assertEquals(3, repaired.size());
            Assertions.assertSame(failing, state.getCandidates().get(1));
        }

        @Test
        public void theFallbackReplaceTakesACandidateFromTheSource() {
            // given
            final RepairingCheck check = check(3, CheckReaction.REPLACE);
            final CheckNewCandidates step = new CheckNewCandidates(List.of(new ConfiguredCheck(check, () -> new ReplacementSource(provider))));

            // when
            step.execute(state);

            // then
            final Candidate replacement = state.getCandidates().get(1);
            Assertions.assertSame(replacements.getFirst(), replacement.input());
            Assertions.assertEquals("test: failed", replacement.properties().get("reason"));
        }

        @Test
        public void theFallbackResampleRedoesTheVariation() {
            // given
            final Candidate resampled = new Candidate(Mockito.mock(TypedEObject.class), Lineage.mutation(parent));
            final CheckNewCandidates step = new CheckNewCandidates(List.of(ConfiguredCheck.withoutSource(check(3, CheckReaction.RESAMPLE))),
                                                                   (searchState, index) -> resampled);

            // when
            step.execute(state);

            // then
            final Candidate result = state.getCandidates().get(1);
            Assertions.assertSame(resampled.input(), result.input());
            Assertions.assertEquals(2L, result.lineage().properties().get("attempts"));
        }

        @Test
        public void aReplacingFallbackNeedsASource() {
            final RepairingCheck check = check(0, CheckReaction.REPLACE);

            Assertions.assertThrows(IllegalArgumentException.class, () -> ConfiguredCheck.withoutSource(check));
        }

        @Test
        public void aResamplingFallbackNeedsAnAlgorithmThatCanResample() {
            final List<CandidateCheck> checks = List.of(check(0, CheckReaction.RESAMPLE));

            Assertions.assertThrows(InitializationException.class,
                                    () -> CandidateCheckProducer.validate(checks, Set.of(CheckPoint.NEW_CANDIDATES), false, "algorithm"));
            Assertions.assertDoesNotThrow(() -> CandidateCheckProducer.validate(checks, Set.of(CheckPoint.NEW_CANDIDATES), true, "algorithm"));
        }

        @Test
        public void theRepairCannotFallBackToRepair() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new Repair("test-repair", input -> input, CheckReaction.REPAIR));
        }
    }

    @Nested
    @DisplayName("given the checks of an algorithm")
    class Validation {
        @Test
        public void supportedReactionsAtOfferedCheckPointsAreAccepted() {
            final List<CandidateCheck> checks = List.of(new TestCheck("test", CheckPoint.POPULATION, CheckReaction.REPLACE, candidate -> false));

            Assertions.assertDoesNotThrow(() -> CandidateCheckProducer.validate(checks, Set.of(CheckPoint.POPULATION), false, "algorithm"));
        }

        @Test
        public void resamplingNeedsACheckOfNewCandidatesAndAnAlgorithmThatCanResample() {
            final List<CandidateCheck> population = List.of(new TestCheck("test", CheckPoint.POPULATION, CheckReaction.RESAMPLE, candidate -> false));
            final List<CandidateCheck> newCandidates = List.of(new TestCheck("test", CheckPoint.NEW_CANDIDATES, CheckReaction.RESAMPLE, candidate -> false));
            final Set<CheckPoint> both = Set.of(CheckPoint.POPULATION, CheckPoint.NEW_CANDIDATES);

            Assertions.assertThrows(InitializationException.class, () -> CandidateCheckProducer.validate(population, both, true, "algorithm"));
            Assertions.assertThrows(InitializationException.class, () -> CandidateCheckProducer.validate(newCandidates, both, false, "algorithm"));
            Assertions.assertDoesNotThrow(() -> CandidateCheckProducer.validate(newCandidates, both, true, "algorithm"));
        }

        @Test
        public void anUnsupportedReactionIsRejected() {
            final List<CandidateCheck> checks = List.of(new TestCheck("test", CheckPoint.POPULATION, CheckReaction.REPAIR, candidate -> false));

            Assertions.assertThrows(InitializationException.class,
                                    () -> CandidateCheckProducer.validate(checks, Set.of(CheckPoint.POPULATION), false, "algorithm"));
        }

        @Test
        public void theReactionRepairNeedsARepairStrategy() {
            final CandidateCheck check = new CandidateCheck() {
                @Override
                public CheckPoint checkPoint() {
                    return CheckPoint.NEW_CANDIDATES;
                }

                @Override
                public int maximumAttempts() {
                    return 3;
                }

                @Override
                public String name() {
                    return "test";
                }

                @Override
                public CheckReaction reaction() {
                    return CheckReaction.REPAIR;
                }

                @Override
                public EObject replacementSource() {
                    return null;
                }

                @Override
                public Set<CheckReaction> supportedReactions() {
                    return EnumSet.allOf(CheckReaction.class);
                }

                @Override
                public Optional<String> test(final Candidate candidate) {
                    return Optional.empty();
                }
            };

            Assertions.assertThrows(InitializationException.class,
                                    () -> CandidateCheckProducer.validate(List.of(check), Set.of(CheckPoint.NEW_CANDIDATES), true, "algorithm"));
        }

        @Test
        public void aCheckPointThatTheAlgorithmDoesNotOfferIsRejected() {
            final List<CandidateCheck> checks = List.of(new TestCheck("test", CheckPoint.NEW_CANDIDATES, CheckReaction.WARN, candidate -> false));

            Assertions.assertThrows(InitializationException.class,
                                    () -> CandidateCheckProducer.validate(checks, Set.of(CheckPoint.POPULATION), false, "algorithm"));
        }

        @Test
        public void aReplacingCheckNeedsASource() {
            final TestCheck check = new TestCheck("test", CheckPoint.POPULATION, CheckReaction.REPLACE, candidate -> false);

            Assertions.assertThrows(IllegalArgumentException.class, () -> ConfiguredCheck.withoutSource(check));
        }

        @Test
        public void theReactionsAreReadFromTheirLiterals() {
            Assertions.assertEquals(List.of(CheckReaction.WARN, CheckReaction.REPLACE, CheckReaction.RESAMPLE, CheckReaction.REPAIR),
                                    Stream.of("warn", "replace", "resample", "repair").map(CheckReaction::of).toList());
            Assertions.assertThrows(IllegalArgumentException.class, () -> CheckReaction.of("ignore"));
        }
    }

    /**
     * A check that fails the candidates of a predicate with the reason "failed". It supports
     *   {@code warn}, {@code replace} and {@code resample} with at most 3 attempts.
     */
    private record TestCheck(String name, CheckPoint checkPoint, CheckReaction reaction, Predicate<Candidate> fails)
            implements CandidateCheck {
        @Override
        public int maximumAttempts() {
            return 3;
        }

        @Override
        public EObject replacementSource() {
            return null;
        }

        @Override
        public Set<CheckReaction> supportedReactions() {
            return EnumSet.of(CheckReaction.WARN, CheckReaction.REPLACE, CheckReaction.RESAMPLE);
        }

        @Override
        public Optional<String> test(final Candidate candidate) {
            return fails.test(candidate) ? Optional.of("failed") : Optional.empty();
        }
    }

    /**
     * A check of new candidates with the reaction {@code repair} that fails the candidates of
     *   a predicate with the reason "failed", with at most 3 attempts.
     */
    private record RepairingCheck(Predicate<Candidate> fails, Repair repairOfCheck) implements CandidateCheck {
        @Override
        public CheckPoint checkPoint() {
            return CheckPoint.NEW_CANDIDATES;
        }

        @Override
        public int maximumAttempts() {
            return 3;
        }

        @Override
        public String name() {
            return "test";
        }

        @Override
        public CheckReaction reaction() {
            return CheckReaction.REPAIR;
        }

        @Override
        public Optional<Repair> repair() {
            return Optional.of(repairOfCheck);
        }

        @Override
        public EObject replacementSource() {
            return null;
        }

        @Override
        public Set<CheckReaction> supportedReactions() {
            return EnumSet.allOf(CheckReaction.class);
        }

        @Override
        public Optional<String> test(final Candidate candidate) {
            return fails.test(candidate) ? Optional.of("failed") : Optional.empty();
        }
    }
}
