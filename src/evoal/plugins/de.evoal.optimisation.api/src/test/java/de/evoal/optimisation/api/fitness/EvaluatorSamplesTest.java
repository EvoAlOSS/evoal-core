package de.evoal.optimisation.api.fitness;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

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
import de.evoal.optimisation.api.evaluation.SampleAggregation;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.main.evaluation.ReEvaluation;
import de.evoal.optimisation.main.evaluation.Resampling;

/**
 * The evaluator with evaluation strategies of several samples. The service returns the
 *   objectives {@code y = n} and {@code z = 10 n} for its n-th call (from 0), so the samples
 *   of a candidate show which calls they came from.
 */
public class EvaluatorSamplesTest {
    private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

    private final OptimisationValueComparator comparator = Mockito.mock(OptimisationValueComparator.class);

    private final FitnessPipeline pipeline = new FitnessPipeline(new Goals(List.of()), List.of());

    private final List<TypedEObject> inputs = new ArrayList<>();

    /**
     * The inputs of the calls of the service, in their order.
     */
    private final List<TypedEObject> calls = new ArrayList<>();

    private OptionalLong remaining = OptionalLong.empty();

    @BeforeEach
    public void numberTheCalls() {
        for(int i = 0; i < 3; ++i) {
            inputs.add(Mockito.mock(TypedEObject.class, "input-" + i));
        }

        Mockito.when(evaluationService.evaluateAll(Mockito.any())).thenAnswer(invocation -> {
            final List<TypedEObject> batch = invocation.getArgument(0);
            if(remaining.isPresent() && batch.size() > remaining.getAsLong()) {
                throw new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 0);
            }

            final List<TypedEObject> outputs = new ArrayList<>();
            for(final TypedEObject input : batch) {
                final int call = calls.size();
                calls.add(input);
                outputs.add(ObjectiveSamplesTest.objectives(call, 10.0 * call));
            }
            if(remaining.isPresent()) {
                remaining = OptionalLong.of(remaining.getAsLong() - batch.size());
            }

            return outputs;
        });
        Mockito.when(evaluationService.evaluate(Mockito.any()))
               .thenAnswer(invocation -> evaluationService.evaluateAll(List.of(invocation.<TypedEObject>getArgument(0))).getFirst());
        Mockito.when(evaluationService.remainingEvaluations()).thenAnswer(invocation -> remaining);
        Mockito.when(comparator.toValue(Mockito.any(), Mockito.any(), Mockito.any()))
               .thenAnswer(invocation -> Mockito.mock(OptimisationValue.class));
    }

    private Evaluator evaluatorWith(final de.evoal.optimisation.api.evaluation.EvaluationStrategy strategy) {
        return new Evaluator(evaluationService, pipeline, comparator, strategy);
    }

    private static List<Object> values(final List<TypedEObject> samples) {
        return samples.stream().map(sample -> sample.eGet(ObjectiveSamplesTest.Y)).toList();
    }

    @Nested
    @DisplayName("given resampling with 3 samples")
    class ResamplingWithThreeSamples {
        private final Evaluator evaluator = evaluatorWith(new Resampling(3, SampleAggregation.MEAN));

        @Test
        public void everyCandidateIsEvaluatedThreeTimesInARowAndAggregated() {
            // when
            final BatchEvaluation batch = evaluator.evaluateAll(inputs);

            // then
            Assertions.assertEquals(List.of(inputs.get(0), inputs.get(0), inputs.get(0),
                                            inputs.get(1), inputs.get(1), inputs.get(1),
                                            inputs.get(2), inputs.get(2), inputs.get(2)), calls);

            final Evaluation second = batch.evaluations().get(1);
            Assertions.assertEquals(List.of(3.0, 4.0, 5.0), values(second.samples().samples()));
            Assertions.assertEquals(4.0, second.output().eGet(ObjectiveSamplesTest.Y));
            Assertions.assertEquals(40.0, second.output().eGet(ObjectiveSamplesTest.Z));
            Mockito.verify(comparator).toValue(Mockito.same(second.output()), Mockito.any(), Mockito.any());
        }

        @Test
        public void aSingleCandidateIsEvaluatedThreeTimes() {
            // when
            final Evaluation evaluation = evaluator.evaluate(inputs.get(0));

            // then
            Assertions.assertEquals(3, evaluation.samples().size());
            Assertions.assertEquals(1.0, evaluation.output().eGet(ObjectiveSamplesTest.Y));
            Mockito.verify(evaluationService, Mockito.never()).evaluate(Mockito.any());
        }

        @Test
        public void aCutOffBudgetNeverSplitsTheSamplesOfACandidate() {
            // given
            remaining = OptionalLong.of(7);

            // when
            final BatchEvaluation batch = evaluator.evaluateAll(inputs);

            // then: 2 candidates with 3 samples each; the third would need 3 of the last 1
            Assertions.assertEquals(2, batch.evaluations().size());
            Assertions.assertEquals(6, calls.size());
            Assertions.assertTrue(batch.isExhausted());
        }

        @Test
        public void aSingleCandidateBeyondTheBudgetIsNotEvaluated() {
            // given
            remaining = OptionalLong.of(2);

            // when, then
            Assertions.assertThrows(EvaluationBudgetExhaustedException.class, () -> evaluator.evaluate(inputs.get(0)));
            Assertions.assertTrue(calls.isEmpty());
        }
    }

    @Nested
    @DisplayName("given re-evaluation with 1 sample of a new candidate")
    class ReEvaluationWithOneSample {
        private final Evaluator evaluator = evaluatorWith(new ReEvaluation(1, SampleAggregation.MEAN));

        @Test
        public void aNewCandidateHasOneRecordedSample() {
            // when
            final Evaluation evaluation = evaluator.evaluate(inputs.get(0));

            // then
            Assertions.assertEquals(1, evaluation.samples().size());
            Assertions.assertEquals(1L, evaluation.samples().toProperties().get(ObjectiveSamples.SAMPLES));
        }

        @Test
        public void aReEvaluationAddsOneSampleAndAggregatesAllSamples() {
            // given
            final List<Evaluation> previous = evaluator.evaluateAll(inputs.subList(0, 2)).evaluations();

            // when
            final BatchEvaluation batch = evaluator.reEvaluateAll(inputs.subList(0, 2), previous);

            // then
            final Evaluation first = batch.evaluations().get(0);
            Assertions.assertEquals(List.of(0.0, 2.0), values(first.samples().samples()));
            Assertions.assertEquals(1.0, first.output().eGet(ObjectiveSamplesTest.Y));

            final Evaluation second = batch.evaluations().get(1);
            Assertions.assertEquals(List.of(1.0, 3.0), values(second.samples().samples()));
            Assertions.assertEquals(2.0, second.output().eGet(ObjectiveSamplesTest.Y));
        }

        @Test
        public void aCutOffBudgetReEvaluatesTheCandidatesItCovers() {
            // given
            final List<Evaluation> previous = evaluator.evaluateAll(inputs).evaluations();
            remaining = OptionalLong.of(2);

            // when
            final BatchEvaluation batch = evaluator.reEvaluateAll(inputs, previous);

            // then
            Assertions.assertEquals(2, batch.evaluations().size());
            Assertions.assertTrue(batch.isExhausted());
            Assertions.assertEquals(5, calls.size());
        }
    }
}
