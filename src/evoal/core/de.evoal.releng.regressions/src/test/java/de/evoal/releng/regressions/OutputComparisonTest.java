package de.evoal.releng.regressions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class OutputComparisonTest {
    private static final String CANDIDATES = "search/candidates-per-iteration.csv";

    private Path actualFolder;

    private Path expectedFolder;

    @TempDir
    private Path temporaryFolder;

    @BeforeEach
    public void createReferences() throws IOException {
        expectedFolder = temporaryFolder.resolve("expected");
        actualFolder = temporaryFolder.resolve("actual");

        write(expectedFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.0");
    }

    private static void write(final Path folder, final String file, final String... lines) throws IOException {
        final Path path = folder.resolve(file);
        final Path parent = path.getParent();
        final List<String> content = List.of(lines);

        Files.createDirectories(parent);
        Files.write(path, content, StandardCharsets.UTF_8);
    }

    @Nested
    @DisplayName("given an output that equals the references")
    class EqualOutput {
        @BeforeEach
        public void createOutput() throws IOException {
            write(actualFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.0");
        }

        @Test
        public void noDifferenceIsReported() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            Assertions.assertEquals(List.of(), differences);
        }
    }

    @Nested
    @DisplayName("given an output with the provenance of the run")
    class Provenance {
        @BeforeEach
        public void createOutput() throws IOException {
            write(actualFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.0");
            write(actualFolder, "search/provenance/environment.json", "{}");
        }

        @Test
        public void theProvenanceIsNotCompared() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            Assertions.assertEquals(List.of(), differences);
        }

        @Test
        public void theProvenanceIsNoReference() throws IOException {
            // when
            OutputComparison.replace(expectedFolder, actualFolder);

            // then
            Assertions.assertTrue(Files.exists(expectedFolder.resolve(CANDIDATES)));
            Assertions.assertFalse(Files.exists(expectedFolder.resolve("search/provenance")));
        }
    }

    @Nested
    @DisplayName("a run has output (#358)")
    class HasOutput {
        @Test
        public void aMissingFolderHasNoOutput() {
            Assertions.assertFalse(OutputComparison.hasOutput(actualFolder));
        }

        @Test
        public void anEmptyFolderHasNoOutput() throws IOException {
            // given
            Files.createDirectories(actualFolder.resolve("search"));

            // then
            Assertions.assertFalse(OutputComparison.hasOutput(actualFolder));
        }

        @Test
        public void aFolderWithOnlyTheProvenanceHasNoOutput() throws IOException {
            // given
            write(actualFolder, "search/provenance/environment.json", "{}");

            // then
            Assertions.assertFalse(OutputComparison.hasOutput(actualFolder));
        }

        @Test
        public void aFolderWithAFileHasOutput() throws IOException {
            // given
            write(actualFolder, CANDIDATES, "individual-id;x:0");

            // then
            Assertions.assertTrue(OutputComparison.hasOutput(actualFolder));
        }
    }

    @Nested
    @DisplayName("given an output with a changed value")
    class ChangedValue {
        @BeforeEach
        public void createOutput() throws IOException {
            write(actualFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.5");
        }

        @Test
        public void theFileAndLineAreReported() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            final String expectedDifference = CANDIDATES + ", line 3:\n"
                    + "  expected: 1;2.0\n"
                    + "  actual:   1;2.5";
            Assertions.assertEquals(List.of(expectedDifference), differences);
        }
    }

    @Nested
    @DisplayName("given an output with an additional row")
    class AdditionalRow {
        @BeforeEach
        public void createOutput() throws IOException {
            write(actualFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.0", "2;3.0");
        }

        @Test
        public void theNumbersOfLinesAreReported() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            final String expectedDifference = CANDIDATES + ": 3 lines expected, 4 lines found.";
            Assertions.assertEquals(List.of(expectedDifference), differences);
        }
    }

    @Nested
    @DisplayName("given an output with a different set of files")
    class DifferentFiles {
        @BeforeEach
        public void createOutput() throws IOException {
            write(actualFolder, "search/best-candidate-per-iteration.csv", "individual-id;x:0", "0;1.0");
        }

        @Test
        public void missingAndUnexpectedFilesAreReported() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            final List<String> expectedDifferences = List.of(
                    "Missing file " + CANDIDATES + ".",
                    "Unexpected file search/best-candidate-per-iteration.csv.");
            Assertions.assertEquals(expectedDifferences, differences);
        }
    }

    @Nested
    @DisplayName("given a memory model written by another EvoAl version")
    class OtherEvoalVersion {
        private static final String INFORMATION = "search/memory-model/execution-information.json";

        @BeforeEach
        public void createOutput() throws IOException {
            write(expectedFolder, INFORMATION, "  \"setup\" : {", "    \"evoalVersion\" : \"${evoal.version}\",");
            write(actualFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.0");
            write(actualFolder, INFORMATION, "  \"setup\" : {", "    \"evoalVersion\" : \"2027.4.0\",");
        }

        @Test
        public void noDifferenceIsReported() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            Assertions.assertEquals(List.of(), differences);
        }

        @Test
        public void replacedReferencesContainThePlaceholder() throws IOException {
            // when
            OutputComparison.replace(expectedFolder, actualFolder);

            // then
            final List<String> lines = Files.readAllLines(expectedFolder.resolve(INFORMATION));
            Assertions.assertEquals("    \"evoalVersion\" : \"${evoal.version}\",", lines.get(1));
        }
    }

    @Nested
    @DisplayName("given an output with Windows line endings")
    class WindowsLineEndings {
        @Test
        public void replacedReferencesKeepTheLineEndings() throws IOException {
            // given
            final Path output = actualFolder.resolve(CANDIDATES);
            Files.createDirectories(output.getParent());
            Files.writeString(output, "individual-id;x:0\r\n0;1.0\r\n", StandardCharsets.UTF_8);

            // when
            OutputComparison.replace(expectedFolder, actualFolder);

            // then
            final String reference = Files.readString(expectedFolder.resolve(CANDIDATES), StandardCharsets.UTF_8);
            Assertions.assertEquals("individual-id;x:0\r\n0;1.0\r\n", reference);
        }
    }

    @Nested
    @DisplayName("given references that are replaced by a changed output")
    class ReplacedReferences {
        @BeforeEach
        public void replaceReferences() throws IOException {
            write(actualFolder, "search/best-candidate-per-iteration.csv", "individual-id;x:0", "0;1.0");

            OutputComparison.replace(expectedFolder, actualFolder);
        }

        @Test
        public void theReferencesEqualTheOutput() {
            // when
            final List<String> differences = OutputComparison.differences(expectedFolder, actualFolder);

            // then
            Assertions.assertEquals(List.of(), differences);
        }
    }

    @Nested
    @DisplayName("given a relative tolerance for numbers")
    class Tolerance {
        private static final String EXPECTED = "\"fitness\" : [ 4.938389903142828E-16 ],";

        private static final String ACTUAL = "\"fitness\" : [ 4.938389903142827E-16 ],";

        @Test
        public void withoutToleranceTheLinesDiffer() {
            Assertions.assertFalse(OutputComparison.linesMatch(EXPECTED, ACTUAL, 0.0));
        }

        @Test
        public void numbersWithinTheToleranceMatch() {
            Assertions.assertTrue(OutputComparison.linesMatch(EXPECTED, ACTUAL, 1e-12));
        }

        @Test
        public void numbersBeyondTheToleranceDiffer() {
            Assertions.assertFalse(OutputComparison.linesMatch("1.0;2.0", "1.0;2.1", 1e-12));
        }

        @Test
        public void theToleranceIsRelative() {
            Assertions.assertTrue(OutputComparison.linesMatch("1000000.0", "1000000.5", 1e-6));
            Assertions.assertFalse(OutputComparison.linesMatch("1.0", "1.5", 1e-6));
        }

        @Test
        public void zeroOnlyMatchesZero() {
            Assertions.assertFalse(OutputComparison.linesMatch("0.0", "1.0E-300", 1e-12));
        }

        @Test
        public void otherTextMustBeEqual() {
            Assertions.assertFalse(OutputComparison.linesMatch("x:0;1.0", "x:1;1.0", 1e-12));
            Assertions.assertFalse(OutputComparison.linesMatch("a;1.0", "b;1.0", 1e-12));
        }

        @Test
        public void theToleranceAppliesToFiles() throws IOException {
            // given
            write(actualFolder, CANDIDATES, "individual-id;x:0", "0;1.0", "1;2.0");
            write(expectedFolder, "search/memory-model/iteration-1.json", EXPECTED);
            write(actualFolder, "search/memory-model/iteration-1.json", ACTUAL);

            // when
            final List<String> exact = OutputComparison.differences(expectedFolder, actualFolder);
            final List<String> tolerant = OutputComparison.differences(expectedFolder, actualFolder, 1e-12);

            // then
            Assertions.assertEquals(1, exact.size());
            Assertions.assertEquals(List.of(), tolerant);
        }
    }
}
