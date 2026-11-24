package de.evoal.core.api.languages.paths;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Parsing the text of path expressions into {@link Path}s, and the positions of syntax errors.
 */
public class PathParserTest {
    private static void assertError(final String text, final int offset, final String problem) {
        final PathException e = Assertions.assertThrows(PathException.class, () -> PathParser.parse(text));

        Assertions.assertEquals(offset, e.getOffset(), e.getMessage());
        Assertions.assertTrue(e.getMessage().contains(problem), e.getMessage());
    }

    @Test
    public void aGroupAfterAStepIsRepeated() {
        final Path expected = new Path.Sequence(List.of(
                new Path.Root(),
                new Path.Child("algorithm"),
                new Path.Sequence(List.of(
                        new Path.Child("stopping-criteria"),
                        new Path.Repetition(new Path.Sequence(List.of(new Path.TypeFilter("any-of", false, 30),
                                                                      new Path.Child("criteria"))), false),
                        new Path.TypeFilter("iteration-count", false, 49)))));

        Assertions.assertEquals(expected, PathParser.parse("/algorithm/stopping-criteria([any-of]/criteria)*[iteration-count]"));
    }

    @Test
    public void aRepetitionAtLeastOnceIsParsed() {
        final Path expected = new Path.Repetition(new Path.Child("criteria"), true);

        Assertions.assertEquals(expected, PathParser.parse("(criteria)+"));
    }

    @Test
    public void aTrailingSeparatorIsRejected() {
        assertError("../mover/", 9, "expected a step");
    }

    @Test
    public void anUnclosedFilterIsRejected() {
        assertError("..[mover", 8, "expected ']'");
    }

    @Test
    public void anUnclosedQuoteIsRejected() {
        assertError("'maximum", 0, "the quoted name is not closed");
    }

    @Test
    public void anUnexpectedCharacterIsRejected() {
        assertError("mover)", 5, "unexpected ')'");
    }

    @Test
    public void descendantsAreAStepBetweenTheOthers() {
        final Path expected = new Path.Sequence(List.of(new Path.Root(), new Path.Descendants(),
                                                        new Path.TypeFilter("count-criterion", false, 3)));

        Assertions.assertEquals(expected, PathParser.parse("//[count-criterion]"));
    }

    @Test
    public void exactlyKeepsOnlyTheType() {
        final Path expected = new Path.Sequence(List.of(new Path.Parent(), new Path.TypeFilter("basic-mover", true, 12)));

        Assertions.assertEquals(expected, PathParser.parse("..[exactly  basic-mover]"));
    }

    @Test
    public void quotedNamesMeanTheSameAsUnquotedOnes() {
        Assertions.assertEquals(PathParser.parse("../maximum-iterations"), PathParser.parse("../'maximum-iterations'"));
    }

    @Test
    public void theRootAloneIsAPath() {
        Assertions.assertEquals(new Path.Root(), PathParser.parse("/"));
    }

    @Test
    public void typeNamesInQuotesMayBeKeywords() {
        final Path expected = new Path.TypeFilter("exactly", false, 1);

        Assertions.assertEquals(expected, PathParser.parse("['exactly']"));
    }

    @Test
    public void unionsSeparateTheirAlternatives() {
        final Path expected = new Path.Union(List.of(
                new Path.Sequence(List.of(new Path.Parent(), new Path.TypeFilter("bit-chromosome", false, 3))),
                new Path.Sequence(List.of(new Path.Parent(), new Path.TypeFilter("gray-chromosome", false, 24)))));

        Assertions.assertEquals(expected, PathParser.parse("..[bit-chromosome] | ..[gray-chromosome]"));
    }

    @Test
    public void whitespaceBetweenTokensIsIgnored() {
        Assertions.assertEquals(PathParser.parse("../mover"), PathParser.parse(" .. / mover "));
    }
}
