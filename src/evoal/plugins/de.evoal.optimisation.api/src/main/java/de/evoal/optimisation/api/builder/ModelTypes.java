package de.evoal.optimisation.api.builder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;

import de.evoal.core.api.dynamic.DynamicArrays;

/**
 * The tables the random builder of model candidates works with, computed once for the types of
 *   a search space: the concrete subtypes of every type that occurs in a model, and per concrete
 *   class
 * <ul>
 *   <li>the minimal depth of a tree with an object of the class as root, i.e. the depth its
 *     required containments (at least one element) need;</li>
 *   <li>the minimal size of such a tree (number of objects);</li>
 *   <li>the maximal depth such a tree can reach, {@link #UNBOUNDED} for recursive classes.</li>
 * </ul>
 * The minima are computed as fixpoints over the required containments. A class whose required
 *   containments never end (e.g. an expression that needs another expression without an
 *   alternative) has no finite minimal depth and cannot be built.
 * <p>
 * The tables also collect the problems that keep a model from being built (see
 *   {@link #problems()}): attributes whose values cannot be drawn, multi-valued features
 *   without upper bound, multi-dimensional arrays, non-containment references, abstract types
 *   without concrete subtype and classes that cannot terminate.
 */
public final class ModelTypes {
    /**
     * The depth or size of a tree that is not bounded (or not reachable).
     */
    public static final int UNBOUNDED = Integer.MAX_VALUE;

    /**
     * The size of a tree that cannot be built; large enough to never fit a budget, small enough
     *   to be added without overflow.
     */
    private static final long UNBOUNDED_SIZE = Long.MAX_VALUE / 4;

    /**
     * The concrete classes of a model, in the order they were found.
     */
    private final Set<EClass> classes = new LinkedHashSet<>();

    /**
     * The maximal depth of a tree per concrete class.
     */
    private final Map<EClass, Integer> maximumDepths = new HashMap<>();

    /**
     * The minimal depth of a tree per concrete class.
     */
    private final Map<EClass, Integer> minimumDepths = new HashMap<>();

    /**
     * The minimal size of a tree per concrete class.
     */
    private final Map<EClass, Long> minimumSizes = new HashMap<>();

    /**
     * The problems found, in the order they were found.
     */
    private final Set<String> problems = new LinkedHashSet<>();

    /**
     * Answers which subtypes a type has and which features are optional.
     */
    private final ModelTypeSource source;

    /**
     * The concrete subtypes per type.
     */
    private final Map<EClass, List<EClass>> subtypes = new LinkedHashMap<>();

    /**
     * Checks the values of the attributes.
     */
    private final ValueDrawer values;

    /**
     * Computes the tables for the models whose roots have the given types.
     *
     * @param source Answers which subtypes a type has and which features are optional.
     * @param values Checks the values of the attributes.
     * @param roots The types of the roots of the models.
     */
    public ModelTypes(final @NonNull ModelTypeSource source,
                      final @NonNull ValueDrawer values,
                      final @NonNull Collection<EClass> roots) {
        this.source = source;
        this.values = values;

        collectClasses(roots);
        computeMinimumDepths();
        computeMinimumSizes();
        classes.forEach(this::maximumDepthOf);
        reportClassesThatCannotTerminate();
    }

    /**
     * @return The concrete classes that a feature of the type can hold, in a fixed order.
     */
    public List<EClass> concreteSubtypesOf(final @NonNull EClass type) {
        return subtypes.computeIfAbsent(type, source::concreteSubtypesOf);
    }

    /**
     * @return {@code true} if a model has a feature that is set only with a probability.
     */
    public boolean hasOptionalFeatures() {
        return classes.stream()
                      .flatMap(eClass -> eClass.getEAllStructuralFeatures().stream())
                      .anyMatch(this::isOptional);
    }

    /**
     * @return {@code true} if the single-valued feature may stay without value.
     */
    public boolean isOptional(final @NonNull EStructuralFeature feature) {
        return !feature.isMany() && source.isOptional(feature);
    }

    /**
     * @return The largest number of elements of the feature: its upper bound for a multi-valued
     *   feature, 1 for a single-valued one.
     */
    public int maximumCount(final @NonNull EStructuralFeature feature) {
        if(!feature.isMany()) {
            return 1;
        }

        final int upper = feature.getUpperBound();

        return upper == ETypedElement.UNBOUNDED_MULTIPLICITY ? minimumCount(feature) : upper;
    }

    /**
     * @return The maximal depth of a tree with an object of the class as root;
     *   {@link #UNBOUNDED} if the class is recursive.
     */
    public int maximumDepth(final @NonNull EClass concrete) {
        return maximumDepthOf(concrete);
    }

    /**
     * @return The smallest number of elements of the feature: its lower bound for a
     *   multi-valued feature; 0 for an optional and 1 for every other single-valued feature
     *   (also one with a default value, which is searched like the others).
     */
    public int minimumCount(final @NonNull EStructuralFeature feature) {
        if(feature.isMany()) {
            return feature.getLowerBound();
        }

        return isOptional(feature) ? 0 : 1;
    }

    /**
     * @return The minimal depth of a tree with an object of the class as root;
     *   {@link #UNBOUNDED} if it cannot terminate.
     */
    public int minimumDepth(final @NonNull EClass concrete) {
        return minimumDepths.getOrDefault(concrete, UNBOUNDED);
    }

    /**
     * @return The smallest minimal depth among the concrete subtypes of the type.
     */
    public int minimumDepthOfType(final @NonNull EClass type) {
        return concreteSubtypesOf(type).stream()
                                       .mapToInt(this::minimumDepth)
                                       .min()
                                       .orElse(UNBOUNDED);
    }

    /**
     * @return The minimal size of a tree with an object of the class as root; a size larger than
     *   every budget if it cannot terminate.
     */
    public long minimumSize(final @NonNull EClass concrete) {
        return minimumSizes.getOrDefault(concrete, UNBOUNDED_SIZE);
    }

    /**
     * @return The smallest minimal size among the concrete subtypes of the type.
     */
    public long minimumSizeOfType(final @NonNull EClass type) {
        return concreteSubtypesOf(type).stream()
                                       .mapToLong(this::minimumSize)
                                       .min()
                                       .orElse(UNBOUNDED_SIZE);
    }

    /**
     * @return The problems that keep the models from being built, e.g.
     *   {@code "'Entry.label' has the type EString, for which no random value can be drawn"}.
     */
    public List<String> problems() {
        return List.copyOf(problems);
    }

    private static boolean isContainment(final EStructuralFeature feature) {
        return feature instanceof EReference reference && reference.isContainment();
    }

    private static String nameOf(final EClass eClass, final EStructuralFeature feature) {
        return eClass.getName() + "." + feature.getName();
    }

    /**
     * Collects the concrete classes reachable from the roots through containments and checks
     *   their features.
     */
    private void collectClasses(final Collection<EClass> roots) {
        final Deque<EClass> types = new ArrayDeque<>(roots);
        final Set<EClass> visitedTypes = new HashSet<>();

        while(!types.isEmpty()) {
            final EClass type = types.removeFirst();
            if(!visitedTypes.add(type)) {
                continue;
            }

            final List<EClass> concrete = concreteSubtypesOf(type);
            if(concrete.isEmpty()) {
                problems.add("the type " + type.getName() + " has no concrete subtype");
            }

            for(final EClass eClass : concrete) {
                if(classes.add(eClass)) {
                    checkFeatures(eClass);
                    types.addAll(containedTypesOf(eClass));
                }
            }
        }
    }

    private void checkFeatures(final EClass eClass) {
        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            problemOf(eClass, feature).ifPresent(problems::add);
        }
    }

    private Optional<String> problemOf(final EClass eClass, final EStructuralFeature feature) {
        final String name = nameOf(eClass, feature);

        if(feature.isMany() && feature.getUpperBound() == ETypedElement.UNBOUNDED_MULTIPLICITY) {
            return Optional.of("'" + name + "' is an array without @MaximumNumberOfElements");
        }

        if(feature instanceof EAttribute attribute) {
            return values.problemOf(attribute)
                         .map(problem -> problem.replace("'" + attribute.getName() + "'", "'" + name + "'"));
        }

        if(!isContainment(feature)) {
            return Optional.of("'" + name + "' refers to other objects, which models do not support");
        }

        final EClass target = ((EReference) feature).getEReferenceType();
        if(DynamicArrays.isArrayClass(target)) {
            return Optional.of("'" + name + "' is a multi-dimensional array, which models do not support");
        }

        return Optional.empty();
    }

    /**
     * @return The types of the containments of the class whose targets are model classes.
     */
    private List<EClass> containedTypesOf(final EClass eClass) {
        return eClass.getEAllStructuralFeatures()
                     .stream()
                     .filter(ModelTypes::isContainment)
                     .map(EReference.class::cast)
                     .map(EReference::getEReferenceType)
                     .filter(type -> !DynamicArrays.isArrayClass(type))
                     .toList();
    }

    private void computeMinimumDepths() {
        boolean changed = true;
        while(changed) {
            changed = false;
            for(final EClass eClass : classes) {
                final int depth = requiredDepthOf(eClass);
                if(depth < minimumDepth(eClass)) {
                    minimumDepths.put(eClass, depth);
                    changed = true;
                }
            }
        }
    }

    private void computeMinimumSizes() {
        boolean changed = true;
        while(changed) {
            changed = false;
            for(final EClass eClass : classes) {
                final long size = requiredSizeOf(eClass);
                if(size < minimumSize(eClass)) {
                    minimumSizes.put(eClass, size);
                    changed = true;
                }
            }
        }
    }

    /**
     * @return The depth the required containments of the class need with the current minimal
     *   depths of the classes.
     */
    private int requiredDepthOf(final EClass eClass) {
        int depth = 0;
        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            final boolean isRequiredContainment = isContainment(feature) && minimumCount(feature) > 0;
            if(!isRequiredContainment) {
                continue;
            }

            final EClass target = ((EReference) feature).getEReferenceType();
            final int childDepth = minimumDepthOfType(target);
            if(childDepth == UNBOUNDED) {
                return UNBOUNDED;
            }

            depth = Math.max(depth, childDepth + 1);
        }

        return depth;
    }

    /**
     * @return The size the class and its required containments need with the current minimal
     *   sizes of the classes.
     */
    private long requiredSizeOf(final EClass eClass) {
        long size = 1;
        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            final boolean isRequiredContainment = isContainment(feature) && minimumCount(feature) > 0;
            if(!isRequiredContainment) {
                continue;
            }

            final EClass target = ((EReference) feature).getEReferenceType();
            final long childSize = minimumSizeOfType(target);
            if(childSize >= UNBOUNDED_SIZE) {
                return UNBOUNDED_SIZE;
            }

            size = Math.min(UNBOUNDED_SIZE, size + minimumCount(feature) * childSize);
        }

        return size;
    }

    /**
     * Computes the maximal depth by a depth-first search; a class that is reached again while it
     *   is computed lies on a cycle and is unbounded.
     */
    private int maximumDepthOf(final EClass eClass) {
        return maximumDepthOf(eClass, new HashSet<>());
    }

    private int maximumDepthOf(final EClass eClass, final Set<EClass> inProgress) {
        final Integer known = maximumDepths.get(eClass);
        if(known != null) {
            return known;
        }

        if(!inProgress.add(eClass)) {
            return UNBOUNDED;
        }

        int depth = 0;
        for(final EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
            final boolean canHoldObjects = isContainment(feature) && maximumCount(feature) > 0;
            if(!canHoldObjects) {
                continue;
            }

            final EClass target = ((EReference) feature).getEReferenceType();
            if(DynamicArrays.isArrayClass(target)) {
                continue;
            }

            for(final EClass child : concreteSubtypesOf(target)) {
                final int childDepth = maximumDepthOf(child, inProgress);
                depth = childDepth == UNBOUNDED ? UNBOUNDED : Math.max(depth, childDepth + 1);
                if(depth == UNBOUNDED) {
                    break;
                }
            }

            if(depth == UNBOUNDED) {
                break;
            }
        }

        inProgress.remove(eClass);
        maximumDepths.put(eClass, depth);

        return depth;
    }

    private void reportClassesThatCannotTerminate() {
        classes.stream()
               .filter(eClass -> minimumDepth(eClass) == UNBOUNDED)
               .map(eClass -> "a model with an object of " + eClass.getName() + " cannot end: its required attributes always need further objects")
               .forEach(problems::add);
    }

    /**
     * @return The concrete classes of the models.
     */
    public List<EClass> classes() {
        return new ArrayList<>(classes);
    }
}
