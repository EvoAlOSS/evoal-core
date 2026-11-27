package de.evoal.optimisation.api.builder;

import java.util.List;

import lombok.NonNull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * The minimal-subtree repair of a model that exceeds a depth or size limit (the reaction
 *   {@code repair} of {@code 'maximum-depth'} and {@code 'maximum-size'}). It replaces the parts
 *   that exceed the limit by minimal subtrees of the {@link ModelBuilder#minimal minimal builder}
 *   and keeps the rest of the model. The repair is EvoAl's own: the literature on size and depth
 *   limits returns a parent, gives the offspring the worst fitness or retries the operation (Poli,
 *   Langdon and McPhee 2008, sec. 11.3.2). Apart from the attribute values of the new objects,
 *   which the builder draws, the repair is deterministic.
 */
public final class LimitRepairs {
    /**
     * The depth limit of the minimal subtrees of the size repair: their depth is not limited.
     */
    private static final int NO_DEPTH_LIMIT = Integer.MAX_VALUE / 2;

    private LimitRepairs() {
    }

    /**
     * Repairs a model deeper than the limit, in place. In pre-order, an object whose subtree is
     *   too deep stays if a tree of its class fits the limit, and its contents are repaired;
     *   otherwise it is replaced by a minimal subtree that fits the limit. A replacement keeps
     *   the place and so the element counts. A content of a kept object whose place cannot fit
     *   at all is removed: an optional object or an array element above the minimal count.
     *
     * @param root The root of the model; its tree is changed.
     * @param limit The largest depth of an object.
     * @param types The tables of the classes.
     * @param minimal Builds the minimal subtrees.
     * @return Whether the model fits the limit afterwards; {@code false} if the class of the root
     *   or the type of a place cannot fit.
     */
    public static boolean repairDepth(final @NonNull EObject root, final int limit, final @NonNull ModelTypes types,
                                      final @NonNull ModelBuilder minimal) {
        if(types.minimumDepth(root.eClass()) > limit) {
            return false;
        }

        return repairDepth(root, 0, limit, types, minimal);
    }

    private static boolean repairDepth(final EObject object, final int depth, final int limit, final ModelTypes types,
                                       final ModelBuilder minimal) {
        if(depth + ModelTrees.height(object) <= limit) {
            return true;
        }

        if(object.eContainer() != null && depth + types.minimumDepth(object.eClass()) > limit) {
            final EObject replacement = minimal.buildMinimal(ModelTrees.typeOfPlace(object), depth, limit);
            ModelTrees.replace(object, replacement);

            return depth + ModelTrees.height(replacement) <= limit;
        }

        boolean fits = true;
        for(final EObject child : List.copyOf(object.eContents())) {
            final boolean placeCanFit = depth + 1 + types.minimumDepthOfType(ModelTrees.typeOfPlace(child)) <= limit;
            if(placeCanFit) {
                fits &= repairDepth(child, depth + 1, limit, types, minimal);
            } else if(isRemovable(child, types) || isOptional(child, types)) {
                remove(child);
            } else {
                fits = false;
            }
        }

        return fits;
    }

    /**
     * Repairs a model larger than the limit, in place. As long as the model is too large, one
     *   change is applied: the removal of an element of a multi-valued containment above its
     *   minimal count, or the replacement of a subtree by a minimal subtree of its place. If a
     *   change saves at least the excess, the one that saves the least is applied, otherwise the
     *   one that saves the most; ties are decided by the pre-order of the objects, a removal
     *   before a replacement of the same object.
     *
     * @param root The root of the model; its tree is changed.
     * @param limit The largest number of objects.
     * @param types The tables of the classes.
     * @param minimal Builds the minimal subtrees.
     * @return Whether the model fits the limit afterwards; {@code false} if no change is left.
     */
    public static boolean repairSize(final @NonNull EObject root, final long limit, final @NonNull ModelTypes types,
                                     final @NonNull ModelBuilder minimal) {
        long size = ModelTrees.size(root);

        while(size > limit) {
            final long excess = size - limit;
            final Change change = chooseChange(root, excess, types);
            if(change == null) {
                return false;
            }

            if(change.removal()) {
                remove(change.object());
            } else {
                final int depth = ModelTrees.depthOf(change.object(), root);
                final EObject replacement = minimal.buildMinimal(ModelTrees.typeOfPlace(change.object()), depth, NO_DEPTH_LIMIT);
                ModelTrees.replace(change.object(), replacement);
            }

            size = ModelTrees.size(root);
        }

        return true;
    }

    /**
     * @return The change to apply, {@code null} if there is none.
     */
    private static Change chooseChange(final EObject root, final long excess, final ModelTypes types) {
        Change smallestSufficient = null;
        Change largest = null;

        for(final EObject object : ModelTrees.objects(root)) {
            if(object == root) {
                continue;
            }

            final long subtreeSize = ModelTrees.size(object);
            final EClass place = ModelTrees.typeOfPlace(object);
            final Change[] changes = {
                    isRemovable(object, types) ? new Change(object, true, subtreeSize) : null,
                    new Change(object, false, subtreeSize - types.minimumSizeOfType(place))
            };

            for(final Change change : changes) {
                if(change == null || change.saving() <= 0) {
                    continue;
                }

                if(change.saving() >= excess && (smallestSufficient == null || change.saving() < smallestSufficient.saving())) {
                    smallestSufficient = change;
                }
                if(largest == null || change.saving() > largest.saving()) {
                    largest = change;
                }
            }
        }

        return smallestSufficient != null ? smallestSufficient : largest;
    }

    /**
     * @return Whether the object is an element of a multi-valued containment above its minimal
     *   count.
     */
    private static boolean isRemovable(final EObject object, final ModelTypes types) {
        final EReference containment = object.eContainmentFeature();
        if(!containment.isMany()) {
            return false;
        }

        final int count = ((List<?>) object.eContainer().eGet(containment)).size();

        return count > types.minimumCount(containment);
    }

    /**
     * @return Whether the object is the value of an optional single-valued containment.
     */
    private static boolean isOptional(final EObject object, final ModelTypes types) {
        final EReference containment = object.eContainmentFeature();

        return !containment.isMany() && types.isOptional(containment);
    }

    private static void remove(final EObject object) {
        final EReference containment = object.eContainmentFeature();
        if(!containment.isMany()) {
            object.eContainer().eUnset(containment);
            return;
        }

        final List<?> elements = (List<?>) object.eContainer().eGet(containment);
        elements.remove(object);
    }

    /**
     * A change of the size repair.
     *
     * @param object The object that is removed or whose subtree is replaced.
     * @param removal Whether the object is removed; otherwise its subtree is replaced.
     * @param saving The number of objects the change saves.
     */
    private record Change(EObject object, boolean removal, long saving) {
    }
}
