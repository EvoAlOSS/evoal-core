package de.evoal.pipeline.impl.internal;

import de.evoal.core.api.utils.Requirements;
import de.evoal.models.v202704.pipeline.PipelineDefinition;
import de.evoal.pipeline.api.model.PipelineSource;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.evoal.models.v202704.pipeline.ConcreteStep;
import de.evoal.models.v202704.pipeline.PipelineStep;
import de.evoal.models.v202704.pipeline.Step;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.models.core.ecore.Space;

import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineComposite;

/**
 * Helper for converting pipelines into an executable composite.
 */
@Slf4j
public class PipelineInstantiator {
    /**
     * The pipeline space.
     */
    private final Space space;

    public PipelineInstantiator(final @NonNull Space space) {
        this.space = space;
    }

    /**
     * Converts the list into a composite that contains each converted pipeline
     *   definition as a child.
     *
     * @param steps List of steps to combine into a single executable pipeline.
     * @return An executable pipeline
     */
    public PipelineComposite definitionsToComposite(final @NonNull List<PipelineDefinition> steps) {
        log.info("Converting {} steps into a composite.", steps.size());

        final List<PipelineComponent> components =
                steps.stream()
                        .map(this::definitionToComposite)
                        .collect(Collectors.toUnmodifiableList());

        final PipelineComposite result = new PipelineComposite(components);
        final Optional<PipelineComponent> firstComponent = result.first();

        Requirements.requireNotNull(firstComponent, "Pipeline contains no components.");
        Requirements.requireTrue(firstComponent.get() instanceof PipelineSource, "First pipeline component is not a valid source.");

        return result;
    }

    /**
     * Converts the pipeline definition into a composite.
     *
     * @param definition The definition to combine into a single executable pipeline.
     * @return An executable pipeline
     */
    private PipelineComposite definitionToComposite(final @NonNull PipelineDefinition definition) {
        log.info("Converting definition '{}# into a composite.", definition.getName());

        return stepsToComposite(definition.getSteps());
    }


    /**
     * Converts the list into a composite that contains each converted pipeline
     *   definition as a child.
     *
     * @param steps List of steps to combine into a single executable pipeline.
     * @return An executable pipeline
     */
    public PipelineComposite stepsToComposite(final @NonNull List<Step> steps) {
        log.info("Converting {} steps into a composite.", steps.size());

        final List<PipelineComponent> components =
                steps.stream()
                         .map(this::toComponent)
                         .toList();

        return new PipelineComposite(components);
    }

    /**
     * Converting a step into a component, a single executable element of the pipeline.
     *
     * @param step The step to instantiate.
     * @return The instantiated component.
     */
    private PipelineComponent toComponent(final Step step) {
        if(step instanceof ConcreteStep concrete) {
            log.info("Instantiating component {}", concrete.getConfiguration().eClass().getName());

            final Space inputSpace = space.subSpace(concrete.getReads());
            final Space outputSpace = space.subSpace(concrete.getWrites());

            return BeanFactory.createComponent(PipelineComponentImpl.class, concrete.getConfiguration(), c -> c.setFeatures(space, inputSpace, outputSpace));
        } else if(step instanceof PipelineStep pipeline) {
            return definitionToComposite(pipeline.getDefinition());
        } else {
            throw new IllegalArgumentException("Unsupported step type: " + step.eClass().getName());
        }
    }
}
