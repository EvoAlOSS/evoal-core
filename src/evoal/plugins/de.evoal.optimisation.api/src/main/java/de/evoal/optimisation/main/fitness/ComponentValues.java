package de.evoal.optimisation.main.fitness;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;

/**
 * Reads a value per fitness component from an array of {@code 'variable'} instances
 *   ({@code var}: the objective, {@code val}: the value), as used by the configured fitness
 *   steps. A component is identified by the name of its objective.
 */
final class ComponentValues {
    private ComponentValues() {
    }

    /**
     * @param attributes Looks up the attributes.
     * @param evaluator Evaluates the values.
     * @param configuration The configuration of the step.
     * @param attributeName The name of the array of {@code 'variable'} instances.
     * @return The value of each listed component, in the order of the configuration.
     * @throws IllegalArgumentException if a component is listed more than once.
     */
    static Map<String, Double> read(final AttributeHelper attributes,
                                    final AttributeEvaluator evaluator,
                                    final EObject configuration,
                                    final String attributeName) {
        final List<EObject> variables = attributes.lookup(configuration, attributeName);
        final Map<String, Double> values = new LinkedHashMap<>();

        for(final EObject variable : variables) {
            final EStructuralFeature objective = attributes.lookup(variable, "var");
            final String name = objective.getName();
            final double value = evaluator.attributeToDouble(variable, "val");
            final Double previous = values.put(name, value);

            if(previous != null) {
                throw new IllegalArgumentException("The objective '" + name + "' is listed more than once in '"
                                                   + attributeName + "'.");
            }
        }

        return values;
    }
}
