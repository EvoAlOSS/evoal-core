package de.evoal.core.main.credits;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class CreditsCollectorTest {
    /**
     * The credits of {@link TestInstallation#example(Path)}.
     */
    private InstalledCredits credits;

    @TempDir
    private Path temporaryFolder;

    @BeforeEach
    public void collectCredits() throws IOException {
        final TestInstallation installation = TestInstallation.example(temporaryFolder);
        final Path coreFolder = installation.folder("modules");

        credits = CreditsCollector.collect(installation.jars(), coreFolder);
    }

    @Test
    public void evoalLibrariesAreNoThirdPartyLibraries() {
        final List<String> names = credits.evoalComponents()
                                          .stream()
                                          .map(SbomComponent::name)
                                          .toList();

        Assertions.assertEquals(List.of("language"), names);
    }

    @Test
    public void librariesAreSortedByName() {
        final List<String> names = credits.libraries()
                                          .stream()
                                          .map(library -> library.component().name())
                                          .toList();

        Assertions.assertEquals(List.of("gpl-lib", "plugin-lib", "shared-lib"), names);
    }

    @Test
    public void libraryOfSeveralModulesAppearsOnce() {
        final InstalledLibrary shared = credits.libraries().get(2);

        Assertions.assertEquals(List.of(new LibraryUse("core", "Shares things."),
                                        new LibraryUse("other", "Shares more.")),
                                shared.uses());
        Assertions.assertEquals(List.of("Apache-2.0"), shared.licenses());
        Assertions.assertEquals("https://example.org/shared-lib", shared.website());
    }

    @Test
    public void licenceChoiceAndCitationsOfThePluginAreUsed() {
        final InstalledLibrary pluginLibrary = credits.libraries().get(1);

        Assertions.assertEquals(List.of("EPL-2.0"), pluginLibrary.licenses());
        Assertions.assertEquals(List.of(new LibraryUse("arff", "Reads files.")), pluginLibrary.uses());
        Assertions.assertEquals("paper", pluginLibrary.citations().get(0).key());
        Assertions.assertEquals("native", pluginLibrary.bundled().get(0).name());
    }

    @Test
    public void licenceOfTheCreditsReplacesTheOneOfTheSbom() {
        final InstalledLibrary gplLibrary = credits.libraries().get(0);

        Assertions.assertEquals(List.of("GPL-3.0-or-later"), gplLibrary.licenses());
    }

    @Test
    public void modulesStartWithCore() {
        final List<String> names = credits.modules()
                                          .stream()
                                          .map(InstalledModule::name)
                                          .toList();

        Assertions.assertEquals(List.of("core", "arff", "other"), names);
        Assertions.assertEquals("evoal", credits.modules().get(0).citations().get(0).key());
        Assertions.assertEquals("2.0", credits.modules().get(0).component().version());
    }
}
