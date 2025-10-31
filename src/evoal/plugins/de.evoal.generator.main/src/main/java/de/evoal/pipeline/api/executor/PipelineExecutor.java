package de.evoal.pipeline.api.executor;

import de.evoal.core.api.ecore.Space;
import de.evoal.pipeline.api.model.PipelineComposite;

/**
 * A pipeline executor receives a pipeline and executes according to a strategy.
 */
public interface PipelineExecutor {
    /**
     * The pipeline's space.
     *
     * @param space The space.
     */
    void setSpace(final Space space);

    /**
     * Executes the pipeline on an optional data stream.
     *
     * @param pipeline The pipeline to execute.
     */
    void execute(final PipelineComposite pipeline);
}
