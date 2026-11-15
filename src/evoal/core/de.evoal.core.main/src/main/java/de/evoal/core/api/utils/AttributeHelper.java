package de.evoal.core.api.utils;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.models.core.ecore.TypedEObject;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Helper component for doing attribute lookups. It is a slightly advanced version of
 *   {@link de.evoal.core.api.languages.AttributeEvaluator}.
 */
@ApplicationScoped
@Slf4j
public class AttributeHelper {
    /**
     * We need the attribute evaluator for the actual attribute lookup
     */
    @Inject
    private AttributeEvaluator evaluator;

    public <T> T lookup(final OptimisationModule model, final String path) {
        log.debug("Looking up '{}' in optimisation module", path);

        requirePathIsNotNull(path);

        if(path.isEmpty()) {
            return (T)model;
        }

        final List<String> splittedPath = new LinkedList<>(Arrays.asList(path.split("\\.")));
        final String firstPath = splittedPath.get(0);
        splittedPath.remove(0);

        if("problem".equals(firstPath)) {
            ProblemInstance problem = model.getProblem();

            if(problem == null) {
                problem = model.getAlgorithm().getProblem();
            }

            return lookup(problem, splittedPath);
        } else if("algorithm".equals(firstPath)) {
            return lookup(model.getAlgorithm(), splittedPath);
        }

        log.error("Cannot lookup path '{}' in optimisation module.", path);
        throw new IllegalArgumentException("Invalid path '" + path + "' for optimisation model.");
    }

    private <T> T lookup(final ProblemInstance problem, final List<String> path) {
        log.debug("Looking up '{}':", path);

        if(path.isEmpty()) {
            return (T)problem;
        }

        Object value = null;
        switch (path.get(0)) {
            case "name":
                value = problem.getName();
                path.remove(0);
                break;
            case "documentation":
                value = evaluator.evaluate(problem.getDocumentation());
                path.remove(0);
                break;
            case "instance":
                path.remove(0);
            default:
                value = problem;
        }

        if(path.isEmpty()) {
            return (T)value;
        }

        if(value instanceof TypedEObject eObject) {
            return lookup(eObject, path);
        }

        log.error("Lookup did not result in an instance: {}", value);
        throw new IllegalStateException("Lookup resulted in a non-instance: " + value);

    }

    private <T> T lookup(final AlgorithmInstance algorithm, final List<String> path) {
        if(path.isEmpty()) {
            return (T)algorithm;
        }

        Object value = null;
        switch (path.get(0)) {
            case "problem":
                value = algorithm.getProblem();
                path.remove(0);
                break;
            case "documentation":
                value = evaluator.evaluate(algorithm.getDocumentation());
                path.remove(0);
                break;
            case "instance":
                path.remove(0);
            default:
                value = algorithm;
        }

        if(path.isEmpty()) {
            return (T)value;
        }

        if(value instanceof TypedEObject eObject) {
            return lookup(eObject, path);
        }

        log.error("Lookup did not result in an instance: {}", value);
        throw new IllegalStateException("Lookup resulted in a non-instance: " + value);
    }

    /**
     * Looks up the attribute reachable by following the given path.
     *
     * @param instance The instance to use.
     * @param path A attribute path, such as "name" or "attribute1.name".
     * @return The found value or the default value if no value is present.
     *
     * @param <T> The type of the target value.
     */
    public <T> T lookup(final EObject instance, final String path) {
        requirePathIsNotNull(path);

        if(path.isEmpty()) {
            return (T)instance;
        }

        return lookup(instance, Arrays.asList(path.split("\\.")));
    }

    private <T> T lookup(final EObject instance, final List<String> path) {
        log.debug("Looking up '{}':", path);

        requirePathIsNotNull(path);

        if(path.isEmpty()) {
            return (T)instance;
        }

        Object current = instance;

        for(final String part : path) {
            try {
                if(current == null) {
                    log.error("Unable to select child on null value.");
                    throw new IllegalStateException("Unable to select child on null value.");
                } else if(!(current instanceof EObject)) {
                    log.error("Failed to lookup part '{}' of path '{}' in '{}'.", part, path, current);
                    throw new IllegalStateException("Configuration is not valid.");
                }

                final EObject currentAsEObject = (EObject)current;

                if("name".equals(part)) {
                    current = currentAsEObject.eClass().getName();
                } else {
                    final EStructuralFeature definition = currentAsEObject.eClass().getEStructuralFeature(part);

                    if(definition == null) {
                        log.warn("Failed to lookup part '{}' of path '{}'. Returning null.", part, path);
                        log.warn("Current instance is: {}", ((EObject) current).eClass().getName());
                        log.warn("Available attributes:");
                        for(final EStructuralFeature f : ((EObject) current).eClass().getEAllStructuralFeatures()) {
                            log.warn("  {}",f.getName());
                        }

                        log.error("Selecting non-existing path '{}'.", path);
                        throw new IllegalStateException("Selecting non-existing field: " + part);
                    }

                    current = evaluator.attributeToJava(currentAsEObject, part, definition.getEType());
                }
            } catch(final NullPointerException e) {
                log.error("Failed to lookup part '{}' of path '{}'.", part, path);
                throw e;
            }
        }

        log.debug("Mapping '{}' to '{}'.", path, current);
        return (T) current;
    }

    private void requirePathIsNotNull(final Object path) {
        if(path == null) {
            log.warn("Asking for a null-path.");
            throw new IllegalArgumentException("Path is not allowed to be null");
        }
    }
}
