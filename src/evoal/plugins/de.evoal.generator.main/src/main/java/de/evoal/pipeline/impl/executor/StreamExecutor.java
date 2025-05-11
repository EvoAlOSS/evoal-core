package de.evoal.pipeline.impl.executor;

import de.evoal.pipeline.api.executor.PipelineExecutor;
import de.evoal.pipeline.api.model.Component;
import de.evoal.pipeline.api.model.Composite;
import de.evoal.pipeline.api.model.TypedEObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamExecutor implements PipelineExecutor {
    private EClass space;

    @Override
    public void setSpace(final EClass space) {
        this.space = space;
    }

    @Override
    public void execute(final Composite pipeline, final Optional<Function<Stream<TypedEObject>, Stream<TypedEObject>>> limiter) {
        // we start with an empty instance
        Stream<TypedEObject> stream = Stream.generate(() -> new TypedEObject(new DynamicEObjectImpl(space)));

        final Collection<Component> components = toCollection(pipeline);
        for(Component component : components) {
            stream = stream.map(component::apply);
        }

        if(limiter.isPresent()) {
            stream = limiter.get().apply(stream);
        }

        stream.forEach(e -> {});
    }

    private Collection<Component> toCollection(final Composite pipeline) {
        final ArrayList<Component> components = new ArrayList<>();

        addToCollection(pipeline, components);

        return components;
    }

    private void addToCollection(final Composite composite, final ArrayList<Component> components) {
        for(final Component component : composite.getChildren()) {
            if(component instanceof Composite childComposite) {
                addToCollection(childComposite, components);
            } else {
                components.add(component);
            }
        }
    }
}
