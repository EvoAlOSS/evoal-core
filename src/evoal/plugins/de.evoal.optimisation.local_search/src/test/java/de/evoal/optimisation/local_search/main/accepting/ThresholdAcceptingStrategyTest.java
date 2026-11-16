package de.evoal.optimisation.local_search.main.accepting;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance;

public class ThresholdAcceptingStrategyTest {
    private final OptimisationValue current = Mockito.mock(OptimisationValue.class);

    private static ThresholdAcceptingStrategy withThreshold(final double threshold) throws Exception {
        final ThresholdAcceptingStrategy strategy = new ThresholdAcceptingStrategy();
        final Field field = ThresholdAcceptingStrategy.class.getDeclaredField("threshold");
        field.setAccessible(true);
        field.set(strategy, threshold);

        return strategy;
    }

    /**
     * @return A candidate that is not better than the current one and has the given distance to it.
     */
    private OptimisationValue candidateWithDistance(final double distance) {
        final OptimisationValueWithDistance candidate = Mockito.mock(OptimisationValueWithDistance.class);
        Mockito.when(candidate.isBetter(current)).thenReturn(false);
        Mockito.when(candidate.distanceFrom(current)).thenReturn(distance);

        return candidate;
    }

    @Test
    public void anEqualCandidateIsAccepted() throws Exception {
        Assertions.assertTrue(withThreshold(1.0).acceptCandidate(candidateWithDistance(0.0), current));
    }

    @Test
    public void aCandidateWorseByLessThanTheThresholdIsAccepted() throws Exception {
        Assertions.assertTrue(withThreshold(1.0).acceptCandidate(candidateWithDistance(0.5), current));
    }

    @Test
    public void aCandidateWorseByTheThresholdIsRejected() throws Exception {
        Assertions.assertFalse(withThreshold(1.0).acceptCandidate(candidateWithDistance(1.0), current));
    }
}
