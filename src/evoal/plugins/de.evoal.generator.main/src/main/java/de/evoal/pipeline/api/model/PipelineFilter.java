package de.evoal.pipeline.api.model;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;

/**
 * A component that passes on the rows that satisfy its condition and drops the others. The
 *   executor calls {@link #test(TypedEObject)} instead of {@link #apply(TypedEObject)}, and
 *   {@link #streamEnded()} after the last row.
 */
public interface PipelineFilter extends PipelineComponent {
    /**
     * @param row The row.
     * @return Whether the row is passed on.
     */
    boolean test(final @NonNull TypedEObject row);

    /**
     * Called once after the last row of the stream.
     */
    void streamEnded();
}
