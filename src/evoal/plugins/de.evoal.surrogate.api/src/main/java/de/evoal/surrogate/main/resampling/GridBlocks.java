package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Divides the range of every input feature on the rows into equal intervals; each non-empty
 *   cell of the grid is a block. The maximum of a feature belongs to its last interval.
 */
@Slf4j
public final class GridBlocks implements BlockDefinition {
    public static final String NAME = "grid-blocks";

    private final int intervals;

    private final List<EStructuralFeature> inputs;

    /**
     * @param intervals The number of intervals per input feature, at least 1.
     * @param inputs The input features that span the grid.
     */
    public GridBlocks(final int intervals, final @NonNull List<EStructuralFeature> inputs) {
        if(intervals < 1) {
            throw new IllegalArgumentException("'" + NAME + "' needs at least 1 interval, but 'intervals' is " + intervals + ".");
        }

        this.intervals = intervals;
        this.inputs = List.copyOf(inputs);
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public int[] blocksOf(final @NonNull List<TypedEObject> rows) {
        final double[][] points = NormalisedInputs.of(rows, inputs);

        final List<List<Integer>> cells = new ArrayList<>(points.length);
        for(final double[] point : points) {
            cells.add(Arrays.stream(point)
                            .mapToInt(v -> Math.min((int) Math.floor(v * intervals), intervals - 1))
                            .boxed()
                            .toList());
        }

        final int[] blocks = BlockDefinition.number(cells);
        final int count = Arrays.stream(blocks).max().orElse(-1) + 1;
        if(count > rows.size() / 2) {
            log.warn("'{}' gives {} blocks for {} rows: most blocks hold one or two rows. Fewer 'intervals' give larger blocks.", NAME, count, rows.size());
        }

        return blocks;
    }
}
