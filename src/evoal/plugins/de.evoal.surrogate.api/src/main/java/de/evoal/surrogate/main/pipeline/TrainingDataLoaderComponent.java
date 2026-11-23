package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineSource;
import de.evoal.surrogate.api.training.TrainingTaskHelper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import java.util.List;
import java.util.stream.Stream;

/**
 * Source of the learning use case: streams the files {@code 'training-files'} with the
 *   features {@code 'input-features'} and {@code 'output-features'}.
 */
@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.training-data-loader")
public class TrainingDataLoaderComponent extends PipelineComponentImpl implements PipelineSource {
    /**
     * All input to stream.
     */
    private Stream<@NonNull TypedEObject> stream = null;

    /**
     * The files to read.
     */
    private List<String> files;

    /**
     * The input features followed by the output features.
     */
    private List<EStructuralFeature> features;

    @Inject
    private TrainingTaskHelper helper;

    @Inject
    private AttributeHelper attributes;

    @Inject
    private AttributeEvaluator evaluator;

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        files = stringsOf(evaluator.attributeToJava(configuration, "training-files", EcorePackage.Literals.EJAVA_OBJECT));
        final List<EStructuralFeature> inputs = attributes.lookup(configuration, "input-features");
        final List<EStructuralFeature> outputs = attributes.lookup(configuration, "output-features");
        features = Stream.concat(inputs.stream(), outputs.stream()).toList();

        return this;
    }

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        throw new IllegalStateException();
    }

    @Override
    public void close() {
        stream = null;
    }

    @Override
    public PipelineComponent setContext(@NonNull InterpreterState context) {
        stream = helper.loadTrainingData(context, files, features);

        return super.setContext(context);
    }

    @Override
    public @NonNull Stream<@NonNull TypedEObject> toStream() {
        log.info("Generating data stream for space {}.", getPipelineSpace());

        return stream;
    }

    private static List<String> stringsOf(final Object value) throws InitializationException {
        if(!(value instanceof List<?> list) || !list.stream().allMatch(String.class::isInstance)) {
            throw new InitializationException("'training-files' of 'training-data-loader' must be an array of file names, e.g. [\"data.json\"].");
        }

        return list.stream()
                   .map(String.class::cast)
                   .toList();
    }
}
