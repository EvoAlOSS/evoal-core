package de.evoal.optimisation.main.constraints;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.LinearForm;
import de.evoal.core.api.math.EvoalMath;

/**
 * Orthogonal projection (DL type {@code 'projection-repair'}) for linear constraints
 *   g(x) = a·x + c >= 0 (or = 0): a violated constraint moves the candidate onto its
 *   hyperplane, x + t·a with t = -g(x) / |a|^2. One attempt projects onto every violated
 *   constraint once, in the order of the DDL, each from the result of the previous one
 *   ("systematic projection", S. Agmon: The relaxation method for linear inequalities.
 *   Canadian Journal of Mathematics 6, 1954, pp. 382-392, doi 10.4153/CJM-1954-037-2,
 *   sections 3 and 4). Afterwards, integer features are rounded and all values are moved
 *   into the bounds of the DDL, so a check may need several attempts. If a rounding error
 *   leaves a projected value on the infeasible side of an inequality, it is moved by the
 *   smallest representable steps.
 */
@Dependent
@Named("de.evoal.optimisation.core.projection-repair")
public class ProjectionRepair extends AbstractConstraintRepair {
    @Override
    protected Optional<String> cannotRepair(final Constraint constraint, final LinearForm form) {
        return Optional.empty();
    }

    @Override
    public String name() {
        return "projection-repair";
    }

    @Override
    public TypedEObject repair(final TypedEObject input, final List<Constraint> constraints) {
        final Map<EStructuralFeature, Double> values = valuesOf(input, constraints);

        for(final Constraint constraint : constraints) {
            final LinearForm form = constraint.linearForm().orElseThrow();
            if(!isViolated(constraint, values)) {
                continue;
            }

            final double squaredNorm = form.coefficients()
                                           .values()
                                           .stream()
                                           .mapToDouble(EvoalMath::square)
                                           .sum();
            final double t = -valueOf(constraint, values) / squaredNorm;

            form.coefficients().forEach((feature, coefficient) -> values.merge(feature, t * coefficient, Double::sum));
            ontoFeasibleSide(constraint, values);
        }

        return write(input, values);
    }
}
