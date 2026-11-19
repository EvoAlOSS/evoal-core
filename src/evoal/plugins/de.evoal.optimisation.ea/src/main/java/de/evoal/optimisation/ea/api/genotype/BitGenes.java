package de.evoal.optimisation.ea.api.genotype;

/**
 * Bits.
 */
public final class BitGenes implements Genes {
    /**
     * The bits.
     */
    private final boolean[] bits;

    /**
     * @param bits The bits; the array is used, not copied.
     */
    public BitGenes(final boolean[] bits) {
        this.bits = bits;
    }

    @Override
    public BitGenes copy() {
        return new BitGenes(bits.clone());
    }

    @Override
    public boolean equalAt(final Genes other, final int index) {
        requireCompatible(other);

        return bits[index] == ((BitGenes) other).bits[index];
    }

    @Override
    public void exchange(final Genes other, final int index) {
        requireCompatible(other);

        final BitGenes genes = (BitGenes) other;
        final boolean bit = bits[index];
        bits[index] = genes.bits[index];
        genes.bits[index] = bit;
    }

    /**
     * Inverts the bit.
     */
    public void flip(final int index) {
        bits[index] = !bits[index];
    }

    /**
     * @return The bit.
     */
    public boolean get(final int index) {
        return bits[index];
    }

    /**
     * Sets the bit.
     */
    public void set(final int index, final boolean bit) {
        bits[index] = bit;
    }

    @Override
    public int size() {
        return bits.length;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder(bits.length);
        for(final boolean bit : bits) {
            result.append(bit ? '1' : '0');
        }

        return result.toString();
    }
}
