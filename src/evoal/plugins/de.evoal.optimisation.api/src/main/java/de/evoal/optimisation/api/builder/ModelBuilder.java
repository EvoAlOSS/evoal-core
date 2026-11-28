package de.evoal.optimisation.api.builder;

import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

import lombok.NonNull;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.optimisation.api.builder.TreeMethod.Plan;
import de.evoal.optimisation.api.builder.TreeMethod.Shape;

/**
 * Builds random model candidates: trees of objects whose classes are given by the
 *   {@link ModelTypes}. The tree of a candidate follows the shape and the depth limit of its
 *   {@link Plan} (full or grow; Koza 1992; Poli, Langdon and McPhee 2008, sec. 2.2) and the size
 *   limit of the {@link BuildSettings}. The root has depth 0, a contained object one more than its
 *   container; the size is the number of objects.
 * <p>
 * The features of an object ({@link ModelFeatures}) are filled in the order of
 *   {@code getEAllStructuralFeatures}:
 * <ul>
 *   <li>an attribute gets a value of the {@link ValueDrawer}, a multi-valued one a number of
 *     values drawn uniformly within its multiplicity;</li>
 *   <li>an optional feature gets a value with the optional probability (grow), an optional
 *     containment always (full);</li>
 *   <li>a containment first gets its required elements, then a number of further ones drawn
 *     uniformly within its multiplicity (full: at least one if the depth limit can be
 *     reached); each element is an object of a concrete subtype drawn uniformly among the
 *     subtypes that fit the depth limit and the size limit (full: among those that can reach
 *     the depth limit, if there are any).</li>
 * </ul>
 * The size limit is kept by reserving the minimal size of every required object before the
 *   optional ones are drawn. If no subtype fits both limits, the depth limit wins and the
 *   smallest fitting subtype is taken, so the tree may exceed the size limit; the checks of the
 *   run ({@code 'maximum-size'}) catch it.
 */
public final class ModelBuilder {
    /**
     * Draws the values of the attributes.
     */
    private final ValueDrawer values;

    /**
     * The source of the random numbers.
     */
    private final RandomGenerator randomness;

    /**
     * The method, the size limit and the optional probability.
     */
    private final BuildSettings settings;

    /**
     * The classes of the models and their tables.
     */
    private final ModelTypes types;

    /**
     * @param types The classes of the models and their tables.
     * @param values Draws the values of the attributes.
     * @param settings The method, the size limit and the optional probability.
     * @param randomness The source of the random numbers.
     */
    public ModelBuilder(final @NonNull ModelTypes types,
                        final @NonNull ValueDrawer values,
                        final @NonNull BuildSettings settings,
                        final @NonNull RandomGenerator randomness) {
        this.types = types;
        this.values = values;
        this.settings = settings;
        this.randomness = randomness;
    }

    /**
     * Builds the model of a candidate.
     *
     * @param rootType The type of the root, e.g. the type of the structured data.
     * @param index The number of the candidate in its stream; it selects the plan of the method.
     * @return The root of the model.
     */
    public EObject build(final @NonNull EClass rootType, final int index) {
        final Plan plan = settings.method().planFor(index);

        return build(rootType, 0, plan, settings.maximumSize());
    }

    /**
     * Builds a tree whose root has the given depth, e.g. a new subtree of an existing model.
     *
     * @param type The type of the root of the tree.
     * @param depth The depth of the root of the tree in its model.
     * @param plan The shape and the depth limit; the depth limit counts from the root of the model.
     * @param sizeLimit The largest number of objects of the tree.
     * @return The root of the tree.
     */
    public EObject build(final @NonNull EClass type, final int depth, final @NonNull Plan plan, final long sizeLimit) {
        final Budget budget = new Budget(sizeLimit);
        final List<EClass> candidates = fittingSubtypes(type, depth, plan, budget.free());
        final EClass chosen = choose(candidates, type, depth, plan);

        budget.reserve(types.minimumSize(chosen));

        return buildObject(chosen, depth, plan, budget);
    }

    /**
     * Creates a builder of minimal trees ({@link #buildMinimal}): no optional feature gets a
     *   value and arrays get only their required elements.
     *
     * @param types The classes of the models and their tables.
     * @param values Draws the values of the attributes.
     * @param randomness The source of the random numbers.
     */
    public static ModelBuilder minimal(final @NonNull ModelTypes types,
                                       final @NonNull ValueDrawer values,
                                       final @NonNull RandomGenerator randomness) {
        final BuildSettings settings = new BuildSettings(new TreeMethod.Grow(0), BuildSettings.NO_SIZE_LIMIT, 0.0);

        return new ModelBuilder(types, values, settings, randomness);
    }

    /**
     * Builds a tree of the smallest size that fits the depth limit, e.g. to repair a model that
     *   exceeds a limit. The subtype is drawn uniformly among the smallest ones that fit the
     *   depth limit; only required features get values (with the optional probability 0 of
     *   {@link #minimal}).
     *
     * @param type The type of the root of the tree.
     * @param depth The depth of the root of the tree in its model.
     * @param depthLimit The largest depth of an object, counted from the root of the model.
     * @return The root of the tree.
     */
    public EObject buildMinimal(final @NonNull EClass type, final int depth, final int depthLimit) {
        final Plan plan = new Plan(Shape.GROW, depthLimit);

        return build(type, depth, plan, types.minimumSizeOfType(type));
    }

    private static <T> boolean hasSingleChoice(final List<T> choices) {
        return choices.size() == 1;
    }

    /**
     * Fills the attribute with a value, a multi-valued one with a number of values.
     */
    private void buildAttribute(final EObject object, final EAttribute attribute) {
        if(attribute.isMany()) {
            final int count = drawCount(types.minimumCount(attribute), types.maximumCount(attribute));
            @SuppressWarnings("unchecked")
            final List<Object> elements = (List<Object>) object.eGet(attribute);
            for(int i = 0; i < count; i++) {
                final Object value = values.draw(attribute, randomness);
                elements.add(value);
            }

            return;
        }

        if(types.isOptional(attribute) && !drawsOptional()) {
            return;
        }

        final Object value = values.draw(attribute, randomness);
        object.eSet(attribute, value);
    }

    /**
     * Fills the containment with its required elements and a number of further ones.
     */
    private void buildContainment(final EObject object, final EReference containment, final int depth, final Plan plan, final Budget budget) {
        final EClass type = containment.getEReferenceType();
        final int childDepth = depth + 1;
        final int required = types.minimumCount(containment);
        final int count = drawElementCount(containment, childDepth, plan, budget);

        for(int i = 0; i < count; i++) {
            final boolean isRequired = i < required;
            if(isRequired) {
                // the minimal size of a required element was reserved with its container
                budget.release(types.minimumSizeOfType(type));
            }

            final List<EClass> candidates = fittingSubtypes(type, childDepth, plan, budget.free());
            if(candidates.isEmpty() && !isRequired) {
                break;
            }

            final EClass chosen = choose(candidates, type, childDepth, plan);
            budget.reserve(types.minimumSize(chosen));

            final EObject child = buildObject(chosen, childDepth, plan, budget);
            addChild(object, containment, child);
        }
    }

    private static void addChild(final EObject object, final EReference containment, final EObject child) {
        if(containment.isMany()) {
            @SuppressWarnings("unchecked")
            final List<EObject> children = (List<EObject>) object.eGet(containment);
            children.add(child);
        } else {
            object.eSet(containment, child);
        }
    }

    /**
     * Creates an object of the concrete class and fills its features. The minimal size of the
     *   object is reserved in the budget.
     */
    private EObject buildObject(final EClass concrete, final int depth, final Plan plan, final Budget budget) {
        final EObject object = EcoreUtil.create(concrete);
        budget.use();

        for(final EStructuralFeature feature : ModelFeatures.of(concrete)) {
            if(feature instanceof EAttribute attribute) {
                buildAttribute(object, attribute);
            } else {
                buildContainment(object, (EReference) feature, depth, plan, budget);
            }
        }

        return object;
    }

    /**
     * @return {@code true} if a subtype of the type can still reach the depth limit from the depth.
     */
    private boolean canReachLimit(final EClass type, final int depth, final Plan plan) {
        final int remaining = plan.depthLimit() - depth;

        return types.concreteSubtypesOf(type)
                    .stream()
                    .anyMatch(candidate -> reaches(candidate, remaining));
    }

    /**
     * Chooses a class uniformly among the candidates; full prefers the candidates that can reach
     *   the depth limit, else the deepest ones. Without candidate that fits the size limit, the
     *   smallest class that fits the depth limit is taken.
     */
    private EClass choose(final List<EClass> candidates, final EClass type, final int depth, final Plan plan) {
        if(candidates.isEmpty()) {
            return smallestFittingDepth(type, depth, plan);
        }

        final List<EClass> preferred = plan.shape() == Shape.FULL ? deepest(candidates, plan.depthLimit() - depth) : candidates;
        if(hasSingleChoice(preferred)) {
            return preferred.getFirst();
        }

        final int index = randomness.nextInt(preferred.size());

        return preferred.get(index);
    }

    /**
     * @return The candidates that can reach the remaining depth; if there are none, those with
     *   the largest maximal depth.
     */
    private List<EClass> deepest(final List<EClass> candidates, final int remaining) {
        final List<EClass> reaching = candidates.stream()
                                                .filter(candidate -> reaches(candidate, remaining))
                                                .toList();
        if(!reaching.isEmpty()) {
            return reaching;
        }

        final int largest = candidates.stream()
                                      .mapToInt(types::maximumDepth)
                                      .max()
                                      .orElse(0);

        return candidates.stream()
                         .filter(candidate -> types.maximumDepth(candidate) == largest)
                         .toList();
    }

    /**
     * @return A number drawn uniformly from {@code [minimum, maximum]}.
     */
    private int drawCount(final int minimum, final int maximum) {
        if(minimum >= maximum) {
            return minimum;
        }

        return randomness.nextInt(minimum, maximum + 1);
    }

    /**
     * @return The number of elements of the containment: the required ones plus further ones as
     *   long as the depth limit allows objects below; an optional single containment is set with
     *   the optional probability (grow) or always (full).
     */
    private int drawElementCount(final EReference containment, final int childDepth, final Plan plan, final Budget budget) {
        final int required = types.minimumCount(containment);
        final EClass type = containment.getEReferenceType();
        final boolean fitsDepth = childDepth + types.minimumDepthOfType(type) <= plan.depthLimit();
        final boolean fitsSize = types.minimumSizeOfType(type) <= budget.free();
        if(!fitsDepth || !fitsSize) {
            return required;
        }

        if(types.isOptional(containment)) {
            final boolean isSet = plan.shape() == Shape.FULL || drawsOptional();

            return isSet ? 1 : 0;
        }

        final boolean fillsUp = plan.shape() == Shape.FULL && canReachLimit(type, childDepth, plan);
        final int minimum = fillsUp ? Math.max(required, 1) : required;
        final int maximum = Math.max(minimum, types.maximumCount(containment));

        return drawCount(minimum, maximum);
    }

    /**
     * @return {@code true} if an optional feature gets a value.
     */
    private boolean drawsOptional() {
        return randomness.nextDouble() < settings.optionalProbability();
    }

    /**
     * @return The concrete subtypes of the type whose minimal trees fit the depth limit and the
     *   free size, in the order of the type tables.
     */
    private List<EClass> fittingSubtypes(final EClass type, final int depth, final Plan plan, final long freeSize) {
        return types.concreteSubtypesOf(type)
                    .stream()
                    .filter(candidate -> depth + types.minimumDepth(candidate) <= plan.depthLimit())
                    .filter(candidate -> types.minimumSize(candidate) <= freeSize)
                    .toList();
    }

    /**
     * @return {@code true} if a tree with an object of the class as root can be as deep as the
     *   remaining depth.
     */
    private boolean reaches(final EClass candidate, final int remaining) {
        return types.maximumDepth(candidate) >= remaining;
    }

    /**
     * @return The concrete subtype of the type with the smallest minimal size among those that
     *   fit the depth limit; with none, the one with the smallest minimal depth.
     */
    private EClass smallestFittingDepth(final EClass type, final int depth, final Plan plan) {
        final List<EClass> subtypes = types.concreteSubtypesOf(type);
        final List<EClass> fittingDepth = subtypes.stream()
                                                  .filter(candidate -> depth + types.minimumDepth(candidate) <= plan.depthLimit())
                                                  .toList();
        if(fittingDepth.isEmpty()) {
            return subtypes.stream()
                           .min(Comparator.comparingInt(types::minimumDepth))
                           .orElseThrow(() -> new IllegalStateException("The type " + type.getName() + " has no concrete subtype."));
        }

        return fittingDepth.stream()
                           .min(Comparator.comparingLong(types::minimumSize))
                           .orElseThrow();
    }

    /**
     * The size budget of one tree: the objects already built ({@code used}) and the minimal size
     *   of the required objects not built yet ({@code reserved}).
     */
    private static final class Budget {
        private final long limit;
        private long reserved;
        private long used;

        private Budget(final long limit) {
            this.limit = limit;
        }

        /**
         * @return The number of objects that can still be added beyond the reserved ones.
         */
        private long free() {
            return Math.max(0, limit - used - reserved);
        }

        /**
         * Gives back the reservation of a required object that is built now.
         */
        private void release(final long size) {
            reserved = Math.max(0, reserved - size);
        }

        /**
         * Reserves the minimal size of an object that is built now (the object and its required
         *   containments).
         */
        private void reserve(final long size) {
            reserved += size;
        }

        /**
         * Turns the reservation of the object being created into a used object; its required
         *   containments stay reserved until they are built.
         */
        private void use() {
            reserved = Math.max(0, reserved - 1);
            used += 1;
        }
    }
}
