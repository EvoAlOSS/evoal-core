package de.evoal.core.api.provenance;

import java.nio.file.Path;
import java.time.Clock;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import lombok.NonNull;
import org.eclipse.emf.common.util.URI;

/**
 * The provenance of the current EvoAl execution: the folder the record is written to, and the
 *   files the execution used. The application names the folder ({@link #setFolder(Path)});
 *   the loaders report the configuration files, the readers and writers the data files. After
 *   the application finished, core's main class writes the record (environment, copies of the
 *   configuration files, the files with their hashes).
 * <p>
 * An EvoAl process runs one application, so there is one record per process
 *   ({@link #current()}), which static code such as factories can reach as well.
 */
public final class RunRecord {
    /**
     * The usual name of the record's folder, e.g. {@code <output folder>/provenance}.
     */
    public static final String FOLDER = "provenance";

    /**
     * The use of a file in the execution.
     */
    public enum Role {
        /**
         * A configuration file (e.g. OL, DDL, MLL, generator) or one it imports.
         */
        CONFIGURATION,

        /**
         * A data file the execution read.
         */
        INPUT,

        /**
         * A file the execution wrote.
         */
        OUTPUT
    }

    /**
     * The record of this process.
     */
    private static final RunRecord CURRENT = new RunRecord(Clock.systemUTC());

    /**
     * Gives the start time.
     */
    private final Clock clock;

    /**
     * The files with their first role, absolute and normalised, in the order they were reported.
     */
    private final Map<Path, Role> files = new LinkedHashMap<>();

    /**
     * The folder the record is written to, {@code null} if the application named none.
     */
    private Path folder;

    /**
     * The start of the execution.
     */
    private final Instant start;

    /**
     * Creates a record, e.g., for testing.
     *
     * @param clock Gives the start time.
     */
    public RunRecord(final @NonNull Clock clock) {
        this.clock = clock;
        this.start = clock.instant();
    }

    /**
     * @return The record of this process.
     */
    public static RunRecord current() {
        return CURRENT;
    }

    /**
     * Reports a configuration file that the execution loaded. URIs other than {@code file:},
     *   e.g. DL files from the plugin jars ({@code classpath:}), are ignored: the hashes of the
     *   modules cover them.
     *
     * @param uri The URI of the loaded resource.
     */
    public synchronized void configuration(final URI uri) {
        if(uri != null && uri.isFile()) {
            files.putIfAbsent(normalise(Path.of(uri.toFileString())), Role.CONFIGURATION);
        }
    }

    /**
     * @return The files with their roles, in the order they were reported.
     */
    public synchronized Map<Path, Role> files() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(files));
    }

    /**
     * @return The folder the record is written to, if the application named one.
     */
    public synchronized Optional<Path> folder() {
        return Optional.ofNullable(folder);
    }

    /**
     * Reports a data file that the execution reads.
     */
    public synchronized void input(final @NonNull Path file) {
        files.putIfAbsent(normalise(file), Role.INPUT);
    }

    /**
     * @return The current time of the record's clock, e.g. the end of the execution.
     */
    public Instant now() {
        return clock.instant();
    }

    /**
     * Reports a file that the execution writes.
     */
    public synchronized void output(final @NonNull Path file) {
        files.putIfAbsent(normalise(file), Role.OUTPUT);
    }

    /**
     * Names the folder the record is written to, e.g. {@code <output folder>/provenance}.
     *   A later call replaces it.
     */
    public synchronized void setFolder(final @NonNull Path folder) {
        this.folder = normalise(folder);
    }

    /**
     * @return The start of the execution.
     */
    public Instant start() {
        return start;
    }

    /**
     * @return The configuration files, in the order they were reported.
     */
    public synchronized List<Path> configurationFiles() {
        return files.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == Role.CONFIGURATION)
                    .map(Map.Entry::getKey)
                    .toList();
    }

    private static Path normalise(final Path file) {
        return file.toAbsolutePath()
                   .normalize();
    }
}
