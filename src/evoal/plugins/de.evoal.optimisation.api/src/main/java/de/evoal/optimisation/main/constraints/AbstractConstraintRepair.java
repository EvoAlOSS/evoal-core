package de.evoal.optimisation.main.constraints;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.api.constraints.ConstraintRepair;
import de.evoal.optimisation.api.constraints.LinearForm;

/**
 * Base class of the repairs of linear constraints: accepts only constraints with a
 *   {@link LinearForm} that reads at least one search feature, and writes repaired values
 *   into a copy of the candidate. A written value is moved into the bounds of the feature in
 *   the DDL (an exclusive bound of an integer feature is replaced by the next integer inside);
 *   the value of an integer feature is rounded to the nearest integer before.
 */
public abstract class AbstractConstraintRepair implements ConstraintRepair {
    /**
     * The bounds of the features in the DDL.
     */
    private final FeatureBoundaries boundaries = new FeatureBoundaries();

    @Override
    public Optional<String> cannotRepair(final Constraint constraint) {
        final Optional<LinearForm> form = constraint.linearForm();

        if(form.isEmpty()) {
            return Optional.of("it is not linear in the search features");
        }
        if(form.get().coefficients().isEmpty()) {
            return Optional.of("it reads no search feature");
        }

        return cannotRepair(constraint, form.get());
    }

    /**
     * @param constraint A linear constraint that reads at least one search feature.
     * @param form Its normal form.
     * @return Why the repair cannot handle the constraint, empty if it can.
     */
    protected abstract Optional<String> cannotRepair(Constraint constraint, LinearForm form);

    @Override
    public final ConstraintRepair init(final EObject configuration) {
        return this;
    }

    /**
     * @param feature A search feature.
     * @return Whether the feature has integer values.
     */
    protected static boolean isInteger(final EStructuralFeature feature) {
        return EClassifierHelper.isLongOrShorter(feature.getEType());
    }

    /**
     * The largest number of steps of {@link #ontoFeasibleSide}.
     */
    private static final int MAXIMUM_STEPS = 64;

    /**
     * Moves the values of the features of an inequality by the smallest representable steps
     *   in the direction of its coefficients until it is satisfied, at most
     *   {@value #MAXIMUM_STEPS} steps. A value on the hyperplane of the constraint can violate
     *   it by a rounding error; this keeps it on the feasible side. Equalities are not changed.
     *
     * @param constraint A linear constraint.
     * @param values The values of the search features; they are changed.
     */
    protected static void ontoFeasibleSide(final Constraint constraint, final Map<EStructuralFeature, Double> values) {
        if(constraint.kind() != ConstraintKind.INEQUALITY) {
            return;
        }

        final LinearForm form = constraint.linearForm().orElseThrow();
        for(int step = 0; step < MAXIMUM_STEPS && valueOf(constraint, values) < 0.0; ++step) {
            form.coefficients().forEach((feature, coefficient) -> values.computeIfPresent(feature, (f, value) ->
                    coefficient > 0.0 ? Math.nextUp(value) : Math.nextDown(value)));
        }
    }

    /**
     * @param constraint A constraint on search features.
     * @param values The values of its search features.
     * @return g, the value of its normal form, computed as the measures compute it.
     */
    protected static double valueOf(final Constraint constraint, final Map<EStructuralFeature, Double> values) {
        return constraint.valueOf(values::get);
    }

    /**
     * @param constraint A constraint on search features.
     * @param values The values of its search features.
     * @return Whether the values violate the constraint: g < 0 for an inequality, g != 0 for
     *   an equality.
     */
    protected static boolean isViolated(final Constraint constraint, final Map<EStructuralFeature, Double> values) {
        final double g = valueOf(constraint, values);

        return constraint.kind() == ConstraintKind.EQUALITY ? g != 0.0 : g < 0.0;
    }

    /**
     * @param input The candidate.
     * @param feature A numeric search feature.
     * @return The value of the feature.
     */
    protected static double valueOf(final TypedEObject input, final EStructuralFeature feature) {
        return ((Number) input.eGet(feature)).doubleValue();
    }

    /**
     * @param input The candidate; it is not changed.
     * @param values The new values of search features.
     * @return A copy of the candidate with the values, each rounded for integer features and
     *   moved into the bounds of its feature.
     */
    protected final TypedEObject write(final TypedEObject input, final Map<EStructuralFeature, Double> values) {
        final TypedEObject copy = new TypedEObject(input);

        for(final Map.Entry<EStructuralFeature, Double> entry : values.entrySet()) {
            final EStructuralFeature feature = entry.getKey();
            final double value = withinBounds(feature, isInteger(feature) ? Math.rint(entry.getValue()) : entry.getValue());

            copy.eSet(feature, NumericConversions.toType(value, feature.getEType()));
        }

        return copy;
    }

    /**
     * @return The value moved into the bounds of the feature in the DDL.
     */
    private double withinBounds(final EStructuralFeature feature, final double value) {
        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
        final boolean integer = isInteger(feature);

        double lower = bounds.lower().doubleValue();
        if(integer && !bounds.lowerIncluded()) {
            lower += 1.0;
        }

        double upper = bounds.upper().doubleValue();
        if(integer && !bounds.UpperIncluded()) {
            upper -= 1.0;
        }

        return Math.min(Math.max(value, lower), upper);
    }

    /**
     * @param input The candidate.
     * @param constraints Constraints on search features.
     * @return The values of the search features the constraints read.
     */
    protected static Map<EStructuralFeature, Double> valuesOf(final TypedEObject input, final List<Constraint> constraints) {
        final Map<EStructuralFeature, Double> values = new LinkedHashMap<>();

        for(final Constraint constraint : constraints) {
            constraint.searchFeatures()
                      .forEach(feature -> values.computeIfAbsent(feature, f -> valueOf(input, f)));
        }

        return values;
    }
}
