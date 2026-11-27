package de.evoal.optimisation.api.builder;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Measures and navigates the tree of a model candidate with the reflective EMF API. The root has
 *   depth 0, a contained object one more than its container; the depth of a model is the depth of
 *   its deepest object and its size the number of its objects (Poli, Langdon and McPhee 2008,
 *   sec. 2.2, for programs).
 */
public final class ModelTrees {
    private ModelTrees() {
    }

    /**
     * @return The depth of the object below the root: 0 for the root.
     * @throws IllegalArgumentException if the object does not belong to the tree of the root.
     */
    public static int depthOf(final @NonNull EObject object, final @NonNull EObject root) {
        int depth = 0;
        for(EObject current = object; current != root; current = current.eContainer()) {
            if(current == null) {
                throw new IllegalArgumentException("The object does not belong to the tree of the root.");
            }
            ++depth;
        }

        return depth;
    }

    /**
     * @return The depth of the deepest object below the object, relative to it: 0 for a leaf.
     */
    public static int height(final @NonNull EObject object) {
        int height = 0;
        for(final EObject child : object.eContents()) {
            height = Math.max(height, 1 + height(child));
        }

        return height;
    }

    /**
     * @return Whether the object contains other objects.
     */
    public static boolean isInner(final @NonNull EObject object) {
        return !object.eContents().isEmpty();
    }

    /**
     * @return The objects of the tree in pre-order: the root, then its contents in the order of
     *   {@code eAllContents} (the containments in the order of the class's features, their
     *   elements in list order).
     */
    public static List<EObject> objects(final @NonNull EObject root) {
        final List<EObject> objects = new ArrayList<>();
        objects.add(root);
        root.eAllContents().forEachRemaining(objects::add);

        return objects;
    }

    /**
     * Puts the replacement into the place of a contained object: the same containment and, for
     *   a multi-valued containment, the same position.
     *
     * @throws IllegalArgumentException if the object has no container.
     */
    public static void replace(final @NonNull EObject object, final @NonNull EObject replacement) {
        if(object.eContainer() == null) {
            throw new IllegalArgumentException("A root has no place in a container.");
        }

        EcoreUtil.replace(object, replacement);
    }

    /**
     * @return The number of objects of the tree.
     */
    public static int size(final @NonNull EObject root) {
        int size = 1;
        for(final EObject child : root.eContents()) {
            size += size(child);
        }

        return size;
    }

    /**
     * @param object A contained object.
     * @return The type that the place of the object requires: the type of its containment.
     */
    public static EClass typeOfPlace(final @NonNull EObject object) {
        final EReference containment = object.eContainmentFeature();
        if(containment == null) {
            throw new IllegalArgumentException("A root has no place in a container.");
        }

        return containment.getEReferenceType();
    }
}
