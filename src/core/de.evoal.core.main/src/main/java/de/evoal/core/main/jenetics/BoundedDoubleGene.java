package de.evoal.core.main.jenetics;

import io.jenetics.DoubleGene;
import io.jenetics.NumericGene;
import io.jenetics.util.*;

import java.io.*;
import java.util.random.RandomGenerator;

import static io.jenetics.internal.util.Hashes.hash;

public class BoundedDoubleGene implements
        NumericGene<Double, BoundedDoubleGene>,
        Mean<BoundedDoubleGene>,
        Comparable<BoundedDoubleGene>,
        Serializable
{

    private static final long serialVersionUID = 2L;

    private final double _allele;
    private final double _min;
    private final double _max;

    /**
     * Create a new random {@code DoubleGene} with the given value and the
     * given range. If the {@code value} isn't within the interval [min, max),
     * no exception is thrown. In this case the method
     * {@link DoubleGene#isValid()} returns {@code false}.
     *
     * @param allele the value of the gene.
     * @param min the minimal valid value of this gene (inclusively).
     * @param max the maximal valid value of this gene (exclusively).
     */
    private BoundedDoubleGene(final double allele, final double min, final double max) {
        _allele = BoundedOperations.boundValue(allele, min, max);
        _min = min;
        _max = max;
    }

    @Override
    public Double allele() {
        return _allele;
    }

    @Override
    public Double min() {
        return _min;
    }

    @Override
    public Double max() {
        return _max;
    }

    /**
     * Return the range of {@code this} gene.
     *
     * @since 4.4
     *
     * @return the range of {@code this} gene
     */
    public DoubleRange range() {
        return DoubleRange.of(_min, _max);
    }

    @Override
    public byte byteValue() {
        return (byte) _allele;
    }

    @Override
    public short shortValue() {
        return (short) _allele;
    }

    @Override
    public int intValue() {
        return (int) _allele;
    }

    @Override
    public long longValue() {
        return (long) _allele;
    }

    @Override
    public float floatValue() {
        return (float) _allele;
    }

    @Override
    public double doubleValue() {
        return _allele;
    }

    @Override
    public boolean isValid() {
        return
                Double.isFinite(_allele) &&
                Double.isFinite(_min) &&
                Double.isFinite(_max) &&
                BoundedOperations.isValid(_allele, _min, _max);
    }

    @Override
    public int compareTo(final BoundedDoubleGene other) {
        return Double.compare(_allele, other._allele);
    }

    @Override
    public BoundedDoubleGene mean(final BoundedDoubleGene that) {
        return of(_allele + (that._allele - _allele)/2.0, _min, _max);
    }

    /**
     * Create a new gene from the given {@code value} and the gene context.
     *
     * @since 5.0
     * @param allele the value of the new gene.
     * @return a new gene with the given value.
     */
    public DoubleGene newInstance(final double allele) {
        return DoubleGene.of(allele, _min, _max);
    }

    @Override
    public BoundedDoubleGene newInstance(final Double allele) {
        return of(allele, _min, _max);
    }

    @Override
    public BoundedDoubleGene newInstance(final Number allele) {
        return of(allele.doubleValue(), _min, _max);
    }

    @Override
    public BoundedDoubleGene newInstance() {
        return of(BoundedOperations.random(_min, _max), _min, _max);
    }

    @Override
    public int hashCode() {
        return hash(_allele, hash(_min, hash(_max)));
    }

    @Override
    public boolean equals(final Object obj) {
        return obj == this ||
                obj instanceof BoundedDoubleGene &&
                        Double.compare(((BoundedDoubleGene)obj)._allele, _allele) == 0 &&
                        Double.compare(((BoundedDoubleGene)obj)._min, _min) == 0 &&
                        Double.compare(((BoundedDoubleGene)obj)._max, _max) == 0;
    }

    @Override
    public String toString() {
        return String.format("[%s]", _allele);
    }


    /* *************************************************************************
     * Static factory methods.
     * ************************************************************************/

    /**
     * Create a new random {@code DoubleGene} with the given value and the
     * given range. If the {@code value} isn't within the interval [min, max),
     * no exception is thrown. In this case the method
     * {@link DoubleGene#isValid()} returns {@code false}.
     *
     * @param allele the value of the gene.
     * @param min the minimal valid value of this gene (inclusively).
     * @param max the maximal valid value of this gene (exclusively).
     * @return a new {@code DoubleGene} with the given parameter
     */
    public static BoundedDoubleGene of(
            final double allele,
            final double min,
            final double max
    ) {
        return new BoundedDoubleGene(allele, min, max);
    }

    /**
     * Create a new random {@code DoubleGene} with the given value and the
     * given range. If the {@code value} isn't within the interval [min, max),
     * no exception is thrown. In this case the method
     * {@link DoubleGene#isValid()} returns {@code false}.
     *
     * @since 3.2
     *
     * @param allele the value of the gene.
     * @param range the double range to use
     * @return a new random {@code DoubleGene}
     * @throws NullPointerException if the given {@code range} is {@code null}.
     */
    public static BoundedDoubleGene of(final double allele, final DoubleRange range) {
        return of(allele, range.min(), range.max());
    }

    /**
     * Create a new random {@code DoubleGene}. It is guaranteed that the value
     * of the {@code DoubleGene} lies in the interval [min, max).
     *
     * @param min the minimal valid value of this gene (inclusively).
     * @param max the maximal valid value of this gene (exclusively).
     * @return a new {@code DoubleGene} with the given parameter
     */
    public static BoundedDoubleGene of(final double min, final double max) {
        return of(BoundedOperations.random(min, max), min, max);
    }

    /**
     * Create a new random {@code DoubleGene}. It is guaranteed that the value
     * of the {@code DoubleGene} lies in the interval [min, max).
     *
     * @since 3.2
     *
     * @param range the double range to use
     * @return a new {@code DoubleGene} with the given parameter
     * @throws NullPointerException if the given {@code range} is {@code null}.
     */
    public static BoundedDoubleGene of(final DoubleRange range) {
        return of(BoundedOperations.random(range.min(), range.max()), range);
    }
    static ISeq<BoundedDoubleGene> seq(
            final double min,
            final double max,
            final IntRange lengthRange
    ) {
        final RandomGenerator random = RandomRegistry.random();
        final int length = random.nextInt(lengthRange.min(), lengthRange.max());

        return MSeq.<BoundedDoubleGene>ofLength(length)
                .fill(() -> new BoundedDoubleGene(BoundedOperations.random(min, max), min, max))
                .toISeq();
    }
}
