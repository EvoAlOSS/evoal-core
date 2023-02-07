package de.evoal.core.main.jenetics;

import io.jenetics.*;
import io.jenetics.util.DoubleRange;
import io.jenetics.util.ISeq;
import io.jenetics.util.IntRange;

import java.io.*;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

public class BoundedDoubleChromosome
    extends
        AbstractBoundedChromosome<Double, BoundedDoubleGene>
    implements
        NumericChromosome<Double, BoundedDoubleGene>,
        Serializable
{
    private static final long serialVersionUID = 3L;

    /**
     * Create a new chromosome from the given {@code genes} and the allowed
     * length range of the chromosome.
     *
     * @since 4.0
     *
     * @param genes the genes that form the chromosome.
     * @param lengthRange the allowed length range of the chromosome
     * @throws NullPointerException if one of the arguments is {@code null}.
     * @throws IllegalArgumentException if the length of the gene sequence is
     *         empty, doesn't match with the allowed length range, the minimum
     *         or maximum of the range is smaller or equal zero or the given
     *         range size is zero.
     */
    protected BoundedDoubleChromosome(
            final ISeq<BoundedDoubleGene> genes,
            final IntRange lengthRange
    ) {
        super(genes, lengthRange);
    }

    @Override
    public BoundedDoubleChromosome newInstance(final ISeq<BoundedDoubleGene> genes) {
        return new BoundedDoubleChromosome(genes, lengthRange());
    }

    @Override
    public BoundedDoubleChromosome newInstance() {
        return of(_min, _max, lengthRange());
    }

    /**
     * Maps the gene alleles of this chromosome, given as {@code double[]} array,
     * by applying the given mapper function {@code f}. The mapped gene values
     * are then wrapped into a newly created chromosome.
     *
     * <pre>{@code
     * final DoubleChromosome chromosome = ...;
     * final DoubleChromosome normalized = chromosome.map(Main::normalize);
     *
     * static double[] normalize(final double[] values) {
     *     final double sum = sum(values);
     *     for (int i = 0; i < values.length; ++i) {
     *         values[i] /= sum;
     *     }
     *     return values;
     * }
     * }</pre>
     *
     * @since 6.1
     *
     * @param f the mapper function
     * @return a newly created chromosome with the mapped gene values
     * @throws NullPointerException if the mapper function is {@code null}.
     * @throws IllegalArgumentException if the length of the mapped
     *         {@code double[]} array is empty or doesn't match with the allowed
     *         length range
     */
    public BoundedDoubleChromosome map(final Function<? super double[], double[]> f) {
        requireNonNull(f);

        final var range = DoubleRange.of(_min, _max);
        final var genes = DoubleStream.of(f.apply(toArray()))
                .mapToObj(v -> BoundedDoubleGene.of(v, range))
                .collect(ISeq.toISeq());

        return newInstance(genes);
    }

    /**
     * Returns a sequential stream of the alleles with this chromosome as its
     * source.
     *
     * @since 4.3
     *
     * @return a sequential stream of alleles
     */
    public DoubleStream doubleStream() {
        return IntStream.range(0, length()).mapToDouble(this::doubleValue);
    }

    /**
     * Returns an double array containing all of the elements in this chromosome
     * in proper sequence.  If the chromosome fits in the specified array, it is
     * returned therein. Otherwise, a new array is allocated with the length of
     * this chromosome.
     *
     * @since 3.0
     *
     * @param array the array into which the elements of this chromosomes are to
     *        be stored, if it is big enough; otherwise, a new array is
     *        allocated for this purpose.
     * @return an array containing the elements of this chromosome
     * @throws NullPointerException if the given {@code array} is {@code null}
     */
    public double[] toArray(final double[] array) {
        final double[] a = array.length >= length()
                ? array
                : new double[length()];

        for (int i = length(); --i >= 0;) {
            a[i] = doubleValue(i);
        }

        return a;
    }

    /**
     * Returns an double array containing all of the elements in this chromosome
     * in proper sequence.
     *
     * @since 3.0
     *
     * @return an array containing the elements of this chromosome
     */
    public double[] toArray() {
        return toArray(new double[length()]);
    }


    /* *************************************************************************
     * Static factory methods.
     * ************************************************************************/

    /**
     * Create a new {@code DoubleChromosome} with the given genes.
     *
     * @param genes the genes of the chromosome.
     * @return a new chromosome with the given genes.
     * @throws IllegalArgumentException if the length of the genes array is
     *         empty or the given {@code genes} doesn't have the same range.
     * @throws NullPointerException if the given {@code genes} array is
     *         {@code null}
     */
    public static BoundedDoubleChromosome of(final BoundedDoubleGene... genes) {
        checkGeneRange(Stream.of(genes).map(BoundedDoubleGene::range));
        return new BoundedDoubleChromosome(ISeq.of(genes), IntRange.of(genes.length));
    }

    /**
     * Create a new {@code DoubleChromosome} with the given genes.
     *
     * @since 4.3
     *
     * @param genes the genes of the chromosome.
     * @return a new chromosome with the given genes.
     * @throws NullPointerException if the given {@code genes} are {@code null}
     * @throws IllegalArgumentException if the of the genes iterable is empty or
     *         the given {@code genes} doesn't have the same range.
     */
    public static BoundedDoubleChromosome of(final Iterable<BoundedDoubleGene> genes) {
        final ISeq<BoundedDoubleGene> values = ISeq.of(genes);
        checkGeneRange(values.stream().map(BoundedDoubleGene::range));
        return new BoundedDoubleChromosome(values, IntRange.of(values.length()));
    }

    /**
     * Create a new random chromosome.
     *
     * @since 4.0
     *
     * @param min the min value of the {@link DoubleGene}s (inclusively).
     * @param max the max value of the {@link DoubleGene}s (exclusively).
     * @param lengthRange the allowed length range of the chromosome.
     * @return a new {@code DoubleChromosome} with the given parameter
     * @throws IllegalArgumentException if the length of the gene sequence is
     *         empty, doesn't match with the allowed length range, the minimum
     *         or maximum of the range is smaller or equal zero or the given
     *         range size is zero.
     * @throws NullPointerException if the given {@code lengthRange} is
     *         {@code null}
     */
    public static BoundedDoubleChromosome of(
            final double min,
            final double max,
            final IntRange lengthRange
    ) {
        final ISeq<BoundedDoubleGene> genes = BoundedDoubleGene.seq(min, max, lengthRange);
        return new BoundedDoubleChromosome(genes, lengthRange);
    }

    /**
     * Create a new random {@code DoubleChromosome}.
     *
     * @param min the min value of the {@link DoubleGene}s (inclusively).
     * @param max the max value of the {@link DoubleGene}s (exclusively).
     * @param length the length of the chromosome.
     * @return a new {@code DoubleChromosome} with the given parameter
     * @throws IllegalArgumentException if the {@code length} is smaller than
     *         one.
     */
    public static BoundedDoubleChromosome of(
            final double min,
            final double max,
            final int length
    ) {
        return of(min, max, IntRange.of(length));
    }

    /**
     * Create a new random chromosome.
     *
     * @since 4.0
     *
     * @param range the integer range of the chromosome.
     * @param lengthRange the allowed length range of the chromosome.
     * @return a new {@code DoubleChromosome} with the given parameter
     * @throws IllegalArgumentException if the length of the gene sequence is
     *         empty, doesn't match with the allowed length range, the minimum
     *         or maximum of the range is smaller or equal zero or the given
     *         range size is zero.
     * @throws NullPointerException if the given {@code lengthRange} is
     *         {@code null}
     */
    public static BoundedDoubleChromosome of(
            final DoubleRange range,
            final IntRange lengthRange
    ) {
        return of(range.min(), range.max(), lengthRange);
    }

    /**
     * Create a new random {@code DoubleChromosome}.
     *
     * @since 3.2
     *
     * @param range the integer range of the chromosome.
     * @param length the length of the chromosome.
     * @return a new random {@code DoubleChromosome}
     * @throws NullPointerException if the given {@code range} is {@code null}
     * @throws IllegalArgumentException if the {@code length} is smaller than
     *         one.
     */
    public static BoundedDoubleChromosome of(final DoubleRange range, final int length) {
        return of(range.min(), range.max(), length);
    }

    /**
     * Create a new random {@code DoubleChromosome} of length one.
     *
     * @param min the minimal value of this chromosome (inclusively).
     * @param max the maximal value of this chromosome (exclusively).
     * @return a new {@code DoubleChromosome} with the given parameter
     */
    public static BoundedDoubleChromosome of(final double min, final double max) {
        return of(min, max, 1);
    }

    /**
     * Create a new random {@code DoubleChromosome} of length one.
     *
     * @since 3.2
     *
     * @param range the double range of the chromosome.
     * @return a new random {@code DoubleChromosome} of length one
     * @throws NullPointerException if the given {@code range} is {@code null}
     */
    public static BoundedDoubleChromosome of(final DoubleRange range) {
        return of(range.min(), range.max());
    }
}
