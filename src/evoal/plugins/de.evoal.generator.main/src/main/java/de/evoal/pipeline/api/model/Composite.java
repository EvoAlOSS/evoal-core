package de.evoal.pipeline.api.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.misc.SpaceHelper;

/**
 * A composite component that contains an arbitrary number of children.
 *   Corresponds to an inner node in the pipeline component tree.
 */
@Slf4j
public final class Composite implements Component {
    /**
     * List of children to execute.
     */
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
    public @NonNull Space getReads() {
        return SpaceHelper.fromFeatureStream(
                children.stream()
                        .flatMap(c -> c.getReads().stream())
        );
    }

    @Override
    public @NonNull Space getWrites() {
        return SpaceHelper.fromFeatureStream(
                children.stream()
                        .flatMap(c -> c.getWrites().stream())
        );
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
