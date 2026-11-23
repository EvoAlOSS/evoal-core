package de.evoal.pipeline.api.model;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;

import java.util.stream.Stream;

/**
 * A component that processes the whole stream instead of one row at a time, e.g. a step that
 *   has to see all rows before it can change the first one. The executor calls
 *   {@link #process(Stream)} instead of {@link #apply(TypedEObject)}.
 */
public interface PipelineStreamProcessor extends PipelineComponent {
    /**
     * Processes the stream. The returned stream should be lazy: it is consumed after the whole
     *   pipeline is composed.
     *
     * @param rows The rows that reach the component.
     * @return The rows that the component passes on.
     */
    @NonNull Stream<@NonNull TypedEObject> process(final @NonNull Stream<@NonNull TypedEObject> rows);
}
