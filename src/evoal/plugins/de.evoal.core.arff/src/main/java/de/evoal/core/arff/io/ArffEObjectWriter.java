package de.evoal.core.arff.io;

import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.Utils;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Writes the features of the space to an ARFF file, one row per object. The relation is named
 *   after the file. A real or integer feature becomes a numeric attribute, a boolean feature a
 *   nominal attribute with the values {@code false} and {@code true}, a string feature a string
 *   attribute; a feature without a value (unset) is written as the missing value {@code ?}.
 *   Weka stores a missing value as NaN, so a real NaN is written as {@code ?}, too, and is
 *   missing when the file is read.
 * <p>
 * Weka writes the header and quotes the names and strings. The rows are written here, since
 *   Weka's {@code ArffSaver} needs libraries that the release does not ship, and so that real
 *   values keep all their digits.
 */
@Slf4j
@Dependent
@Named("arff-eObject-writer")
public class ArffEObjectWriter implements EObjectWriter {
    /**
     * The file extension that the relation name leaves out.
     */
    private static final String EXTENSION = ".arff";

    /**
     * The line separator of Weka's header, also used for the rows.
     */
    private static final String LINE_SEPARATOR = "\n";

    private Writer writer;

    private List<EStructuralFeature> features;

    @Override
    public EObjectWriter init(final File outputFile, final Space specification) throws EvoalIOException {
        log.info("Creating ARFF writer for {} to file {}.", specification, outputFile);

        features = List.copyOf(specification);

        final ArrayList<Attribute> attributes = new ArrayList<>();
        for(final EStructuralFeature feature : features) {
            attributes.add(attributeOf(feature));
        }

        try {
            writer = Files.newBufferedWriter(outputFile.toPath(), StandardCharsets.UTF_8);
            writer.write(new Instances(relationOf(outputFile), attributes, 0).toString());
        } catch(final IOException e) {
            throw new EvoalIOException("Failed to open ARFF file " + outputFile + " for writing.", e);
        }

        return this;
    }

    private static String relationOf(final File file) {
        final String name = file.getName();

        return name.endsWith(EXTENSION) ? name.substring(0, name.length() - EXTENSION.length()) : name;
    }

    private static Attribute attributeOf(final EStructuralFeature feature) throws EvoalIOException {
        final EClassifier type = feature.getEType();

        if(EClassifierHelper.isNumeric(type)) {
            return new Attribute(feature.getName());
        } else if(EClassifierHelper.isBoolean(type)) {
            return new Attribute(feature.getName(), List.of(Boolean.FALSE.toString(), Boolean.TRUE.toString()));
        } else if(EClassifierHelper.isString(type)) {
            return new Attribute(feature.getName(), (List<String>) null);
        }

        throw new EvoalIOException("Cannot write the feature '" + feature.getName() + "' of type "
                                   + type.getName() + " to an ARFF file.");
    }

    @Override
    public void add(final TypedEObject object) throws EvoalIOException {
        final StringJoiner row = new StringJoiner(",");

        for(final EStructuralFeature feature : features) {
            final Object value = object.eIsSet(feature) ? object.eGet(feature) : null;

            if(value == null || (value instanceof Double d && d.isNaN()) || (value instanceof Float f && f.isNaN())) {
                row.add("?");
            } else if(EClassifierHelper.isString(feature.getEType())) {
                row.add(Utils.quote(value.toString()));
            } else {
                // numbers in Java's notation keep all digits; Weka reads them, also Infinity
                row.add(value.toString());
            }
        }

        try {
            writer.write(row.toString());
            writer.write(LINE_SEPARATOR);
        } catch(final IOException e) {
            throw new EvoalIOException("Failed to write a row to an ARFF file.", e);
        }
    }

    @Override
    public void close() throws Exception {
        if(writer != null) {
            writer.close();
        }
    }
}
