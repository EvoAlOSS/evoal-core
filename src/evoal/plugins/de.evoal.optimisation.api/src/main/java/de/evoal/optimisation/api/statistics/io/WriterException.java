package de.evoal.optimisation.api.statistics.io;

/**
 * Exception for signaling errors while writing.
 */
public class WriterException extends Exception {
    public WriterException(final String msg, final Throwable e) {
        super(msg, e);
    }
}
