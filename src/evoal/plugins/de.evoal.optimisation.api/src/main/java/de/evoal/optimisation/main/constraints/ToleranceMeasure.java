package de.evoal.optimisation.main.constraints;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.constraints.AbstractConstraintMeasure;
import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.FeatureValues;

/**
 * Accepts a measurement uncertainty (DL type {@code 'tolerance-measure'}): every feature f
 *   of the constraint that has a standard deviation sigma(f) in the DDL is moved by
 *   {@code -factor * sigma(f)}, 0 or {@code +factor * sigma(f)}; the degree of violation is
 *   the smallest degree of all 3^k combinations of the k moved features. A satisfied
 *   combination ends the search.
 */
@Dependent
@Named("de.evoal.optimisation.core.tolerance-measure")
public class ToleranceMeasure extends AbstractConstraintMeasure {
    /**
     * The three moves of a feature in units of {@code factor * sigma}: unmoved first, so an
     *   unmoved satisfied constraint is found first.
     */
    private static final double[] MOVES = {0.0, -1.0, 1.0};

    /**
     * The multiple of the standard deviation by which a feature is moved.
     */
    private double factor;

    @Inject
    private AttributeHelper helper;

    /**
     * Creates a measure that is configured by {@link #init(EObject)}.
     */
    public ToleranceMeasure() {
    }

    /**
     * @param equalityTolerance The deviation up to which an equality counts as satisfied.
     * @param factor The multiple of the standard deviation by which a feature is moved.
     * @throws IllegalArgumentException if the factor is not positive.
     */
    public ToleranceMeasure(final double equalityTolerance, final double factor) {
        super(equalityTolerance);
        this.factor = requireFactor(factor);
    }

    @Override
    protected void configure(final EObject configuration) throws InitializationException {
        final double configuredFactor = helper.<Number>lookup(configuration, "factor")
                                              .doubleValue();

        try {
            factor = requireFactor(configuredFactor);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }
    }

    @Override
    public double degreeOf(final Constraint constraint, final TypedEObject input, final TypedEObject objectives) {
        final List<EStructuralFeature> moved = List.copyOf(constraint.deviations().keySet());
        final Map<EStructuralFeature, Double> offsets = new HashMap<>();
        final FeatureValues unmoved = constraint.valuesOf(input, objectives);

        return smallestDegree(constraint, moved, 0, offsets, unmoved);
    }

    private static double requireFactor(final double factor) {
        // also rejects NaN
        if(!(factor > 0.0)) {
            throw new IllegalArgumentException("The 'factor' of 'tolerance-measure' must be greater than 0, but is "
                                               + factor + ".");
        }

        return factor;
    }

    /**
     * Tries the moves of the feature at {@code index} and, recursively, of all later features.
     *
     * @return The smallest degree of all combinations of the moves of the features from
     *   {@code index} on, with the earlier features moved by {@code offsets}.
     */
    private double smallestDegree(final Constraint constraint,
                                  final List<EStructuralFeature> moved,
                                  final int index,
                                  final Map<EStructuralFeature, Double> offsets,
                                  final FeatureValues unmoved) {
        if(index == moved.size()) {
            final FeatureValues movedValues = feature -> unmoved.valueOf(feature) + offsets.getOrDefault(feature, 0.0);
            final double value = constraint.valueOf(movedValues);

            return degreeOf(constraint, value);
        }

        final EStructuralFeature feature = moved.get(index);
        final double step = factor * constraint.deviations().get(feature);
        double smallest = Double.POSITIVE_INFINITY;

        for(final double move : MOVES) {
            offsets.put(feature, move * step);
            final double degree = smallestDegree(constraint, moved, index + 1, offsets, unmoved);
            smallest = Math.min(smallest, degree);

            if(smallest == 0.0) {
                break;
            }
        }

        offsets.remove(feature);

        return smallest;
    }

    @Override
    public String toString() {
        return "tolerance-measure (factor " + factor + ", equality tolerance " + equalityTolerance() + ")";
    }
}
