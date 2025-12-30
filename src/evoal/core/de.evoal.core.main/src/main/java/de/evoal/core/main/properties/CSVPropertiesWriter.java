package de.evoal.core.main.properties;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.api.utils.EvoalIOException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@Slf4j
@Dependent
@Named("csv-writer")
public class CSVPropertiesWriter implements PropertiesWriter {
    private CSVPrinter csvPrinter;

    private FileWriter csvWriter;

    private File filename;

    private final NumberFormat nf = NumberFormat.getInstance(Locale.US);

    private int recordCounter = 0;

    private PropertiesSpecification specification;

    @Override
    public void add(@NonNull Properties properties) throws EvoalIOException {
        try {
            recordCounter += 1;

            csvPrinter.printRecord(properties.getValues());
        } catch (IOException e) {
            throw new EvoalIOException("Failed to write recored.", e);
        }
    }

    @Override
    public PropertiesWriter init(final File outputFile, final PropertiesSpecification specification) throws EvoalIOException {
        log.info("Creating CSV properties writer for {} to file {}.", specification, outputFile);
        filename = outputFile;

        this.specification = specification;

        try {
            final String[] fileHeader = new String[specification.size()];

            for(int i = 0; i < fileHeader.length; ++i) {
                fileHeader[i] = specification.getProperties().get(i).name();
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
