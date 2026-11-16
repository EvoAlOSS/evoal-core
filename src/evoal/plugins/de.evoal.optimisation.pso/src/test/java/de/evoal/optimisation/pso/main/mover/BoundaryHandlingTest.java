package de.evoal.optimisation.pso.main.mover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.optimisation.pso.api.BoundaryType;

/**
 * The variable has the boundaries [0, 10]; the particle moved by the velocity to the position.
 */
public class BoundaryHandlingTest {
    private static BoundaryHandling.Moved move(final BoundaryType type, final double position, final double velocity) {
        return BoundaryHandling.apply(type, position, velocity, 0.0, 10.0);
    }

    @Test
    public void aPositionWithinTheBoundariesIsKept() {
        for(final BoundaryType type : BoundaryType.values()) {
            Assertions.assertEquals(new BoundaryHandling.Moved(5.0, 3.0), move(type, 5.0, 3.0));
        }
    }

    @Test
    public void bounceReflectsThePositionAndNegatesTheVelocity() {
        Assertions.assertEquals(new BoundaryHandling.Moved(8.0, -3.0), move(BoundaryType.BOUNCE, 12.0, 3.0));
        Assertions.assertEquals(new BoundaryHandling.Moved(2.0, 3.0), move(BoundaryType.BOUNCE, -2.0, -3.0));
    }

    @Test
    public void stickSetsThePositionToTheBoundaryAndStopsTheParticle() {
        Assertions.assertEquals(new BoundaryHandling.Moved(10.0, 0.0), move(BoundaryType.STICK, 12.0, 3.0));
        Assertions.assertEquals(new BoundaryHandling.Moved(0.0, 0.0), move(BoundaryType.STICK, -2.0, -3.0));
    }

    @Test
    public void wrapEntersFromTheOtherSideWithTheSameVelocity() {
        Assertions.assertEquals(new BoundaryHandling.Moved(2.0, 3.0), move(BoundaryType.WRAP, 12.0, 3.0));
        Assertions.assertEquals(new BoundaryHandling.Moved(8.0, -3.0), move(BoundaryType.WRAP, -2.0, -3.0));
    }
}
