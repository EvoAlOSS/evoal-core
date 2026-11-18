package de.evoal.optimisation.api.fitness;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.OptimisationGoal;
import de.evoal.models.v202704.optimisation.model.Problem;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

import de.evoal.optimisation.main.comparator.ComparatorFactory;
import de.evoal.optimisation.main.comparator.NumericOptimisationValue;
import de.evoal.optimisation.main.fitness.AbsoluteDistance;
import de.evoal.optimisation.main.fitness.ObjectiveSelectionStep;
import de.evoal.optimisation.main.fitness.ScalingStep;
import de.evoal.optimisation.main.fitness.SquaredDistance;
import de.evoal.optimisation.main.fitness.WeightedSumStep;

public class FitnessPipelineTest {
    private static Space space(final EDataType type, final String... names) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

        for(final String name : names) {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(type);
            eClass.getEStructuralFeatures().add(feature);
        }

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    /**
     * A step that adds one component, whose value is the number of components it got, and
     *   records what it saw.
     */
    private static final class AppendingStep implements FitnessStep {
        /**
         * The names of the steps in the order of their calls, shared by all steps of a test.
         */
        private final List<String> calls;

        /**
         * The contexts the step got.
         */
        private final List<FitnessContext> contexts = new ArrayList<>();

        /**
         * The fitness values the step got.
         */
        private final List<Fitness> inputs = new ArrayList<>();

        /**
         * The name of the step and of the component it adds.
         */
        private final String name;

        private AppendingStep(final String name, final List<String> calls) {
            this.name = name;
            this.calls = calls;
        }

        @Override
        public Fitness apply(final FitnessContext context, final Fitness current) {
            calls.add(name);
            contexts.add(context);
            inputs.add(current);

            final FitnessLayout layout = layout(current.layout());
            final double[] values = new double[current.size() + 1];
            System.arraycopy(current.values(), 0, values, 0, current.size());
            values[current.size()] = current.size();

            return new Fitness(layout, values);
        }

        @Override
        public FitnessLayout layout(final FitnessLayout input) {
            final List<FitnessComponent> components = new ArrayList<>(input.components());
            components.add(FitnessComponent.named(name));

            return new FitnessLayout(components);
        }
    }

    @Nested
    @DisplayName("given a pipeline with configured steps")
    class ConfiguredSteps {
        private final Space space = space(EcorePackage.Literals.EDOUBLE, "a", "b");

        private final EStructuralFeature a = space.getEClass().getEStructuralFeature("a");

        private final EStructuralFeature b = space.getEClass().getEStructuralFeature("b");

        private final List<String> calls = new ArrayList<>();

        private final AppendingStep first = new AppendingStep("first", calls);

        private final AppendingStep second = new AppendingStep("second", calls);

        private final Goals goals = new Goals(List.of(new Goal.Minimise(a), new Goal.Maximise(b)));

        private final FitnessPipeline pipeline = new FitnessPipeline(goals, List.of(first, second));

        private final TypedEObject input = space.newEObject();

        private TypedEObject objectives(final double valueOfA, final double valueOfB) {
            final TypedEObject objectives = space.newEObject();
            objectives.eSet(a, valueOfA);
            objectives.eSet(b, valueOfB);

            return objectives;
        }

        @Test
        public void theDirectionStepRunsFirst() {
            // when
            final List<FitnessStep> steps = pipeline.steps();

            // then
            Assertions.assertInstanceOf(DirectionStep.class, steps.getFirst());
            Assertions.assertEquals(List.of(first, second), steps.subList(1, steps.size()));
        }

        @Test
        public void theConfiguredStepsRunInTheirOrder() {
            // when
            pipeline.apply(input, objectives(1.0, 2.0));

            // then
            Assertions.assertEquals(List.of("first", "second"), calls);
        }

        @Test
        public void eachStepGetsTheCandidateAndTheGoals() {
            // given
            final TypedEObject objectives = objectives(1.0, 2.0);

            // when
            pipeline.apply(input, objectives);

            // then
            final FitnessContext context = first.contexts.getFirst();
            Assertions.assertSame(input, context.input());
            Assertions.assertSame(objectives, context.objectives());
            Assertions.assertSame(goals, context.goals());
            Assertions.assertSame(context, second.contexts.getFirst());
        }

        @Test
        public void eachStepGetsTheResultOfThePreviousStep() {
            // when
            final Fitness fitness = pipeline.apply(input, objectives(1.0, 2.0));

            // then
            Assertions.assertArrayEquals(new double[] {1.0, -2.0}, first.inputs.getFirst().values());
            Assertions.assertArrayEquals(new double[] {1.0, -2.0, 2.0}, second.inputs.getFirst().values());
            Assertions.assertArrayEquals(new double[] {1.0, -2.0, 2.0, 3.0}, fitness.values());
        }

        @Test
        public void theLayoutIsKnownBeforeTheFirstEvaluation() {
            // when
            final FitnessLayout layout = pipeline.layout();

            // then
            final List<String> names = layout.components()
                                             .stream()
                                             .map(FitnessComponent::name)
                                             .toList();
            Assertions.assertEquals(List.of("a", "b", "first", "second"), names);
            Assertions.assertTrue(calls.isEmpty());
        }

        @Test
        public void theComponentsOfTheGoalsReferToTheirGoals() {
            // when
            final FitnessLayout layout = pipeline.layout();

            // then
            Assertions.assertEquals(goals.get(0), layout.component(0).goal().orElseThrow());
            Assertions.assertEquals(goals.get(1), layout.component(1).goal().orElseThrow());
            Assertions.assertTrue(layout.component(2).goal().isEmpty());
            Assertions.assertEquals(2, layout.indexOf("first"));
        }

        @Test
        public void aStepThatReturnsOtherComponentsThanDeclaredIsRejected() {
            // given
            final FitnessStep inconsistent = (context, current) -> new Fitness(FitnessLayout.EMPTY, new double[0]);
            final FitnessPipeline broken = new FitnessPipeline(goals, List.of(inconsistent));
            final TypedEObject objectives = objectives(1.0, 2.0);

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> broken.apply(input, objectives));
        }
    }

    @Nested
    @DisplayName("given a pipeline with a scalarisation")
    class WithScalarisation {
        private final Space space = space(EcorePackage.Literals.EDOUBLE, "a", "b");

        private final EStructuralFeature a = space.getEClass().getEStructuralFeature("a");

        private final EStructuralFeature b = space.getEClass().getEStructuralFeature("b");

        private final Goals goals = new Goals(List.of(new Goal.Minimise(a), new Goal.Maximise(b)));

        private Fitness fitnessOf(final List<FitnessStep> steps, final double valueOfA, final double valueOfB) {
            final FitnessPipeline pipeline = new FitnessPipeline(goals, steps);
            final TypedEObject objectives = space.newEObject();
            objectives.eSet(a, valueOfA);
            objectives.eSet(b, valueOfB);

            return pipeline.apply(space.newEObject(), objectives);
        }

        @Test
        public void theWeightedSumUsesTheCanonicalDirection() {
            // given: a is minimised, b is maximised, so the fitness is 0.5 * a + 0.5 * (-b)
            final List<FitnessStep> steps = List.of(new WeightedSumStep(Map.of(), true));

            // when
            final double better = fitnessOf(steps, 1.0, 5.0).value(0);
            final double worse = fitnessOf(steps, 2.0, 3.0).value(0);

            // then
            Assertions.assertEquals(-2.0, better);
            Assertions.assertEquals(-0.5, worse);
            Assertions.assertTrue(better < worse);
        }

        @Test
        public void scalingBeforeTheWeightedSumScalesTheComponent() {
            // given
            final List<FitnessStep> steps = List.of(new ScalingStep(Map.of("b", 10.0)),
                                                    new WeightedSumStep(Map.of("a", 1.0, "b", 1.0), false));

            // when
            final Fitness fitness = fitnessOf(steps, 1.0, 20.0);

            // then
            Assertions.assertEquals(1.0 - 2.0, fitness.value(0));
        }

        @Test
        public void theObjectiveSelectionKeepsTheCanonicalFitnessAndTheGoal() {
            // given
            final List<FitnessStep> steps = List.of(new ObjectiveSelectionStep("b"));

            // when
            final Fitness fitness = fitnessOf(steps, 1.0, 5.0);

            // then
            Assertions.assertArrayEquals(new double[] {-5.0}, fitness.values());
            Assertions.assertEquals(goals.get(1), fitness.layout().component(0).goal().orElseThrow());
        }

        @Test
        public void aScalarisationBeforeTheLastStepIsRejected() {
            // given
            final List<FitnessStep> steps = List.of(new WeightedSumStep(Map.of(), true),
                                                    new ScalingStep(Map.of("weighted-sum", 2.0)));

            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> new FitnessPipeline(goals, steps));
        }

        @Test
        public void aSecondScalarisationIsRejected() {
            // given
            final List<FitnessStep> steps = List.of(new WeightedSumStep(Map.of(), true),
                                                    new WeightedSumStep(Map.of(), false));

            // when, then
            Assertions.assertThrows(IllegalArgumentException.class, () -> new FitnessPipeline(goals, steps));
        }
    }

    @Nested
    @DisplayName("given a pipeline without configured steps")
    class DirectionOnly {
        private final Space space = space(EcorePackage.Literals.EDOUBLE, "y");

        private final EStructuralFeature y = space.getEClass().getEStructuralFeature("y");

        private Fitness fitnessOf(final Goal goal, final double value) {
            final FitnessPipeline pipeline = new FitnessPipeline(new Goals(List.of(goal)), List.of());
            final TypedEObject objectives = space.newEObject();
            objectives.eSet(y, value);

            return pipeline.apply(space.newEObject(), objectives);
        }

        @Test
        public void onlyTheDirectionStepRuns() {
            // given
            final FitnessPipeline pipeline = new FitnessPipeline(new Goals(List.of(new Goal.Minimise(y))), List.of());

            // when
            final List<FitnessStep> steps = pipeline.steps();

            // then
            Assertions.assertEquals(1, steps.size());
            Assertions.assertInstanceOf(DirectionStep.class, steps.getFirst());
        }

        @Test
        public void aMinimisedObjectiveIsKept() {
            Assertions.assertEquals(2.5, fitnessOf(new Goal.Minimise(y), 2.5).value(0));
        }

        @Test
        public void aMaximisedObjectiveIsNegated() {
            Assertions.assertEquals(-2.5, fitnessOf(new Goal.Maximise(y), 2.5).value(0));
        }

        @Test
        public void aMaximisedZeroIsPositiveZero() {
            // when
            final double value = fitnessOf(new Goal.Maximise(y), 0.0).value(0);

            // then
            Assertions.assertEquals(0, Double.compare(0.0, value));
        }

        @Test
        public void aTargetBecomesTheDistanceOfTheGoal() {
            // given
            final Goal.Target absolute = new Goal.Target(y, 4.0, new AbsoluteDistance());
            final Goal.Target squared = new Goal.Target(y, 4.0, new SquaredDistance());

            // then
            Assertions.assertEquals(1.5, fitnessOf(absolute, 2.5).value(0));
            Assertions.assertEquals(1.5, fitnessOf(absolute, 5.5).value(0));
            Assertions.assertEquals(0.0, fitnessOf(absolute, 4.0).value(0));
            Assertions.assertEquals(2.25, fitnessOf(squared, 2.5).value(0));
            Assertions.assertEquals(0.0, fitnessOf(squared, 4.0).value(0));
        }
    }

    @Nested
    @DisplayName("given an integer objective")
    class IntegerObjective {
        private final Space space = space(EcorePackage.Literals.EINT, "n");

        private final EStructuralFeature n = space.getEClass().getEStructuralFeature("n");

        @Test
        public void theValueIsConvertedExactly() {
            // given
            final FitnessPipeline pipeline = new FitnessPipeline(new Goals(List.of(new Goal.Minimise(n))), List.of());
            final TypedEObject objectives = space.newEObject();
            objectives.eSet(n, Integer.MAX_VALUE);

            // when
            final Fitness fitness = pipeline.apply(space.newEObject(), objectives);

            // then
            Assertions.assertEquals((double) Integer.MAX_VALUE, fitness.value(0));
        }
    }

    /**
     * Today's value conversions ({@link ComparatorFactory}) use maximisation; the canonical
     *   fitness is their negation. So the fitness orders two candidates exactly opposite to
     *   the numeric comparator.
     */
    @Nested
    @DisplayName("given today's value conversions")
    class ValueConversions {
        private final Space space = space(EcorePackage.Literals.EDOUBLE, "y");

        private final EStructuralFeature y = space.getEClass().getEStructuralFeature("y");

        private Map<EStructuralFeature, Function<Number, Number>> conversionsOf(final Goals goals) {
            final ComparatorFactory factory = new ComparatorFactory();

            return factory.createValueConversions(goals);
        }

        private static Goals goalsOf(final Problem problem) {
            return Goals.of(problem, null, configuration -> new AbsoluteDistance());
        }

        private TypedEObject objectives(final double value) {
            final TypedEObject objectives = space.newEObject();
            objectives.eSet(y, value);

            return objectives;
        }

        @Test
        public void aMinimisedObjectiveIsOrderedOppositeToTheNumericComparator() {
            assertOppositeOrder(ModelFactory.eINSTANCE.createMinimiseGoal());
        }

        @Test
        public void aMaximisedObjectiveIsOrderedOppositeToTheNumericComparator() {
            assertOppositeOrder(ModelFactory.eINSTANCE.createMaximiseGoal());
        }

        @Test
        public void aTargetIsOrderedOppositeToTheNumericComparator() {
            final TargetGoal target = ModelFactory.eINSTANCE.createTargetGoal();
            target.setValue(3.0);

            assertOppositeOrder(target);
        }

        private void assertOppositeOrder(final OptimisationGoal goal) {
            // given
            goal.setData(y);
            final Problem problem = ModelFactory.eINSTANCE.createProblem();
            problem.getGoals().add(goal);

            final Goals goals = goalsOf(problem);
            final Map<EStructuralFeature, Function<Number, Number>> conversions = conversionsOf(goals);
            final FitnessPipeline pipeline = new FitnessPipeline(goals, List.of());
            final SplittableRandom random = new SplittableRandom(42);

            for(int pair = 0; pair < 1000; ++pair) {
                // values on a coarse grid, so that ties occur
                final TypedEObject first = objectives(random.nextInt(-20, 21) / 4.0);
                final TypedEObject second = objectives(random.nextInt(-20, 21) / 4.0);

                // when
                final double firstFitness = pipeline.apply(first, first).value(0);
                final double secondFitness = pipeline.apply(second, second).value(0);
                final NumericOptimisationValue firstValue = NumericOptimisationValue.of(conversions, first);
                final NumericOptimisationValue secondValue = NumericOptimisationValue.of(conversions, second);

                // then
                final int byFitness = Integer.signum(Double.compare(firstFitness, secondFitness));
                final int byComparator = Integer.signum(firstValue.compareTo(secondValue));
                Assertions.assertEquals(-byComparator, byFitness, () -> first + " vs. " + second);
            }
        }
    }
}
