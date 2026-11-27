package de.evoal.optimisation.main.statistics.io.csv;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import de.evoal.core.api.cdi.EvaluationScoped;

import de.evoal.optimisation.api.run.CurrentEvaluation;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;

/**
 * Writes every named output into the CSV file {@code <name>.csv} in the output folder of
 *   the evaluation ({@link CurrentEvaluation}). The files stay open for the whole
 *   evaluation, so its runs append to the same files. They are closed when the evaluation
 *   ends.
 */
@EvaluationScoped
@Named("csv")
public class CsvStrategy extends WriterStrategy {
    /**
     * The header each output was created with.
     */
    private final Map<String, List<Column>> headers = new HashMap<>();

    /**
     * Provides the folder the CSV files are written to.
     */
    @Inject
    private CurrentEvaluation evaluation;

    /**
     * The open writers by output name.
     */
    private final Map<String, CsvWriter> writers = new HashMap<>();

    /**
     * Closes all files when the evaluation ends.
     */
    @PreDestroy
    public void closeAll() {
        writers.values()
               .forEach(Writer::close);
        writers.clear();
        headers.clear();
    }

    @Override
    public Writer create(final String name, final List<Column> header) throws WriterException {
        final CsvWriter existingWriter = writers.get(name);
        if(existingWriter != null) {
            requireSameHeader(name, header);
            return existingWriter;
        }

        final File csvFile = new File(evaluation.outputFolder(), name + ".csv");
        final File parentFolder = csvFile.getParentFile();
        parentFolder.mkdirs();

        final CsvWriter writer = new CsvWriter(csvFile, context, header);
        writers.put(name, writer);
        headers.put(name, List.copyOf(header));

        return writer;
    }

    @Override
    public void flush(final Writer writer) {
        writer.flush();
    }

    /**
     * Two writers may only share a file if they write the same columns.
     *   Otherwise rows of different layouts would end up in one file.
     */
    private void requireSameHeader(final String name, final List<Column> header) {
        final List<Column> existingHeader = headers.get(name);
        if(existingHeader.equals(header)) {
            return;
        }

        final String message = "The statistics output '" + name + ".csv' is already used with the columns "
                + existingHeader + " and cannot be reused with the columns " + header + ".";
        throw new IllegalStateException(message);
    }
}
