package de.evoal.core.api.utils;

/**
 * Base class for all EvoAl exceptions.
 */
public class EvoalException extends Exception {
    public EvoalException(final String message) {
        super(message);
    }

    public EvoalException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
