package de.evoal.core.main.ecore;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.api.utils.EvoalIOException;
import jakarta.inject.Named;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
@Dependent
@Named("csv-eObject-writer")
public class CSVEObjectWriter implements EObjectWriter {
    /**
     * The format of the file: a header line with the names of the features, then one line per
     *   object.
     */
    private static final CSVFormat FORMAT = CSVFormat.DEFAULT;

    /**
     * An empty string, quoted so that it differs from a cell without a value (#356).
     */
    private static final String QUOTED_EMPTY_STRING = "\"\"";

    /**
     * For writing the generated stream to an actual file.
     */
    private FileWriter csvWriter;

    /**
     * The file to write.
     */
    private File filename;

    /**
     * How to format numbers.
     */
    private final NumberFormat nf = NumberFormat.getInstance(Locale.US);

    /**
     * Counter for logging purposes.
     */
    private int recordCounter = 0;

    /**
     * What to write.
     */
    private Space specification;

    /**
     * Writes one line. A feature without a value (unset, e.g. a missing value of an ARFF file)
     *   gives an empty cell, an empty string the quoted cell {@code ""}, so that reading the file
     *   tells them apart (#356). Every other value is quoted only where CSV needs it.
     */
    @Override
    public void add(@NonNull TypedEObject object) throws EvoalIOException {
        try {
            recordCounter += 1;

            boolean first = true;
            for(final EStructuralFeature feature : specification) {
                print(object.eIsSet(feature) ? object.eGet(feature) : null, first);
                first = false;
            }

            csvWriter.append(FORMAT.getRecordSeparator());
        } catch (IOException e) {
            throw new EvoalIOException("Failed to write recored.", e);
        }
    }

    private void print(final Object value, final boolean first) throws IOException {
        if(value == null || "".equals(value)) {
            if(!first) {
                csvWriter.append(FORMAT.getDelimiterString());
            }

            if(value != null) {
                csvWriter.append(QUOTED_EMPTY_STRING);
            }
        } else {
            FORMAT.print(value, csvWriter, first);
        }
    }

    @Override
    public EObjectWriter init(final File outputFile, final Space specification) throws EvoalIOException {
        log.info("Creating CSV EObject writer for {} to file {}.", specification, outputFile);
        filename = outputFile;

        this.specification = specification;

        try {
            final String[] fileHeader = new String[specification.size()];

            int index = 0;
            for(final EStructuralFeature feature : specification) {
                fileHeader[index++] = feature.getName();
            }

            csvWriter = new FileWriter(outputFile);
            FORMAT.printRecord(csvWriter, (Object[]) fileHeader);
        } catch (IOException e) {
            throw new EvoalIOException("Failed to open CSV file " + outputFile + " for writing.", e);
        }

        return this;
    }

    @Override
    public void close() throws Exception {
        log.info("Closing CSV writer of '{}' after writing {} records.", filename, recordCounter);

        csvWriter.close();
    }
}
