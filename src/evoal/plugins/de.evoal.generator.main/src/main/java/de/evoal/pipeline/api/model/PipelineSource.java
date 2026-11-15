package de.evoal.pipeline.api.model;

import lombok.NonNull;

import java.util.stream.Stream;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * A source component for producing data.
 */
public interface PipelineSource extends PipelineComponent {
    /**
     * @return A non-null stream of all typed objects.
     */
    public @NonNull Stream<@NonNull TypedEObject> toStream();
}
