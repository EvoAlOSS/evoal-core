package de.evoal.optimisation.main.constraints;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.api.constraints.LinearForm;

/**
 * Saturation (DL type {@code 'saturation-repair'}): a constraint on a single search feature
 *   is a bound a·x + c >= 0 (or = 0) of that feature, and a violated bound sets the feature to
 *   the bound. The constraints are handled in the order of the DDL. For an integer feature,
 *   the value becomes the nearest integer on the feasible side, one step inside the bound if
 *   the comparison is strict; an equality takes the nearest integer. The name follows the
 *   bound handling "saturation" (A. V. Kononova, D. Vermetten, F. Caraffini, M.-A. Mitran,
 *   D. Zaharie: The importance of being constrained: dealing with infeasible solutions in
 *   Differential Evolution and beyond. Evolutionary Computation, 2024,
 *   doi 10.1162/evco_a_00333, section 2.4), also called projection.
 */
@Dependent
@Named("de.evoal.optimisation.core.saturation-repair")
public class SaturationRepair extends AbstractConstraintRepair {
    @Override
    protected Optional<String> cannotRepair(final Constraint constraint, final LinearForm form) {
        final int features = form.coefficients().size();

        return features == 1
                ? Optional.empty()
                : Optional.of("it reads " + features + " search features; saturation repairs bounds of one feature");
    }

    @Override
    public String name() {
        return "saturation-repair";
    }

    @Override
    public TypedEObject repair(final TypedEObject input, final List<Constraint> constraints) {
        final Map<EStructuralFeature, Double> values = valuesOf(input, constraints);

        for(final Constraint constraint : constraints) {
            final LinearForm form = constraint.linearForm().orElseThrow();
            final Map.Entry<EStructuralFeature, Double> term = form.coefficients().entrySet().iterator().next();
            final EStructuralFeature feature = term.getKey();
            final double coefficient = term.getValue();
            if(!isViolated(constraint, values)) {
                continue;
            }

            final double bound = -form.constant() / coefficient;
            values.put(feature, saturated(constraint, feature, bound, coefficient > 0.0));
            ontoFeasibleSide(constraint, values);
        }

        return write(input, values);
    }

    /**
     * @param lower Whether the bound is a lower bound (a > 0); ignored for equalities.
     * @return The value of the feature on the bound, for integer features the nearest integer
     *   on the feasible side.
     */
    private static double saturated(final Constraint constraint, final EStructuralFeature feature, final double bound,
                                    final boolean lower) {
        if(!isInteger(feature)) {
            return bound;
        }

        if(constraint.kind() == ConstraintKind.EQUALITY) {
            return Math.rint(bound);
        }

        final double step = constraint.isStrict() ? 1.0 : 0.0;
        if(lower) {
            final double value = Math.ceil(bound);
            return value == bound ? value + step : value;
        }

        final double value = Math.floor(bound);
        return value == bound ? value - step : value;
    }
}
