package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

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
 * The references of the output are in {@value #EXPECTED_FOLDER}. The optional file
 *   {@value #SETTINGS_FILE} sets the {@linkplain #tolerance() tolerance} of the comparison.
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
     * The optional settings of a regression, e.g. {@code tolerance = 1e-12}.
     */
    public static final String SETTINGS_FILE = "regression.properties";

    /**
     * The setting for the relative tolerance of numbers.
     */
    private static final String TOLERANCE_SETTING = "tolerance";

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
     * The relative tolerance for numbers in the comparison with the references, from the
     *   setting {@code tolerance} in {@value #SETTINGS_FILE}. It is meant for regressions
     *   whose results depend on the platform, e.g. because they use native numeric
     *   libraries; the file states the reason in a comment.
     *
     * @return The tolerance, 0 (exact comparison) if the setting is missing.
     * @throws IllegalStateException if the setting is no number or negative.
     */
    public double tolerance() {
        final Properties settings = readSettings();
        final String value = settings.getProperty(TOLERANCE_SETTING, "0");
        final double tolerance = parseTolerance(value);

        // also rejects NaN
        if(!(tolerance >= 0.0)) {
            throw new IllegalStateException("The tolerance of " + name + " must not be negative, but is " + value + ".");
        }

        return tolerance;
    }

    private double parseTolerance(final String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch(final NumberFormatException e) {
            throw new IllegalStateException("The tolerance of " + name + " is no number: '" + value + "'.", e);
        }
    }

    private Properties readSettings() {
        final Properties settings = new Properties();
        final Path settingsFile = folder.resolve(SETTINGS_FILE);

        if(!Files.exists(settingsFile)) {
            return settings;
        }

        try(Reader reader = Files.newBufferedReader(settingsFile, StandardCharsets.UTF_8)) {
            settings.load(reader);
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot read " + settingsFile, e);
        }

        return settings;
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
