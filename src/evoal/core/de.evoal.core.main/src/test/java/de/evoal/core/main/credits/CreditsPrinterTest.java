package de.evoal.core.main.credits;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class CreditsPrinterTest {
    /**
     * The credits of {@link TestInstallation#example(Path)}.
     */
    private InstalledCredits credits;

    @TempDir
    private Path temporaryFolder;

    @Test
    public void bibTeXContainsAllCitationsEvoalFirst() {
        final String bibtex = print(out -> CreditsPrinter.printBibTeX(out, credits));

        final List<String> keys = BibTeXParser.parse(bibtex)
                                              .stream()
                                              .map(BibTeXEntry::key)
                                              .toList();

        Assertions.assertEquals(List.of("evoal", "paper"), keys);
    }

    @BeforeEach
    public void collectCredits() throws IOException {
        final TestInstallation installation = TestInstallation.example(temporaryFolder);
        final Path coreFolder = installation.folder("modules");

        credits = CreditsCollector.collect(installation.jars(), coreFolder);
    }

    @Test
    public void creditsListEvoalAndTheLibraries() {
        final String text = print(out -> CreditsPrinter.printCredits(out, credits));

        final String evoal = """
                EvoAl 2.0

                If you use EvoAl, please cite:
                  Ada Lovelace, Alan Turing. EvoAl - Optimisation. Proceedings, pp. 1-9, 2024. \
                https://doi.org/10.1/evoal
                """;
        Assertions.assertTrue(text.startsWith(evoal), text);
        Assertions.assertTrue(text.contains("EvoAl uses the following 3 libraries."), text);
        Assertions.assertTrue(text.contains("""
                  plugin-lib 1.0 (org.example:plugin-lib)
                      Licence:  EPL-2.0 (https://spdx.org/licenses/EPL-2.0.html)
                      Project:  https://example.org/plugin-lib
                      Used by:  arff: Reads files.
                      Cite:     Grace Hopper. The Library. Online, 2016.
                      Bundles:  native (MIT, https://example.org/native)
                """), text);
        Assertions.assertTrue(text.contains("""
                      Used by:  core: Shares things.
                      Used by:  other: Shares more.
                """), text);
    }

    /**
     * @return What the printer writes.
     */
    private static String print(final java.util.function.Consumer<PrintStream> printer) {
        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(bytes, true, StandardCharsets.UTF_8);
        printer.accept(out);

        return bytes.toString(StandardCharsets.UTF_8);
    }
}
