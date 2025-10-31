package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
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

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
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
    public PipelineComponentImpl init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        log.info("Looking up component configuration.");
        final Instance modelConfiguration = helper.lookup(configuration, "model");
        final String filename = helper.lookup(configuration, "model-file");

        final List<DataDescription> inputFeatures = helper.lookup(configuration, "input-features");
        final List<DataDescription> outputFeatures = helper.lookup(configuration, "output-features");

        final Space inputSpace = annotationsHelper.subSpaceOf(getPipelineSpace(), inputFeatures);
        final Space outputSpace = annotationsHelper.subSpaceOf(getPipelineSpace(), outputFeatures);

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