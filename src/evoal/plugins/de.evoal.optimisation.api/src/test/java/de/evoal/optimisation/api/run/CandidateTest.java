package de.evoal.optimisation.api.run;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;

public class CandidateTest {
    private final Candidate candidate = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);

    @Test
    public void aNewCandidateHasAgeZero() {
        Assertions.assertEquals(0, candidate.age());
        Assertions.assertEquals(0, new Candidate(candidate.input(), Lineage.mutation(candidate.survivor())).age());
    }

    @Test
    public void aSurvivorIsOneIterationOlderAndAnIdentity() {
        // when
        final Candidate survivor = candidate.survivor().survivor();

        // then
        Assertions.assertEquals(2, survivor.age());
        Assertions.assertEquals(Lineage.Kind.IDENTITY, survivor.lineage().kind());
        Assertions.assertSame(candidate.input(), survivor.input());
    }

    @Test
    public void aCopyKeepsTheAgeButNotTheProperties() {
        // given
        final Candidate survivor = candidate.survivor();
        survivor.setProperty("reason", "test");

        // when
        final Candidate copy = survivor.copy();

        // then
        Assertions.assertEquals(1, copy.age());
        Assertions.assertEquals(Map.of(), copy.properties());
    }

    @Test
    public void lineagePropertiesKeepTheirOrder() {
        // when
        final Lineage lineage = Lineage.replacement(candidate)
                                       .withProperty("b", 1L)
                                       .withProperty("a", "x");

        // then
        Assertions.assertEquals(List.of("b", "a"), List.copyOf(lineage.properties().keySet()));
        Assertions.assertEquals(candidate, lineage.predecessor());
    }
}
