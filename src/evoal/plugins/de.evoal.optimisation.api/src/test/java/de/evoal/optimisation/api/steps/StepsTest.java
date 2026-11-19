package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.run.Ranking;

public class StepsTest {
    /**
     * @return An evaluator whose fitness pipeline has no goals, so it accepts any output.
     */
    private static Evaluator evaluator(final EvaluationService evaluationService,
                                       final OptimisationValueComparator comparator) {
        final Goals goals = new Goals(List.of());
        final FitnessPipeline pipeline = new FitnessPipeline(goals, List.of());

        return new Evaluator(evaluationService, pipeline, comparator);
    }

    private static TypedEObject input() {
        return Mockito.mock(TypedEObject.class);
    }

    @Nested
    @DisplayName("given a fitness calculation")
    class Batch {
        private final OptimisationValueComparator comparator = Mockito.mock(OptimisationValueComparator.class);

        private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

        private final EvaluateCandidates step = new EvaluateCandidates(evaluator(evaluationService, comparator));

        private final SearchState state = new SearchState();

        @BeforeEach
        public void evaluateToAnOutput() {
            Mockito.when(evaluationService.remainingEvaluations()).thenReturn(java.util.OptionalLong.empty());
            Mockito.when(evaluationService.evaluateAll(Mockito.any())).thenAnswer(invocation -> {
                final List<TypedEObject> inputs = invocation.getArgument(0);
                return inputs.stream().map(i -> input()).toList();
            });
        }

        @Test
        public void theUnevaluatedCandidatesAreEvaluatedInTheirOrder() {
            // given
            final TypedEObject first = input();
            final TypedEObject second = input();
            final Fitness fitness = new Fitness(FitnessLayout.EMPTY, new double[0]);
            final Evaluation evaluation = new Evaluation(input(), fitness, new TestValue(1.0));
            final Candidate done = Candidate.evaluated(input(), evaluation, Lineage.NONE);
            state.setCandidates(List.of(new Candidate(first, Lineage.NONE), done, new Candidate(second, Lineage.NONE)));
            final OptimisationValue value = new TestValue(2.0);
            Mockito.when(comparator.toValue(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(value);

            // when
            step.execute(state);

            // then
            Mockito.verify(evaluationService).evaluateAll(List.of(first, second));
            Mockito.verify(evaluationService, Mockito.never()).evaluate(Mockito.any());

            Assertions.assertTrue(state.getCandidates().stream().allMatch(Candidate::isEvaluated));
            Assertions.assertTrue(state.getCandidates().stream().allMatch(candidate -> candidate.fitness() != null));
            Assertions.assertSame(done, state.getCandidates().get(1));
            Assertions.assertEquals(1.0, done.value().toStatistics().getFirst());
        }

        @Test
        public void anExhaustedBudgetKeepsTheEvaluationsBeforeIt() {
            // given
            final List<Candidate> candidates = List.of(new Candidate(input(), Lineage.NONE), new Candidate(input(), Lineage.NONE));
            state.setCandidates(candidates);
            Mockito.when(comparator.toValue(Mockito.any(), Mockito.any(), Mockito.any()))
                   .thenReturn(new TestValue(2.0));
            Mockito.when(evaluationService.remainingEvaluations()).thenReturn(java.util.OptionalLong.of(1));
            Mockito.when(evaluationService.evaluateAll(List.of(candidates.get(1).input())))
                   .thenThrow(new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 1));

            // when
            Assertions.assertThrows(EvaluationBudgetExhaustedException.class, () -> step.execute(state));

            // then
            Assertions.assertEquals(candidates, state.getCandidates());
            Assertions.assertTrue(candidates.get(0).isEvaluated());
            Assertions.assertFalse(candidates.get(1).isEvaluated());
        }
    }

    @Nested
    @DisplayName("given a fitness calculation until accepted")
    class UntilAccepted {
        private final OptimisationValueComparator comparator = Mockito.mock(OptimisationValueComparator.class);

        private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

        private final SearchState state = new SearchState();

        /**
         * The number of offered candidates that were created.
         */
        private int created;

        /**
         * The values of the offered candidates, in their order.
         */
        private final List<Double> values = List.of(1.0, 5.0, 2.0, 7.0);

        /**
         * The candidates the acceptance test was called for, by value.
         */
        private final List<Double> tested = new ArrayList<>();

        /**
         * Whether the candidates the acceptance test was called for had a fitness.
         */
        private final List<Boolean> testedWithFitness = new ArrayList<>();

        @BeforeEach
        public void offer() {
            Mockito.when(evaluationService.evaluate(Mockito.any())).thenAnswer(invocation -> input());

            final Iterator<Double> results = values.iterator();
            Mockito.when(comparator.toValue(Mockito.any(), Mockito.any(), Mockito.any()))
                   .thenAnswer(invocation -> new TestValue(results.next()));

            state.setOffered(Stream.generate(() -> {
                                       created += 1;
                                       return new Candidate(input(), Lineage.NONE);
                                   })
                                   .limit(values.size()));
        }

        private EvaluateCandidates acceptingAbove(final double threshold) {
            return EvaluateCandidates.untilAccepted(evaluator(evaluationService, comparator), (current, candidate) -> {
                final double value = (Double) candidate.value().toStatistics().getFirst();
                tested.add(value);
                testedWithFitness.add(candidate.fitness() != null);
                return value > threshold;
            });
        }

        @Test
        public void theCandidatesAreEvaluatedUntilTheFirstAcceptableOne() {
            // when
            acceptingAbove(4.0).execute(state);

            // then
            Assertions.assertEquals(2, created);
            Assertions.assertEquals(List.of(1.0, 5.0), tested);
            Assertions.assertEquals(2, state.getCandidates().size());
            Assertions.assertSame(state.getCandidates().get(1), state.getAccepted().orElseThrow());
            Mockito.verify(evaluationService, Mockito.times(2)).evaluate(Mockito.any());
        }

        @Test
        public void theFitnessIsKnownBeforeTheAcceptanceTest() {
            // when
            acceptingAbove(4.0).execute(state);

            // then
            Assertions.assertEquals(List.of(true, true), testedWithFitness);
        }

        @Test
        public void withoutAnAcceptableCandidateAllAreEvaluatedAndNoneIsAccepted() {
            // when
            acceptingAbove(10.0).execute(state);

            // then
            Assertions.assertEquals(List.of(1.0, 5.0, 2.0, 7.0), tested);
            Assertions.assertEquals(4, state.getCandidates().size());
            Assertions.assertTrue(state.getAccepted().isEmpty());
        }
    }

    @Nested
    @DisplayName("given a sampling step")
    class Sampling {
        @Test
        public void allExecutionsTakeTheNextCandidatesOfTheSameStream() {
            // given
            final List<TypedEObject> inputs = Stream.generate(StepsTest::input).limit(5).toList();
            final InitialCandidatesProvider provider = Mockito.mock(InitialCandidatesProvider.class);
            Mockito.when(provider.create()).thenAnswer(invocation -> inputs.stream());
            final SampleCandidates step = new SampleCandidates(provider, 2);
            final SearchState state = new SearchState();

            // when
            step.execute(state);
            final List<Candidate> first = state.getCandidates();
            step.execute(state);
            final List<Candidate> second = state.getCandidates();

            // then
            Assertions.assertEquals(inputs.subList(0, 2), first.stream().map(Candidate::input).toList());
            Assertions.assertEquals(inputs.subList(2, 4), second.stream().map(Candidate::input).toList());
            Assertions.assertTrue(second.stream().allMatch(candidate -> candidate.lineage() == Lineage.NONE));
            Mockito.verify(provider, Mockito.times(1)).create();
        }

        @Test
        public void anExhaustedProviderIsReported() {
            // given
            final InitialCandidatesProvider provider = Mockito.mock(InitialCandidatesProvider.class);
            Mockito.when(provider.create()).thenAnswer(invocation -> Stream.of(input()));
            final SampleCandidates step = new SampleCandidates(provider, 2);

            // when / then
            Assertions.assertThrows(IllegalStateException.class, () -> step.execute(new SearchState()));
        }

        @Test
        public void atLeastOneCandidateIsSampled() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> new SampleCandidates(Mockito.mock(InitialCandidatesProvider.class), 0));
        }
    }

    @Test
    public void theAcceptedCandidatesReplaceThePopulation() {
        // given
        final SearchState state = new SearchState();
        final List<Candidate> candidates = List.of(new Candidate(input(), Lineage.NONE));
        state.setPopulation(List.of(new Candidate(input(), Lineage.NONE)));
        state.setCandidates(candidates);

        // when
        new ReplacePopulation().execute(state);

        // then
        Assertions.assertEquals(candidates, state.getPopulation());
        Assertions.assertEquals(List.of(), state.getCandidates());
    }

    @Test
    public void membersOfEqualValueShareARankInTheirOrder() {
        // given
        final List<OptimisationValue> values = List.of(new TestValue(1.0), new TestValue(2.0),
                                                       new TestValue(1.0), new TestValue(2.0));

        // when
        final List<List<Integer>> ranks = Ranking.byValue(values);

        // then
        Assertions.assertEquals(List.of(List.of(1, 3), List.of(0, 2)), ranks);
    }

    @Test
    public void theStrategyStateIsTyped() {
        // given
        final StateKey<Double> temperature = new StateKey<>("temperature", Double.class);
        final SearchState state = new SearchState();

        // when
        state.setStrategy(temperature, 10.0);

        // then
        Assertions.assertEquals(10.0, state.strategy(temperature).orElseThrow());
        Assertions.assertTrue(state.strategy(new StateKey<>("velocity", Double.class)).isEmpty());
    }
}
