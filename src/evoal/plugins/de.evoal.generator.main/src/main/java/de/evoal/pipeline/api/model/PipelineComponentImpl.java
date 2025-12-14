package de.evoal.pipeline.api.model;

import de.evoal.core.api.interpreter.InterpreterState;
import lombok.Getter;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.core.api.ecore.Space;
import lombok.NonNull;

/**
 * Abstract implementation of a pipeline component (an actual component of the
 *   pipeline).
 */
@Getter
public abstract class PipelineComponentImpl implements PipelineComponent, EvoalComponent<PipelineComponentImpl> {

    /**
     * Context of the pipeline component.
     */
    private InterpreterState context;

    /**
     * The space of the entire pipeline.
     */
    private Space pipelineSpace;

    /**
     * The subspace read by this component.
     */
    private Space reads;

    /**
     * The subspace written by the component.
     */
    private Space writes;

    @Override
    public PipelineComponent setContext(final @NonNull InterpreterState context) {
        this.context = context;

        return this;
    }

    public void setFeatures(final Space pipeline, final Space reads, final Space writes) {
        this.pipelineSpace = pipeline;
        this.reads = reads;
        this.writes = writes;
    }

    /**
     * By default, we assume that no close operation is necessary.
     */
    @Override
    public void close() {
    }
}
