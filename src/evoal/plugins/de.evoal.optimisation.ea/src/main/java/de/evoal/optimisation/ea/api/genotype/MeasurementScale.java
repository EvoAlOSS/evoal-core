package de.evoal.optimisation.ea.api.genotype;

/**
 * The scales of measurement of the DDL, from the weakest to the strongest (DL enumeration
 *   {@code 'measurement-scale'}).
 */
public enum MeasurementScale {
    NOMINAL("nominal"),
    ORDINAL("ordinal"),
    CARDINAL("cardinal"),
    QUOTIENT("quotient");

    /**
     * The name of the literal in the DL and the DDL.
     */
    private final String literal;

    MeasurementScale(final String literal) {
        this.literal = literal;
    }

    /**
     * @param literal The name of a scale of the DL or the DDL.
     * @return The scale.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static MeasurementScale of(final String literal) {
        for(final MeasurementScale scale : values()) {
            if(scale.literal.equals(literal)) {
                return scale;
            }
        }

        throw new IllegalArgumentException("Unknown scale of measurement '" + literal + "'.");
    }

    /**
     * @return Whether this scale is at least as strong as the other one.
     */
    public boolean isAtLeast(final MeasurementScale other) {
        return compareTo(other) >= 0;
    }

    @Override
    public String toString() {
        return literal;
    }
}
