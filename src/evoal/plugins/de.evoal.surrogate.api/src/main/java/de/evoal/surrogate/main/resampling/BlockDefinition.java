package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;

import java.util.List;

/**
 * Divides the rows of a block cross-validation into blocks ({@code 'block-definition'} of
 *   {@code de.evoal.surrogate.pipeline}).
 */
public interface BlockDefinition {
    /**
     * @return The name of the definition, its DL type, e.g. {@code k-means-blocks}.
     */
    String name();

    /**
     * @param rows The training data.
     * @return The block of each row, numbered 0, 1, ... without gaps in the order of their
     *   first row.
     */
    int[] blocksOf(final @NonNull List<TypedEObject> rows);

    /**
     * Numbers the keys 0, 1, ... in the order of their first occurrence.
     *
     * @param keys The key of each row.
     * @return The number of each row's key.
     */
    static int[] number(final List<?> keys) {
        final java.util.Map<Object, Integer> numbers = new java.util.LinkedHashMap<>();
        final int[] result = new int[keys.size()];
        for(int i = 0; i < keys.size(); ++i) {
            result[i] = numbers.computeIfAbsent(keys.get(i), key -> numbers.size());
        }

        return result;
    }
}
