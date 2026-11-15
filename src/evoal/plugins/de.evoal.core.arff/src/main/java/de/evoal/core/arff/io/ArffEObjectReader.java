package de.evoal.core.arff.io;

import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import jakarta.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import jakarta.inject.Named;
import java.io.File;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiFunction;

@Slf4j
@Dependent
@Named("arff-reader")
public class ArffEObjectReader implements EObjectReader {
    private interface TriFunction<S,T,U,R> {
        /**
         * Applies this function to the given arguments.
         *
         * @param s the first function argument
         * @param t the second function argument
         * @param u the third function argument
         * @return the function result
         */
        R apply(S s, T t, U u);
    }

    private Instances data;

    private int index = 0;
    private Space readerSpace;

    private BiFunction<Instance, Space, TypedEObject> toEObject = (instance, space) -> space.newEObject();

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
        final int size = structure.numAttributes();

        for(int i = 0; i < size; ++i) {
            final Attribute attr = structure.attribute(i);
            final Optional<EStructuralFeature> attrFeature = readerSpace.find(attr.name());

            if(attrFeature.isEmpty()) {
                log.info("Skipping attribute '{}'.", attr.name());
                continue;
            }

            final BiFunction<Instance, Space, TypedEObject> decoratee = toEObject;
            final int index = i;

            if(attr.isNumeric() && EClassifierHelper.isReal(attrFeature.get().getEType())) {
                toEObject = (instance, space) -> {
                    // continue the chain
                    final TypedEObject object = decoratee.apply(instance, space);

                    if(!instance.isMissing(index)) {
                        // set value
                        object.eSet(attrFeature.get(), instance.toDoubleArray()[index]);
                    }

                    return object;
                };
            } else if(attr.isNumeric() && EClassifierHelper.isIntegerOrShorter(attrFeature.get().getEType())) {
                toEObject = (instance, space) -> {
                    // continue the chain
                    final TypedEObject object = decoratee.apply(instance, space);

                    if(!instance.isMissing(index)) {
                        // set value
                        object.eSet(attrFeature.get(), (int)instance.toDoubleArray()[index]);
                    }

                    return object;
                };
            } else if(attr.isString() || attr.isNominal()) {
                toEObject = (instance, space) -> {
                    // continue the chain
                    final TypedEObject object = decoratee.apply(instance, space);

                    if(!instance.isMissing(index)) {
                        // set value
                        object.eSet(attrFeature.get(), instance.stringValue(index));
                    }

                    return object;
                };
            } else {
                throw new RuntimeException("Not yet supported: " + attr);
            }
        }
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public boolean hasNext() {
        return index < data.size();
    }

    @Override
    public TypedEObject next() {
        return toEObject.apply(data.get(index++), readerSpace);
    }
}
