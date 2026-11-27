package de.evoal.optimisation.api.statistics.io;

import java.util.List;

import jakarta.inject.Inject;

import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.WriterContext;

/**
 * Base class for the serialisation backends of statistics writers. A strategy
 *   creates the writers for named outputs and owns them: it decides where and in
 *   which format the data is stored, and it closes the writers when the
 *   evaluation ends (it is {@link de.evoal.core.api.cdi.EvaluationScoped}).
 * <p>
 * Writers with the same name share one output. This allows the runs of an
 *   evaluation to append to the same output (distinguished by the columns of
 *   the {@link WriterContext}).
 */
public abstract class WriterStrategy {
    /**
     * Context of the writer.
     */
    @Inject
    protected WriterContext context;

    /**
     * Creates the writer for the given name and the given header, or returns the
     *   existing writer if the name was already used with the same header.
     *
     * @param name Name of the output.
     * @param header Header of the output.
     * @return A non-null writer.
     *
     * @throws WriterException If there is some problem with creating the writer.
     * @throws IllegalStateException If the name was already used with a different header.
     */
    public abstract Writer create(final String name, final List<Column> header) throws WriterException;

    /**
     * Flushes the data of the writer at the end of a run. The writer stays open,
     *   since later runs may append to the same output.
     *
     * @param writer The writer to flush.
     * @throws WriterException when there is an error during flushing.
     */
    public abstract void flush(Writer writer) throws WriterException;
}
