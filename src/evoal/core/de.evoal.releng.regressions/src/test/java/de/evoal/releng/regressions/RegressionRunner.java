package de.evoal.releng.regressions;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Runs a regression configuration with the search launcher of the release
 *   ({@code bin/evoal-search.sh}) and a fixed seed. A configuration with target points
 *   ({@value Regression#TARGET_POINTS_FILE}) runs as an evaluation with one repetition
 *   per target point ({@code bin/evoal-evaluate-search.sh}). The run takes place in a
 *   copy of the configuration folder, so the run does not change the repository.
 */
public final class RegressionRunner {
    /**
     * The number of repetitions per target point of a configuration with target points.
     */
    private static final String EVALUATION_REPETITIONS = "1";

    /**
     * The evaluation launcher, relative to the release folder.
     */
    private static final String EVALUATION_SCRIPT = "bin/evoal-evaluate-search.sh";

    /**
     * The log of the run, next to the copied configuration.
     */
    public static final String LOG_FILE = "run.log";

    /**
     * The output folder of the run, relative to the working folder.
     */
    public static final String OUTPUT_FOLDER = "output";

    /**
     * The search launcher, relative to the release folder.
     */
    private static final String SEARCH_SCRIPT = "bin/evoal-search.sh";

    /**
     * The seed of every run.
     */
    private static final String SEED = "42";

    /**
     * Number of lines of the log that are shown when a run fails.
     */
    private static final int SHOWN_LOG_LINES = 30;

    /**
     * Maximum duration of a run in minutes.
     */
    private static final long TIMEOUT_IN_MINUTES = 10;

    /**
     * Java agent for the runs (e.g., JaCoCo), empty for none.
     */
    private final String agent;

    /**
     * The folder of the assembled release.
     */
    private final Path release;

    /**
     * The shell that executes the launcher (bash or zsh).
     */
    private final String shell;

    /**
     * Creates a runner for regressions.
     *
     * @param release The folder of the assembled release.
     * @param shell The shell that executes the launcher.
     * @param agent The Java agent for the runs, empty for none.
     */
    public RegressionRunner(final Path release, final String shell, final String agent) {
        this.release = release;
        this.shell = shell;
        this.agent = agent;
    }

    /**
     * Runs a regression.
     *
     * @param regression The regression to run.
     * @param workingFolder An empty folder for the run.
     * @return The output folder of the run.
     * @throws IllegalStateException if the run fails or does not finish in time.
     */
    public Path run(final Regression regression, final Path workingFolder) throws InterruptedException {
        copyConfiguration(regression.folder(), workingFolder);

        final Path logFile = workingFolder.resolve(LOG_FILE);
        final Process process = start(regression, workingFolder, logFile);
        final boolean finished = process.waitFor(TIMEOUT_IN_MINUTES, TimeUnit.MINUTES);

        if(!finished) {
            process.destroyForcibly();
            throw new IllegalStateException("The regression " + regression + " did not finish within "
                    + TIMEOUT_IN_MINUTES + " minutes. Log: " + logFile);
        }

        final int exitCode = process.exitValue();
        if(exitCode != 0) {
            final String logTail = tailOf(logFile);
            throw new IllegalStateException("The regression " + regression + " failed with exit code " + exitCode
                    + ". Log: " + logFile + "\n" + logTail);
        }

        return workingFolder.resolve(OUTPUT_FOLDER);
    }

    /**
     * Copies the configuration folder without the references.
     */
    private static void copyConfiguration(final Path configurationFolder, final Path workingFolder) {
        final Path expectedFolder = configurationFolder.resolve(Regression.EXPECTED_FOLDER);

        try(Stream<Path> paths = Files.walk(configurationFolder)) {
            paths.filter(path -> !path.startsWith(expectedFolder))
                 .forEach(path -> copyInto(configurationFolder, path, workingFolder));
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot copy the configuration " + configurationFolder, e);
        }
    }

    private static void copyInto(final Path sourceFolder, final Path source, final Path targetFolder) {
        final Path relativePath = sourceFolder.relativize(source);
        final Path target = targetFolder.resolve(relativePath);

        try {
            if(Files.isDirectory(source)) {
                Files.createDirectories(target);
            } else {
                Files.copy(source, target);
            }
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot copy " + source + " to " + target, e);
        }
    }

    /**
     * @return The command that runs the regression: the run script of an example, the
     *   evaluation launcher for a regression configuration with target points, or the
     *   search launcher of the release for other regression configurations.
     */
    private List<String> commandOf(final Regression regression) {
        if(regression.isExample()) {
            return List.of(shell, regression.runScript());
        }

        if(regression.hasTargetPoints()) {
            final Path evaluationScript = release.resolve(EVALUATION_SCRIPT);
            final String targetPoints = "-Boptimisation:target-points-file=" + Regression.TARGET_POINTS_FILE;

            return List.of(shell,
                           evaluationScript.toString(),
                           ".",
                           Regression.CONFIGURATION_FILE,
                           OUTPUT_FOLDER,
                           EVALUATION_REPETITIONS,
                           targetPoints);
        }

        final Path searchScript = release.resolve(SEARCH_SCRIPT);

        return List.of(shell, searchScript.toString(), ".", Regression.CONFIGURATION_FILE, OUTPUT_FOLDER);
    }

    private Process start(final Regression regression, final Path workingFolder, final Path logFile) {
        final List<String> command = commandOf(regression);
        final ProcessBuilder builder = new ProcessBuilder(command);

        final Map<String, String> environment = builder.environment();
        environment.put("EVOAL_HOME", release.toString());
        environment.put("EVOAL_SEED", SEED);
        environment.put("EVOAL_LOGGING", "WARN");
        environment.remove("EVOAL_DEBUG");
        environment.remove("EVOAL_VM");

        if(!agent.isBlank()) {
            environment.put("EVOAL_VM", agent);
        }

        final File log = logFile.toFile();
        builder.directory(workingFolder.toFile())
               .redirectErrorStream(true)
               .redirectOutput(log);

        try {
            return builder.start();
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot start " + command, e);
        }
    }

    /**
     * @return The last lines of the log.
     */
    private static String tailOf(final Path logFile) {
        try {
            final List<String> lines = Files.readAllLines(logFile, StandardCharsets.UTF_8);
            final int firstShownLine = Math.max(0, lines.size() - SHOWN_LOG_LINES);
            final List<String> shownLines = lines.subList(firstShownLine, lines.size());

            return String.join("\n", shownLines);
        } catch(final IOException e) {
            return "(cannot read the log: " + e.getMessage() + ")";
        }
    }
}
