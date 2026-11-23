package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Leave-one-out cross-validation (Stone 1974): each row is held out once, in the order of the
 *   training data.
 */
public final class LeaveOneOutCrossValidation implements ResamplingScheme {
    public static final String NAME = "leave-one-out-cross-validation";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public List<Part> parts(final @NonNull List<TypedEObject> rows) {
        final int n = rows.size();
        if(n < 2) {
            throw new IllegalArgumentException("'" + NAME + "' needs at least 2 rows, but the training data has " + n + ".");
        }

        return KFoldCrossValidation.folds(IntStream.range(0, n).toArray(), n);
    }
}
