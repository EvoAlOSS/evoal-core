package de.evoal.optimisation.ea.api.genotype;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.models.core.ecore.TypedEObject;

/**
 * Features as {@link BitGenes bits}, most significant bit first: a boolean feature is one
 *   bit, a real or integer feature {@code precision} bits. The bits k of a feature with the
 *   boundaries l and u stand for l + k (u - l) / (2^precision - 1); integers are rounded.
 *   With Gray code, k is stored as its reflected binary code, so neighbouring values differ
 *   in one bit.
 * <p>
 * Encoding rounds a real value to the nearest of the 2^precision values, so a candidate
 *   that was not created by the chromosome, e.g., an initial one, can change slightly when
 *   its genes are decoded.
 */
public final class BinaryChromosome extends Chromosome {
    /**
     * The kind of a feature.
     */
    public enum Kind { BOOLEAN, INTEGER, REAL }

    /**
     * The index of the first bit of every feature, and the number of bits as last entry.
     */
    private final int[] firstBit;

    /**
     * Whether the values are in Gray code.
     */
    private final boolean gray;

    /**
     * The kind of every feature.
     */
    private final Kind[] kinds;

    /**
     * The inclusive boundaries of every real or integer feature.
     */
    private final double[] lower;
    private final double[] upper;

    /**
     * The number of bits of a real or integer feature.
     */
    private final int precision;

    /**
     * @param features The features.
     * @param kinds The kind of every feature.
     * @param lower The inclusive lower boundary of every feature (ignored for booleans).
     * @param upper The inclusive upper boundary of every feature (ignored for booleans).
     * @param precision The number of bits of a real or integer feature, 1 to 52.
     * @param gray Whether real and integer features are in Gray code.
     * @throws IllegalArgumentException if the precision cannot represent every integer of
     *   an integer feature.
     */
    public BinaryChromosome(final List<EStructuralFeature> features, final Kind[] kinds, final double[] lower,
                            final double[] upper, final int precision, final boolean gray) {
        super(features);

        if(precision < 1 || precision > 52) {
            throw new IllegalArgumentException("The precision must be between 1 and 52 bits, but is " + precision + ".");
        }

        this.kinds = kinds.clone();
        this.lower = lower.clone();
        this.upper = upper.clone();
        this.precision = precision;
        this.gray = gray;

        final long levels = (1L << precision) - 1;
        firstBit = new int[features.size() + 1];
        for(int i = 0; i < features.size(); ++i) {
            if(kinds[i] == Kind.INTEGER && upper[i] - lower[i] > levels) {
                throw new IllegalArgumentException("The integer feature '" + features.get(i).getName() + "' has "
                                                   + ((long) (upper[i] - lower[i]) + 1) + " values, but " + precision
                                                   + " bits can represent only " + (levels + 1) + ".");
            }

            firstBit[i + 1] = firstBit[i] + (kinds[i] == Kind.BOOLEAN ? 1 : precision);
        }
    }

    @Override
    public void decode(final Genes genes, final TypedEObject target) {
        final BitGenes bits = (BitGenes) genes;
        final long levels = (1L << precision) - 1;

        for(int i = 0; i < kinds.length; ++i) {
            final EStructuralFeature feature = features().get(i);

            if(kinds[i] == Kind.BOOLEAN) {
                target.eSet(feature, bits.get(firstBit[i]));
                continue;
            }

            long k = 0;
            for(int bit = firstBit[i]; bit < firstBit[i + 1]; ++bit) {
                k = (k << 1) | (bits.get(bit) ? 1 : 0);
            }
            if(gray) {
                k = fromGray(k);
            }

            final double value = lower[i] + k * (upper[i] - lower[i]) / levels;
            if(kinds[i] == Kind.INTEGER) {
                target.eSet(feature, (int) Math.round(value));
            } else {
                target.eSet(feature, Math.min(upper[i], value));
            }
        }
    }

    @Override
    public BitGenes encode(final TypedEObject candidate) {
        final boolean[] bits = new boolean[firstBit[kinds.length]];
        final long levels = (1L << precision) - 1;

        for(int i = 0; i < kinds.length; ++i) {
            final Object value = candidate.eGet(features().get(i));

            if(kinds[i] == Kind.BOOLEAN) {
                bits[firstBit[i]] = (Boolean) value;
                continue;
            }

            final double range = upper[i] - lower[i];
            final double ratio = range == 0.0 ? 0.0 : (((Number) value).doubleValue() - lower[i]) / range;
            long k = Math.max(0, Math.min(levels, Math.round(ratio * levels)));
            if(gray) {
                k = k ^ (k >>> 1);
            }

            for(int bit = firstBit[i + 1] - 1; bit >= firstBit[i]; --bit) {
                bits[bit] = (k & 1) == 1;
                k >>>= 1;
            }
        }

        return new BitGenes(bits);
    }

    @Override
    public int featureOfGene(final int gene) {
        for(int i = 0; i < kinds.length; ++i) {
            if(gene < firstBit[i + 1]) {
                return i;
            }
        }

        throw new IndexOutOfBoundsException("The chromosome has " + firstBit[kinds.length] + " bits, not " + (gene + 1) + ".");
    }

    private static long fromGray(final long code) {
        long value = code;
        for(long shifted = code >>> 1; shifted != 0; shifted >>>= 1) {
            value ^= shifted;
        }

        return value;
    }

    @Override
    public void handleBoundaries(final Genes genes, final BoundaryHandling handling) {
        // every bit pattern stands for a value within the boundaries
    }

    @Override
    public Representation representation() {
        return gray ? Representation.GRAY : Representation.BIT;
    }
}
