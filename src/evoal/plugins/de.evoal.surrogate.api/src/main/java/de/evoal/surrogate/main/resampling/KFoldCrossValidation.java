package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * k-fold cross-validation (Stone 1974): shuffles the row indices and splits them into k folds
 *   whose sizes differ by at most one; each fold is held out once.
 */
public final class KFoldCrossValidation implements ResamplingScheme {
    public static final String NAME = "k-fold-cross-validation";

    private final int k;

    private final RandomGenerator random;

    /**
     * @param k The number of folds, at least 2.
     * @param random The stream that shuffles the rows.
     */
    public KFoldCrossValidation(final int k, final @NonNull RandomGenerator random) {
        if(k < 2) {
            throw new IllegalArgumentException("'" + NAME + "' needs at least 2 folds, but 'k' is " + k + ".");
        }

        this.k = k;
        this.random = random;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public List<Part> parts(final @NonNull List<TypedEObject> rows) {
        final int n = rows.size();
        if(k > n) {
            throw new IllegalArgumentException("'" + NAME + "' with 'k' = " + k + " needs at least " + k + " rows, but the training data has " + n + ".");
        }

        final int[] order = shuffled(n, random);

        return folds(order, k);
    }

    /**
     * @return The indices 0, ..., n - 1 in random order (Fisher-Yates).
     */
    static int[] shuffled(final int n, final RandomGenerator random) {
        final int[] order = IntStream.range(0, n).toArray();
        for(int i = n - 1; i > 0; --i) {
            final int j = random.nextInt(i + 1);
            final int swap = order[i];
            order[i] = order[j];
            order[j] = swap;
        }

        return order;
    }

    /**
     * Splits the ordered indices into k consecutive folds; the first n mod k folds have one
     *   index more.
     */
    static List<Part> folds(final int[] order, final int k) {
        final int n = order.length;
        final List<Part> parts = new ArrayList<>(k);

        int start = 0;
        for(int fold = 0; fold < k; ++fold) {
            final int size = n / k + (fold < n % k ? 1 : 0);
            final int end = start + size;

            final int[] heldOut = new int[size];
            final int[] training = new int[n - size];
            int t = 0;
            for(int i = 0; i < n; ++i) {
                if(i >= start && i < end) {
                    heldOut[i - start] = order[i];
                } else {
                    training[t++] = order[i];
                }
            }

            parts.add(new Part(training, heldOut));
            start = end;
        }

        return parts;
    }
}
