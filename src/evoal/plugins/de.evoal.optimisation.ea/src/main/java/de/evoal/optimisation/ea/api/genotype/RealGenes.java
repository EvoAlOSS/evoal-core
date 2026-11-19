package de.evoal.optimisation.ea.api.genotype;

import java.util.Arrays;

/**
 * Real genes with the inclusive boundaries of their features.
 */
public final class RealGenes implements Genes {
    /**
     * The lower boundary of every gene.
     */
    private final double[] lower;

    /**
     * The upper boundary of every gene.
     */
    private final double[] upper;

    /**
     * The gene values.
     */
    private final double[] values;

    /**
     * @param values The gene values; the array is used, not copied.
     * @param lower The lower boundary of every gene; shared by all candidates.
     * @param upper The upper boundary of every gene; shared by all candidates.
     */
    public RealGenes(final double[] values, final double[] lower, final double[] upper) {
        if(values.length != lower.length || values.length != upper.length) {
            throw new IllegalArgumentException("Every gene needs a lower and an upper boundary.");
        }

        this.values = values;
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public RealGenes copy() {
        return new RealGenes(values.clone(), lower, upper);
    }

    @Override
    public boolean equalAt(final Genes other, final int index) {
        requireCompatible(other);

        return Double.compare(values[index], ((RealGenes) other).values[index]) == 0;
    }

    @Override
    public void exchange(final Genes other, final int index) {
        requireCompatible(other);

        final RealGenes genes = (RealGenes) other;
        final double value = values[index];
        values[index] = genes.values[index];
        genes.values[index] = value;
    }

    /**
     * @return The value of the gene.
     */
    public double get(final int index) {
        return values[index];
    }

    /**
     * @return The lower boundary of the gene.
     */
    public double lower(final int index) {
        return lower[index];
    }

    /**
     * Sets the value of the gene; the caller keeps it within the boundaries.
     */
    public void set(final int index, final double value) {
        values[index] = value;
    }

    @Override
    public int size() {
        return values.length;
    }

    /**
     * @return The upper boundary of the gene.
     */
    public double upper(final int index) {
        return upper[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
