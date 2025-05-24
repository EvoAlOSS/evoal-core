package de.evoal.core.main.ecore;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.Requirements;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.emf.ecore.*;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Dependent
@Named("csv-eObject-reader")
public class CSVEObjectReader implements EObjectReader {
    private Space specification;

    private CSVParser parser;
    private Iterator<CSVRecord> iterator;

    private final NumberFormat nf = NumberFormat.getInstance(Locale.US);
    private final EcorePackage ePackage = EcorePackage.eINSTANCE;

    @Override
    public EObjectReader init(final File inputFile, final Space specification) throws EvoalIOException {
        log.info("Creating CSV EObject reader for {}.", specification);
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

        specification.stream()
                     .map(EStructuralFeature::getName)
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
    public TypedEObject next() {
        return readEObjects();
    }

    private TypedEObject readEObjects() throws ParseException {
        final CSVRecord record = iterator.next();
        final TypedEObject result = specification.newEObject();

        log.info("Read properties");

        for(final EStructuralFeature s : specification) {
            final String strValue = record.get(s.getName());

            final EClassifier type = s.getEType();
            Object value = strValue;
            if(ePackage.getEBoolean().equals(type)) {
                value = Boolean.parseBoolean(strValue);
            } else if(ePackage.getEInt().equals(type)) {
                value = "Infinity".equals(strValue) ? Integer.MAX_VALUE : nf.parse(strValue);
            } else if(ePackage.getEFloat().equals(type)) {
                value = "Infinity".equals(strValue) ? Float.POSITIVE_INFINITY : nf.parse(strValue).floatValue();
            } else if(ePackage.getEDouble().equals(type)) {
                value = "Infinity".equals(strValue) ? Double.POSITIVE_INFINITY : nf.parse(strValue).doubleValue();
            } else if(ePackage.getEString().equals(type)) {
                // do nothing as the value was already assigned
            }

            result.eSet(s, value);
        }

        return result;
    }
}
