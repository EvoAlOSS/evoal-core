package de.evoal.core.arff.io;

import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import jakarta.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import jakarta.inject.Named;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Reads the rows of an ARFF file. Every attribute with the name of a feature of the space sets
 *   this feature; the other attributes are skipped. A missing value ({@code ?}) leaves the
 *   feature unset, i.e. without a value.
 * <p>
 * A numeric attribute sets a real or an integer feature (an integer feature only with whole
 *   numbers), a nominal or string attribute a string feature, and a nominal attribute with the
 *   values {@code false} and {@code true} a boolean feature.
 */
@Slf4j
@Dependent
@Named("arff-eObject-reader")
public class ArffEObjectReader implements EObjectReader {
    /**
     * Sets the feature of one attribute from a row.
     */
    @FunctionalInterface
    private interface Setter {
        void set(Instance row, TypedEObject object);
    }

    private Instances data;

    /**
     * The index of the next row.
     */
    private int nextRow = 0;
    private Space readerSpace;

    /**
     * The setters of the attributes that the space has a feature for.
     */
    private final List<Setter> setters = new ArrayList<>();

    @Override
    public ArffEObjectReader init(final File inputFile, final Space space) throws EvoalIOException {
        log.info("Creating ARFF properties reader for {}.", space);

        try {
            this.readerSpace = space;

            final ConverterUtils.DataSource arffSource = new ConverterUtils.DataSource(inputFile.toString());
            this.data = arffSource.getDataSet();

            createMapping(arffSource.getStructure());
        } catch (final Exception e) {
            log.error("Failed to load arff file '{}'.", inputFile, e);
            throw new EvoalIOException("Failed to load arff file: " + inputFile, e);
        }

        return this;
    }

    private void createMapping(final Instances structure) {
        log.info("Mapping ARFF attributes to properties specification.");

        for(int i = 0; i < structure.numAttributes(); ++i) {
            final Attribute attribute = structure.attribute(i);
            final Optional<EStructuralFeature> feature = readerSpace.find(attribute.name());

            if(feature.isEmpty()) {
                log.info("Skipping attribute '{}'.", attribute.name());
                continue;
            }

            final int index = i;
            final Setter setter = setterFor(index, attribute, feature.get());
            setters.add((row, object) -> {
                if(!row.isMissing(index)) {
                    setter.set(row, object);
                }
            });
        }
    }

    private static Setter setterFor(final int index, final Attribute attribute, final EStructuralFeature feature) {
        final EClassifier type = feature.getEType();

        if(attribute.isNumeric() && EClassifierHelper.isDouble(type)) {
            return (row, object) -> object.eSet(feature, row.value(index));
        } else if(attribute.isNumeric() && EClassifierHelper.isInteger(type)) {
            return (row, object) -> object.eSet(feature, wholeNumber(row.value(index), attribute));
        } else if((attribute.isNominal() || attribute.isString()) && EClassifierHelper.isString(type)) {
            return (row, object) -> object.eSet(feature, row.stringValue(index));
        } else if(attribute.isNominal() && EClassifierHelper.isBoolean(type)) {
            return (row, object) -> object.eSet(feature, truthValue(row.stringValue(index), attribute));
        }

        throw new IllegalArgumentException("Cannot read the " + Attribute.typeToString(attribute)
                                           + " attribute '" + attribute.name() + "' into the feature '"
                                           + feature.getName() + "' of type " + type.getName() + ".");
    }

    private static int wholeNumber(final double value, final Attribute attribute) {
        if(value != Math.rint(value) || value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("The attribute '" + attribute.name() + "' has the value " + value
                                               + ", but its feature is an integer.");
        }

        return (int) value;
    }

    private static boolean truthValue(final String value, final Attribute attribute) {
        return switch(value.toLowerCase(Locale.ROOT)) {
            case "true" -> true;
            case "false" -> false;
            default -> throw new IllegalArgumentException("The attribute '" + attribute.name() + "' has the value '"
                                                          + value + "', but its feature is a boolean (false or true).");
        };
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public boolean hasNext() {
        return nextRow < data.size();
    }

    @Override
    public TypedEObject next() {
        final Instance row = data.get(nextRow++);
        final TypedEObject object = readerSpace.newEObject();
        setters.forEach(setter -> setter.set(row, object));

        return object;
    }
}
