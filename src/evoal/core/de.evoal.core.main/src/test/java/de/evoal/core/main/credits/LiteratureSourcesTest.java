package de.evoal.core.main.credits;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class LiteratureSourcesTest {
    @TempDir
    private Path classesFolder;

    private void writeDl(final String name, final String text) throws IOException {
        final Path file = classesFolder.resolve("de/example").resolve(name);
        Files.createDirectories(file.getParent());
        Files.writeString(file, text);
    }

    private LiteratureSources read() throws IOException {
        return LiteratureSources.read(classesFolder, LiteratureSourcesTest.class.getClassLoader());
    }

    @Test
    public void theKeysOfTypesAndDeclarationsAreCollectedWithTheirDefinitions() throws IOException {
        // given
        writeDl("operators.dl", """
                import "definitions" from 'de.evoal.core.constraints';

                module de.example.operators {
                    @Literature { keys := ["deb2002fast"]; }
                    type 'nsga2-selection' {}

                    @Literature { keys := ["deb2002fast", "harik1996learning"]; }
                    type 'crowded-comparator' {}

                    @Literature { keys := ["harik1996learning"]; }
                    def void 'building-block'(array data features);

                    type plain {}
                }
                """);

        // when
        final LiteratureSources literature = read();

        // then
        Assertions.assertEquals(List.of(), literature.problems());
        Assertions.assertEquals(Map.of("deb2002fast", List.of("'de.example.operators.nsga2-selection'",
                                                              "'de.example.operators.crowded-comparator'"),
                                       "harik1996learning", List.of("'de.example.operators.crowded-comparator'",
                                                                    "'de.example.operators.building-block'")),
                                literature.dlCitations());
    }

    @Test
    public void anAnnotationWithoutTheImportOfItsTypeIsReported() throws IOException {
        // given
        writeDl("broken.dl", """
                module de.example.broken {
                    @Literature { keys := ["deb2002fast"]; }
                    type 'nsga2-selection' {}
                }
                """);

        // when
        final LiteratureSources literature = read();

        // then
        Assertions.assertEquals(1, literature.problems().size(), literature.problems().toString());
        Assertions.assertTrue(literature.problems().getFirst().startsWith("The @Literature of "
                                                                         + "'de.example.broken.nsga2-selection' in "),
                              literature.problems().toString());
    }

    @Test
    public void theCitationsOfTheClassPathAreDependenciesButTheModulesOwnAreNot() throws IOException {
        // given
        final Path ownCitations = classesFolder.resolve(CreditsFiles.FOLDER).resolve(CreditsFiles.CITATIONS_FILE);
        Files.createDirectories(ownCitations.getParent());
        Files.writeString(ownCitations, "@misc{own2026, title = {Own}}");

        // when: the module's output folder is on the class path, as in the build
        final LiteratureSources literature;
        try(URLClassLoader classpath = new URLClassLoader(new URL[] {classesFolder.toUri().toURL()},
                                                          LiteratureSourcesTest.class.getClassLoader())) {
            literature = LiteratureSources.read(classesFolder, classpath);
        }

        // then: core.main's citations are on the class path of the test
        Assertions.assertTrue(literature.dependencyEntries().containsKey("berger2024evoal"),
                              literature.dependencyEntries().toString());
        Assertions.assertFalse(literature.dependencyEntries().containsKey("own2026"),
                               literature.dependencyEntries().toString());
    }

    @Test
    public void aModuleWithoutDlFilesHasNoDlCitations() throws IOException {
        // when
        final LiteratureSources literature = read();

        // then
        Assertions.assertEquals(Map.of(), literature.dlCitations());
        Assertions.assertEquals(List.of(), literature.problems());
    }
}
