package de.evoal.optimisation.ea.main.alterer.internal;

import de.evoal.optimisation.api.correlations.Correlation;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import io.jenetics.*;
import io.jenetics.util.BaseSeq;
import io.jenetics.util.MSeq;
import io.jenetics.util.RandomRegistry;

import java.util.function.BinaryOperator;
import java.util.random.RandomGenerator;

import static java.lang.Math.min;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public abstract class CorrelationCombineAlterer<
        G extends NumericGene<?, G>,
        C extends Comparable<? super C>
        >
        extends CorrelationRecombinator<G, C>
{

    private final BinaryOperator<G> _combiner;
    private final Correlations correlations;

    private final CustomCodec<G> codec;

    /**
     * Create a new combiner alterer with the given arguments.
     *
     * @param combiner the function used for combining two genes
     * @param probability The recombination probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *         valid range of {@code [0, 1]}
     * @throws NullPointerException if the given {@code combiner} is {@code null}
     */
    public CorrelationCombineAlterer(
            final BinaryOperator<G> combiner,
            final double probability,
            final Correlations correlations,
            final CustomCodec<G> codec
    ) {
        super(probability, 2);
        _combiner = requireNonNull(combiner);
        
        this.correlations = correlations;
        this.codec = codec;
    }


    /**
     * Return the combiner function, used by {@code this} alterer.
     *
     * @return the combiner function, used by {@code this} alterer
     */
    public BinaryOperator<G> combiner() {
        return _combiner;
    }

    @Override
    protected int recombine(
            final MSeq<Phenotype<G, C>> population,
            final int[] individuals,
            final long generation
    ) {
        final RandomGenerator random = RandomRegistry.random();

        final Phenotype<G, C> pt1 = population.get(individuals[0]);
        final Phenotype<G, C> pt2 = population.get(individuals[1]);
        final Genotype<G> gt1 = pt1.genotype();
        final Genotype<G> gt2 = pt2.genotype();

        // choosing a random Chromosome index for crossover.
        final int randomIndex = random.nextInt(min(gt1.length(), gt2.length()));

        // track the correlations to the first index to handle
        final int rootIndex = correlations.findCorrelationRoot(codec.decode(gt1), randomIndex);

        return recombine(population, individuals[0], generation, gt1, gt2, rootIndex);
    }

    private int recombine(final MSeq<Phenotype<G, C>> population, final int individual, final long generation, final Genotype<G> gt1, final Genotype<G> gt2, final int index) {
        final MSeq<Chromosome<G>> c1 = MSeq.of(gt1);
        final Chromosome<G> chromosome1 = c1.get(index);
        final double chromosomeValue1 = getValue(gt1, index);

        // Calculate the mean value of the gene array.
        final MSeq<G> mean = combine(chromosome1, gt2.get(index), _combiner);

        c1.set(index, c1.get(index).newInstance(mean.toISeq()));
        population.set(individual, Phenotype.of(Genotype.of(c1), generation));

        int result = 1;
        for(final Correlation correlation : correlations.find(codec.decode(gt1), index)) {
            final int index2 = correlation.getChromosomeTwo();
            final double chromosomeValue2 = getValue(gt1, index2);

            if(!correlation.matchesTarget(index2, chromosomeValue2)) {
                continue;
            }

            result += recombine(population, individual, generation, gt1, gt2, index2);
        }

        return result;
    }

    private static <G extends Gene<?, G>>
    MSeq<G> combine(
            final BaseSeq<G> a,
            final BaseSeq<G> b,
            final BinaryOperator<G> combiner
    ) {
        final MSeq<G> result = MSeq.ofLength(a.length());
        for (int i = a.length(); --i >= 0;) {
            result.set(i, combiner.apply(a.get(i), b.get(i)));
        }
        return result;
    }

    private double getValue(final Genotype<G> genotype, final int index) {
        return genotype.get(index).gene().doubleValue();
    }

    @Override
    public String toString() {
        return format("%s[p=%f]", getClass().getSimpleName(), _probability);
    }
}
