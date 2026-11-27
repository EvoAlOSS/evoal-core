package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

/**
 * Runs every regression configuration against the assembled release and compares
 *   its output with the references. Examples run their scripts; an example without
 *   references is a smoke test whose scripts only have to succeed.
 * <p>
 * The runs start in parallel on {@code evoal.regressions.parallelism} workers when the
 *   tests are created; every test waits for the result of its run. The output of a run
 *   does not depend on the parallelism, since every run has its own folder and process.
 * <p>
 * System properties:
 * <ul>
 *   <li>{@code evoal.regressions.root}: root folder of the repository (required).</li>
 *   <li>{@code evoal.regressions.update}: {@code true} rewrites the references
 *     instead of comparing against them.</li>
 *   <li>{@code evoal.regressions.examples}: {@code true} also runs the examples
 *     (see {@link RegressionFinder}).</li>
 *   <li>{@code evoal.regressions.repetitions}: number of runs per regression
 *     (default 1); all runs must give the same output.</li>
 *   <li>{@code evoal.regressions.shell}: shell for the launcher (default {@code bash}).</li>
 *   <li>{@code evoal.regressions.threads}: number of threads that evaluate the candidates
 *     (default 1); the output does not depend on it.</li>
 *   <li>{@code evoal.regressions.parallelism}: number of regressions that run at the same
 *     time (default 1).</li>
 *   <li>{@code evoal.regressions.agent}: Java agent for the runs (set by JaCoCo).</li>
 *   <li>{@code evoal.regressions.vm-options}: further JVM options of the runs, e.g.
 *     {@code -XX:ActiveProcessorCount=2} so that parallel runs fit the CPUs of a CI job.</li>
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
     * Number of regressions that run at the same time.
     */
    private final int parallelism;

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
     * Also runs the examples.
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
        final String vmOptions = System.getProperty("evoal.regressions.vm-options", "");

        this.root = Path.of(rootName);

        final Path release = root.resolve(RELEASE_FOLDER);
        this.runner = new RegressionRunner(release, shell, agent, threads, vmOptions);
        this.update = Boolean.getBoolean("evoal.regressions.update");
        this.withExamples = Boolean.getBoolean("evoal.regressions.examples");
        this.repetitions = Integer.getInteger("evoal.regressions.repetitions", 1);
        this.parallelism = Integer.getInteger("evoal.regressions.parallelism", 1);
    }

    /**
     * Waits for the check of a regression and rethrows its failure.
     */
    private static void await(final Future<?> check) throws Throwable {
        try {
            check.get();
        } catch(final ExecutionException e) {
            throw e.getCause();
        }
    }

    /**
     * Compares the output with the references, or rewrites them in update mode. A run with
     *   references that writes no output fails in both modes and leaves the references
     *   unchanged (#358). A smoke test runs once and is not compared.
     */
    private void check(final Regression regression) throws InterruptedException {
        final Path workingFolder = workingFolderOf(regression);

        if(!regression.hasReferences()) {
            runner.run(regression, workingFolder.resolve("run-1"));
            return;
        }

        final Path outputFolder = runRepeatedly(regression, workingFolder);
        final Path expectedFolder = regression.expectedFolder();

        Assertions.assertTrue(OutputComparison.hasOutput(outputFolder), () -> "The regression " + regression
                + " wrote no output to " + outputFolder + "; " + expectedFolder + " is left unchanged.");

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
     * Starts the runs and creates one test per regression configuration and example.
     */
    @TestFactory
    public Stream<DynamicTest> outputMatchesTheReferences() {
        final List<Regression> regressions = RegressionFinder.findAll(root);
        final Path absoluteRoot = root.toAbsolutePath();
        Assertions.assertFalse(regressions.isEmpty(), "No regressions found below " + absoluteRoot);

        final List<Regression> examples = withExamples ? RegressionFinder.findExamples(root) : List.of();
        final List<Regression> all = Stream.concat(regressions.stream(), examples.stream())
                                           .toList();

        final ExecutorService workers = Executors.newFixedThreadPool(parallelism);
        final List<Future<?>> checks = all.stream()
                                          .<Future<?>>map(regression -> workers.submit(() -> {
                                              check(regression);
                                              return null;
                                          }))
                                          .toList();
        workers.shutdown();

        return Stream.iterate(0, index -> index < all.size(), index -> index + 1)
                     .map(index -> toTest(all.get(index), checks.get(index)));
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

    private static DynamicTest toTest(final Regression regression, final Future<?> check) {
        return DynamicTest.dynamicTest(regression.name(), () -> await(check));
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
