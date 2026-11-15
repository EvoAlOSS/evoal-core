package de.evoal.pipeline.impl.optimisation;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import de.evoal.pipeline.api.model.PipelineComposite;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComponentImpl;

@Slf4j
@Dependent
@Named("de.evoal.pipeline.optimisation.benchmark-function")
public class BenchmarkOptimisationFunction extends OptimisationFunctionImpl {

    /**
     * Lookup configuration attributes.
     */
    @Inject
    private AttributeHelper attributes;

    /**
     * The instantiated pipeline.
     */
    private PipelineComposite benchmarkPipeline;

    /**
     * A merged space (of search and optimisation space) that is used for the
     *   benchmark pipeline.
     */
    private Space mergedSpace;

    /**
     * Optimisation space configuration.
     */
    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    /**
     * Search space definition.
     */
    @Inject @Named("search-space")
    private Space searchSpace;

    @Override
    public TypedEObject evaluate(final TypedEObject candidate) {
        final TypedEObject result = optimisationSpace.newEObject();
        final TypedEObject object = mergedSpace.newEObject();
        for(final EStructuralFeature feature : searchSpace) {
            object.eSet(feature, candidate.eGet(feature));
        }

        benchmarkPipeline.apply(object);

        for(final EStructuralFeature feature : optimisationSpace) {
            result.eSet(feature, object.eGet(feature));
        }

        return result;
    }

    @SneakyThrows
    @Override
    public OptimisationFunction init(final EObject config) {
        log.info("Using benchmark function as optimisation function");
        mergedSpace = searchSpace.merge(optimisationSpace);

        final List<EObject> benchmarkConfigurations = attributes.lookup(config, "benchmarks");

        final List<PipelineComponent> components =
            benchmarkConfigurations
                    .stream()
                    .map(configuration -> {
                            // In the runtime model, 'function' is a dynamic EObject of the benchmark's
                            // DL class, and 'reads'/'writes' already hold the merged-space features.
                            final EObject function = attributes.lookup(configuration, "function");
                            final List<EStructuralFeature> reads = attributes.lookup(configuration, "reads");
                            final List<EStructuralFeature> writes = attributes.lookup(configuration, "writes");

                            log.info("  found configuration of benchmark {} (reads {}, writes {})",
                                    function.eClass().getName(),
                                    reads.stream().map(EStructuralFeature::getName).toList(),
                                    writes.stream().map(EStructuralFeature::getName).toList());

                            return toComponent(function, reads, writes);
                        })
                    .toList();

        benchmarkPipeline = new PipelineComposite(components);

        return this;
    }

    /**
     * Instantiates a benchmark component, a single executable element of the pipeline.
     *
     * @param instance The benchmark configuration (dynamic EObject of the runtime model).
     * @param reads The features the benchmark reads.
     * @param writes The features the benchmark writes.
     * @return The instantiated component.
     */
    private PipelineComponent toComponent(final EObject instance,
                                          final List<EStructuralFeature> reads,
                                          final List<EStructuralFeature> writes) {
        log.info("Instantiating component {}", instance.eClass().getName());

        final Space inputSpace = mergedSpace.subSpace(reads);
        final Space outputSpace = mergedSpace.subSpace(writes);

        return BeanFactory.createComponent(
                PipelineComponentImpl.class,
                instance,
                c -> c.setFeatures(mergedSpace, inputSpace, outputSpace)
        );
    }
}


