package de.evoal.pipeline.api.model;

import de.evoal.core.api.interpreter.InterpreterState;
import lombok.NonNull;

import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.Space;

import java.util.Optional;

/**
 * A component of the data pipeline.
 */
public interface PipelineComponent {
    /**
     * Applies the component to an object. Therefore, the component reads and writes features.
     *
     * @param object The object to work on.
     * @return The passed object.
     */
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object);

    /**
     * Gets called to signal component that the pipeline was closed.
     */
    public void close();

    /**
     * @return The first component.
     */
    public default Optional<PipelineComponent> first() {
        return Optional.of(this);
    }

    /**
     * @return A non-null set of structural features the component will read.
     */
    public @NonNull Space getReads();

    /**
     * @return The space of the entire pipeline.
     */
    public @NonNull Space getPipelineSpace();

    /**
     * @return A non-null set of structural features the component will write.
     */
    public @NonNull Space getWrites();

    /**
     * Sets the pipeline context.
     *
     * @param context The context.
     * @return The component itself.
     */
    public PipelineComponent setContext(final @NonNull InterpreterState context);
}
