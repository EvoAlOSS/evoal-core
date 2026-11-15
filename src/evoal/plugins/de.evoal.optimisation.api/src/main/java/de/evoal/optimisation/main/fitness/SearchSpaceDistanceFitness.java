package de.evoal.optimisation.main.fitness;

import de.evoal.models.v202704.optimisation.execution.impl.OptimisationFunctionImpl;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.languages.model.base.definitions.DataDescription;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

@Dependent
@Named("de.evoal.optimisation.core.search-space-distance")
@Slf4j
public class SearchSpaceDistanceFitness extends OptimisationFunctionImpl {

    @Inject
    private EAnnotationHelper annotations;

    @Inject
    private AttributeHelper attributes;


    @Inject @Named("optimisation-space")
    private Space optimisationSpace;

    @Inject
    private Blackboard board;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * The actual fitness calculation.
     */
    private BiConsumer<TypedEObject, TypedEObject> fitness;

    @Override
    public TypedEObject evaluate(final TypedEObject properties) {
        final TypedEObject result = optimisationSpace.newEObject();

        fitness.accept(properties, result);

        return result;
    }

    private double distance(final Object o, final double v) {
        return Math.abs(((Number)o).doubleValue() - v);
    }

    @Override
    public OptimisationFunction init(final EObject config) {
        final Map<DataDescription, EStructuralFeature> sourceMapping = annotations.featuresOf(searchSpace);
        final Map<DataDescription, EStructuralFeature> targetMapping = annotations.featuresOf(optimisationSpace);

        final List<EObject> target = attributes.lookup(config, "target");
        final Map<EStructuralFeature, Number> values = toValueMap(sourceMapping, target);

        final List<EObject> mapping = attributes.lookup(config, "mapping");
        final Map<EStructuralFeature, EStructuralFeature> mappings = toMappingMap(sourceMapping, targetMapping, mapping);

        fitness = (input, output) -> {
            for(final Map.Entry<EStructuralFeature, EStructuralFeature> entry : mappings.entrySet()) {
                final Number targetValue = values.get(entry.getKey());
                final Number actualValue = input.eGetAsNumber(entry.getKey());

                final Number resultValue = ArithmeticNumberOperations.abs(ArithmeticNumberOperations.minus(targetValue, actualValue));

                output.eSet(entry.getValue(), resultValue);
            }
        };


        return this;
    }

    private Map<EStructuralFeature, Number> toValueMap(final Map<DataDescription, EStructuralFeature> sources, final List<EObject> array) {
        return array.stream()
                    .collect(
                        Collectors.toMap(
                            i -> inSpace(sources, attributes.lookup(i, "var")),
                            i -> attributes.<Number>lookup(i, "val")
                        )
                    );
    }

    private Map<EStructuralFeature, EStructuralFeature> toMappingMap(final Map<DataDescription, EStructuralFeature> sources, final Map<DataDescription, EStructuralFeature> targets, final List<EObject> array) {
        return array.stream()
                .collect(
                        Collectors.toMap(
                                i -> inSpace(sources, attributes.lookup(i, "input")),
                                i -> inSpace(targets, attributes.lookup(i, "output"))
                        )
                );
    }

    /**
     * Maps the feature of a {@code data} attribute to the feature of the same data in the
     *   given space (the configured feature may belong to a different space class).
     */
    private EStructuralFeature inSpace(final Map<DataDescription, EStructuralFeature> space, final EStructuralFeature feature) {
        return annotations.dataDescriptionOf(feature)
                          .map(space::get)
                          .orElseThrow(() -> new IllegalStateException("Data '" + feature.getName() + "' is not part of the space."));
    }
}
