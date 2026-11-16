package de.evoal.optimisation.local_search.main.accepting;

import java.lang.reflect.Field;
import java.util.random.RandomGenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.optimisation.local_search.api.probability.AcceptanceProbabilityFunction;

public class SimulatedAnnealingStrategyTest {
    private final OptimisationValue current = Mockito.mock(OptimisationValue.class);
    private final OptimisationValue candidate = Mockito.mock(OptimisationValue.class);

    private static void inject(final Object target, final String name, final Object value) throws Exception {
        final Field field = SimulatedAnnealingStrategy.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * @return The strategy with the given acceptance probability and a generator that returns 0.0.
     */
    private SimulatedAnnealingStrategy strategy(final double probability) throws Exception {
        final AcceptanceProbabilityFunction function = Mockito.mock(AcceptanceProbabilityFunction.class);
        Mockito.when(function.apply(Mockito.eq(current), Mockito.eq(candidate), Mockito.anyDouble())).thenReturn(probability);

        final RandomGenerator random = Mockito.mock(RandomGenerator.class);
        Mockito.when(random.nextDouble()).thenReturn(0.0);

        final SimulatedAnnealingStrategy strategy = new SimulatedAnnealingStrategy();
        inject(strategy, "probabilityFunction", function);
        inject(strategy, "random", random);

        return strategy;
    }

    @Test
    public void aSingleNeighbourIsTestedPerIteration() {
        Assertions.assertTrue(new SimulatedAnnealingStrategy().testsSingleNeighbour());
    }

    @Test
    public void aProbabilityOfZeroNeverAccepts() throws Exception {
        Assertions.assertFalse(strategy(0.0).acceptCandidate(candidate, current));
    }

    @Test
    public void aPositiveProbabilityAcceptsIfTheRandomNumberIsBelowIt() throws Exception {
        Assertions.assertTrue(strategy(1e-9).acceptCandidate(candidate, current));
    }
}
