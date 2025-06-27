package de.evoal.core.api.utils;

import lombok.Getter;

/**
 * Indicates that EvoAl should be terminated with the given error code but without
 *   any additional logging.
 */
public class EvoAlShutDownException extends RuntimeException {
    @Getter
    private final int errorCode;

    public EvoAlShutDownException(final int errorCode) {
        this.errorCode = errorCode;
    }
}
