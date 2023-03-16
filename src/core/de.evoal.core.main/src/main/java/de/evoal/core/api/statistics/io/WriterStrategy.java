package de.evoal.core.api.statistics.io;

import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.WriterContext;

import javax.inject.Inject;
import java.util.List;

/**
 * Base class for writer strategies (different serializing backends). A strategy
 * can decide to reuse files, to store them in different formats, and so on.
 */
public abstract class WriterStrategy {
    /**
     * Context of the writer.
     */
    @Inject
    protected WriterContext context;

    /**
     * Creates a writer for the given name and the given header.
     *
     * @param name Name of the output.
     * @param header Header of the output.
     * @return A non-null writer.
     *
     * @throws WriterException If there is some problem with creating the writer.
     */
    public abstract Writer create(final String name, final List<Column> header) throws WriterException;

    /**
     * Closes the writer.
     *
     * @param writer The writer to close.
     * @throws WriterException when there is an error during closing.
     */
    public abstract void close(Writer writer) throws WriterException;
}
