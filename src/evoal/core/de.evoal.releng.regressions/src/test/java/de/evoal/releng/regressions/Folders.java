package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * File operations on folders that the JDK does not provide.
 */
public final class Folders {
    private Folders() {
    }

    /**
     * Deletes a folder and its content. Does nothing if the folder does not exist.
     *
     * @param folder The folder to delete.
     */
    public static void deleteRecursively(final Path folder) {
        if(!Files.exists(folder)) {
            return;
        }

        try(Stream<Path> paths = Files.walk(folder)) {
            paths.sorted(Comparator.reverseOrder())
                 .forEach(Folders::delete);
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot delete the folder " + folder, e);
        }
    }

    private static void delete(final Path path) {
        try {
            Files.delete(path);
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot delete " + path, e);
        }
    }
}
