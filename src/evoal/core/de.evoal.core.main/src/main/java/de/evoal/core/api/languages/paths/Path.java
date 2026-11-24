package de.evoal.core.api.languages.paths;

import java.util.List;

/**
 * A parsed path expression ({@code path "…"} in the languages), see {@link PathParser} for
 *   the syntax and {@link PathEvaluator} for the meaning of the steps.
 */
public sealed interface Path {
    /**
     * {@code ..}: the containing object.
     */
    record Parent() implements Path {}

    /**
     * {@code /} at the start: the module of the file.
     */
    record Root() implements Path {}

    /**
     * {@code .}: the object itself.
     */
    record Self() implements Path {}

    /**
     * {@code *}: all children.
     */
    record AllChildren() implements Path {}

    /**
     * {@code name}: the child of the given name.
     *
     * @param name The name without quotes.
     */
    record Child(String name) implements Path {}

    /**
     * {@code //}: the object and all objects below it.
     */
    record Descendants() implements Path {}

    /**
     * {@code [T]} or {@code [exactly T]}: keeps the instances of the DL type.
     *
     * @param typeName The name of the DL type.
     * @param exactly Whether only instances of exactly that type are kept, not those of a subtype.
     * @param offset The position of the type name in the text of the path.
     */
    record TypeFilter(String typeName, boolean exactly, int offset) implements Path {}

    /**
     * {@code (p)*} or {@code (p)+}: the path any number of times.
     *
     * @param path The repeated path.
     * @param atLeastOnce Whether the path is applied at least once ({@code +}) or the selection
     *   itself belongs to the result ({@code *}).
     */
    record Repetition(Path path, boolean atLeastOnce) implements Path {}

    /**
     * Steps that are applied one after the other, e.g. {@code ../mover[arpso-mover]}.
     *
     * @param steps The steps in their order.
     */
    record Sequence(List<Path> steps) implements Path {
        public Sequence {
            steps = List.copyOf(steps);
        }
    }

    /**
     * {@code p1 | p2}: the selections of all paths.
     *
     * @param alternatives The paths.
     */
    record Union(List<Path> alternatives) implements Path {
        public Union {
            alternatives = List.copyOf(alternatives);
        }
    }
}
