package de.evoal.core.main.credits;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BibTeXParserTest {
    @Test
    public void concatenationIsRejected() {
        final String message = errorOf("@misc{key, title = {A} # {B}}");

        Assertions.assertTrue(message.contains("'#'"), message);
    }

    @Test
    public void duplicateFieldIsRejected() {
        final String message = errorOf("@misc{key, title = {A}, Title = {B}}");

        Assertions.assertTrue(message.contains("'title' is set twice"), message);
    }

    @Test
    public void duplicateKeyIsRejected() {
        final String message = errorOf("@misc{key, title = {A}}\n@misc{key, title = {B}}");

        Assertions.assertEquals("Line 2: The key 'key' is used twice.", message);
    }

    @Test
    public void emptyTextHasNoEntries() {
        final List<BibTeXEntry> entries = BibTeXParser.parse("  % only a comment\n");

        Assertions.assertEquals(List.of(), entries);
    }

    @Test
    public void entriesAreParsedWithTheirFields() {
        final String text = """
                % comment before the entries
                @Article{hall2009,
                    author  = {Mark Hall and Eibe Frank},
                    title   = "The {WEKA} Data Mining Software:
                               An Update",
                    year    = 2009,
                }

                @misc{other, title = {Nested {braces} stay}}
                """;

        final List<BibTeXEntry> entries = BibTeXParser.parse(text);

        Assertions.assertEquals(2, entries.size());

        final BibTeXEntry first = entries.get(0);
        Assertions.assertEquals("article", first.type());
        Assertions.assertEquals("hall2009", first.key());
        Assertions.assertEquals(Map.of("author", "Mark Hall and Eibe Frank",
                                       "title", "The {WEKA} Data Mining Software: An Update",
                                       "year", "2009"),
                                first.fields());
        Assertions.assertEquals(List.of("author", "title", "year"), List.copyOf(first.fields().keySet()));

        final BibTeXEntry second = entries.get(1);
        Assertions.assertEquals("Nested {braces} stay", second.fields().get("title"));
    }

    /**
     * @return The message of the exception that parsing the text throws.
     */
    private static String errorOf(final String text) {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                                                                           () -> BibTeXParser.parse(text));

        return exception.getMessage();
    }

    @Test
    public void stringDefinitionsAreRejected() {
        final String message = errorOf("@string{weka = {Weka}}");

        Assertions.assertTrue(message.contains("'@string' is not supported"), message);
    }

    @Test
    public void textOutsideOfEntriesIsRejected() {
        final String message = errorOf("@misc{key, title = {A}}\nstray text");

        Assertions.assertTrue(message.startsWith("Line 2: Unexpected text"), message);
    }

    @Test
    public void unclosedBraceIsRejected() {
        final String message = errorOf("@misc{key, title = {A {B}");

        Assertions.assertTrue(message.contains("not closed"), message);
    }

    @Test
    public void unclosedEntryIsRejected() {
        final String message = errorOf("@misc{key, title = {A}");

        Assertions.assertTrue(message.contains("Expected '}', but found the end of the text"), message);
    }
}
