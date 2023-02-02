package de.evoal.core.api.properties.stream;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesIOFactory;
import de.evoal.core.api.properties.io.PropertiesReader;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Collections;

/**
 * A simple {@see PropertiesFactory} that works on JSON-stored list of {@see Properties}.
 */
@Slf4j
public class FileBasedPropertiesStreamSupplier extends PropertiesBasedPropertiesStreamSupplier {

    /**
     * Creates a new {@see PropertiesFactory} based on the given filename.
     *
     * @param filename The file to read.
     */
    public FileBasedPropertiesStreamSupplier(final File filename, final PropertiesSpecification specification) {
        super(Collections.emptyList());
        log.info("Creating properties stream for {}.", filename);

        try(final PropertiesReader reader = PropertiesIOFactory.reader(filename, specification)) {
            while(reader.hasNext()) {
                properties.add(reader.next());
            }
        } catch (final Exception e) {
            log.error("Failed to read properties from {}.", filename, e);
        }

        log.info("Successfully fetched {} properties from  {}.", properties.size(), filename);
    }
}
