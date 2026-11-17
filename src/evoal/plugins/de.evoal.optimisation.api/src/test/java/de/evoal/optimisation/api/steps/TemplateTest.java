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
import de.evoal.models.v202704.optimisation.memory.IterationStep;

import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.events.StepExecuted;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.run.Candidate;
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
        events.startRun(List.of(event -> {
            if(event instanceof StepExecuted(var iteration, var step)) {
                published.add(iteration + ": " + step.getDescription());
            }
        }));
    }

    private static Candidate evaluated(final double value, final Lineage lineage) {
        final TypedEObject input = Mockito.mock(TypedEObject.class);
        return Candidate.evaluated(input, Mockito.mock(TypedEObject.class), new TestValue(value), lineage);
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
                         .map(IterationStep::getDescription)
                         .toList();
    }

    @Nested
    @DisplayName("given a template that replaces its population in every iteration")
    class ReplacingTemplate {
        private final Template template = new Template(
                events,
                List.of(acceptance("start", state -> state.setPopulation(List.of(evaluated(1.0, Lineage.NONE),
                                                                                  evaluated(3.0, Lineage.NONE),
                                                                                  evaluated(1.0, Lineage.NONE))))),
                List.of(acceptance("keep", state -> { }),
                        acceptance("stop", SearchState::stop)));

        @Test
        public void everyExecutedStepIsPublishedWithItsKind() {
            // when
            template.initialise();
            template.population();
            template.iterate(1);

            // then
            Assertions.assertEquals(List.of("0: Acceptance: start", "1: Acceptance: keep", "1: Acceptance: stop"),
                                    published);
        }

        @Test
        public void thePopulationHasTheStepsOfItsIterationOnly() {
            // when
            template.initialise();
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
            template.initialise();
            final Population population = template.population();

            // then
            Assertions.assertEquals(List.of(List.of(1), List.of(0, 2)), population.ranks());
        }

        @Test
        public void aMemberThatStaysIsAnIdentityOfItself() {
            // when
            template.initialise();
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
        public void aStepCanStopTheSearch() {
            // when
            template.initialise();
            template.population();
            final Progress progress = template.iterate(1);

            // then
            Assertions.assertEquals(Progress.STOP, progress);
        }
    }

    @Test
    public void anUnevaluatedMemberIsRejected() {
        // given
        final Candidate unevaluated = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);
        final Template template = new Template(events,
                                               List.of(acceptance("start", state -> state.setPopulation(List.of(unevaluated)))),
                                               List.of());
        template.initialise();

        // when / then
        Assertions.assertThrows(IllegalArgumentException.class, template::population);
    }

    @Test
    public void anInterruptedIterationKeepsThePopulation() {
        // given
        final Template template = new Template(
                events,
                List.of(acceptance("start", state -> state.setPopulation(List.of(evaluated(2.0, Lineage.NONE))))),
                List.of(acceptance("interrupted", state -> {
                    throw new IllegalStateException("interrupted");
                })));
        template.initialise();
        final Candidate initial = template.population().members().getFirst();

        // when
        Assertions.assertThrows(IllegalStateException.class, () -> template.iterate(1));
        final Population population = template.population();

        // then
        Assertions.assertEquals(List.of(Lineage.identity(initial)),
                                population.members().stream().map(Candidate::lineage).toList());
        Assertions.assertEquals(List.of(), population.steps());
    }
}
