package de.evoal.models.core.exceptions;

/**
 * Base class for all EvoAl exceptions.
 */
public class EvoalException extends Exception {
    private static final long serialVersionUID = 1298700999327528583L;

	public EvoalException(final String message) {
        super(message);
    }

    public EvoalException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
