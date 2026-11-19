package de.evoal.optimisation.main.checks;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;

public class MaximumAgeCheckTest {
    private final MaximumAgeCheck check = new MaximumAgeCheck(2, CheckReaction.REPLACE);

    /**
     * @return A candidate that was carried over into {@code age} iterations unchanged.
     */
    private static Candidate aged(final int age) {
        Candidate candidate = new Candidate(Mockito.mock(TypedEObject.class), Lineage.NONE);
        for(int i = 0; i < age; ++i) {
            candidate = candidate.survivor();
        }

        return candidate;
    }

    @Test
    public void theMaximumAgeIsAllowed() {
        Assertions.assertEquals(Optional.empty(), check.test(aged(0)));
        Assertions.assertEquals(Optional.empty(), check.test(aged(2)));
    }

    @Test
    public void anOlderCandidateFails() {
        Assertions.assertEquals(Optional.of("age 3 exceeds 2 iterations"), check.test(aged(3)));
    }

    @Test
    public void theCheckTestsThePopulationAndWarnsOrReplaces() {
        Assertions.assertEquals(CheckPoint.POPULATION, check.checkPoint());
        Assertions.assertEquals(Set.of(CheckReaction.WARN, CheckReaction.REPLACE), check.supportedReactions());
        Assertions.assertEquals("maximum-age", check.name());
    }
}
