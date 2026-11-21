package de.evoal.core.api.random;

import java.util.random.RandomGenerator;

import de.evoal.core.api.math.EvoalMath;

/**
 * Draws standard normally distributed numbers with the Box-Muller transform (Box and Muller
 *   1958). {@link RandomGenerator#nextGaussian()} is not used, since it calls the platform
 *   dependent {@link Math} functions; {@link EvoalMath} gives the same numbers on every
 *   platform.
 */
public final class Gaussian {
    private Gaussian() {
    }

    /**
     * @return A standard normally distributed number; draws two uniform numbers.
     */
    public static double next(final RandomGenerator random) {
        // 1 - u lies in (0, 1], so the logarithm is finite
        final double radius = Math.sqrt(-2.0 * EvoalMath.log(1.0 - random.nextDouble()));
        final double angle = 2.0 * Math.PI * random.nextDouble();

        return radius * EvoalMath.cos(angle);
    }
}
