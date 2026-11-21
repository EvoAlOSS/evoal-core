package de.evoal.pipeline.api.model;

/**
 * A component that acts when the stream of a pipeline ends, e.g., to estimate values from all
 *   rows or to write a file. A sink passes rows on unchanged, so sinks can follow each other.
 *   The executor calls {@link #streamEnded()} on every sink in pipeline order after the last
 *   row and before {@link #close()}.
 */
public interface PipelineSink extends PipelineComponent {
    /**
     * Called once after the last row of the stream.
     */
    void streamEnded();
}
