package de.evoal.optimisation.ea.main.jenetics;

import io.jenetics.util.RandomRegistry;

public final class BoundedOperations {

    private BoundedOperations() {
    }

    public static double boundValue(final double value, final double min, final double max) {
        return Math.min(max, Math.max(min, value));
    }

    public static int boundValue(final int value, final int min, final int max) {
        return Math.min(max, Math.max(min, value));
    }

	public static boolean isValid(final double value, final double min, final double max) {
        return Double.compare(value, min) >= 0 &&
               Double.compare(value, max) < 0;
	}

	public static double random(final double min, final double max) {
        return RandomRegistry.random()
                             .nextDouble(min, max);
	}

    public static int random(final int min, final int max) {
        return RandomRegistry.random()
                .nextInt(min, max);
    }
}
