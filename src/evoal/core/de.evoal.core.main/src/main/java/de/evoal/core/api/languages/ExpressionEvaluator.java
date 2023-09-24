package de.evoal.core.api.languages;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.interpreter.ConstantExpressionEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@ApplicationScoped
@Slf4j
public class ExpressionEvaluator {
    /**
     * Map that caches default values of attributes.
     */
    private final Map<AttributeDefinition, Object> defaultValueCache = new HashMap<>();

    /**
     * For evaluating expressions
     */
    private final ConstantExpressionEvaluator evaluator = new ConstantExpressionEvaluator();

    public boolean attributeToBoolean(final Instance instance, final String attributeName) {
        return (Boolean) attributeToObject(instance, attributeName);
    }

    public double attributeToDouble(final Instance instance, final String attributeName) {
        return attributeToNumber(instance, attributeName).doubleValue();
    }

    public double[] attributeToDoubleArray(final Instance instance, final String attributeName) {
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
                .map(Number.class::cast)
                .mapToDouble(Number::doubleValue)
                .toArray();
    }

    public double[][] attributeToDoubleArrayArray(final Instance instance, final String attributeName) {
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
                .map(Number.class::cast)
                .mapToDouble(Number::doubleValue)
                .toArray();

        return resultList.stream()
                .map(l -> (List<?>)l)
                .map(conversion)
                .toArray(double[][]::new);
    }

    public Instance attributeToInstance(final Instance instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof Instance)) {
            log.error("Expression did not evaluate to an Instance for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return (Instance)result;
    }

    public int attributeToInteger(final Instance instance, final String attributeName) {
        return attributeToNumber(instance, attributeName).intValue();
    }

    private Number attributeToNumber(final Instance instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof Number number)) {
            log.error("Expression did not evaluate to a number value for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return number;
    }

    public Object attributeToObject(final Attribute attribute) {
        return evaluator.doSwitch(attribute.getValue());
    }

    public Object attributeToObject(final Instance instance, final String attributeName) {
        final Attribute attribute = instance.findAttribute(attributeName);

        Object result = null;

        if(attribute == null) {
            log.info("Attribute binding not found. Using default value.");
            final AttributeDefinition definition = instance.getDefinition().findAttribute(attributeName);

            if(defaultValueCache.containsKey(definition)) {
                result = defaultValueCache.get(definition);
            } else {
                result = evaluator.doSwitch(definition.getInitialisation());
                defaultValueCache.put(definition, result);
            }
        } else {
            result = attributeToObject(attribute);
        }

        return result;
    }

    public Object evaluate(final Object current) {
        return evaluator.doSwitch((EObject) current);
    }
}
