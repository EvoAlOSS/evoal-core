package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * Finds the regression configurations and the checked examples of all plugins.
 * <ul>
 *   <li>A regression configuration is a folder
 *     {@code src/evoal/plugins/<plugin>/src/test/regressions/<name>} that contains
 *     the file {@value Regression#CONFIGURATION_FILE}.</li>
 *   <li>A checked example is a folder {@code src/evoal/plugins/<plugin>/src/main/examples/<name>}
 *     that contains the folder {@value Regression#EXPECTED_FOLDER} and exactly one run
 *     script {@code 01-run-*.sh}. Examples without references are not checked.</li>
 * </ul>
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

    /**
     * The folder of the examples, relative to the plugin folder.
     */
    private static final String EXAMPLES_FOLDER = "src/main/examples";

    /**
     * The pattern of the run script of an example.
     */
    private static final String RUN_SCRIPT_PATTERN = "01-run-.*\\.sh";

    private RegressionFinder() {
    }

    /**
     * Finds the regression configurations of all plugins, sorted by plugin and name.
     *
     * @param root The root folder of the repository.
     * @return The regressions.
     */
    public static List<Regression> findAll(final Path root) {
        return pluginFolders(root).flatMap(RegressionFinder::regressionsOf)
                                  .toList();
    }

    /**
     * Finds the checked examples of all plugins, sorted by plugin and name.
     *
     * @param root The root folder of the repository.
     * @return The examples.
     * @throws IllegalStateException if an example with references has no or several run scripts.
     */
    public static List<Regression> findExamples(final Path root) {
        return pluginFolders(root).flatMap(RegressionFinder::examplesOf)
                                  .toList();
    }

    private static boolean isRegression(final Path folder) {
        final Path configuration = folder.resolve(Regression.CONFIGURATION_FILE);

        return Files.isRegularFile(configuration);
    }

    private static boolean isCheckedExample(final Path folder) {
        final Path expectedFolder = folder.resolve(Regression.EXPECTED_FOLDER);

        return Files.isDirectory(expectedFolder);
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

    private static Stream<Path> pluginFolders(final Path root) {
        final Path pluginsFolder = root.resolve(PLUGINS_FOLDER);

        return list(pluginsFolder).stream()
                                  .filter(Files::isDirectory);
    }

    private static String pluginNameOf(final Path pluginFolder) {
        final String pluginFolderName = pluginFolder.getFileName().toString();

        return pluginFolderName.replaceFirst("^" + PLUGIN_PREFIX, "");
    }

    private static Stream<Regression> regressionsOf(final Path pluginFolder) {
        final Path regressionsFolder = pluginFolder.resolve(REGRESSIONS_FOLDER);
        if(!Files.isDirectory(regressionsFolder)) {
            return Stream.empty();
        }

        final String pluginName = pluginNameOf(pluginFolder);

        return list(regressionsFolder).stream()
                                      .filter(RegressionFinder::isRegression)
                                      .map(folder -> Regression.configuration(folder, pluginName + "/" + folder.getFileName()));
    }

    private static Stream<Regression> examplesOf(final Path pluginFolder) {
        final Path examplesFolder = pluginFolder.resolve(EXAMPLES_FOLDER);
        if(!Files.isDirectory(examplesFolder)) {
            return Stream.empty();
        }

        final String pluginName = pluginNameOf(pluginFolder);

        return list(examplesFolder).stream()
                                   .filter(Files::isDirectory)
                                   .filter(RegressionFinder::isCheckedExample)
                                   .map(folder -> toExample(pluginName, folder));
    }

    private static Regression toExample(final String pluginName, final Path folder) {
        final List<String> runScripts = list(folder).stream()
                                                    .map(path -> path.getFileName().toString())
                                                    .filter(name -> name.matches(RUN_SCRIPT_PATTERN))
                                                    .toList();

        if(runScripts.size() != 1) {
            throw new IllegalStateException("The example " + folder + " needs exactly one run script 01-run-*.sh, found "
                    + runScripts + ".");
        }

        final String name = pluginName + "/examples/" + folder.getFileName();

        return Regression.example(folder, name, runScripts.getFirst());
    }
}
