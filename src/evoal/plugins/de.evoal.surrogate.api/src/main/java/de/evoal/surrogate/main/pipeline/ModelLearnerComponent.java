package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.function.ModelFunctionData;
import de.evoal.surrogate.api.function.ModelFunctionFactory;
import de.evoal.surrogate.api.training.ModelLearner;
import de.evoal.surrogate.main.training.ModelLearnerFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.model-learner")
public class ModelLearnerComponent extends PipelineComponentImpl {
    @Inject
    private AttributeHelper helper;

    @Inject
    private ModelFunctionFactory functionFactory;

    @Inject
    private ModelLearnerFactory factory;

    private ModelLearner learner;

    private URI modelURI;

    @Inject
    private EAnnotationHelper annotationsHelper;

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        learner.add(object);

        return object;
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        log.info("Looking up component configuration.");
        final EObject modelConfiguration = helper.lookup(configuration, "model");
        final String filename = helper.lookup(configuration, "model-file");

        final List<EStructuralFeature> inputFeatures = helper.lookup(configuration, "input-features");
        final List<EStructuralFeature> outputFeatures = helper.lookup(configuration, "output-features");

        final Space inputSpace = getPipelineSpace().subSpace(inputFeatures);
        final Space outputSpace = getPipelineSpace().subSpace(outputFeatures);

        log.info("Creating model learner.");
        try {
            modelURI = new URI(filename);
            learner = factory.create(modelConfiguration, inputSpace, outputSpace);
        } catch (final URISyntaxException e) {
            throw new InitializationException("Failed to create model URI.", e);
        }

        return this;
    }

    @Override
    public void close() {
        learner.learn();
        final ModelFunction function = learner.toFunction();
        final ModelFunctionData data = functionFactory.create(modelURI, function);

        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName("model-function");

        getContext().put(variable, data);
    }
}