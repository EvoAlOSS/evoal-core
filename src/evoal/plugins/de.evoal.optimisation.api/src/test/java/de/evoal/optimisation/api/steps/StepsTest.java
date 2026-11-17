package de.evoal.optimisation.api.steps;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.InOrder;
import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.run.Ranking;

public class StepsTest {
    private static TypedEObject input() {
        return Mockito.mock(TypedEObject.class);
    }

    @Nested
    @DisplayName("given a fitness calculation")
    class Fitness {
        private final OptimisationValueComparator comparator = Mockito.mock(OptimisationValueComparator.class);

        private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

        private final FitnessCalculation step = new FitnessCalculation(evaluationService, comparator);

        private final SearchState state = new SearchState();

        @Test
        public void theUnevaluatedCandidatesAreEvaluatedInTheirOrder() {
            // given
            final TypedEObject first = input();
            final TypedEObject second = input();
            final Candidate done = Candidate.evaluated(input(), input(), new TestValue(1.0), Lineage.NONE);
            state.setCandidates(List.of(new Candidate(first, Lineage.NONE), done, new Candidate(second, Lineage.NONE)));
            final OptimisationValue value = new TestValue(2.0);
            Mockito.when(comparator.apply(Mockito.any())).thenReturn(value);

            // when
            step.execute(state);

            // then
            final InOrder order = Mockito.inOrder(evaluationService);
            order.verify(evaluationService).evaluate(first);
            order.verify(evaluationService).evaluate(second);
            order.verifyNoMoreInteractions();

            Assertions.assertTrue(state.getCandidates().stream().allMatch(Candidate::isEvaluated));
            Assertions.assertSame(done, state.getCandidates().get(1));
            Assertions.assertEquals(1.0, done.value().toStatistics().getFirst());
        }

        @Test
        public void anExhaustedBudgetKeepsTheEvaluationsBeforeIt() {
            // given
            final List<Candidate> candidates = List.of(new Candidate(input(), Lineage.NONE), new Candidate(input(), Lineage.NONE));
            state.setCandidates(candidates);
            Mockito.when(comparator.apply(Mockito.any())).thenReturn(new TestValue(2.0));
            Mockito.when(evaluationService.evaluate(candidates.get(1).input()))
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
