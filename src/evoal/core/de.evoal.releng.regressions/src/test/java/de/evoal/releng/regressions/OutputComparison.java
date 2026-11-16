package de.evoal.releng.regressions;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Compares the output of a regression run with its references. The comparison is
 *   exact: both folders contain the same files (by relative path), and every file
 *   has the same lines.
 * <p>
 * Only the EvoAl version in the memory model ({@code "evoalVersion" : "..."}) is masked
 *   ({@value #VERSION_PLACEHOLDER}), in the references and in the compared output. It
 *   changes with every project version, while the results stay the same.
 */
public final class OutputComparison {
    /**
     * Replaces the EvoAl version in the references.
     */
    public static final String VERSION_PLACEHOLDER = "${evoal.version}";

    /**
     * Finds the EvoAl version in a line of the memory model.
     */
    private static final Pattern EVOAL_VERSION = Pattern.compile("(\"evoalVersion\" : \")[^\"]*(\")");

    private OutputComparison() {
    }

    /**
     * Compares the output of a run with the references.
     *
     * @param expectedFolder The folder with the references.
     * @param actualFolder The output folder of the run.
     * @return A description of every difference; empty if the output equals the references.
     */
    public static List<String> differences(final Path expectedFolder, final Path actualFolder) {
        final SortedSet<String> expectedFiles = filesIn(expectedFolder);
        final SortedSet<String> actualFiles = filesIn(actualFolder);
        final List<String> differences = new ArrayList<>();

        expectedFiles.stream()
                     .filter(file -> !actualFiles.contains(file))
                     .map(file -> "Missing file " + file + ".")
                     .forEach(differences::add);

        actualFiles.stream()
                   .filter(file -> !expectedFiles.contains(file))
                   .map(file -> "Unexpected file " + file + ".")
                   .forEach(differences::add);

        expectedFiles.stream()
                     .filter(actualFiles::contains)
                     .map(file -> differenceOf(file, expectedFolder, actualFolder))
                     .flatMap(Optional::stream)
                     .forEach(differences::add);

        return differences;
    }

    /**
     * Replaces the references with the output of a run.
     *
     * @param expectedFolder The folder with the references, replaced completely.
     * @param actualFolder The output folder of the run.
     */
    public static void replace(final Path expectedFolder, final Path actualFolder) {
        Folders.deleteRecursively(expectedFolder);

        for(final String file : filesIn(actualFolder)) {
            final Path source = actualFolder.resolve(file);
            final Path target = expectedFolder.resolve(file);

            copy(source, target);
        }
    }

    /**
     * Copies the file with the EvoAl version masked. Everything else, including the line
     *   endings, is copied unchanged.
     */
    private static void copy(final Path source, final Path target) {
        try {
            final String content = Files.readString(source, StandardCharsets.UTF_8);
            final String maskedContent = masked(content);
            final Path targetFolder = target.getParent();

            Files.createDirectories(targetFolder);
            Files.writeString(target, maskedContent, StandardCharsets.UTF_8);
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot copy " + source + " to " + target, e);
        }
    }

    /**
     * Compares a file that exists in both folders.
     *
     * @return The first difference of the file, if any.
     */
    private static Optional<String> differenceOf(final String file,
                                                 final Path expectedFolder,
                                                 final Path actualFolder) {
        final Path expectedFile = expectedFolder.resolve(file);
        final Path actualFile = actualFolder.resolve(file);
        final List<String> expectedLines = readLines(expectedFile);
        final List<String> actualLines = readLines(actualFile);
        final int commonLines = Math.min(expectedLines.size(), actualLines.size());

        for(int line = 0; line < commonLines; ++line) {
            final String expectedLine = expectedLines.get(line);
            final String actualLine = actualLines.get(line);

            if(!expectedLine.equals(actualLine)) {
                final int lineNumber = line + 1;

                return Optional.of(file + ", line " + lineNumber + ":\n"
                        + "  expected: " + expectedLine + "\n"
                        + "  actual:   " + actualLine);
            }
        }

        if(expectedLines.size() != actualLines.size()) {
            return Optional.of(file + ": " + expectedLines.size() + " lines expected, "
                    + actualLines.size() + " lines found.");
        }

        return Optional.empty();
    }

    /**
     * @return The paths of all files in the folder (recursively), relative to the folder.
     */
    private static SortedSet<String> filesIn(final Path folder) {
        if(!Files.isDirectory(folder)) {
            return new TreeSet<>();
        }

        try(Stream<Path> paths = Files.walk(folder)) {
            return paths.filter(Files::isRegularFile)
                        .map(folder::relativize)
                        .map(Path::toString)
                        .collect(Collectors.toCollection(TreeSet::new));
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot list the files of " + folder, e);
        }
    }

    /**
     * @return The text with every EvoAl version replaced by {@value #VERSION_PLACEHOLDER}.
     */
    static String masked(final String text) {
        final Matcher matcher = EVOAL_VERSION.matcher(text);
        final String replacement = "$1" + Matcher.quoteReplacement(VERSION_PLACEHOLDER) + "$2";

        return matcher.replaceAll(replacement);
    }

    /**
     * @return The lines of the file, with the EvoAl version masked.
     */
    private static List<String> readLines(final Path file) {
        try {
            return Files.readAllLines(file, StandardCharsets.UTF_8)
                        .stream()
                        .map(OutputComparison::masked)
                        .toList();
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot read " + file, e);
        }
    }
}
