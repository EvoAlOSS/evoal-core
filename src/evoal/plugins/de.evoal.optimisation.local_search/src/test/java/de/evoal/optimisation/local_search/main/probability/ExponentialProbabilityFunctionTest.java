package de.evoal.optimisation.local_search.main.probability;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

public class ExponentialProbabilityFunctionTest {
    private final ExponentialProbabilityFunction testee = new ExponentialProbabilityFunction();

    private static OptimisationValue value(final double fitness, final boolean betterThanOther) {
        final OptimisationValue value = Mockito.mock(OptimisationValue.class);
        Mockito.when(value.toStatistics()).thenReturn(List.of(fitness));
        Mockito.when(value.isBetter(Mockito.any())).thenReturn(betterThanOther);
        return value;
    }

    @Test
    public void betterNeighboursAreAlwaysAccepted() {
        Assertions.assertEquals(1.0, testee.apply(value(10.0, false), value(5.0, true), 1.0));
    }

    @Test
    public void worseNeighboursAreAcceptedWithDecreasingProbability() {
        final OptimisationValue current = value(10.0, false);

        final double slightlyWorse = testee.apply(current, value(11.0, false), 2.0);
        final double muchWorse = testee.apply(current, value(20.0, false), 2.0);

        Assertions.assertEquals(Math.exp(-0.5), slightlyWorse, 1e-12);
        Assertions.assertEquals(Math.exp(-5.0), muchWorse, 1e-12);
        Assertions.assertTrue(muchWorse < slightlyWorse && slightlyWorse < 1.0);
    }

    @Test
    public void lowerTemperaturesReduceTheProbability() {
        final OptimisationValue current = value(10.0, false);
        final OptimisationValue neighbour = value(12.0, false);

        Assertions.assertTrue(testee.apply(current, neighbour, 0.5) < testee.apply(current, neighbour, 5.0));
        Assertions.assertEquals(0.0, testee.apply(current, neighbour, 0.0));
    }
}
