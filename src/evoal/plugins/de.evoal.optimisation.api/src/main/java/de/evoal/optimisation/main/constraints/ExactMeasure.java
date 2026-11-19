package de.evoal.optimisation.main.constraints;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.ecore.TypedEObject;

import de.evoal.optimisation.api.constraints.AbstractConstraintMeasure;
import de.evoal.optimisation.api.constraints.Constraint;

/**
 * Measures the violation of a constraint at the values of the candidate (DL type
 *   {@code 'exact-measure'}).
 */
@Dependent
@Named("de.evoal.optimisation.core.exact-measure")
public class ExactMeasure extends AbstractConstraintMeasure {
    /**
     * Creates a measure that is configured by {@link #init(EObject)}.
     */
    public ExactMeasure() {
    }

    /**
     * @param equalityTolerance The deviation up to which an equality counts as satisfied.
     */
    public ExactMeasure(final double equalityTolerance) {
        super(equalityTolerance);
    }

    @Override
    protected void configure(final EObject configuration) {
    }

    @Override
    public double degreeOf(final Constraint constraint, final TypedEObject input, final TypedEObject objectives) {
        final double value = constraint.valueOf(input, objectives);

        return degreeOf(constraint, value);
    }

    @Override
    public String toString() {
        return "exact-measure (equality tolerance " + equalityTolerance() + ")";
    }
}
