package de.evoal.optimisation.api.run;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Identity;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.IndividualStub;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.IterationStep;
import de.evoal.models.v202704.optimisation.memory.Mutation;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.memory.Recombination;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.models.v202704.optimisation.memory.Replacement;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.model.IndividualIDGenerator;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;

import org.eclipse.emf.ecore.EObject;

public class OptimisationRunTest {
    /**
     * What happened in the run, in order.
     */
    private final List<String> protocol = new ArrayList<>();

    /**
     * The iterations the statistics writer received.
     */
    private final List<Iteration> iterations = new ArrayList<>();

    /**
     * Checks the properties; accepts every property unless a test says otherwise.
     */
    private final ExecutionRecorder recorder = Mockito.mock(ExecutionRecorder.class);

    private final OptimisationRun kernel = kernel();

    /**
     * Continues while the number of the last iteration is smaller than {@link #lastIteration}.
     */
    private final TerminationCriterion criterion = Mockito.mock(TerminationCriterion.class);

    private int lastIteration = 2;

    private OptimisationRun kernel() {
        final RunEventDispatcher events = new RunEventDispatcher(Mockito.mock(ExecutionRecorder.class));
        final RunScope scope = new RunScope() {
            @Override
            public void start() {
                protocol.add("scope started");
            }

            @Override
            public void stop() {
                protocol.add("scope stopped");
            }
        };
        final StatisticsWriter statistics = new StatisticsWriter() {
            @Override
            public void start() {
                protocol.add("statistics started");
            }

            @Override
            public void add(final Iteration iteration) {
                protocol.add("iteration " + iteration.getNumber());
                iterations.add(iteration);
            }

            @Override
            public void write() {
                protocol.add("statistics written");
            }

            @Override
            public StatisticsWriter init(final EObject configuration) {
                return this;
            }
        };

        return new OptimisationRun(events, new IndividualIDGenerator(), recorder, scope, statistics);
    }

    @BeforeEach
    public void configureCriterion() {
        Mockito.when(criterion.shouldContinue(Mockito.any()))
               .thenAnswer(invocation -> invocation.<Iteration>getArgument(0).getNumber() < lastIteration);
    }

    /**
     * @return An evaluated member whose fitness and optimisation value are {@code value}.
     */
    private static Candidate member(final double value, final Lineage lineage) {
        final TypedEObject input = Mockito.mock(TypedEObject.class);

        return Candidate.evaluated(input, evaluation(value), lineage);
    }

    /**
     * @return An evaluation whose fitness and optimisation value are {@code value}.
     */
    private static Evaluation evaluation(final double value) {
        final TypedEObject output = Mockito.mock(TypedEObject.class);
        final FitnessLayout layout = new FitnessLayout(List.of(FitnessComponent.named("f")));
        final Fitness fitness = new Fitness(layout, new double[] {value});

        return new Evaluation(output, fitness, new Value(value));
    }

    private static List<Integer> idsOf(final Iteration iteration) {
        return iteration.getRanks()
                        .stream()
                        .map(Rank::getMembers)
                        .flatMap(List::stream)
                        .map(Individual::getId)
                        .sorted()
                        .toList();
    }

    private static IndividualRecord individual(final Iteration iteration, final int id) {
        return iteration.getRanks()
                        .stream()
                        .map(Rank::getMembers)
                        .flatMap(List::stream)
                        .filter(individual -> individual.getId() == id)
                        .findFirst()
                        .orElseThrow();
    }

    private static List<Integer> targetIds(final Relationship relationship) {
        return relationship.getTarget()
                           .stream()
                           .map(Individual::getId)
                           .sorted()
                           .toList();
    }

    @Nested
    @DisplayName("given a procedure that always continues")
    class ContinuingProcedure {
        private final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
            final Lineage lineage = number == 0 ? Lineage.NONE : Lineage.mutation(previous.getFirst());
            return new Population(List.of(member(number, lineage), member(-number, Lineage.NONE)),
                                  List.of(List.of(0), List.of(1)));
        });

        @Test
        public void theRunHappensInTheScopeAndTheWritersReceiveEveryIteration() {
            // when
            kernel.execute(criterion, procedure);

            // then
            final List<String> expected = List.of("scope started",
                                                  "statistics started",
                                                  "initialise",
                                                  "iteration 0",
                                                  "iterate 1",
                                                  "iteration 1",
                                                  "iterate 2",
                                                  "iteration 2",
                                                  "statistics written",
                                                  "scope stopped");
            Assertions.assertEquals(expected, protocol);
        }

        @Test
        public void theIdsAreAssignedInMemberOrderAcrossIterations() {
            // when
            kernel.execute(criterion, procedure);

            // then
            Assertions.assertEquals(List.of(0, 1), idsOf(iterations.get(0)));
            Assertions.assertEquals(List.of(2, 3), idsOf(iterations.get(1)));
            Assertions.assertEquals(List.of(4, 5), idsOf(iterations.get(2)));
        }

        @Test
        public void theIndividualsHaveTheFitnessOfTheirMembers() {
            // when
            kernel.execute(criterion, procedure);

            // then
            Assertions.assertEquals(List.of(1.0), individual(iterations.get(1), 2).getFitness());
            Assertions.assertEquals(List.of(-1.0), individual(iterations.get(1), 3).getFitness());
        }

        @Test
        public void theRanksKeepTheOrderOfThePopulation() {
            // when
            kernel.execute(criterion, procedure);

            // then
            final List<Rank> ranks = iterations.get(1).getRanks();
            Assertions.assertEquals(List.of(0, 1), ranks.stream().map(Rank::getNumber).toList());
            Assertions.assertEquals(2, ranks.get(0).getMembers().getFirst().getId());
            Assertions.assertEquals(3, ranks.get(1).getMembers().getFirst().getId());
        }

        @Test
        public void theLineageRefersToTheIndividualsOfThePreviousIteration() {
            // when
            kernel.execute(criterion, procedure);

            // then
            final IndividualRecord mutated = individual(iterations.get(2), 4);
            final Relationship relationship = mutated.getRelationships().getFirst();
            Assertions.assertInstanceOf(Mutation.class, relationship);
            Assertions.assertEquals(List.of(2), targetIds(relationship));

            final IndividualRecord unrelated = individual(iterations.get(2), 5);
            Assertions.assertEquals(List.of(), unrelated.getRelationships());
        }

        @Test
        public void relationshipsToThePreviousIterationEndInStubs() {
            // when
            kernel.execute(criterion, procedure);

            // then
            final Individual target = individual(iterations.get(2), 4).getRelationships().getFirst().getTarget().getFirst();
            final IndividualStub stub = Assertions.assertInstanceOf(IndividualStub.class, target);
            Assertions.assertEquals(2, stub.getId());
            Assertions.assertEquals(1, stub.getIteration());
            Assertions.assertNull(stub.eContainer());
            Assertions.assertEquals(individual(iterations.get(1), 2).getFitness(), stub.getFitness());
            Assertions.assertSame(individual(iterations.get(1), 2).getInput(), stub.getInput());
        }

        @Test
        public void theBestSoFarIsARecordOfItsIteration() {
            // when
            kernel.execute(criterion, procedure);

            // then
            final IndividualRecord best = iterations.get(2).getBestSoFar();
            Assertions.assertNotNull(best.eContainer());
            best.getRelationships()
                .forEach(relationship -> relationship.getTarget()
                                                     .forEach(target -> Assertions.assertInstanceOf(IndividualStub.class, target)));
        }

        @Test
        public void theMembersOfARecordedIterationForgetTheirPredecessors() {
            // given
            final List<Candidate> members = new ArrayList<>();
            final FakeProcedure recording = new FakeProcedure((number, previous) -> {
                final Lineage lineage = number == 0 ? Lineage.NONE : Lineage.mutation(previous.getFirst());
                final Candidate member = member(number, lineage);
                members.add(member);
                return Population.of(member);
            });

            // when
            kernel.execute(criterion, recording);

            // then
            members.forEach(member -> Assertions.assertEquals(Lineage.Kind.RECORDED, member.lineage().kind()));
        }

        @Test
        public void aRecordedCandidateCannotBeRecordedAgain() {
            // given: the same candidate object is a member of every iteration
            final Candidate member = member(1, Lineage.NONE);
            final FakeProcedure same = new FakeProcedure((number, previous) -> Population.of(member));

            // when
            final IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                                                                            () -> kernel.execute(criterion, same));

            // then
            Assertions.assertTrue(exception.getMessage().contains("already recorded"), exception.getMessage());
        }
    }

    @Nested
    @DisplayName("given a population whose best member gets worse")
    class BestSoFar {
        /**
         * Iteration 0 has the values 1 and 2 (ids 0, 1), iteration 1 the values 3 and 2
         *   (ids 2, 3), iteration 2 the values 0 and 3 (ids 4, 5).
         */
        private final double[][] values = {{1.0, 2.0}, {3.0, 2.0}, {0.0, 3.0}};

        @BeforeEach
        public void run() {
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                final Lineage lineage = number == 0 ? Lineage.NONE : Lineage.identity(previous.getFirst());
                final List<Candidate> members = List.of(member(values[number][0], lineage),
                                                     member(values[number][1], Lineage.NONE));

                return new Population(members, List.of(List.of(0, 1)));
            });

            kernel.execute(criterion, procedure);
        }

        private int bestSoFarId(final int iteration) {
            return iterations.get(iteration).getBestSoFar().getId();
        }

        @Test
        public void theBestOfTheInitialPopulationIsTheBestSoFar() {
            Assertions.assertEquals(1, bestSoFarId(0));
        }

        @Test
        public void aBetterIndividualBecomesTheBestSoFar() {
            Assertions.assertEquals(2, bestSoFarId(1));
        }

        @Test
        public void theBestSoFarStaysWhenThePopulationGetsWorseOrOnlyEqual() {
            Assertions.assertEquals(2, bestSoFarId(2));
        }

        @Test
        public void anIdentityRefersToTheUnchangedIndividual() {
            final Relationship relationship = individual(iterations.get(1), 2).getRelationships().getFirst();

            Assertions.assertInstanceOf(Identity.class, relationship);
            Assertions.assertEquals(List.of(0), targetIds(relationship));
        }
    }

    @Nested
    @DisplayName("given a procedure whose budget runs out")
    class ExhaustedBudget {
        @Test
        public void anInterruptedIterationIsRecordedAndEndsTheRun() {
            // given
            lastIteration = 10;
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> Population.of(member(number, Lineage.NONE)));
            procedure.exhaustedInIteration = 1;

            // when
            kernel.execute(criterion, procedure);

            // then
            Assertions.assertEquals(List.of(0, 1), iterations.stream().map(Iteration::getNumber).toList());
            Assertions.assertTrue(protocol.contains("statistics written"));
        }

        @Test
        public void anInterruptedInitialisationIsRecordedAndEndsTheRun() {
            // given
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> Population.of(member(number, Lineage.NONE)));
            procedure.exhaustedInIteration = 0;

            // when
            kernel.execute(criterion, procedure);

            // then
            Assertions.assertEquals(List.of(0), iterations.stream().map(Iteration::getNumber).toList());
            Mockito.verifyNoInteractions(criterion);
        }
    }

    @Nested
    @DisplayName("given a procedure that stops")
    class StoppingProcedure {
        @Test
        public void theStoppedIterationIsRecordedAndEndsTheRun() {
            // given
            lastIteration = 10;
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> Population.of(member(number, Lineage.NONE)));
            procedure.stopInIteration = 2;

            // when
            kernel.execute(criterion, procedure);

            // then
            Assertions.assertEquals(List.of(0, 1, 2), iterations.stream().map(Iteration::getNumber).toList());
        }
    }

    @Nested
    @DisplayName("given an invalid lineage")
    class InvalidLineage {
        @Test
        public void aPredecessorOutsideThePreviousPopulationIsRejectedAndTheScopeIsStopped() {
            // given
            final Candidate unknown = member(5, Lineage.NONE);
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                final Lineage lineage = number == 0 ? Lineage.NONE : Lineage.mutation(unknown);
                return Population.of(member(number, lineage));
            });

            // when
            Assertions.assertThrows(IllegalStateException.class, () -> kernel.execute(criterion, procedure));

            // then
            Assertions.assertEquals("scope stopped", protocol.getLast());
            Assertions.assertFalse(protocol.contains("statistics written"));
        }
    }

    @Nested
    @DisplayName("given a member that combines two members")
    class Recombining {
        @Test
        public void aRecombinationRefersToAllParents() {
            // given
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                if(number == 0) {
                    return new Population(List.of(member(1, Lineage.NONE), member(2, Lineage.NONE)),
                                          List.of(List.of(0, 1)));
                }
                return Population.of(member(3, Lineage.recombination(previous)));
            });
            lastIteration = 1;

            // when
            kernel.execute(criterion, procedure);

            // then
            final Relationship relationship = individual(iterations.get(1), 2).getRelationships().getFirst();
            Assertions.assertInstanceOf(Recombination.class, relationship);
            Assertions.assertEquals(List.of(0, 1), targetIds(relationship));
        }
    }

    @Nested
    @DisplayName("given two children of the same recombination")
    class Siblings {
        @Test
        public void theirRecombinationsReferToEachOther() {
            // given
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                if(number == 0) {
                    return new Population(List.of(member(1, Lineage.NONE), member(2, Lineage.NONE)), List.of(List.of(0, 1)));
                }
                final Object pair = new Object();
                return new Population(List.of(member(3, Lineage.recombination(previous, pair)),
                                              member(4, Lineage.recombination(previous.reversed(), pair))),
                                      List.of(List.of(0, 1)));
            });
            lastIteration = 1;

            // when
            kernel.execute(criterion, procedure);

            // then
            final Recombination first = (Recombination) individual(iterations.get(1), 2).getRelationships().getFirst();
            final Recombination second = (Recombination) individual(iterations.get(1), 3).getRelationships().getFirst();
            Assertions.assertSame(second, first.getOther());
            Assertions.assertSame(first, second.getOther());
        }

        @Test
        public void aChildWithoutRecordedSiblingHasNoSibling() {
            // given
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                if(number == 0) {
                    return new Population(List.of(member(1, Lineage.NONE), member(2, Lineage.NONE)), List.of(List.of(0, 1)));
                }
                return Population.of(member(3, Lineage.recombination(previous, new Object())));
            });
            lastIteration = 1;

            // when
            kernel.execute(criterion, procedure);

            // then
            final Recombination recombination = (Recombination) individual(iterations.get(1), 2).getRelationships().getFirst();
            Assertions.assertNull(recombination.getOther());
        }

        @Test
        public void aChildThatIsAMemberTwiceIsLinkedOnce() {
            // given: a selection with replacement kept the first child twice
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                if(number == 0) {
                    return new Population(List.of(member(1, Lineage.NONE), member(2, Lineage.NONE)), List.of(List.of(0, 1)));
                }
                final Object pair = new Object();
                final Candidate first = member(3, Lineage.recombination(previous, pair));
                final Candidate second = member(4, Lineage.recombination(previous.reversed(), pair));
                return new Population(List.of(first, first, second), List.of(List.of(0, 1, 2)));
            });
            lastIteration = 1;

            // when
            kernel.execute(criterion, procedure);

            // then
            final Recombination first = (Recombination) individual(iterations.get(1), 2).getRelationships().getFirst();
            final Recombination duplicate = (Recombination) individual(iterations.get(1), 3).getRelationships().getFirst();
            final Recombination second = (Recombination) individual(iterations.get(1), 4).getRelationships().getFirst();
            Assertions.assertSame(second, first.getOther());
            Assertions.assertSame(first, second.getOther());
            Assertions.assertNull(duplicate.getOther());
        }
    }

    @Test
    public void aLineageMustFitItsKind() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Lineage(Lineage.Kind.MUTATION, List.of(member(1, Lineage.NONE), member(2, Lineage.NONE))));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Lineage(Lineage.Kind.NONE, List.of(member(1, Lineage.NONE))));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Lineage(Lineage.Kind.REPLACEMENT, List.of()));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> Lineage.NONE.withProperty("reason", "none"));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Lineage(Lineage.Kind.MUTATION, List.of(member(1, Lineage.NONE)), java.util.Map.of(), new Object()));
    }

    @Test
    public void aRankMustReferToMembers() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Population(List.of(member(1, Lineage.NONE)), List.of(List.of(1))));
    }

    @Test
    public void aMemberMustBeEvaluated() {
        final Candidate unevaluated = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);

        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new Population(List.of(unevaluated), List.of(List.of(0))));
    }

    @Nested
    @DisplayName("given a member that replaces a previous member")
    class Replacing {
        private final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
            if(number == 0) {
                return Population.of(member(1, Lineage.NONE));
            }

            final Candidate survivor = previous.getFirst().survivor();
            final Candidate replacement = member(2, Lineage.replacement(survivor).withProperty("reason", "too old"));
            replacement.setProperty("age", 0L);
            return Population.of(replacement);
        });

        @BeforeEach
        public void lastIterationIsOne() {
            lastIteration = 1;
        }

        @Test
        public void theReplacementRefersToTheReplacedIndividualWithItsProperties() {
            // when
            kernel.execute(criterion, procedure);

            // then
            final IndividualRecord replacement = individual(iterations.get(1), 1);
            final Relationship relationship = replacement.getRelationships().getFirst();
            Assertions.assertInstanceOf(Replacement.class, relationship);
            Assertions.assertEquals(List.of(0), targetIds(relationship));
            Assertions.assertEquals("too old", relationship.getProperties().get("reason"));
            Assertions.assertEquals(0L, replacement.getProperties().get("age"));
        }

        @Test
        public void thePropertiesAreCheckedByTheRecorder() {
            // when
            kernel.execute(criterion, procedure);

            // then
            Mockito.verify(recorder).requireProperty("reason", PropertyScope.RELATIONSHIP, "too old");
            Mockito.verify(recorder).requireProperty("age", PropertyScope.INDIVIDUAL, 0L);
        }

        @Test
        public void anUndefinedPropertyIsRejected() {
            // given
            Mockito.doThrow(new IllegalStateException("not defined"))
                   .when(recorder)
                   .requireProperty("reason", PropertyScope.RELATIONSHIP, "too old");

            // when, then
            Assertions.assertThrows(IllegalStateException.class, () -> kernel.execute(criterion, procedure));
        }
    }

    @Nested
    @DisplayName("given a member that refers to an unchanged copy of a previous member")
    class CopiedPredecessor {
        @Test
        public void theCopyStandsForItsOriginal() {
            // given: the previous member 0 is copied twice, the new member mutates the copy
            final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
                if(number == 0) {
                    return Population.of(member(1, Lineage.NONE));
                }
                final Candidate copy = previous.getFirst().copy().copy();
                return Population.of(member(2, Lineage.mutation(copy)));
            });
            lastIteration = 1;

            // when
            kernel.execute(criterion, procedure);

            // then
            final Relationship relationship = individual(iterations.get(1), 1).getRelationships().getFirst();
            Assertions.assertInstanceOf(Mutation.class, relationship);
            Assertions.assertEquals(List.of(0), targetIds(relationship));
        }
    }

    @Nested
    @DisplayName("given steps with outputs")
    class StepOutputs {
        /**
         * Iteration 0 samples a (id 0) and b (id 1). Iteration 1 selects the survivor of a twice
         *   (ids 2, 3), recombines it with the survivor of b, which occurs in no step, into r
         *   (4), mutates r into m (5) and creates u (6), which is not evaluated, evaluates m and
         *   keeps m and the survivor of a.
         */
        private final FakeProcedure procedure = new FakeProcedure((number, previous) -> {
            if(number == 0) {
                final Candidate a = member(1, Lineage.NONE);
                final Candidate b = member(2, Lineage.NONE);
                return new Population(List.of(a, b), List.of(List.of(0, 1)),
                                      List.of(new ExecutedStep("Initialization", "sample", List.of(a, b))));
            }

            final Candidate parentA = previous.get(0).survivor();
            final Candidate parentB = previous.get(1).survivor();
            final Candidate recombined = new Candidate(Mockito.mock(TypedEObject.class),
                                                       Lineage.recombination(List.of(parentA, parentB)));
            final Candidate mutated = new Candidate(Mockito.mock(TypedEObject.class),
                                                    Lineage.recombination(List.of(parentA, parentB)),
                                                    Lineage.mutation(recombined));
            mutated.evaluate(evaluation(3));
            final Candidate unevaluated = new Candidate(Mockito.mock(TypedEObject.class), Lineage.mutation(parentA));

            final List<ExecutedStep> steps = List.of(
                    new ExecutedStep("Selection", "select", List.of(parentA, parentA)),
                    new ExecutedStep("Adaption", "recombine", List.of(recombined)),
                    new ExecutedStep("Adaption", "mutate", List.of(mutated, unevaluated)),
                    new ExecutedStep("FitnessCalculation", "evaluate", List.of(mutated)),
                    new ExecutedStep("Acceptance", "replace", List.of(mutated, parentA)),
                    new ExecutedStep("ParameterAdjustment", "adjust", List.of()));
            return new Population(List.of(mutated, parentA), List.of(List.of(0), List.of(1)), steps);
        });

        @BeforeEach
        public void run() {
            lastIteration = 1;
            kernel.execute(criterion, procedure);
        }

        private List<IterationStep> steps() {
            return iterations.get(1).getSteps();
        }

        private IndividualRecord inStep(final int step, final int index) {
            return ((UnorderedIterationStep) steps().get(step)).getIndividuals().get(index);
        }

        private List<Integer> idsOfStep(final int step) {
            return ((UnorderedIterationStep) steps().get(step)).getIndividuals()
                                                                .stream()
                                                                .map(Individual::getId)
                                                                .toList();
        }

        @Test
        public void everyStepHoldsItsOutputsWithIdsInTheOrderOfTheirFirstOccurrence() {
            Assertions.assertEquals(List.of("Selection: select", "Adaption: recombine", "Adaption: mutate",
                                            "FitnessCalculation: evaluate", "Acceptance: replace",
                                            "ParameterAdjustment: adjust"),
                                    steps().stream().map(IterationStep::getDescription).toList());
            Assertions.assertEquals(List.of(2, 3), idsOfStep(0));
            Assertions.assertEquals(List.of(4), idsOfStep(1));
            Assertions.assertEquals(List.of(5, 6), idsOfStep(2));
            Assertions.assertEquals(List.of(5), idsOfStep(3));
            Assertions.assertEquals(List.of(5, 2), idsOfStep(4));
            Assertions.assertEquals(List.of(), idsOfStep(5));
            Assertions.assertEquals(List.of(2, 5), idsOf(iterations.get(1)));
        }

        @Test
        public void anIndividualOfSeveralStepsIsACopyWithTheSameValues() {
            final IndividualRecord mutated = inStep(2, 0);
            final IndividualRecord evaluated = inStep(3, 0);

            Assertions.assertNotSame(mutated, evaluated);
            Assertions.assertSame(mutated.getInput(), evaluated.getInput());
            Assertions.assertSame(mutated.getOutput(), evaluated.getOutput());
            Assertions.assertEquals(mutated.getFitness(), evaluated.getFitness());
        }

        @Test
        public void anUnevaluatedOutputHasNoOutput() {
            final IndividualRecord unevaluated = inStep(2, 1);

            Assertions.assertNull(unevaluated.getOutput());
            Assertions.assertEquals(List.of(), unevaluated.getFitness());
        }

        @Test
        public void theStepsRelateEveryIndividualToItsDirectPredecessor() {
            // the selected survivor stands for a, the survivor of b that occurs in no step for b
            Assertions.assertInstanceOf(Identity.class, inStep(0, 0).getRelationships().getFirst());
            Assertions.assertEquals(List.of(0), targetIds(inStep(0, 1).getRelationships().getFirst()));
            Assertions.assertInstanceOf(Recombination.class, inStep(1, 0).getRelationships().getFirst());
            Assertions.assertEquals(List.of(1, 2), targetIds(inStep(1, 0).getRelationships().getFirst()));

            final Relationship mutation = inStep(2, 0).getRelationships().getFirst();
            Assertions.assertInstanceOf(Mutation.class, mutation);
            Assertions.assertEquals(List.of(4), targetIds(mutation));
            Assertions.assertEquals(List.of(2), targetIds(inStep(2, 1).getRelationships().getFirst()));
        }

        @Test
        public void theRanksRelateTheMembersToThePreviousIteration() {
            final Relationship recombination = individual(iterations.get(1), 5).getRelationships().getFirst();
            Assertions.assertInstanceOf(Recombination.class, recombination);
            Assertions.assertEquals(List.of(0, 1), targetIds(recombination));

            final Relationship identity = individual(iterations.get(1), 2).getRelationships().getFirst();
            Assertions.assertInstanceOf(Identity.class, identity);
            Assertions.assertEquals(List.of(0), targetIds(identity));
            Assertions.assertNotSame(inStep(4, 0), individual(iterations.get(1), 5));
        }
    }

    /**
     * A procedure whose population of iteration {@code n} is given by a function.
     */
    private final class FakeProcedure implements SearchProcedure {
        /**
         * Creates the population of an iteration from its number and the members of the
         *   previous population.
         */
        private final BiFunction<Integer, List<Candidate>, Population> populations;

        private List<Candidate> previous = List.of();

        private int iteration;

        /**
         * The iteration in which the budget runs out, -1 for none.
         */
        private int exhaustedInIteration = -1;

        /**
         * The iteration that stops the search, -1 for none.
         */
        private int stopInIteration = -1;

        private FakeProcedure(final BiFunction<Integer, List<Candidate>, Population> populations) {
            this.populations = populations;
        }

        @Override
        public void initialise(final RunEventDispatcher events) {
            protocol.add("initialise");
            exhaustIn(0);
        }

        @Override
        public Progress iterate(final int iteration) {
            this.iteration = iteration;
            protocol.add("iterate " + iteration);
            exhaustIn(iteration);

            return iteration == stopInIteration ? Progress.STOP : Progress.CONTINUE;
        }

        private void exhaustIn(final int iteration) {
            if(iteration == exhaustedInIteration) {
                throw new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 3);
            }
        }

        @Override
        public Population population() {
            final Population population = populations.apply(iteration, previous);
            previous = population.members();

            return population;
        }
    }

    /**
     * An optimisation value with a single number, greater values are better.
     */
    private static final class Value extends MinimalEObjectImpl.Container implements OptimisationValue {
        private final double value;

        private Value(final double value) {
            this.value = value;
        }

        @Override
        public int compareTo(final OptimisationValue other) {
            return Double.compare(value, ((Value) other).value);
        }

        @Override
        public boolean isBetter(final OptimisationValue other) {
            return compareTo(other) > 0;
        }

        @Override
        public boolean isEqual(final OptimisationValue other) {
            return compareTo(other) == 0;
        }

        @Override
        public boolean isWorse(final OptimisationValue other) {
            return compareTo(other) < 0;
        }

        @Override
        public TypedEObject toOptmisationSpace() {
            return null;
        }

        @Override
        public List<Object> toStatistics() {
            return List.of(value);
        }
    }
}
