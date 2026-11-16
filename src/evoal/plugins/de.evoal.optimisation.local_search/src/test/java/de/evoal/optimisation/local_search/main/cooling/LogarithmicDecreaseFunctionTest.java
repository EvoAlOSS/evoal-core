package de.evoal.optimisation.local_search.main.cooling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogarithmicDecreaseFunctionTest {
    private final LogarithmicDecreaseFunction function = new LogarithmicDecreaseFunction();

    @Test
    public void theValueStartsAtTheInitialValue() {
        Assertions.assertEquals(5.0, function.decrease(5.0, 5.0, 0), 1e-12);
    }

    @Test
    public void theValueFallsFromTheFirstIterationOn() {
        double previous = 5.0;
        for(int iteration = 1; iteration <= 100; ++iteration) {
            final double value = function.decrease(previous, 5.0, iteration);

            Assertions.assertTrue(value < previous, "iteration " + iteration + ": " + value + " >= " + previous);
            previous = value;
        }
    }
}
