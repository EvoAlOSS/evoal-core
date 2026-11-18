package de.evoal.surrogate.adaption.interval.fitness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The interval formula is kept from the former decorator until #288 is decided.
 */
public class PredictionIntervalStepTest {
    @Test
    public void theFormulaDividesTwiceTheSquareByTheWidth() {
        // 2 * 3^2 / (5 - 1)
        Assertions.assertEquals(4.5, PredictionIntervalStep.adapt(3.0, 1.0, 5.0));
    }

    @Test
    public void theSignOfTheValueIsLost() {
        Assertions.assertEquals(PredictionIntervalStep.adapt(3.0, 1.0, 5.0), PredictionIntervalStep.adapt(-3.0, 1.0, 5.0));
    }
}
