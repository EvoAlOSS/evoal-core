package de.evoal.optimisation.api.constraints;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * The normal form g of a constraint that is affine in the search features:
 *   g(x) = sum of coefficient(f) * x(f) + constant.
 *
 * @param coefficients The coefficient of every search feature with a coefficient other than 0,
 *   in the order of their first use in the constraint.
 * @param constant The constant term.
 */
public record LinearForm(Map<EStructuralFeature, Double> coefficients, double constant) {
    /**
     * Copies the coefficients and keeps their order.
     */
    public LinearForm {
        coefficients = Collections.unmodifiableMap(new LinkedHashMap<>(coefficients));
    }
}
