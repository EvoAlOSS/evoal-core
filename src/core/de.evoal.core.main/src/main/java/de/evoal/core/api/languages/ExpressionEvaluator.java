package de.evoal.core.api.languages;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.base.eval.ConstantExpressionEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;
import org.eclipse.emf.ecore.EObject;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

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
    private ConstantExpressionEvaluator evaluator = new ConstantExpressionEvaluator();

    public double attributeToDouble(final Instance instance, final String attributeName) {
        final Attribute attribute = instance.findAttribute(attributeName);

        Object result = null;

        if(attribute == null) {
            log.info("Attribute binding not found. Using default value.");
            final AttributeDefinition definition = instance.getDefinition().findAttribute(attributeName);

            if(defaultValueCache.containsKey(definition)) {
                result = defaultValueCache.get(definition);
            } else {
                result = evaluator.doSwitch(definition.getInitialisation());
            }
        } else {
            result = evaluator.doSwitch(attribute.getValue());
        }

        if(!(result instanceof Number)) {
            log.error("Expression did not evaluate to a number value for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return ((Number)result).doubleValue();
    }

    public double[] attributeToDoubleArray(final Instance instance, final String attributeName) {
        throw new IllegalStateException("Not yet implemented.");
    }

    public Object attributeToObject(final Attribute attribute) {
        return evaluator.doSwitch(attribute.getValue());
    }

    public Object evaluate(final Object current) {
        return evaluator.doSwitch((EObject) current);
    }
}
