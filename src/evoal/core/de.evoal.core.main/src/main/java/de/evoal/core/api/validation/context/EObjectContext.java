package de.evoal.core.api.validation.context;

import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class EObjectContext extends DiagnosticsContext {
    @Getter
    private final EObject object;

    private final String path;

    @Getter
    private final DiagnosticsContext context;

    public EObjectContext(final @NonNull DiagnosticsContext context, final String path, final @NonNull EObject object) {
        this.context = context;
        this.path = path;
        this.object = object;
    }

    public EObjectContext(final @NonNull EObjectContext context, final String subpath) {
        this.context = context.context;
        this.path = context.path.isEmpty() ? subpath : (context.path + "." + subpath);
        this.object = context.object;
    }

    public EObjectContext parent() {
        String parentPath = "";
        EObject parent = object.eContainer();

        if(path.contains(".")) {
            parentPath = path.substring(0, path.lastIndexOf('.'));
        } else {
            parentPath = "";
        }

        return new EObjectContext(context, parentPath, parent);
    }

    public EObjectContext child(final String name) {
        return new EObjectContext((EObjectContext) context, name);
    }

    public EObjectContext child(final String name, final EObject object) {
        String p = path.isEmpty() ? name : (path + "." + name);
        return new EObjectContext(context, p, object);
    }

    /**
     * @return The file, the line of the object (if it was parsed) and the path, e.g.
     *   {@code File: "search.ol" Line: 12 Path: "algorithm.mutation.probability"}.
     */
    public String toString() {
        final INode node = NodeModelUtils.findActualNodeFor(object);
        final String line = node == null ? "" : " Line: " + node.getStartLine();

        return context.toString() + line + " Path: \"" + path + "\"";
    }
}
