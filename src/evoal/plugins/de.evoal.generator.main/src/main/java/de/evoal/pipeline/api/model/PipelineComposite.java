package de.evoal.pipeline.api.model;

import de.evoal.core.api.interpreter.InterpreterState;
import lombok.Getter;
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
public final class PipelineComposite implements PipelineComponent {
    /**
     * List of children to execute.
     */
    private final List<PipelineComponent> children = new ArrayList<>();

    /**
     * Space of the entire pipeline.
     */
    @Getter
    private Space pipelineSpace;

    public PipelineComposite(final @NonNull Collection<PipelineComponent> children) {
        this.children.addAll(children);
    }

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        children.forEach(c -> c.apply(object));

        return object;
    }

    @Override
    public void close() {
        children.forEach(PipelineComponent::close);
    }

    /**
     * @return A collection of all child components.
     */
    public @NonNull Collection<PipelineComponent> getChildren() {
        return Collections.unmodifiableList(children);
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
    public PipelineComponent setContext(@NonNull InterpreterState context) {
        children.forEach(c -> c.setContext(context));

        return this;
    }

    public static PipelineComposite of(final @NonNull Collection<PipelineComponent> children) {
        return new PipelineComposite(children);
    }

    public void setFeatures(final Space pipeline, final Space reads, final Space writes) {
        this.pipelineSpace = pipeline;

    }

    @Override
    public Optional<PipelineComponent> first() {
        if(children.isEmpty()) {
            return Optional.empty();
        }

        return children.get(0)
                       .first();
    }
}
