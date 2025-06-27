package de.evoal.core.api.validation.context;

import lombok.Getter;
import lombok.NonNull;
import org.eclipse.emf.ecore.resource.Resource;

public class XtextResourceContext extends ResourceContext {

    @Getter
    private final int line;

    @Getter
    private final int column;

    public XtextResourceContext(final @NonNull Resource resource, final int line, final int column) {
        super(resource);

        this.line = line;
        this.column = column;
    }

    public String toString() {
        return resource.getURI().toString() + ":" + line + ":" + column;
    }
}
