package de.evoal.surrogate.main.resampling;

import de.evoal.models.core.ecore.TypedEObject;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.List;

/**
 * Rows with the same value of a feature form a block.
 */
public final class GivenBlocks implements BlockDefinition {
    public static final String NAME = "given-blocks";

    private final EStructuralFeature feature;

    /**
     * @param feature The feature whose value names the block of a row.
     */
    public GivenBlocks(final @NonNull EStructuralFeature feature) {
        this.feature = feature;
    }

    @Override
    public String name() {
        return NAME;
    }

    /**
     * @return The feature whose value names the block of a row.
     */
    public EStructuralFeature feature() {
        return feature;
    }

    @Override
    public int[] blocksOf(final @NonNull List<TypedEObject> rows) {
        return BlockDefinition.number(rows.stream()
                                          .map(row -> row.eGet(feature))
                                          .toList());
    }
}
