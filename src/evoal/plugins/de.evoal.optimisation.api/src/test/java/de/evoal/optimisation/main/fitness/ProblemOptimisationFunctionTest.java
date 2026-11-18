package de.evoal.optimisation.main.fitness;

import java.lang.reflect.Field;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

public class ProblemOptimisationFunctionTest {
    @ParameterizedTest
    @ValueSource(booleans = { true, false })
    public void forwardsTheThreadSafetyOfItsDelegate(final boolean threadSafe) throws Exception {
        // given
        final OptimisationFunction delegate = Mockito.mock(OptimisationFunction.class);
        Mockito.when(delegate.isThreadSafe()).thenReturn(threadSafe);

        final ProblemOptimisationFunction function = new ProblemOptimisationFunction();
        final Field delegateField = ProblemOptimisationFunction.class.getDeclaredField("delegate");
        delegateField.setAccessible(true);
        delegateField.set(function, delegate);

        // when, then
        Assertions.assertEquals(threadSafe, function.isThreadSafe());
    }
}
