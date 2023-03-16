package de.evoal.core.main.language;

import de.evoal.languages.model.utils.builtin.BuiltinProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.lang.module.ResolvedModule;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Builtin provider for Java SE module environment.
 */
@Slf4j
public class ModuleBuiltinProvider implements BuiltinProvider {
    private static Map<String, Collection<URI>> builtinCache = new HashMap<>();

    @Override
    public Collection<URI> findBuiltins(final String name) {
        Collection<URI> result = builtinCache.get(name);

        if(result != null) {
            return result;
        }

        result = ModuleLayer.boot()
                .configuration()
                .modules()
                .stream()
                .map(ResolvedModule::reference)
                .flatMap(m -> findBuiltins(m, name))
                .collect(Collectors.toList());

        log.info("Found {} builtins for {}.", result.size(), name);
        result.forEach(u -> log.info("  {}", u));
        builtinCache.put(name, result);

        return result;
    }

    private Stream<URI> findBuiltins(final ModuleReference module, final String basename) {
        final String completeBase = "META-INF/definitions/" + basename;

        try (ModuleReader reader = module.open()) {
            return reader.list()
                    .filter(f -> f.startsWith(completeBase))
                    .filter(f -> f.endsWith(".dl"))
                    .map(f -> {
                        try {
                            log.info("Found builtin {} in {}.", f, module.location().get().getPath());
                            final Path modulePath = Paths.get(module.location().get().getPath());

                            if(modulePath.toFile().isDirectory()) {
                                return modulePath.resolve(f).toUri();
                            } else {
                                final FileSystem zipFS = FileSystems.newFileSystem(modulePath);
                                final Path fileInZip = zipFS.getPath(f);

                                return fileInZip.toUri();
                            }
                        } catch (final Exception e) {
                            log.error("Unable to create URI for {} in {}.", f, module.location().get(), e);
                            return null;
                        }
                    })
                    .filter(Objects::nonNull);
        } catch (IOException ioe) {
            return Stream.<URI>builder().build();
        }
    }
}
