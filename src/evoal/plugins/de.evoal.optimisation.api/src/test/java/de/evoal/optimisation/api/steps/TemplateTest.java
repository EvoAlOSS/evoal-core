package de.evoal.optimisation.api.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.evaluation.EvaluationBudgetExhaustedException;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.events.StepExecuted;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.ExecutedStep;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.run.Population;
import de.evoal.optimisation.api.run.Progress;

public class TemplateTest {
    private final RunEventDispatcher events = new RunEventDispatcher(Mockito.mock(ExecutionRecorder.class));

    /**
     * The published steps as "iteration: description".
     */
    private final List<String> published = new ArrayList<>();

    @BeforeEach
    public void listen() {
        events.dispatchTo(List.of(event -> {
            if(event instanceof StepExecuted(var iteration, var step)) {
                published.add(iteration + ": " + step.getDescription());
            }
        }));
    }

    private static Candidate evaluated(final double value, final Lineage lineage) {
        final TypedEObject input = Mockito.mock(TypedEObject.class);
        final TypedEObject output = Mockito.mock(TypedEObject.class);
        final Fitness fitness = new Fitness(FitnessLayout.EMPTY, new double[0]);
        final Evaluation evaluation = new Evaluation(output, fitness, new TestValue(value));

        return Candidate.evaluated(input, evaluation, lineage);
    }

    /**
     * @return An acceptance that executes the action.
     */
    private static Step acceptance(final String description, final Consumer<SearchState> action) {
        return new Acceptance() {
            @Override
            public String description() {
                return description;
            }

            @Override
            public void execute(final SearchState state) {
                action.accept(state);
            }
        };
    }

    private static List<String> descriptionsOf(final Population population) {
        return population.steps()
                         .stream()
                         .map(step -> step.kind() + ": " + step.description())
                         .toList();
    }

    @Nested
    @DisplayName("given a template that replaces its population in every iteration")
    class ReplacingTemplate {
        private final Template template = new Template(
                List.of(acceptance("start", state -> state.setPopulation(List.of(evaluated(1.0, Lineage.NONE),
                                                                                  evaluated(3.0, Lineage.NONE),
                                                                                  evaluated(1.0, Lineage.NONE))))),
                List.of(acceptance("keep", state -> { }),
                        acceptance("stop", SearchState::stop)));

        @Test
        public void everyExecutedStepIsPublishedWithItsKind() {
            // when
            template.initialise(events);
            template.population();
            template.iterate(1);

            // then
            Assertions.assertEquals(List.of("0: Acceptance: start", "1: Acceptance: keep", "1: Acceptance: stop"),
                                    published);
        }

        @Test
        public void thePopulationHasTheStepsOfItsIterationOnly() {
            // when
            template.initialise(events);
            final Population initial = template.population();
            template.iterate(1);
            final Population next = template.population();

            // then
            Assertions.assertEquals(List.of("Acceptance: start"), descriptionsOf(initial));
            Assertions.assertEquals(List.of("Acceptance: keep", "Acceptance: stop"), descriptionsOf(next));
        }

        @Test
        public void thePopulationIsRankedByValue() {
            // when
            template.initialise(events);
            final Population population = template.population();

            // then
            Assertions.assertEquals(List.of(List.of(1), List.of(0, 2)), population.ranks());
        }

        @Test
        public void aMemberThatStaysIsAnIdentityOfItself() {
            // when
            template.initialise(events);
            final Population initial = template.population();
            template.iterate(1);
            final Population population = template.population();

            // then
            final List<Lineage> lineages = population.members()
                                                     .stream()
                                                     .map(Candidate::lineage)
                                                     .toList();
            final List<Lineage> expected = initial.members()
                                                  .stream()
                                                  .map(Lineage::identity)
                                                  .toList();
            Assertions.assertEquals(expected, lineages);
            Assertions.assertNotSame(initial.members().getFirst(), population.members().getFirst());
        }

        @Test
        public void aMemberThatStaysIsOneIterationOlder() {
            // when
            template.initialise(events);
            template.population();
            template.iterate(1);
            final Population population = template.population();

            // then
            Assertions.assertEquals(List.of(1, 1, 1), population.members().stream().map(Candidate::age).toList());
            Assertions.assertEquals(List.of(2, 2, 2), template.state().getPopulation().stream().map(Candidate::age).toList());
        }

        @Test
        public void aStepCanStopTheSearch() {
            // when
            template.initialise(events);
            template.population();
            final Progress progress = template.iterate(1);

            // then
            Assertions.assertEquals(Progress.STOP, progress);
        }
    }

    @Test
    public void aTemplateCanDescribeItsMembersItself() {
        // given
        final Candidate member = evaluated(4.0, Lineage.NONE);
        final Template template = new Template(List.of(), List.of()) {
            @Override
            protected List<Candidate> members() {
                return List.of(member);
            }
        };
        template.initialise(events);

        // when
        final Population population = template.population();

        // then
        Assertions.assertEquals(List.of(member), population.members());
        Assertions.assertEquals(List.of(List.of(0)), population.ranks());
    }

    @Test
    public void anUnevaluatedMemberIsRejected() {
        // given
        final Candidate unevaluated = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);
        final Template template = new Template(List.of(acceptance("start", state -> state.setPopulation(List.of(unevaluated)))),
                                    List.of());
        template.initialise(events);

        // when / then
        Assertions.assertThrows(IllegalArgumentException.class, template::population);
    }

    @Test
    public void anInterruptedIterationKeepsThePopulation() {
        // given
        final Template template = new Template(
                List.of(acceptance("start", state -> state.setPopulation(List.of(evaluated(2.0, Lineage.NONE))))),
                List.of(acceptance("interrupted", state -> {
                    throw new IllegalStateException("interrupted");
                })));
        template.initialise(events);
        final Candidate initial = template.population().members().getFirst();

        // when
        Assertions.assertThrows(IllegalStateException.class, () -> template.iterate(1));
        final Population population = template.population();

        // then
        Assertions.assertEquals(List.of(Lineage.identity(initial)),
                                population.members().stream().map(Candidate::lineage).toList());
        Assertions.assertEquals(List.of(), population.steps());
    }

    @Test
    public void theStepsOfThePopulationHoldTheirOutputs() {
        // given: the acceptance outputs the new population, the parameter adjustment nothing
        final Candidate member = evaluated(2.0, Lineage.NONE);
        final Template template = new Template(
                List.of(acceptance("start", state -> state.setPopulation(List.of(member))),
                        new ParameterAdjustment() {
                            @Override
                            public String description() {
                                return "adjust";
                            }

                            @Override
                            public void execute(final SearchState state) {
                            }
                        }),
                List.of());
        template.initialise(events);

        // when
        final Population population = template.population();

        // then
        Assertions.assertEquals(List.of(List.of(member), List.of()),
                                population.steps().stream().map(ExecutedStep::outputs).toList());
    }

    @Test
    public void aStepInterruptedByAnExhaustedBudgetIsRecordedWithItsOutputsSoFar() {
        // given
        final Candidate evaluated = evaluated(2.0, Lineage.NONE);
        final Template template = new Template(
                List.of(acceptance("start", state -> state.setPopulation(List.of(evaluated(1.0, Lineage.NONE))))),
                List.of(acceptance("interrupted", state -> {
                    state.setPopulation(List.of(evaluated));
                    throw new EvaluationBudgetExhaustedException(EvaluationSource.REAL, 3);
                })));
        template.initialise(events);
        template.population();

        // when
        Assertions.assertThrows(EvaluationBudgetExhaustedException.class, () -> template.iterate(1));
        final Population population = template.population();

        // then
        Assertions.assertEquals(List.of("Acceptance: interrupted"), descriptionsOf(population));
        Assertions.assertEquals(List.of(evaluated), population.steps().getFirst().outputs());
    }
}
