package de.evoal.surrogate.smile.svr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The warning of {@link SVRLerner} about an ε-tube that contains the whole standardised
 *   training output.
 */
public class SVRLernerTest {
    /**
     * Standardised output with range [−1.5, 1.5], so half the range is 1.5.
     */
    private static final double[] OUTPUT = {-1.5, -0.5, 0.5, 1.5};

    @Test
    public void anEpsilonBelowHalfTheRangeGivesNoWarning() {
        Assertions.assertTrue(SVRLerner.constantModelWarning(1.4, OUTPUT, "y").isEmpty());
    }

    @Test
    public void anEpsilonOfAtLeastHalfTheRangeGivesAWarning() {
        Assertions.assertTrue(SVRLerner.constantModelWarning(1.5, OUTPUT, "y").isPresent());

        final String warning = SVRLerner.constantModelWarning(2.0, OUTPUT, "y").orElseThrow();
        Assertions.assertTrue(warning.contains("'y'"), warning);
        Assertions.assertTrue(warning.contains("[-1.500, 1.500]"), warning);
        Assertions.assertTrue(warning.contains("constant"), warning);
    }

    @Test
    public void noOutputGivesNoWarning() {
        Assertions.assertTrue(SVRLerner.constantModelWarning(1.0, new double[0], "y").isEmpty());
    }
}
