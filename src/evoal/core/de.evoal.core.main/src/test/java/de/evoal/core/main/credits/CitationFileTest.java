package de.evoal.core.main.credits;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * EvoAl's citation stands in two places: {@code CITATION.cff} in the repository root (read by
 *   GitLab, GitHub and Zenodo) and core.main's {@value CreditsFiles#CITATIONS_FILE} (printed by
 *   {@code --credits}). This test keeps them in agreement.
 */
public class CitationFileTest {
    /**
     * {@code CITATION.cff}, seen from the folder of core.main.
     */
    private static final Path CITATION_FILE = Path.of("../../../../CITATION.cff");

    /**
     * @return The value of the key in the {@code preferred-citation} block, without quotes.
     */
    private static String preferredCitationValue(final String cff, final String key) {
        final String block = cff.substring(cff.indexOf("preferred-citation:"));
        final Pattern pattern = Pattern.compile("^  " + key + ": *['\"]?(.*?)['\"]?$", Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(block);
        Assertions.assertTrue(matcher.find(), "CITATION.cff has no preferred-citation " + key + ".");

        return matcher.group(1);
    }

    @Test
    public void titleAndDoiAgree() throws IOException {
        final String cff = Files.readString(CITATION_FILE);

        final String resource = "/" + CreditsFiles.FOLDER + "/" + CreditsFiles.CITATIONS_FILE;
        final String bib;
        try(InputStream stream = CitationFileTest.class.getResourceAsStream(resource)) {
            Assertions.assertNotNull(stream, "core.main has no " + CreditsFiles.CITATIONS_FILE + ".");
            bib = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }

        final List<BibTeXEntry> entries = BibTeXParser.parse(bib);
        Assertions.assertEquals(1, entries.size());

        final BibTeXEntry evoal = entries.get(0);
        final String bibTitle = evoal.fields().get("title").replace("{", "").replace("}", "");

        Assertions.assertEquals(preferredCitationValue(cff, "title"), bibTitle);
        Assertions.assertEquals(preferredCitationValue(cff, "doi"), evoal.fields().get("doi"));
    }
}
