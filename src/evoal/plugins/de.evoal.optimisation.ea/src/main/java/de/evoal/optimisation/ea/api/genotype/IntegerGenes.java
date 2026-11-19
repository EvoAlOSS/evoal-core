package de.evoal.optimisation.ea.api.genotype;

import java.util.Arrays;

/**
 * Integer genes with the inclusive boundaries of their features.
 */
public final class IntegerGenes implements Genes {
    /**
     * The lower boundary of every gene.
     */
    private final long[] lower;

    /**
     * The upper boundary of every gene.
     */
    private final long[] upper;

    /**
     * The gene values.
     */
    private final long[] values;

    /**
     * @param values The gene values; the array is used, not copied.
     * @param lower The lower boundary of every gene; shared by all candidates.
     * @param upper The upper boundary of every gene; shared by all candidates.
     */
    public IntegerGenes(final long[] values, final long[] lower, final long[] upper) {
        if(values.length != lower.length || values.length != upper.length) {
            throw new IllegalArgumentException("Every gene needs a lower and an upper boundary.");
        }

        this.values = values;
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public IntegerGenes copy() {
        return new IntegerGenes(values.clone(), lower, upper);
    }

    @Override
    public boolean equalAt(final Genes other, final int index) {
        requireCompatible(other);

        return values[index] == ((IntegerGenes) other).values[index];
    }

    @Override
    public void exchange(final Genes other, final int index) {
        requireCompatible(other);

        final IntegerGenes genes = (IntegerGenes) other;
        final long value = values[index];
        values[index] = genes.values[index];
        genes.values[index] = value;
    }

    /**
     * @return The value of the gene.
     */
    public long get(final int index) {
        return values[index];
    }

    /**
     * @return The lower boundary of the gene.
     */
    public long lower(final int index) {
        return lower[index];
    }

    /**
     * Sets the value of the gene; the caller keeps it within the boundaries.
     */
    public void set(final int index, final long value) {
        values[index] = value;
    }

    @Override
    public int size() {
        return values.length;
    }

    /**
     * @return The upper boundary of the gene.
     */
    public long upper(final int index) {
        return upper[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
