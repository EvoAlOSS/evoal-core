package de.evoal.core.api.utils;

/**
 * An IO-related exception.
 */
public class EvoalIOException extends EvoalException {
    /**
     * Wrapper of the super constructor to pass the given parameters.
     *
     * @param message The message of the exception
     */
    public EvoalIOException(final String message) {
        super(message);
    }

    /**
     * Wrapper of the super constructor to pass the given parameters.
     *
     * @param message The message of the exception
     * @param cause The reason for this exception
     */
    public EvoalIOException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
