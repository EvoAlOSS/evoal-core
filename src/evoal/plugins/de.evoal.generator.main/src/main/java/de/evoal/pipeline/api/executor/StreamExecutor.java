package de.evoal.pipeline.api.executor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import de.evoal.core.api.ecore.Space;

import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineSource;
import de.evoal.pipeline.impl.components.misc.Limit;
import lombok.extern.slf4j.Slf4j;

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
/*
        Stream<TypedEObject> stream = ((PipelineSource)sourceComponent.get()).toStream();

        final Collection<PipelineComponent> components = toCollection(pipeline);
        for(PipelineComponent component : components) {
            if(component == sourceComponent.get()) {
                // first component already handled
                continue;
            }

            if(component instanceof Limit limit) {
                stream = stream.limit(limit.getLimit());
            }

            stream = stream.map(component::apply);
        }

        stream.forEach(e -> {});
*/
        execute(pipeline,
                Collections.singleton(sourceComponent.get()),
                ((PipelineSource)sourceComponent.get()).toStream(),
                s -> { s.forEach(e -> {}); return null; });
    }
/*
    @Override
    public TypedEObject execute(final PipelineComposite pipeline, final TypedEObject input) {
        return execute(pipeline, Collections.singletonList(input)).get(0);
    }

    @Override
    public List<TypedEObject> execute(final PipelineComposite pipeline, final Collection<TypedEObject> input) {
        return execute(pipeline, Collections.emptySet(), input.stream(), Stream::toList);
    }
*/
    private <T> T execute(final PipelineComposite pipeline, final Set<PipelineComponent> filter, final Stream<TypedEObject> input, final Function<Stream<TypedEObject>, T> collector) {
        Stream<TypedEObject> stream = input;

        final Collection<PipelineComponent> components = toCollection(pipeline);
        for(PipelineComponent component : components) {
            if(filter.contains(component)) {
                // first component already handled
                continue;
            }

            if(component instanceof Limit limit) {
                stream = stream.limit(limit.getLimit());
            }

            stream = stream.map(component::apply);
        }

        return collector.apply(stream);
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
