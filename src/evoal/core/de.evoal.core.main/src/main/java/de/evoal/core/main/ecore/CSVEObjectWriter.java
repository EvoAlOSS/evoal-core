package de.evoal.core.main.ecore;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
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
     * The CSV helper
     */
    private CSVPrinter csvPrinter;

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

    @Override
    public void add(@NonNull TypedEObject object) throws EvoalIOException {
        try {
            recordCounter += 1;

            for(final EStructuralFeature feature : specification) {
                csvPrinter.print(object.eGet(feature));
            }

            csvPrinter.println();
        } catch (IOException e) {
            throw new EvoalIOException("Failed to write recored.", e);
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
            csvPrinter = new CSVPrinter(csvWriter,
                                        CSVFormat.DEFAULT
                                            .withHeader(fileHeader));
        } catch (IOException e) {
            throw new EvoalIOException("Failed to open CSV file " + outputFile + " for writing.", e);
        }

        return this;
    }

    @Override
    public void close() throws Exception {
        log.info("Closing CSV writer of '{}' after writing {} records.", filename, recordCounter);

        csvPrinter.close();
        csvWriter.close();
    }
}
