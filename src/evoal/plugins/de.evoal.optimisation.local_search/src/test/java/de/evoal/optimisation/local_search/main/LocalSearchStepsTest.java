package de.evoal.optimisation.local_search.main;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

import de.evoal.optimisation.api.fitness.Evaluation;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.steps.SearchState;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;

public class LocalSearchStepsTest {
    private final AcceptingStrategy acceptingStrategy = Mockito.mock(AcceptingStrategy.class);

    private final SearchState state = new SearchState();

    private Candidate current;

    private static Candidate evaluated(final TypedEObject input) {
        final TypedEObject output = Mockito.mock(TypedEObject.class);
        final Fitness fitness = new Fitness(FitnessLayout.EMPTY, new double[0]);
        final OptimisationValue value = Mockito.mock(OptimisationValue.class);
        final Evaluation evaluation = new Evaluation(output, fitness, value);

        return Candidate.evaluated(input, evaluation, Lineage.NONE);
    }

    @BeforeEach
    public void setCurrentCandidate() {
        current = evaluated(Mockito.mock(TypedEObject.class));
        state.setPopulation(List.of(current));
    }

    @Nested
    @DisplayName("given the offering of neighbours")
    class Offering {
        private final NeighbourChoosingStrategy neighbourStrategy = Mockito.mock(NeighbourChoosingStrategy.class);

        private final List<TypedEObject> neighbours = List.of(Mockito.mock(TypedEObject.class),
                                                              Mockito.mock(TypedEObject.class));

        @Test
        public void allNeighboursAreOfferedAsMutationsOfTheCurrentCandidate() {
            // given
            Mockito.when(neighbourStrategy.neighbours(current.input())).thenReturn(neighbours.stream());

            // when
            new OfferNeighbours(neighbourStrategy, acceptingStrategy).execute(state);

            // then
            final List<Candidate> offered = state.getOffered().toList();
            Assertions.assertEquals(neighbours, offered.stream().map(Candidate::input).toList());
            Assertions.assertTrue(offered.stream().allMatch(candidate -> candidate.lineage().equals(Lineage.mutation(current))));
        }

        @Test
        public void aStrategyThatTestsASingleNeighbourGetsARandomOne() {
            // given
            Mockito.when(acceptingStrategy.testsSingleNeighbour()).thenReturn(true);
            Mockito.when(neighbourStrategy.randomNeighbour(current.input())).thenReturn(Optional.of(neighbours.get(1)));

            // when
            new OfferNeighbours(neighbourStrategy, acceptingStrategy).execute(state);

            // then
            Assertions.assertEquals(List.of(neighbours.get(1)), state.getOffered().map(Candidate::input).toList());
            Mockito.verify(neighbourStrategy, Mockito.never()).neighbours(Mockito.any());
        }
    }

    @Nested
    @DisplayName("given the acceptance of a neighbour")
    class Accepting {
        private final AcceptNeighbour acceptance = new AcceptNeighbour(acceptingStrategy);

        @Test
        public void theAcceptedNeighbourBecomesTheCurrentCandidate() {
            // given
            final Candidate neighbour = evaluated(Mockito.mock(TypedEObject.class));
            state.setCandidates(List.of(neighbour));
            state.setAccepted(neighbour);

            // when
            acceptance.execute(state);

            // then
            Assertions.assertEquals(List.of(neighbour), state.getPopulation());
            Assertions.assertFalse(state.isStopped());
        }

        @Test
        public void aFinalRejectionEndsTheSearch() {
            // given
            Mockito.when(acceptingStrategy.rejectionIsFinal()).thenReturn(true);
            state.setCandidates(List.of(evaluated(Mockito.mock(TypedEObject.class))));

            // when
            acceptance.execute(state);

            // then
            Assertions.assertTrue(state.isStopped());
            Assertions.assertEquals(List.of(current), state.getPopulation());
        }

        @Test
        public void aRandomisedRejectionKeepsTheCandidate() {
            // given
            Mockito.when(acceptingStrategy.rejectionIsFinal()).thenReturn(false);
            state.setCandidates(List.of(evaluated(Mockito.mock(TypedEObject.class))));

            // when
            acceptance.execute(state);

            // then
            Assertions.assertFalse(state.isStopped());
            Assertions.assertEquals(List.of(current), state.getPopulation());
        }

        @Test
        public void noNeighboursEndTheSearch() {
            // given
            Mockito.when(acceptingStrategy.rejectionIsFinal()).thenReturn(false);

            // when
            acceptance.execute(state);

            // then
            Assertions.assertTrue(state.isStopped());
        }

        @Test
        public void aNeighbourIsComparedWithTheCurrentCandidate() {
            // given
            final Candidate neighbour = evaluated(Mockito.mock(TypedEObject.class));
            Mockito.when(acceptingStrategy.acceptCandidate(neighbour.value(), current.value())).thenReturn(true);

            // when / then
            Assertions.assertTrue(acceptance.isAcceptable(state, neighbour));
        }
    }

    @Nested
    @DisplayName("given the adjustment of the accepting strategy")
    class Adjusting {
        @Test
        public void theStrategyGetsTheIteration() {
            // when
            new AdjustAcceptingStrategy(acceptingStrategy).execute(state);

            // then
            Mockito.verify(acceptingStrategy).setIteration(state.getIteration());
        }

        @Test
        public void aStoppedSearchIsNotAdjusted() {
            // given
            state.stop();

            // when
            new AdjustAcceptingStrategy(acceptingStrategy).execute(state);

            // then
            Mockito.verify(acceptingStrategy, Mockito.never()).setIteration(Mockito.anyInt());
        }
    }
}
