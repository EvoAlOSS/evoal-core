package de.evoal.pipeline.api.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.*;

/**
 * A composite component that contains an arbitrary number of children.
 *   Corresponds to an inner node in the pipeline component tree.
 */
@Slf4j
public final class Composite implements Component {
    private final List<Component> children = new ArrayList<>();

    public Composite(final @NonNull Collection<Component> children) {
        this.children.addAll(children);
    }

    /**
     * @return A collection of all child components.
     */
    public @NonNull Collection<Component> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public static Composite of(final @NonNull Collection<Component> children) {
        return new Composite(children);
    }

    @Override
    public @NonNull LinkedHashSet<EStructuralFeature> getReads() {
        final LinkedHashSet<EStructuralFeature> reads = new LinkedHashSet<>();
        children.forEach(c -> reads.addAll(c.getReads()));

        return reads;
    }

    @Override
    public @NonNull LinkedHashSet<EStructuralFeature> getWrites() {
        final LinkedHashSet<EStructuralFeature> writes = new LinkedHashSet<>();
        children.forEach(c -> writes.addAll(c.getWrites()));

        return writes;
    }

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        children.forEach(c -> c.apply(object));

        return object;
    }

    @Override
    public void close() {
        children.forEach(Component::close);
    }
}
