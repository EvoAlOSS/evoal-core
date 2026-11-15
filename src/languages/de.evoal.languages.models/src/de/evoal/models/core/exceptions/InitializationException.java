package de.evoal.models.core.exceptions;

public class InitializationException extends EvoalException {
    private static final long serialVersionUID = -592457624969893566L;

	public InitializationException(final String message) {
        super(message);
    }

    public InitializationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
