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
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Compares the output of a regression run with its references: both folders contain the
 *   same files (by relative path), and every file has the same lines. By default the
 *   comparison is exact. With a tolerance greater than 0, two different lines still match
 *   if they differ only in numbers, and every pair of numbers {@code a}, {@code b}
 *   satisfies {@code |a - b| <= tolerance * max(|a|, |b|)}.
 * <p>
 * Only the EvoAl version in the memory model ({@code "evoalVersion" : "..."}) is masked
 *   ({@value #VERSION_PLACEHOLDER}), in the references and in the compared output. It
 *   changes with every project version, while the results stay the same.
 * <p>
 * The provenance of a run (every folder named {@value #PROVENANCE}: environment, hashes,
 *   configuration copies) is neither compared nor written as a reference: it changes with
 *   every build and every execution.
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

    /**
     * Finds the numbers in a line, e.g. {@code 4.938389903142828E-16}.
     */
    private static final Pattern NUMBER = Pattern.compile("[-+]?(?:\\d+\\.?\\d*|\\.\\d+)(?:[eE][-+]?\\d+)?");

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
        return differences(expectedFolder, actualFolder, 0.0);
    }

    /**
     * Compares the output of a run with the references, with a relative tolerance for
     *   numbers.
     *
     * @param expectedFolder The folder with the references.
     * @param actualFolder The output folder of the run.
     * @param tolerance The relative tolerance for numbers, 0 for an exact comparison.
     * @return A description of every difference; empty if the output matches the references.
     */
    public static List<String> differences(final Path expectedFolder, final Path actualFolder, final double tolerance) {
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
                     .map(file -> differenceOf(file, expectedFolder, actualFolder, tolerance))
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
                                                 final Path actualFolder,
                                                 final double tolerance) {
        final Path expectedFile = expectedFolder.resolve(file);
        final Path actualFile = actualFolder.resolve(file);
        final List<String> expectedLines = readLines(expectedFile);
        final List<String> actualLines = readLines(actualFile);
        final int commonLines = Math.min(expectedLines.size(), actualLines.size());

        for(int line = 0; line < commonLines; ++line) {
            final String expectedLine = expectedLines.get(line);
            final String actualLine = actualLines.get(line);

            if(!linesMatch(expectedLine, actualLine, tolerance)) {
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
     * @return {@code true} if the lines are equal, or if they differ only in numbers that
     *   are equal within the relative tolerance.
     */
    static boolean linesMatch(final String expectedLine, final String actualLine, final double tolerance) {
        if(expectedLine.equals(actualLine)) {
            return true;
        }

        if(tolerance == 0.0) {
            return false;
        }

        final String expectedText = NUMBER.matcher(expectedLine).replaceAll("#");
        final String actualText = NUMBER.matcher(actualLine).replaceAll("#");
        if(!expectedText.equals(actualText)) {
            return false;
        }

        final List<Double> expectedNumbers = numbersIn(expectedLine);
        final List<Double> actualNumbers = numbersIn(actualLine);

        for(int index = 0; index < expectedNumbers.size(); ++index) {
            final double expected = expectedNumbers.get(index);
            final double actual = actualNumbers.get(index);

            if(!numbersMatch(expected, actual, tolerance)) {
                return false;
            }
        }

        return true;
    }

    private static boolean numbersMatch(final double expected, final double actual, final double tolerance) {
        final double difference = Math.abs(expected - actual);
        final double magnitude = Math.max(Math.abs(expected), Math.abs(actual));

        return difference <= tolerance * magnitude;
    }

    private static List<Double> numbersIn(final String line) {
        return NUMBER.matcher(line)
                     .results()
                     .map(MatchResult::group)
                     .map(Double::valueOf)
                     .toList();
    }

    /**
     * The name of the folders with the provenance of a run, which are skipped.
     */
    static final String PROVENANCE = "provenance";

    /**
     * @return The paths of all files in the folder (recursively), relative to the folder,
     *   without those in a {@value #PROVENANCE} folder.
     */
    private static SortedSet<String> filesIn(final Path folder) {
        if(!Files.isDirectory(folder)) {
            return new TreeSet<>();
        }

        try(Stream<Path> paths = Files.walk(folder)) {
            return paths.filter(Files::isRegularFile)
                        .map(folder::relativize)
                        .filter(file -> !isProvenance(file))
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

    /**
     * @return {@code true} if one of the folders of the relative path is {@value #PROVENANCE}.
     */
    private static boolean isProvenance(final Path file) {
        for(int i = 0; i < file.getNameCount() - 1; ++i) {
            if(PROVENANCE.equals(file.getName(i).toString())) {
                return true;
            }
        }

        return false;
    }
}
