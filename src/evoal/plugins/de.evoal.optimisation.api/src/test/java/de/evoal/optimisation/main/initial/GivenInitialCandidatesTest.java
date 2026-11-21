package de.evoal.optimisation.main.initial;

import java.util.Collections;
import java.util.List;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * The order of given candidates.
 */
class GivenInitialCandidatesTest {
    @Test
    void withoutRandomTheCandidatesComeOneAfterTheOther() {
        final List<TypedEObject> candidates = Collections.nCopies(2, null);

        // the stream does not end after the last candidate
        Assertions.assertEquals(5, GivenInitialCandidates.order(candidates, null, "test").limit(5).count());
    }

    @Test
    void noCandidatesAreRejected() {
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> GivenInitialCandidates.order(List.of(), RandomGeneratorFactory.of("L64X128MixRandom").create(1), "test"));

        Assertions.assertTrue(e.getMessage().contains("has no candidates"), e.getMessage());
    }
}
