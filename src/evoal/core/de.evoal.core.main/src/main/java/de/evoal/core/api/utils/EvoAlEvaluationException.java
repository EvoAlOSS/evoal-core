package de.evoal.core.api.utils;

/**
 * An evaluation exception during the evaluation of code.
 */
public class EvoAlEvaluationException extends EvoalException {
    /**
     * Wrapper of the super constructor to pass the given parameters.
     *
     * @param message The message of the exception
     */
    public EvoAlEvaluationException(final String message) {
        super(message);
    }

    /**
     * Wrapper of the super constructor to pass the given parameters.
     *
     * @param message The message of the exception
     * @param cause The reason for this exception
     */
    public EvoAlEvaluationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
