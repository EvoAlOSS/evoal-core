package de.evoal.optimisation.ea.api.genotype;

/**
 * Brings a gene value back into the boundaries of its feature after a recombination or a
 *   mutation (DL enumeration {@code 'boundary-handling'}). The boundaries are inclusive.
 *   Unlike the boundary handling of particle swarm optimisation, a value can be any distance
 *   outside the range, so reflections and wraps are repeated as often as needed.
 */
public enum BoundaryHandling {
    /**
     * The value enters the range from the other side (periodic boundaries).
     */
    WRAP("wrap"),

    /**
     * The value is reflected at the boundaries.
     */
    BOUNCE("bounce"),

    /**
     * The value is set to the nearest boundary.
     */
    STICK("stick");

    /**
     * The name of the literal in the DL.
     */
    private final String literal;

    BoundaryHandling(final String literal) {
        this.literal = literal;
    }

    /**
     * @param literal The name of a literal of the DL enumeration {@code 'boundary-handling'}.
     * @return The boundary handling.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static BoundaryHandling of(final String literal) {
        for(final BoundaryHandling handling : values()) {
            if(handling.literal.equals(literal)) {
                return handling;
            }
        }

        throw new IllegalArgumentException("Unknown boundary handling '" + literal + "'.");
    }

    /**
     * @param value A real value.
     * @param lower The lower boundary.
     * @param upper The upper boundary, not smaller than the lower one.
     * @return The value within the boundaries; a value within them is returned unchanged.
     */
    public double apply(final double value, final double lower, final double upper) {
        if(value >= lower && value <= upper) {
            return value;
        }

        final double range = upper - lower;
        if(range == 0.0 || !Double.isFinite(value)) {
            return value < lower ? lower : upper;
        }

        final double result = switch(this) {
            case STICK -> value < lower ? lower : upper;
            case WRAP -> lower + floorMod(value - lower, range);
            case BOUNCE -> {
                final double position = floorMod(value - lower, 2.0 * range);
                yield position <= range ? lower + position : upper - (position - range);
            }
        };

        // rounding may leave the result an ulp outside
        return Math.min(upper, Math.max(lower, result));
    }

    /**
     * @param value An integer value.
     * @param lower The lower boundary.
     * @param upper The upper boundary, not smaller than the lower one.
     * @return The value within the boundaries; a value within them is returned unchanged.
     */
    public long apply(final long value, final long lower, final long upper) {
        if(value >= lower && value <= upper) {
            return value;
        }

        final long span = upper - lower;
        if(span == 0) {
            return lower;
        }

        return switch(this) {
            case STICK -> value < lower ? lower : upper;
            case WRAP -> lower + Math.floorMod(value - lower, span + 1);
            case BOUNCE -> {
                final long position = Math.floorMod(value - lower, 2 * span);
                yield position <= span ? lower + position : upper - (position - span);
            }
        };
    }

    private static double floorMod(final double value, final double modulus) {
        final double result = value % modulus;

        return result < 0.0 ? result + modulus : result;
    }

    @Override
    public String toString() {
        return literal;
    }
}
