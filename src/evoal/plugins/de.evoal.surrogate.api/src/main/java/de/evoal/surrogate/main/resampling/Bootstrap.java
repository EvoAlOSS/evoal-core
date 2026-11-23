package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * Bootstrap (Efron 1979): each repetition draws n of the n rows with replacement to learn
 *   from and holds out the rows that were not drawn (out of bag). A repetition without
 *   out-of-bag rows is skipped with a warning.
 */
@Slf4j
public final class Bootstrap implements ResamplingScheme {
    public static final String NAME = "bootstrap";

    private final int repetitions;

    private final RandomGenerator random;

    /**
     * @param repetitions The number of repetitions, at least 1.
     * @param random The stream that draws the rows.
     */
    public Bootstrap(final int repetitions, final @NonNull RandomGenerator random) {
        if(repetitions < 1) {
            throw new IllegalArgumentException("'" + NAME + "' needs at least 1 repetition, but 'repetitions' is " + repetitions + ".");
        }

        this.repetitions = repetitions;
        this.random = random;
    }

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

        final List<Part> parts = new ArrayList<>(repetitions);
        for(int repetition = 0; repetition < repetitions; ++repetition) {
            final int[] drawn = new int[n];
            final boolean[] inBag = new boolean[n];
            for(int i = 0; i < n; ++i) {
                drawn[i] = random.nextInt(n);
                inBag[drawn[i]] = true;
            }

            final int[] outOfBag = IntStream.range(0, n)
                                            .filter(i -> !inBag[i])
                                            .toArray();
            if(outOfBag.length == 0) {
                log.warn("Skipping repetition {} of '{}': every row was drawn, so no row is out of bag.", repetition + 1, NAME);
                continue;
            }

            parts.add(new Part(drawn, outOfBag));
        }

        return parts;
    }
}
