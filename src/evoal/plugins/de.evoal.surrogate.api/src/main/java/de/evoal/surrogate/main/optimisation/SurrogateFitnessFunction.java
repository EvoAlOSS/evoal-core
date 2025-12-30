package de.evoal.surrogate.main.optimisation;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.cdi.SurrogateProducer;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Surrogate-based fitness function for optimisation.
 */
@Dependent @Named("de.evoal.surrogate.optimisation.surrogate")
@Slf4j
public class SurrogateFitnessFunction implements OptimisationFunction {

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private AttributeHelper attribute;

    @Inject
    private EClassProvider dynamic;

    private ModelFunctionData memento;

    private Space outputSpecification;

    @Inject
    private SurrogateProducer producer;

    @Override
    public double[] evaluate(final Properties properties) {
        final ModelFunction function = memento.function();

        final TypedEObject input = function.getInput().newEObject();
        final TypedEObject output = function.getOutput().newEObject();

        for(final PropertySpecification spec : properties.getSpecification().getProperties()) {
            final Object value = properties.get(spec);

            input.eSet(input.eClass().getEStructuralFeature(spec.name()), value);
        }

        function.apply(input, output);

        final int size = function.getOutput().size();
        final double [] result = new double[size];
        int index = 0;
        for(final EStructuralFeature feature : function.getOutput()) {
            result[index++] = output.eGetAsDouble(feature);
        }

        log.info(" {} -> {}.", properties, Arrays.toString(result));

        return result;
    }

    @Override
    public OptimisationFunction init(final Instance configuration) {
        final String surrogateConfiguration = attribute.lookup(configuration, "model-file");

        log.info("Loading function from {}.", surrogateConfiguration);

        final List<DataDescription> inputSpace = attribute.lookup(configuration, "input-space");
        final List<DataDescription> outputSpace = attribute.lookup(configuration, "output-space");

        final EClass dynamicEClass = dynamic.eClassFor(inputSpace, outputSpace);
        final Space dynamicSpace = new Space(dynamicEClass);
        final Space input = helper.subSpaceOf(dynamicSpace, inputSpace);
        final Space output = helper.subSpaceOf(dynamicSpace, outputSpace);

        memento = producer.load(new File(surrogateConfiguration), input, output);
        log.info("Function is {}.", memento.function());

        this.outputSpecification = memento.function().getOutput();
        return this;
    }
}
