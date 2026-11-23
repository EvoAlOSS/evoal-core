package de.evoal.surrogate.main.optimisation;

import java.io.File;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;
import de.evoal.optimisation.api.evaluation.EvaluationSource;
import de.evoal.optimisation.api.evaluation.EvaluationSourceProvider;

import de.evoal.surrogate.api.cdi.SurrogateProducer;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.SurrogateModelProvider;

/**
 * Surrogate-based fitness function for optimisation. Its evaluations are counted as
 *   {@link EvaluationSource#SURROGATE} evaluations.
 */
@Dependent @Named("de.evoal.surrogate.optimisation.surrogate")
@Slf4j
public class SurrogateFitnessFunction extends OptimisationFunctionImpl
                                      implements EvaluationSourceProvider, SurrogateModelProvider {

    @Inject
    private EAnnotationHelper annotations;

    @Inject
    private AttributeHelper attribute;

    private ModelFunctionData memento;

    @Inject @Named("search-space")
    private Space searchSpace;

    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject
    private SurrogateProducer producer;

    @Override
    public EvaluationSource getEvaluationSource() {
        return EvaluationSource.SURROGATE;
    }

    @Override
    public ModelFunctionData getModelFunctionData() {
        return memento;
    }

    @Override
    public TypedEObject evaluate(final TypedEObject input) {
        final TypedEObject output = optimisationSpace.newEObject();

        memento.predict(input, output);

        log.info(" {} -> {}.", input, output);

        return output;
    }

    @Override
    public OptimisationFunction init(final EObject configuration) {
        final String surrogateConfiguration = attribute.lookup(configuration, "model-file");

        log.info("Loading function from {}.", surrogateConfiguration);

        final List<EStructuralFeature> input = attribute.lookup(configuration, "input-space");
        final List<EStructuralFeature> output = attribute.lookup(configuration, "output-space");

        memento = producer.load(new File(surrogateConfiguration), searchSpace, optimisationSpace);
        log.info("Function is {}.", memento.function());
        return this;
    }
}
