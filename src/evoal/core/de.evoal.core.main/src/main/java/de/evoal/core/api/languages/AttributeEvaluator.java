package de.evoal.core.api.languages;

import de.evoal.languages.model.base.*;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * Map that caches default values of attributes.
     */
    private final Map<AttributeDefinition, Object> defaultValueCache = new HashMap<>();

    /**
     * For evaluating expressions
     */
    private final ConstantEvaluator evaluator = new ConstantEvaluator();

    public boolean attributeToBoolean(final Instance instance, final String attributeName) {
        return (Boolean) attributeToObject(instance, attributeName);
    }

    public DataDescription attributeToDataDescription(final Instance instance, final String attributeName) {
        return (DataDescription) attributeToObject(instance, attributeName);
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

    public DataDescription[] attributeToDataDescriptionArray(final Instance instance, final String attributeName) {
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

    public Instance [] attributeToInstanceArray(final Instance instance, final String attributeName) {
        final Object result = attributeToObject(instance, attributeName);

        if(!(result instanceof List<?> resultList)) {
            log.error("Expression did not evaluate to a list for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        final boolean allInstances = resultList.stream()
                .allMatch(Instance.class::isInstance);

        if(!allInstances) {
            log.error("Expression did not evaluate to a list of instances for attribute {} which was expected.", attributeName);
            throw new IllegalStateException("Expression evaluation error. Please check your configuration.");
        }

        return resultList.stream()
                .map(Instance.class::cast)
                .toArray(Instance[]::new);
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

    /**
     * @deprecated
     */
    public Object attributeToObject(final Attribute attribute) {
        return evaluator.doSwitch(attribute.getValue());
    }

    private Object attributeToObject(final Instance instance, final String attributeName) {
        log.info("Attribute to object: {}", attributeName);
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

    public Object attributeToJava(final Instance instance, final String name, final Type target) {
        if(target instanceof RealType) {
            return attributeToDouble(instance, name);
        } else if(target instanceof IntType) {
            return attributeToInteger(instance, name);
        } else if(target instanceof BooleanType) {
            return attributeToBoolean(instance, name);
        } else if(target instanceof InstanceType) {
            return attributeToInstance(instance, name);
        } else if(target instanceof ArrayType aType) {
            return attributeToObject(instance, name);
        } else {
            log.warn("Converting type {} by using Object.", target.eClass().getName());
            return attributeToObject(instance, name);
        }
    }

    private Object attributeToList(final Object current, final Type type) {
        final List<Object> array = (List<Object>)evaluate(current);

        return array.stream()
                .map(current1 -> convertToJava(current1, ((ArrayType)type).getElements()))
                .toArray();
    }

    private Object convertToJava(final Object current, final Type type) {
        log.info("Converting {} to {}", current, type);

        if((type instanceof InstanceType || type instanceof DataType) && current instanceof OrExpression) {
            return evaluate(current);
        } else if(type instanceof LiteralType) {
            if(!(current instanceof EObject)) {
                log.info("Current is not an EObject, returning value.");
                return current;
            }

            return readExpression(current, type);
        } else if(type instanceof ArrayType) {
            return readArray(current, type);
        }

        return current;
    }

    private Object readArray(final Object current, final Type type) {
        final List<Object> array = (List<Object>)evaluate(current);

        return array.stream()
                .map(current1 -> convertToJava(current1, ((ArrayType)type).getElements()))
                .toArray();
    }

    private Object readExpression(final Object current, final Type type) {
        return evaluate(current);
    }
}
