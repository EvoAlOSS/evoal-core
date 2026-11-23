package de.evoal.core.main.credits;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * The jars of the installation: the modules of the boot layer (core.main, its libraries and the
 *   plugins with theirs), shared by the credits and the provenance of an execution.
 */
public final class InstalledJars {
    private InstalledJars() {
    }

    /**
     * A jar of the boot layer.
     *
     * @param file The jar.
     * @param module The name of its Java module.
     * @param version The version of its Java module, empty if it has none.
     */
    public record InstalledJar(Path file, String module, Optional<String> version) {
    }

    /**
     * @return The folder of core.main's jar.
     */
    public static Path coreFolder() {
        try {
            final URI location = InstalledJars.class.getProtectionDomain()
                                                    .getCodeSource()
                                                    .getLocation()
                                                    .toURI();

            return Path.of(location)
                       .getParent();
        } catch(final URISyntaxException e) {
            throw new IllegalStateException("Cannot find the jar of core.main.", e);
        }
    }

    /**
     * @return The jars of the boot layer's modules, sorted by path.
     */
    public static List<Path> moduleJars() {
        return bootLayerJars().stream()
                              .map(InstalledJar::file)
                              .toList();
    }

    /**
     * @return The jars of the boot layer's modules with their module names and versions, sorted
     *   by path.
     */
    public static List<InstalledJar> bootLayerJars() {
        return ModuleLayer.boot()
                          .configuration()
                          .modules()
                          .stream()
                          .flatMap(module -> module.reference()
                                                   .location()
                                                   .filter(location -> "file".equals(location.getScheme()))
                                                   .map(Path::of)
                                                   .filter(Files::isRegularFile)
                                                   .filter(path -> path.getFileName().toString().endsWith(".jar"))
                                                   .map(path -> new InstalledJar(path, module.name(),
                                                                                 module.reference().descriptor().rawVersion()))
                                                   .stream())
                          .sorted(Comparator.comparing(InstalledJar::file))
                          .toList();
    }
}
