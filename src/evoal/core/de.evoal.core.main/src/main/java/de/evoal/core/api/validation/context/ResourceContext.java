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

    /**
     * @return The file relative to the working directory, e.g. {@code File: "search.ol"}; for
     *   a file in an archive (e.g. the DL file of a plugin) its path in the archive, e.g.
     *   {@code File: "de/evoal/optimisation/ea/optimisation.dl"}.
     */
    @Override
    public String toString() {
        if (resource == null || this.resource.getURI() == null) {
            return "File: Unknown";
        }

        if (this.resource.getURI().toFileString() == null) {
            final String uri = this.resource.getURI().toString();
            final int entry = uri.lastIndexOf("!/");
            return "File: \"" + (entry < 0 ? uri : uri.substring(entry + 2)) + "\"";
        }

        final Path localDir = Paths.get(".").toAbsolutePath();
        final Path resource = Paths.get(this.resource.getURI().toFileString());

        return "File: \"" + localDir.relativize(resource).toString() + "\"";
    }
}
