package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineSource;
import de.evoal.surrogate.api.training.TrainingTaskHelper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.stream.Stream;

/**
 * Source of the testing use case: streams the test data of the learning task
 *   ({@code testing with [...]}).
 */
@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.test-data-loader")
public class TestDataLoaderComponent extends PipelineComponentImpl implements PipelineSource {
    /**
     * The test data to stream.
     */
    private Stream<@NonNull TypedEObject> stream = null;

    @Inject
    private TrainingTaskHelper helper;

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
        stream = helper.loadTestData(context);

        return super.setContext(context);
    }

    @Override
    public @NonNull Stream<@NonNull TypedEObject> toStream() {
        log.info("Generating test data stream for space {}.", getPipelineSpace());

        return stream;
    }
}
