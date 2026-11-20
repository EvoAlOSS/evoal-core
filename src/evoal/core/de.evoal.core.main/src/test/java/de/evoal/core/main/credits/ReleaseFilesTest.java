package de.evoal.core.main.credits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

public class ReleaseFilesTest {
    /**
     * The folder of the written release files.
     */
    private Path releaseFolder;

    @TempDir
    private Path temporaryFolder;

    /**
     * @return The licences of the component in the SBOM: the ids and the names.
     */
    private static List<String> licensesOf(final JsonNode component) {
        final List<String> licenses = new ArrayList<>();
        for(final JsonNode entry : component.path("licenses")) {
            final JsonNode license = entry.path("license");
            licenses.add(license.path("id").asString(license.path("name").asString("")));
        }

        return licenses;
    }

    @Test
    public void licenseTextsOfAllLicencesAreWritten() throws IOException {
        final List<String> files;
        try(Stream<Path> paths = Files.list(releaseFolder.resolve(ReleaseFiles.LICENSES_FOLDER))) {
            files = paths.map(path -> path.getFileName().toString())
                         .sorted()
                         .toList();
        }

        Assertions.assertEquals(List.of("Apache-2.0.txt", "BSD-3-Clause.txt", "EPL-2.0.txt", "GPL-3.0-or-later.txt",
                                        "MIT.txt"),
                                files);
    }

    @Test
    public void noticeNamesTheGplLibrariesAndContainsTheNoticesOfTheJars() throws IOException {
        final String notice = Files.readString(releaseFolder.resolve(ReleaseFiles.NOTICE_FILE));

        Assertions.assertTrue(notice.startsWith("EvoAl\n"), notice);
        final String gplStatement = "GNU General Public License (GPL-3.0-or-later):\n  - gpl-lib 1.0 (core)\n";
        Assertions.assertTrue(notice.contains(gplStatement), notice);
        Assertions.assertTrue(notice.contains("shared-lib 1.0 (org.example:shared-lib)\n"
                                              + "-".repeat(80) + "\nShared Lib\nCopyright The Shared Authors"),
                              notice);
    }

    @Test
    public void sbomListsTheReleaseWithTheLicencesInUse() throws IOException {
        final String json = Files.readString(releaseFolder.resolve(ReleaseFiles.SBOM_FILE));
        final JsonNode sbom = JsonMapper.builder().build().readTree(json);

        Assertions.assertEquals("EvoAl", sbom.path("metadata").path("component").path("name").asString());
        Assertions.assertEquals("2.0", sbom.path("metadata").path("component").path("version").asString());

        final List<String> components = new ArrayList<>();
        for(final JsonNode component : sbom.path("components")) {
            final String name = component.path("name").asString();
            components.add(name + " " + licensesOf(component));

            for(final String license : licensesOf(component)) {
                final Path text = releaseFolder.resolve(ReleaseFiles.LICENSES_FOLDER).resolve(license + ".txt");
                Assertions.assertTrue(Files.exists(text), "No text for " + license + " of " + name);
            }
        }

        Assertions.assertEquals(List.of("core.main [Apache-2.0]",
                                        "core.arff [Apache-2.0]",
                                        "other [Apache-2.0]",
                                        "language [Apache-2.0]",
                                        "gpl-lib [GPL-3.0-or-later]",
                                        "plugin-lib [EPL-2.0]",
                                        "shared-lib [Apache-2.0]",
                                        "inner-lib [BSD-3-Clause]"),
                                components);
    }

    @BeforeEach
    public void writeReleaseFiles() throws IOException {
        final TestInstallation installation = TestInstallation.example(temporaryFolder.resolve("installation"));
        final Path coreFolder = installation.folder("modules");
        final InstalledCredits credits = CreditsCollector.collect(installation.jars(), coreFolder);

        releaseFolder = Files.createDirectories(temporaryFolder.resolve("release"));
        ReleaseFiles.write(credits, releaseFolder);
    }
}
