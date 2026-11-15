package de.evoal.core.api.languages;

import de.evoal.core.api.dynamic.DynamicArrays;
import de.evoal.languages.model.base.definitions.*;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.List;
import java.util.function.Function;

/**
 * The attribute evaluator helps client classes to do the attribute value lookup
 *   correctly. It provides dedicated functions that a) lookup default values if
 *   the actual value is not present, and b) cast the result to the correct type.
 */
@ApplicationScoped
@Slf4j
public class AttributeEvaluator {
    /**
     * For evaluating expressions
     */
    private final ConstantEvaluator evaluator = new ConstantEvaluator();

    public boolean attributeToBoolean(final EObject instance, final String attributeName) {
        return (Boolean) attributeToObject(instance, attributeName);
    }

    public DataDescription attributeToDataDescription(final EObject instance, final String attributeName) {
        return (DataDescription) attributeToObject(instance, attributeName);
    }

    public double attributeToDouble(final EObject instance, final String attributeName) {
        return convertNumber(attributeName, NumericConversions::toDouble, attributeToNumber(instance, attributeName));
    }

    public double[] attributeToDoubleArray(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof List<?> resultList)) {
            log.error("Expression did not evaluate to a list for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final boolean allNumbers = resultList.stream()
                .allMatch(Number.class::isInstance);

        if(!allNumbers) {
            log.error("Expression did not evaluate to a list of numbers for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return resultList.stream()
                .mapToDouble(v -> convertNumber(attributeName, NumericConversions::toDouble, v))
                .toArray();
    }

    public DataDescription[] attributeToDataDescriptionArray(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof List<?> resultList)) {
            log.error("Expression did not evaluate to a list for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final boolean allDataDescriptions = resultList.stream()
                .allMatch(DataDescription.class::isInstance);

        if(!allDataDescriptions) {
            log.error("Expression did not evaluate to a list of numbers for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return resultList.stream()
                .map(DataDescription.class::cast)
                .toArray(DataDescription[]::new);
    }
    public double[][] attributeToDoubleArrayArray(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof List<?> resultList)) {
            log.error("Expression did not evaluate to a list for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final boolean allLists = resultList.stream()
                .allMatch(List.class::isInstance);

        if(!allLists) {
            log.error("Expression did not evaluate to a list of lists for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final boolean allListList = resultList.stream()
                .map(l -> (List<?>)l)
                .allMatch(l -> l.stream().allMatch(Number.class::isInstance));

        if(!allListList) {
            log.error("Expression did not evaluate to a list of numbers for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final Function<List<?>, double []> conversion = l -> l.stream()
                .mapToDouble(v -> convertNumber(attributeName, NumericConversions::toDouble, v))
                .toArray();

        return resultList.stream()
                .map(l -> (List<?>)l)
                .map(conversion)
                .toArray(double[][]::new);
    }

    /**
     * Reads an attribute whose value is a (nested) configuration, i.e., an object of the
     *   runtime model (an instance in the DSL).
     *
     * @return The configuration object.
     */
    public EObject attributeToEObject(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof EObject eObject)) {
            log.error("Expression did not evaluate to an instance for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return eObject;
    }

    /**
     * Reads an attribute whose value is an array of (nested) configurations, i.e., objects
     *   of the runtime model (instances in the DSL).
     *
     * @return The configuration objects.
     */
    public EObject [] attributeToEObjectArray(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof List<?> resultList)) {
            log.error("Expression did not evaluate to a list for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final boolean allEObjects = resultList.stream()
                .allMatch(EObject.class::isInstance);

        if(!allEObjects) {
            log.error("Expression did not evaluate to a list of instances for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return resultList.stream()
                .map(EObject.class::cast)
                .toArray(EObject[]::new);
    }

    public int attributeToInteger(final EObject instance, final String attributeName) {
        return convertNumber(attributeName, NumericConversions::toInteger, attributeToNumber(instance, attributeName));
    }

    /**
     * Converts a numeric attribute value using {@link NumericConversions}, e.g., to
     *   reject {@code 1.7} for an integer attribute instead of silently truncating it.
     */
    private static <T> T convertNumber(final String attributeName, final Function<Object, T> conversion, final Object value) {
        try {
            return conversion.apply(value);
        } catch(final IllegalArgumentException e) {
            log.error("Invalid value for attribute {}: {}", attributeName, e.getMessage());
            throw new IllegalStateException("Invalid value for attribute '" + attributeName + "': " + e.getMessage() + " Please check your configuration.", e);
        }
    }

    private Number attributeToNumber(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof Number number)) {
            log.error("Expression did not evaluate to a number value for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return number;
    }


    public String attributeToString(final EObject instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof String string)) {
            log.error("Expression did not evaluate to a string value for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return string;
    }

    private Object attributeToObject(final EObject instance, final String attributeName) {
        log.info("Attribute to object: {}", attributeName);
        final EStructuralFeature feature = instance.eClass().getEStructuralFeature(attributeName);
        final Object value = instance.eGet(feature);

        if(value == null) {
            // default values are assigned when creating the runtime object, so this is a missing required value
            log.error("No value for attribute '{}' of '{}'.", attributeName, instance.eClass().getName());
            throw new IllegalStateException("No value for attribute '" + attributeName + "' of '" + instance.eClass().getName() + "'. Please check your configuration.");
        }

        // converts array objects of multi-dimensional arrays into nested lists
        return DynamicArrays.toJava(value);
    }

    /**
     * @deprecated
     */
    public Object evaluate(final Object current) {
        if(current == null ) {
            log.info("Skipping evaluation of null value");
            return null;
        }

        if(!(current instanceof EObject)) {
            throw new IllegalArgumentException("Expression " + current.getClass().getSimpleName() + " did not evaluate to an EObject instance.");
        }

        return evaluator.doSwitch((EObject) current);
    }

    /**
     * Reads the attribute and converts it to the Java type of the given Ecore classifier,
     *   i.e., the type of the attribute's feature. Numeric values are converted using
     *   {@link NumericConversions} (element-wise for multi-valued features), booleans and
     *   strings are checked. All other values, e.g., instances, multi-dimensional arrays,
     *   data, and literals, are returned as they are (see {@link #attributeToObject}).
     *
     * @param instance The configuration to read from.
     * @param name The attribute name.
     * @param target The Ecore type of the attribute, e.g., {@code EDouble}.
     * @return The converted value.
     */
    public Object attributeToJava(final EObject instance, final String name, final EClassifier target) {
        final Class<?> targetClass = target.getInstanceClass();

        if(NumericConversions.isNumeric(target)) {
            return convertNumber(name, v -> NumericConversions.toType(v, target), attributeToObject(instance, name));
        } else if(targetClass == boolean.class || targetClass == Boolean.class) {
            return attributeToBoolean(instance, name);
        } else if(targetClass == String.class) {
            return attributeToString(instance, name);
        }

        return attributeToObject(instance, name);
    }
}
