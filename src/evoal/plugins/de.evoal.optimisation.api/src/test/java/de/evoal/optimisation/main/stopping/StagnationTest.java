package de.evoal.optimisation.main.stopping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StagnationTest {
    @Test
    public void theFirstFiniteValueSetsTheReference() {
        // given
        final Stagnation stagnation = new Stagnation(0.0, 0.0);

        // when
        final boolean improvement = stagnation.update(5.0);

        // then
        Assertions.assertTrue(improvement);
        Assertions.assertEquals(5.0, stagnation.reference());
        Assertions.assertEquals(0, stagnation.iterationsWithoutImprovement());
    }

    @Test
    public void withoutToleranceEveryDecreaseImprovesAndEqualValuesDoNot() {
        // given
        final Stagnation stagnation = new Stagnation(0.0, 0.0);
        stagnation.update(5.0);

        // when / then
        Assertions.assertTrue(stagnation.update(4.999));
        Assertions.assertFalse(stagnation.update(4.999));
        Assertions.assertFalse(stagnation.update(6.0));
        Assertions.assertEquals(2, stagnation.iterationsWithoutImprovement());
    }

    @Nested
    @DisplayName("given an absolute tolerance of 0.1")
    class AbsoluteTolerance {
        private final Stagnation stagnation = new Stagnation(0.1, 0.0);

        @Test
        public void anImprovementWithinTheToleranceDoesNotCount() {
            // given
            stagnation.update(1.0);

            // when
            final boolean improvement = stagnation.update(0.95);

            // then
            Assertions.assertFalse(improvement);
            Assertions.assertEquals(1.0, stagnation.reference());
            Assertions.assertEquals(1, stagnation.iterationsWithoutImprovement());
        }

        @Test
        public void anImprovementBeyondTheToleranceResetsTheCount() {
            // given
            stagnation.update(1.0);
            stagnation.update(0.95);

            // when
            final boolean improvement = stagnation.update(0.85);

            // then
            Assertions.assertTrue(improvement);
            Assertions.assertEquals(0.85, stagnation.reference());
            Assertions.assertEquals(0, stagnation.iterationsWithoutImprovement());
        }

        @Test
        public void smallImprovementsAddUpAgainstTheReference() {
            // given
            stagnation.update(1.0);

            // when / then: 0.04 per iteration, the third step is 0.12 below the reference
            Assertions.assertFalse(stagnation.update(0.96));
            Assertions.assertFalse(stagnation.update(0.92));
            Assertions.assertTrue(stagnation.update(0.88));
            Assertions.assertEquals(0, stagnation.iterationsWithoutImprovement());
        }
    }

    @Nested
    @DisplayName("given a relative tolerance of 10 %")
    class RelativeTolerance {
        private final Stagnation stagnation = new Stagnation(0.0, 0.1);

        @Test
        public void theToleranceScalesWithTheReference() {
            // given
            stagnation.update(100.0);

            // when / then: the tolerance is 10
            Assertions.assertFalse(stagnation.update(91.0));
            Assertions.assertTrue(stagnation.update(89.0));
            Assertions.assertEquals(8.9, stagnation.tolerance(), 1e-12);
        }

        @Test
        public void aNegativeReferenceUsesItsMagnitude() {
            // given
            stagnation.update(-100.0);

            // when / then: the tolerance is 10, an improvement is below -110
            Assertions.assertEquals(10.0, stagnation.tolerance(), 1e-12);
            Assertions.assertFalse(stagnation.update(-109.0));
            Assertions.assertTrue(stagnation.update(-111.0));
        }
    }

    @Test
    public void theLargerToleranceCounts() {
        // given: absolute 0.5, relative 10 % of 2 = 0.2
        final Stagnation stagnation = new Stagnation(0.5, 0.1);
        stagnation.update(2.0);

        // when / then
        Assertions.assertEquals(0.5, stagnation.tolerance(), 1e-12);
        Assertions.assertFalse(stagnation.update(1.6));
        Assertions.assertTrue(stagnation.update(1.4));
    }

    @Test
    public void nonFiniteValuesNeverImprove() {
        // given
        final Stagnation stagnation = new Stagnation(0.0, 0.0);

        // when / then
        Assertions.assertFalse(stagnation.update(Double.NaN));
        Assertions.assertFalse(stagnation.update(Double.NEGATIVE_INFINITY));
        Assertions.assertTrue(Double.isNaN(stagnation.reference()));
        Assertions.assertTrue(stagnation.update(3.0));
        Assertions.assertFalse(stagnation.update(Double.NaN));
        Assertions.assertEquals(3.0, stagnation.reference());
    }

    @Test
    public void resetForgetsReferenceAndCount() {
        // given
        final Stagnation stagnation = new Stagnation(0.0, 0.0);
        stagnation.update(1.0);
        stagnation.update(2.0);

        // when
        stagnation.reset();

        // then
        Assertions.assertTrue(Double.isNaN(stagnation.reference()));
        Assertions.assertEquals(0, stagnation.iterationsWithoutImprovement());
        Assertions.assertTrue(stagnation.update(7.0));
    }

    @Test
    public void negativeOrNonFiniteTolerancesAreRejected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Stagnation(-0.1, 0.0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Stagnation(0.0, -0.1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Stagnation(Double.NaN, 0.0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Stagnation(0.0, Double.POSITIVE_INFINITY));
    }
}
