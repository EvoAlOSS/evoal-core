package de.evoal.core.api.validation.context;

import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

public class EObjectContext extends DiagnosticsContext {
    @Getter
    private final EObject object;

    private final String path;
    private final DiagnosticsContext context;

    public EObjectContext(final @NonNull DiagnosticsContext context, final String path, final @NonNull EObject object) {
        this.context = context;
        this.path = path;
        this.object = object;
    }

    public EObjectContext(final @NonNull EObjectContext context, final String subpath) {
        this.context = context.context;
        this.path = context.path + "." + subpath;
        this.object = context.object;
    }

    public String toString() {
        return context.toString() + " Path: \"" + path + "\"";
    }
}
