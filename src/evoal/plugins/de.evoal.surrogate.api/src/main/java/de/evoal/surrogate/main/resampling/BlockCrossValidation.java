package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Block cross-validation (Roberts et al. 2017): the rows are divided into blocks, and each
 *   block is held out once.
 */
@Slf4j
public final class BlockCrossValidation implements ResamplingScheme {
    public static final String NAME = "block-cross-validation";

    private final BlockDefinition blocks;

    /**
     * @param blocks How the rows are divided into blocks.
     */
    public BlockCrossValidation(final @NonNull BlockDefinition blocks) {
        this.blocks = blocks;
    }

    @Override
    public String name() {
        return NAME;
    }

    /**
     * @return How the rows are divided into blocks.
     */
    public BlockDefinition blocks() {
        return blocks;
    }

    @Override
    public List<Part> parts(final @NonNull List<TypedEObject> rows) {
        final int[] blockOf = blocks.blocksOf(rows);
        final int count = Arrays.stream(blockOf).max().orElse(-1) + 1;
        if(count < 2) {
            throw new IllegalArgumentException("'" + NAME + "' needs at least 2 blocks, but '" + blocks.name() + "' gives " + count + ".");
        }

        log.info("'{}' divides {} rows into {} blocks.", blocks.name(), rows.size(), count);

        final List<Part> parts = new ArrayList<>(count);
        for(int block = 0; block < count; ++block) {
            final int b = block;
            final int[] heldOut = IntStream.range(0, rows.size()).filter(i -> blockOf[i] == b).toArray();
            final int[] training = IntStream.range(0, rows.size()).filter(i -> blockOf[i] != b).toArray();
            parts.add(new Part(training, heldOut));
        }

        return parts;
    }
}
