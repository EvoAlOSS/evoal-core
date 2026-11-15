package de.evoal.optimisation.local_search.main.neighbour;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.VariableToEObjectHelper;

import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;


/**
 * The manual neighbour-choosing strategy generates neighbours in numeric search spaces.
 * All possible permutations (addition of step size, subtraction of step size, identity) are
 * generated as neighbours of the current point, except the unchanged point itself. For n
 * features, there are 3<sup>n</sup> - 1 neighbours, so at most 19 features are supported.
 *
 * Neighbour values have the type of their feature. Neighbours outside of the boundaries of
 * a feature ({@link FeatureBoundaries}) are skipped. Non-numeric features are copied unchanged.
 */
@Named("de.evoal.optimisation.local_search.optimisation.manual-strategy")
@Dependent
public class ManualNeighbourChoosingStrategy implements NeighbourChoosingStrategy {
    @Inject
    protected AttributeHelper helper;

    @Inject
    protected VariableToEObjectHelper variableHelper;

    @Inject
    protected FeatureBoundaries boundaries;

    /**
     * The step sizes, already converted to the types of the features.
     */
	private TypedEObject stepValues;

    @Inject @Named("search-space")
    private Space space;

    @Override
    public Stream<TypedEObject> neighbours(final TypedEObject currentBestCandidate) {
        final EStructuralFeature[] orderedFeatures = space.toArray(new EStructuralFeature[0]);
        final int numberOfNeighbours = (int) Math.pow(3, orderedFeatures.length);

        return IntStream.range(0, numberOfNeighbours)
                        .mapToObj(index -> toOperations(index, orderedFeatures.length))
                        .filter(ManualNeighbourChoosingStrategy::changesCandidate)
                        .map(operations -> toNeighbour(currentBestCandidate, orderedFeatures, operations))
                        .flatMap(Optional::stream);
    }

    @Override
    public ManualNeighbourChoosingStrategy init(final EObject config) {
        final  List<EObject> sv = helper.lookup(config, "step-size");
        this.stepValues = variableHelper.fromVariables(sv, space);
        return this;
    }

    /**
     * Calculates the combination of -1, 0, and 1 for the given neighbour index (a number
     *   in the base 3). The order is the same as before: the first feature changes fastest
     *   and the all -1 combination comes last.
     */
    private static int[] toOperations(final int index, final int length) {
        final int[] operations = new int[length];

        int remaining = index + 1;
        for(int i = 0; i < length; i++) {
            operations[i] = remaining % 3 - 1;
            remaining /= 3;
        }

        return operations;
    }

    /**
     * @return {@code false} for the identity, i.e., if no feature is changed.
     */
    private static boolean changesCandidate(final int[] operations) {
        return Arrays.stream(operations).anyMatch(operation -> operation != 0);
    }

    /**
     * Creates the neighbour for the given operations.
     *
     * @return The neighbour or nothing if a value is outside of the boundaries of its feature.
     */
    private Optional<TypedEObject> toNeighbour(final TypedEObject base, final EStructuralFeature[] features, final int[] operations) {
        final TypedEObject neighbour = space.newEObject();

        for(int i = 0; i < features.length; i++) {
            final EStructuralFeature feature = features[i];
            final Optional<Object> value = neighbourValue(feature, base.eGet(feature), operations[i]);

            if(value.isEmpty()) {
                return Optional.empty();
            }

            neighbour.eSet(feature, value.get());
        }

        return Optional.of(neighbour);
    }

    /**
     * Calculates {@code base + operation * step} for a single feature.
     *
     * @return The value in the type of the feature or nothing if it is outside of the boundaries.
     */
    private Optional<Object> neighbourValue(final EStructuralFeature feature, final Object base, final int operation) {
        final EClassifier type = feature.getEType();

        if(EClassifierHelper.isReal(type)) {
            final double value = NumericConversions.toDouble(base) + operation * NumericConversions.toDouble(stepValues.eGet(feature));
            if(!isWithinBoundaries(feature, value)) {
                return Optional.empty();
            }

            return Optional.of(NumericConversions.toType(value, type));
        } else if(EClassifierHelper.isLongOrShorter(type)) {
            final long value;
            try {
                // long arithmetic does not overflow silently like int arithmetic
                value = Math.addExact(NumericConversions.toLong(base), operation * NumericConversions.toLong(stepValues.eGet(feature)));
            } catch(final ArithmeticException e) {
                return Optional.empty();
            }

            if(!isWithinBoundaries(feature, value)) {
                return Optional.empty();
            }

            return Optional.of(NumericConversions.toType(value, type));
        } else {
            // non-numeric features are not changed
            return Optional.of(base);
        }
    }

    private boolean isWithinBoundaries(final EStructuralFeature feature, final double value) {
        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
        final double lower = bounds.lower().doubleValue();
        final double upper = bounds.upper().doubleValue();

        return (bounds.lowerIncluded() ? lower <= value : lower < value)
            && (bounds.UpperIncluded() ? value <= upper : value < upper);
    }

    private boolean isWithinBoundaries(final EStructuralFeature feature, final long value) {
        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
        final long lower = bounds.lower().longValue();
        final long upper = bounds.upper().longValue();

        return (bounds.lowerIncluded() ? lower <= value : lower < value)
            && (bounds.UpperIncluded() ? value <= upper : value < upper);
    }
}
