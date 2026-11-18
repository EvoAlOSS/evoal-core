package de.evoal.optimisation.main.fitness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RelativeDistanceTest {
    @Nested
    @DisplayName("given a relative distance with scale 1")
    class UnitScale {
        private final RelativeDistance distance = new RelativeDistance(1.0);

        @Test
        public void aLargeTargetGivesTheRelativeDeviation() {
            Assertions.assertEquals(0.1, distance.distance(11.0, 10.0), 1e-12);
            Assertions.assertEquals(0.1, distance.distance(-11.0, -10.0), 1e-12);
        }

        @Test
        public void aTargetOfZeroGivesTheAbsoluteDeviation() {
            Assertions.assertEquals(2.5, distance.distance(-2.5, 0.0));
            Assertions.assertEquals(2.5, distance.distance(2.5, 0.0));
        }

        @Test
        public void aSmallTargetIsMeasuredInUnitsOfTheScale() {
            Assertions.assertEquals(0.75, distance.distance(1.0, 0.25));
        }

        @Test
        public void theDistanceIsZeroExactlyAtTheTarget() {
            Assertions.assertEquals(0.0, distance.distance(0.0, 0.0));
            Assertions.assertEquals(0.0, distance.distance(-3.0, -3.0));
            Assertions.assertTrue(distance.distance(3.0 + 1e-9, 3.0) > 0.0);
        }
    }

    @Nested
    @DisplayName("given a scale that is not greater than 0")
    class InvalidScale {
        @Test
        public void aScaleOfZeroIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new RelativeDistance(0.0));
        }

        @Test
        public void aNegativeScaleIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new RelativeDistance(-1.0));
        }

        @Test
        public void anUndefinedScaleIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new RelativeDistance(Double.NaN));
        }
    }
}
