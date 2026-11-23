package de.evoal.surrogate.knn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The warning of {@link KNNLerner} about a k that exceeds the number of training rows.
 */
public class KNNLernerTest {
    @Test
    public void aKUpToTheNumberOfRowsGivesNoWarning() {
        Assertions.assertTrue(KNNLerner.constantModelWarning(3, 5).isEmpty());
        Assertions.assertTrue(KNNLerner.constantModelWarning(5, 5).isEmpty());
    }

    @Test
    public void aKAboveTheNumberOfRowsGivesAWarning() {
        final String warning = KNNLerner.constantModelWarning(6, 5).orElseThrow();

        Assertions.assertTrue(warning.contains("k = 6"), warning);
        Assertions.assertTrue(warning.contains("(5)"), warning);
        Assertions.assertTrue(warning.contains("constant"), warning);
    }
}
