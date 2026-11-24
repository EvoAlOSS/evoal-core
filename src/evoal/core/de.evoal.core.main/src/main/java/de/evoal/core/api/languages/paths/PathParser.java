package de.evoal.core.api.languages.paths;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses the text of a path expression ({@code path "…"}) into a {@link Path}. The syntax
 *   follows XPath, with groups and repetitions of the property paths of SPARQL 1.1:
 *
 * <pre>
 * union    := sequence ('|' sequence)*
 * sequence := ('/' | '//')? step? (('/' | '//') step)*
 * step     := primary postfix*
 * primary  := '.' | '..' | '*' | name | filter | group
 * postfix  := filter | group
 * filter   := '[' 'exactly'? name ']'
 * group    := '(' union ')' ('*' | '+')?
 * name     := an unquoted name of letters, digits, '_' and '-' | a name in single quotes
 * </pre>
 *
 * A '/' at the start is the module of the file; '//' selects the objects and all objects below
 *   them before the next step. Whitespace between the tokens is ignored. A '*' directly after a
 *   group is the repetition, everywhere else it selects all children. A sequence without a step
 *   (only '/' or '//') is allowed at the start of a path.
 */
public final class PathParser {
    /**
     * The separator that also selects all objects below, {@code //}.
     */
    private static final String DESCENDANTS = "//";

    /**
     * The keyword of a filter that keeps only instances of exactly the type.
     */
    private static final String EXACTLY = "exactly";

    /**
     * The separator of two steps, {@code /}.
     */
    private static final String SEPARATOR = "/";

    /**
     * The current position in {@link #text}.
     */
    private int position;

    /**
     * The text of the path.
     */
    private final String text;

    private PathParser(final String text) {
        this.text = text;
    }

    private char current() {
        return text.charAt(position);
    }

    private PathException error(final String problem) {
        return new PathException(text, position, problem);
    }

    private void expect(final char expected) {
        skipWhitespace();
        if(isAtEnd() || current() != expected) {
            throw error("expected '" + expected + "'");
        }
        ++position;
    }

    private Path filter() {
        expect('[');
        skipWhitespace();

        int nameOffset = position;
        String typeName = name();
        boolean exactly = false;

        skipWhitespace();
        final boolean followedByName = !isAtEnd() && current() != ']';
        if(EXACTLY.equals(typeName) && followedByName) {
            exactly = true;
            nameOffset = position;
            typeName = name();
        }

        expect(']');

        return new Path.TypeFilter(typeName, exactly, nameOffset);
    }

    private Path group() {
        expect('(');
        final Path inner = union();
        expect(')');

        if(lookingAt("*")) {
            ++position;

            return new Path.Repetition(inner, false);
        }

        if(lookingAt("+")) {
            ++position;

            return new Path.Repetition(inner, true);
        }

        return inner;
    }

    private boolean isAtEnd() {
        return position >= text.length();
    }

    private static boolean isNameCharacter(final char character) {
        return Character.isLetterOrDigit(character) || character == '_' || character == '-';
    }

    private static boolean isNameStart(final char character) {
        return Character.isLetter(character) || character == '_';
    }

    private boolean isStepStart() {
        skipWhitespace();
        if(isAtEnd()) {
            return false;
        }

        final char character = current();
        final boolean startsOperator = character == '.' || character == '*' || character == '[' || character == '(';
        final boolean startsName = character == '\'' || isNameStart(character);

        return startsOperator || startsName;
    }

    private boolean lookingAt(final String token) {
        return text.startsWith(token, position);
    }

    private String name() {
        skipWhitespace();
        if(isAtEnd()) {
            throw error("expected a name");
        }

        if(current() == '\'') {
            return quotedName();
        }

        if(!isNameStart(current())) {
            throw error("expected a name, but found '" + current() + "'");
        }

        final int start = position;
        while(!isAtEnd() && isNameCharacter(current())) {
            ++position;
        }

        return text.substring(start, position);
    }

    /**
     * @param text The text of the path, e.g. {@code ../mover[arpso-mover]}.
     * @return The parsed path.
     * @throws PathException if the text is no valid path.
     */
    public static Path parse(final String text) {
        final PathParser parser = new PathParser(text);
        final Path path = parser.union();

        parser.skipWhitespace();
        if(!parser.isAtEnd()) {
            throw parser.error("unexpected '" + parser.current() + "'");
        }

        return path;
    }

    private Path postfixes(final Path primary) {
        final List<Path> steps = new ArrayList<>(List.of(primary));

        while(true) {
            skipWhitespace();
            if(lookingAt("[")) {
                steps.add(filter());
            } else if(lookingAt("(")) {
                steps.add(group());
            } else {
                break;
            }
        }

        return toPath(steps);
    }

    private Path primary() {
        skipWhitespace();
        if(lookingAt("..")) {
            position += 2;

            return new Path.Parent();
        }

        if(lookingAt(".")) {
            ++position;

            return new Path.Self();
        }

        if(lookingAt("*")) {
            ++position;

            return new Path.AllChildren();
        }

        if(lookingAt("[")) {
            return filter();
        }

        if(lookingAt("(")) {
            return group();
        }

        return new Path.Child(name());
    }

    private String quotedName() {
        final int start = position;
        ++position;

        final StringBuilder name = new StringBuilder();
        while(!isAtEnd() && current() != '\'') {
            name.append(current());
            ++position;
        }

        if(isAtEnd()) {
            position = start;
            throw error("the quoted name is not closed");
        }
        ++position;

        if(name.isEmpty()) {
            position = start;
            throw error("the quoted name is empty");
        }

        return name.toString();
    }

    /**
     * Reads a separator and adds the descendants step of a {@code //}.
     *
     * @return Whether there was a separator.
     */
    private boolean readSeparator(final List<Path> steps) {
        skipWhitespace();
        if(lookingAt(DESCENDANTS)) {
            position += DESCENDANTS.length();
            steps.add(new Path.Descendants());

            return true;
        }

        if(lookingAt(SEPARATOR)) {
            position += SEPARATOR.length();

            return true;
        }

        return false;
    }

    private Path sequence() {
        final List<Path> steps = new ArrayList<>();

        skipWhitespace();
        if(lookingAt(SEPARATOR)) {
            steps.add(new Path.Root());
            readSeparator(steps);

            if(!isStepStart()) {
                return toPath(steps);
            }
        }

        steps.add(step());
        while(readSeparator(steps)) {
            steps.add(step());
        }

        return toPath(steps);
    }

    private void skipWhitespace() {
        while(!isAtEnd() && Character.isWhitespace(current())) {
            ++position;
        }
    }

    private Path step() {
        if(!isStepStart()) {
            if(isAtEnd()) {
                throw error("expected a step");
            }
            throw error("expected a step, but found '" + current() + "'");
        }

        return postfixes(primary());
    }

    private static Path toPath(final List<Path> steps) {
        return steps.size() == 1 ? steps.getFirst() : new Path.Sequence(steps);
    }

    private Path union() {
        final List<Path> alternatives = new ArrayList<>();
        alternatives.add(sequence());

        while(true) {
            skipWhitespace();
            if(!lookingAt("|")) {
                break;
            }
            ++position;
            alternatives.add(sequence());
        }

        return alternatives.size() == 1 ? alternatives.getFirst() : new Path.Union(alternatives);
    }
}
