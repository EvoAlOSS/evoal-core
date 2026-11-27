package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.optimisation.api.evaluation.ConfiguredEvaluationStrategy;
import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.SampleAggregation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.fitness.FitnessPipeline;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.main.evaluation.ReEvaluation;

/**
 * The service returns the objective {@code y = n} for its n-th call (from 0).
 */
public class ReEvaluatePopulationTest {
    private static final Space SPACE = space();

    private static final EAttribute Y = (EAttribute) SPACE.getEClass().getEStructuralFeature("y");

    private final EvaluationService evaluationService = Mockito.mock(EvaluationService.class);

    private final OptimisationValueComparator comparator = Mockito.mock(OptimisationValueComparator.class);

    private final Evaluator evaluator = new Evaluator(evaluationService,
                                                      new FitnessPipeline(new Goals(List.of()), List.of()),
                                                      comparator,
                                                      new ReEvaluation(1, SampleAggregation.MEAN));

    private final SearchState state = new SearchState();

    private int calls;

    private OptionalLong remaining = OptionalLong.empty();

    private static Space space() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Objectives");
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName("y");
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        eClass.getEStructuralFeatures().add(attribute);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    @BeforeEach
    public void numberTheCalls() {
        Mockito.when(evaluationService.evaluateAll(Mockito.any())).thenAnswer(invocation -> {
            final List<TypedEObject> batch = invocation.getArgument(0);
            if(remaining.isPresent() && batch.size() > remaining.getAsLong()) {
                throw new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 0);
            }

            final List<TypedEObject> outputs = new ArrayList<>();
            for(int i = 0; i < batch.size(); ++i) {
                final TypedEObject output = SPACE.newEObject();
                output.eSet(Y, (double) calls++);
                outputs.add(output);
            }
            if(remaining.isPresent()) {
                remaining = OptionalLong.of(remaining.getAsLong() - batch.size());
            }

            return outputs;
        });
        Mockito.when(evaluationService.remainingEvaluations()).thenAnswer(invocation -> remaining);
        Mockito.when(comparator.toValue(Mockito.any(), Mockito.any(), Mockito.any()))
               .thenAnswer(invocation -> Mockito.mock(OptimisationValue.class));

        // two members carried over from the previous iteration, with the samples 0 and 1
        final List<Candidate> previous = new ArrayList<>();
        for(final var evaluation : evaluator.evaluateAll(List.of(Mockito.mock(TypedEObject.class, "a"),
                                                                  Mockito.mock(TypedEObject.class, "b")))
                                            .evaluations()) {
            previous.add(Candidate.evaluated(Mockito.mock(TypedEObject.class), evaluation, Lineage.NONE));
        }
        state.setPopulation(previous.stream().map(Candidate::survivor).toList());
    }

    @Test
    public void everyMemberGetsOneMoreSampleAndIsMarkedAsReEvaluated() {
        // given
        final List<Candidate> survivors = state.getPopulation();
        final ReEvaluatePopulation step = new ReEvaluatePopulation(evaluator);

        // when
        step.execute(state);

        // then
        final List<Candidate> population = state.getPopulation();
        Assertions.assertEquals(2, population.size());
        Assertions.assertEquals(List.of(0.0, 2.0), population.get(0).evaluation().samples().samples().stream().map(o -> o.eGet(Y)).toList());
        Assertions.assertEquals(1.0, population.get(0).output().eGet(Y));
        Assertions.assertEquals(2.0, population.get(1).output().eGet(Y));

        for(int i = 0; i < 2; ++i) {
            final Lineage lineage = population.get(i).lineage();
            Assertions.assertEquals(Lineage.Kind.IDENTITY, lineage.kind());
            Assertions.assertSame(survivors.get(i).lineage().predecessor(), lineage.predecessor());
            Assertions.assertEquals(Map.of(ConfiguredEvaluationStrategy.RE_EVALUATED, true), lineage.properties());
            Assertions.assertEquals(survivors.get(i).age(), population.get(i).age());
        }
        Assertions.assertEquals(population, step.outputs(state));
    }

    @Test
    public void anExhaustedBudgetReEvaluatesTheCoveredMembersAndPassesTheExhaustionOn() {
        // given
        final List<Candidate> survivors = state.getPopulation();
        remaining = OptionalLong.of(1);
        final ReEvaluatePopulation step = new ReEvaluatePopulation(evaluator);

        // when
        Assertions.assertThrows(EvaluationBudgetExhaustedException.class, () -> step.execute(state));

        // then
        final List<Candidate> population = state.getPopulation();
        Assertions.assertEquals(2, population.get(0).evaluation().samples().size());
        Assertions.assertSame(survivors.get(1), population.get(1));
        Assertions.assertEquals(List.of(population.get(0)), step.outputs(state));
    }
}
