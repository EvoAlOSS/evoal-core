package de.evoal.optimisation.api.fitness;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.optimisation.api.constraints.ConstraintEvaluation;
import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.TestConstraints;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.model.OptimisationValueComparator;

public class EvaluatorTest {
    private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

    private final OptimisationValueComparator comparator = Mockito.mock(OptimisationValueComparator.class);

    private final Evaluator evaluator = new Evaluator(evaluationService,
                                                      new FitnessPipeline(new Goals(List.of()), List.of()),
                                                      comparator);

    private final List<TypedEObject> inputs = new ArrayList<>();

    /**
     * The output of each input, by index.
     */
    private final List<TypedEObject> outputs = new ArrayList<>();

    @BeforeEach
    public void evaluateToOutputs() {
        for(int i = 0; i < 5; ++i) {
            inputs.add(Mockito.mock(TypedEObject.class, "input-" + i));
            outputs.add(Mockito.mock(TypedEObject.class, "output-" + i));
        }

        Mockito.when(evaluationService.evaluateAll(Mockito.any())).thenAnswer(invocation -> {
            final List<TypedEObject> batch = invocation.getArgument(0);
            return batch.stream().map(input -> outputs.get(inputs.indexOf(input))).toList();
        });
        Mockito.when(comparator.toValue(Mockito.any(), Mockito.any(), Mockito.any()))
               .thenAnswer(invocation -> Mockito.mock(OptimisationValue.class));
    }

    @Test
    public void evaluatesAllInputsInTheirOrderWithoutALimit() {
        // given
        Mockito.when(evaluationService.remainingEvaluations()).thenReturn(OptionalLong.empty());

        // when
        final BatchEvaluation batch = evaluator.evaluateAll(inputs);

        // then
        Assertions.assertFalse(batch.isExhausted());
        Assertions.assertEquals(outputs, batch.evaluations().stream().map(Evaluation::output).toList());
        Assertions.assertDoesNotThrow(batch::rethrowExhaustion);
    }

    @Test
    public void evaluatesTheInputsThatTheBudgetCovers() {
        // given
        final EvaluationBudgetExhaustedException exhaustion = new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 3);
        Mockito.when(evaluationService.remainingEvaluations()).thenReturn(OptionalLong.of(3));
        Mockito.when(evaluationService.evaluateAll(inputs.subList(3, 5))).thenThrow(exhaustion);

        // when
        final BatchEvaluation batch = evaluator.evaluateAll(inputs);

        // then
        Mockito.verify(evaluationService).evaluateAll(inputs.subList(0, 3));
        Assertions.assertEquals(outputs.subList(0, 3), batch.evaluations().stream().map(Evaluation::output).toList());
        Assertions.assertSame(exhaustion, batch.exhaustion());
        Assertions.assertSame(exhaustion, Assertions.assertThrows(EvaluationBudgetExhaustedException.class, batch::rethrowExhaustion));
    }

    @Test
    public void anExhaustedBudgetEvaluatesNothing() {
        // given
        final EvaluationBudgetExhaustedException exhaustion = new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 0);
        Mockito.when(evaluationService.remainingEvaluations()).thenReturn(OptionalLong.of(0));
        Mockito.when(evaluationService.evaluateAll(inputs)).thenThrow(exhaustion);

        // when
        final BatchEvaluation batch = evaluator.evaluateAll(inputs);

        // then
        Assertions.assertTrue(batch.evaluations().isEmpty());
        Assertions.assertSame(exhaustion, batch.exhaustion());
    }

    @Test
    public void theViolationRecordReachesThePipelineTheComparatorAndTheEvaluation() {
        // given
        final Constraints constraints = TestConstraints.constraints("g");
        final ConstraintEvaluation constraintEvaluation = new ConstraintEvaluation();
        constraintEvaluation.setUp(constraints, (constraint, input, objectives) -> 2.0);

        final List<ViolationRecord> seenByPipeline = new ArrayList<>();
        final FitnessStep recordingStep = (context, current) -> {
            seenByPipeline.add(context.violations());
            return current;
        };
        final FitnessPipeline pipeline = new FitnessPipeline(new Goals(List.of()), List.of(recordingStep));
        final Evaluator withConstraints = new Evaluator(evaluationService, constraintEvaluation, pipeline, comparator);
        Mockito.when(evaluationService.evaluate(inputs.get(0))).thenReturn(outputs.get(0));

        // when
        final Evaluation evaluation = withConstraints.evaluate(inputs.get(0));

        // then
        Assertions.assertEquals(2.0, evaluation.violations().violation("g"));
        Assertions.assertSame(evaluation.violations(), seenByPipeline.get(0));
        Mockito.verify(comparator)
               .toValue(Mockito.eq(outputs.get(0)), Mockito.any(), Mockito.same(evaluation.violations()));
        Assertions.assertEquals(1, constraintEvaluation.numberOfEvaluations());
        Mockito.verify(evaluationService).evaluate(inputs.get(0));
    }
}
