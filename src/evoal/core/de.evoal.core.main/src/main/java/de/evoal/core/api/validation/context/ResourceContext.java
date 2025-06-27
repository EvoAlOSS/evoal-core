package de.evoal.core.api.validation.context;

import lombok.NonNull;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceContext extends DiagnosticsContext {
    protected final Resource resource;

    public ResourceContext(final @NonNull Resource resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        final Path localDir = Paths.get(".").toAbsolutePath();
        final Path resource = Paths.get(this.resource.getURI().toFileString());

        return "File: \"" + localDir.relativize(resource).toString() + "\"";
    }
}
