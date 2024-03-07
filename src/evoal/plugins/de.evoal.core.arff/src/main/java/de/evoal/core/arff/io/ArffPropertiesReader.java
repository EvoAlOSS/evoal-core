package de.evoal.core.arff.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.io.PropertiesReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.RepresentationType;
import lombok.extern.slf4j.Slf4j;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.File;
import java.util.Arrays;

@Slf4j
@Dependent
@Named("arff-reader")
public class ArffPropertiesReader implements PropertiesReader {
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
    private PropertiesSpecification specification;

    private TriFunction<Instance, PropertiesSpecification, PropertiesSpecification.Builder, Properties> toProperties = (instance, template, builder) -> new Properties(builder.build());

    @Override
    public PropertiesReader init(final File inputFile, final PropertiesSpecification specification) throws EvoalIOException {
        log.info("Creating ARFF properties reader for {}.", specification);

        try {
            this.specification = specification;

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

            if(!specification.contains(attr.name())) {
                log.info("Skipping attribute '{}'.", attr.name());
                continue;
            }

            final PropertySpecification pSpec = specification.find(attr.name());
            Requirements.requireInstanceOf(pSpec, DataDescription.class);
            final RepresentationType rType = ((DataDescription)pSpec.type()).getRepresentation();
            final TriFunction<Instance, PropertiesSpecification, PropertiesSpecification.Builder, Properties> decoratee = toProperties;
            final int index = i;

            if(RepresentationType.REAL.equals(rType)) {
                toProperties = (instance, template, builder) -> {
                    if(instance.isMissing(index)) {
                        return decoratee.apply(instance, template, builder);
                    }

                    // add current specification to builder and let the chain complete it
                    builder.add(pSpec);
                    final Properties properties = decoratee.apply(instance, template, builder);

                    // set value and return
                    properties.put(pSpec, instance.toDoubleArray()[index]);
                    return properties;
                };
            } else if(RepresentationType.INTEGER.equals(rType)) {
                toProperties = (instance, template, builder) -> {
                    if(instance.isMissing(index)) {
                        return decoratee.apply(instance, template, builder);
                    }

                    // add current specification to builder and let the chain complete it
                    builder.add(pSpec);
                    final Properties properties = decoratee.apply(instance, template, builder);

                    // set value and return
                    properties.put(pSpec, (int)instance.toDoubleArray()[index]);
                    return properties;
                };
            } else if(RepresentationType.STRING.equals(rType)) {
                toProperties = (instance, template, builder) -> {
                    if(instance.isMissing(index)) {
                        return decoratee.apply(instance, template, builder);
                    }

                    // add current specification to builder and let the chain complete it
                    builder.add(pSpec);
                    final Properties properties = decoratee.apply(instance, template, builder);

                    // set value and return
                    properties.put(pSpec, instance.stringValue(index));
                    return properties;
                };
            } else {
                throw new RuntimeException("Not yet supported: " + rType);
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
    public Properties next() {
        return toProperties.apply(data.get(index++), specification, PropertiesSpecification.builder());
    }
}
