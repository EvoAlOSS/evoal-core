package de.evoal.releng.regressions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class RegressionFinderTest {
    @TempDir
    private Path root;

    private Path example(final String name, final String... files) throws IOException {
        final Path folder = root.resolve("src/evoal/plugins/de.evoal.plugin/src/main/examples").resolve(name);
        Files.createDirectories(folder);

        for(final String file : files) {
            Files.writeString(folder.resolve(file), "");
        }

        return folder;
    }

    @Test
    public void exampleWithReferencesIsCompared() throws IOException {
        final Path folder = example("compared", "01-run-search.sh");
        Files.createDirectory(folder.resolve(Regression.EXPECTED_FOLDER));

        final Regression example = RegressionFinder.findExamples(root).getFirst();

        Assertions.assertEquals("plugin/examples/compared", example.name());
        Assertions.assertTrue(example.isExample());
        Assertions.assertTrue(example.hasReferences());
    }

    @Test
    public void exampleWithoutReferencesIsASmokeTest() throws IOException {
        example("smoke", "01-run-generator.sh");

        final Regression example = RegressionFinder.findExamples(root).getFirst();

        Assertions.assertFalse(example.hasReferences());
    }

    @Test
    public void exampleRunsItsNumberedScriptsInOrder() throws IOException {
        example("pipeline", "03-run-calculation.sh", "01-run-generator.sh", "02-calculate-data.sh", "helper.sh", "README.md");

        final Regression example = RegressionFinder.findExamples(root).getFirst();

        Assertions.assertEquals(List.of("01-run-generator.sh", "02-calculate-data.sh", "03-run-calculation.sh"), example.scripts());
    }

    @Test
    public void exampleWithoutScriptIsRejected() throws IOException {
        example("broken", "README.md");

        Assertions.assertThrows(IllegalStateException.class, () -> RegressionFinder.findExamples(root));
    }

    @Test
    public void regressionConfigurationAlwaysHasReferences() {
        final Regression configuration = Regression.configuration(root, "plugin/name");

        Assertions.assertFalse(configuration.isExample());
        Assertions.assertTrue(configuration.hasReferences());
    }
}
