package de.evoal.releng.regressions;

import java.nio.file.Path;

/**
 * A regression configuration: a folder in {@code src/test/regressions} of a plugin
 *   that contains the configuration {@value #CONFIGURATION_FILE}, the files it
 *   imports and the references of its output in {@value #EXPECTED_FOLDER}.
 *
 * @param folder The folder of the regression configuration.
 * @param name The name of the regression, {@code <plugin>/<folder name>}.
 */
public record Regression(Path folder, String name) {
    /**
     * The optimisation configuration that is run.
     */
    public static final String CONFIGURATION_FILE = "search.ol";

    /**
     * The folder that contains the expected output.
     */
    public static final String EXPECTED_FOLDER = "expected";

    /**
     * @return The folder that contains the expected output of the regression.
     */
    public Path expectedFolder() {
        return folder.resolve(EXPECTED_FOLDER);
    }

    @Override
    public String toString() {
        return name;
    }
}
