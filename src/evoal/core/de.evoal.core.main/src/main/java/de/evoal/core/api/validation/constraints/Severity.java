package de.evoal.core.api.validation.constraints;

import org.eclipse.emf.common.util.Enumerator;

/**
 * How serious the violation of a constraint annotation is (DL enumeration {@code Severity} of
 *   {@code de.evoal.core.constraints}, attribute {@code severity} of every constraint).
 */
public enum Severity {
    /**
     * The value cannot work, e.g. a parameter the library rejects: a configuration with such
     *   a value does not start.
     */
    ERROR("error"),

    /**
     * The value works but is likely a mistake: the violation is reported and the run
     *   continues.
     */
    WARNING("warning");

    /**
     * The name of the literal in the DL.
     */
    private final String literal;

    Severity(final String literal) {
        this.literal = literal;
    }

    /**
     * @param value The value of the attribute {@code severity}: a literal of the DL enumeration
     *   ({@link Enumerator}, e.g. an {@code EEnumLiteral}) or its name.
     * @return The corresponding severity.
     * @throws IllegalArgumentException if the value is no literal of the enumeration.
     */
    public static Severity of(final Object value) {
        final String name = value instanceof Enumerator literal ? literal.getName() : String.valueOf(value);

        for(final Severity severity : values()) {
            if(severity.literal.equals(name)) {
                return severity;
            }
        }

        throw new IllegalArgumentException("Unknown severity '" + name + "'.");
    }

    /**
     * @return The name of the literal in the DL.
     */
    @Override
    public String toString() {
        return literal;
    }
}
