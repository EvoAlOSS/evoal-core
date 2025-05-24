package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.languages.model.pipeline.Step;
import de.evoal.pipeline.api.model.Component;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.Composite;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper for creating an executable pipeline for a list of pipeline definitions.
 */
@Slf4j
public class PipelineInstantiator {
    private final EClass space;

    public PipelineInstantiator(final @NonNull EClass space) {
        this.space = space;
    }

    /**
     * Converts the list into a composite that contains each converted pipeline
     *   definition as a child.
     *
     * @param pipelines List of pipelines to instanciate and to combine into a
     *                  single executable pipeline.
     * @return An executable pipeline
     */
    public Composite convert(final @NonNull List<PipelineDefinition> pipelines) {
        log.info("Converting {} pipelines into a composite.", pipelines.size());
        final List<Component> components =
                pipelines.stream()
                         .map(this::toComposite)
                         .collect(Collectors.toUnmodifiableList());

        return new Composite(components);
    }

    /**
     * Converts a single pipeline definition into a composite as every pipeline
     *   definition contains an arbitrary number of steps.
     *
     * @param pipeline The pipeline to convert.
     * @return An executable composite.
     */
    private Composite toComposite(final PipelineDefinition pipeline) {
        log.info("Converting {} pipeline into a composite.", pipeline.getName());
        final List<Component> components =
                pipeline.getSteps()
                        .stream()
                        .map(this::toComponent)
                        .toList();

        return new Composite(components);
    }

    /**
     * Converting a step into a component, a single executable element of the pipeline.
     *
     * @param step The step to instanciate.
     * @return The instanciated component.
     */
    private Component toComponent(final Step step) {
        log.info("Instantiating component {}", step.getInstance().getDefinition().getName());

        final Space inputSpace = new Space(space, step.getReads());
        final Space outputSpace = new Space(space, step.getWrites());

        return BeanFactory.createComponent(ComponentImpl.class, step.getInstance(), c -> c.setFeatures(inputSpace, outputSpace));
    }
}
