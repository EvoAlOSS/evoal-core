package de.evoal.core.api.utils;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.languages.model.base.*;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.ProblemInstance;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Helper component for processing instances.
 */
@ApplicationScoped
@Slf4j
public class LanguageHelper {
    @Inject
    private ExpressionEvaluator evaluator;

    public <T> T lookup(final OptimisationModule model, final String path) {
        log.debug("Locking up '{}':", path);

        if(path == null) {
            log.warn("Asking for a null-path.");
            throw new IllegalArgumentException("Path is not allowed to be null");
        } else if(path.isEmpty()) {
            return (T)model;
        }

        final List<String> splittedPath = new LinkedList<>(Arrays.asList(path.split("\\.")));

        if("problem".equals(splittedPath.get(0))) {
            splittedPath.remove(0);

            ProblemInstance problem = model.getProblem();

            if(problem == null) {
                problem = model.getAlgorithm().getProblem();
            }

            return lookup(problem, splittedPath);
        } else if("algorithm".equals(splittedPath.get(0))) {
            splittedPath.remove(0);
            return lookup(model.getAlgorithm(), splittedPath);
        }

        log.error("Cannot lookup path '{}'.", path);
        throw new IllegalArgumentException("Invalid path '" + path + "' for optimisation model.");
    }

    private <T> T lookup(final ProblemInstance problem, final List<String> path) {
        log.debug("Locking up '{}':", path);

        if(path.size() == 0) {
            return (T)problem;
        }

        Object value = null;
        switch (path.get(0)) {
                case "name":
                    value = problem.getName();
                    path.remove(0);
                    break;
                case "documentation":
                    value = problem.getDocumentation();
                    path.remove(0);
                    break;
                case "instance":
                    path.remove(0);
                default:
                    value = problem;
        }

        if(path.size() == 0) {
            return (T)value;
        }

        if(!(value instanceof Instance)) {
            log.error("Lookup did not result in an instance: {}", value);
            throw new IllegalStateException("Lookup resulted in a non-instance: " + value);
        }

        return lookup((Instance)value, path);
    }

    private <T> T lookup(final AlgorithmInstance algorithm, final List<String> path) {
        log.debug("Locking up '{}':", path);

        if(path.size() == 0) {
            return (T)algorithm;
        }

        Object value = null;
        switch (path.get(0)) {
            case "problem":
                value = algorithm.getProblem();
                path.remove(0);
                break;
            case "documentation":
                value = algorithm.getDocumentation();
                path.remove(0);
                break;
            case "instance":
                path.remove(0);
            default:
                value = algorithm;
        }

        if(path.size() == 0) {
            return (T)value;
        }

        if(!(value instanceof Instance)) {
            log.error("Lookup did not result in an instance: {}", value);
            throw new IllegalStateException("Lookup resulted in a non-instance: " + value);
        }

        return lookup((Instance)value, path);
    }

    public <T> T lookup(final Instance instance, final String path) {
        if(path == null) {
            log.warn("Asking for a null-path.");
            throw new IllegalArgumentException("Path is not allowed to be null");
        } else if(path.isEmpty()) {
            return (T)instance;
        }

        return lookup(instance, Arrays.asList(path.split("\\.")));
    }

    private <T> T lookup(final Instance instance, final List<String> path) {
        log.debug("Locking up '{}':", path);

        if(path == null) {
            log.warn("Asking for a null-path.");
            throw new IllegalArgumentException("Path is not allowed to be null");
        } else if(path.isEmpty()) {
            return (T)instance;
        }

        Object current = instance;

        for(final String part : path) {
            try {
                if(current == null) {
                    log.error("Unable to select child on null value.");
                    throw new IllegalStateException("Unable to select child on null value.");
                } else if(!(current instanceof Instance)) {
                    log.error("Failed to lookup part '{}' of path '{}' in '{}'.", part, path, current);
                    throw new IllegalStateException("Configuration is not valid.");
                }

                final Attribute attribute = ((Instance)current).findAttribute(part);

                if(attribute != null) {
                    current = attribute.getValue();
                } else if("name".equals(part)) {
                    current = ((Instance)current).getDefinition().getName();
                } else {
                    log.warn("Failed to lookup part '{}' of path '{}'. Returning null.", part, path);
                    log.warn("Current instance is: {}", ((Instance) current).getDefinition().getName());
                    log.warn("Available attributes:");
                    for(final Attribute a : ((Instance) current).getAttributes()) {
                        log.warn("  {}", a.getDefinition().getName());
                    }

                    log.error("Selecting non-existing path '{}'.", path);
                    throw new IllegalStateException("Selecting non-existing field: " + part);
                }
                if(attribute != null) {
                    current = convertToJava(current, attribute.getDefinition().getType());
                }
            } catch(final NullPointerException e) {
                log.error("Failed to lookup part '{}' of path '{}'.", part, path);
                throw e;
            }
        }

        if(current instanceof Instance) {
            log.debug("Mapping '{}' to instance with name '{}'.", path, ((Instance)current).getDefinition().getName());
        } else {
            log.debug("Mapping '{}' to '{}'.", path, current);
        }
        return (T) current;
    }

    private Object convertToJava(final Object current, final Type type) {
        log.info("Converting " + current +  " to " + type);

        if((type instanceof InstanceType || type instanceof DataType) && current instanceof OrExpression) {
            return evaluator.evaluate(current);
        } else if(type instanceof LiteralType) {
            return readExpression(current, type);
        } else if(type instanceof ArrayType) {
            return readArray(current, type);
        }

        return current;
    }

    private Object readArray(final Object current, final Type type) {
        final List<Object> array = (List<Object>)evaluator.evaluate(current);

        return array.stream()
                    .map(current1 -> convertToJava(current1, ((ArrayType)type).getElements()))
                    .toArray();
    }

    private Object readExpression(final Object current, final Type type) {
        return evaluator.evaluate(current);
    }

    public static Predicate<? super Value> filterInstanceByType(final String instanceTypeName) {
        return i -> instanceTypeName.equals(((Instance)i).getDefinition().getName());
    }

    public Predicate<? super Instance> filterByAttributesInstanceType(final String attributeName, final String attributeTypeName) {
        return i -> attributeTypeName.equals(evaluator.attributeToInstance(i, attributeName).getDefinition().getName());
    }
}
