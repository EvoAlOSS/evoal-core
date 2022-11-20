package de.evoal.core.main.ea.chromosomes;

import io.jenetics.util.RandomRegistry;

import java.util.random.RandomGenerator;

public final class BoundedOperations {
    /**
     * Use bounded operations.
     */
    private static boolean useBoundedOperations = true;

    private BoundedOperations() {
    }

    public static void setUseBoundedOperations(final boolean useBoundedOperations) {
        BoundedOperations.useBoundedOperations = useBoundedOperations;
    }

    public static double boundValue(final double value, final double min, final double max) {
        if(useBoundedOperations) {
            return Math.min(max, Math.max(min, value));
        } else {
            return value;
        }
    }

	public static boolean isValid(final double value, final double min, final double max) {
		if(useBoundedOperations) {
			return Double.compare(value, min) >= 0 &&
                   Double.compare(value, max) < 0;

		} else {
			return true;
		}
	}

	public static double random(final double min, final double max) {
        final RandomGenerator random = RandomRegistry.random();
		if(useBoundedOperations) {
			return random.nextDouble(min, max);
		} else {
			return random.nextDouble(-100_000_000 , 100_000_000);
		}
	}
}
