package de.evoal.pipeline.impl.components.io;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.provenance.RunRecord;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineSink;
import de.evoal.pipeline.api.values.PipelineValues;

/**
 * Writes a named {@link PipelineValues pipeline value}, a list of maps, as a CSV file when the
 *   stream has ended (DL type {@code 'csv-writer'}): one row per map, one column per key in the
 *   key order of the first map, the keys as column names. Values are strings, numbers,
 *   booleans or missing (an empty cell). An empty list writes an empty file.
 */
@Dependent
@Named("de.evoal.pipeline.io.csv-writer")
@Slf4j
public class CsvValueWriter extends PipelineComponentImpl implements PipelineSink {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The name of the value to write.
     */
    private String name;

    /**
     * The file to write.
     */
    private File output;

    /**
     * Creates a writer that is configured by {@link #init(EObject)}.
     */
    public CsvValueWriter() {
    }

    /**
     * Creates a writer without a DL configuration, e.g., for tests.
     *
     * @param name The name of the value to write.
     * @param output The file to write.
     */
    CsvValueWriter(final String name, final File output) {
        this.name = name;
        this.output = output;
    }

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        return object;
    }

    /**
     * @throws InitializationException if the step reads or writes data.
     */
    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        if(!isEmpty(getReads()) || !isEmpty(getWrites())) {
            throw new InitializationException("'csv-writer' reads and writes no data; remove its 'reads' and 'writes'.");
        }

        name = evaluator.attributeToString(configuration, "name");
        output = new File(evaluator.attributeToString(configuration, "filename"));

        return this;
    }

    /**
     * @throws IllegalStateException if the value is no list of maps with the same keys and
     *   plain values, or the file cannot be written.
     */
    @Override
    public void streamEnded() {
        final List<Map<?, ?>> rows = rowsOf(PipelineValues.of(getContext()).get(name));

        try {
            final File parent = output.getAbsoluteFile().getParentFile();
            if(parent != null) {
                Files.createDirectories(parent.toPath());
            }

            RunRecord.current().output(output.toPath());
            try(Writer writer = Files.newBufferedWriter(output.toPath(), StandardCharsets.UTF_8)) {
                if(rows.isEmpty()) {
                    log.warn("The pipeline value '{}' is empty; '{}' stays empty.", name, output);
                    return;
                }

                final List<String> columns = rows.getFirst()
                                                 .keySet()
                                                 .stream()
                                                 .map(String::valueOf)
                                                 .toList();
                final CSVFormat format = CSVFormat.DEFAULT.builder()
                                                          .setHeader(columns.toArray(String[]::new))
                                                          .setRecordSeparator("\n")
                                                          .get();

                try(CSVPrinter printer = new CSVPrinter(writer, format)) {
                    for(final Map<?, ?> row : rows) {
                        final List<Object> record = new ArrayList<>();
                        for(final String column : columns) {
                            record.add(row.get(column));
                        }
                        printer.printRecord(record);
                    }
                }
            }
        } catch(final IOException e) {
            throw new IllegalStateException("Cannot write the pipeline value '" + name + "' to '" + output + "'.", e);
        }

        log.info("Wrote {} rows of the pipeline value '{}' to '{}'.", rows.size(), name, output.getAbsolutePath());
    }

    private List<Map<?, ?>> rowsOf(final Object value) {
        if(!(value instanceof List<?> list)) {
            throw new IllegalStateException("The pipeline value '" + name + "' is no list of rows.");
        }

        final List<Map<?, ?>> rows = new ArrayList<>();
        for(final Object element : list) {
            if(!(element instanceof Map<?, ?> row)) {
                throw new IllegalStateException("The pipeline value '" + name + "' is no list of maps.");
            }
            if(!rows.isEmpty() && !rows.getFirst().keySet().equals(row.keySet())) {
                throw new IllegalStateException("The rows of the pipeline value '" + name + "' have different keys: "
                                                + rows.getFirst().keySet() + " and " + row.keySet() + ".");
            }
            for(final Object cell : row.values()) {
                if(cell != null && !(cell instanceof String || cell instanceof Number || cell instanceof Boolean)) {
                    throw new IllegalStateException("The pipeline value '" + name + "' has a nested value, which a "
                                                    + "CSV file cannot hold: " + cell + ".");
                }
            }
            rows.add(row);
        }

        return rows;
    }

    private static boolean isEmpty(final Space space) {
        return space == null || space.isEmpty();
    }
}
