package de.evoal.core.api.utils;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import lombok.extern.slf4j.Slf4j;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class VariableToEObjectHelper {
    @Inject
    protected AttributeHelper helper;

    /**
     * Creates an object of the given space from a list of {@code variable} instances
     *   ({@code var} references the feature, {@code val} contains the value).
     *
     * Variables whose feature is not part of the space are ignored with a warning, since
     *   a list may contain additional values, e.g., known values of the optimisation space.
     *
     * @throws IllegalArgumentException iff not all features of the space receive a value.
     */
    public TypedEObject fromVariables(final List<EObject> variablesList, final Space specification) {
        final TypedEObject result = specification.newEObject();

        // track the set features ourselves, since eIsSet returns false for default values (e.g. 0.0)
        final Set<EStructuralFeature> setFeatures = new HashSet<>();

        for(final EObject variable : variablesList) {
            final EStructuralFeature feature = helper.lookup(variable, "var");
            final Object val = helper.lookup(variable, "val");

            if(feature == null || !specification.contains(feature)) {
                log.warn("Ignoring variable '{}' since it is not part of the space {}.",
                         feature == null ? "<unresolved>" : feature.getName(),
                         specification);
                continue;
            }

            if(!setFeatures.add(feature)) {
                log.warn("Variable '{}' is specified more than once. Using the last value.", feature.getName());
            }

            try {
                // numeric values get the type of the feature, e.g., 1 for a real feature becomes 1.0
                result.eSet(feature, NumericConversions.toType(val, feature.getEType()));
            } catch(final IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid value for variable '" + feature.getName() + "': " + e.getMessage(), e);
            }
        }

        final List<String> missing = specification.stream()
                                                  .filter(f -> !setFeatures.contains(f))
                                                  .map(EStructuralFeature::getName)
                                                  .toList();

        Requirements.requireTrue(missing.isEmpty(), "No value specified for the variable(s) " + missing + " of the space " + specification + ".");

        return result;
    }

    public TypedEObject fromCandidate(final EObject candidate, final Space specification) {
        //receives candidate, turns to properties
        final List<EObject> sv = helper.lookup(candidate, "values");

        return fromVariables(sv, specification);
    }
}