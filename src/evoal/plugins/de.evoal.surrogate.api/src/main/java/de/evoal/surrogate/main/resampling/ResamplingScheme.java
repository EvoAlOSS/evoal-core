package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;

import java.util.List;

/**
 * Splits the training data into parts, each with rows to learn from and rows to assess
 *   ({@code 'resampling-scheme'} of {@code de.evoal.surrogate.pipeline}).
 */
public interface ResamplingScheme {
    /**
     * @return The name of the scheme, its DL type and the name of its data set, e.g.
     *   {@code k-fold-cross-validation}.
     */
    String name();

    /**
     * Splits the rows into parts.
     *
     * @param rows The training data.
     * @return The parts, in a reproducible order.
     * @throws IllegalArgumentException if the scheme cannot split the rows, e.g. there are
     *   fewer rows than folds.
     */
    List<Part> parts(final @NonNull List<TypedEObject> rows);
}
