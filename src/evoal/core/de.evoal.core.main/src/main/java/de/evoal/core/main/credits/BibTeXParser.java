package de.evoal.core.main.credits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Reads the BibTeX entries of the credits files, e.g.
 *   {@code @article{key, author = {A and B}, title = "Title", year = 2009}}.
 * <p>
 * The parser reads the subset that citations need: entries with braces, field values in
 *   braces (nested braces allowed), in quotes or as a number, and an optional comma after
 *   the last field. Outside the entries only whitespace and {@code %} line comments are
 *   allowed, so stray text is reported instead of being ignored. Not supported are
 *   {@code @string}, {@code @preamble}, {@code @comment}, entries in parentheses and the
 *   concatenation of values with {@code #}.
 */
public final class BibTeXParser {
    /**
     * Returned by {@link #peek()} at the end of the text.
     */
    private static final char END_OF_TEXT = '\0';

    /**
     * Entry types of BibTeX that are no citations.
     */
    private static final Set<String> UNSUPPORTED_TYPES = Set.of("comment", "preamble", "string");

    /**
     * The index of the next character to read.
     */
    private int position;

    /**
     * The BibTeX text.
     */
    private final String text;

    private BibTeXParser(final String text) {
        this.text = text;
    }

    /**
     * Collapses every run of whitespace to one space and removes it at both ends.
     */
    private static String collapseWhitespace(final String value) {
        return value.strip()
                    .replaceAll("\\s+", " ");
    }

    /**
     * @return The number of the line of the current position, starting at 1.
     */
    private int currentLine() {
        final long lineBreaks = text.substring(0, position)
                                    .chars()
                                    .filter(character -> character == '\n')
                                    .count();

        return (int) lineBreaks + 1;
    }

    /**
     * @return The character in quotes, or "the end of the text".
     */
    private static String describe(final char character) {
        if(character == END_OF_TEXT) {
            return "the end of the text";
        }

        return "'" + character + "'";
    }

    /**
     * Reads the expected character.
     *
     * @throws IllegalArgumentException if the current character is a different one.
     */
    private void expect(final char expected) {
        final char current = peek();
        if(current != expected) {
            throw failure("Expected '" + expected + "', but found " + describe(current) + ".");
        }

        position += 1;
    }

    /**
     * @return An exception whose message starts with the current line.
     */
    private IllegalArgumentException failure(final String message) {
        final int line = currentLine();

        return new IllegalArgumentException("Line " + line + ": " + message);
    }

    private boolean isAtEnd() {
        return position >= text.length();
    }

    private static boolean isIdentifierCharacter(final char character) {
        final boolean isSymbol = character == '-' || character == '_' || character == ':';

        return Character.isLetterOrDigit(character) || isSymbol;
    }

    private static boolean isKeyCharacter(final char character) {
        final boolean isDelimiter = character == ',' || character == '{' || character == '}';

        return !Character.isWhitespace(character) && !isDelimiter && character != END_OF_TEXT;
    }

    /**
     * Parses the entries of a BibTeX text.
     *
     * @param text The BibTeX text.
     * @return The entries in the order of the text.
     * @throws IllegalArgumentException if the text is not valid in the supported subset or
     *   uses a key twice. The message names the line.
     */
    public static List<BibTeXEntry> parse(final String text) {
        final BibTeXParser parser = new BibTeXParser(text);

        return parser.parseEntries();
    }

    /**
     * Reads a value in braces, which may contain nested braces.
     *
     * @return The value without the outer braces.
     */
    private String parseBracedValue() {
        expect('{');

        final int start = position;
        int depth = 1;
        while(depth > 0) {
            if(isAtEnd()) {
                throw failure("The value in braces is not closed.");
            }

            final char current = text.charAt(position);
            if(current == '{') {
                depth += 1;
            } else if(current == '}') {
                depth -= 1;
            }

            position += 1;
        }

        final String value = text.substring(start, position - 1);

        return collapseWhitespace(value);
    }

    private List<BibTeXEntry> parseEntries() {
        final List<BibTeXEntry> entries = new ArrayList<>();
        final Set<String> keys = new HashSet<>();

        skipWhitespaceAndComments();
        while(!isAtEnd()) {
            final BibTeXEntry entry = parseEntry();
            final boolean isNewKey = keys.add(entry.key());
            if(!isNewKey) {
                throw failure("The key '" + entry.key() + "' is used twice.");
            }

            entries.add(entry);
            skipWhitespaceAndComments();
        }

        return entries;
    }

    private BibTeXEntry parseEntry() {
        expect('@');

        final String type = parseIdentifier().toLowerCase(Locale.ROOT);
        if(UNSUPPORTED_TYPES.contains(type)) {
            throw failure("'@" + type + "' is not supported.");
        }

        skipWhitespace();
        expect('{');
        skipWhitespace();

        final String key = parseKey();
        final Map<String, String> fields = parseFields();
        expect('}');

        return new BibTeXEntry(type, key, fields);
    }

    /**
     * Reads the fields after the key up to the closing brace of the entry (not consumed).
     */
    private Map<String, String> parseFields() {
        final Map<String, String> fields = new LinkedHashMap<>();

        skipWhitespace();
        while(peek() == ',') {
            position += 1;
            skipWhitespace();

            final boolean isTrailingComma = peek() == '}';
            if(isTrailingComma) {
                break;
            }

            final String name = parseIdentifier().toLowerCase(Locale.ROOT);
            skipWhitespace();
            expect('=');
            skipWhitespace();

            final String value = parseValue();
            if(fields.containsKey(name)) {
                throw failure("The field '" + name + "' is set twice.");
            }

            fields.put(name, value);
            skipWhitespace();

            if(peek() == '#') {
                throw failure("The concatenation of values with '#' is not supported.");
            }
        }

        return fields;
    }

    private String parseIdentifier() {
        final int start = position;
        while(isIdentifierCharacter(peek())) {
            position += 1;
        }

        if(start == position) {
            throw failure("Expected a name, but found " + describe(peek()) + ".");
        }

        return text.substring(start, position);
    }

    private String parseKey() {
        final int start = position;
        while(isKeyCharacter(peek())) {
            position += 1;
        }

        if(start == position) {
            throw failure("Expected the key of the entry, but found " + describe(peek()) + ".");
        }

        return text.substring(start, position);
    }

    private String parseNumber() {
        final int start = position;
        while(Character.isDigit(peek())) {
            position += 1;
        }

        return text.substring(start, position);
    }

    /**
     * Reads a value in quotes. Braces inside the quotes must be balanced, a quote inside braces
     *   does not end the value.
     *
     * @return The value without the quotes.
     */
    private String parseQuotedValue() {
        expect('"');

        final int start = position;
        int depth = 0;
        while(depth > 0 || peek() != '"') {
            if(isAtEnd()) {
                throw failure("The value in quotes is not closed.");
            }

            final char current = text.charAt(position);
            if(current == '{') {
                depth += 1;
            } else if(current == '}') {
                depth -= 1;
            }

            position += 1;
        }

        final String value = text.substring(start, position);
        position += 1;

        return collapseWhitespace(value);
    }

    private String parseValue() {
        final char current = peek();
        if(current == '{') {
            return parseBracedValue();
        }

        if(current == '"') {
            return parseQuotedValue();
        }

        if(Character.isDigit(current)) {
            return parseNumber();
        }

        throw failure("Expected a value in braces, in quotes or a number, but found " + describe(current) + ".");
    }

    /**
     * @return The current character, {@link #END_OF_TEXT} at the end.
     */
    private char peek() {
        if(isAtEnd()) {
            return END_OF_TEXT;
        }

        return text.charAt(position);
    }

    private void skipWhitespace() {
        while(Character.isWhitespace(peek())) {
            position += 1;
        }
    }

    /**
     * Skips whitespace and {@code %} line comments up to the next entry or the end.
     *
     * @throws IllegalArgumentException if other text stands outside an entry.
     */
    private void skipWhitespaceAndComments() {
        skipWhitespace();

        while(peek() == '%') {
            while(!isAtEnd() && peek() != '\n') {
                position += 1;
            }

            skipWhitespace();
        }

        final boolean isAtEntry = peek() == '@';
        if(!isAtEnd() && !isAtEntry) {
            throw failure("Unexpected text outside of an entry: " + describe(peek()) + ".");
        }
    }
}
