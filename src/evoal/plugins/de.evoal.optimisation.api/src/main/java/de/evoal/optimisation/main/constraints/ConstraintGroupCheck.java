package de.evoal.optimisation.main.constraints;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.constraints.Constraints;

/**
 * Checks the constraint groups of an optimisation configuration when it is loaded:
 * <ul>
 *   <li>every constraint of the DDL can be compiled;</li>
 *   <li>every group that the algorithm configuration names is declared in the DDL; otherwise
 *     the configuration is rejected;</li>
 *   <li>every group of the DDL is handled by the algorithm configuration; otherwise a warning
 *     is reported, because the constraints of the group are measured, but have no effect.</li>
 * </ul>
 * By convention, every DL type that handles a constraint group names it in a string attribute
 *   {@value #GROUP}; the check collects these attributes from all instances of the
 *   algorithm configuration.
 */
@ApplicationScoped
@Slf4j
public class ConstraintGroupCheck {
    /**
     * The name of the attribute with the constraint group of a handling.
     */
    public static final String GROUP = "group";

    @Inject
    private ConstraintCompiler compiler;

    /**
     * Checks the configuration.
     *
     * @param configuration The runtime model of the configuration.
     * @throws IllegalArgumentException if a constraint cannot be compiled or the algorithm
     *   names a group the DDL does not declare.
     */
    public void check(final OptimisationModule configuration) {
        final Problem problem = configuration.getProblem();
        final Constraints constraints = compiler.compile(problem);
        final EObject algorithm = configuration.getAlgorithm();
        final Set<String> handled = handledGroups(algorithm);

        check(constraints, handled);
    }

    /**
     * @param constraints The constraints of the problem.
     * @param handled The groups the algorithm configuration names.
     * @throws IllegalArgumentException if a handled group is not declared.
     */
    static void check(final Constraints constraints, final Set<String> handled) {
        final List<String> undeclared = handled.stream()
                                               .filter(group -> !constraints.hasGroup(group))
                                               .toList();
        if(!undeclared.isEmpty()) {
            throw new IllegalArgumentException("The configuration names the constraint groups " + undeclared
                                               + ", but the DDL declares only " + constraints.groups() + ".");
        }

        final List<String> unhandled = constraints.groups()
                                                  .stream()
                                                  .filter(group -> !handled.contains(group))
                                                  .toList();
        if(!unhandled.isEmpty()) {
            log.warn("The constraint groups {} are measured, but nothing handles them: they have no effect on the "
                     + "search. Use 'constraint-check', 'constraint-penalty', 'feasibility-comparator', "
                     + "'epsilon-comparator', 'nsga2-selection' or 'stochastic-ranking-selection'.", unhandled);
        }
    }

    /**
     * @param algorithm The algorithm configuration.
     * @return The values of all {@value #GROUP} attributes of the configuration and of all
     *   instances it refers to, in the order in which they are found.
     */
    static Set<String> handledGroups(final EObject algorithm) {
        final Set<String> groups = new LinkedHashSet<>();
        final Set<EObject> visited = Collections.newSetFromMap(new IdentityHashMap<>());
        final Deque<EObject> pending = new ArrayDeque<>();
        pending.add(algorithm);

        while(!pending.isEmpty()) {
            final EObject current = pending.removeFirst();
            if(!visited.add(current)) {
                continue;
            }

            for(final EStructuralFeature feature : current.eClass().getEAllStructuralFeatures()) {
                if(!current.eIsSet(feature)) {
                    continue;
                }

                final Object value = current.eGet(feature);
                final boolean isGroup = GROUP.equals(feature.getName()) && value instanceof String;
                if(isGroup) {
                    groups.add((String) value);
                }

                collectInstances(value, pending);
            }
        }

        return groups;
    }

    /**
     * Adds the configuration instances of an attribute value to the pending instances. Model
     *   elements of Ecore (e.g., the features of {@code data} attributes) are no configuration
     *   instances and are skipped.
     */
    private static void collectInstances(final Object value, final Deque<EObject> pending) {
        if(value instanceof List<?> elements) {
            elements.forEach(element -> collectInstances(element, pending));
        } else if(value instanceof EObject instance && !(instance instanceof EModelElement)) {
            pending.addLast(instance);
        }
    }
}
