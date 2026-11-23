package de.evoal.pipeline.api.executor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import de.evoal.models.core.ecore.Space;

import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.pipeline.api.model.PipelineFilter;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineSink;
import de.evoal.pipeline.api.model.PipelineSource;
import de.evoal.pipeline.api.model.PipelineStreamProcessor;
import de.evoal.pipeline.impl.components.misc.Limit;
import lombok.extern.slf4j.Slf4j;

/**
 * Runs a pipeline as a stream of rows: a stream processor ({@link PipelineStreamProcessor})
 *   processes the whole stream, a filter ({@link PipelineFilter}) drops the rows it does not
 *   pass on, a limit shortens the stream, and every other step changes the row and passes it
 *   on. After the last row, the filters and sinks act in pipeline order.
 */
@Slf4j
public class StreamExecutor implements PipelineExecutor {
    private Space space;

    @Override
    public void setSpace(final Space space) {
        this.space = space;
    }

    @Override
    public void execute(final PipelineComposite pipeline) {
        // we start with an empty instance
        final Optional<PipelineComponent> sourceComponent = pipeline.first();

        if(sourceComponent.isEmpty()) {
            log.info("Pipeline is empty. Skipping execution.");
            return;
        }

        execute(pipeline,
                Collections.singleton(sourceComponent.get()),
                ((PipelineSource)sourceComponent.get()).toStream(),
                s -> { s.forEach(e -> {}); return null; });
    }

    /**
     * Runs the pipeline on the given rows instead of a source, e.g. a stored prediction
     *   pipeline on one row.
     *
     * @param pipeline The pipeline, without a source.
     * @param rows The rows to run it on.
     * @return The rows that leave the pipeline, in their order.
     */
    public List<TypedEObject> execute(final PipelineComposite pipeline, final Collection<TypedEObject> rows) {
        return execute(pipeline, Collections.emptySet(), rows.stream(), Stream::toList);
    }

    private <T> T execute(final PipelineComposite pipeline, final Set<PipelineComponent> filter, final Stream<TypedEObject> input, final Function<Stream<TypedEObject>, T> collector) {
        Stream<TypedEObject> stream = input;

        final Collection<PipelineComponent> components = toCollection(pipeline);
        for(PipelineComponent component : components) {
            if(filter.contains(component)) {
                // first component already handled
                continue;
            }

            if(component instanceof PipelineStreamProcessor processor) {
                stream = processor.process(stream);
                continue;
            }

            if(component instanceof PipelineFilter rowFilter) {
                stream = stream.filter(rowFilter::test);
                continue;
            }

            if(component instanceof Limit limit) {
                stream = stream.limit(limit.getLimit());
            }

            stream = stream.map(component::apply);
        }

        final T result = collector.apply(stream);

        // the stream has ended: the filters and sinks act in pipeline order
        for(final PipelineComponent component : components) {
            if(component instanceof PipelineFilter rowFilter) {
                rowFilter.streamEnded();
            } else if(component instanceof PipelineSink sink) {
                sink.streamEnded();
            }
        }

        return result;
    }

    private Collection<PipelineComponent> toCollection(final PipelineComposite pipeline) {
        final ArrayList<PipelineComponent> components = new ArrayList<>();

        addToCollection(pipeline, components);

        return components;
    }

    private void addToCollection(final PipelineComposite composite, final ArrayList<PipelineComponent> components) {
        for(final PipelineComponent component : composite.getChildren()) {
            if(component instanceof PipelineComposite childComposite) {
                addToCollection(childComposite, components);
            } else {
                components.add(component);
            }
        }
    }
}
