package de.evoal.core.api.utils;

import de.evoal.core.api.utils.EvoalException;

public class InitializationException extends EvoalException {
    public InitializationException(final String message) {
        super(message);
    }

    public InitializationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
