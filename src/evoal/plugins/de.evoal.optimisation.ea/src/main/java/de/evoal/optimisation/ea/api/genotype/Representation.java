package de.evoal.optimisation.ea.api.genotype;

/**
 * The representations of the genes of a chromosome (DL enumeration {@code representation}).
 */
public enum Representation {
    /**
     * One real gene per real feature ({@link RealGenes}).
     */
    DOUBLE("double"),

    /**
     * One integer gene per integer feature ({@link IntegerGenes}).
     */
    INTEGER("integer"),

    /**
     * Bits in standard binary code ({@link BitGenes}).
     */
    BIT("bit"),

    /**
     * Bits; real and integer features in Gray code ({@link BitGenes}).
     */
    GRAY("gray"),

    /**
     * One model per structured feature ({@link ModelGenes}).
     */
    MODEL("model");

    /**
     * The name of the literal in the DL.
     */
    private final String literal;

    Representation(final String literal) {
        this.literal = literal;
    }

    /**
     * @param literal The name of a literal of the DL enumeration {@code representation}.
     * @return The representation.
     * @throws IllegalArgumentException if the literal is unknown.
     */
    public static Representation of(final String literal) {
        for(final Representation representation : values()) {
            if(representation.literal.equals(literal)) {
                return representation;
            }
        }

        throw new IllegalArgumentException("Unknown representation '" + literal + "'.");
    }

    @Override
    public String toString() {
        return literal;
    }
}
