package de.evoal.surrogate.main.ea;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.cdi.SurrogateProducer;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.List;

@Dependent
@Named("de.evoal.surrogate.optimisation.surrogate")
@Slf4j
public class SurrogateFitnessFunction implements OptimisationFunction {

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private AttributeHelper attribute;

    @Inject
    private EClassProvider dynamic;

    private SurrogateFunction function;

    private Space outputSpecification;

    @Inject
    private SurrogateProducer producer;

    @Override
    public double[] evaluate(final Properties properties) {
        final TypedEObject input = function.getInputSpecification().newEObject();
        final TypedEObject output = outputSpecification.newEObject();

        function.apply(input, output);

        final int size = outputSpecification.size();
        final double [] result = new double[size];
        int index = 0;
        for(final EStructuralFeature feature : outputSpecification) {
            result[index++] = output.eGetAsDouble(feature);
        }

        return result;
    }

    @Override
    public OptimisationFunction init(final Instance configuration) {
        final String surrogateConfiguration = attribute.lookup(configuration, "pson-file");
        log.info("Loading configuration from {}", surrogateConfiguration);

        final List<DataDescription> inputSpace = attribute.lookup(configuration, "input-space");
        final List<DataDescription> outputSpace = attribute.lookup(configuration, "output-space");

        final EClass dynamicEClass = dynamic.eClassFor(inputSpace, outputSpace);
        final Space input = helper.subSpaceOf(dynamicEClass, inputSpace);
        final Space output = helper.subSpaceOf(dynamicEClass, outputSpace);

        function = producer.load(new File(surrogateConfiguration), input.merge(output));

        this.outputSpecification = function.getOutputSpecification();
        return this;
    }
}
