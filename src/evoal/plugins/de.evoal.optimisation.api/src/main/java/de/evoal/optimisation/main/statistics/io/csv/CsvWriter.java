package de.evoal.optimisation.main.statistics.io.csv;

import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class CsvWriter implements Writer {

    private final CSVPrinter csvPrinter;
    private final FileWriter csvWriter;
    private final WriterContext context;

    public CsvWriter(final File filename, final WriterContext context, final List<Column> header) throws WriterException {
        try {
            final String[] fileHeader = new String[context.size() + header.size()];

            int i = 0;
            for(final Column column : context.getColumns()) {
                fileHeader[i++] = column.getName();
            }

            for(final Column column : header) {
                fileHeader[i++] = column.getName();
            }

            csvWriter = new FileWriter(filename);
            csvPrinter = new CSVPrinter(csvWriter,
                    CSVFormat.DEFAULT
                            .withHeader(fileHeader));

            this.context = context;
        } catch(final IOException e) {
            throw new WriterException("Unable to open CSV file: " + filename, e);
        }
    }

    @Override
    public void addRecord(final Object[] data) throws WriterException {
        try {
            for(final Column column : context.getColumns()) {
                csvPrinter.print(context.get(column));
            }

            for(final Object obj : data) {
                csvPrinter.print(obj);
            }

            csvPrinter.println();
        } catch(final IOException e) {
            throw new WriterException("Unable to write CSV file.", e);
        }
    }

    @Override
    public void close() {
        try {
            csvPrinter.close();
            csvWriter.close();
        } catch (final IOException e) {
            log.error("Failed to close CSV file.", e);
        }
    }

    @Override
    public void flush() {
        try {
            csvPrinter.flush();
            csvWriter.flush();
        } catch (final IOException e) {
            log.error("Failed to close CSV file.", e);
        }
    }
}
