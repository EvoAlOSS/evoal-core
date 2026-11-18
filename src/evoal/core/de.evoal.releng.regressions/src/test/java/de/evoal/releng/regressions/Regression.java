package de.evoal.releng.regressions;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A configuration that is run and whose output is compared with references. It is
 *   either
 * <ul>
 *   <li>a regression configuration: a folder in {@code src/test/regressions} of a plugin
 *     that contains the configuration {@value #CONFIGURATION_FILE} and the files it
 *     imports. It runs with the search launcher of the release.</li>
 *   <li>an example: a folder in {@code src/main/examples} of a plugin that contains a
 *     run script ({@code 01-run-*.sh}). It runs with its own run script, as users
 *     run it.</li>
 * </ul>
 * The references of the output are in {@value #EXPECTED_FOLDER}.
 *
 * @param folder The folder of the configuration.
 * @param name The name, {@code <plugin>/<folder name>} for a regression configuration
 *   and {@code <plugin>/examples/<folder name>} for an example.
 * @param runScript The run script of an example, relative to {@link #folder()}, or
 *   {@code null} for a regression configuration.
 */
public record Regression(Path folder, String name, String runScript) {
    /**
     * The optimisation configuration of a regression configuration.
     */
    public static final String CONFIGURATION_FILE = "search.ol";

    /**
     * The folder that contains the expected output.
     */
    public static final String EXPECTED_FOLDER = "expected";

    /**
     * The target points of a regression configuration that runs as an evaluation.
     */
    public static final String TARGET_POINTS_FILE = "targets.csv";

    /**
     * Creates a regression configuration.
     */
    public static Regression configuration(final Path folder, final String name) {
        return new Regression(folder, name, null);
    }

    /**
     * Creates an example that runs with its own run script.
     */
    public static Regression example(final Path folder, final String name, final String runScript) {
        return new Regression(folder, name, runScript);
    }

    /**
     * @return The folder that contains the expected output of the regression.
     */
    public Path expectedFolder() {
        return folder.resolve(EXPECTED_FOLDER);
    }

    /**
     * @return {@code true} if this is a regression configuration with target points, which
     *   runs as an evaluation with one repetition per target point.
     */
    public boolean hasTargetPoints() {
        final Path targetPoints = folder.resolve(TARGET_POINTS_FILE);

        return !isExample() && Files.exists(targetPoints);
    }

    /**
     * @return {@code true} if this is an example that runs with its own run script.
     */
    public boolean isExample() {
        return runScript != null;
    }

    @Override
    public String toString() {
        return name;
    }
}
