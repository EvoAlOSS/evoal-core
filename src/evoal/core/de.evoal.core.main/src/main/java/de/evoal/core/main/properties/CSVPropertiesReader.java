package de.evoal.core.main.properties;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.io.PropertiesReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.BaseDataDescription;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Dependent
@Named("csv-reader")
public class CSVPropertiesReader implements PropertiesReader {
    private PropertiesSpecification specification;

    private CSVParser parser;
    private Iterator<CSVRecord> iterator;

    private final NumberFormat nf = NumberFormat.getInstance(Locale.US);

    @Override
    public PropertiesReader init(final File inputFile, final PropertiesSpecification specification) throws EvoalIOException {
        log.info("Creating CSV properties reader for {}.", specification);
        this.specification = specification;

        try {
            parser = CSVParser.parse(inputFile, StandardCharsets.UTF_8, CSVFormat.RFC4180.withHeader());
            iterator = parser.iterator();
        } catch (IOException e) {
            throw new EvoalIOException("Failed to parse CSV file " + inputFile, e);
        }

        // sanity check
        final List<String> names = parser.getHeaderNames();
        log.info("Found the properties {} in the input file", names);

        specification.getProperties()
                     .stream()
                     .map(PropertySpecification::name)
                     .forEach(name -> Requirements.requireTrue(names.contains(name), "Attribute of name '" + name + "' hash(" + name.hashCode() + ") could not be found in " + names.stream().map(n -> "'" + n + "' hash(" + n.hashCode()  + ")").collect(Collectors.joining(", "))));

        return this;
    }

    @Override
    public void close() throws Exception {
        parser.close();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    @SneakyThrows({ParseException.class})
    public Properties next() {
        return readProperties();
    }

    private Properties readProperties() throws ParseException {
        final CSVRecord record = iterator.next();
        final Properties p = new Properties(specification);

        log.info("Read properties");

        for(final PropertySpecification s : specification.getProperties()) {
            final String strValue = record.get(s.name());
            Requirements.requireInstanceOf(s.type(), BaseDataDescription.class);

            final Object value = switch (((BaseDataDescription)s.type()).getRepresentation()) {
                case BOOLEAN -> Boolean.parseBoolean(strValue);
                case INTEGER -> "Infinity".equals(strValue) ? Integer.MAX_VALUE : nf.parse(strValue);
                case REAL -> "Infinity".equals(strValue) ? Double.POSITIVE_INFINITY : nf.parse(strValue).doubleValue();
                case STRING -> strValue;
            };

            p.put(s, value);
        }

        return p;
    }
}
