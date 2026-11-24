package de.evoal.core.api.languages.paths;

import lombok.Getter;

/**
 * A path expression is invalid, e.g. a syntax error or an unknown type name. The message names
 *   the path and the position of the problem in it.
 */
@Getter
public class PathException extends IllegalArgumentException {
    /**
     * The position of the problem in the text of the path, starting at 0.
     */
    private final int offset;

    /**
     * The text of the path.
     */
    private final String path;

    /**
     * @param path The text of the path.
     * @param offset The position of the problem in the text, starting at 0.
     * @param problem What is wrong, e.g. "expected ']'".
     */
    public PathException(final String path, final int offset, final String problem) {
        super("Invalid path \"" + path + "\" at position " + (offset + 1) + ": " + problem + ".");
        this.path = path;
        this.offset = offset;
    }
}
