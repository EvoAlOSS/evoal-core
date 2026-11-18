package de.evoal.surrogate.adaption.density.fitness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The density formula is kept from the former decorator until #288 is decided.
 */
public class DensityStepTest {
    @Test
    public void aProbabilityOfOneKeepsThePrediction() {
        Assertions.assertEquals(4.0, DensityStep.adapt(4.0, 1.0, 1.0, 1.0));
    }

    @Test
    public void theFormulaWeightsThePredictionAndAddsThePenalty() {
        // 4 * 0.5^2 + (1 - 0.5) / 0.5^1
        Assertions.assertEquals(1.0 + 1.0, DensityStep.adapt(4.0, 0.5, 2.0, 1.0), 1e-12);
    }
}
