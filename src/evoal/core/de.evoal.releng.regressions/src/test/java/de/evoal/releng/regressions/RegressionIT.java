package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Runs every regression configuration against the assembled release and compares
 *   its output with the references.
 * <p>
 * System properties:
 * <ul>
 *   <li>{@code evoal.regressions.root}: root folder of the repository (required).</li>
 *   <li>{@code evoal.regressions.update}: {@code true} rewrites the references
 *     instead of comparing against them.</li>
 *   <li>{@code evoal.regressions.examples}: {@code true} also checks the examples
 *     that have references (see {@link RegressionFinder}).</li>
 *   <li>{@code evoal.regressions.repetitions}: number of runs per regression
 *     (default 1); all runs must give the same output.</li>
 *   <li>{@code evoal.regressions.shell}: shell for the launcher (default {@code bash}).</li>
 *   <li>{@code evoal.regressions.threads}: number of threads that evaluate the candidates
 *     (default 1); the output does not depend on it.</li>
 *   <li>{@code evoal.regressions.agent}: Java agent for the runs (set by JaCoCo).</li>
 * </ul>
 */
public class RegressionIT {
    /**
     * The release folder, relative to the root of the repository.
     */
    private static final String RELEASE_FOLDER = "evoal";

    /**
     * The working folders of the runs, kept for inspection.
     */
    private static final Path WORKING_FOLDER = Path.of("target", "regressions");

    /**
     * Number of runs per regression. All runs must give the same output.
     */
    private final int repetitions;

    /**
     * The root folder of the repository.
     */
    private final Path root;

    private final RegressionRunner runner;

    /**
     * Rewrites the references instead of comparing against them.
     */
    private final boolean update;

    /**
     * Also checks the examples that have references (nightly pipeline).
     */
    private final boolean withExamples;

    /**
     * Creates the test from the system properties.
     */
    public RegressionIT() {
        final String rootName = System.getProperty("evoal.regressions.root", "../../../..");
        final String shell = System.getProperty("evoal.regressions.shell", "bash");
        final String agent = System.getProperty("evoal.regressions.agent", "");
        final int threads = Integer.getInteger("evoal.regressions.threads", 1);

        this.root = Path.of(rootName);

        final Path release = root.resolve(RELEASE_FOLDER);
        this.runner = new RegressionRunner(release, shell, agent, threads);
        this.update = Boolean.getBoolean("evoal.regressions.update");
        this.withExamples = Boolean.getBoolean("evoal.regressions.examples");
        this.repetitions = Integer.getInteger("evoal.regressions.repetitions", 1);
    }

    /**
     * Compares the output with the references, or rewrites them in update mode.
     */
    private void check(final Regression regression) throws InterruptedException {
        final Path workingFolder = workingFolderOf(regression);
        final Path outputFolder = runRepeatedly(regression, workingFolder);
        final Path expectedFolder = regression.expectedFolder();

        if(update) {
            OutputComparison.replace(expectedFolder, outputFolder);
            return;
        }

        final boolean hasReferences = Files.isDirectory(expectedFolder);
        Assertions.assertTrue(hasReferences, "The regression " + regression + " has no references in "
                + expectedFolder + ". Create them with -Devoal.regressions.update=true.");

        final double tolerance = regression.tolerance();
        final List<String> differences = OutputComparison.differences(expectedFolder, outputFolder, tolerance);
        Assertions.assertTrue(differences.isEmpty(), () -> String.join("\n", differences));
    }

    /**
     * Creates one test per regression configuration.
     */
    @TestFactory
    public Stream<DynamicTest> outputMatchesTheReferences() {
        final List<Regression> regressions = RegressionFinder.findAll(root);
        final Path absoluteRoot = root.toAbsolutePath();
        Assertions.assertFalse(regressions.isEmpty(), "No regressions found below " + absoluteRoot);

        final List<Regression> examples = withExamples ? RegressionFinder.findExamples(root) : List.of();

        return Stream.concat(regressions.stream(), examples.stream())
                     .map(this::toTest);
    }

    /**
     * Runs the regression {@link #repetitions} times, each run in its own folder
     *   {@code run-<n>}, and checks that all runs give the same output.
     *
     * @return The output folder of the first run.
     */
    private Path runRepeatedly(final Regression regression, final Path workingFolder) throws InterruptedException {
        final Path firstRunFolder = workingFolder.resolve("run-1");
        final Path firstOutput = runner.run(regression, firstRunFolder);

        for(int run = 2; run <= repetitions; ++run) {
            final Path runFolder = workingFolder.resolve("run-" + run);
            final Path output = runner.run(regression, runFolder);
            final List<String> differences = OutputComparison.differences(firstOutput, output);
            final String message = "Run " + run + " differs from run 1:\n" + String.join("\n", differences);

            Assertions.assertTrue(differences.isEmpty(), message);
        }

        return firstOutput;
    }

    private DynamicTest toTest(final Regression regression) {
        return DynamicTest.dynamicTest(regression.name(), () -> check(regression));
    }

    /**
     * @return A new, empty working folder for the regression.
     */
    private static Path workingFolderOf(final Regression regression) {
        final Path workingFolder = WORKING_FOLDER.resolve(regression.name());

        Folders.deleteRecursively(workingFolder);

        try {
            Files.createDirectories(workingFolder);
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot create the working folder " + workingFolder, e);
        }

        return workingFolder;
    }
}
