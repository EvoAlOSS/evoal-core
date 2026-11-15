package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * Finds the regression configurations of all plugins. A regression is a folder
 *   {@code src/evoal/plugins/<plugin>/src/test/regressions/<name>} that contains
 *   the file {@value Regression#CONFIGURATION_FILE}.
 */
public final class RegressionFinder {
    /**
     * The prefix of the plugin folders, left out in the names of the regressions.
     */
    private static final String PLUGIN_PREFIX = "de.evoal.";

    /**
     * The folder of the plugins, relative to the root of the repository.
     */
    private static final String PLUGINS_FOLDER = "src/evoal/plugins";

    /**
     * The folder of the regressions, relative to the plugin folder.
     */
    private static final String REGRESSIONS_FOLDER = "src/test/regressions";

    private RegressionFinder() {
    }

    /**
     * Finds the regressions of all plugins, sorted by plugin and name.
     *
     * @param root The root folder of the repository.
     * @return The regressions.
     */
    public static List<Regression> findAll(final Path root) {
        final Path pluginsFolder = root.resolve(PLUGINS_FOLDER);

        return list(pluginsFolder).stream()
                                  .filter(Files::isDirectory)
                                  .flatMap(RegressionFinder::regressionsOf)
                                  .toList();
    }

    private static boolean isRegression(final Path folder) {
        final Path configuration = folder.resolve(Regression.CONFIGURATION_FILE);

        return Files.isRegularFile(configuration);
    }

    /**
     * @return The entries of the folder, sorted by name.
     */
    private static List<Path> list(final Path folder) {
        try(Stream<Path> entries = Files.list(folder)) {
            return entries.sorted()
                          .toList();
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot list the folder " + folder, e);
        }
    }

    private static Stream<Regression> regressionsOf(final Path pluginFolder) {
        final Path regressionsFolder = pluginFolder.resolve(REGRESSIONS_FOLDER);
        if(!Files.isDirectory(regressionsFolder)) {
            return Stream.empty();
        }

        final String pluginFolderName = pluginFolder.getFileName().toString();
        final String pluginName = pluginFolderName.replaceFirst("^" + PLUGIN_PREFIX, "");

        return list(regressionsFolder).stream()
                                      .filter(RegressionFinder::isRegression)
                                      .map(folder -> toRegression(pluginName, folder));
    }

    private static Regression toRegression(final String pluginName, final Path folder) {
        final String name = pluginName + "/" + folder.getFileName();

        return new Regression(folder, name);
    }
}
